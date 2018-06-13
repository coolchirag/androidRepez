package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class bs implements OnItemClickListener {
    final /* synthetic */ ActivityCustomise f982a;
    private final /* synthetic */ ArrayList f983b;
    private final /* synthetic */ Dialog f984c;

    bs(ActivityCustomise activityCustomise, ArrayList arrayList, Dialog dialog) {
        this.f982a = activityCustomise;
        this.f983b = arrayList;
        this.f984c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + i + " : " + adapterView.getItemAtPosition(i).toString());
        ls.m1344a("stringLocale: " + ((String) this.f983b.get(i)));
        lc.m1313a(this.f982a, false, "Thank you");
        this.f984c.dismiss();
        this.f982a.f672e = (String) this.f983b.get(i);
        this.f982a.f674g.setChecked(true);
        this.f982a.f674g.setText((CharSequence) this.f983b.get(i));
        this.f982a.f672e = (String) this.f983b.get(i);
    }
}
