package com.brandall.nutter;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class nm {
    public static void m1497a(Context context) {
        lx.m1406c(context, 100.0d);
    }

    public static void m1498b(Context context) {
        lx.m1406c(context, 10.0d);
    }

    public static void m1499c(Context context) {
        if (lx.ah(context)) {
            lx.m1406c(context, lx.ai(context) + 20.0d);
            return;
        }
        double h = (double) (((m1504h(context) + 1) / m1505i(context)) * 100);
        ls.m1344a("givp: " + h);
        lx.m1406c(context, h);
        if (VERSION.SDK_INT < 11) {
            ls.m1344a("!>= honeycomb ");
            ((AudioManager) context.getSystemService("audio")).adjustVolume(1, 0);
        }
    }

    public static void m1500d(Context context) {
        if (lx.ah(context)) {
            lx.m1406c(context, lx.ai(context) - 20.0d);
            return;
        }
        double h = (double) (((m1504h(context) - 1) / m1505i(context)) * 100);
        ls.m1344a("gdvp: " + h);
        lx.m1406c(context, h);
        if (VERSION.SDK_INT < 11) {
            ls.m1344a("!>= honeycomb ");
            ((AudioManager) context.getSystemService("audio")).adjustVolume(-1, 0);
        }
    }

    public static void m1501e(Context context) {
        if (VERSION.SDK_INT < 11 && lx.ah(context)) {
            ((AudioManager) context.getSystemService("audio")).setStreamVolume(3, GlobalV.m783A(), 0);
        }
    }

    public static void m1502f(Context context) {
        if (VERSION.SDK_INT >= 16) {
            ((AudioManager) context.getSystemService("audio")).setStreamVolume(1, GlobalV.m849i(), 0);
        }
    }

    public static double m1503g(Context context) {
        double ai = lx.ai(context);
        ls.m1344a("uvv: " + ai);
        if (!lx.ah(context) || ai <= 0.0d) {
            return 0.0d;
        }
        if (VERSION.SDK_INT >= 11) {
            ls.m1344a(">= honeycomb ");
            double h = (double) ((m1504h(context) / m1505i(context)) * 100);
            ls.m1344a("vp: " + h);
            DecimalFormat decimalFormat = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));
            if (ai > h) {
                ls.m1346c("Volume set to: " + (h / 100.0d));
                return Double.valueOf(decimalFormat.format(h / 100.0d)).doubleValue();
            }
            ls.m1346c("Volume set to: " + (ai / 100.0d));
            return Double.valueOf(decimalFormat.format(ai / 100.0d)).doubleValue();
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        GlobalV.m837f(m1504h(context));
        double i = (((double) m1505i(context)) * lx.ai(context)) / 100.0d;
        ls.m1344a("vv: " + i);
        if (i > ((double) m1504h(context))) {
            i = (double) m1504h(context);
        }
        audioManager.setStreamVolume(3, (int) Math.round(i), 0);
        ls.m1346c("Volume set to: " + i);
        return 0.0d;
    }

    private static int m1504h(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
    }

    private static int m1505i(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(3);
    }
}
