package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Locale;

final class cl implements OnItemClickListener {
    final /* synthetic */ ActivityHome f1012a;
    private final /* synthetic */ ArrayList f1013b;
    private final /* synthetic */ Dialog f1014c;

    cl(ActivityHome activityHome, ArrayList arrayList, Dialog dialog) {
        this.f1012a = activityHome;
        this.f1013b = arrayList;
        this.f1014c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
        }
        this.f1012a.m558a("Default saved. You can change this at any time in the settings menu.", false, false);
        ly.m1464b(this.f1012a);
        ly.m1465b(this.f1012a, 9000, true);
        Locale locale = (Locale) this.f1013b.get(i);
        if (hc.f1269b) {
            ls.m1344a("Language: " + locale.getLanguage() + " : ISO3: " + locale.getISO3Country());
        }
        String[] split = obj.split("-");
        if (split.length > 1) {
            if (hc.f1269b) {
                ls.m1344a("selectedResult -: gls0: " + split[0] + "  : gls1 :" + split[1]);
            }
            lx.m1393a(this.f1012a, split[0], split[1], true);
        } else {
            lx.m1393a(this.f1012a, locale.getLanguage(), locale.getISO3Country(), true);
        }
        this.f1014c.dismiss();
        if (!lx.m1456y(this.f1012a)) {
            this.f1012a.m560b();
        }
    }
}
