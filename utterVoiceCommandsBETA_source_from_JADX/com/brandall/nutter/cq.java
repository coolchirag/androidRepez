package com.brandall.nutter;

import android.webkit.WebView;

final class cq implements Runnable {
    final /* synthetic */ ActivityLinkApps f1020a;
    private final /* synthetic */ WebView f1021b;

    cq(ActivityLinkApps activityLinkApps, WebView webView) {
        this.f1020a = activityLinkApps;
        this.f1021b = webView;
    }

    public final void run() {
        try {
            this.f1021b.loadUrl("https://foursquare.com/oauth2/authenticate?client_id=ZAZ45CUEZDGGZJYH5YSWWUC5CYYPI1IUUTLDUJBW0OEHLKII&response_type=token&redirect_uri=http://localhost/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
