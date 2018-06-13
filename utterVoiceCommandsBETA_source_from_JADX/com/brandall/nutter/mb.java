package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class mb {
    @SuppressLint({"NewApi"})
    public static void m1469a(Context context, int i, int i2) {
        if (hc.f1269b) {
            ls.m1344a("SH - commandInt: " + i);
            ls.m1344a("SH - outcome: " + i2);
        }
        if (hc.f1270c) {
            if (!lx.m1450s(context).matches("null")) {
                kz.f1643l = i;
                kz.f1644m = i2;
                kz.f1633b = true;
            }
            if (VERSION.SDK_INT >= 11) {
                new kz(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new kz(context).execute(new Void[0]);
            }
        }
    }

    public static boolean m1470a(Context context) {
        return (lx.m1450s(context).matches("null") && lx.m1436k(context).matches("null")) ? false : true;
    }
}
