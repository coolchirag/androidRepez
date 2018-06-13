package com.google.ads.util;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.ap;
import com.google.ads.aq;
import com.google.ads.ar;
import com.google.ads.internal.AdWebView;

public class C0301p extends WebChromeClient {
    private final ar f2297a;

    public C0301p(ar arVar) {
        this.f2297a = arVar;
    }

    private static boolean m1879a(WebView webView, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        if (webView instanceof AdWebView) {
            Context d = ((AdWebView) webView).m1676d();
            if (d != null) {
                Builder builder = new Builder(d);
                builder.setTitle(str);
                if (z) {
                    View linearLayout = new LinearLayout(d);
                    linearLayout.setOrientation(1);
                    View textView = new TextView(d);
                    textView.setText(str2);
                    View editText = new EditText(d);
                    editText.setText(str3);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new C0307v(jsPromptResult, editText)).setNegativeButton(17039360, new C0306u(jsPromptResult)).setOnCancelListener(new C0305t(jsPromptResult)).create().show();
                    return true;
                }
                builder.setMessage(str2).setPositiveButton(17039370, new C0304s(jsResult)).setNegativeButton(17039360, new C0303r(jsResult)).setOnCancelListener(new C0302q(jsResult)).create().show();
                return true;
            }
        }
        return false;
    }

    public void onCloseWindow(WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).m1673a();
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (C0300o.f2296a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                C0290d.m1865b(str);
                break;
            case 2:
                C0290d.m1871e(str);
                break;
            case 3:
            case 4:
                C0290d.m1867c(str);
                break;
            case 5:
                C0290d.m1862a(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        aq aqVar = (aq) ((ap) this.f2297a.f2010a.m1850a()).f1997a.m1850a();
        long longValue = ((Long) aqVar.f2006i.m1851a()).longValue() - j3;
        if (longValue <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min(((Long) aqVar.f2008k.m1851a()).longValue(), longValue) + j, ((Long) aqVar.f2007j.m1851a()).longValue());
            } else if (j2 <= Math.min(((Long) aqVar.f2007j.m1851a()).longValue() - j, longValue)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > longValue || j2 > ((Long) aqVar.f2007j.m1851a()).longValue()) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return C0301p.m1879a(webView, str, str2, null, jsResult, null, false);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return C0301p.m1879a(webView, str, str2, null, jsResult, null, false);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return C0301p.m1879a(webView, str, str2, null, jsResult, null, false);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return C0301p.m1879a(webView, str, str2, str3, null, jsPromptResult, true);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        aq aqVar = (aq) ((ap) this.f2297a.f2010a.m1850a()).f1997a.m1850a();
        long longValue = ((Long) aqVar.f2004g.m1851a()).longValue() + j;
        if (((Long) aqVar.f2005h.m1851a()).longValue() - j2 < longValue) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(longValue);
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        customViewCallback.onCustomViewHidden();
    }
}
