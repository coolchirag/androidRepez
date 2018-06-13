package com.nuance.nmdp.speechkit;

public class dj extends da implements du {
    private static final bj f2673a = C0478j.m2563a(dj.class);

    public dj(byte[] bArr) {
        super((short) 29189, bArr);
    }

    public final String mo272g() {
        f2673a.mo316b((Object) "PDXQueryRetry.getName()");
        String e = mo263e("name");
        return e != null ? e : "";
    }

    public final int mo273h() {
        f2673a.mo316b((Object) "PDXQueryRetry.getCause()");
        try {
            return mo261c("cause");
        } catch (Exception e) {
            return 0;
        }
    }

    public final String mo274i() {
        String e;
        f2673a.mo316b((Object) "PDXQueryRetry.getPrompt()");
        try {
            e = mo263e("prompt");
        } catch (Exception e2) {
            e = "";
        }
        return e != null ? e : "";
    }
}
