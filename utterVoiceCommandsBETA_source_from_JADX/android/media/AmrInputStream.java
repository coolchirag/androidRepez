package android.media;

import java.io.InputStream;

public final class AmrInputStream extends InputStream {
    private static final int SAMPLES_PER_FRAME = 160;
    private static final String TAG = "AmrInputStream";
    private byte[] mBuf = new byte[320];
    private int mBufIn = 0;
    private int mBufOut = 0;
    private int mGae;
    private InputStream mInputStream;
    private byte[] mOneByte = new byte[1];

    static {
        System.loadLibrary("media_jni");
    }

    public AmrInputStream(InputStream inputStream) {
        this.mInputStream = inputStream;
        this.mGae = GsmAmrEncoderNew();
        GsmAmrEncoderInitialize(this.mGae);
    }

    private static native void GsmAmrEncoderCleanup(int i);

    private static native void GsmAmrEncoderDelete(int i);

    private static native int GsmAmrEncoderEncode(int i, byte[] bArr, int i2, byte[] bArr2, int i3);

    private static native void GsmAmrEncoderInitialize(int i);

    private static native int GsmAmrEncoderNew();

    public final void close() {
        try {
            if (this.mInputStream != null) {
                this.mInputStream.close();
            }
            this.mInputStream = null;
            try {
                if (this.mGae != 0) {
                    GsmAmrEncoderCleanup(this.mGae);
                }
                try {
                    if (this.mGae != 0) {
                        GsmAmrEncoderDelete(this.mGae);
                    }
                    this.mGae = 0;
                } catch (Throwable th) {
                    this.mGae = 0;
                }
            } catch (Throwable th2) {
                this.mGae = 0;
            }
        } catch (Throwable th3) {
            this.mGae = 0;
        }
    }

    protected final void finalize() {
        if (this.mGae != 0) {
            close();
            throw new IllegalStateException("someone forgot to close AmrInputStream");
        }
    }

    public final int read() {
        return read(this.mOneByte, 0, 1) == 1 ? this.mOneByte[0] & 255 : -1;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.mGae == 0) {
            throw new IllegalStateException("not open");
        }
        if (this.mBufOut >= this.mBufIn) {
            this.mBufOut = 0;
            this.mBufIn = 0;
            int i3 = 0;
            while (i3 < 320) {
                int read = this.mInputStream.read(this.mBuf, i3, 320 - i3);
                if (read == -1) {
                    return -1;
                }
                i3 += read;
            }
            this.mBufIn = GsmAmrEncoderEncode(this.mGae, this.mBuf, 0, this.mBuf, 0);
        }
        if (i2 > this.mBufIn - this.mBufOut) {
            i2 = this.mBufIn - this.mBufOut;
        }
        System.arraycopy(this.mBuf, this.mBufOut, bArr, i, i2);
        this.mBufOut += i2;
        return i2;
    }
}
