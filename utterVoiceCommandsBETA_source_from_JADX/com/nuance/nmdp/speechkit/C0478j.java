package com.nuance.nmdp.speechkit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.nuance.nmsp.client.sdk.oem.C0517a;
import com.nuance.nmsp.client.sdk.oem.C0518b;
import java.io.UnsupportedEncodingException;

public final class C0478j {
    private boolean f2815a = Build.PRODUCT.equals("sdk");
    private final Context f2816b;

    public C0478j(Object obj) {
        this.f2816b = (Context) obj;
    }

    public static bj m2563a(Class cls) {
        return new C0518b(cls);
    }

    public static void m2564a(Object obj, String str) {
        Log.i("SpeechKit", C0478j.m2568d(obj, str));
    }

    public static void m2565a(Object obj, String str, Throwable th) {
        Log.e("SpeechKit", C0478j.m2568d(obj, str), th);
    }

    public static void m2566b(Object obj, String str) {
        Log.w("SpeechKit", C0478j.m2568d(obj, str));
    }

    public static void m2567c(Object obj, String str) {
        Log.e("SpeechKit", C0478j.m2568d(obj, str));
    }

    private static String m2568d(Object obj, String str) {
        if (aw.f2383a || obj == null) {
            return str;
        }
        String name = obj.getClass().getName();
        if (name == null || name.length() == 0) {
            return str;
        }
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            lastIndexOf++;
            if (lastIndexOf < name.length()) {
                name = name.substring(lastIndexOf);
            }
        }
        return name + ": " + str;
    }

    public final String m2569a() {
        String networkOperatorName = ((TelephonyManager) this.f2816b.getSystemService("phone")).getNetworkOperatorName();
        return (networkOperatorName == null || networkOperatorName.length() == 0) ? "carrier" : networkOperatorName;
    }

    public final String m2570b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2816b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName != null && typeName.length() > 0) {
                return activeNetworkInfo.getTypeName();
            }
        }
        return null;
    }

    public final String m2571c() {
        String a = new C0517a(this.f2816b).m2739a();
        return (a == null || a.length() != 0) ? a : null;
    }

    public final bh m2572d() {
        return (((AudioManager) this.f2816b.getSystemService("audio")).isBluetoothScoOn() || this.f2815a) ? bh.f2456a : bh.f2457b;
    }

    public final bh m2573e() {
        return ((AudioManager) this.f2816b.getSystemService("audio")).isBluetoothScoOn() ? bh.f2456a : bh.f2457b;
    }

    public final byte[] m2574f() {
        try {
            ApplicationInfo applicationInfo = this.f2816b.getApplicationInfo();
            if (applicationInfo.name != null) {
                return applicationInfo.name.getBytes("UTF-8");
            }
            if (applicationInfo.packageName != null) {
                String[] split = applicationInfo.packageName.split(".");
                if (split.length > 1) {
                    return split[split.length - 1].getBytes("UTF-8");
                }
            }
            return new byte[0];
        } catch (UnsupportedEncodingException e) {
        }
    }

    public final byte[] m2575g() {
        try {
            ApplicationInfo applicationInfo = this.f2816b.getApplicationInfo();
            if (applicationInfo.packageName != null) {
                return applicationInfo.packageName.getBytes("UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
        }
        return new byte[0];
    }
}
