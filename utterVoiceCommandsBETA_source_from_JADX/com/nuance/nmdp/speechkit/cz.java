package com.nuance.nmdp.speechkit;

public final class cz extends cv {
    private int f2663a;

    public cz(int i) {
        super((short) 192);
        this.f2663a = i;
    }

    public cz(byte[] bArr) {
        super((short) 192);
        if (bArr.length == 1) {
            this.f2663a = bArr[0] & 255;
        } else if (bArr.length == 2) {
            this.f2663a = ((bArr[1] & 255) << 8) + (bArr[0] & 255);
        } else if (bArr.length == 3) {
            this.f2663a = (((bArr[2] & 255) << 16) + ((bArr[1] & 255) << 8)) + (bArr[0] & 255);
        } else {
            this.f2663a = ((((bArr[3] & 255) << 24) + ((bArr[2] & 255) << 16)) + ((bArr[1] & 255) << 8)) + (bArr[0] & 255);
        }
    }

    public final int m2393a() {
        return this.f2663a;
    }

    public final byte[] m2394b() {
        byte[] bArr = Math.abs(this.f2663a) < 128 ? new byte[]{(byte) (this.f2663a & 255)} : Math.abs(this.f2663a) < 32768 ? new byte[]{(byte) (this.f2663a & 255), (byte) ((this.f2663a >> 8) & 255)} : new byte[]{(byte) (this.f2663a & 255), (byte) ((this.f2663a >> 8) & 255), (byte) ((this.f2663a >> 16) & 255), (byte) ((this.f2663a >> 24) & 255)};
        return super.m2349a(bArr);
    }
}
