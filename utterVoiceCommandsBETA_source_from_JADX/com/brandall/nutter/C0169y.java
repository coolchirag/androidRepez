package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class C0169y implements OnItemClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1834a;
    private final /* synthetic */ ArrayList f1835b;
    private final /* synthetic */ Dialog f1836c;

    C0169y(ActivityAdvancedSettings activityAdvancedSettings, ArrayList arrayList, Dialog dialog) {
        this.f1834a = activityAdvancedSettings;
        this.f1835b = arrayList;
        this.f1836c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
        }
        lc.m1313a(this.f1834a, false, "Thank you, that's complete. Please be aware, if this locale isn't available to the voice engine you are using, it will default back to English");
        Locale locale = (Locale) this.f1835b.get(i);
        if (hc.f1269b) {
            ls.m1344a("Language: " + locale.getLanguage() + " : ISO3: " + locale.getISO3Country());
        }
        Matcher matcher = Pattern.compile("(.*?\\().*").matcher(this.f1834a.f653d);
        while (matcher.find()) {
            if (hc.f1269b) {
                ls.m1346c("group1: " + matcher.group(1));
            }
            this.f1834a.f653d = matcher.group(1) + locale.getLanguage() + ")";
            if (hc.f1269b) {
                ls.m1346c("recognitionLocaleTitle: " + this.f1834a.f653d);
            }
        }
        jy.m1235a(this.f1834a, true, this.f1834a.f652c, this.f1834a.f653d, locale.getLanguage(), locale.getISO3Country());
        this.f1836c.dismiss();
    }
}
