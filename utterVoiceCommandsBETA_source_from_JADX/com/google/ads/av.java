package com.google.ads;

import android.net.Uri;
import android.webkit.WebView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0269u;
import com.google.ads.util.C0290d;
import java.util.HashMap;
import java.util.Locale;

public final class av extends az {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get(QueryParamConst.U_NAME);
        if (str == null) {
            C0290d.m1871e("Could not get URL from click gmsg.");
            return;
        }
        C0269u l = c0264p.m1747l();
        if (l != null) {
            Uri parse = Uri.parse(str);
            str = parse.getHost();
            if (str != null && str.toLowerCase(Locale.US).endsWith(".admob.com")) {
                str = null;
                String path = parse.getPath();
                if (path != null) {
                    String[] split = path.split("/");
                    if (split.length >= 4) {
                        str = split[2] + "/" + split[3];
                    }
                }
                l.m1771a(str);
            }
        }
        super.mo107a(c0264p, hashMap, webView);
    }
}
