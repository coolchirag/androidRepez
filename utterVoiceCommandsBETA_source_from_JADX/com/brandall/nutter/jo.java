package com.brandall.nutter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class jo {
    private static Pattern f1557a = Pattern.compile(".*\\byes\\b.*");
    private static Pattern f1558b = Pattern.compile(".*\\bno\\b.*");

    public static jq m1213a(ArrayList<String> arrayList) {
        ls.m1344a("yesNoEstablish: " + arrayList.size() + " : " + arrayList.toString());
        jo joVar = new jo();
        joVar.getClass();
        jq jqVar = new jq(joVar);
        ListIterator listIterator = arrayList.listIterator();
        Arrays.asList(arrayList.toArray());
        int i = 0;
        int i2 = 0;
        while (listIterator.hasNext()) {
            Object trim = ((String) listIterator.next()).toString().toLowerCase().trim();
            ls.m1344a("rawpass: " + trim);
            int i3 = (f1557a.matcher(trim).matches() || trim.matches("it is") || trim.matches("that's right") || trim.matches("that's correct")) ? i2 + 1 : i2;
            if (f1558b.matcher(trim).matches() || trim.contains("wrong")) {
                i++;
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        if (i > i2) {
            jqVar.f1563a = jp.no;
        } else if (i2 > i) {
            jqVar.f1563a = jp.yes;
        } else {
            jqVar.f1563a = jp.unclear;
        }
        return jqVar;
    }
}
