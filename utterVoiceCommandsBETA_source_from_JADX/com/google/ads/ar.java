package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.internal.C0270v;
import com.google.ads.internal.state.AdState;
import com.google.ads.util.C0236z;
import com.google.ads.util.ab;
import com.google.ads.util.ac;
import com.google.ads.util.ad;

public final class ar extends C0236z {
    public final ab<ap> f2010a;
    public final ac<AdState> f2011b = new ac(this, "currentAd", null);
    public final ac<AdState> f2012c = new ac(this, "nextAd", null);
    public final ab<String> f2013d;
    public final ad<Activity> f2014e;
    public final ab<Context> f2015f;
    public final ab<ViewGroup> f2016g;
    public final ab<C0226a> f2017h;
    public final ab<AdView> f2018i;
    public final ab<C0247i> f2019j;
    public final ab<C0270v> f2020k;
    public final ac<C0245g[]> f2021l;
    public final ac<C0241c> f2022m = new ac(this, "adListener");
    public final ac<C0246h> f2023n = new ac(this, "appEventListener");

    public ar(ap apVar, C0226a c0226a, AdView adView, C0247i c0247i, String str, Activity activity, Context context, ViewGroup viewGroup, C0270v c0270v) {
        this.f2010a = new ab(this, "appState", apVar);
        this.f2017h = new ab(this, "ad", c0226a);
        this.f2018i = new ab(this, "adView", adView);
        this.f2020k = new ab(this, "adType", c0270v);
        this.f2013d = new ab(this, "adUnitId", str);
        this.f2014e = new ad(this, "activity", activity);
        this.f2019j = new ab(this, "interstitialAd", c0247i);
        this.f2016g = new ab(this, "bannerContainer", viewGroup);
        this.f2015f = new ab(this, "applicationContext", context);
        this.f2021l = new ac(this, "adSizes", null);
    }

    public final boolean m1626a() {
        return !m1627b();
    }

    public final boolean m1627b() {
        return ((C0270v) this.f2020k.m1850a()).m1798a();
    }
}
