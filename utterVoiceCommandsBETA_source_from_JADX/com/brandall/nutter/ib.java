package com.brandall.nutter;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.provider.Settings.Secure;

public final class ib {
    static String m1160a() {
        try {
            return Build.SERIAL;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static String m1161a(Context context) {
        NameNotFoundException e;
        if (!jy.m1262m(context, "com.google.android.voicesearch")) {
            return "null";
        }
        String str = "null";
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo("com.google.android.voicesearch", 0).versionName;
            try {
                if (!hc.f1269b) {
                    return str2;
                }
                ls.m1346c("GVS version: " + str2);
                return str2;
            } catch (NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
        } catch (NameNotFoundException e3) {
            NameNotFoundException nameNotFoundException = e3;
            str2 = str;
            e = nameNotFoundException;
            e.printStackTrace();
            return str2;
        }
    }

    public static String m1162b(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
