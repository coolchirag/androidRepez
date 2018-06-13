package com.google.ads;

import android.webkit.WebView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public class az implements as {
    public void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get(QueryParamConst.U_NAME);
        if (str == null) {
            C0290d.m1871e("Could not get URL from click gmsg.");
        } else {
            new Thread(new C0278m(str, webView.getContext().getApplicationContext())).start();
        }
    }
}
