package com.brandall.nutter;

import com.p013b.p014a.C0140a;
import com.p013b.p014a.p015a.C0139a;
import com.p013b.p014a.p016b.C0141a;

public final class kk {
    public static String m1303a(String str) {
        ls.m1346c("ExecuteTranslation tran");
        String str2 = "Sorry, but there was a translation error.";
        try {
            ls.m1346c("ExecuteTranslation translate");
            String str3 = "Sorry, but there was a translation error.";
            C0140a.m469a("0959890a-77e4-46c4-9d39-ac0772ae9178");
            C0140a.m471b("An6ZWJTt56nWFKhpIu+XUO1kvQPVKr4I562b0+FnzXI=");
            if (GlobalV.aa().matches("german")) {
                ls.m1346c("Language German");
                str3 = C0141a.m472a(str, C0139a.ENGLISH, C0139a.GERMAN);
                ls.m1344a("toTranslate: " + str);
                ls.m1344a("translatedText: " + str3);
                return str3;
            } else if (GlobalV.aa().matches("french")) {
                ls.m1346c("Language French");
                str3 = C0141a.m472a(str, C0139a.ENGLISH, C0139a.FRENCH);
                ls.m1344a("toTranslate: " + str);
                ls.m1344a("translatedText: " + str3);
                return str3;
            } else if (GlobalV.aa().matches("spanish")) {
                ls.m1346c("Language Spanish");
                str3 = C0141a.m472a(str, C0139a.ENGLISH, C0139a.SPANISH);
                ls.m1344a("toTranslate: " + str);
                ls.m1344a("translatedText: " + str3);
                return str3;
            } else if (GlobalV.aa().matches("italian")) {
                ls.m1346c("Language Italian");
                str3 = C0141a.m472a(str, C0139a.ENGLISH, C0139a.ITALIAN);
                ls.m1344a("toTranslate: " + str);
                ls.m1344a("translatedText: " + str3);
                return str3;
            } else if (GlobalV.aa().matches("polish")) {
                ls.m1346c("Language Polish");
                str3 = C0141a.m472a(str, C0139a.ENGLISH, C0139a.POLISH);
                ls.m1344a("toTranslate: " + str);
                ls.m1344a("translatedText: " + str3);
                return str3;
            } else if (!GlobalV.aa().matches("romanian")) {
                return str3;
            } else {
                ls.m1346c("Language Romanian");
                str3 = C0141a.m472a(str, C0139a.ENGLISH, C0139a.ROMANIAN);
                ls.m1344a("toTranslate: " + str);
                ls.m1344a("translatedText: " + str3);
                return str3;
            }
        } catch (Exception e) {
            ls.m1348e("runTranslation Exception");
            e.printStackTrace();
            return str2;
        }
    }
}
