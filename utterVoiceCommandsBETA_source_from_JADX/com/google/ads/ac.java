package com.google.ads;

import android.app.Activity;
import android.os.SystemClock;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0270v;
import com.google.ads.util.C0288b;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public final class ac {
    final C0264p f1939a;
    public Thread f1940b;
    public Object f1941c;
    public boolean f1942d;
    public Object f1943e;
    private aj f1944f;
    private Object f1945g;

    protected ac() {
        this.f1944f = null;
        this.f1945g = new Object();
        this.f1940b = null;
        this.f1941c = new Object();
        this.f1942d = false;
        this.f1943e = new Object();
        this.f1939a = null;
    }

    public ac(C0264p c0264p) {
        this.f1944f = null;
        this.f1945g = new Object();
        this.f1940b = null;
        this.f1941c = new Object();
        this.f1942d = false;
        this.f1943e = new Object();
        C0288b.m1854a((Object) c0264p);
        this.f1939a = c0264p;
    }

    private boolean m1606b() {
        boolean z;
        synchronized (this.f1941c) {
            z = this.f1940b != null;
        }
        return z;
    }

    public final void m1607a(C0315z c0315z, C0237d c0237d) {
        synchronized (this.f1941c) {
            if (m1606b()) {
                C0290d.m1867c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
                return;
            }
            C0264p c0264p = this.f1939a;
            if (c0315z.m1897j() != null) {
                if (!c0264p.m1742g().m1627b()) {
                    C0245g b = ((C0270v) c0264p.m1742g().f2020k.m1850a()).m1799b();
                    if (c0315z.m1897j().m1798a()) {
                        C0290d.m1871e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + b + ") in the ad-type field in the mediation UI.");
                    } else {
                        C0245g b2 = c0315z.m1897j().m1799b();
                        if (b2 != b) {
                            C0290d.m1871e("Mediation server returned ad size: '" + b2 + "', while the AdView was created with ad size: '" + b + "'. Using the ad-size passed to the AdView on creation.");
                        }
                    }
                } else if (!c0315z.m1897j().m1798a()) {
                    C0290d.m1871e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
                }
            }
            this.f1940b = new Thread(new ad(this, c0315z, c0237d));
            this.f1940b.start();
        }
    }

    final boolean m1608a() {
        boolean z;
        synchronized (this.f1943e) {
            z = this.f1942d;
        }
        return z;
    }

    final boolean m1609a(aj ajVar) {
        boolean z;
        synchronized (this.f1943e) {
            if (m1608a()) {
                ajVar.m1612a();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    final boolean m1610a(String str, Activity activity, C0237d c0237d, ag agVar, HashMap<String, String> hashMap, long j) {
        aj ajVar = new aj(this, (C0270v) this.f1939a.m1742g().f2020k.m1850a(), agVar, str, c0237d, hashMap);
        synchronized (ajVar) {
            ajVar.m1613a(activity);
            while (!ajVar.m1616b() && j > 0) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ajVar.wait(j);
                    j -= SystemClock.elapsedRealtime() - elapsedRealtime;
                } catch (InterruptedException e) {
                    C0290d.m1862a("Interrupted while waiting for ad network to load ad using adapter class: " + str);
                }
            }
            this.f1939a.m1747l().m1770a(ajVar.m1618d());
            if (ajVar.m1616b() && ajVar.m1617c()) {
                this.f1939a.m1729a(new af(this, ajVar, this.f1939a.m1742g().m1627b() ? null : ajVar.m1619e(), agVar));
                return true;
            }
            ajVar.m1612a();
            return false;
        }
    }

    public final void m1611b(aj ajVar) {
        synchronized (this.f1945g) {
            if (this.f1944f != ajVar) {
                if (this.f1944f != null) {
                    this.f1944f.m1612a();
                }
                this.f1944f = ajVar;
            }
        }
    }
}
