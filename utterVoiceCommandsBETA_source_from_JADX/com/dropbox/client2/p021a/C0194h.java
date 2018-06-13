package com.dropbox.client2.p021a;

import java.util.Map;

public final class C0194h {
    public String f1851a;
    public String f1852b;

    public C0194h(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("error");
            if (obj instanceof String) {
                this.f1851a = (String) obj;
            } else if (obj instanceof Map) {
                for (Object obj2 : ((Map) obj2).values()) {
                    if (obj2 instanceof String) {
                        this.f1851a = (String) obj2;
                    }
                }
            }
            obj2 = map.get("user_error");
            if (obj2 instanceof String) {
                this.f1852b = (String) obj2;
            }
        }
    }
}
