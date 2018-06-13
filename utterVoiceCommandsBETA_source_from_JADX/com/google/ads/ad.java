package com.google.ads;

import android.app.Activity;
import com.google.ads.util.C0288b;
import com.google.ads.util.C0290d;
import java.util.HashMap;
import java.util.List;

final class ad implements Runnable {
    final /* synthetic */ C0315z f1946a;
    final /* synthetic */ C0237d f1947b;
    final /* synthetic */ ac f1948c;

    ad(ac acVar, C0315z c0315z, C0237d c0237d) {
        this.f1948c = acVar;
        this.f1946a = c0315z;
        this.f1947b = c0237d;
    }

    public final void run() {
        ac acVar = this.f1948c;
        C0315z c0315z = this.f1946a;
        C0237d c0237d = this.f1947b;
        synchronized (acVar.f1941c) {
            C0288b.m1855a(Thread.currentThread(), acVar.f1940b);
        }
        List<C0275j> f = c0315z.m1893f();
        long b = c0315z.m1888a() ? (long) c0315z.m1889b() : 10000;
        loop0:
        for (C0275j c0275j : f) {
            C0290d.m1862a("Looking to fetch ads from network: " + c0275j.f2220b);
            List<String> list = c0275j.f2221c;
            HashMap hashMap = c0275j.f2223e;
            List list2 = c0275j.f2222d;
            String str = c0275j.f2219a;
            String str2 = c0275j.f2220b;
            String c = c0315z.m1890c();
            if (list2 == null) {
                list2 = c0315z.m1894g();
            }
            ag agVar = new ag(str, str2, c, list2, c0315z.m1895h(), c0315z.m1896i());
            for (String str22 : list) {
                Activity activity = (Activity) acVar.f1939a.m1742g().f2014e.m1853a();
                if (activity != null) {
                    acVar.f1939a.m1747l().m1773c();
                    if (!acVar.m1610a(str22, activity, c0237d, agVar, hashMap, b)) {
                        if (acVar.m1608a()) {
                            C0290d.m1862a("GWController.destroy() called. Terminating mediation thread.");
                            break loop0;
                        }
                    }
                    break loop0;
                }
                C0290d.m1862a("Activity is null while mediating.  Terminating mediation thread.");
                break loop0;
            }
        }
        acVar.f1939a.m1729a(new ae(acVar, c0315z));
        synchronized (this.f1948c.f1941c) {
            this.f1948c.f1940b = null;
        }
    }
}
