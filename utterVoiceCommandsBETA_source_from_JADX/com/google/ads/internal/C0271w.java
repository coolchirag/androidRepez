package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.AdActivity;
import com.google.ads.as;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import com.google.ads.util.C0308w;
import java.util.HashMap;
import java.util.Map;

public class C0271w extends WebViewClient {
    private static final C0250c f2206c = ((C0250c) C0250c.f2099a.mo113a());
    protected C0264p f2207a;
    protected boolean f2208b = false;
    private final Map<String, as> f2209d;
    private final boolean f2210e;
    private boolean f2211f;
    private boolean f2212g = false;
    private boolean f2213h = false;

    public C0271w(C0264p c0264p, Map<String, as> map, boolean z, boolean z2) {
        this.f2207a = c0264p;
        this.f2209d = map;
        this.f2210e = z;
        this.f2211f = z2;
    }

    public static C0271w m1801a(C0264p c0264p, Map<String, as> map, boolean z, boolean z2) {
        return AdUtil.f2240a >= 11 ? new C0308w(c0264p, map, z, z2) : new C0271w(c0264p, map, z, z2);
    }

    public final void m1802a() {
        this.f2208b = true;
    }

    public final void m1803b() {
        this.f2211f = false;
    }

    public final void m1804c() {
        this.f2212g = true;
    }

    public final void m1805d() {
        this.f2213h = true;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.f2212g) {
            C0256h i = this.f2207a.m1744i();
            if (i != null) {
                i.m1707b();
            } else {
                C0290d.m1862a("adLoader was null while trying to setFinishedLoadingHtml().");
            }
            this.f2212g = false;
        }
        if (this.f2213h) {
            C0250c c0250c = f2206c;
            C0250c.m1681a(webView);
            this.f2213h = false;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            C0290d.m1862a("shouldOverrideUrlLoading(\"" + str + "\")");
            Uri parse = Uri.parse(str);
            C0250c c0250c = f2206c;
            if (C0250c.m1686a(parse)) {
                c0250c = f2206c;
                C0250c.m1685a(this.f2207a, this.f2209d, parse, webView);
                return true;
            } else if (this.f2211f) {
                if (AdUtil.m1833a(parse)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(QueryParamConst.U_NAME, str);
                AdActivity.m1566a(this.f2207a, new C0265q("intent", hashMap));
                return true;
            } else if (this.f2210e) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(QueryParamConst.U_NAME, parse.toString());
                AdActivity.m1566a(this.f2207a, new C0265q("intent", hashMap2));
                return true;
            } else {
                C0290d.m1871e("URL is not a GMSG and can't handle URL: " + str);
                return true;
            }
        } catch (Throwable th) {
            C0290d.m1866b("An unknown error occurred in shouldOverrideUrlLoading.", th);
            return true;
        }
    }
}
