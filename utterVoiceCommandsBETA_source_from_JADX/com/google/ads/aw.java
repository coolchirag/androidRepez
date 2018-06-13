package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public final class aw implements as {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).m1673a();
        } else {
            C0290d.m1865b("Trying to close WebView that isn't an AdWebView");
        }
    }
}
