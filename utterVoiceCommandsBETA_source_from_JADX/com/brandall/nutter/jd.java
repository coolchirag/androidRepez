package com.brandall.nutter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;

public final class jd {
    public static je m1200a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, double d) {
        jd jdVar = new jd();
        jdVar.getClass();
        je jeVar = new je(jdVar);
        long currentTimeMillis = System.currentTimeMillis();
        jeVar.f1523a = false;
        jeVar.f1524b = false;
        mp leVar = new le();
        ListIterator listIterator = arrayList2.listIterator();
        Arrays.asList(arrayList2.toArray());
        Locale locale = Locale.US;
        loop0:
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            String trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
            String trim2 = trim.replaceAll("[^a-z0-9 ]", "").trim();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ls.m1346c("Comparing:" + str + " : " + trim2);
                if (str.matches(trim2)) {
                    jeVar.f1528f.add(trim);
                    jeVar.f1528f.add((String) arrayList3.get(nextIndex));
                    jeVar.f1523a = true;
                    break loop0;
                }
                double a = leVar.mo94a(trim2, str);
                if (a > 0.95d) {
                    jeVar.f1528f.add("ALGORITHM");
                    jeVar.f1528f.add(trim);
                    jeVar.f1528f.add((String) arrayList3.get(nextIndex));
                    jeVar.f1523a = true;
                    break loop0;
                } else if (a > d) {
                    jeVar.f1526d.add(trim);
                    jeVar.f1527e.add((String) arrayList3.get(nextIndex));
                    jeVar.f1525c.add(String.valueOf(a));
                    jeVar.f1523a = false;
                }
            }
        }
        if (!jeVar.f1523a) {
            ls.m1346c("scoreProcess.exactMatch: false");
            if (jeVar.f1525c.isEmpty()) {
                ls.m1347d("scoreProcess.testScores empty: " + jeVar.f1525c.size());
                jeVar.f1524b = false;
            } else {
                ls.m1346c("scoreProcess.testScores: " + jeVar.f1525c.size());
                jg a2 = jf.m1201a(jeVar.f1525c, jeVar.f1526d, jeVar.f1527e);
                jeVar.f1529g.add("ALGORITHM");
                jeVar.f1529g.add(a2.f1531a);
                jeVar.f1529g.add(a2.f1532b);
                jeVar.f1529g.add(a2.f1533c);
                jeVar.f1524b = true;
            }
        }
        ls.m1346c("ScoreProcess elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return jeVar;
    }
}
