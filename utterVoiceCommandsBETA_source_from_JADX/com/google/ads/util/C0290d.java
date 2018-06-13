package com.google.ads.util;

import android.util.Log;

public final class C0290d {
    public static C0292f f2264a = null;
    private static int f2265b = 5;

    private static void m1861a() {
        if (f2264a != null) {
            C0292f c0292f = f2264a;
        }
    }

    public static void m1862a(String str) {
        if (C0290d.m1864a("Ads", 3)) {
            Log.d("Ads", str);
        }
        C0291e c0291e = C0291e.DEBUG;
        C0290d.m1861a();
    }

    public static void m1863a(String str, Throwable th) {
        if (C0290d.m1864a("Ads", 3)) {
            Log.d("Ads", str, th);
        }
        C0291e c0291e = C0291e.DEBUG;
        C0290d.m1861a();
    }

    private static boolean m1864a(String str, int i) {
        return (i >= f2265b) || Log.isLoggable(str, i);
    }

    public static void m1865b(String str) {
        if (C0290d.m1864a("Ads", 6)) {
            Log.e("Ads", str);
        }
        C0291e c0291e = C0291e.ERROR;
        C0290d.m1861a();
    }

    public static void m1866b(String str, Throwable th) {
        if (C0290d.m1864a("Ads", 6)) {
            Log.e("Ads", str, th);
        }
        C0291e c0291e = C0291e.ERROR;
        C0290d.m1861a();
    }

    public static void m1867c(String str) {
        if (C0290d.m1864a("Ads", 4)) {
            Log.i("Ads", str);
        }
        C0291e c0291e = C0291e.INFO;
        C0290d.m1861a();
    }

    public static void m1868c(String str, Throwable th) {
        if (C0290d.m1864a("Ads", 4)) {
            Log.i("Ads", str, th);
        }
        C0291e c0291e = C0291e.INFO;
        C0290d.m1861a();
    }

    public static void m1869d(String str) {
        if (C0290d.m1864a("Ads", 2)) {
            Log.v("Ads", str);
        }
        C0291e c0291e = C0291e.VERBOSE;
        C0290d.m1861a();
    }

    public static void m1870d(String str, Throwable th) {
        if (C0290d.m1864a("Ads", 5)) {
            Log.w("Ads", str, th);
        }
        C0291e c0291e = C0291e.WARN;
        C0290d.m1861a();
    }

    public static void m1871e(String str) {
        if (C0290d.m1864a("Ads", 5)) {
            Log.w("Ads", str);
        }
        C0291e c0291e = C0291e.WARN;
        C0290d.m1861a();
    }
}
