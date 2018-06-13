package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.AdActivity;
import com.google.ads.AdView;
import com.google.ads.C0226a;
import com.google.ads.C0237d;
import com.google.ads.C0241c;
import com.google.ads.C0243e;
import com.google.ads.C0245g;
import com.google.ads.C0246h;
import com.google.ads.C0247i;
import com.google.ads.C0278m;
import com.google.ads.C0279n;
import com.google.ads.C0281p;
import com.google.ads.C0314y;
import com.google.ads.C0315z;
import com.google.ads.ab;
import com.google.ads.ac;
import com.google.ads.ag;
import com.google.ads.aj;
import com.google.ads.ap;
import com.google.ads.aq;
import com.google.ads.ar;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class C0264p {
    private static final Object f2152a = new Object();
    private final ar f2153b;
    private C0256h f2154c = null;
    private C0237d f2155d = null;
    private C0269u f2156e = new C0269u();
    private AdWebView f2157f;
    private C0271w f2158g;
    private Handler f2159h = new Handler();
    private long f2160i;
    private boolean f2161j;
    private boolean f2162k = false;
    private boolean f2163l = false;
    private boolean f2164m = true;
    private boolean f2165n = false;
    private SharedPreferences f2166o;
    private long f2167p = 60000;
    private C0279n f2168q;
    private boolean f2169r = false;
    private LinkedList<String> f2170s;
    private LinkedList<String> f2171t;
    private int f2172u = -1;
    private Boolean f2173v;
    private ab f2174w;
    private ac f2175x;
    private ag f2176y;
    private String f2177z = null;

    public C0264p(C0226a c0226a, Activity activity, C0245g c0245g, String str, ViewGroup viewGroup) {
        if (activity == null) {
            this.f2153b = new ar(ap.m1625a(), c0226a, c0226a instanceof AdView ? (AdView) c0226a : null, c0226a instanceof C0247i ? (C0247i) c0226a : null, str, null, null, viewGroup, c0245g == null ? C0270v.f2203a : C0270v.m1796a(c0245g));
            return;
        }
        synchronized (f2152a) {
            this.f2166o = activity.getApplicationContext().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
            this.f2160i = 60000;
        }
        this.f2153b = new ar(ap.m1625a(), c0226a, c0226a instanceof AdView ? (AdView) c0226a : null, c0226a instanceof C0247i ? (C0247i) c0226a : null, str, activity, activity.getApplicationContext(), viewGroup, c0245g == null ? C0270v.f2203a : C0270v.m1797a(c0245g, activity.getApplicationContext()));
        this.f2168q = new C0279n(this);
        this.f2170s = new LinkedList();
        this.f2171t = new LinkedList();
        m1721a();
        AdUtil.m1848h((Context) this.f2153b.f2015f.m1850a());
        this.f2174w = new ab();
        this.f2175x = new ac(this);
        this.f2173v = null;
        this.f2176y = null;
    }

    private synchronized void m1715A() {
        Activity activity = (Activity) this.f2153b.f2014e.m1853a();
        if (activity == null) {
            C0290d.m1871e("activity was null while trying to ping click tracking URLs.");
        } else {
            Iterator it = this.f2171t.iterator();
            while (it.hasNext()) {
                new Thread(new C0278m((String) it.next(), activity.getApplicationContext())).start();
            }
        }
    }

    private void m1716a(View view) {
        ((ViewGroup) this.f2153b.f2016g.m1850a()).removeAllViews();
        ((ViewGroup) this.f2153b.f2016g.m1850a()).addView(view);
    }

    private void m1717a(List<String> list, String str, String str2, String str3, Boolean bool, String str4, String str5) {
        String a = AdUtil.m1822a((Context) this.f2153b.f2015f.m1850a());
        C0314y a2 = C0314y.m1881a();
        String bigInteger = a2.m1883b().toString();
        String bigInteger2 = a2.m1884c().toString();
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll.replaceAll("@gw_adlocid@", (String) this.f2153b.f2013d.m1850a()).replaceAll("@gw_qdata@", str3).replaceAll("@gw_sdkver@", "afma-sdk-a-v6.2.1").replaceAll("@gw_sessid@", bigInteger).replaceAll("@gw_seqnum@", bigInteger2).replaceAll("@gw_devid@", a);
            if (str2 != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", str2);
            }
            if (str != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_allocid@", str);
            }
            if (str4 != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adt@", str4);
            }
            if (str5 != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_aec@", str5);
            }
            if (bool != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetrefresh@", bool.booleanValue() ? "1" : QueryParamConst.U_VALUE);
            }
            new Thread(new C0278m(replaceAll2, (Context) this.f2153b.f2015f.m1850a())).start();
        }
        this.f2156e.m1772b();
    }

    private synchronized boolean m1718x() {
        return this.f2154c != null;
    }

    private synchronized void m1719y() {
        Activity activity = (Activity) this.f2153b.f2014e.m1853a();
        if (activity == null) {
            C0290d.m1871e("activity was null while trying to ping tracking URLs.");
        } else {
            Iterator it = this.f2170s.iterator();
            while (it.hasNext()) {
                new Thread(new C0278m((String) it.next(), activity.getApplicationContext())).start();
            }
        }
    }

    private synchronized void m1720z() {
        if (this.f2154c != null) {
            this.f2154c.m1698a();
            this.f2154c = null;
        }
        if (this.f2157f != null) {
            this.f2157f.stopLoading();
        }
    }

    public final synchronized void m1721a() {
        this.f2157f = new AdWebView(this.f2153b, ((C0270v) this.f2153b.f2020k.m1850a()).m1799b());
        this.f2157f.setVisibility(8);
        this.f2158g = C0271w.m1801a(this, C0250c.f2101c, true, this.f2153b.m1627b());
        this.f2157f.setWebViewClient(this.f2158g);
        if (AdUtil.f2240a < ((Integer) ((aq) ((ap) this.f2153b.f2010a.m1850a()).f1997a.m1850a()).f1998a.m1851a()).intValue() && !((C0270v) this.f2153b.f2020k.m1850a()).m1798a()) {
            C0290d.m1862a("Disabling hardware acceleration for a banner.");
            this.f2157f.m1674b();
        }
    }

    public final synchronized void m1722a(float f) {
        long j = this.f2167p;
        this.f2167p = (long) (1000.0f * f);
        if (m1751p() && this.f2167p != j) {
            m1740e();
            m1741f();
        }
    }

    public final synchronized void m1723a(int i) {
        this.f2172u = i;
    }

    public final void m1724a(long j) {
        synchronized (f2152a) {
            Editor edit = this.f2166o.edit();
            edit.putLong("Timeout" + this.f2153b.f2013d, j);
            edit.commit();
            if (this.f2169r) {
                this.f2160i = j;
            }
        }
    }

    public final synchronized void m1725a(View view, aj ajVar, ag agVar) {
        C0290d.m1862a("AdManager.onReceiveGWhirlAd() called.");
        this.f2162k = true;
        this.f2176y = agVar;
        if (this.f2153b.m1626a()) {
            m1716a(view);
            Boolean valueOf = Boolean.valueOf(false);
            List list = agVar.f1958d;
            if (list == null) {
                list = new ArrayList();
                list.add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
            }
            String str = agVar.f1956b;
            m1717a(list, agVar.f1955a, str, agVar.f1957c, valueOf, this.f2156e.m1774d(), this.f2156e.m1775e());
        }
        this.f2175x.m1611b(ajVar);
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }

    public final synchronized void m1726a(C0237d c0237d) {
        if (m1718x()) {
            C0290d.m1871e("loadAd called while the ad is already loading, so aborting.");
        } else if (AdActivity.m1571c()) {
            C0290d.m1871e("loadAd called while an interstitial or landing page is displayed, so aborting");
        } else if (AdUtil.m1842c((Context) this.f2153b.f2015f.m1850a()) && AdUtil.m1839b((Context) this.f2153b.f2015f.m1850a())) {
            if (C0281p.m1815a((Context) this.f2153b.f2015f.m1850a(), this.f2166o.getLong("GoogleAdMobDoritosLife", 60000))) {
                C0281p.m1811a((Activity) this.f2153b.f2014e.m1853a());
            }
            this.f2162k = false;
            this.f2170s.clear();
            this.f2155d = c0237d;
            ab abVar = this.f2174w;
            Object obj = (abVar.f1937a == null || SystemClock.elapsedRealtime() >= abVar.f1938b) ? null : 1;
            if (obj != null) {
                this.f2175x.m1607a(this.f2174w.f1937a, c0237d);
            } else {
                this.f2154c = new C0256h(this);
                this.f2154c.m1700a(c0237d);
            }
        }
    }

    public final synchronized void m1727a(C0243e c0243e) {
        this.f2154c = null;
        if (c0243e == C0243e.NETWORK_ERROR) {
            m1722a(60.0f);
            if (!m1751p()) {
                m1741f();
                this.f2165n = true;
            }
        }
        if (this.f2153b.m1627b()) {
            if (c0243e == C0243e.NO_FILL) {
                this.f2156e.m1766B();
            } else if (c0243e == C0243e.NETWORK_ERROR) {
                this.f2156e.m1795z();
            }
        }
        C0290d.m1867c("onFailedToReceiveAd(" + c0243e + ")");
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }

    public final synchronized void m1728a(C0315z c0315z) {
        this.f2154c = null;
        if (c0315z.m1891d()) {
            m1722a((float) c0315z.m1892e());
            if (!this.f2163l) {
                m1741f();
            }
        } else if (this.f2163l) {
            m1740e();
        }
        this.f2175x.m1607a(c0315z, this.f2155d);
    }

    public final void m1729a(Runnable runnable) {
        this.f2159h.post(runnable);
    }

    public final void m1730a(String str) {
        Uri build = new Builder().encodedQuery(str).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map b = AdUtil.m1837b(build);
        for (String str2 : b.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) b.get(str2)).append("\n");
        }
        this.f2177z = stringBuilder.toString().trim();
        if (TextUtils.isEmpty(this.f2177z)) {
            this.f2177z = null;
        }
    }

    protected final synchronized void m1731a(LinkedList<String> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C0290d.m1862a("Adding a click tracking URL: " + ((String) it.next()));
        }
        this.f2171t = linkedList;
    }

    public final synchronized void m1732a(boolean z) {
        this.f2161j = z;
    }

    public final synchronized void m1733b() {
        if (this.f2175x != null) {
            ac acVar = this.f2175x;
            synchronized (acVar.f1943e) {
                acVar.f1942d = true;
                acVar.m1611b(null);
                synchronized (acVar.f1941c) {
                    if (acVar.f1940b != null) {
                        acVar.f1940b.interrupt();
                    }
                }
            }
        }
        this.f2153b.f2022m.m1852a(null);
        this.f2153b.f2023n.m1852a(null);
        m1720z();
        if (this.f2157f != null) {
            this.f2157f.destroy();
        }
    }

    public final synchronized void m1734b(long j) {
        if (j > 0) {
            this.f2166o.edit().putLong("GoogleAdMobDoritosLife", j).commit();
        }
    }

    public final synchronized void m1735b(C0315z c0315z) {
        C0290d.m1862a("AdManager.onGWhirlNoFill() called.");
        List i = c0315z.m1896i();
        String c = c0315z.m1890c();
        if (i == null) {
            i = new ArrayList();
            i.add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
        }
        m1717a(i, null, null, c, null, this.f2156e.m1774d(), this.f2156e.m1775e());
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
            C0243e c0243e = C0243e.NO_FILL;
        }
    }

    protected final synchronized void m1736b(String str) {
        C0290d.m1862a("Adding a tracking URL: " + str);
        this.f2170s.add(str);
    }

    public final void m1737b(boolean z) {
        this.f2173v = Boolean.valueOf(z);
    }

    public final String m1738c() {
        return this.f2177z;
    }

    public final synchronized void m1739d() {
        this.f2164m = false;
        C0290d.m1862a("Refreshing is no longer allowed on this AdView.");
    }

    public final synchronized void m1740e() {
        if (this.f2163l) {
            C0290d.m1862a("Disabling refreshing.");
            this.f2159h.removeCallbacks(this.f2168q);
            this.f2163l = false;
        } else {
            C0290d.m1862a("Refreshing is already disabled.");
        }
    }

    public final synchronized void m1741f() {
        this.f2165n = false;
        if (!this.f2153b.m1626a()) {
            C0290d.m1862a("Tried to enable refreshing on something other than an AdView.");
        } else if (!this.f2164m) {
            C0290d.m1862a("Refreshing disabled on this AdView");
        } else if (this.f2163l) {
            C0290d.m1862a("Refreshing is already enabled.");
        } else {
            C0290d.m1862a("Enabling refreshing every " + this.f2167p + " milliseconds.");
            this.f2159h.postDelayed(this.f2168q, this.f2167p);
            this.f2163l = true;
        }
    }

    public final ar m1742g() {
        return this.f2153b;
    }

    public final synchronized ab m1743h() {
        return this.f2174w;
    }

    public final synchronized C0256h m1744i() {
        return this.f2154c;
    }

    public final synchronized AdWebView m1745j() {
        return this.f2157f;
    }

    public final synchronized C0271w m1746k() {
        return this.f2158g;
    }

    public final C0269u m1747l() {
        return this.f2156e;
    }

    public final synchronized int m1748m() {
        return this.f2172u;
    }

    public final long m1749n() {
        return this.f2160i;
    }

    public final synchronized boolean m1750o() {
        return this.f2161j;
    }

    public final synchronized boolean m1751p() {
        return this.f2163l;
    }

    public final synchronized void m1752q() {
        this.f2156e.m1767C();
        C0290d.m1867c("onDismissScreen()");
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }

    public final synchronized void m1753r() {
        C0290d.m1867c("onPresentScreen()");
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }

    public final synchronized void m1754s() {
        C0290d.m1867c("onLeaveApplication()");
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }

    public final synchronized void m1755t() {
        if (((C0246h) this.f2153b.f2023n.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }

    public final void m1756u() {
        this.f2156e.m1776f();
        m1715A();
    }

    public final synchronized void m1757v() {
        if (this.f2155d == null) {
            C0290d.m1862a("Tried to refresh before calling loadAd().");
        } else if (this.f2153b.m1626a()) {
            if (((AdView) this.f2153b.f2018i.m1850a()).isShown() && AdUtil.m1844d()) {
                C0290d.m1867c("Refreshing ad.");
                m1726a(this.f2155d);
            } else {
                C0290d.m1862a("Not refreshing because the ad is not visible.");
            }
            if (this.f2165n) {
                m1740e();
            } else {
                this.f2159h.postDelayed(this.f2168q, this.f2167p);
            }
        } else {
            C0290d.m1862a("Tried to refresh an ad that wasn't an AdView.");
        }
    }

    protected final synchronized void m1758w() {
        this.f2154c = null;
        this.f2162k = true;
        this.f2157f.setVisibility(0);
        if (this.f2153b.m1626a()) {
            m1716a(this.f2157f);
        }
        this.f2156e.m1777g();
        if (this.f2153b.m1626a()) {
            m1719y();
        }
        C0290d.m1867c("onReceiveAd()");
        if (((C0241c) this.f2153b.f2022m.m1851a()) != null) {
            this.f2153b.f2017h.m1850a();
        }
    }
}
