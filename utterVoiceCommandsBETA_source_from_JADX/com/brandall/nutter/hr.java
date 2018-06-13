package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class hr {
    public static String m1141a(Context context) {
        String str = "error";
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://call_log/calls"), null, "type = 3", null, "date DESC");
            String str2 = str;
            while (query.moveToNext()) {
                str2 = query.getString(query.getColumnIndex("number"));
                if (str2 != null && !str2.matches("error") && !str2.matches("-1") && hc.f1269b) {
                    ls.m1346c("callNumber: " + str2);
                    break;
                }
            }
            query.close();
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
