package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.C0243e;
import com.google.ads.C0245g;
import com.google.ads.C0314y;
import com.google.ads.ap;
import com.google.ads.aq;
import com.google.ads.p030b.C0238a;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.ispeech.core.InternalResources;

public final class C0256h implements Runnable {
    C0264p f2104a;
    WebView f2105b;
    String f2106c;
    C0245g f2107d;
    boolean f2108e;
    private String f2109f;
    private String f2110g;
    private String f2111h;
    private String f2112i;
    private boolean f2113j;
    private C0266r f2114k;
    private C0237d f2115l;
    private String f2116m;
    private LinkedList<String> f2117n;
    private volatile boolean f2118o;
    private boolean f2119p;
    private C0243e f2120q;
    private boolean f2121r;
    private int f2122s;
    private Thread f2123t;
    private boolean f2124u;
    private C0262n f2125v = C0262n.ONLINE_SERVER_REQUEST;

    protected C0256h() {
    }

    public C0256h(C0264p c0264p) {
        this.f2104a = c0264p;
        this.f2116m = null;
        this.f2109f = null;
        this.f2110g = null;
        this.f2111h = null;
        this.f2117n = new LinkedList();
        this.f2120q = null;
        this.f2121r = false;
        this.f2122s = -1;
        this.f2113j = false;
        this.f2119p = false;
        this.f2106c = null;
        this.f2107d = null;
        if (((Activity) c0264p.m1742g().f2014e.m1853a()) != null) {
            this.f2105b = new AdWebView(c0264p.m1742g(), null);
            this.f2105b.setWebViewClient(C0271w.m1801a(c0264p, C0250c.f2100b, false, false));
            this.f2105b.setVisibility(8);
            this.f2105b.setWillNotDraw(true);
            this.f2114k = new C0266r(this, c0264p);
            return;
        }
        this.f2105b = null;
        this.f2114k = null;
        C0290d.m1871e("activity was null while trying to create an AdLoader.");
    }

