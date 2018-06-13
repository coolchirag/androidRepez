package com.nuance.nmdp.speechkit;

import com.nuance.nmsp.client.sdk.oem.C0521c;

public abstract class ca {
    private static final bj f2552a = C0478j.m2563a(ca.class);
    private String f2553b;
    private short f2554c;
    private String f2555d;
    private bk f2556e;
    private bh f2557f;
    private bh f2558g;

    protected ca(String str, short s, String str2, bh bhVar, bh bhVar2) {
        if (f2552a.mo317b()) {
            f2552a.mo316b("in NMSPManager() gateway IP [" + str + "] Port [" + s + "]");
        }
        String str3 = null;
        if (str == null) {
            str3 = " gatewayIP is null";
        } else if (str.length() == 0) {
            str3 = " gatewayIP is empty";
        }
        if (s <= (short) 0) {
            str3 = " gatewayPort should be greater than 0";
        }
        if (str3 != null) {
            f2552a.mo322e("NMSPManager " + IllegalArgumentException.class.getName() + str3);
            throw new IllegalArgumentException(str3);
        }
        this.f2553b = str;
        this.f2554c = s;
        this.f2555d = str2;
        this.f2557f = bhVar;
        this.f2558g = bhVar2;
        this.f2556e = new C0521c();
    }

    public static String m2225g() {
        throw new RuntimeException("Unsupported");
    }

    public final bk m2226a() {
        return this.f2556e;
    }

    public final void m2227a(bh bhVar) {
        this.f2557f = bhVar;
    }

    public final String m2228b() {
        return this.f2553b;
    }

    public final void m2229b(bh bhVar) {
        this.f2558g = bhVar;
    }

    public final short m2230c() {
        return this.f2554c;
    }

    public final String m2231d() {
        return this.f2555d;
    }

    public final bh m2232e() {
        return this.f2557f;
    }

    public final bh m2233f() {
        return this.f2558g;
    }
}
