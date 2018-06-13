package com.nuance.nmdp.speechkit;

import java.util.Enumeration;

public class de extends da {
    private static final bj f2668a = C0478j.m2563a(de.class);

    public de(String str, String str2, String str3, String str4, String str5, String str6, bh bhVar, String str7, short s, short s2, String str8, String str9, String str10, String str11, byte[] bArr, String str12, String str13, dp dpVar) {
        super((short) 514);
        if (f2668a.mo317b()) {
            f2668a.mo316b((Object) "PDXQueryBegin()");
        }
        m2376a("uid", str, (short) 193);
        m2376a("pdx_version", str2, (short) 193);
        m2376a("client_version", str3, (short) 193);
        m2376a("script_version", str4, (short) 193);
        m2376a("language", str5, (short) 193);
        m2376a("region", str6, (short) 193);
        m2372a("device_codec", (int) bhVar.m2119a());
        m2376a("dictation_language", str7, (short) 193);
        m2372a("lcd_width", (int) s);
        m2372a("lcd_height", (int) s2);
        if (str8 == null) {
            m2378a("carrier", new byte[0], (short) 5);
        } else {
            m2376a("carrier", str8, (short) 193);
        }
        m2376a("phone_model", str9, (short) 193);
        m2376a("phone_number", str10, (short) 193);
        m2376a("original_session_id", str11, (short) 22);
        if (bArr != null) {
            m2378a("new_session_id", bArr, (short) 22);
        }
        m2376a("application", str12, (short) 22);
        m2376a("nmaid", str12, (short) 22);
        m2376a("command", str13, (short) 22);
        if (dpVar != null) {
            Enumeration a = dpVar.mo257a();
            while (a.hasMoreElements()) {
                String str14 = (String) a.nextElement();
                switch (((cx) dpVar).m2380b(str14).m2350c()) {
                    case (short) 4:
                        m2378a(str14, dpVar.mo262d(str14), (short) 4);
                        break;
                    case (short) 5:
                        m2378a(str14, null, (short) 5);
                        break;
                    case (short) 16:
                        f2668a.mo322e("PDXQueryBegin() Sequence not accepted in optionalKeys");
                        break;
                    case (short) 22:
                        m2376a(str14, dpVar.mo264f(str14), (short) 22);
                        break;
                    case (short) 192:
                        m2372a(str14, dpVar.mo261c(str14));
                        break;
                    case (short) 193:
                        m2376a(str14, dpVar.mo263e(str14), (short) 193);
                        break;
                    case (short) 224:
                        f2668a.mo322e("PDXQueryBegin() Dictionary not accepted in optionalKeys");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
