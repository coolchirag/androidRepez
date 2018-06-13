package com.brandall.nutter;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class co extends WebViewClient {
    final /* synthetic */ ActivityLinkApps f1017a;
    private final /* synthetic */ Dialog f1018b;

    co(ActivityLinkApps activityLinkApps, Dialog dialog) {
        this.f1017a = activityLinkApps;
        this.f1018b = dialog;
    }

    public final void onPageFinished(WebView webView, String str) {
        if (hc.f1269b) {
            ls.m1346c("url finished: " + str);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = "#access_token=";
        int indexOf = str.indexOf(str2);
        if (indexOf >= 0) {
            try {
                str2 = str.substring(str2.length() + indexOf, str.length());
                if (hc.f1269b) {
                    ls.m1346c("OAuth complete, token: [" + str2 + "].");
                }
                if (str2 != null) {
                    lx.m1392a(this.f1017a, str2);
                    lc.m1313a(this.f1017a, false, "Four Square authorisation successful");
                } else {
                    lx.m1392a(this.f1017a, "");
                    lc.m1313a(this.f1017a, false, "Four Square authorisation failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.f1018b.dismiss();
                lx.m1392a(this.f1017a, "");
                lc.m1313a(this.f1017a, false, "Four Square authorisation failed");
            }
            this.f1018b.dismiss();
        }
    }
}
