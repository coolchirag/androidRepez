package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Locale;

final class fl implements OnItemClickListener {
    final /* synthetic */ ActivitySettings f1194a;
    private final /* synthetic */ ArrayList f1195b;
    private final /* synthetic */ Dialog f1196c;

    fl(ActivitySettings activitySettings, ArrayList arrayList, Dialog dialog) {
        this.f1194a = activitySettings;
        this.f1195b = arrayList;
        this.f1196c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
        }
        lc.m1313a(this.f1194a, false, "Thank you. Should you change your default engine in the Android settings, please return and update this setting.");
        Locale locale = (Locale) this.f1195b.get(i);
        if (hc.f1269b) {
            ls.m1344a("Language: " + locale.getLanguage() + " : ISO3: " + locale.getISO3Country());
        }
        String[] split = obj.split("-");
        if (split.length > 1) {
            if (hc.f1269b) {
                ls.m1344a("selectedResult -: gls0: " + split[0] + "  : gls1 :" + split[1]);
            }
            lx.m1393a(this.f1194a, split[0], split[1], true);
        } else {
            lx.m1393a(this.f1194a, locale.getLanguage(), locale.getISO3Country(), true);
        }
        this.f1196c.dismiss();
    }
}
