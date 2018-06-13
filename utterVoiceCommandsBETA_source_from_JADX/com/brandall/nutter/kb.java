package com.brandall.nutter;

import android.content.Context;
import android.net.ConnectivityManager;
import java.lang.reflect.Method;

public final class kb {
    private static void m1279a(Context context, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("In dataState");
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            connectivityManager.getClass().getMethod("setMobileDataEnabled", new Class[]{Boolean.TYPE}).invoke(connectivityManager, new Object[]{Boolean.valueOf(z)});
            int i = 0;
            while (i < 10) {
                Thread.sleep(100);
                if (m1280a(context) != z) {
                    i++;
                } else if (hc.f1269b) {
                    ls.m1347d("Attempt: " + i);
                    return;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Error: " + e);
            }
        }
    }

    public static boolean m1280a(Context context) {
        boolean booleanValue;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Method method = connectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
            method.setAccessible(true);
            booleanValue = ((Boolean) method.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Error: " + e);
            }
            booleanValue = false;
        }
        if (hc.f1269b) {
            ls.m1344a("Data returned: " + booleanValue);
        }
        return booleanValue;
    }

    public static void m1281b(Context context) {
        if (hc.f1269b) {
            ls.m1346c("In disable");
        }
        m1279a(context, false);
    }

    public static void m1282c(Context context) {
        if (hc.f1269b) {
            ls.m1346c("In enable");
        }
        m1279a(context, true);
    }
}
