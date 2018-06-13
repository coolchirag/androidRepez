package com.google.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0250c;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0265q;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;

public class AdActivity extends Activity implements OnClickListener {
    private static final C0250c f1910a = ((C0250c) C0250c.f2099a.mo113a());
    private static final Object f1911b = new Object();
    private static AdActivity f1912c = null;
    private static C0264p f1913d = null;
    private static AdActivity f1914e = null;
    private static AdActivity f1915f = null;
    private static final C0240b f1916g = new C0240b();
    private AdWebView f1917h;
    private FrameLayout f1918i;
    private int f1919j;
    private ViewGroup f1920k = null;
    private boolean f1921l;
    private long f1922m;
    private RelativeLayout f1923n;
    private AdActivity f1924o = null;
    private boolean f1925p;
    private boolean f1926q;
    private boolean f1927r;
    private boolean f1928s;
    private AdVideoView f1929t;

    private void m1565a(AdWebView adWebView, boolean z, int i, boolean z2, boolean z3) {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        if (AdUtil.f2240a >= 11) {
            if (this.f1927r) {
                C0290d.m1862a("Enabling hardware acceleration on the AdActivity window.");
                window.setFlags(16777216, 16777216);
            } else {
                C0290d.m1862a("Disabling hardware acceleration on the AdActivity WebView.");
                adWebView.m1674b();
            }
        }
        ViewParent parent = adWebView.getParent();
        if (parent != null) {
            if (!z2) {
                m1567a("Interstitial created with an AdWebView that has a parent.");
                return;
            } else if (parent instanceof ViewGroup) {
                this.f1920k = (ViewGroup) parent;
                this.f1920k.removeView(adWebView);
            } else {
                m1567a("MRAID banner was not a child of a ViewGroup.");
                return;
            }
        }
        if (adWebView.m1676d() != null) {
            m1567a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
            return;
        }
        setRequestedOrientation(i);
        adWebView.setAdActivity(this);
        this.f1919j = (int) TypedValue.applyDimension(1, (float) (z2 ? 50 : 32), getResources().getDisplayMetrics());
        this.f1918i = new FrameLayout(getApplicationContext());
        this.f1918i.setMinimumWidth(this.f1919j);
        this.f1918i.setMinimumHeight(this.f1919j);
        this.f1918i.setOnClickListener(this);
        m1578a(z3);
        View view = this.f1918i;
        this.f1923n.addView(adWebView, -1, -1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        this.f1923n.addView(view, layoutParams);
        this.f1923n.setKeepScreenOn(true);
        setContentView(this.f1923n);
        this.f1923n.getRootView().setBackgroundColor(-16777216);
        if (z) {
            C0250c c0250c = f1910a;
            C0250c.m1681a((WebView) adWebView);
        }
    }

    public static void m1566a(C0264p c0264p, C0265q c0265q) {
        C0240b c0240b = f1916g;
        C0240b.m1646a(c0264p, c0265q);
    }

    private void m1567a(String str) {
        C0290d.m1865b(str);
        finish();
    }

    private void m1568a(String str, Throwable th) {
        C0290d.m1866b(str, th);
        finish();
    }

    private void m1569b(C0264p c0264p) {
        this.f1917h = null;
        this.f1922m = SystemClock.elapsedRealtime();
        this.f1925p = true;
        synchronized (f1911b) {
            if (f1912c == null) {
                f1912c = this;
                c0264p.m1754s();
            }
        }
    }

    private static RelativeLayout.LayoutParams m1570c(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public static boolean m1571c() {
        C0240b c0240b = f1916g;
        return C0240b.m1647a();
    }

    private void m1575g() {
        if (!this.f1921l) {
            if (this.f1917h != null) {
                C0250c c0250c = f1910a;
                C0250c.m1687b(this.f1917h);
                this.f1917h.setAdActivity(null);
                this.f1917h.setIsExpandedMraid(false);
                if (!(this.f1926q || this.f1923n == null || this.f1920k == null)) {
                    if (this.f1927r && !this.f1928s) {
                        C0290d.m1862a("Disabling hardware acceleration on collapsing MRAID WebView.");
                        this.f1917h.m1674b();
                    } else if (!this.f1927r && this.f1928s) {
                        C0290d.m1862a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
                        this.f1917h.m1675c();
                    }
                    this.f1923n.removeView(this.f1917h);
                    this.f1920k.addView(this.f1917h);
                }
            }
            if (this.f1929t != null) {
                this.f1929t.m1671d();
                this.f1929t = null;
            }
            if (this == f1912c) {
                f1912c = null;
            }
            f1915f = this.f1924o;
            synchronized (f1911b) {
                if (!(f1913d == null || !this.f1926q || this.f1917h == null)) {
                    if (this.f1917h == f1913d.m1745j()) {
                        f1913d.m1721a();
                    }
                    this.f1917h.stopLoading();
                }
                if (this == f1914e) {
                    f1914e = null;
                    if (f1913d != null) {
                        f1913d.m1752q();
                        f1913d = null;
                    } else {
                        C0290d.m1871e("currentAdManager is null while trying to destroy AdActivity.");
                    }
                }
            }
            this.f1921l = true;
            C0290d.m1862a("AdActivity is closing.");
        }
    }

    public final AdVideoView m1576a() {
        return this.f1929t;
    }

    public final void m1577a(int i, int i2, int i3, int i4) {
        if (this.f1929t != null) {
            this.f1929t.setLayoutParams(m1570c(i, i2, i3, i4));
            this.f1929t.requestLayout();
        }
    }

    public final void m1578a(boolean z) {
        if (this.f1918i != null) {
            this.f1918i.removeAllViews();
            if (!z) {
                View imageButton = new ImageButton(this);
                imageButton.setImageResource(17301527);
                imageButton.setBackgroundColor(0);
                imageButton.setOnClickListener(this);
                imageButton.setPadding(0, 0, 0, 0);
                this.f1918i.addView(imageButton, new FrameLayout.LayoutParams(this.f1919j, this.f1919j, 17));
            }
        }
    }

    public final AdWebView m1579b() {
        if (this.f1924o != null) {
            return this.f1924o.f1917h;
        }
        synchronized (f1911b) {
            if (f1913d == null) {
                C0290d.m1871e("currentAdManager was null while trying to get the opening AdWebView.");
                return null;
            }
            AdWebView j = f1913d.m1745j();
            if (j != this.f1917h) {
                return j;
            }
            return null;
        }
    }

    public final void m1580b(int i, int i2, int i3, int i4) {
        if (this.f1929t == null) {
            this.f1929t = new AdVideoView(this, this.f1917h);
            this.f1923n.addView(this.f1929t, 0, m1570c(i, i2, i3, i4));
            synchronized (f1911b) {
                if (f1913d == null) {
                    C0290d.m1871e("currentAdManager was null while trying to get the opening AdWebView.");
                    return;
                }
                f1913d.m1746k().m1803b();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!(m1579b() == null || intent == null || intent.getExtras() == null || intent.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION") == null || intent.getExtras().getString("com.google.circles.platform.result.extra.ACTION") == null)) {
            String string = intent.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION");
            String string2 = intent.getExtras().getString("com.google.circles.platform.result.extra.ACTION");
            if (string.equals("yes")) {
                if (string2.equals("insert")) {
                    C0281p.m1814a(m1579b(), true);
                } else if (string2.equals("delete")) {
                    C0281p.m1814a(m1579b(), false);
                }
            }
        }
        finish();
    }

    public void onClick(View view) {
        finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
        r11 = this;
        r5 = 0;
        r6 = 1;
        r7 = 0;
        super.onCreate(r12);
        r11.f1921l = r7;
        r2 = f1911b;
        monitor-enter(r2);
        r0 = f1913d;	 Catch:{ all -> 0x00a9 }
        if (r0 == 0) goto L_0x00a2;
    L_0x000f:
        r8 = f1913d;	 Catch:{ all -> 0x00a9 }
        r0 = f1914e;	 Catch:{ all -> 0x00a9 }
        if (r0 != 0) goto L_0x001a;
    L_0x0015:
        f1914e = r11;	 Catch:{ all -> 0x00a9 }
        r8.m1753r();	 Catch:{ all -> 0x00a9 }
    L_0x001a:
        r0 = r11.f1924o;	 Catch:{ all -> 0x00a9 }
        if (r0 != 0) goto L_0x0026;
    L_0x001e:
        r0 = f1915f;	 Catch:{ all -> 0x00a9 }
        if (r0 == 0) goto L_0x0026;
    L_0x0022:
        r0 = f1915f;	 Catch:{ all -> 0x00a9 }
        r11.f1924o = r0;	 Catch:{ all -> 0x00a9 }
    L_0x0026:
        f1915f = r11;	 Catch:{ all -> 0x00a9 }
        r0 = r8.m1742g();	 Catch:{ all -> 0x00a9 }
        r0 = r0.m1626a();	 Catch:{ all -> 0x00a9 }
        if (r0 == 0) goto L_0x0036;
    L_0x0032:
        r0 = f1914e;	 Catch:{ all -> 0x00a9 }
        if (r0 == r11) goto L_0x0046;
    L_0x0036:
        r0 = r8.m1742g();	 Catch:{ all -> 0x00a9 }
        r0 = r0.m1627b();	 Catch:{ all -> 0x00a9 }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r11.f1924o;	 Catch:{ all -> 0x00a9 }
        r1 = f1914e;	 Catch:{ all -> 0x00a9 }
        if (r0 != r1) goto L_0x0049;
    L_0x0046:
        r8.m1756u();	 Catch:{ all -> 0x00a9 }
    L_0x0049:
        r9 = r8.m1750o();	 Catch:{ all -> 0x00a9 }
        r0 = r8.m1742g();	 Catch:{ all -> 0x00a9 }
        r0 = r0.f2010a;	 Catch:{ all -> 0x00a9 }
        r0 = r0.m1850a();	 Catch:{ all -> 0x00a9 }
        r0 = (com.google.ads.ap) r0;	 Catch:{ all -> 0x00a9 }
        r0 = r0.f1997a;	 Catch:{ all -> 0x00a9 }
        r0 = r0.m1850a();	 Catch:{ all -> 0x00a9 }
        r0 = (com.google.ads.aq) r0;	 Catch:{ all -> 0x00a9 }
        r3 = com.google.ads.util.AdUtil.f2240a;	 Catch:{ all -> 0x00a9 }
        r1 = r0.f1998a;	 Catch:{ all -> 0x00a9 }
        r1 = r1.m1851a();	 Catch:{ all -> 0x00a9 }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x00a9 }
        r1 = r1.intValue();	 Catch:{ all -> 0x00a9 }
        if (r3 < r1) goto L_0x00ac;
    L_0x0071:
        r1 = r6;
    L_0x0072:
        r11.f1928s = r1;	 Catch:{ all -> 0x00a9 }
        r1 = com.google.ads.util.AdUtil.f2240a;	 Catch:{ all -> 0x00a9 }
        r0 = r0.f1999b;	 Catch:{ all -> 0x00a9 }
        r0 = r0.m1851a();	 Catch:{ all -> 0x00a9 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x00a9 }
        r0 = r0.intValue();	 Catch:{ all -> 0x00a9 }
        if (r1 < r0) goto L_0x00ae;
    L_0x0084:
        r0 = r6;
    L_0x0085:
        r11.f1927r = r0;	 Catch:{ all -> 0x00a9 }
        monitor-exit(r2);	 Catch:{ all -> 0x00a9 }
        r11.f1923n = r5;
        r11.f1925p = r7;
        r11.f1926q = r6;
        r11.f1929t = r5;
        r0 = r11.getIntent();
        r1 = "com.google.ads.AdOpener";
        r0 = r0.getBundleExtra(r1);
        if (r0 != 0) goto L_0x00b0;
    L_0x009c:
        r0 = "Could not get the Bundle used to create AdActivity.";
        r11.m1567a(r0);
    L_0x00a1:
        return;
    L_0x00a2:
        r0 = "Could not get currentAdManager.";
        r11.m1567a(r0);	 Catch:{ all -> 0x00a9 }
        monitor-exit(r2);	 Catch:{ all -> 0x00a9 }
        goto L_0x00a1;
    L_0x00a9:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x00ac:
        r1 = r7;
        goto L_0x0072;
    L_0x00ae:
        r0 = r7;
        goto L_0x0085;
    L_0x00b0:
        r1 = new com.google.ads.internal.q;
        r1.<init>(r0);
        r0 = r1.f2178a;
        r10 = r1.f2179b;
        r1 = "plusone";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x011b;
    L_0x00c1:
        r1 = new android.content.Intent;
        r1.<init>();
        r0 = new android.content.ComponentName;
        r2 = "com.google.android.apps.plus";
        r3 = "com.google.android.apps.circles.platform.PlusOneActivity";
        r0.<init>(r2, r3);
        r1.setComponent(r0);
        r0 = "android.intent.category.LAUNCHER";
        r1.addCategory(r0);
        r0 = r11.getIntent();
        r0 = r0.getExtras();
        r1.putExtras(r0);
        r2 = "com.google.circles.platform.intent.extra.ENTITY";
        r0 = "u";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1.putExtra(r2, r0);
        r0 = "com.google.circles.platform.intent.extra.ENTITY_TYPE";
        r2 = com.google.ads.C0312w.AD;
        r2 = r2.f2308c;
        r1.putExtra(r0, r2);
        r2 = "com.google.circles.platform.intent.extra.ACTION";
        r0 = "a";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1.putExtra(r2, r0);
        r11.m1569b(r8);
        r0 = "Launching Google+ intent from AdActivity.";
        com.google.ads.util.C0290d.m1862a(r0);	 Catch:{ ActivityNotFoundException -> 0x0112 }
        r0 = 0;
        r11.startActivityForResult(r1, r0);	 Catch:{ ActivityNotFoundException -> 0x0112 }
        goto L_0x00a1;
    L_0x0112:
        r0 = move-exception;
        r1 = r0.getMessage();
        r11.m1568a(r1, r0);
        goto L_0x00a1;
    L_0x011b:
        r1 = "intent";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0197;
    L_0x0123:
        if (r10 != 0) goto L_0x012c;
    L_0x0125:
        r0 = "Could not get the paramMap in launchIntent()";
        r11.m1567a(r0);
        goto L_0x00a1;
    L_0x012c:
        r0 = "u";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        if (r0 != 0) goto L_0x013d;
    L_0x0136:
        r0 = "Could not get the URL parameter in launchIntent().";
        r11.m1567a(r0);
        goto L_0x00a1;
    L_0x013d:
        r1 = "i";
        r1 = r10.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "m";
        r2 = r10.get(r2);
        r2 = (java.lang.String) r2;
        r3 = android.net.Uri.parse(r0);
        if (r1 != 0) goto L_0x0191;
    L_0x0153:
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r0.<init>(r1, r3);
    L_0x015a:
        if (r2 == 0) goto L_0x015f;
    L_0x015c:
        r0.setDataAndType(r3, r2);
    L_0x015f:
        r11.m1569b(r8);
        r1 = new java.lang.StringBuilder;	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r2 = "Launching an intent from AdActivity: ";
        r1.<init>(r2);	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r2 = r0.getAction();	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r1 = r1.append(r2);	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r2 = " - ";
        r1 = r1.append(r2);	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r1 = r1.append(r3);	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r1 = r1.toString();	 Catch:{ ActivityNotFoundException -> 0x0187 }
        com.google.ads.util.C0290d.m1862a(r1);	 Catch:{ ActivityNotFoundException -> 0x0187 }
        r11.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0187 }
        goto L_0x00a1;
    L_0x0187:
        r0 = move-exception;
        r1 = r0.getMessage();
        r11.m1568a(r1, r0);
        goto L_0x00a1;
    L_0x0191:
        r0 = new android.content.Intent;
        r0.<init>(r1, r3);
        goto L_0x015a;
    L_0x0197:
        r1 = new android.widget.RelativeLayout;
        r2 = r11.getApplicationContext();
        r1.<init>(r2);
        r11.f1923n = r1;
        r1 = "webapp";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0248;
    L_0x01aa:
        r0 = new com.google.ads.internal.AdWebView;
        r1 = r8.m1742g();
        r0.<init>(r1, r5);
        r11.f1917h = r0;
        r1 = com.google.ads.internal.C0250c.f2101c;
        if (r9 != 0) goto L_0x0219;
    L_0x01b9:
        r0 = r6;
    L_0x01ba:
        r0 = com.google.ads.internal.C0271w.m1801a(r8, r1, r6, r0);
        r0.m1805d();
        if (r9 == 0) goto L_0x01c6;
    L_0x01c3:
        r0.m1802a();
    L_0x01c6:
        r1 = r11.f1917h;
        r1.setWebViewClient(r0);
        r0 = "u";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1 = "baseurl";
        r1 = r10.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "html";
        r2 = r10.get(r2);
        r2 = (java.lang.String) r2;
        if (r0 == 0) goto L_0x021b;
    L_0x01e5:
        r1 = r11.f1917h;
        r1.loadUrl(r0);
    L_0x01ea:
        r0 = "o";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r1 = "p";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x022e;
    L_0x01fa:
        r3 = com.google.ads.util.AdUtil.m1834b();
    L_0x01fe:
        r1 = r11.f1917h;
        if (r10 == 0) goto L_0x0246;
    L_0x0202:
        r0 = "1";
        r2 = "custom_close";
        r2 = r10.get(r2);
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0246;
    L_0x0210:
        r5 = r6;
    L_0x0211:
        r0 = r11;
        r2 = r7;
        r4 = r9;
        r0.m1565a(r1, r2, r3, r4, r5);
        goto L_0x00a1;
    L_0x0219:
        r0 = r7;
        goto L_0x01ba;
    L_0x021b:
        if (r2 == 0) goto L_0x0227;
    L_0x021d:
        r0 = r11.f1917h;
        r3 = "text/html";
        r4 = "utf-8";
        r0.loadDataWithBaseURL(r1, r2, r3, r4, r5);
        goto L_0x01ea;
    L_0x0227:
        r0 = "Could not get the URL or HTML parameter to show a web app.";
        r11.m1567a(r0);
        goto L_0x00a1;
    L_0x022e:
        r1 = "l";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x023b;
    L_0x0236:
        r3 = com.google.ads.util.AdUtil.m1819a();
        goto L_0x01fe;
    L_0x023b:
        r0 = f1914e;
        if (r11 != r0) goto L_0x0244;
    L_0x023f:
        r3 = r8.m1748m();
        goto L_0x01fe;
    L_0x0244:
        r3 = -1;
        goto L_0x01fe;
    L_0x0246:
        r5 = r7;
        goto L_0x0211;
    L_0x0248:
        r1 = "interstitial";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x0258;
    L_0x0250:
        r1 = "expand";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x02a7;
    L_0x0258:
        r1 = r8.m1745j();
        r11.f1917h = r1;
        r3 = r8.m1748m();
        r1 = "expand";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x029f;
    L_0x026a:
        r0 = r11.f1917h;
        r0.setIsExpandedMraid(r6);
        r11.f1926q = r7;
        if (r10 == 0) goto L_0x0282;
    L_0x0273:
        r0 = "1";
        r1 = "custom_close";
        r1 = r10.get(r1);
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0282;
    L_0x0281:
        r7 = r6;
    L_0x0282:
        r0 = r11.f1927r;
        if (r0 == 0) goto L_0x02c1;
    L_0x0286:
        r0 = r11.f1928s;
        if (r0 != 0) goto L_0x02c1;
    L_0x028a:
        r0 = "Re-enabling hardware acceleration on expanding MRAID WebView.";
        com.google.ads.util.C0290d.m1862a(r0);
        r0 = r11.f1917h;
        r0.m1675c();
        r5 = r7;
    L_0x0295:
        r1 = r11.f1917h;
        r0 = r11;
        r2 = r6;
        r4 = r9;
        r0.m1565a(r1, r2, r3, r4, r5);
        goto L_0x00a1;
    L_0x029f:
        r0 = r11.f1917h;
        r7 = r0.m1677e();
        r5 = r7;
        goto L_0x0295;
    L_0x02a7:
        r1 = new java.lang.StringBuilder;
        r2 = "Unknown AdOpener, <action: ";
        r1.<init>(r2);
        r0 = r1.append(r0);
        r1 = ">";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.m1567a(r0);
        goto L_0x00a1;
    L_0x02c1:
        r5 = r7;
        goto L_0x0295;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        if (this.f1923n != null) {
            this.f1923n.removeAllViews();
        }
        if (isFinishing()) {
            m1575g();
            if (this.f1926q && this.f1917h != null) {
                this.f1917h.stopLoading();
                this.f1917h.destroy();
                this.f1917h = null;
            }
        }
        super.onDestroy();
    }

    public void onPause() {
        if (isFinishing()) {
            m1575g();
        }
        super.onPause();
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.f1925p && z && SystemClock.elapsedRealtime() - this.f1922m > 250) {
            C0290d.m1869d("Launcher AdActivity got focus and is closing.");
            finish();
        }
        super.onWindowFocusChanged(z);
    }
}
