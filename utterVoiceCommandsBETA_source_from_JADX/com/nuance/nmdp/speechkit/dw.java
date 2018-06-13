package com.nuance.nmdp.speechkit;

import android.os.Build;
import android.os.Build.VERSION;

public final class dw {
    public static final int f2702a = Integer.parseInt(VERSION.SDK);
    public static final boolean f2703b;
    public static final boolean f2704c;
    private static boolean f2705d;
    private static boolean f2706e;
    private static final boolean f2707f;
    private static final boolean f2708g;

    static {
        String str;
        boolean z = false;
        try {
            str = (String) Build.class.getField("MANUFACTURER").get(null);
        } catch (Exception e) {
            str = "";
        }
        String str2 = Build.MODEL;
        boolean z2 = str.equalsIgnoreCase("samsung") && (str2.equalsIgnoreCase("SGH-T959") || str2.equalsIgnoreCase("SAMSUNG-SGH-I897") || str2.equalsIgnoreCase("SGH-I897") || str2.equalsIgnoreCase("GT-I9000"));
        f2705d = z2;
        z2 = str.equalsIgnoreCase("htc") && (str2.equalsIgnoreCase("PC36100") || str2.equalsIgnoreCase("ADR6300") || str2.equalsIgnoreCase("HTC Glacier") || str2.equalsIgnoreCase("T-Mobile myTouch 4G") || str2.equalsIgnoreCase("T-Mobile G2"));
        f2703b = z2;
        f2706e = str2.equalsIgnoreCase("Motorola_i1");
        z2 = str.equalsIgnoreCase("Motorola") && str2.equalsIgnoreCase("MB860");
        f2708g = z2;
        boolean z3 = str.equalsIgnoreCase("samsung") && f2702a == 8;
        f2707f = z3;
        if (f2705d || f2706e) {
            z = true;
        }
        f2704c = z;
        z3 = f2705d;
        z3 = f2708g;
    }
}
