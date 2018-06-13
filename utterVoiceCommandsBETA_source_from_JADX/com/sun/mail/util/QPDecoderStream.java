package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class QPDecoderStream extends FilterInputStream {
    protected byte[] ba = new byte[2];
    protected int spaces = 0;

    public QPDecoderStream(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 2));
    }

    public int available() {
        return this.in.available();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        if (this.spaces > 0) {
            this.spaces--;
            return 32;
        }
        int read = this.in.read();
        if (read == 32) {
            int i;
            while (true) {
                read = this.in.read();
                if (read != 32) {
                    break;
                }
                this.spaces++;
            }
            if (read == 13 || read == 10 || read == -1) {
                this.spaces = 0;
                i = read;
            } else {
                ((PushbackInputStream) this.in).unread(read);
                i = 32;
            }
            return i;
        } else if (read != 61) {
            return read;
        } else {
            int read2 = this.in.read();
            if (read2 == 10) {
                return read();
            }
            if (read2 == 13) {
                read2 = this.in.read();
                if (read2 != 10) {
                    ((PushbackInputStream) this.in).unread(read2);
                }
                return read();
            } else if (read2 == -1) {
                return -1;
            } else {
                this.ba[0] = (byte) read2;
                this.ba[1] = (byte) this.in.read();
                try {
                    return ASCIIUtility.parseInt(this.ba, 0, 2, 16);
                } catch (NumberFormatException e) {
                    ((PushbackInputStream) this.in).unread(this.ba);
                    return read;
                }
            }
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        for (i3 = 0; i3 < i2; i3++) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i + i3] = (byte) read;
        }
        return i3;
    }
}
