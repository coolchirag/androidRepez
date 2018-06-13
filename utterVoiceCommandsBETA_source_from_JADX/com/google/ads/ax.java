package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public final class ax implements as {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).setCustomClose("1".equals(hashMap.get("custom_close")));
        } else {
            C0290d.m1865b("Trying to set a custom close icon on a WebView that isn't an AdWebView");
        }
    }
}
