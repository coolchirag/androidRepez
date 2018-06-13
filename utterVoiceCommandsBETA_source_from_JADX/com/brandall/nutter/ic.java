package com.brandall.nutter;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public final class ic {
    ArrayList<String> f1430a = new ArrayList();
    ArrayList<String> f1431b = new ArrayList();
    ArrayList<String> f1432c = new ArrayList();
    ArrayList<String> f1433d = new ArrayList();
    ArrayList<String> f1434e = new ArrayList();
    ArrayList<String> f1435f = new ArrayList();
    mp f1436g = new le();
    File f1437h = Environment.getExternalStorageDirectory();
    String f1438i = Environment.getExternalStorageDirectory().getAbsolutePath();
    File[] f1439j = this.f1437h.listFiles();
    List<File> f1440k = Arrays.asList(this.f1439j);
    private boolean f1441l = false;

    private List<File> m1163a(File file) {
        List<File> arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        List<File> asList = Arrays.asList(listFiles);
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : asList) {
                if (!(file2.isFile() || !file2.canRead() || file2.isHidden() || file2.getName().toLowerCase(Locale.US).startsWith("cache") || file2.getName().toLowerCase(Locale.US).startsWith("temp"))) {
                    arrayList.add(file2);
                    arrayList.addAll(m1163a(file2));
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<String> m1164a(Context context, ArrayList<String> arrayList, boolean z) {
        ls.m1346c("dirAlgorithm");
        long currentTimeMillis = System.currentTimeMillis();
        if (Environment.getExternalStorageState().equals("mounted")) {
            ls.m1346c("Mounted: true");
            ListIterator listIterator = arrayList.listIterator();
            jg a;
            if (z) {
                ls.m1346c("subDir: true");
                hf hfVar = new hf(context);
                this.f1434e = hfVar.m1084a();
                this.f1435f = hfVar.m1086b();
                if (this.f1434e.isEmpty() || this.f1435f.isEmpty() || this.f1434e.size() != this.f1435f.size()) {
                    ls.m1347d("!dirNameSP dirPathSP populated == size");
                    List<File> asList = Arrays.asList(Environment.getExternalStorageDirectory().listFiles());
                    loop2:
                    while (listIterator.hasNext()) {
                        String trim = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
                        for (File file : asList) {
                            if (!(file.isFile() || !file.canRead() || file.isHidden())) {
                                List<File> a2 = m1163a(file);
                                if (!(a2 == null || a2.isEmpty())) {
                                    Collections.sort(a2);
                                }
                                for (File file2 : a2) {
                                    String replaceAll = file2.getPath().replaceAll(this.f1438i, "").toLowerCase(Locale.US).replaceAll("\\/", " ").trim().replaceAll(" +", " ");
                                    ls.m1344a("gsdlLoop comparing: " + replaceAll + " : rawpass : " + trim);
                                    if (trim.matches(replaceAll)) {
                                        this.f1441l = true;
                                        this.f1432c.add(replaceAll);
                                        this.f1432c.add(file2.getPath());
                                        break loop2;
                                    }
                                    double a3 = this.f1436g.mo94a(trim, replaceAll);
                                    if (a3 > 0.99d) {
                                        this.f1432c.add("ALGORITHM");
                                        this.f1432c.add(replaceAll);
                                        this.f1432c.add(file2.getPath());
                                        this.f1441l = true;
                                        break loop2;
                                    } else if (a3 > 0.7d) {
                                        String valueOf = String.valueOf(a3);
                                        this.f1430a.add(replaceAll);
                                        this.f1431b.add(file2.getPath());
                                        this.f1433d.add(valueOf);
                                    }
                                }
                                continue;
                            }
                        }
                    }
                    if (this.f1441l) {
                        ls.m1346c("exactMatch: true");
                    } else {
                        ls.m1346c("exactMatch: false");
                        ls.m1344a("toDirName: " + this.f1430a.size() + " : " + this.f1430a.toString());
                        ls.m1344a("toDirPath: " + this.f1431b.size() + " : " + this.f1431b.toString());
                        ls.m1344a("toKeepTS: " + this.f1433d.size() + " " + this.f1433d.toString());
                        this.f1432c.clear();
                        if (this.f1433d.isEmpty()) {
                            ls.m1347d("toKeepTS is empty");
                            this.f1432c.add("ERROR");
                            this.f1432c.add("NOTFOUND");
                        } else {
                            ls.m1346c("toKeepTS has data");
                            a = jf.m1201a(this.f1433d, this.f1430a, this.f1431b);
                            this.f1432c.add("ALGORITHM");
                            this.f1432c.add(a.f1531a);
                            this.f1432c.add(a.f1532b);
                        }
                    }
                } else {
                    ls.m1346c("dirNameSP dirPathSP populated == size: " + this.f1435f.size());
                    je a4 = jd.m1200a(arrayList, this.f1434e, this.f1435f, 0.7d);
                    if (a4.f1523a) {
                        ls.m1346c("myScoreProcess.exactMatch: true");
                        if (((String) a4.f1528f.get(0)).matches("ALGORITHM")) {
                            ls.m1346c("myScoreProcess.exactMatch ALGORITHM: true");
                            this.f1432c.add((String) a4.f1528f.get(0));
                            this.f1432c.add((String) a4.f1528f.get(1));
                            this.f1432c.add((String) a4.f1528f.get(2));
                        } else {
                            ls.m1346c("myScoreProcess.exactMatch : true");
                            this.f1432c.add((String) a4.f1528f.get(0));
                            this.f1432c.add((String) a4.f1528f.get(1));
                        }
                    } else {
                        ls.m1346c("myScoreProcess.exactMatch: false");
                        if (a4.f1524b) {
                            ls.m1346c("myScoreProcess.testMaxResult: true");
                            this.f1432c.add((String) a4.f1529g.get(0));
                            this.f1432c.add((String) a4.f1529g.get(1));
                            this.f1432c.add((String) a4.f1529g.get(2));
                            this.f1432c.add((String) a4.f1529g.get(3));
                        } else {
                            ls.m1347d("myScoreProcess.testMaxResult: false");
                            this.f1432c.clear();
                            this.f1432c.add("ERROR");
                            this.f1432c.add("NOTFOUND");
                        }
                    }
                }
            } else {
                ls.m1346c("subDir: false");
                loop0:
                while (listIterator.hasNext()) {
                    String trim2 = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
                    for (File file22 : this.f1440k) {
                        if (!(file22.isFile() || !file22.canRead() || file22.isHidden() || file22.getName().startsWith("\\."))) {
                            ls.m1344a("outerloop comparing: " + file22.getName() + " : rawpass : " + trim2);
                            if (trim2.matches(file22.getName().toLowerCase(Locale.US).trim())) {
                                this.f1441l = true;
                                this.f1432c.add(file22.getName());
                                this.f1432c.add(file22.getPath());
                                break loop0;
                            }
                            double a5 = this.f1436g.mo94a(trim2.replaceAll("[^a-zA-Z]", "").trim(), file22.getName().toLowerCase(Locale.US).replaceAll("[^a-zA-Z]", "").trim().trim().replaceAll(" +", " "));
                            if (a5 > 0.99d) {
                                this.f1432c.add("ALGORITHM");
                                this.f1432c.add(file22.getName());
                                this.f1432c.add(file22.getPath());
                                this.f1441l = true;
                                break loop0;
                            } else if (a5 > 0.6d) {
                                String valueOf2 = String.valueOf(a5);
                                this.f1430a.add(file22.getName());
                                this.f1431b.add(file22.getPath());
                                this.f1433d.add(valueOf2);
                            }
                        }
                    }
                }
                if (this.f1441l) {
                    ls.m1346c("exactMatch: true");
                } else {
                    ls.m1346c("exactMatch: false");
                    ls.m1344a("toDirName: " + this.f1430a.size() + " : " + this.f1430a.toString());
                    ls.m1344a("toDirPath: " + this.f1431b.size() + " : " + this.f1431b.toString());
                    ls.m1344a("toKeepTS: " + this.f1433d.size() + " " + this.f1433d.toString());
                    this.f1432c.clear();
                    if (this.f1433d.isEmpty()) {
                        ls.m1347d("toKeepTS is empty");
                        this.f1432c.add("ERROR");
                        this.f1432c.add("NOTFOUND");
                    } else {
                        ls.m1346c("toKeepTS has data");
                        a = jf.m1201a(this.f1433d, this.f1430a, this.f1431b);
                        this.f1432c.add("ALGORITHM");
                        this.f1432c.add(a.f1531a);
                        this.f1432c.add(a.f1532b);
                    }
                }
            }
        } else {
            ls.m1347d("Mounted: false");
            this.f1432c.add("ERROR");
            this.f1432c.add("NOTMOUNTED");
        }
        ls.m1344a("dirAlg elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        ls.m1344a("toReturn : " + this.f1432c.size() + " : " + this.f1432c.toString());
        return this.f1432c;
    }
}
