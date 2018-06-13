package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class az implements OnClickListener {
    final /* synthetic */ ActivityContactPicker f952a;
    private final /* synthetic */ Dialog f953b;

    az(ActivityContactPicker activityContactPicker, Dialog dialog) {
        this.f952a = activityContactPicker;
        this.f953b = dialog;
    }

    public final void onClick(View view) {
        this.f953b.dismiss();
        lc.m1313a(this.f952a, false, " ");
        this.f952a.m520a();
    }
}
