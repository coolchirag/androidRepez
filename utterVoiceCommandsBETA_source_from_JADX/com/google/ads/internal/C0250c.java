package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.as;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0252m;
import com.google.ads.util.C0290d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class C0250c {
    public static final C0252m<C0250c> f2099a = new C0253e();
    public static final Map<String, as> f2100b = Collections.unmodifiableMap(new C0254f());
    public static final Map<String, as> f2101c = Collections.unmodifiableMap(new C0251d());
    private static final C0250c f2102d = new C0250c();

    public static void m1681a(WebView webView) {
        C0250c.m1683a(webView, "onshow", "{'version': 'afma-sdk-a-v6.2.1'}");
    }

    public static void m1682a(WebView webView, String str) {
        C0290d.m1862a("Sending JS to a WebView: " + str);
        webView.loadUrl("javascript:" + str);
    }

    public static void m1683a(WebView webView, String str, String str2) {
        String str3 = "AFMA_ReceiveMessage";
        if (str2 != null) {
            C0250c.m1682a(webView, str3 + "('" + str + "', " + str2 + ");");
        } else {
            C0250c.m1682a(webView, str3 + "('" + str + "');");
        }
    }

    public static void m1684a(WebView webView, Map<String, Boolean> map) {
        C0250c.m1683a(webView, "openableURLs", new JSONObject(map).toString());
    }

    public static void m1685a(C0264p c0264p, Map<String, as> map, Uri uri, WebView webView) {
        HashMap b = AdUtil.m1837b(uri);
        if (b == null) {
            C0290d.m1871e("An error occurred while parsing the message parameters.");
            return;
        }
        String host;
        if (C0250c.m1689c(uri)) {
            host = uri.getHost();
            if (host == null) {
                C0290d.m1871e("An error occurred while parsing the AMSG parameters.");
                host = null;
            } else if (host.equals("launch")) {
                b.put("a", "intent");
                b.put(QueryParamConst.U_NAME, b.get("url"));
                b.remove("url");
                host = "/open";
            } else if (host.equals("closecanvas")) {
                host = "/close";
            } else if (host.equals("log")) {
                host = "/log";
            } else {
                C0290d.m1871e("An error occurred while parsing the AMSG: " + uri.toString());
                host = null;
            }
        } else if (C0250c.m1688b(uri)) {
            host = uri.getPath();
        } else {
            C0290d.m1871e("Message was neither a GMSG nor an AMSG.");
            host = null;
        }
        if (host == null) {
            C0290d.m1871e("An error occurred while parsing the message.");
            return;
        }
        as asVar = (as) map.get(host);
        if (asVar == null) {
            C0290d.m1871e("No AdResponse found, <message: " + host + ">");
        } else {
            asVar.mo107a(c0264p, b, webView);
        }
    }

    public static boolean m1686a(Uri uri) {
        return (uri == null || !uri.isHierarchical()) ? false : C0250c.m1688b(uri) || C0250c.m1689c(uri);
    }

    public static void m1687b(WebView webView) {
        C0250c.m1683a(webView, "onhide", null);
    }

    private static boolean m1688b(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("gmsg")) {
            return false;
        }
        scheme = uri.getAuthority();
        return scheme != null && scheme.equals("mobileads.google.com");
    }

    private static boolean m1689c(Uri uri) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("admob");
    }
}
