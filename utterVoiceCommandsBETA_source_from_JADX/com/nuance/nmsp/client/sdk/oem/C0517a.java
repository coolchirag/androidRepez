package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.nuance.nmdp.speechkit.C0478j;
import com.nuance.nmdp.speechkit.bj;
import java.util.UUID;

public class C0517a {
    private static final bj f2983a = C0478j.m2563a(C0517a.class);
    private Context f2984b = null;

    public C0517a(Context context) {
        this.f2984b = context;
        context.getSystemService("phone");
    }

    public final String m2739a() {
        SharedPreferences sharedPreferences = this.f2984b.getSharedPreferences("nuance_sdk_pref", 0);
        String string = sharedPreferences.getString("NUANCE_NMSP_UID", "");
        if (string.length() == 0) {
            string = UUID.randomUUID().toString();
            if (string != null) {
                string = string.replaceAll("-", "");
            }
            Editor edit = sharedPreferences.edit();
            edit.putString("NUANCE_NMSP_UID", string);
            if (!edit.commit()) {
                f2983a.mo322e("Storing nuance sdk uid has failed");
            }
        }
        return string == null ? "" : string;
    }
}
