package com.google.ads.internal;

import android.content.Context;
import com.google.ads.C0245g;

public final class C0270v {
    public static final C0270v f2203a = new C0270v(null, true);
    private C0245g f2204b;
    private final boolean f2205c;

    private C0270v(C0245g c0245g, boolean z) {
        this.f2204b = c0245g;
        this.f2205c = z;
    }

    public static C0270v m1796a(C0245g c0245g) {
        return C0270v.m1797a(c0245g, null);
    }

    public static C0270v m1797a(C0245g c0245g, Context context) {
        return new C0270v(C0245g.m1659a(c0245g, context), false);
    }

    public final boolean m1798a() {
        return this.f2205c;
    }

    public final C0245g m1799b() {
        return this.f2204b;
    }

    public final void m1800b(C0245g c0245g) {
        if (!this.f2205c) {
            this.f2204b = c0245g;
        }
    }
}
