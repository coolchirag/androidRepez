package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class C0148f implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1159a;
    private final /* synthetic */ Dialog f1160b;

    C0148f(ActivityAdvancedSettings activityAdvancedSettings, Dialog dialog) {
        this.f1159a = activityAdvancedSettings;
        this.f1160b = dialog;
    }

    public final void onClick(View view) {
        this.f1160b.dismiss();
        lc.m1313a(this.f1159a, false, " ");
    }
}
