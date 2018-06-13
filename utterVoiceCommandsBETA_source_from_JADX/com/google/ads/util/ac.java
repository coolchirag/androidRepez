package com.google.ads.util;

public final class ac<T> extends aa<T> {
    final /* synthetic */ C0236z f2260d;
    private boolean f2261e;

    public ac(C0236z c0236z, String str) {
        this.f2260d = c0236z;
        super(c0236z, str);
        this.f2261e = false;
        this.f2261e = false;
    }

    public ac(C0236z c0236z, String str, T t) {
        this.f2260d = c0236z;
        super(c0236z, str, t);
        this.f2261e = false;
        this.f2261e = false;
    }

    public final synchronized T m1851a() {
        return this.a;
    }

    public final synchronized void m1852a(T t) {
        C0290d.m1869d("State changed - " + this.f2260d.toString() + "." + this.b + ": '" + t + "' <-- '" + this.a + "'.");
        this.a = t;
        this.f2261e = true;
    }

    public final String toString() {
        return super.toString() + (this.f2261e ? " (*)" : "");
    }
}
