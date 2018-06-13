package com.brandall.nutter;

import android.content.Context;
import java.util.ArrayList;

public final class ih {
    public static String m1171a(Context context, String str) {
        int i = 0;
        if (hc.f1269b) {
            ls.m1346c("EstablishJoke formatJoke: " + str);
        }
        if (str == null || str.matches("error")) {
            return "null";
        }
        if (io.m1181a(str)) {
            return "obsen";
        }
        int length;
        String[] split = str.split(System.getProperty("line.separator"));
        int length2 = split.length;
        if (hc.f1269b) {
            ls.m1345b("mrLength: " + length2);
        }
        for (String str2 : split) {
            if (hc.f1269b) {
                String str22;
                ls.m1345b("mr: " + str22);
            }
            if (str22.startsWith("JOKE=")) {
                split = str22.split("JOKE=");
                break;
            }
        }
        if (split.length <= 1) {
            return "null";
        }
        String trim = split[1].trim();
        if (trim.isEmpty()) {
            return "null";
        }
        if (hc.f1269b) {
            ls.m1346c("EstablishJoke formatJoke final: " + trim);
        }
        if (trim.contains("R:") || trim.contains("A:")) {
            if (hc.f1269b) {
                ls.m1345b("formatJoke: response: true");
            }
            split = trim.split("\\|");
            ArrayList arrayList = new ArrayList();
            length = split.length;
            while (i < length) {
                str22 = split[i];
                if (hc.f1269b) {
                    ls.m1345b("mr: " + str22);
                }
                arrayList.add(str22);
                i++;
            }
            if (hc.f1269b) {
                ls.m1344a("jokeFormat: " + arrayList.size() + " : " + arrayList.toString());
            }
            GlobalV.m818a(arrayList);
            return "response";
        }
        if (hc.f1269b) {
            ls.m1345b("formatJoke: response: false");
        }
        GlobalV.m889t(true);
        GlobalV.m899w(true);
        length2 = 0;
        for (String str3 : trim.split("\\|")) {
            if (hc.f1269b) {
                ls.m1345b("mr: " + str3);
            }
            String str32 = str32.replace("S:", "");
            if (length2 == 0) {
                lc.m1313a(context, false, str32);
            } else {
                ServiceTTS.m913a(context, 750);
                lc.m1313a(context, false, str32);
            }
            length2++;
        }
        return "success";
    }
}
