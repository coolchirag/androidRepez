package com.brandall.nutter;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;

public final class gz {
    public static ha m1056a(ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        gz gzVar = new gz();
        gzVar.getClass();
        ha haVar = new ha(gzVar);
        ListIterator listIterator = arrayList.listIterator();
        haVar.f1265b = 0;
        while (listIterator.hasNext()) {
            String trim = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
            ls.m1344a("rawpass: " + trim);
            if (!trim.contains("cancel cancel")) {
                ls.m1346c("CR isDisplayContact");
                int i = (trim.startsWith("display ") && trim.contains(" contact")) ? 1 : 0;
                haVar.f1265b = i;
                if (haVar.f1265b != 1) {
                    ls.m1346c("CR isTaskerTask");
                    haVar.f1265b = trim.contains("task") ? 2 : 0;
                    if (haVar.f1265b != 2) {
                        ls.m1346c("CR isActivity");
                        haVar.f1265b = trim.contains("activity") ? 3 : 0;
                        if (haVar.f1265b != 3) {
                            ls.m1346c("CR isCallContact");
                            i = (trim.startsWith("call ") && trim.contains(" contact")) ? 4 : 0;
                            haVar.f1265b = i;
                            if (haVar.f1265b != 4) {
                                ls.m1346c("CR isLaunchApplication");
                                haVar.f1265b = trim.contains("application") ? 5 : 0;
                                if (haVar.f1265b == 5) {
                                    haVar.f1264a = "Please select the application.";
                                    break;
                                }
                            }
                            haVar.f1264a = "Please select the contact.";
                            break;
                        }
                        haVar.f1264a = "Please select the activity.";
                        break;
                    }
                    haVar.f1264a = "tasker";
                    break;
                }
                haVar.f1264a = "Please select the contact.";
                break;
            }
            ls.m1346c("Cancel cancel");
            haVar.f1265b = 999;
            haVar.f1264a = "Cancelling";
            break;
        }
        if (haVar.f1265b == 0) {
            ls.m1347d("No command to create recognised");
            haVar.f1264a = "Sorry, but that command can't be customised";
        }
        ls.m1346c("TestProcess elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return haVar;
    }
}
