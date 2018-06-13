package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.internal.C0270v;
import com.google.ads.p028a.C0230b;
import com.google.ads.util.C0288b;
import java.util.HashMap;

public final class aj {
    final C0270v f1968a;
    C0230b<?, ?> f1969b = null;
    private final ag f1970c;
    private boolean f1971d = false;
    private boolean f1972e = false;
    private ai f1973f = null;
    private final ac f1974g;
    private boolean f1975h = false;
    private boolean f1976i = false;
    private View f1977j = null;
    private final Handler f1978k = new Handler(Looper.getMainLooper());
    private final String f1979l;
    private final C0237d f1980m;
    private final HashMap<String, String> f1981n;

    public aj(ac acVar, C0270v c0270v, ag agVar, String str, C0237d c0237d, HashMap<String, String> hashMap) {
        C0288b.m1857a(TextUtils.isEmpty(str));
        this.f1974g = acVar;
        this.f1968a = c0270v;
        this.f1970c = agVar;
        this.f1979l = str;
        this.f1980m = c0237d;
        this.f1981n = hashMap;
    }

    public final synchronized void m1612a() {
        C0288b.m1858a(this.f1975h, "destroy() called but startLoadAdTask has not been called.");
        this.f1978k.post(new ak(this));
    }

    public final synchronized void m1613a(Activity activity) {
        C0288b.m1859b(this.f1975h, "startLoadAdTask has already been called.");
        this.f1975h = true;
        this.f1978k.post(new al(this, activity, this.f1979l, this.f1980m, this.f1981n));
    }

    final synchronized void m1614a(C0230b<?, ?> c0230b) {
        this.f1969b = c0230b;
    }

    final synchronized void m1615a(ai aiVar) {
        this.f1972e = false;
        this.f1971d = true;
        this.f1973f = aiVar;
        notify();
    }

    public final synchronized boolean m1616b() {
        return this.f1971d;
    }

    public final synchronized boolean m1617c() {
        C0288b.m1858a(this.f1971d, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
        return this.f1972e;
    }

    public final synchronized ai m1618d() {
        return this.f1973f == null ? ai.TIMEOUT : this.f1973f;
    }

    public final synchronized View m1619e() {
        C0288b.m1858a(this.f1971d, "getAdView() called when isLoadAdTaskDone() is false.");
        return this.f1977j;
    }

    public final synchronized String m1620f() {
        return this.f1969b != null ? this.f1969b.getClass().getName() : "\"adapter was not created.\"";
    }

    final synchronized void m1621g() {
        this.f1976i = true;
    }

    final synchronized boolean m1622h() {
        return this.f1976i;
    }
}
