package com.dropbox.client2;

import com.dropbox.client2.p023b.C0201a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p033a.p034a.C0555a;

public final class C0218c {
    public static final C0201a<C0218c> f1882o = new C0219d();
    public long f1883a;
    public String f1884b;
    public String f1885c;
    public boolean f1886d;
    public String f1887e;
    public String f1888f;
    public String f1889g;
    public String f1890h;
    public String f1891i;
    public String f1892j;
    public String f1893k;
    public boolean f1894l;
    public boolean f1895m;
    public List<C0218c> f1896n;

    public C0218c(Map<String, Object> map) {
        this.f1883a = C0196a.m1521b(map, "bytes");
        this.f1884b = (String) map.get("hash");
        this.f1885c = (String) map.get("icon");
        this.f1886d = C0196a.m1520a(map, "is_dir");
        this.f1887e = (String) map.get("modified");
        this.f1888f = (String) map.get("client_mtime");
        this.f1889g = (String) map.get("path");
        this.f1890h = (String) map.get("root");
        this.f1891i = (String) map.get("size");
        this.f1892j = (String) map.get("mime_type");
        this.f1893k = (String) map.get("rev");
        this.f1894l = C0196a.m1520a(map, "thumb_exists");
        this.f1895m = C0196a.m1520a(map, "is_deleted");
        Object obj = map.get("contents");
        if (obj == null || !(obj instanceof C0555a)) {
            this.f1896n = null;
            return;
        }
        this.f1896n = new ArrayList();
        Iterator it = ((C0555a) obj).iterator();
        while (it.hasNext()) {
            obj = it.next();
            if (obj instanceof Map) {
                this.f1896n.add(new C0218c((Map) obj));
            }
        }
    }
}
