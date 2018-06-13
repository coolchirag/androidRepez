package com.brandall.nutter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class is {
    public static int m1183a(ArrayList<Integer> arrayList) {
        int i = 74;
        Map hashMap = new HashMap();
        if (arrayList.contains(Integer.valueOf(74))) {
            ls.m1346c("EstablishOutlier commandCancel detected");
        } else if (arrayList.isEmpty()) {
            ls.m1347d("intArray empty");
            i = 999;
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Integer.valueOf(0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                Integer num = (Integer) hashMap.get(Integer.valueOf(intValue));
                hashMap.put(Integer.valueOf(intValue), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            }
            Map treeMap = new TreeMap(new it(hashMap));
            treeMap.putAll(hashMap);
            if (treeMap.isEmpty()) {
                ls.m1347d("sortedMap empty");
                i = 999;
            } else {
                for (Entry entry : treeMap.entrySet()) {
                    ls.m1344a("Value: " + entry.getValue() + " key: " + entry.getKey());
                    arrayList2.add((Integer) entry.getKey());
                    arrayList3.add((Integer) entry.getValue());
                }
                ls.m1344a("CommandNumber: " + arrayList2.size() + " : " + arrayList2.toString());
                ls.m1344a("commandFrequency: " + arrayList3.size() + " : " + arrayList3.toString());
                if (arrayList2.size() > 1) {
                    double intValue2 = (double) ((Integer) arrayList3.get(0)).intValue();
                    intValue2 = (intValue2 / (((double) ((Integer) arrayList3.get(1)).intValue()) + intValue2)) * 100.0d;
                    if (intValue2 > 65.0d) {
                        ls.m1344a("Percentage: " + intValue2);
                        i = ((Integer) arrayList2.get(0)).intValue();
                    } else {
                        ls.m1347d("Percentage: " + intValue2);
                        if (((Integer) arrayList.get(0)).equals(arrayList2.get(0))) {
                            ls.m1347d("EstablishOutlier: intArray0 = commandNumber0");
                            i = ((Integer) arrayList2.get(0)).intValue();
                        } else if (((Integer) arrayList.get(0)).equals(arrayList2.get(1))) {
                            ls.m1347d("EstablishOutlier: intArray0 = commandNumber1");
                            i = ((Integer) arrayList2.get(1)).intValue();
                        } else {
                            ls.m1347d("intArray0 didn't match: 911");
                            i = 911;
                        }
                    }
                } else if (arrayList2.size() == 1) {
                    i = ((Integer) arrayList2.get(0)).intValue();
                } else {
                    ls.m1347d("commandNumber empty");
                    i = 999;
                }
            }
        }
        ls.m1344a("commandInt: " + i);
        return i;
    }
}
