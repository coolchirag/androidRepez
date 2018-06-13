package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0256h;
import com.google.ads.internal.C0262n;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;
import org.ispeech.core.InternalResources;

public final class bb implements as {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("url");
        String str2 = (String) hashMap.get(InternalResources.ISPEECH_SCREEN_TYPE);
        String str3 = (String) hashMap.get("afma_notify_dt");
        boolean equals = "1".equals(hashMap.get("drt_include"));
        String str4 = (String) hashMap.get("request_scenario");
        boolean equals2 = "1".equals(hashMap.get("use_webview_loadurl"));
        C0262n c0262n = C0262n.OFFLINE_EMPTY.f2144e.equals(str4) ? C0262n.OFFLINE_EMPTY : C0262n.OFFLINE_USING_BUFFERED_ADS.f2144e.equals(str4) ? C0262n.OFFLINE_USING_BUFFERED_ADS : C0262n.ONLINE_USING_BUFFERED_ADS.f2144e.equals(str4) ? C0262n.ONLINE_USING_BUFFERED_ADS : C0262n.ONLINE_SERVER_REQUEST;
        C0290d.m1867c("Received ad url: <url: \"" + str + "\" type: \"" + str2 + "\" afmaNotifyDt: \"" + str3 + "\" useWebViewLoadUrl: \"" + equals2 + "\">");
        C0256h i = c0264p.m1744i();
        if (i != null) {
            i.m1709b(equals);
            i.m1703a(c0262n);
            i.m1712c(equals2);
            i.m1713d(str);
        }
    }
}
