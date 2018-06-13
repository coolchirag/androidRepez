package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class da implements OnItemSelectedListener {
    final /* synthetic */ ActivityPickerActivity f1038a;

    da(ActivityPickerActivity activityPickerActivity) {
        this.f1038a = activityPickerActivity;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("sActSel: " + adapterView.getItemAtPosition(i).toString());
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
