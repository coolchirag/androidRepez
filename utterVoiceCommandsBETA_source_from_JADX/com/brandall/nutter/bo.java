package com.brandall.nutter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

final class bo extends BroadcastReceiver {
    final /* synthetic */ ActivityCustomise f978a;

    bo(ActivityCustomise activityCustomise) {
        this.f978a = activityCustomise;
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle resultExtras = getResultExtras(true);
        Locale locale = null;
        if (resultExtras.containsKey("android.speech.extra.LANGUAGE_PREFERENCE")) {
            String string = resultExtras.getString("android.speech.extra.LANGUAGE_PREFERENCE");
            locale = new Locale(string);
            if (!locale.toString().matches("")) {
                ls.m1344a("languagePreference: " + string + " :" + locale.getDisplayName());
            }
        }
        if (resultExtras.containsKey("android.speech.extra.SUPPORTED_LANGUAGES")) {
            List<String> stringArrayList = resultExtras.getStringArrayList("android.speech.extra.SUPPORTED_LANGUAGES");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            new String[1][0] = "";
            Locale locale2 = locale;
            for (String str : stringArrayList) {
                if (str.contains("-")) {
                    String[] split = str.split("-");
                    locale = split.length == 1 ? new Locale(str) : split.length == 2 ? new Locale(split[0], split[1]) : split.length == 3 ? new Locale(split[0], split[1], split[2]) : locale2;
                } else {
                    locale = new Locale(str);
                }
                if (!(locale == null || locale.toString().matches(""))) {
                    arrayList2.add(locale.toString());
                    arrayList.add(locale.getDisplayName());
                    ls.m1344a("loc toString: " + locale.toString());
                    ls.m1344a("loc getDisplayName: " + locale.getDisplayName());
                }
                locale2 = locale;
            }
            ls.m1344a("stringLocale: " + arrayList2.size() + " : " + arrayList2.toString());
            ls.m1344a("readableLocale: " + arrayList.size() + " : " + arrayList.toString());
            ActivityCustomise.m530a(this.f978a, arrayList, arrayList2);
        }
    }
}
