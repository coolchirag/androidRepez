package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class C0162r implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1823a;
    private final /* synthetic */ Dialog f1824b;

    C0162r(ActivityAdvancedSettings activityAdvancedSettings, Dialog dialog) {
        this.f1823a = activityAdvancedSettings;
        this.f1824b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1823a, false, " ");
        this.f1824b.dismiss();
    }
}
