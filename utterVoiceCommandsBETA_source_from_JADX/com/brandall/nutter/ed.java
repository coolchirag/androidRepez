package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ed implements OnClickListener {
    final /* synthetic */ ActivitySettings f1090a;
    private final /* synthetic */ Dialog f1091b;

    ed(ActivitySettings activitySettings, Dialog dialog) {
        this.f1090a = activitySettings;
        this.f1091b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1090a, false, " ");
        this.f1091b.dismiss();
    }
}
