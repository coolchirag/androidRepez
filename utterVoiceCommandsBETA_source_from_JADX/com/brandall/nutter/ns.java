package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ns implements OnItemClickListener {
    final /* synthetic */ WidgetConfiguration f1801a;
    private final /* synthetic */ ArrayList f1802b;
    private final /* synthetic */ Dialog f1803c;

    ns(WidgetConfiguration widgetConfiguration, ArrayList arrayList, Dialog dialog) {
        this.f1801a = widgetConfiguration;
        this.f1802b = arrayList;
        this.f1803c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + i + " : " + adapterView.getItemAtPosition(i).toString());
        Locale locale = (Locale) this.f1802b.get(i);
        ls.m1344a("Language: " + locale.getLanguage() + " : ISO3: " + locale.getISO3Country());
        Matcher matcher = Pattern.compile("(.*?\\().*").matcher(this.f1801a.f907b);
        while (matcher.find()) {
            ls.m1346c("group1: " + matcher.group(1));
            this.f1801a.f907b = matcher.group(1) + locale.getLanguage() + ")";
            ls.m1346c("recognitionLocaleTitle: " + this.f1801a.f907b);
        }
        WidgetConfiguration.m966a(this.f1801a, this.f1801a.f906a, locale.getLanguage(), locale.getISO3Country());
        this.f1803c.dismiss();
    }
}
