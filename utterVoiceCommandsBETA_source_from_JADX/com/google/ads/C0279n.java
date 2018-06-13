package com.google.ads;

import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.lang.ref.WeakReference;

public final class C0279n implements Runnable {
    private WeakReference<C0264p> f2227a;

    public C0279n(C0264p c0264p) {
        this.f2227a = new WeakReference(c0264p);
    }

    public final void run() {
        C0264p c0264p = (C0264p) this.f2227a.get();
        if (c0264p == null) {
            C0290d.m1862a("The ad must be gone, so cancelling the refresh timer.");
        } else {
            c0264p.m1757v();
        }
    }
}
