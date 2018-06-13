package org.p033a.p034a;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import org.p033a.p034a.p035a.C0550a;

public final class C0557d {
    private static Object m2817a(Reader reader) {
        try {
            return new C0550a().m2807a(reader);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object m2818a(String str) {
        return C0557d.m2817a(new StringReader(str));
    }

    public static String m2819a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (!(obj instanceof String)) {
            return obj instanceof Double ? (((Double) obj).isInfinite() || ((Double) obj).isNaN()) ? "null" : obj.toString() : obj instanceof Float ? (((Float) obj).isInfinite() || ((Float) obj).isNaN()) ? "null" : obj.toString() : obj instanceof Number ? obj.toString() : obj instanceof Boolean ? obj.toString() : obj instanceof C0554b ? ((C0554b) obj).mo472a() : obj instanceof Map ? C0556c.m2815a((Map) obj) : obj instanceof List ? C0555a.m2813a((List) obj) : obj.toString();
        } else {
            String str;
            StringBuffer stringBuffer = new StringBuffer("\"");
            String str2 = (String) obj;
            if (str2 == null) {
                str = null;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                C0557d.m2820a(str2, stringBuffer2);
                str = stringBuffer2.toString();
            }
            return stringBuffer.append(str).append("\"").toString();
        }
    }

    static void m2820a(String str, StringBuffer stringBuffer) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '/':
                    stringBuffer.append("\\/");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    if ((charAt >= '\u0000' && charAt <= '\u001f') || ((charAt >= '' && charAt <= '') || (charAt >= ' ' && charAt <= '⃿'))) {
                        String toHexString = Integer.toHexString(charAt);
                        stringBuffer.append("\\u");
                        for (int i2 = 0; i2 < 4 - toHexString.length(); i2++) {
                            stringBuffer.append('0');
                        }
                        stringBuffer.append(toHexString.toUpperCase());
                        break;
                    }
                    stringBuffer.append(charAt);
                    break;
            }
        }
    }
}
