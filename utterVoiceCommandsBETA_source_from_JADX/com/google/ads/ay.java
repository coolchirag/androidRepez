package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0250c;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public final class ay implements as {
    private static final C0250c f2025a = ((C0250c) C0250c.f2099a.mo113a());

    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("js");
        if (str == null) {
            C0290d.m1865b("Could not get the JS to evaluate.");
        } else if (webView instanceof AdWebView) {
            AdActivity d = ((AdWebView) webView).m1676d();
            if (d == null) {
                C0290d.m1865b("Could not get the AdActivity from the AdWebView.");
                return;
            }
            WebView b = d.m1579b();
            if (b == null) {
                C0290d.m1865b("Could not get the opening WebView.");
                return;
            }
            C0250c c0250c = f2025a;
            C0250c.m1682a(b, str);
        } else {
            C0290d.m1865b("Trying to evaluate JS in a WebView that isn't an AdWebView");
        }
    }
}
