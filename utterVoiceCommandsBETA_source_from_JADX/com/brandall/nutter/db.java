package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class db implements OnItemSelectedListener {
    final /* synthetic */ ActivityPickerActivity f1039a;

    db(ActivityPickerActivity activityPickerActivity) {
        this.f1039a = activityPickerActivity;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("sCatSel: " + adapterView.getItemAtPosition(i).toString());
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
