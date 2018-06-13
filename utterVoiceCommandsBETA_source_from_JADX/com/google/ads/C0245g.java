package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;

public final class C0245g {
    public static final C0245g f2070a = new C0245g(-1, -2, "mb");
    public static final C0245g f2071b = new C0245g(320, 50, "mb");
    public static final C0245g f2072c = new C0245g(300, 250, "as");
    public static final C0245g f2073d = new C0245g(468, 60, "as");
    public static final C0245g f2074e = new C0245g(728, 90, "as");
    public static final C0245g f2075f = new C0245g(160, 600, "as");
    private final int f2076g;
    private final int f2077h;
    private boolean f2078i;
    private boolean f2079j;
    private boolean f2080k;
    private String f2081l;

    public C0245g(int i, int i2) {
        this(i, i2, null);
        if (m1660f()) {
            this.f2080k = false;
            this.f2081l = "mb";
            return;
        }
        this.f2080k = true;
    }

    private C0245g(int i, int i2, String str) {
        boolean z = true;
        this.f2076g = i;
        this.f2077h = i2;
        this.f2081l = str;
        this.f2078i = i == -1;
        if (i2 != -2) {
            z = false;
        }
        this.f2079j = z;
        this.f2080k = false;
    }

    public static C0245g m1659a(C0245g c0245g, Context context) {
        if (context == null || !c0245g.m1660f()) {
            return c0245g.m1660f() ? f2071b : c0245g;
        } else {
            int i;
            int i2;
            if (c0245g.f2078i) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                i = (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
            } else {
                i = c0245g.m1661a();
            }
            if (c0245g.f2079j) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                i2 = (int) (((float) displayMetrics2.heightPixels) / displayMetrics2.density);
                i2 = i2 <= 400 ? 32 : i2 <= 720 ? 50 : 90;
            } else {
                i2 = c0245g.m1662b();
            }
            C0245g c0245g2 = new C0245g(i, i2, c0245g.f2081l);
            c0245g2.f2079j = c0245g.f2079j;
            c0245g2.f2078i = c0245g.f2078i;
            c0245g2.f2080k = c0245g.f2080k;
            return c0245g2;
        }
    }

    private boolean m1660f() {
        return this.f2076g < 0 || this.f2077h < 0;
    }

    public final int m1661a() {
        if (this.f2076g >= 0) {
            return this.f2076g;
        }
        throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
    }

    public final int m1662b() {
        if (this.f2077h >= 0) {
            return this.f2077h;
        }
        throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
    }

    public final boolean m1663c() {
        return this.f2078i;
    }

    public final boolean m1664d() {
        return this.f2079j;
    }

    public final boolean m1665e() {
        return this.f2080k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0245g)) {
            return false;
        }
        C0245g c0245g = (C0245g) obj;
        return this.f2076g == c0245g.f2076g && this.f2077h == c0245g.f2077h;
    }

    public final int hashCode() {
        return (Integer.valueOf(this.f2076g).hashCode() << 16) | (Integer.valueOf(this.f2077h).hashCode() & 65535);
    }

    public final String toString() {
        return m1661a() + "x" + m1662b() + (this.f2081l == null ? "" : "_" + this.f2081l);
    }
}
