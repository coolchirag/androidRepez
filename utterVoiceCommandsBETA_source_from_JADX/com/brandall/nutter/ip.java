package com.brandall.nutter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;

public final class ip {
    private static final Pattern f1466a = Pattern.compile(".*\\bon\\b.*");
    private static final Pattern f1467b = Pattern.compile(".*\\boff\\b.*");
    private static final Pattern f1468c = Pattern.compile(".*\\btoggle\\b.*");
    private static boolean f1469d = false;
    private static boolean f1470e = false;
    private static boolean f1471f = false;
    private static boolean f1472g = false;

    public static ir m1182a(ArrayList<String> arrayList) {
        if (hc.f1269b) {
            ls.m1345b("onOffEstablish");
            ls.m1346c("onOffEstablishData: " + arrayList.size() + " : " + arrayList.toString());
        }
        f1469d = false;
        f1470e = false;
        f1471f = false;
        f1472g = false;
        ArrayList arrayList2 = new ArrayList();
        ip ipVar = new ip();
        ipVar.getClass();
        ir irVar = new ir(ipVar);
        ListIterator listIterator = arrayList.listIterator();
        Arrays.asList(arrayList.toArray());
        Locale locale = Locale.US;
        while (listIterator.hasNext()) {
            String trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
            if (hc.f1269b) {
                ls.m1345b("rawpass: " + trim);
            }
            if (f1466a.matcher(trim).matches() || f1467b.matcher(trim).matches()) {
                if (f1466a.matcher(trim).matches() && f1467b.matcher(trim).matches()) {
                    f1469d = true;
                    break;
                } else if (f1466a.matcher(trim).matches()) {
                    if (hc.f1269b) {
                        ls.m1344a("on.matcher: " + trim);
                    }
                    f1470e = true;
                } else if (f1467b.matcher(trim).matches()) {
                    if (hc.f1269b) {
                        ls.m1344a("off.matcher: " + trim);
                    }
                    f1471f = true;
                } else if (f1468c.matcher(trim).matches()) {
                    if (hc.f1269b) {
                        ls.m1344a("toggle.matcher: " + trim);
                    }
                    f1472g = true;
                }
            } else {
                f1472g = true;
                break;
            }
        }
        if (f1469d) {
            if (hc.f1269b) {
                ls.m1347d("multipleCommand: " + f1469d);
            }
            irVar.f1479a = iq.multipleOnOff;
        } else if (f1471f) {
            if (hc.f1269b) {
                ls.m1345b("commandOff: " + f1471f);
            }
            irVar.f1479a = iq.off;
        } else if (f1470e) {
            if (hc.f1269b) {
                ls.m1345b("commandOn: " + f1470e);
            }
            irVar.f1479a = iq.on;
        } else if (f1472g) {
            if (hc.f1269b) {
                ls.m1345b("commandToggle: " + f1472g);
            }
            irVar.f1479a = iq.toggle;
        } else {
            if (hc.f1269b) {
                ls.m1347d("onOffEstablish no command");
            }
            irVar.f1479a = iq.error;
        }
        irVar.f1480b = arrayList2;
        return irVar;
    }
}
