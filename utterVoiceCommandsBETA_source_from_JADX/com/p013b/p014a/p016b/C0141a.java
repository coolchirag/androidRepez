package com.p013b.p014a.p016b;

import com.p013b.p014a.C0140a;
import com.p013b.p014a.p015a.C0139a;
import java.net.URL;
import java.net.URLEncoder;

public final class C0141a extends C0140a {
    public static String m472a(String str, C0139a c0139a, C0139a c0139a2) {
        if (str.getBytes("UTF-8").length > 10240) {
            throw new RuntimeException("TEXT_TOO_LARGE - Microsoft Translator (Translate) can handle up to 10,240 bytes per request");
        }
        C0140a.m468a();
        return C0140a.m467a(new URL("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?" + ((a != null ? "appId=" + URLEncoder.encode(a, "UTF-8") : "") + "&from=" + URLEncoder.encode(c0139a.toString(), "UTF-8") + "&to=" + URLEncoder.encode(c0139a2.toString(), "UTF-8") + "&text=" + URLEncoder.encode(str, "UTF-8"))));
    }
}
