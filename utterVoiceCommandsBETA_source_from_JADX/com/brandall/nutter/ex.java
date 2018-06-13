package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ex implements OnClickListener {
    final /* synthetic */ ActivitySettings f1143a;
    private final /* synthetic */ Dialog f1144b;

    ex(ActivitySettings activitySettings, Dialog dialog) {
        this.f1143a = activitySettings;
        this.f1144b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1143a, false, " ");
        this.f1144b.dismiss();
    }
}
