package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;

public final class ht {
    private static Pattern f1406a = Pattern.compile(".*\\bwifi\\b.*");
    private static Pattern f1407b = Pattern.compile(".*\\bdata\\b.*");
    private static Pattern f1408c = Pattern.compile(".*\\bbluetooth\\b.*");
    private static Pattern f1409d = Pattern.compile(".*\\bairplane\\b.*");
    private static Pattern f1410e = Pattern.compile(".*\\baeroplane\\b.*");

    public static hv m1145a(ArrayList<String> arrayList) {
        ls.m1345b("connectionEstablish");
        ls.m1346c("connectionData: " + arrayList.size() + " : " + arrayList.toString());
        ht htVar = new ht();
        htVar.getClass();
        hv hvVar = new hv(htVar);
        ListIterator listIterator = arrayList.listIterator();
        Arrays.asList(arrayList.toArray());
        Locale locale = Locale.US;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            CharSequence trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
            ls.m1345b("rawpass: " + trim);
            int i5 = f1408c.matcher(trim).matches() ? i3 + 1 : i3;
            i3 = f1407b.matcher(trim).matches() ? i2 + 1 : i2;
            i2 = f1406a.matcher(trim).matches() ? i4 + 1 : i4;
            if (f1409d.matcher(trim).matches() || f1410e.matcher(trim).matches()) {
                i++;
                i4 = i2;
                i2 = i3;
                i3 = i5;
            } else {
                i4 = i2;
                i2 = i3;
                i3 = i5;
            }
        }
        if (i3 > i2 && i3 > i4 && i3 > i) {
            hvVar.f1417a = hu.bluetooth;
        } else if (i2 > i3 && i2 > i4 && i2 > i) {
            hvVar.f1417a = hu.data;
        } else if (i4 > i2 && i4 > i3 && i4 > i) {
            hvVar.f1417a = hu.wifi;
        } else if (i <= i2 || i <= i3 || i <= i4) {
            hvVar.f1417a = hu.multipleCommand;
        } else {
            hvVar.f1417a = hu.airplance;
        }
        return hvVar;
    }

    @SuppressLint({"NewApi"})
    public static boolean m1146a(Context context) {
        return VERSION.SDK_INT != 17 ? System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 : Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }
}
