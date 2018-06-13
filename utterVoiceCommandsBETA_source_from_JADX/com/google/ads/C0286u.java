package com.google.ads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0265q;
import java.util.HashMap;

public final class C0286u implements as {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        Context context = (Context) c0264p.m1742g().f2015f.m1850a();
        String str = (String) hashMap.get("a");
        if (str != null) {
            if (str.equals("resize")) {
                C0281p.m1813a(webView, (String) hashMap.get(QueryParamConst.U_NAME));
                return;
            } else if (str.equals("state")) {
                C0281p.m1812a((Activity) c0264p.m1742g().f2014e.m1853a(), webView, (String) hashMap.get(QueryParamConst.U_NAME));
                return;
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        if (C0285t.m1817a(intent, context)) {
            AdActivity.m1566a(c0264p, new C0265q("plusone", hashMap));
        } else if (!C0285t.m1817a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.plus")), context)) {
        } else {
            if (TextUtils.isEmpty((CharSequence) hashMap.get("d")) || TextUtils.isEmpty((CharSequence) hashMap.get("o")) || TextUtils.isEmpty((CharSequence) hashMap.get("c"))) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(QueryParamConst.U_NAME, "market://details?id=com.google.android.apps.plus");
                AdActivity.m1566a(c0264p, new C0265q("intent", hashMap2));
                return;
            }
            Builder builder = new Builder(context);
            builder.setMessage((CharSequence) hashMap.get("d")).setPositiveButton((CharSequence) hashMap.get("o"), new C0313x(c0264p)).setNegativeButton((CharSequence) hashMap.get("c"), new C0311v());
            builder.create().show();
        }
    }
}
