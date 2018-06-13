package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.webkit.WebView;
import com.google.ads.internal.C0250c;
import java.util.Date;
import java.util.Locale;

public final class C0281p {
    private static final C0250c f2232a = ((C0250c) C0250c.f2099a.mo113a());

    public static void m1811a(Activity activity) {
        new Thread(new C0282q(activity)).start();
    }

    public static void m1812a(Activity activity, WebView webView, String str) {
        new Thread(new C0283r(activity, webView, str)).start();
    }

    public static void m1813a(WebView webView, String str) {
        C0250c c0250c = f2232a;
        C0250c.m1682a(webView, String.format(Locale.US, "(G_resizeIframe(%s))", new Object[]{str}));
    }

    public static void m1814a(WebView webView, boolean z) {
        C0250c c0250c = f2232a;
        C0250c.m1682a(webView, String.format(Locale.US, "(G_updatePlusOne(%b))", new Object[]{Boolean.valueOf(z)}));
    }

    public static boolean m1815a(Context context, long j) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return C0285t.m1816a(context) && !(defaultSharedPreferences.contains("drt") && defaultSharedPreferences.contains("drt_ts") && defaultSharedPreferences.getLong("drt_ts", 0) >= new Date().getTime() - j);
    }
}
