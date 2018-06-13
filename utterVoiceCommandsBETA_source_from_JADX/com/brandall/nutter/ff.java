package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ff implements OnClickListener {
    final /* synthetic */ ActivitySettings f1186a;
    private final /* synthetic */ Dialog f1187b;

    ff(ActivitySettings activitySettings, Dialog dialog) {
        this.f1186a = activitySettings;
        this.f1187b = dialog;
    }

    public final void onClick(View view) {
        this.f1187b.dismiss();
        lc.m1313a(this.f1186a, false, " ");
    }
}
