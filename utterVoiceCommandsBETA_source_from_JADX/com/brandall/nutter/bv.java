package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class bv implements OnItemClickListener {
    final /* synthetic */ ActivityCustomise f987a;
    private final /* synthetic */ Dialog f988b;

    bv(ActivityCustomise activityCustomise, Dialog dialog) {
        this.f987a = activityCustomise;
        this.f988b = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
        }
        this.f987a.f675h = obj;
        lc.m1313a(this.f987a, false, "Thank you. Please be aware, if this locale isn't available to the voice engine you are using, it will default back to English");
        this.f987a.f673f.setChecked(true);
        this.f987a.f673f.setText(this.f987a.f675h);
        this.f988b.dismiss();
    }
}
