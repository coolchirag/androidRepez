package com.google.ads.internal;

import com.google.ads.util.C0290d;

public final class C0255g extends Exception {
    public final boolean f2103a = true;

    public C0255g(String str) {
        super(str);
    }

    public C0255g(String str, Throwable th) {
        super(str, th);
    }

    public final void m1692a(String str) {
        C0290d.m1865b(m1694c(str));
        C0290d.m1863a(null, (Throwable) this);
    }

    public final void m1693b(String str) {
        Throwable th;
        String c = m1694c(str);
        if (!this.f2103a) {
            th = null;
        }
        throw new RuntimeException(c, th);
    }

    public final String m1694c(String str) {
        return this.f2103a ? str + ": " + getMessage() : str;
    }
}
