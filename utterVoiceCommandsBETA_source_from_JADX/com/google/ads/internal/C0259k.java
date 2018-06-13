package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.C0243e;

final class C0259k implements Runnable {
    private final C0264p f2129a;
    private final WebView f2130b;
    private final C0266r f2131c;
    private final C0243e f2132d;
    private final boolean f2133e;

    public C0259k(C0264p c0264p, WebView webView, C0266r c0266r, C0243e c0243e, boolean z) {
        this.f2129a = c0264p;
        this.f2130b = webView;
        this.f2131c = c0266r;
        this.f2132d = c0243e;
        this.f2133e = z;
    }

    public final void run() {
        if (this.f2130b != null) {
            this.f2130b.stopLoading();
            this.f2130b.destroy();
        }
        if (this.f2131c != null) {
            this.f2131c.f2180a = true;
        }
        if (this.f2133e) {
            AdWebView j = this.f2129a.m1745j();
            j.stopLoading();
            j.setVisibility(8);
        }
        this.f2129a.m1727a(this.f2132d);
    }
}
