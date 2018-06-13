package com.google.ads.p028a.p029a;

import com.google.ads.p028a.C0227h;
import java.util.HashMap;
import java.util.Map;

public class C0228a implements C0227h {
    private boolean f1931a = false;
    private boolean f1932b = false;
    private Map<String, Object> f1933c;

    public C0228a() {
        mo112b();
    }

    public C0228a mo111a(String str, Object obj) {
        this.f1933c.put(str, obj);
        return this;
    }

    public C0228a mo112b() {
        this.f1933c = new HashMap();
        return this;
    }

    public final boolean m1596c() {
        return this.f1931a;
    }

    public final Map<String, Object> m1597d() {
        return this.f1933c;
    }
}
