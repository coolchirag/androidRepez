package com.brandall.nutter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;

public final class jf {
    public static jg m1201a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        jf jfVar = new jf();
        jfVar.getClass();
        jg jgVar = new jg(jfVar);
        long currentTimeMillis = System.currentTimeMillis();
        Object max = Collections.max(arrayList);
        ListIterator listIterator = arrayList.listIterator();
        Arrays.asList(arrayList.toArray());
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            if (listIterator.next().equals(max)) {
                jgVar.f1533c = String.valueOf(max);
                jgVar.f1531a = (String) arrayList2.get(nextIndex);
                jgVar.f1532b = (String) arrayList3.get(nextIndex);
                ls.m1346c("highestName: " + jgVar.f1531a);
                ls.m1346c("highestIdentifyer: " + jgVar.f1532b);
                ls.m1346c("highestScore: " + jgVar.f1533c);
                break;
            }
        }
        ls.m1346c("TestProcess elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return jgVar;
    }
}
