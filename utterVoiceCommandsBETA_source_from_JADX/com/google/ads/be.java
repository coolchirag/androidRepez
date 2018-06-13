package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0265q;
import com.google.ads.util.C0290d;
import java.util.HashMap;

public final class be implements as {
    private C0240b f2058a;

    public be() {
        this(new C0240b());
    }

    private be(C0240b c0240b) {
        this.f2058a = c0240b;
    }

    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("a");
        if (str == null) {
            C0290d.m1862a("Could not get the action parameter for open GMSG.");
        } else if (str.equals("webapp")) {
            r0 = this.f2058a;
            C0240b.m1646a(c0264p, new C0265q("webapp", hashMap));
        } else if (str.equals("expand")) {
            r0 = this.f2058a;
            C0240b.m1646a(c0264p, new C0265q("expand", hashMap));
        } else {
            r0 = this.f2058a;
            C0240b.m1646a(c0264p, new C0265q("intent", hashMap));
        }
    }
}
