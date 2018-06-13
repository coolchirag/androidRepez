package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.C0245g;
import java.util.LinkedList;

final class C0263o implements Runnable {
    private final C0264p f2145a;
    private final WebView f2146b;
    private final LinkedList<String> f2147c;
    private final int f2148d;
    private final boolean f2149e;
    private final String f2150f;
    private final C0245g f2151g;

    public C0263o(C0264p c0264p, WebView webView, LinkedList<String> linkedList, int i, boolean z, String str, C0245g c0245g) {
        this.f2145a = c0264p;
        this.f2146b = webView;
        this.f2147c = linkedList;
        this.f2148d = i;
        this.f2149e = z;
        this.f2150f = str;
        this.f2151g = c0245g;
    }

    public final void run() {
        if (this.f2146b != null) {
            this.f2146b.stopLoading();
            this.f2146b.destroy();
        }
        this.f2145a.m1731a(this.f2147c);
        this.f2145a.m1723a(this.f2148d);
        this.f2145a.m1732a(this.f2149e);
        this.f2145a.m1730a(this.f2150f);
        if (this.f2151g != null) {
            ((C0270v) this.f2145a.m1742g().f2020k.m1850a()).m1800b(this.f2151g);
            this.f2145a.m1745j().setAdSize(this.f2151g);
        }
        this.f2145a.m1758w();
    }
}
