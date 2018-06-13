package com.google.ads.internal;

import com.google.ads.C0315z;

final class C0257i implements Runnable {
    final /* synthetic */ C0315z f2126a;
    final /* synthetic */ C0256h f2127b;

    C0257i(C0256h c0256h, C0315z c0315z) {
        this.f2127b = c0256h;
        this.f2126a = c0315z;
    }

    public final void run() {
        if (this.f2127b.f2105b != null) {
            this.f2127b.f2105b.stopLoading();
            this.f2127b.f2105b.destroy();
        }
        this.f2127b.f2104a.m1730a(this.f2127b.f2106c);
        if (this.f2127b.f2107d != null) {
            ((C0270v) this.f2127b.f2104a.m1742g().f2020k.m1850a()).m1800b(this.f2127b.f2107d);
        }
        this.f2127b.f2104a.m1728a(this.f2126a);
    }
}
