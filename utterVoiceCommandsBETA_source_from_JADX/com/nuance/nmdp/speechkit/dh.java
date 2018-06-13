package com.nuance.nmdp.speechkit;

import org.ispeech.core.HttpRequestParams;
import org.ispeech.core.InternalResources;

public class dh extends da {
    private static final bj f2671a = C0478j.m2563a(dh.class);

    public dh(dd ddVar) {
        String str = null;
        super((short) 515);
        if (f2671a.mo317b()) {
            f2671a.mo316b((Object) "PDXQueryParameter()");
        }
        m2376a("name", ddVar.m2353b(), (short) 193);
        if (ddVar.m2354c() == Byte.MAX_VALUE) {
            m2372a(InternalResources.ISPEECH_SCREEN_TYPE, 5);
        } else {
            m2372a(InternalResources.ISPEECH_SCREEN_TYPE, (int) ddVar.m2354c());
        }
        switch (ddVar.m2354c()) {
            case (byte) 1:
                m2372a("buffer_id", ((ct) ddVar).m2355a());
                return;
            case (byte) 2:
                m2376a(HttpRequestParams.TEXT, str, (short) 193);
                return;
            case (byte) 3:
                m2376a(HttpRequestParams.TEXT, str, (short) 193);
                return;
            case (byte) 4:
                m2378a("data", (byte[]) str, (short) 193);
                return;
            case (byte) 5:
                m2378a("dict", ((cw) ddVar).m2360a(), (short) 224);
                return;
            case (byte) 6:
            case (byte) 7:
            case (byte) 8:
                m2378a("dict", str.m2383b(), (short) 224);
                return;
            case Byte.MAX_VALUE:
                m2378a("dict", ((dl) ddVar).m2418d(), (short) 224);
                return;
            default:
                f2671a.mo322e("PDXQueryParameter() Unknown parameter type: " + ddVar.m2354c() + ". ");
                return;
        }
    }
}
