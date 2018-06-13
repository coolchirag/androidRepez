package com.google.ads.util;

import android.os.Build;

final class C0297k {
    static final C0297k f2291d = new C0297k();
    static final C0297k f2292e = new C0297k("unknown", "generic", "generic");
    public final String f2293a;
    public final String f2294b;
    public final String f2295c;

    C0297k() {
        this.f2293a = Build.BOARD;
        this.f2294b = Build.DEVICE;
        this.f2295c = Build.BRAND;
    }

    private C0297k(String str, String str2, String str3) {
        this.f2293a = str;
        this.f2294b = str2;
        this.f2295c = str3;
    }

    private static boolean m1876a(String str, String str2) {
        return str != null ? str.equals(str2) : str == str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0297k)) {
            return false;
        }
        C0297k c0297k = (C0297k) obj;
        return C0297k.m1876a(this.f2293a, c0297k.f2293a) && C0297k.m1876a(this.f2294b, c0297k.f2294b) && C0297k.m1876a(this.f2295c, c0297k.f2295c);
    }

    public final int hashCode() {
        int i = 0;
        if (this.f2293a != null) {
            i = this.f2293a.hashCode() + 0;
        }
        if (this.f2294b != null) {
            i += this.f2294b.hashCode();
        }
        return this.f2295c != null ? i + this.f2295c.hashCode() : i;
    }
}
