package com.google.ads.util;

import java.lang.ref.WeakReference;

public final class ad<T> extends aa<WeakReference<T>> {
    final /* synthetic */ C0236z f2262d;

    public ad(C0236z c0236z, String str, T t) {
        this.f2262d = c0236z;
        super(c0236z, str, new WeakReference(t));
    }

    public final T m1853a() {
        return ((WeakReference) this.a).get();
    }

    public final String toString() {
        return this.f2262d.toString() + "." + this.b + " = " + m1853a() + " (?)";
    }
}
