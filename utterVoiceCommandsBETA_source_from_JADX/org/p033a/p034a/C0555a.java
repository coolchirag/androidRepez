package org.p033a.p034a;

import java.util.ArrayList;
import java.util.List;

public final class C0555a extends ArrayList implements List, C0554b {
    public static String m2813a(List list) {
        if (list == null) {
            return "null";
        }
        Object obj = 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (Object next : list) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuffer.append(',');
            }
            if (next == null) {
                stringBuffer.append("null");
            } else {
                stringBuffer.append(C0557d.m2819a(next));
            }
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public final String mo472a() {
        return C0555a.m2813a(this);
    }

    public final String toString() {
        return C0555a.m2813a(this);
    }
}
