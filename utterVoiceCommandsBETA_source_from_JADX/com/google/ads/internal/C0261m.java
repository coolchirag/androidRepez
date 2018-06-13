package com.google.ads.internal;

import android.webkit.WebView;

final class C0261m implements Runnable {
    final /* synthetic */ C0256h f2135a;
    private final String f2136b;
    private final String f2137c;
    private final WebView f2138d;

    public C0261m(C0256h c0256h, WebView webView, String str, String str2) {
        this.f2135a = c0256h;
        this.f2138d = webView;
        this.f2136b = str;
        this.f2137c = str2;
    }

    public final void run() {
        if (this.f2137c != null) {
            this.f2138d.loadDataWithBaseURL(this.f2136b, this.f2137c, "text/html", "utf-8", null);
        } else {
            this.f2138d.loadUrl(this.f2136b);
        }
    }
}
