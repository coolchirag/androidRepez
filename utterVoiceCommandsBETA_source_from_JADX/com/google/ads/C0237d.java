package com.google.ads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.ads.doubleclick.C0242a;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C0237d {
    public static final String f2026a = AdUtil.m1825a("emulator");
    private static final SimpleDateFormat f2027b = new SimpleDateFormat("yyyyMMdd");
    private static Method f2028c;
    private static Method f2029d;
    private C0244f f2030e = null;
    private Date f2031f = null;
    private Set<String> f2032g = null;
    private Map<String, Object> f2033h = null;
    private final Map<Class<?>, C0227h> f2034i = new HashMap();
    private Location f2035j = null;
    private boolean f2036k = false;
    private boolean f2037l = false;
    private Set<String> f2038m = null;

    static {
        f2028c = null;
        f2029d = null;
        try {
            for (Method method : Class.forName("com.google.analytics.tracking.android.AdMobInfo").getMethods()) {
                if (method.getName().equals("getInstance") && method.getParameterTypes().length == 0) {
                    f2028c = method;
                } else if (method.getName().equals("getJoinIds") && method.getParameterTypes().length == 0) {
                    f2029d = method;
                }
            }
            if (f2028c == null || f2029d == null) {
                f2028c = null;
                f2029d = null;
                C0290d.m1871e("No Google Analytics: Library Incompatible.");
            }
        } catch (ClassNotFoundException e) {
            C0290d.m1862a("No Google Analytics: Library Not Found.");
        } catch (Throwable th) {
            C0290d.m1862a("No Google Analytics: Error Loading Library");
        }
    }

    public final C0237d m1636a(C0227h c0227h) {
        if (c0227h != null) {
            this.f2034i.put(c0227h.getClass(), c0227h);
        }
        return this;
    }

    public final C0237d m1637a(C0244f c0244f) {
        this.f2030e = c0244f;
        return this;
    }

    public final C0237d m1638a(String str) {
        if (this.f2038m == null) {
            this.f2038m = new HashSet();
        }
        this.f2038m.add(str);
        return this;
    }

    public final C0237d m1639a(Set<String> set) {
        this.f2032g = set;
        return this;
    }

    public final <T> T m1640a(Class<T> cls) {
        return this.f2034i.get(cls);
    }

    public Map<String, Object> mo108a(Context context) {
        int i = 1;
        Map<String, Object> hashMap = new HashMap();
        if (this.f2032g != null) {
            hashMap.put("kw", this.f2032g);
        }
        if (this.f2030e != null) {
            hashMap.put("cust_gender", Integer.valueOf(this.f2030e.ordinal()));
        }
        if (this.f2031f != null) {
            hashMap.put("cust_age", f2027b.format(this.f2031f));
        }
        if (this.f2035j != null) {
            hashMap.put("uule", AdUtil.m1823a(this.f2035j));
        }
        if (this.f2036k) {
            hashMap.put("testing", Integer.valueOf(1));
        }
        if (m1643b(context)) {
            hashMap.put("adtest", "on");
        } else if (!this.f2037l) {
            C0290d.m1867c("To get test ads on this device, call adRequest.addTestDevice(" + (AdUtil.m1841c() ? "AdRequest.TEST_EMULATOR" : "\"" + AdUtil.m1822a(context) + "\"") + ");");
            this.f2037l = true;
        }
        C0228a c0228a = (C0228a) m1640a(C0228a.class);
        if (c0228a == null || !c0228a.m1596c()) {
            String str = "cipa";
            if (!C0285t.m1816a(context)) {
                i = 0;
            }
            hashMap.put(str, Integer.valueOf(i));
        } else {
            hashMap.put("pto", Integer.valueOf(1));
        }
        C0242a c0242a = (C0242a) m1640a(C0242a.class);
        if (c0242a != null && c0242a.m1597d() != null && !c0242a.m1597d().isEmpty()) {
            hashMap.put("extras", c0242a.m1597d());
        } else if (!(c0228a == null || c0228a.m1597d() == null || c0228a.m1597d().isEmpty())) {
            hashMap.put("extras", c0228a.m1597d());
        }
        if (c0242a != null) {
            CharSequence a = c0242a.m1657a();
            if (!TextUtils.isEmpty(a)) {
                hashMap.put("ppid", a);
            }
        }
        if (this.f2033h != null) {
            hashMap.put("mediation_extras", this.f2033h);
        }
        try {
            if (f2028c != null) {
                Map map = (Map) f2029d.invoke(f2028c.invoke(null, new Object[0]), new Object[0]);
                if (map != null && map.size() > 0) {
                    hashMap.put("analytics_join_id", map);
                }
            }
        } catch (Throwable th) {
            C0290d.m1868c("Internal Analytics Error:", th);
        }
        return hashMap;
    }

    public final C0237d m1642b(Set<String> set) {
        this.f2038m = set;
        return this;
    }

    public final boolean m1643b(Context context) {
        if (this.f2038m == null) {
            return false;
        }
        String a = AdUtil.m1822a(context);
        return a != null && this.f2038m.contains(a);
    }
}
