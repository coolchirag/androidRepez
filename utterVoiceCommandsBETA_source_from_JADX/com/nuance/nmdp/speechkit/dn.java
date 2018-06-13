package com.nuance.nmdp.speechkit;

public class dn extends cv {
    private static final bj f2698a = C0478j.m2563a(dn.class);
    private String f2699b;

    public dn(String str) {
        super((short) 193);
        this.f2699b = str;
    }

    public dn(byte[] bArr) {
        super((short) 193);
        try {
            this.f2699b = new String(bArr, "UTF-8");
        } catch (Exception e) {
            f2698a.mo322e("PDXUTF8String() " + e.getMessage());
            this.f2699b = new String(bArr);
        }
    }

    public final String m2450a() {
        return this.f2699b;
    }

    public final byte[] m2451b() {
        try {
            return super.m2349a(this.f2699b.getBytes("UTF-8"));
        } catch (Exception e) {
            f2698a.mo322e("PDXUTF8String().toByteArray() " + e.getMessage());
            return super.m2349a(this.f2699b.getBytes());
        }
    }
}
