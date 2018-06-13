package com.nuance.nmdp.speechkit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class da extends cx {
    private static final bj f2661a = C0478j.m2563a(da.class);
    private short f2662b;

    public da(short s) {
        this.f2662b = s;
    }

    public da(short s, byte[] bArr) {
        super(bArr);
        this.f2662b = s;
    }

    public final byte[] mo266d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.f2662b & 255);
        byteArrayOutputStream.write((this.f2662b & 65280) >> 8);
        try {
            byteArrayOutputStream.write(super.mo266d());
        } catch (IOException e) {
            f2661a.mo322e("PDXMessage.toByteArray() " + e.toString() + ". ");
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final short m2391e() {
        return this.f2662b;
    }

    public final byte[] m2392f() {
        return super.mo266d();
    }
}
