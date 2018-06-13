package com.brandall.nutter;

import android.content.Context;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;

public final class in {
    public static ArrayList<String> m1180a(Context context, ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        arrayList2 = new ArrayList();
        Object arrayList3 = new ArrayList();
        hh hhVar = new hh(context);
        ArrayList a = hhVar.m1092a();
        ArrayList b = hhVar.m1097b();
        ListIterator listIterator = a.listIterator();
        Locale locale = Locale.US;
        int size = arrayList.size();
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            String trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
            if (hc.f1269b) {
                ls.m1344a("unnPass: " + trim + " : contact name: " + ((String) b.get(nextIndex)));
            }
            arrayList3.clear();
            for (int i = 0; i < size; i++) {
                if (hc.f1269b) {
                    ls.m1344a("vd: " + ((String) arrayList.get(i)));
                }
                String replaceAll = ((String) arrayList.get(i)).toLowerCase(locale).trim().replaceAll("\\b" + trim + "\\b", (String) b.get(nextIndex));
                if (hc.f1269b) {
                    ls.m1344a("vd updated: " + replaceAll);
                }
                arrayList3.add(replaceAll);
            }
            if (hc.f1269b) {
                ls.m1346c("Upating voice data");
                ls.m1345b("voiceDataUpdated: " + arrayList3.size() + " : " + arrayList3.toString());
            }
            arrayList.clear();
            arrayList.addAll(arrayList3);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("establishNickNames elapsed: " + currentTimeMillis2);
        }
        return arrayList3;
    }
}
