package com.brandall.nutter;

import android.content.Context;
import java.util.ArrayList;
import java.util.ListIterator;

public final class jc {
    public static String m1199a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList = new ArrayList();
        hj hjVar = new hj(context);
        ArrayList a = hjVar.m1108a();
        ArrayList b = hjVar.m1111b();
        ls.m1344a("varNames: " + a.size() + " : " + a.toString());
        ls.m1344a("varValues: " + b.size() + " : " + b.toString());
        ListIterator listIterator = a.listIterator();
        if (a.isEmpty()) {
            ls.m1346c("replaceTaskerVar elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
            return str;
        }
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            Object trim = ((String) listIterator.next()).toString().trim();
            ls.m1344a("vnPass: " + trim);
            if (str.contains(trim)) {
                ls.m1346c("replaceTaskerVar elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
                return str.replaceAll(trim, (String) b.get(nextIndex));
            }
        }
        ls.m1346c("replaceTaskerVar elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return str;
    }
}
