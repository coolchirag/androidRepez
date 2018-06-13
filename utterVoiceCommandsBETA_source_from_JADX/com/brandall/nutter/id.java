package com.brandall.nutter;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class id {
    public static String m1165a(Context context) {
        if (hc.f1269b) {
            ls.m1346c("getForeApp");
        }
        ArrayList arrayList = new ArrayList();
        arrayList = new ArrayList();
        String str = "none";
        Locale locale = Locale.US;
        hd hdVar = new hd(context);
        ArrayList a = hdVar.m1060a();
        ArrayList b = hdVar.m1062b();
        String str2;
        if (a.isEmpty()) {
            if (hc.f1269b) {
                ls.m1347d("toAppName not populated");
            }
            a.clear();
            b.clear();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
            intent.addFlags(262144);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 128);
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100) {
                    if (hc.f1269b) {
                        ls.m1345b("Process Name: " + runningAppProcessInfo.processName);
                    }
                    if (!runningAppProcessInfo.processName.matches("system") && !runningAppProcessInfo.processName.contains("systemui") && !runningAppProcessInfo.processName.matches("com.android.phone") && !runningAppProcessInfo.processName.matches("android.process.acore")) {
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            String toLowerCase = resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager).toString().toLowerCase(locale);
                            str2 = resolveInfo.activityInfo.applicationInfo.packageName;
                            if (runningAppProcessInfo.processName.matches(str2)) {
                                if (hc.f1269b) {
                                    ls.m1344a("Matched: " + runningAppProcessInfo.processName + " : " + str2);
                                }
                                if (!hc.f1269b) {
                                    return toLowerCase;
                                }
                                ls.m1344a("foregroundApp: " + toLowerCase);
                                return toLowerCase;
                            } else if (hc.f1269b) {
                                ls.m1345b("No match: " + runningAppProcessInfo.processName + " : " + str2);
                            }
                        }
                        continue;
                    } else if (hc.f1269b) {
                        ls.m1345b("excluded: " + runningAppProcessInfo.processName);
                    }
                }
            }
            return str;
        }
        if (hc.f1269b) {
            ls.m1346c("toAppName has data: " + a.size());
        }
        for (RunningAppProcessInfo runningAppProcessInfo2 : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo2.importance == 100) {
                if (hc.f1269b) {
                    ls.m1345b("Process Name: " + runningAppProcessInfo2.processName);
                }
                if (runningAppProcessInfo2.processName.matches("system") || runningAppProcessInfo2.processName.contains("systemui") || runningAppProcessInfo2.processName.matches("com.android.phone") || runningAppProcessInfo2.processName.matches("android.process.acore")) {
                    if (hc.f1269b) {
                        ls.m1345b("excluded: " + runningAppProcessInfo2.processName);
                    }
                } else if (b.contains(runningAppProcessInfo2.processName)) {
                    int indexOf = b.indexOf(runningAppProcessInfo2.processName);
                    str = runningAppProcessInfo2.processName;
                    str2 = (String) a.get(indexOf);
                    if (!hc.f1269b) {
                        return str2;
                    }
                    ls.m1344a("foregroundPackage: " + str);
                    ls.m1344a("foregroundApp: " + str2);
                    return str2;
                } else if (hc.f1269b) {
                    ls.m1344a("Foreground Ignored: pid: " + runningAppProcessInfo2.pid + " : uid :" + runningAppProcessInfo2.uid + " : " + runningAppProcessInfo2.processName);
                }
            }
        }
        return str;
    }

    public static boolean m1166b(Context context) {
        if (hc.f1269b) {
            ls.m1346c("EstablishForeground utterForeground");
        }
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100) {
                if (hc.f1269b) {
                    ls.m1345b("Process Name: " + runningAppProcessInfo.processName);
                }
                if (runningAppProcessInfo.processName.matches("com.brandall.nutter")) {
                    return true;
                }
            }
        }
        return false;
    }
}
