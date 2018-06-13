package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class lk implements OnItemClickListener {
    final /* synthetic */ LauncherShortcutProvider f1676a;
    private final /* synthetic */ ArrayList f1677b;
    private final /* synthetic */ Dialog f1678c;

    lk(LauncherShortcutProvider launcherShortcutProvider, ArrayList arrayList, Dialog dialog) {
        this.f1676a = launcherShortcutProvider;
        this.f1677b = arrayList;
        this.f1678c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + i + " : " + adapterView.getItemAtPosition(i).toString());
        Locale locale = (Locale) this.f1677b.get(i);
        ls.m1344a("Language: " + locale.getLanguage() + " : ISO3: " + locale.getISO3Country());
        Matcher matcher = Pattern.compile("(.*?\\().*").matcher(this.f1676a.f828b);
        while (matcher.find()) {
            ls.m1346c("group1: " + matcher.group(1));
            this.f1676a.f828b = matcher.group(1) + locale.getLanguage() + ")";
            ls.m1346c("recognitionLocaleTitle: " + this.f1676a.f828b);
        }
        jy.m1235a(this.f1676a, true, this.f1676a.f827a, this.f1676a.f828b, locale.getLanguage(), locale.getISO3Country());
        this.f1678c.dismiss();
        this.f1676a.finish();
    }
}
