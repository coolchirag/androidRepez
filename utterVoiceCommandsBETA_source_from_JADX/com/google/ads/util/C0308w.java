package com.google.ads.util;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.ads.ap;
import com.google.ads.aq;
import com.google.ads.as;
import com.google.ads.internal.C0256h;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0271w;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class C0308w extends C0271w {
    public C0308w(C0264p c0264p, Map<String, as> map, boolean z, boolean z2) {
        super(c0264p, map, z, z2);
    }

    private static WebResourceResponse m1880a(String str, Context context) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            AdUtil.m1829a(httpURLConnection, context.getApplicationContext());
            httpURLConnection.connect();
            String str2 = "UTF-8";
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", str2, new ByteArrayInputStream(AdUtil.m1824a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes(str2)));
            return webResourceResponse;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if ("mraid.js".equalsIgnoreCase(new File(str).getName())) {
                C0256h i = this.a.m1744i();
                if (i != null) {
                    i.m1710c();
                } else {
                    this.a.m1732a(true);
                }
                aq aqVar = (aq) ((ap) this.a.m1742g().f2010a.m1850a()).f1997a.m1850a();
                String str2;
                if (this.a.m1742g().m1627b()) {
                    str2 = (String) aqVar.f2002e.m1851a();
                    C0290d.m1862a("shouldInterceptRequest(" + str2 + ")");
                    return C0308w.m1880a(str2, webView.getContext());
                } else if (this.b) {
                    str2 = (String) aqVar.f2001d.m1851a();
                    C0290d.m1862a("shouldInterceptRequest(" + str2 + ")");
                    return C0308w.m1880a(str2, webView.getContext());
                } else {
                    str2 = (String) aqVar.f2000c.m1851a();
                    C0290d.m1862a("shouldInterceptRequest(" + str2 + ")");
                    return C0308w.m1880a(str2, webView.getContext());
                }
            }
        } catch (Throwable e) {
            C0290d.m1870d("IOException fetching MRAID JS.", e);
        } catch (Throwable e2) {
            C0290d.m1866b("An unknown error occurred fetching MRAID JS.", e2);
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
