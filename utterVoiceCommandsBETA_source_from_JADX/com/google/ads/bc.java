package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0270v;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import com.google.ads.util.C0299n;
import com.google.ads.util.ac;
import java.util.HashMap;

public final class bc implements as {
    private static void m1650a(HashMap<String, String> hashMap, String str, ac<Integer> acVar) {
        try {
            String str2 = (String) hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                acVar.m1852a(Integer.valueOf(str2));
            }
        } catch (NumberFormatException e) {
            C0290d.m1862a("Could not parse \"" + str + "\" constant.");
        }
    }

    private static void m1651b(HashMap<String, String> hashMap, String str, ac<Long> acVar) {
        try {
            String str2 = (String) hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                acVar.m1852a(new Long(str2));
            }
        } catch (NumberFormatException e) {
            C0290d.m1862a("Could not parse \"" + str + "\" constant.");
        }
    }

    private static void m1652c(HashMap<String, String> hashMap, String str, ac<String> acVar) {
        String str2 = (String) hashMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            acVar.m1852a(str2);
        }
    }

    public final void mo107a(C0264p c0264p, HashMap<String, String> hashMap, WebView webView) {
        ar g = c0264p.m1742g();
        aq aqVar = (aq) ((ap) g.f2010a.m1850a()).f1997a.m1850a();
        m1650a((HashMap) hashMap, "min_hwa_banner", aqVar.f1998a);
        m1650a((HashMap) hashMap, "min_hwa_overlay", aqVar.f1999b);
        m1652c(hashMap, "mraid_banner_path", aqVar.f2000c);
        m1652c(hashMap, "mraid_expanded_banner_path", aqVar.f2001d);
        m1652c(hashMap, "mraid_interstitial_path", aqVar.f2002e);
        m1651b(hashMap, "ac_max_size", aqVar.f2003f);
        m1651b(hashMap, "ac_padding", aqVar.f2004g);
        m1651b(hashMap, "ac_total_quota", aqVar.f2005h);
        m1651b(hashMap, "db_total_quota", aqVar.f2006i);
        m1651b(hashMap, "db_quota_per_origin", aqVar.f2007j);
        m1651b(hashMap, "db_quota_step_size", aqVar.f2008k);
        AdWebView j = c0264p.m1745j();
        if (AdUtil.f2240a >= 11) {
            C0299n.m1878a(j.getSettings(), g);
            C0299n.m1878a(webView.getSettings(), g);
        }
        if (!((C0270v) g.f2020k.m1850a()).m1798a()) {
            boolean f = j.m1678f();
            boolean z = AdUtil.f2240a < ((Integer) aqVar.f1998a.m1851a()).intValue();
            if (!z && f) {
                C0290d.m1862a("Re-enabling hardware acceleration for a banner after reading constants.");
                j.m1675c();
            } else if (z && !f) {
                C0290d.m1862a("Disabling hardware acceleration for a banner after reading constants.");
                j.m1674b();
            }
        }
        aqVar.f2009l.m1852a(Boolean.valueOf(true));
    }
}
