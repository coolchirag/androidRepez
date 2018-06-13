package javax.mail.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.mail.internet.SharedInputStream;

public class SharedFileInputStream extends BufferedInputStream implements SharedInputStream {
    private static int defaultBufferSize = 2048;
    protected long bufpos;
    protected int bufsize;
    protected long datalen;
    protected RandomAccessFile in;
    private boolean master;
    private SharedFile sf;
    protected long start;

    class SharedFile {
        private int cnt;
        private RandomAccessFile in;

        SharedFile(File file) {
            this.in = new RandomAccessFile(file, "r");
        }

        SharedFile(String str) {
            this.in = new RandomAccessFile(str, "r");
        }

        public synchronized void close() {
            if (this.cnt > 0) {
                int i = this.cnt - 1;
                this.cnt = i;
                if (i <= 0) {
                    this.in.close();
                }
            }
        }

        protected void finalize() {
            super.finalize();
            this.in.close();
        }

        public synchronized void forceClose() {
            if (this.cnt > 0) {
                this.cnt = 0;
                this.in.close();
            } else {
                try {
                    this.in.close();
                } catch (IOException e) {
                }
            }
        }

        public RandomAccessFile open() {
            this.cnt++;
            return this.in;
        }
    }

    public SharedFileInputStream(File file) {
        this(file, defaultBufferSize);
    }

    public SharedFileInputStream(File file, int i) {
        super(null);
        this.start = 0;
        this.master = true;
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        init(new SharedFile(file), i);
    }

    public SharedFileInputStream(String str) {
        this(str, defaultBufferSize);
    }

    public SharedFileInputStream(String str, int i) {
        super(null);
        this.start = 0;
        this.master = true;
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        init(new SharedFile(str), i);
    }

    private SharedFileInputStream(SharedFile sharedFile, long j, long j2, int i) {
        super(null);
        this.start = 0;
        this.master = true;
        this.master = false;
        this.sf = sharedFile;
        this.in = sharedFile.open();
        this.start = j;
        this.bufpos = j;
        this.datalen = j2;
        this.bufsize = i;
        this.buf = new byte[i];
    }

    private void ensureOpen() {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill() {
        int i;
        if (this.markpos < 0) {
            this.pos = 0;
            this.bufpos += (long) this.count;
        } else if (this.pos >= this.buf.length) {
            if (this.markpos > 0) {
                i = this.pos - this.markpos;
                System.arraycopy(this.buf, this.markpos, this.buf, 0, i);
                this.pos = i;
                this.bufpos += (long) this.markpos;
                this.markpos = 0;
            } else if (this.buf.length >= this.marklimit) {
                this.markpos = -1;
                this.pos = 0;
                this.bufpos += (long) this.count;
            } else {
                i = this.pos * 2;
                if (i > this.marklimit) {
                    i = this.marklimit;
                }
                Object obj = new byte[i];
                System.arraycopy(this.buf, 0, obj, 0, this.pos);
                this.buf = obj;
            }
        }
        this.count = this.pos;
        this.in.seek(this.bufpos + ((long) this.pos));
        i = this.buf.length - this.pos;
        if (((this.bufpos - this.start) + ((long) this.pos)) + ((long) i) > this.datalen) {
            i = (int) (this.datalen - ((this.bufpos - this.start) + ((long) this.pos)));
        }
        i = this.in.read(this.buf, this.pos, i);
        if (i > 0) {
            this.count = i + this.pos;
        }
    }

    private int in_available() {
        return (int) ((this.start + this.datalen) - (this.bufpos + ((long) this.count)));
    }

    private void init(SharedFile sharedFile, int i) {
        this.sf = sharedFile;
        this.in = sharedFile.open();
        this.start = 0;
        this.datalen = this.in.length();
        this.bufsize = i;
        this.buf = new byte[i];
    }

    private int read1(byte[] bArr, int i, int i2) {
        int i3 = this.count - this.pos;
        if (i3 <= 0) {
            fill();
            i3 = this.count - this.pos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.pos, bArr, i, i2);
        this.pos += i2;
        return i2;
    }

    public synchronized int available() {
        ensureOpen();
        return (this.count - this.pos) + in_available();
    }

    public void close() {
        if (this.in != null) {
            try {
                if (this.master) {
                    this.sf.forceClose();
                } else {
                    this.sf.close();
                }
                this.sf = null;
                this.in = null;
                this.buf = null;
            } catch (Throwable th) {
                this.sf = null;
                this.in = null;
                this.buf = null;
            }
        }
    }

    protected void finalize() {
        super.finalize();
        close();
    }

    public long getPosition() {
        if (this.in != null) {
            return (this.bufpos + ((long) this.pos)) - this.start;
        }
        throw new RuntimeException("Stream closed");
    }

    public synchronized void mark(int i) {
        this.marklimit = i;
        this.markpos = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public InputStream newStream(long j, long j2) {
        if (this.in == null) {
            throw new RuntimeException("Stream closed");
        } else if (j < 0) {
            throw new IllegalArgumentException("start < 0");
        } else {
            if (j2 == -1) {
                j2 = this.datalen;
            }
            return new SharedFileInputStream(this.sf, this.start + ((long) ((int) j)), (long) ((int) (j2 - j)), this.bufsize);
        }
    }

    public synchronized int read() {
        int i;
        ensureOpen();
        if (this.pos >= this.count) {
            fill();
            if (this.pos >= this.count) {
                i = -1;
            }
        }
        byte[] bArr = this.buf;
        int i2 = this.pos;
        this.pos = i2 + 1;
        i = bArr[i2] & 255;
        return i;
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        ensureOpen();
        if ((((i | i2) | (i + i2)) | (bArr.length - (i + i2))) < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            i3 = 0;
        } else {
            i3 = read1(bArr, i, i2);
            if (i3 > 0) {
                while (i3 < i2) {
                    int read1 = read1(bArr, i + i3, i2 - i3);
                    if (read1 <= 0) {
                        break;
                    }
                    i3 += read1;
                }
            }
        }
        return i3;
    }

    public synchronized void reset() {
        ensureOpen();
        if (this.markpos < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.pos = this.markpos;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long skip(long r6) {
        /*
        r5 = this;
        r0 = 0;
        monitor-enter(r5);
        r5.ensureOpen();	 Catch:{ all -> 0x0030 }
        r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);
        return r0;
    L_0x000c:
        r2 = r5.count;	 Catch:{ all -> 0x0030 }
        r3 = r5.pos;	 Catch:{ all -> 0x0030 }
        r2 = r2 - r3;
        r2 = (long) r2;	 Catch:{ all -> 0x0030 }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r4 > 0) goto L_0x0023;
    L_0x0016:
        r5.fill();	 Catch:{ all -> 0x0030 }
        r2 = r5.count;	 Catch:{ all -> 0x0030 }
        r3 = r5.pos;	 Catch:{ all -> 0x0030 }
        r2 = r2 - r3;
        r2 = (long) r2;	 Catch:{ all -> 0x0030 }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r4 <= 0) goto L_0x000a;
    L_0x0023:
        r0 = r2;
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0033;
    L_0x0028:
        r2 = r5.pos;	 Catch:{ all -> 0x0030 }
        r2 = (long) r2;	 Catch:{ all -> 0x0030 }
        r2 = r2 + r0;
        r2 = (int) r2;	 Catch:{ all -> 0x0030 }
        r5.pos = r2;	 Catch:{ all -> 0x0030 }
        goto L_0x000a;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0033:
        r0 = r6;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.util.SharedFileInputStream.skip(long):long");
    }
}
