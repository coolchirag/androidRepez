package com.google.ads.util;

import android.text.TextUtils;
import android.util.Log;

public final class C0288b {
    private static boolean f2263a = Log.isLoggable("GoogleAdsAssertion", 3);

    public static void m1854a(Object obj) {
        C0288b.m1860c(obj != null, "Assertion that an object is not null failed.");
    }

    public static void m1855a(Object obj, Object obj2) {
        C0288b.m1860c(obj == obj2, "Assertion that 'a' and 'b' refer to the same object failed.a: " + obj + ", b: " + obj2);
    }

    public static void m1856a(String str) {
        C0288b.m1860c(!TextUtils.isEmpty(str), "Expected a non empty string, got: " + str);
    }

    public static void m1857a(boolean z) {
        C0288b.m1860c(!z, "Assertion failed.");
    }

    public static void m1858a(boolean z, String str) {
        C0288b.m1860c(z, str);
    }

    public static void m1859b(boolean z, String str) {
        C0288b.m1860c(!z, str);
    }

    private static void m1860c(boolean z, String str) {
        if ((Log.isLoggable("GoogleAdsAssertion", 3) || f2263a) && !z) {
            Throwable c0289c = new C0289c(str);
            Log.d("GoogleAdsAssertion", str, c0289c);
            throw c0289c;
        }
    }
}