    private String m1695a(Map<String, Object> map, Activity activity) {
        int i = 0;
        Context applicationContext = activity.getApplicationContext();
        C0269u l = this.f2104a.m1747l();
        long m = l.m1783m();
        if (m > 0) {
            map.put("prl", Long.valueOf(m));
        }
        m = l.m1784n();
        if (m > 0) {
            map.put("prnl", Long.valueOf(m));
        }
        String l2 = l.m1782l();
        if (l2 != null) {
            map.put("ppcl", l2);
        }
        l2 = l.m1781k();
        if (l2 != null) {
            map.put("pcl", l2);
        }
        m = l.m1780j();
        if (m > 0) {
            map.put("pcc", Long.valueOf(m));
        }
        map.put("preqs", Long.valueOf(C0269u.m1764o()));
        map.put("oar", Long.valueOf(l.m1785p()));
        map.put("bas_on", Long.valueOf(l.m1788s()));
        map.put("bas_off", Long.valueOf(l.m1791v()));
        if (l.m1794y()) {
            map.put("aoi_timeout", "true");
        }
        if (l.m1765A()) {
            map.put("aoi_nofill", "true");
        }
        l2 = l.m1768D();
        if (l2 != null) {
            map.put("pit", l2);
        }
        map.put("ptime", Long.valueOf(C0269u.m1763E()));
        l.m1769a();
        l.m1779i();
        if (this.f2104a.m1742g().m1627b()) {
            map.put("format", "interstitial_mb");
        } else {
            C0245g b = ((C0270v) this.f2104a.m1742g().f2020k.m1850a()).m1799b();
            if (b.m1663c()) {
                map.put("smart_w", "full");
            }
            if (b.m1664d()) {
                map.put("smart_h", "auto");
            }
            if (b.m1665e()) {
                Map hashMap = new HashMap();
                hashMap.put(InternalResources.ISPEECH_SCREEN_AD_WIDTH, Integer.valueOf(b.m1661a()));
                hashMap.put(InternalResources.ISPEECH_SCREEN_AD_HEIGHT, Integer.valueOf(b.m1662b()));
                map.put("ad_frame", hashMap);
            } else {
                map.put("format", b.toString());
            }
        }
        map.put("slotname", this.f2104a.m1742g().f2013d.m1850a());
        map.put("js", "afma-sdk-a-v6.2.1");
        try {
            int i2;
            int i3 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
            CharSequence f = AdUtil.m1846f(applicationContext);
            if (!TextUtils.isEmpty(f)) {
                map.put("mv", f);
            }
            map.put("msid", applicationContext.getPackageName());
            map.put("app_name", i3 + ".android." + applicationContext.getPackageName());
            map.put("isu", AdUtil.m1822a(applicationContext));
            Object d = AdUtil.m1843d(applicationContext);
            l2 = "net";
            if (d == null) {
                d = "null";
            }
            map.put(l2, d);
            String e = AdUtil.m1845e(applicationContext);
            if (!(e == null || e.length() == 0)) {
                map.put("cap", e);
            }
            map.put("u_audio", Integer.valueOf(AdUtil.m1847g(applicationContext).ordinal()));
            DisplayMetrics a = AdUtil.m1821a(activity);
            map.put("u_sd", Float.valueOf(a.density));
            map.put("u_h", Integer.valueOf(AdUtil.m1820a(applicationContext, a)));
            map.put("u_w", Integer.valueOf(AdUtil.m1835b(applicationContext, a)));
            map.put(QueryParamConst.HL_NAME, Locale.getDefault().getLanguage());
            if (!(this.f2104a.m1742g().f2018i == null || this.f2104a.m1742g().f2018i.m1850a() == null)) {
                AdView adView = (AdView) this.f2104a.m1742g().f2018i.m1850a();
                if (adView.getParent() != null) {
                    int[] iArr = new int[2];
                    adView.getLocationOnScreen(iArr);
                    i2 = iArr[0];
                    int i4 = iArr[1];
                    DisplayMetrics displayMetrics = ((Context) this.f2104a.m1742g().f2015f.m1850a()).getResources().getDisplayMetrics();
                    int i5 = (!adView.isShown() || adView.getWidth() + i2 <= 0 || adView.getHeight() + i4 <= 0 || i2 > displayMetrics.widthPixels || i4 > displayMetrics.heightPixels) ? 0 : 1;
                    Map hashMap2 = new HashMap();
                    hashMap2.put("x", Integer.valueOf(i2));
                    hashMap2.put("y", Integer.valueOf(i4));
                    hashMap2.put("width", Integer.valueOf(adView.getWidth()));
                    hashMap2.put("height", Integer.valueOf(adView.getHeight()));
                    hashMap2.put("visible", Integer.valueOf(i5));
                    map.put("ad_pos", hashMap2);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            C0245g[] c0245gArr = (C0245g[]) this.f2104a.m1742g().f2021l.m1851a();
            if (c0245gArr != null) {
                i2 = c0245gArr.length;
                while (i < i2) {
                    C0245g c0245g = c0245gArr[i];
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(c0245g.m1661a() + "x" + c0245g.m1662b());
                    i++;
                }
                map.put("sz", stringBuilder.toString());
            }
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            map.put("carrier", telephonyManager.getNetworkOperator());
            map.put("gnt", Integer.valueOf(telephonyManager.getNetworkType()));
            if (AdUtil.m1841c()) {
                map.put("simulator", Integer.valueOf(1));
            }
            map.put("session_id", C0314y.m1881a().m1883b().toString());
            map.put("seq_num", C0314y.m1881a().m1884c().toString());
            String a2 = AdUtil.m1826a((Map) map);
            if (((Boolean) ((aq) ((ap) this.f2104a.m1742g().f2010a.m1850a()).f1997a.m1850a()).f2009l.m1851a()).booleanValue()) {
                stringBuilder = new StringBuilder();
                e = m1697d();
            } else {
                stringBuilder = new StringBuilder().append(m1697d());
                C0237d c0237d = this.f2115l;
                e = "AFMA_getSdkConstants();";
            }
            StringBuilder append = stringBuilder.append(e);
            C0237d c0237d2 = this.f2115l;
            append = append.append("AFMA_buildAdURL(").append(a2).append(");");
            c0237d2 = this.f2115l;
            e = append.append("</script></head><body></body></html>").toString();
            C0290d.m1867c("adRequestUrlHtml: " + e);
            return e;
        } catch (NameNotFoundException e2) {
            throw new C0260l(this, "NameNotFoundException");
        }
    }

    private void m1696a(C0243e c0243e, boolean z) {
        this.f2104a.m1729a(new C0259k(this.f2104a, this.f2105b, this.f2114k, c0243e, z));
    }

    private String m1697d() {
        return this.f2115l instanceof C0238a ? "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>" : "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
    }

    protected final void m1698a() {
        C0290d.m1862a("AdLoader cancelled.");
        if (this.f2105b != null) {
            this.f2105b.stopLoading();
            this.f2105b.destroy();
        }
        if (this.f2123t != null) {
            this.f2123t.interrupt();
            this.f2123t = null;
        }
        if (this.f2114k != null) {
            this.f2114k.f2180a = true;
        }
        this.f2118o = true;
    }

    public final synchronized void m1699a(int i) {
        this.f2122s = i;
    }

    protected final void m1700a(C0237d c0237d) {
        this.f2115l = c0237d;
        this.f2118o = false;
        this.f2123t = new Thread(this);
        this.f2123t.start();
    }

    public final synchronized void m1701a(C0243e c0243e) {
        this.f2120q = c0243e;
        notify();
    }

    public final synchronized void m1702a(C0245g c0245g) {
        this.f2107d = c0245g;
    }

    public final synchronized void m1703a(C0262n c0262n) {
        this.f2125v = c0262n;
    }

    protected final synchronized void m1704a(String str) {
        this.f2117n.add(str);
    }

    protected final synchronized void m1705a(String str, String str2) {
        this.f2109f = str2;
        this.f2110g = str;
        notify();
    }

    protected final synchronized void m1706a(boolean z) {
        this.f2113j = z;
    }

    protected final synchronized void m1707b() {
        this.f2121r = true;
        notify();
    }

    protected final synchronized void m1708b(String str) {
        this.f2112i = str;
    }

    public final synchronized void m1709b(boolean z) {
        this.f2124u = z;
    }

    public final synchronized void m1710c() {
        this.f2119p = true;
    }

    protected final synchronized void m1711c(String str) {
        this.f2111h = str;
    }

    public final synchronized void m1712c(boolean z) {
        this.f2108e = z;
    }

    public final synchronized void m1713d(String str) {
        this.f2116m = str;
        notify();
    }

    public final synchronized void m1714e(String str) {
        this.f2106c = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r11 = this;
        r9 = 0;
        monitor-enter(r11);
        r0 = r11.f2105b;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r11.f2114k;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x0018;
    L_0x000b:
        r0 = "adRequestWebView was null while trying to load an ad.";
        com.google.ads.util.C0290d.m1871e(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
    L_0x0017:
        return;
    L_0x0018:
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1742g();	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.f2014e;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1853a();	 Catch:{ Throwable -> 0x00eb }
        r0 = (android.app.Activity) r0;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x0038;
    L_0x0028:
        r0 = "activity was null while forming an ad request.";
        com.google.ads.util.C0290d.m1871e(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r11);
        throw r0;
    L_0x0038:
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r3 = r1.m1749n();	 Catch:{ Throwable -> 0x00eb }
        r5 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00eb }
        r2 = r11.f2115l;	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r1 = r1.m1742g();	 Catch:{ Throwable -> 0x00eb }
        r1 = r1.f2015f;	 Catch:{ Throwable -> 0x00eb }
        r1 = r1.m1850a();	 Catch:{ Throwable -> 0x00eb }
        r1 = (android.content.Context) r1;	 Catch:{ Throwable -> 0x00eb }
        r7 = r2.mo108a(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = "extras";
        r1 = r7.get(r1);	 Catch:{ Throwable -> 0x00eb }
        r2 = r1 instanceof java.util.Map;	 Catch:{ Throwable -> 0x00eb }
        if (r2 == 0) goto L_0x00aa;
    L_0x0060:
        r1 = (java.util.Map) r1;	 Catch:{ Throwable -> 0x00eb }
        r2 = "_adUrl";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x00eb }
        r8 = r2 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00eb }
        if (r8 == 0) goto L_0x0070;
    L_0x006c:
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00eb }
        r11.f2109f = r2;	 Catch:{ Throwable -> 0x00eb }
    L_0x0070:
        r2 = "_requestUrl";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x00eb }
        r8 = r2 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00eb }
        if (r8 == 0) goto L_0x007e;
    L_0x007a:
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00eb }
        r11.f2116m = r2;	 Catch:{ Throwable -> 0x00eb }
    L_0x007e:
        r2 = "_orientation";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x00eb }
        r8 = r2 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00eb }
        if (r8 == 0) goto L_0x0093;
    L_0x0088:
        r8 = "p";
        r8 = r2.equals(r8);	 Catch:{ Throwable -> 0x00eb }
        if (r8 == 0) goto L_0x00df;
    L_0x0090:
        r2 = 1;
        r11.f2122s = r2;	 Catch:{ Throwable -> 0x00eb }
    L_0x0093:
        r2 = "_norefresh";
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x00eb }
        r2 = r1 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00eb }
        if (r2 == 0) goto L_0x00aa;
    L_0x009d:
        r2 = "t";
        r1 = r1.equals(r2);	 Catch:{ Throwable -> 0x00eb }
        if (r1 == 0) goto L_0x00aa;
    L_0x00a5:
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r1.m1739d();	 Catch:{ Throwable -> 0x00eb }
    L_0x00aa:
        r1 = r11.f2109f;	 Catch:{ Throwable -> 0x00eb }
        if (r1 != 0) goto L_0x0239;
    L_0x00ae:
        r1 = r11.f2116m;	 Catch:{ Throwable -> 0x00eb }
        if (r1 != 0) goto L_0x0161;
    L_0x00b2:
        r1 = r11.m1695a(r7, r0);	 Catch:{ l -> 0x00fa }
        r0 = r11.f2115l;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0 instanceof com.google.ads.p030b.C0238a;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x0116;
    L_0x00bc:
        r0 = "http://www.gstatic.com/safa/";
    L_0x00be:
        r2 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r7 = new com.google.ads.internal.m;	 Catch:{ Throwable -> 0x00eb }
        r8 = r11.f2105b;	 Catch:{ Throwable -> 0x00eb }
        r7.<init>(r11, r8, r0, r1);	 Catch:{ Throwable -> 0x00eb }
        r2.m1729a(r7);	 Catch:{ Throwable -> 0x00eb }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00eb }
        r0 = r0 - r5;
        r0 = r3 - r0;
        r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x00d8;
    L_0x00d5:
        r11.wait(r0);	 Catch:{ InterruptedException -> 0x0119 }
    L_0x00d8:
        r0 = r11.f2118o;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x012f;
    L_0x00dc:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x00df:
        r8 = "l";
        r2 = r2.equals(r8);	 Catch:{ Throwable -> 0x00eb }
        if (r2 == 0) goto L_0x0093;
    L_0x00e7:
        r2 = 0;
        r11.f2122s = r2;	 Catch:{ Throwable -> 0x00eb }
        goto L_0x0093;
    L_0x00eb:
        r0 = move-exception;
        r1 = "An unknown error occurred in AdLoader.";
        com.google.ads.util.C0290d.m1866b(r1, r0);	 Catch:{ all -> 0x0035 }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ all -> 0x0035 }
        r1 = 1;
        r11.m1696a(r0, r1);	 Catch:{ all -> 0x0035 }
    L_0x00f7:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x00fa:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r2 = "Caught internal exception: ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00eb }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0116:
        r0 = "http://media.admob.com/";
        goto L_0x00be;
    L_0x0119:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r2 = "AdLoader InterruptedException while getting the URL: ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00eb }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1862a(r0);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x012f:
        r0 = r11.f2120q;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x013c;
    L_0x0133:
        r0 = r11.f2120q;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x013c:
        r0 = r11.f2116m;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x0161;
    L_0x0140:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r1 = "AdLoader timed out after ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00eb }
        r1 = "ms while getting the URL.";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0161:
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1747l();	 Catch:{ Throwable -> 0x00eb }
        r1 = com.google.ads.internal.C0258j.f2128a;	 Catch:{ Throwable -> 0x00eb }
        r2 = r11.f2125v;	 Catch:{ Throwable -> 0x00eb }
        r2 = r2.ordinal();	 Catch:{ Throwable -> 0x00eb }
        r1 = r1[r2];	 Catch:{ Throwable -> 0x00eb }
        switch(r1) {
            case 1: goto L_0x019f;
            case 2: goto L_0x01ae;
            case 3: goto L_0x01b7;
            case 4: goto L_0x01c3;
            default: goto L_0x0174;
        };	 Catch:{ Throwable -> 0x00eb }
    L_0x0174:
        r0 = r11.f2108e;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x0221;
    L_0x0178:
        r0 = "Not using loadUrl().";
        com.google.ads.util.C0290d.m1862a(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = r11.f2114k;	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2124u;	 Catch:{ Throwable -> 0x00eb }
        r0.f2181b = r1;	 Catch:{ Throwable -> 0x00eb }
        r0 = r11.f2114k;	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2116m;	 Catch:{ Throwable -> 0x00eb }
        r0.m1760a(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00eb }
        r0 = r0 - r5;
        r0 = r3 - r0;
        r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x0198;
    L_0x0195:
        r11.wait(r0);	 Catch:{ InterruptedException -> 0x01d9 }
    L_0x0198:
        r0 = r11.f2118o;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x01ef;
    L_0x019c:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x019f:
        r0.m1787r();	 Catch:{ Throwable -> 0x00eb }
        r0.m1790u();	 Catch:{ Throwable -> 0x00eb }
        r0.m1793x();	 Catch:{ Throwable -> 0x00eb }
        r0 = "Request scenario: Online server request.";
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x0174;
    L_0x01ae:
        r0.m1789t();	 Catch:{ Throwable -> 0x00eb }
        r0 = "Request scenario: Online using buffered ads.";
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x0174;
    L_0x01b7:
        r0.m1792w();	 Catch:{ Throwable -> 0x00eb }
        r0.m1786q();	 Catch:{ Throwable -> 0x00eb }
        r0 = "Request scenario: Offline using buffered ads.";
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x0174;
    L_0x01c3:
        r0.m1786q();	 Catch:{ Throwable -> 0x00eb }
        r0 = "Request scenario: Offline with no buffered ads.";
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = "Network is unavailable.  Aborting ad request.";
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x01d9:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r2 = "AdLoader InterruptedException while getting the ad server's response: ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00eb }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1862a(r0);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x01ef:
        r0 = r11.f2120q;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x01fc;
    L_0x01f3:
        r0 = r11.f2120q;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x01fc:
        r0 = r11.f2110g;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x0239;
    L_0x0200:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r1 = "AdLoader timed out after ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00eb }
        r1 = "ms while waiting for the ad server's response.";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0221:
        r0 = r11.f2116m;	 Catch:{ Throwable -> 0x00eb }
        r11.f2109f = r0;	 Catch:{ Throwable -> 0x00eb }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r1 = "Using loadUrl.  adBaseUrl: ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2109f;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1862a(r0);	 Catch:{ Throwable -> 0x00eb }
    L_0x0239:
        r0 = r11.f2108e;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x03bf;
    L_0x023d:
        r0 = r11.f2113j;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x0321;
    L_0x0241:
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r1 = 1;
        r0.m1737b(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r11.f2112i;	 Catch:{ JSONException -> 0x0288 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ JSONException -> 0x0288 }
        if (r0 == 0) goto L_0x025d;
    L_0x024f:
        r0 = "Got a mediation response with no content type. Aborting mediation.";
        com.google.ads.util.C0290d.m1865b(r0);	 Catch:{ JSONException -> 0x0288 }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ JSONException -> 0x0288 }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ JSONException -> 0x0288 }
    L_0x025a:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x025d:
        r0 = r11.f2112i;	 Catch:{ JSONException -> 0x0288 }
        r1 = "application/json";
        r0 = r0.startsWith(r1);	 Catch:{ JSONException -> 0x0288 }
        if (r0 != 0) goto L_0x0295;
    L_0x0267:
        r0 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0288 }
        r1 = "Got a mediation response with a content type: '";
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0288 }
        r1 = r11.f2112i;	 Catch:{ JSONException -> 0x0288 }
        r0 = r0.append(r1);	 Catch:{ JSONException -> 0x0288 }
        r1 = "'. Expected something starting with 'application/json'. Aborting mediation.";
        r0 = r0.append(r1);	 Catch:{ JSONException -> 0x0288 }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x0288 }
        com.google.ads.util.C0290d.m1865b(r0);	 Catch:{ JSONException -> 0x0288 }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ JSONException -> 0x0288 }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ JSONException -> 0x0288 }
        goto L_0x025a;
    L_0x0288:
        r0 = move-exception;
        r1 = "AdLoader can't parse gWhirl server configuration.";
        com.google.ads.util.C0290d.m1866b(r1, r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x025a;
    L_0x0295:
        r0 = r11.f2110g;	 Catch:{ JSONException -> 0x0288 }
        r1 = com.google.ads.C0315z.m1886a(r0);	 Catch:{ JSONException -> 0x0288 }
        r0 = r11.f2111h;	 Catch:{ JSONException -> 0x0288 }
        r2 = r11.f2104a;	 Catch:{ JSONException -> 0x0288 }
        r2 = r2.m1743h();	 Catch:{ JSONException -> 0x0288 }
        if (r0 == 0) goto L_0x02f5;
    L_0x02a5:
        r3 = "no-store";
        r3 = r0.contains(r3);	 Catch:{ JSONException -> 0x0288 }
        if (r3 != 0) goto L_0x02f5;
    L_0x02ad:
        r3 = "no-cache";
        r3 = r0.contains(r3);	 Catch:{ JSONException -> 0x0288 }
        if (r3 != 0) goto L_0x02f5;
    L_0x02b5:
        r3 = "max-age\\s*=\\s*(\\d+)";
        r3 = java.util.regex.Pattern.compile(r3);	 Catch:{ JSONException -> 0x0288 }
        r3 = r3.matcher(r0);	 Catch:{ JSONException -> 0x0288 }
        r4 = r3.find();	 Catch:{ JSONException -> 0x0288 }
        if (r4 == 0) goto L_0x0308;
    L_0x02c5:
        r0 = 1;
        r0 = r3.group(r0);	 Catch:{ NumberFormatException -> 0x0301 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0301 }
        r2.f1937a = r1;	 Catch:{ NumberFormatException -> 0x0301 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x0301 }
        r4 = (long) r0;	 Catch:{ NumberFormatException -> 0x0301 }
        r6 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ NumberFormatException -> 0x0301 }
        r3 = r3.convert(r4, r6);	 Catch:{ NumberFormatException -> 0x0301 }
        r5 = android.os.SystemClock.elapsedRealtime();	 Catch:{ NumberFormatException -> 0x0301 }
        r3 = r3 + r5;
        r2.f1938b = r3;	 Catch:{ NumberFormatException -> 0x0301 }
        r2 = java.util.Locale.US;	 Catch:{ NumberFormatException -> 0x0301 }
        r3 = "Caching gWhirl configuration for: %d seconds";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ NumberFormatException -> 0x0301 }
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0301 }
        r4[r5] = r0;	 Catch:{ NumberFormatException -> 0x0301 }
        r0 = java.lang.String.format(r2, r3, r4);	 Catch:{ NumberFormatException -> 0x0301 }
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ NumberFormatException -> 0x0301 }
    L_0x02f5:
        r0 = r11.f2104a;	 Catch:{ JSONException -> 0x0288 }
        r2 = new com.google.ads.internal.i;	 Catch:{ JSONException -> 0x0288 }
        r2.<init>(r11, r1);	 Catch:{ JSONException -> 0x0288 }
        r0.m1729a(r2);	 Catch:{ JSONException -> 0x0288 }
        goto L_0x025a;
    L_0x0301:
        r0 = move-exception;
        r2 = "Caught exception trying to parse cache control directive. Overflow?";
        com.google.ads.util.C0290d.m1866b(r2, r0);	 Catch:{ JSONException -> 0x0288 }
        goto L_0x02f5;
    L_0x0308:
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0288 }
        r3 = "Unrecognized cacheControlDirective: '";
        r2.<init>(r3);	 Catch:{ JSONException -> 0x0288 }
        r0 = r2.append(r0);	 Catch:{ JSONException -> 0x0288 }
        r2 = "'. Not caching configuration.";
        r0 = r0.append(r2);	 Catch:{ JSONException -> 0x0288 }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x0288 }
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ JSONException -> 0x0288 }
        goto L_0x02f5;
    L_0x0321:
        r0 = r11.f2112i;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x035c;
    L_0x0325:
        r0 = r11.f2112i;	 Catch:{ Throwable -> 0x00eb }
        r1 = "application/json";
        r0 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x0339;
    L_0x032f:
        r0 = r11.f2112i;	 Catch:{ Throwable -> 0x00eb }
        r1 = "text/javascript";
        r0 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x035c;
    L_0x0339:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r1 = "Expected HTML but received ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2112i;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = ".";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1865b(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x035c:
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1742g();	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.f2021l;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1851a();	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x03b3;
    L_0x036a:
        r0 = r11.f2107d;	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x037c;
    L_0x036e:
        r0 = "Multiple supported ad sizes were specified, but the server did not respond with a size.";
        com.google.ads.util.C0290d.m1865b(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x037c:
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1742g();	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.f2021l;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1851a();	 Catch:{ Throwable -> 0x00eb }
        r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x00eb }
        r0 = java.util.Arrays.asList(r0);	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2107d;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.contains(r1);	 Catch:{ Throwable -> 0x00eb }
        if (r0 != 0) goto L_0x03bf;
    L_0x0396:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r1 = "The ad server did not respond with a supported AdSize: ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2107d;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1865b(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x03b3:
        r0 = r11.f2107d;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x03bf;
    L_0x03b7:
        r0 = "adSize was expected to be null in AdLoader.";
        com.google.ads.util.C0290d.m1871e(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = 0;
        r11.f2107d = r0;	 Catch:{ Throwable -> 0x00eb }
    L_0x03bf:
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r0.m1737b(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.m1745j();	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r1 = r1.m1746k();	 Catch:{ Throwable -> 0x00eb }
        r1.m1804c();	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r1 = r1.m1747l();	 Catch:{ Throwable -> 0x00eb }
        r1.m1778h();	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r2 = new com.google.ads.internal.m;	 Catch:{ Throwable -> 0x00eb }
        r7 = r11.f2109f;	 Catch:{ Throwable -> 0x00eb }
        r8 = r11.f2110g;	 Catch:{ Throwable -> 0x00eb }
        r2.<init>(r11, r0, r7, r8);	 Catch:{ Throwable -> 0x00eb }
        r1.m1729a(r2);	 Catch:{ Throwable -> 0x00eb }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00eb }
        r0 = r0 - r5;
        r0 = r3 - r0;
        r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x03f9;
    L_0x03f6:
        r11.wait(r0);	 Catch:{ InterruptedException -> 0x0417 }
    L_0x03f9:
        r0 = r11.f2121r;	 Catch:{ Throwable -> 0x00eb }
        if (r0 == 0) goto L_0x042d;
    L_0x03fd:
        r8 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r0 = new com.google.ads.internal.o;	 Catch:{ Throwable -> 0x00eb }
        r1 = r11.f2104a;	 Catch:{ Throwable -> 0x00eb }
        r2 = r11.f2105b;	 Catch:{ Throwable -> 0x00eb }
        r3 = r11.f2117n;	 Catch:{ Throwable -> 0x00eb }
        r4 = r11.f2122s;	 Catch:{ Throwable -> 0x00eb }
        r5 = r11.f2119p;	 Catch:{ Throwable -> 0x00eb }
        r6 = r11.f2106c;	 Catch:{ Throwable -> 0x00eb }
        r7 = r11.f2107d;	 Catch:{ Throwable -> 0x00eb }
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00eb }
        r8.m1729a(r0);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x00f7;
    L_0x0417:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r2 = "AdLoader InterruptedException while loading the HTML: ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00eb }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1862a(r0);	 Catch:{ Throwable -> 0x00eb }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x042d:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00eb }
        r1 = "AdLoader timed out after ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00eb }
        r1 = "ms while loading the HTML.";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00eb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00eb }
        com.google.ads.util.C0290d.m1867c(r0);	 Catch:{ Throwable -> 0x00eb }
        r0 = com.google.ads.C0243e.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00eb }
        r1 = 1;
        r11.m1696a(r0, r1);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x00f7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.h.run():void");
    }
}
