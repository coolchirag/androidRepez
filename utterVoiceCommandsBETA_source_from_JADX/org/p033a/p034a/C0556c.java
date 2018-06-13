package org.p033a.p034a;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class C0556c extends HashMap implements Map, C0554b {
    public static String m2815a(Map map) {
        if (map == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = 1;
        stringBuffer.append('{');
        for (Entry entry : map.entrySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuffer.append(',');
                obj2 = obj;
            }
            String valueOf = String.valueOf(entry.getKey());
            obj = entry.getValue();
            stringBuffer.append('\"');
            if (valueOf == null) {
                stringBuffer.append("null");
            } else {
                C0557d.m2820a(valueOf, stringBuffer);
            }
            stringBuffer.append('\"').append(':');
            stringBuffer.append(C0557d.m2819a(obj));
            stringBuffer.toString();
            obj = obj2;
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public final String mo472a() {
        return C0556c.m2815a(this);
    }

    public final String toString() {
        return C0556c.m2815a(this);
    }
}
