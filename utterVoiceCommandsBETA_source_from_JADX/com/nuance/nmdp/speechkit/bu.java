package com.nuance.nmdp.speechkit;

public class bu {
    private static final bj f2493a = C0478j.m2563a(bu.class);

    public static String m2182a(String str) {
        if (f2493a.mo315a()) {
            f2493a.mo313a("Escaping XML reserved tokens (&, <, >, \" and ') of: " + str);
        }
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(str);
        while (i < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == '&') {
                i++;
                stringBuffer.insert(i, "amp;");
                i += 4;
            } else if (charAt == '<') {
                stringBuffer.deleteCharAt(i);
                stringBuffer.insert(i, "&lt;");
                i += 4;
            } else if (charAt == '>') {
                stringBuffer.deleteCharAt(i);
                stringBuffer.insert(i, "&gt;");
                i += 4;
            } else if (charAt == '\"') {
                stringBuffer.deleteCharAt(i);
                stringBuffer.insert(i, "&quot;");
                i += 6;
            } else if (charAt == '\'') {
                stringBuffer.deleteCharAt(i);
                stringBuffer.insert(i, "&apos;");
                i += 6;
            } else {
                i++;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (f2493a.mo315a()) {
            f2493a.mo313a("Final output: " + stringBuffer2);
        }
        return stringBuffer2;
    }

    public static boolean m2183a() {
        return false;
    }

    public static boolean m2184a(bh bhVar) {
        short a = bhVar.m2119a();
        return a == bh.f2459d.m2119a() || a == bh.f2460e.m2119a() || a == bh.f2461f.m2119a() || a == bh.f2462g.m2119a();
    }

    public static boolean m2185b() {
        return false;
    }

    public static boolean m2186b(bh bhVar) {
        short a = bhVar.m2119a();
        return a == bh.f2456a.m2119a() || a == bh.f2458c.m2119a() || a == bh.f2457b.m2119a();
    }

    public static bh m2187c(bh bhVar) {
        bh bhVar2 = (bhVar == bh.f2457b || bhVar == bh.f2458c) ? bh.f2456a : (bhVar == bh.f2460e || bhVar == bh.f2461f || bhVar == bh.f2463h || bhVar == bh.f2462g) ? bh.f2459d : bhVar;
        if (f2493a.mo319c()) {
            f2493a.mo318c("adjustCodecForBluetooth() " + bhVar.m2119a() + " -> " + bhVar2.m2119a());
        }
        return bhVar2;
    }
}
