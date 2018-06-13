package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0256h;
import com.google.ads.internal.C0264p;
import com.google.ads.util.C0290d;
import java.util.HashMap;
import org.ispeech.core.InternalResources;

public final class ba implements as {
    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("errors");
        C0290d.m1871e("Invalid " + ((String) hashMap.get(InternalResources.ISPEECH_SCREEN_TYPE)) + " request error: " + str);
        C0256h i = c0264p.m1744i();
        if (i != null) {
            i.m1701a(C0243e.INVALID_REQUEST);
        }
    }
}
