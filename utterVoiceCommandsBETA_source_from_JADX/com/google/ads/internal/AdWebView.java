package com.google.ads.internal;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.C0245g;
import com.google.ads.ar;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import com.google.ads.util.C0299n;
import com.google.ads.util.C0301p;
import com.google.ads.util.C0310y;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView {
    private WeakReference<AdActivity> f2089a = null;
    private C0245g f2090b;
    private boolean f2091c = false;
    private boolean f2092d = false;
    private boolean f2093e = false;

    public AdWebView(ar arVar, C0245g c0245g) {
        super((Context) arVar.f2015f.m1850a());
        this.f2090b = c0245g;
        setBackgroundColor(0);
        AdUtil.m1828a((WebView) this);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        setDownloadListener(new C0249b(this));
        if (AdUtil.f2240a >= 11) {
            C0299n.m1878a(settings, arVar);
        }
        setScrollBarStyle(33554432);
        if (AdUtil.f2240a >= 14) {
            setWebChromeClient(new C0310y(arVar));
        } else if (AdUtil.f2240a >= 11) {
            setWebChromeClient(new C0301p(arVar));
        }
    }

    public final void m1673a() {
        AdActivity d = m1676d();
        if (d != null) {
            d.finish();
        }
    }

    public final void m1674b() {
        if (AdUtil.f2240a >= 11) {
            setLayerType(1, null);
        }
        this.f2092d = true;
    }

    public final void m1675c() {
        if (this.f2092d && AdUtil.f2240a >= 11) {
            setLayerType(0, null);
        }
        this.f2092d = false;
    }

    public final AdActivity m1676d() {
        return this.f2089a != null ? (AdActivity) this.f2089a.get() : null;
    }

    public void destroy() {
        try {
            super.destroy();
            setWebViewClient(new WebViewClient());
        } catch (Throwable th) {
            C0290d.m1866b("An error occurred while destroying an AdWebView:", th);
        }
    }

    public final boolean m1677e() {
        return this.f2093e;
    }

    public final boolean m1678f() {
        return this.f2092d;
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            C0290d.m1866b("An error occurred while loading data in AdWebView:", th);
        }
    }

    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Throwable th) {
            C0290d.m1866b("An error occurred while loading a URL in AdWebView:", th);
        }
    }

    protected synchronized void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        synchronized (this) {
            if (isInEditMode()) {
                super.onMeasure(i, i2);
            } else if (this.f2090b == null || this.f2091c) {
                super.onMeasure(i, i2);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                int size2 = MeasureSpec.getSize(i2);
                float f = getContext().getResources().getDisplayMetrics().density;
                int a = (int) (((float) this.f2090b.m1661a()) * f);
                int b = (int) (((float) this.f2090b.m1662b()) * f);
                mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i3 = size2;
                }
                if (((float) a) - (f * 6.0f) > ((float) mode) || b > r0) {
                    C0290d.m1871e("Not enough space to show ad! Wants: <" + a + ", " + b + ">, Has: <" + size + ", " + size2 + ">");
                    setVisibility(8);
                    setMeasuredDimension(size, size2);
                } else {
                    setMeasuredDimension(a, b);
                }
            }
        }
    }

    public void setAdActivity(AdActivity adActivity) {
        this.f2089a = new WeakReference(adActivity);
    }

    public synchronized void setAdSize(C0245g c0245g) {
        this.f2090b = c0245g;
        requestLayout();
    }

    public void setCustomClose(boolean z) {
        this.f2093e = z;
        if (this.f2089a != null) {
            AdActivity adActivity = (AdActivity) this.f2089a.get();
            if (adActivity != null) {
                adActivity.m1578a(z);
            }
        }
    }

    public void setIsExpandedMraid(boolean z) {
        this.f2091c = z;
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable th) {
            C0290d.m1870d("An error occurred while stopping loading in AdWebView:", th);
        }
    }
}
