package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class BASE64EncoderStream extends FilterOutputStream {
    private static byte[] newline = new byte[]{(byte) 13, (byte) 10};
    private static final char[] pem_array = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private byte[] buffer;
    private int bufsize;
    private int bytesPerLine;
    private int count;
    private int lineLimit;
    private boolean noCRLF;
    private byte[] outbuf;

    public BASE64EncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public BASE64EncoderStream(OutputStream outputStream, int i) {
        super(outputStream);
        this.bufsize = 0;
        this.count = 0;
        this.noCRLF = false;
        this.buffer = new byte[3];
        if (i == Integer.MAX_VALUE || i < 4) {
            this.noCRLF = true;
            i = 76;
        }
        int i2 = (i / 4) * 4;
        this.bytesPerLine = i2;
        this.lineLimit = (i2 / 4) * 3;
        if (this.noCRLF) {
            this.outbuf = new byte[i2];
            return;
        }
        this.outbuf = new byte[(i2 + 2)];
        this.outbuf[i2] = (byte) 13;
        this.outbuf[i2 + 1] = (byte) 10;
    }

    private void encode() {
        int encodedSize = encodedSize(this.bufsize);
        this.out.write(encode(this.buffer, 0, this.bufsize, this.outbuf), 0, encodedSize);
        this.count = encodedSize + this.count;
        if (this.count >= this.bytesPerLine) {
            if (!this.noCRLF) {
                this.out.write(newline);
            }
            this.count = 0;
        }
    }

    public static byte[] encode(byte[] bArr) {
        return bArr.length == 0 ? bArr : encode(bArr, 0, bArr.length, null);
    }

    private static byte[] encode(byte[] bArr, int i, int i2, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = new byte[encodedSize(i2)];
        }
        int i3 = 0;
        while (i2 >= 3) {
            int i4 = i + 1;
            int i5 = (bArr[i] & 255) << 8;
            int i6 = i4 + 1;
            i = i6 + 1;
            i4 = (((bArr[i4] & 255) | i5) << 8) | (bArr[i6] & 255);
            bArr2[i3 + 3] = (byte) pem_array[i4 & 63];
            i4 >>= 6;
            bArr2[i3 + 2] = (byte) pem_array[i4 & 63];
            i4 >>= 6;
            bArr2[i3 + 1] = (byte) pem_array[i4 & 63];
            bArr2[i3 + 0] = (byte) pem_array[(i4 >> 6) & 63];
            i2 -= 3;
            i3 += 4;
        }
        if (i2 == 1) {
            i4 = (bArr[i] & 255) << 4;
            bArr2[i3 + 3] = (byte) 61;
            bArr2[i3 + 2] = (byte) 61;
            bArr2[i3 + 1] = (byte) pem_array[i4 & 63];
            bArr2[i3 + 0] = (byte) pem_array[(i4 >> 6) & 63];
        } else if (i2 == 2) {
            i5 = (bArr[i] & 255) << 8;
            i4 = ((bArr[i + 1] & 255) | i5) << 2;
            bArr2[i3 + 3] = (byte) 61;
            bArr2[i3 + 2] = (byte) pem_array[i4 & 63];
            i4 >>= 6;
            bArr2[i3 + 1] = (byte) pem_array[i4 & 63];
            bArr2[i3 + 0] = (byte) pem_array[(i4 >> 6) & 63];
        }
        return bArr2;
    }

    private static int encodedSize(int i) {
        return ((i + 2) / 3) * 4;
    }

    public synchronized void close() {
        flush();
        if (this.count > 0 && !this.noCRLF) {
            this.out.write(newline);
            this.out.flush();
        }
        this.out.close();
    }

    public synchronized void flush() {
        if (this.bufsize > 0) {
            encode();
            this.bufsize = 0;
        }
        this.out.flush();
    }

    public synchronized void write(int i) {
        byte[] bArr = this.buffer;
        int i2 = this.bufsize;
        this.bufsize = i2 + 1;
        bArr[i2] = (byte) i;
        if (this.bufsize == 3) {
            encode();
            this.bufsize = 0;
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        int encodedSize;
        int i3 = i + i2;
        int i4 = i;
        while (this.bufsize != 0 && i4 < i3) {
            i = i4 + 1;
            write(bArr[i4]);
            i4 = i;
        }
        int i5 = ((this.bytesPerLine - this.count) / 4) * 3;
        if (i4 + i5 < i3) {
            encodedSize = encodedSize(i5);
            if (!this.noCRLF) {
                int i6 = encodedSize + 1;
                this.outbuf[encodedSize] = (byte) 13;
                encodedSize = i6 + 1;
                this.outbuf[i6] = (byte) 10;
            }
            this.out.write(encode(bArr, i4, i5, this.outbuf), 0, encodedSize);
            i4 += i5;
            this.count = 0;
        }
        while (this.lineLimit + i4 < i3) {
            this.out.write(encode(bArr, i4, this.lineLimit, this.outbuf));
            i4 += this.lineLimit;
        }
        if (i4 + 3 < i3) {
            encodedSize = ((i3 - i4) / 3) * 3;
            i5 = encodedSize(encodedSize);
            this.out.write(encode(bArr, i4, encodedSize, this.outbuf), 0, i5);
            i4 += encodedSize;
            this.count += i5;
        }
        while (i4 < i3) {
            write(bArr[i4]);
            i4++;
        }
    }
}
