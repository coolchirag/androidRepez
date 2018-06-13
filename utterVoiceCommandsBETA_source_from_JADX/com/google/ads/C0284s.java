package com.google.ads;

import android.webkit.WebView;

final class C0284s implements Runnable {
    private final boolean f2238a;
    private final WebView f2239b;

    public C0284s(WebView webView, boolean z) {
        this.f2239b = webView;
        this.f2238a = z;
    }

    public final void run() {
        C0281p.m1814a(this.f2239b, this.f2238a);
    }
}
