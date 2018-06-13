package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public final class at implements as {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        if (((String) hashMap.get("name")) == null) {
            C0290d.m1865b("Error: App event with no name parameter.");
            return;
        }
        hashMap.get("info");
        c0264p.m1755t();
    }
}
