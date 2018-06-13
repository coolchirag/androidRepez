package com.brandall.nutter;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public final class ka {
    private static String f1588a = "";

    public static String m1277a(Context context, ArrayList<String> arrayList) {
        String trim;
        Object obj;
        if (hc.f1269b) {
            ls.m1346c("killApp");
            ls.m1346c("appToKill: " + arrayList.size() + " : " + arrayList.toString());
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Object arrayList4 = new ArrayList();
        Locale locale = Locale.US;
        mp leVar = new le();
        List runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        PackageManager packageManager = context.getPackageManager();
        ListIterator listIterator = runningAppProcesses.listIterator();
        Object obj2 = null;
        while (listIterator.hasNext()) {
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) listIterator.next();
            if (!(runningAppProcessInfo.processName.toLowerCase(locale).trim().matches("system") || runningAppProcessInfo.processName.toLowerCase(locale).trim().matches("com.android.phone") || runningAppProcessInfo.processName.toLowerCase(locale).trim().matches("com.android.systemui"))) {
                try {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128));
                    if (!(applicationLabel == null || runningAppProcessInfo == null)) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            trim = ((String) it.next()).replaceAll("\\s", "").trim().replaceAll("[^a-zA-Z]", "").trim();
                            String trim2 = applicationLabel.toString().toLowerCase(locale).replaceAll("\\s", "").trim().replaceAll("[^a-zA-Z]", "").trim();
                            if (trim.matches(trim2)) {
                                obj = 1;
                                try {
                                    if (lx.ac(context)) {
                                        if (hc.f1269b) {
                                            ls.m1345b("ExecuteKill - Device rooted");
                                        }
                                        GlobalV.m786B("killApp");
                                        new kf(context).execute(new String[]{"kill", runningAppProcessInfo.processName.toLowerCase(locale).trim()});
                                        f1588a = "killed " + applicationLabel.toString().toLowerCase(locale).trim();
                                        obj2 = 1;
                                    } else {
                                        if (hc.f1269b) {
                                            ls.m1345b("ExecuteKill - Device not rooted");
                                        }
                                        if (id.m1165a(context).toLowerCase(Locale.US).trim().matches(applicationLabel.toString().toLowerCase(locale).trim())) {
                                            f1588a = "Sorry, Android won't allow me to kill the application you are currently using.";
                                            obj2 = 1;
                                        } else {
                                            if (m1278a(context, runningAppProcessInfo.processName.toLowerCase(locale).trim())) {
                                                f1588a = "killed " + applicationLabel.toString().toLowerCase(locale).trim();
                                                obj2 = 1;
                                            } else {
                                                f1588a = "Sorry, but something went wrong killing that application.";
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    if (hc.f1269b) {
                                        ls.m1348e("Package Label Exception");
                                    }
                                    obj2 = obj;
                                }
                            } else {
                                double a = leVar.mo94a(trim, trim2);
                                trim = String.valueOf(a);
                                if (a > 0.9d) {
                                    arrayList2.add(applicationLabel.toString().toLowerCase(locale).trim());
                                    arrayList3.add(runningAppProcessInfo.processName.toLowerCase(locale).trim());
                                    arrayList4.add(trim);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    obj = obj2;
                }
            }
        }
        if (obj2 == null) {
            if (hc.f1269b) {
                ls.m1344a("runningAppName: " + arrayList2.size() + " : " + arrayList2.toString());
                ls.m1344a("runningPackageName: " + arrayList3.size() + " : " + arrayList3.toString());
                ls.m1344a("toKeepTT: " + arrayList4.size() + " : " + arrayList4.toString());
            }
            if (arrayList4.isEmpty()) {
                if (hc.f1269b) {
                    ls.m1347d("toKeepTT2 empty!?");
                }
                f1588a = "Sorry, but I couldn't find a matching running application.";
            } else {
                obj2 = Collections.max(arrayList4);
                ListIterator listIterator2 = arrayList4.listIterator();
                String str = "";
                trim = "";
                while (listIterator2.hasNext()) {
                    int nextIndex = listIterator2.nextIndex();
                    if (listIterator2.next().equals(obj2)) {
                        trim = (String) arrayList2.get(nextIndex);
                        str = (String) arrayList3.get(nextIndex);
                        if (hc.f1269b) {
                            ls.m1346c("Highest TT: " + obj2 + " Name: " + trim + " CID: " + str);
                        }
                        if (lx.ac(context)) {
                            if (hc.f1269b) {
                                ls.m1345b("ExecuteKil - Device not rooted");
                            }
                            if (id.m1165a(context).toLowerCase(locale).trim().matches(trim.toLowerCase(locale).trim())) {
                                f1588a = "Sorry, Android won't allow me to kill the application you are currently using.";
                            } else if (m1278a(context, str)) {
                                f1588a = "Sorry, but something went wrong killing that application.";
                            } else {
                                f1588a = "killed " + trim;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1345b("ExecuteKil - Device rooted");
                            }
                            GlobalV.m786B("killApp");
                            new kf(context).execute(new String[]{"kill", str});
                            f1588a = "killed " + trim;
                        }
                    }
                }
                if (lx.ac(context)) {
                    if (hc.f1269b) {
                        ls.m1345b("ExecuteKil - Device not rooted");
                    }
                    if (id.m1165a(context).toLowerCase(locale).trim().matches(trim.toLowerCase(locale).trim())) {
                        f1588a = "Sorry, Android won't allow me to kill the application you are currently using.";
                    } else if (m1278a(context, str)) {
                        f1588a = "Sorry, but something went wrong killing that application.";
                    } else {
                        f1588a = "killed " + trim;
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1345b("ExecuteKil - Device rooted");
                    }
                    GlobalV.m786B("killApp");
                    new kf(context).execute(new String[]{"kill", str});
                    f1588a = "killed " + trim;
                }
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1344a("ExecuteKill elapsed: " + currentTimeMillis2);
        }
        return f1588a;
    }

    private static boolean m1278a(Context context, String str) {
        if (hc.f1269b) {
            ls.m1346c("killThisPackageIfRunning");
        }
        try {
            ((ActivityManager) context.getSystemService("activity")).killBackgroundProcesses(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
