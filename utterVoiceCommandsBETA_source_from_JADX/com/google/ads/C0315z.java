package com.google.ads;

import com.google.ads.internal.C0270v;
import com.google.ads.util.C0288b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C0315z {
    private static final Map<String, C0245g> f2313a = Collections.unmodifiableMap(new aa());
    private final String f2314b;
    private final String f2315c;
    private final List<C0275j> f2316d;
    private final Integer f2317e;
    private final Integer f2318f;
    private final List<String> f2319g;
    private final List<String> f2320h;
    private final List<String> f2321i;

    private C0315z(String str, String str2, List<C0275j> list, Integer num, Integer num2, List<String> list2, List<String> list3, List<String> list4) {
        C0288b.m1856a(str);
        this.f2314b = str;
        this.f2315c = str2;
        this.f2316d = list;
        this.f2317e = num;
        this.f2318f = num2;
        this.f2319g = list2;
        this.f2320h = list3;
        this.f2321i = list4;
    }

    private static C0275j m1885a(JSONObject jSONObject) {
        HashMap hashMap;
        String string = jSONObject.getString("id");
        String optString = jSONObject.optString("allocation_id", null);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        List a = C0315z.m1887a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        HashMap hashMap2 = new HashMap(0);
        if (optJSONObject != null) {
            hashMap = new HashMap(optJSONObject.length());
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.getString(str));
            }
        } else {
            hashMap = hashMap2;
        }
        return new C0275j(optString, string, arrayList, a, hashMap);
    }

    public static C0315z m1886a(String str) {
        Integer valueOf;
        List a;
        List a2;
        List a3;
        Integer num;
        Integer num2 = null;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("qdata");
        String string2 = jSONObject.has("ad_type") ? jSONObject.getString("ad_type") : null;
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0315z.m1885a(jSONArray.getJSONObject(i)));
        }
        jSONObject = jSONObject.optJSONObject("settings");
        if (jSONObject != null) {
            valueOf = jSONObject.has("refresh") ? Integer.valueOf(jSONObject.getInt("refresh")) : null;
            if (jSONObject.has("ad_network_timeout_millis")) {
                num2 = Integer.valueOf(jSONObject.getInt("ad_network_timeout_millis"));
            }
            a = C0315z.m1887a(jSONObject, "imp_urls");
            a2 = C0315z.m1887a(jSONObject, "click_urls");
            a3 = C0315z.m1887a(jSONObject, "nofill_urls");
            num = num2;
        } else {
            a3 = null;
            a = null;
            a2 = null;
            num = null;
            valueOf = null;
        }
        return new C0315z(string, string2, arrayList, valueOf, num, a, a2, a3);
    }

    private static List<String> m1887a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List<String> arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return arrayList;
    }

    public final boolean m1888a() {
        return this.f2318f != null;
    }

    public final int m1889b() {
        return this.f2318f.intValue();
    }

    public final String m1890c() {
        return this.f2314b;
    }

    public final boolean m1891d() {
        return this.f2317e != null;
    }

    public final int m1892e() {
        return this.f2317e.intValue();
    }

    public final List<C0275j> m1893f() {
        return this.f2316d;
    }

    public final List<String> m1894g() {
        return this.f2319g;
    }

    public final List<String> m1895h() {
        return this.f2320h;
    }

    public final List<String> m1896i() {
        return this.f2321i;
    }

    public final C0270v m1897j() {
        if (this.f2315c == null) {
            return null;
        }
        if ("interstitial".equals(this.f2315c)) {
            return C0270v.f2203a;
        }
        C0245g c0245g = (C0245g) f2313a.get(this.f2315c);
        return c0245g != null ? C0270v.m1796a(c0245g) : null;
    }
}
