package com.brandall.nutter;

import android.content.Context;
import android.media.AudioManager;

public final class ke {
    public static boolean m1284a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (lx.m1435j(context) && audioManager.getRingerMode() == 0) ? false : (lx.m1433i(context) && audioManager.getRingerMode() == 1) ? false : audioManager.getStreamVolume(3) != 0;
    }

    public static boolean m1285b(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode() == 0;
    }

    public static boolean m1286c(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode() == 1;
    }

    public static boolean m1287d(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2;
    }

    public static boolean m1288e(Context context) {
        ((AudioManager) context.getSystemService("audio")).setRingerMode(0);
        return m1285b(context);
    }

    public static boolean m1289f(Context context) {
        ((AudioManager) context.getSystemService("audio")).setRingerMode(1);
        return m1286c(context);
    }

    public static boolean m1290g(Context context) {
        ((AudioManager) context.getSystemService("audio")).setRingerMode(2);
        return m1287d(context);
    }
}
