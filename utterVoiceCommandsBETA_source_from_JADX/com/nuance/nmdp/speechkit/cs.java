package com.nuance.nmdp.speechkit;

public final class cs extends cv {
    private String f2649a;

    public cs(String str) {
        super((short) 22);
        this.f2649a = str;
    }

    public cs(byte[] bArr) {
        super((short) 22);
        this.f2649a = new String(bArr);
    }

    public final String m2351a() {
        return this.f2649a;
    }

    public final byte[] m2352b() {
        return super.m2349a(this.f2649a.getBytes());
    }
}
