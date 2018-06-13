package com.google.ads.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebSettings;
import com.google.ads.ap;
import com.google.ads.aq;
import com.google.ads.ar;
import java.io.File;

@TargetApi(11)
public final class C0299n {
    public static void m1878a(WebSettings webSettings, ar arVar) {
        Context context = (Context) arVar.f2015f.m1850a();
        aq aqVar = (aq) ((ap) arVar.f2010a.m1850a()).f1997a.m1850a();
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCacheMaxSize(((Long) aqVar.f2003f.m1851a()).longValue());
        webSettings.setAppCachePath(new File(context.getCacheDir(), "admob").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("admob").getAbsolutePath());
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
    }
}
