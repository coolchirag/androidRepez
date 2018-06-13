package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class fo implements OnClickListener {
    final /* synthetic */ ActivitySettings f1201a;
    private final /* synthetic */ Dialog f1202b;

    fo(ActivitySettings activitySettings, Dialog dialog) {
        this.f1201a = activitySettings;
        this.f1202b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1201a, false, " ");
        this.f1202b.dismiss();
    }
}
