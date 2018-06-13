package com.brandall.nutter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;

public final class TaskerReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        ls.m1346c("TaskerReceiver onReceive");
        if ("com.twofortyfouram.locale.intent.action.FIRE_SETTING".equals(intent.getAction())) {
            gw.m1001a(intent);
            gw.m1002a(intent.getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE"));
            Bundle bundleExtra = intent.getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
            if (lu.m1355a(bundleExtra)) {
                String string = bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE");
                boolean booleanValue = Boolean.valueOf(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE1")).booleanValue();
                String string2 = bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE2");
                boolean booleanValue2 = Boolean.valueOf(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE3")).booleanValue();
                boolean booleanValue3 = Boolean.valueOf(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE4")).booleanValue();
                String string3 = bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE5");
                String string4 = bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE6");
                String string5 = bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE7");
                ls.m1346c("toSpeak: " + string);
                ls.m1346c("speak: " + booleanValue);
                ls.m1346c("Voice locale: " + string2);
                ls.m1346c("Start recog: " + booleanValue2);
                ls.m1346c("Store Only: " + booleanValue3);
                ls.m1346c("Variable Value: " + string3);
                ls.m1346c("Variable Name: " + string4);
                ls.m1346c("Recog Locale: " + string5);
                if (booleanValue3) {
                    ls.m1346c("Updated Tasker variable: " + string4 + " : " + string3);
                    hj hjVar = new hj(context);
                    ArrayList arrayList = new ArrayList();
                    arrayList = new ArrayList();
                    arrayList = hjVar.m1108a();
                    ArrayList c = hjVar.m1112c();
                    ListIterator listIterator = arrayList.listIterator();
                    if (arrayList.isEmpty()) {
                        ls.m1346c("dbut - row inserted - table empty");
                        hjVar.m1109a(string4, string3);
                    } else {
                        boolean z;
                        while (listIterator.hasNext()) {
                            int nextIndex = listIterator.nextIndex();
                            String trim = ((String) listIterator.next()).toString().replaceAll("\\p{P}", "").trim();
                            ls.m1344a("vnPass: " + trim);
                            if (trim.matches(string4.replaceAll("\\p{P}", "").trim())) {
                                hjVar.m1110a(string4, string3, ((Integer) c.get(nextIndex)).intValue());
                                ls.m1346c("dbut - row updated");
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        if (!z) {
                            ls.m1346c("dbut - row inserted");
                            hjVar.m1109a(string4, string3);
                        }
                    }
                    Editor edit = context.getSharedPreferences("utterPref", 0).edit();
                    edit.putBoolean("tasker_variables", true);
                    edit.commit();
                    return;
                } else if (!booleanValue) {
                    ((Vibrator) context.getSystemService("vibrator")).vibrate(100);
                    lt.m1353a(context, string, "Interactive Update", "utter!", booleanValue2, !string5.matches(""), !string2.matches(""), string, string2, string5);
                    return;
                } else if (string2.matches("")) {
                    lc.m1313a(context, booleanValue2, string);
                    return;
                } else {
                    ly.f1700a = true;
                    String[] split;
                    if (string2.contains("-")) {
                        split = string2.split("-");
                        if (split.length > 1) {
                            ls.m1344a("EUC-: gls0: " + split[0] + "  : gls1 :" + split[1]);
                            ly.f1701b = new Locale(split[0], split[1]);
                        } else {
                            ly.f1701b = new Locale(string2);
                        }
                    } else if (string2.contains("\\s")) {
                        split = string2.split("\\s");
                        if (split.length > 1) {
                            ls.m1344a("EUC ws: gls0: " + split[0] + "  : gls1 :" + split[1]);
                            ly.f1701b = new Locale(split[0], split[1]);
                        } else {
                            ly.f1701b = new Locale(string2);
                        }
                    } else if (string2.contains("_")) {
                        split = string2.split("_");
                        if (split.length > 1) {
                            ls.m1344a("EUC_: gls0: " + split[0] + "  : gls1 :" + split[1]);
                            ly.f1701b = new Locale(split[0], split[1]);
                        } else {
                            ly.f1701b = new Locale(string2);
                        }
                    } else {
                        ly.f1701b = new Locale(string2);
                    }
                    lc.m1313a(context, booleanValue2, string);
                    return;
                }
            }
            ls.m1348e("bundle was invalid");
            return;
        }
        ls.m1348e("TR error: " + String.format("Received unexpected Intent action %s", new Object[]{intent.getAction()}));
    }
}
