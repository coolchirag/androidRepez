package com.brandall.nutter;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;

public final class im {
    public static ArrayList<String> m1178a(Context context, ArrayList<String> arrayList) {
        ArrayList<String> b;
        if (hc.f1269b) {
            ls.m1346c("musicAlgorithm");
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList2 = new ArrayList();
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (hc.f1269b) {
                ls.m1346c("Mounted: true");
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3 = new ArrayList();
            arrayList3 = new ArrayList();
            hg hgVar = new hg(context);
            ArrayList a = hgVar.m1088a();
            arrayList3 = hgVar.m1090b();
            if (a.isEmpty() || arrayList3.isEmpty() || a.size() != arrayList3.size()) {
                if (hc.f1269b) {
                    ls.m1347d("trackTag trackURI no data != size");
                }
                a.clear();
                arrayList3.clear();
                b = m1179b(context, arrayList);
            } else {
                if (hc.f1269b) {
                    ls.m1346c("trackTag trackURI populated == size: " + arrayList3.size());
                }
                je a2 = jd.m1200a(arrayList, a, arrayList3, 0.7d);
                if (a2.f1523a) {
                    if (hc.f1269b) {
                        ls.m1346c("myScoreProcess.exactMatch: true");
                    }
                    if (((String) a2.f1528f.get(0)).matches("ALGORITHM")) {
                        if (hc.f1269b) {
                            ls.m1346c("myScoreProcess.exactMatch ALGORITHM: true");
                        }
                        arrayList2.add((String) a2.f1528f.get(0));
                        arrayList2.add((String) a2.f1528f.get(1));
                        arrayList2.add((String) a2.f1528f.get(2));
                        b = arrayList2;
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("myScoreProcess.exactMatch ALGORITHM: false");
                        }
                        arrayList2.add((String) a2.f1528f.get(0));
                        arrayList2.add((String) a2.f1528f.get(1));
                        b = arrayList2;
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("myScoreProcess.exactMatch: false");
                    }
                    if (a2.f1524b) {
                        if (hc.f1269b) {
                            ls.m1346c("myScoreProcess.testMaxResult: true");
                        }
                        arrayList2.add((String) a2.f1529g.get(0));
                        arrayList2.add((String) a2.f1529g.get(1));
                        arrayList2.add((String) a2.f1529g.get(2));
                        arrayList2.add((String) a2.f1529g.get(3));
                        a = m1179b(context, arrayList);
                        if (((String) a.get(0)).matches("ERROR")) {
                            if (hc.f1269b) {
                                ls.m1347d("smaResults ERROR");
                                b = arrayList2;
                            }
                        } else if (((String) a.get(0)).matches("ALGORITHM")) {
                            if (hc.f1269b) {
                                ls.m1346c("smaResults ALGORITHM");
                            }
                            if (a.size() <= 3) {
                                if (hc.f1269b) {
                                    ls.m1346c("smaResults Exact match ALGORITHM");
                                }
                                arrayList2.clear();
                                arrayList2.add((String) a.get(0));
                                arrayList2.add((String) a.get(1));
                                arrayList2.add((String) a.get(2));
                                b = arrayList2;
                            } else if (Double.valueOf((String) arrayList2.get(3)).doubleValue() <= Double.valueOf((String) a.get(3)).doubleValue()) {
                                if (hc.f1269b) {
                                    ls.m1346c("Algorithm 2 is highest: " + ((String) arrayList2.get(3)) + " : " + ((String) a.get(3)));
                                }
                                arrayList2.clear();
                                arrayList2.add((String) a.get(0));
                                arrayList2.add((String) a.get(1));
                                arrayList2.add((String) a.get(2));
                                b = arrayList2;
                            } else if (hc.f1269b) {
                                ls.m1346c("Algorithm 1 is highest: " + ((String) arrayList2.get(3)) + " : " + ((String) a.get(3)));
                                b = arrayList2;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1346c("smaResults Exact match");
                            }
                            arrayList2.clear();
                            arrayList2.add((String) a.get(0));
                            arrayList2.add((String) a.get(1));
                            b = arrayList2;
                        }
                        b = arrayList2;
                    } else {
                        if (hc.f1269b) {
                            ls.m1347d("myScoreProcess.testMaxResult: false");
                        }
                        arrayList2.clear();
                        b = m1179b(context, arrayList);
                    }
                }
            }
            if (hc.f1269b) {
                ls.m1344a("toReturn Final: " + b.size() + " : " + b.toString());
            }
            arrayList.clear();
        } else {
            if (hc.f1269b) {
                ls.m1347d("media mounted: false");
            }
            arrayList2.add("ERROR");
            arrayList2.add("MOUNT");
            b = arrayList2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("MusicAlgorithm elapsed: " + currentTimeMillis2);
        }
        return b;
    }

    private static ArrayList<String> m1179b(Context context, ArrayList<String> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("secondMusicAlgorithm");
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList();
        kx a = kw.m1307a(context);
        je a2 = jd.m1200a(arrayList, a.f1627b, a.f1626a, 0.7d);
        if (a2.f1523a) {
            if (hc.f1269b) {
                ls.m1346c("SMA myScoreProcess.exactMatch: true");
            }
            if (((String) a2.f1528f.get(0)).matches("ALGORITHM")) {
                if (hc.f1269b) {
                    ls.m1346c("SMA myScoreProcess.exactMatch ALGORITHM: true");
                }
                arrayList3.add((String) a2.f1528f.get(0));
                arrayList3.add((String) a2.f1528f.get(1));
                arrayList3.add((String) a2.f1528f.get(2));
            } else {
                if (hc.f1269b) {
                    ls.m1346c("SMA myScoreProcess.exactMatch ALGORITHM: false");
                }
                arrayList3.add((String) a2.f1528f.get(0));
                arrayList3.add((String) a2.f1528f.get(1));
            }
        } else {
            if (hc.f1269b) {
                ls.m1346c("SMA myScoreProcess.exactMatch: false");
            }
            if (a2.f1524b) {
                if (hc.f1269b) {
                    ls.m1346c("SMA myScoreProcess.testMaxResult: true");
                }
                arrayList3.add((String) a2.f1529g.get(0));
                arrayList3.add((String) a2.f1529g.get(1));
                arrayList3.add((String) a2.f1529g.get(2));
                arrayList3.add((String) a2.f1529g.get(3));
            } else {
                if (hc.f1269b) {
                    ls.m1347d("SMA myScoreProcess.testMaxResult: false");
                }
                arrayList3.add("ERROR");
                arrayList3.add("MATCH");
            }
        }
        return arrayList3;
    }
}
