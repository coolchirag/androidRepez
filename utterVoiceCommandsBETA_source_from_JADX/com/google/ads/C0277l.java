package com.google.ads;

import android.app.Activity;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0250c;
import com.google.ads.internal.C0264p;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.util.HashMap;
import org.ispeech.core.HttpRequestParams;
import org.ispeech.core.InternalResources;

public final class C0277l implements as {
    private static final C0250c f2224a = ((C0250c) C0250c.f2099a.mo113a());

    private static int m1809a(HashMap<String, String> hashMap, String str, int i, DisplayMetrics displayMetrics) {
        String str2 = (String) hashMap.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) Integer.parseInt(str2), displayMetrics);
        } catch (NumberFormatException e) {
            C0290d.m1862a("Could not parse \"" + str + "\" in a video gmsg: " + str2);
            return i;
        }
    }

    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get(HttpRequestParams.ACTION);
        if (str == null) {
            C0290d.m1862a("No \"action\" parameter in a video gmsg.");
        } else if (webView instanceof AdWebView) {
            AdWebView adWebView = (AdWebView) webView;
            Activity d = adWebView.m1676d();
            if (d == null) {
                C0290d.m1862a("Could not get adActivity for a video gmsg.");
                return;
            }
            boolean equals = str.equals("new");
            boolean equals2 = str.equals("position");
            DisplayMetrics a;
            int a2;
            if (equals || equals2) {
                a = AdUtil.m1821a(d);
                a2 = C0277l.m1809a(hashMap, "x", 0, a);
                int a3 = C0277l.m1809a(hashMap, "y", 0, a);
                int a4 = C0277l.m1809a(hashMap, InternalResources.ISPEECH_SCREEN_AD_WIDTH, -1, a);
                int a5 = C0277l.m1809a(hashMap, InternalResources.ISPEECH_SCREEN_AD_HEIGHT, -1, a);
                if (equals && d.m1576a() == null) {
                    d.m1580b(a2, a3, a4, a5);
                    return;
                } else {
                    d.m1577a(a2, a3, a4, a5);
                    return;
                }
            }
            AdVideoView a6 = d.m1576a();
            if (a6 == null) {
                C0250c c0250c = f2224a;
                C0250c.m1683a(adWebView, "onVideoEvent", "{'event': 'error', 'what': 'no_video_view'}");
            } else if (str.equals("click")) {
                a = AdUtil.m1821a(d);
                int a7 = C0277l.m1809a(hashMap, "x", 0, a);
                a2 = C0277l.m1809a(hashMap, "y", 0, a);
                long uptimeMillis = SystemClock.uptimeMillis();
                a6.m1668a(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a7, (float) a2, 0));
            } else if (str.equals("controls")) {
                str = (String) hashMap.get("enabled");
                if (str == null) {
                    C0290d.m1862a("No \"enabled\" parameter in a controls video gmsg.");
                } else if (str.equals("true")) {
                    a6.setMediaControllerEnabled(true);
                } else {
                    a6.setMediaControllerEnabled(false);
                }
            } else if (str.equals("currentTime")) {
                str = (String) hashMap.get("time");
                if (str == null) {
                    C0290d.m1862a("No \"time\" parameter in a currentTime video gmsg.");
                    return;
                }
                try {
                    a6.m1667a((int) (Float.parseFloat(str) * 1000.0f));
                } catch (NumberFormatException e) {
                    C0290d.m1862a("Could not parse \"time\" parameter: " + str);
                }
            } else if (str.equals("hide")) {
                a6.setVisibility(4);
            } else if (str.equals("load")) {
                a6.m1666a();
            } else if (str.equals("pause")) {
                a6.m1669b();
            } else if (str.equals("play")) {
                a6.m1670c();
            } else if (str.equals("show")) {
                a6.setVisibility(0);
            } else if (str.equals("src")) {
                a6.setSrc((String) hashMap.get("src"));
            } else {
                C0290d.m1862a("Unknown video action: " + str);
            }
        } else {
            C0290d.m1862a("Could not get adWebView for a video gmsg.");
        }
    }
}
