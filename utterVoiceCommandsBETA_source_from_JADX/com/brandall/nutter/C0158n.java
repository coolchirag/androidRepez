package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class C0158n implements OnItemClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1756a;
    private final /* synthetic */ ArrayList f1757b;
    private final /* synthetic */ Dialog f1758c;

    C0158n(ActivityAdvancedSettings activityAdvancedSettings, ArrayList arrayList, Dialog dialog) {
        this.f1756a = activityAdvancedSettings;
        this.f1757b = arrayList;
        this.f1758c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
            ls.m1344a("stringLocale: " + ((String) this.f1757b.get(i)));
        }
        lc.m1313a(this.f1756a, false, "Your language, " + obj + " has been set.");
        this.f1758c.dismiss();
        ActivityAdvancedSettings.m497c(this.f1756a, (String) this.f1757b.get(i));
    }
}
