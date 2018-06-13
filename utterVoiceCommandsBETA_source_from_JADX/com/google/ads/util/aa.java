package com.google.ads.util;

public abstract class aa<T> {
    protected T f2256a;
    protected final String f2257b;
    final /* synthetic */ C0236z f2258c;

    private aa(C0236z c0236z, String str) {
        this(c0236z, str, null);
    }

    private aa(C0236z c0236z, String str, T t) {
        this.f2258c = c0236z;
        this.f2257b = str;
        c0236z.f1994d.add(this);
        this.f2256a = t;
    }

    public String toString() {
        return this.f2258c.toString() + "." + this.f2257b + " = " + this.f2256a;
    }
}
