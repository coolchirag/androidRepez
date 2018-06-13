package com.brandall.nutter;

import java.util.ArrayList;

public final class ig {
    public static ArrayList<String> m1170a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        if (hc.f1269b) {
            ls.m1346c("musicAlgorithm");
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList4 = new ArrayList();
        je a = jd.m1200a(arrayList, arrayList2, arrayList3, -1.0d);
        if (a.f1523a) {
            if (hc.f1269b) {
                ls.m1346c("myScoreProcess.exactMatch: true");
            }
            if (((String) a.f1528f.get(0)).matches("ALGORITHM")) {
                if (hc.f1269b) {
                    ls.m1346c("myScoreProcess.exactMatch ALGORITHM: true");
                }
                arrayList4.add((String) a.f1528f.get(1));
                arrayList4.add((String) a.f1528f.get(2));
            } else {
                if (hc.f1269b) {
                    ls.m1346c("myScoreProcess.exactMatch ALGORITHM: false");
                }
                arrayList4.add((String) a.f1528f.get(0));
                arrayList4.add((String) a.f1528f.get(1));
            }
        } else {
            if (hc.f1269b) {
                ls.m1346c("myScoreProcess.exactMatch: false");
            }
            if (a.f1524b) {
                if (hc.f1269b) {
                    ls.m1346c("myScoreProcess.testMaxResult: true");
                }
                arrayList4.add((String) a.f1529g.get(1));
                arrayList4.add((String) a.f1529g.get(2));
            } else {
                if (hc.f1269b) {
                    ls.m1347d("myScoreProcess.testMaxResult: false");
                }
                arrayList4.clear();
            }
        }
        if (hc.f1269b) {
            ls.m1344a("toReturn: " + arrayList4.size() + " : " + arrayList4.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("MusicAlgorithm elapsed: " + currentTimeMillis2);
        }
        return arrayList4;
    }
}
