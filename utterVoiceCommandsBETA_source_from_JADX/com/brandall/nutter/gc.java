package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class gc implements OnItemClickListener {
    final /* synthetic */ ActivityUserPhrases f1222a;
    private final /* synthetic */ Dialog f1223b;

    gc(ActivityUserPhrases activityUserPhrases, Dialog dialog) {
        this.f1222a = activityUserPhrases;
        this.f1223b = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        ls.m1344a("selectedResult: " + i + " : " + obj);
        this.f1222a.f739j = obj;
        lc.m1313a(this.f1222a, false, "Thank you. Please be aware, if this locale isn't available to the voice engine your are using, it will default back to English");
        this.f1222a.f738i.setChecked(true);
        this.f1222a.f738i.setText(this.f1222a.f739j);
        this.f1223b.dismiss();
    }
}
