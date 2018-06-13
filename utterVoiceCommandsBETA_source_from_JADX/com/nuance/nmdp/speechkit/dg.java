package com.nuance.nmdp.speechkit;

public class dg extends da implements dt {
    private static final bj f2670a = C0478j.m2563a(dg.class);

    public dg(byte[] bArr) {
        super((short) 29186, bArr);
    }

    public final int mo270g() {
        f2670a.mo316b((Object) "PDXQueryError.getError()");
        return mo261c("error");
    }

    public final String mo271h() {
        f2670a.mo316b((Object) "PDXQueryError.getDescription()");
        String e = mo263e("description");
        return e != null ? e : "";
    }
}
