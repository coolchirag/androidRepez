package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ad implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f916a;
    private final /* synthetic */ Dialog f917b;

    ad(ActivityAdvancedSettings activityAdvancedSettings, Dialog dialog) {
        this.f916a = activityAdvancedSettings;
        this.f917b = dialog;
    }

    public final void onClick(View view) {
        this.f917b.dismiss();
        lc.m1313a(this.f916a, false, " ");
    }
}
