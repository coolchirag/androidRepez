package com.brandall.nutter;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class C0142a {
    public static String f910a = "B2nP5P212a";

    public static double m969a(Context context) {
        double d = 1.0d;
        if (lx.af(context)) {
            d = 1.005d;
        }
        if (lx.ak(context) || context.getSharedPreferences("utterPref", 0).getBoolean("user_name_condition", false)) {
            d += 0.005d;
        }
        if (lx.ah(context)) {
            d += 0.005d;
        }
        if (lx.aj(context)) {
            d += 0.005d;
        }
        if (lx.m1368G(context)) {
            d += 0.005d;
        }
        if (lx.m1370I(context)) {
            d += 0.005d;
        }
        if (lx.m1371J(context)) {
            d += 0.008d;
        }
        if (lx.m1374M(context)) {
            d += 0.009d;
        }
        if (lx.m1375N(context)) {
            d += 0.005d;
        }
        if (lx.m1376O(context)) {
            d += 0.005d;
        }
        if (lx.m1387Z(context)) {
            d += 0.009d;
        }
        if (!context.getSharedPreferences("utterPref", 0).getString("db_token_key", "").matches("")) {
            d += 0.005d;
        }
        if (!lx.m1377P(context).matches("")) {
            d += 0.005d;
        }
        if (!lx.m1378Q(context).matches("")) {
            d += 0.005d;
        }
        if (!lx.m1380S(context).matches("")) {
            d += 0.005d;
        }
        if (!lx.m1383V(context).matches("")) {
            d += 0.005d;
        }
        if (!lx.m1372K(context).matches("")) {
            d += 0.005d;
        }
        if (!lx.m1373L(context).matches("")) {
            d += 0.005d;
        }
        if (!mv.m1489b(context).equals(mw.NotInstalled)) {
            d += 0.01d;
        }
        if (jy.m1262m(context, "com.evernote")) {
            d += 0.005d;
        }
        if (jy.m1262m(context, "com.google.android.street")) {
            d += 0.005d;
        }
        if (jy.m1262m(context, "com.imdb.mobile")) {
            d += 0.005d;
        }
        if (jy.m1262m(context, "net.dinglisch.android.filer")) {
            d += 0.005d;
        }
        return Double.valueOf(new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US)).format(d)).doubleValue();
    }
}
