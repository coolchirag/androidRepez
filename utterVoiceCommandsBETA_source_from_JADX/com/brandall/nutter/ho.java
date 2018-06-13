package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public final class ho {
    boolean f1297a = false;
    private ArrayList<String> f1298b = new ArrayList();
    private ArrayList<String> f1299c = new ArrayList();
    private ArrayList<String> f1300d = new ArrayList();

    public final ArrayList<String> m1129a(Context context, ArrayList<String> arrayList) {
        String toLowerCase;
        Exception exception;
        boolean z;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        mp leVar;
        ListIterator listIterator;
        int nextIndex;
        String trim;
        Iterator it;
        double a;
        String valueOf;
        Object max;
        ListIterator listIterator2;
        int nextIndex2;
        ls.m1346c("appAlgorithm");
        ls.m1346c("myApps: " + arrayList.size() + " : " + arrayList.toString());
        long currentTimeMillis = System.currentTimeMillis();
        hd hdVar = new hd(context);
        this.f1298b = hdVar.m1060a();
        this.f1299c = hdVar.m1062b();
        String str;
        boolean z2;
        if (this.f1298b.isEmpty() || this.f1299c.isEmpty()) {
            ls.m1347d("toAppName toPackageName not populated");
            this.f1298b.clear();
            this.f1299c.clear();
            System.gc();
            Runtime.getRuntime().gc();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 128);
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                toLowerCase = resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager).toString().toLowerCase(Locale.US);
                str = resolveInfo.activityInfo.applicationInfo.packageName;
                if (this.f1298b.contains(toLowerCase)) {
                    try {
                        ls.m1345b("Duplicate: " + toLowerCase);
                    } catch (Exception e) {
                        Exception exception2 = e;
                        z2 = false;
                        exception = exception2;
                    }
                } else if (arrayList.contains(toLowerCase)) {
                    ls.m1346c("Matched app label: " + toLowerCase);
                    ls.m1346c("Matched package name: " + str);
                    this.f1300d.add(toLowerCase);
                    this.f1300d.add(str);
                    z2 = true;
                    break;
                } else {
                    ls.m1345b("Didn't match: " + toLowerCase);
                    this.f1298b.add(toLowerCase);
                    this.f1299c.add(str);
                }
            }
            z2 = false;
            try {
                queryIntentActivities.clear();
                intent.setAction(null);
                intent.setData(null);
                ls.m1344a("toAppName: " + this.f1298b.size() + " : " + this.f1298b.toString());
                ls.m1344a("toPackageName: " + this.f1299c.size() + " : " + this.f1299c.toString());
                ls.m1346c("Broken for loop now");
                ls.m1344a("elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
                z = z2;
            } catch (Exception e2) {
                exception = e2;
                exception.printStackTrace();
                this.f1297a = true;
                z = z2;
                if (this.f1297a) {
                    this.f1300d.clear();
                    this.f1300d.add("oom");
                } else {
                    if (!z) {
                        ls.m1346c("exactMatch: " + z);
                        ls.m1346c("Establish Application Algorithms Running");
                        if (ke.m1284a(context)) {
                            ls.m1346c("shouldSpeak: true");
                            lc.m1313a(context, false, "One moment.");
                        }
                        arrayList2 = new ArrayList();
                        arrayList3 = new ArrayList();
                        arrayList4 = new ArrayList();
                        leVar = new le();
                        listIterator = this.f1298b.listIterator();
                        loop1:
                        while (listIterator.hasNext()) {
                            nextIndex = listIterator.nextIndex();
                            toLowerCase = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
                            trim = toLowerCase.replaceAll("\\s", "").trim().replaceAll("[^a-zA-Z]", "").trim();
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = ((String) it.next()).replaceAll("\\s", "").trim().replaceAll("[^a-zA-Z]", "").trim();
                                if (!trim.matches(str)) {
                                    a = leVar.mo94a(trim, str);
                                    if (a > 0.9d) {
                                        ls.m1344a("test2: " + a);
                                        this.f1300d.add(toLowerCase);
                                        this.f1300d.add((String) this.f1299c.get(nextIndex));
                                        this.f1300d.add("ALGORITHM");
                                        z = true;
                                        break loop1;
                                    }
                                    valueOf = String.valueOf(a);
                                    if (a > 0.35d) {
                                        arrayList2.add(toLowerCase);
                                        arrayList3.add((String) this.f1299c.get(nextIndex));
                                        arrayList4.add(valueOf);
                                    }
                                } else {
                                    this.f1300d.add(toLowerCase);
                                    this.f1300d.add((String) this.f1299c.get(nextIndex));
                                    z = true;
                                    break loop1;
                                }
                            }
                        }
                        if (!z) {
                            ls.m1346c("toKeepAN: " + arrayList2.size() + " " + arrayList2.toString());
                            ls.m1346c("toKeepPN: " + arrayList3.size() + " " + arrayList3.toString());
                            ls.m1346c("toKeepTT2: " + arrayList4.size() + " " + arrayList4.toString());
                            this.f1300d.clear();
                            if (!arrayList4.isEmpty()) {
                                max = Collections.max(arrayList4);
                                listIterator2 = arrayList4.listIterator();
                                while (listIterator2.hasNext()) {
                                    nextIndex2 = listIterator2.nextIndex();
                                    if (listIterator2.next().equals(max)) {
                                        str = (String) arrayList2.get(nextIndex2);
                                        String str2 = (String) arrayList3.get(nextIndex2);
                                        ls.m1346c("Highest TT2: " + max + " Name: " + str + " CID: " + str2);
                                        this.f1300d.add(str);
                                        this.f1300d.add(str2);
                                        this.f1300d.add("ALGORITHM");
                                        break;
                                    }
                                }
                            }
                            ls.m1347d("toKeepTT2 empty!?");
                        } else {
                            ls.m1346c("exactMatch: " + z);
                        }
                    } else {
                        ls.m1346c("exactMatch: " + z);
                    }
                    ls.m1344a("toReturn : " + this.f1300d.size() + " : " + this.f1300d.toString());
                    arrayList.clear();
                }
                return this.f1300d;
            }
        }
        ls.m1346c("toAppName toPackageName have data");
        ls.m1346c("toAppName: " + this.f1298b.size() + " " + this.f1298b.toString());
        ls.m1346c("PackageName: " + this.f1299c.size() + " " + this.f1299c.toString());
        ListIterator listIterator3 = this.f1298b.listIterator();
        while (listIterator3.hasNext()) {
            int nextIndex3 = listIterator3.nextIndex();
            String trim2 = ((String) listIterator3.next()).toString().toLowerCase(Locale.US).trim();
            if (arrayList.contains(trim2)) {
                ls.m1344a("Matched app label: " + trim2);
                ls.m1344a("Matched package name: " + ((String) this.f1299c.get(nextIndex3)).toString());
                this.f1300d.add(trim2);
                this.f1300d.add(((String) this.f1299c.get(nextIndex3)).toString());
                z2 = true;
                break;
            }
            ls.m1344a("Didn't match: " + trim2);
        }
        z2 = false;
        ls.m1344a("elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        z = z2;
        if (this.f1297a) {
            if (!z) {
                ls.m1346c("exactMatch: " + z);
                ls.m1346c("Establish Application Algorithms Running");
                if (ke.m1284a(context)) {
                    ls.m1346c("shouldSpeak: true");
                    lc.m1313a(context, false, "One moment.");
                }
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
                arrayList4 = new ArrayList();
                leVar = new le();
                listIterator = this.f1298b.listIterator();
                loop1:
                while (listIterator.hasNext()) {
                    nextIndex = listIterator.nextIndex();
                    toLowerCase = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
                    trim = toLowerCase.replaceAll("\\s", "").trim().replaceAll("[^a-zA-Z]", "").trim();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        str = ((String) it.next()).replaceAll("\\s", "").trim().replaceAll("[^a-zA-Z]", "").trim();
                        if (!trim.matches(str)) {
                            this.f1300d.add(toLowerCase);
                            this.f1300d.add((String) this.f1299c.get(nextIndex));
                            z = true;
                            break loop1;
                        }
                        a = leVar.mo94a(trim, str);
                        if (a > 0.9d) {
                            ls.m1344a("test2: " + a);
                            this.f1300d.add(toLowerCase);
                            this.f1300d.add((String) this.f1299c.get(nextIndex));
                            this.f1300d.add("ALGORITHM");
                            z = true;
                            break loop1;
                        }
                        valueOf = String.valueOf(a);
                        if (a > 0.35d) {
                            arrayList2.add(toLowerCase);
                            arrayList3.add((String) this.f1299c.get(nextIndex));
                            arrayList4.add(valueOf);
                        }
                    }
                }
                if (!z) {
                    ls.m1346c("toKeepAN: " + arrayList2.size() + " " + arrayList2.toString());
                    ls.m1346c("toKeepPN: " + arrayList3.size() + " " + arrayList3.toString());
                    ls.m1346c("toKeepTT2: " + arrayList4.size() + " " + arrayList4.toString());
                    this.f1300d.clear();
                    if (!arrayList4.isEmpty()) {
                        max = Collections.max(arrayList4);
                        listIterator2 = arrayList4.listIterator();
                        while (listIterator2.hasNext()) {
                            nextIndex2 = listIterator2.nextIndex();
                            if (listIterator2.next().equals(max)) {
                                str = (String) arrayList2.get(nextIndex2);
                                String str22 = (String) arrayList3.get(nextIndex2);
                                ls.m1346c("Highest TT2: " + max + " Name: " + str + " CID: " + str22);
                                this.f1300d.add(str);
                                this.f1300d.add(str22);
                                this.f1300d.add("ALGORITHM");
                                break;
                            }
                        }
                    }
                    ls.m1347d("toKeepTT2 empty!?");
                } else {
                    ls.m1346c("exactMatch: " + z);
                }
            } else {
                ls.m1346c("exactMatch: " + z);
            }
            ls.m1344a("toReturn : " + this.f1300d.size() + " : " + this.f1300d.toString());
            arrayList.clear();
        } else {
            this.f1300d.clear();
            this.f1300d.add("oom");
        }
        return this.f1300d;
    }
}
