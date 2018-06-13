package com.nuance.nmdp.speechkit;

import java.io.ByteArrayOutputStream;

public class cv {
    private short f2648a;

    public cv(short s) {
        this.f2648a = s;
    }

    public static int m2347a(int i) {
        return i <= 127 ? 1 : i <= 255 ? 2 : i <= 65535 ? 3 : 5;
    }

    public static int m2348a(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        return i2 == 129 ? bArr[i + 1] & 255 : i2 == 130 ? ((bArr[i + 1] & 255) << 8) + (bArr[i + 2] & 255) : i2 == 132 ? ((((bArr[i + 1] & 255) << 24) + ((bArr[i + 2] & 255) << 16)) + ((bArr[i + 3] & 255) << 8)) + (bArr[i + 4] & 255) : i2;
    }

    public final byte[] m2349a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.f2648a & 255);
        if (bArr.length > 65535) {
            byteArrayOutputStream.write(132);
            byteArrayOutputStream.write((bArr.length >> 24) & 255);
            byteArrayOutputStream.write((bArr.length >> 16) & 255);
            byteArrayOutputStream.write((bArr.length >> 8) & 255);
            byteArrayOutputStream.write(bArr.length & 255);
        } else if (bArr.length > 255) {
            byteArrayOutputStream.write(130);
            byteArrayOutputStream.write((bArr.length >> 8) & 255);
            byteArrayOutputStream.write(bArr.length & 255);
        } else if (bArr.length > 127) {
            byteArrayOutputStream.write(129);
            byteArrayOutputStream.write(bArr.length);
        } else if (bArr.length >= 0) {
            byteArrayOutputStream.write(bArr.length);
        }
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        return byteArrayOutputStream.toByteArray();
    }

    public final short m2350c() {
        return this.f2648a;
    }
}
