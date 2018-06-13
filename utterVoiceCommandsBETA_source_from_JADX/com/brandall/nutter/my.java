package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class my implements OnItemClickListener {
    final /* synthetic */ TaskerPluginActivity f1752a;
    private final /* synthetic */ ArrayList f1753b;
    private final /* synthetic */ Dialog f1754c;

    my(TaskerPluginActivity taskerPluginActivity, ArrayList arrayList, Dialog dialog) {
        this.f1752a = taskerPluginActivity;
        this.f1753b = arrayList;
        this.f1754c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + i + " : " + adapterView.getItemAtPosition(i).toString());
        ls.m1344a("stringLocale: " + ((String) this.f1753b.get(i)));
        lc.m1313a(this.f1752a, false, "Thank you");
        this.f1754c.dismiss();
        this.f1752a.f902q = (String) this.f1753b.get(i);
        this.f1752a.f889d.setChecked(true);
        this.f1752a.f889d.setText((CharSequence) this.f1753b.get(i));
        this.f1752a.f902q = (String) this.f1753b.get(i);
    }
}
