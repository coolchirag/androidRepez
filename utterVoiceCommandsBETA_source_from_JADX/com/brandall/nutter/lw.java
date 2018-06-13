package com.brandall.nutter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;

public final class lw {
    public static String m1360a(Context context) {
        ArrayList arrayList = new ArrayList();
        SharedPreferences sharedPreferences = context.getSharedPreferences("utterPref", 0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(sharedPreferences.getString("sms_message_body", "null"));
        arrayList2.add(sharedPreferences.getString("sms_message_originator", ""));
        arrayList2.add(sharedPreferences.getString("sms_message_timestamp", ""));
        arrayList2.add(String.valueOf(sharedPreferences.getBoolean("sms_known_contact", false)));
        if (arrayList2.size() != 4) {
            return "Sorry, I don't appear to have any recent message data";
        }
        ls.m1346c("toReturn: " + arrayList2.size() + " " + arrayList2.toString());
        return !((String) arrayList2.get(0)).matches("null") ? ((String) arrayList2.get(3)).matches("true") ? "You received a text from, " + ((String) arrayList2.get(1)) + ", at, " + ((String) arrayList2.get(2)) + ", saying, " + ((String) arrayList2.get(0)) : "You received a text from the number, " + ((String) arrayList2.get(1)).replaceAll(".(?=.)", "$0 ").trim() + ", at, " + ((String) arrayList2.get(2)) + ", saying, " + ((String) arrayList2.get(0)) : "Sorry, I don't appear to have any recent message data";
    }

    public static void m1361a(Context context, String str, String str2) {
        boolean z;
        ls.m1346c("receivedSMS: body: " + str + " : originator: " + str2);
        String c = hx.m1152c(context, str2);
        if (c.matches("error")) {
            z = false;
        } else {
            z = true;
            str2 = c;
        }
        c = jh.m1203a().replaceFirst("It's ", "");
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("sms_message_body", str);
        edit.putString("sms_message_originator", str2);
        edit.putString("sms_message_timestamp", c);
        edit.putBoolean("sms_known_contact", z);
        edit.commit();
    }
}
