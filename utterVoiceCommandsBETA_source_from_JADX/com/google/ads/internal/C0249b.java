package com.google.ads.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;

final class C0249b implements DownloadListener {
    final /* synthetic */ AdWebView f2098a;

    C0249b(AdWebView adWebView) {
        this.f2098a = adWebView;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            Context d = this.f2098a.m1676d();
            if (d != null && AdUtil.m1832a(intent, d)) {
                d.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            C0290d.m1862a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        } catch (Throwable th) {
            C0290d.m1866b("Unknown error trying to start activity to view URL: " + str, th);
        }
    }
}
