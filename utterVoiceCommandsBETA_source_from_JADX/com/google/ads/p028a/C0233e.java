package com.google.ads.p028a;

import com.google.ads.util.C0290d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class C0233e {
    public final void m1603a(Map<String, String> map) {
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            C0235g c0235g = (C0235g) field.getAnnotation(C0235g.class);
            if (c0235g != null) {
                hashMap.put(c0235g.m1604a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            C0290d.m1871e("No server options fields detected.  To suppress this message either add a field with the @Parameter annotation, or override the load() method");
        }
        for (Entry entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    C0290d.m1865b("Server Option '" + ((String) entry.getKey()) + "' could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    C0290d.m1865b("Server Option '" + ((String) entry.getKey()) + "' could not be set: Bad Type");
                }
            } else {
                C0290d.m1871e("Unexpected Server Option: " + ((String) entry.getKey()) + " = '" + ((String) entry.getValue()) + "'");
            }
        }
        String str = null;
        for (Field field3 : hashMap.values()) {
            String str2;
            if (((C0235g) field3.getAnnotation(C0235g.class)).m1605b()) {
                C0290d.m1865b("Required Server Option missing: " + ((C0235g) field3.getAnnotation(C0235g.class)).m1604a());
                str2 = (str == null ? "" : str + ", ") + ((C0235g) field3.getAnnotation(C0235g.class)).m1604a();
            } else {
                str2 = str;
            }
            str = str2;
        }
        if (str != null) {
            throw new C0234f("Required Server Option(s) missing: " + str);
        }
    }
}
