package com.p011a.p012a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class C0109i extends WebViewClient {
    final /* synthetic */ C0107g f364a;

    private C0109i(C0107g c0107g) {
        this.f364a = c0107g;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f364a.f359f.dismiss();
        this.f364a.f362i.setBackgroundColor(0);
        this.f364a.f361h.setVisibility(0);
        this.f364a.f360g.setVisibility(0);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C0112l.m332a("Facebook-WebView", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        this.f364a.f359f.show();
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f364a.f358e.mo54a(new C0101a(str, i, str2));
        this.f364a.dismiss();
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C0112l.m332a("Facebook-WebView", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            Bundle a = C0112l.m326a(str);
            String string = a.getString("error");
            if (string == null) {
                string = a.getString("error_type");
            }
            if (string == null) {
                this.f364a.f358e.mo53a(a);
            } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                this.f364a.f358e.mo52a();
            } else {
                this.f364a.f358e.mo55a(new C0106f(string));
            }
            this.f364a.dismiss();
            return true;
        } else if (str.startsWith("fbconnect://cancel")) {
            this.f364a.f358e.mo52a();
            this.f364a.dismiss();
            return true;
        } else if (str.contains("touch")) {
            return false;
        } else {
            this.f364a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }
}
