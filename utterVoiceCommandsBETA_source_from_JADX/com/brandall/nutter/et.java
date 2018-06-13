package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class et implements OnClickListener {
    final /* synthetic */ ActivitySettings f1130a;
    private final /* synthetic */ Dialog f1131b;

    et(ActivitySettings activitySettings, Dialog dialog) {
        this.f1130a = activitySettings;
        this.f1131b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1130a, "xcxin.filexpert")) {
            jy.m1264o(this.f1130a, "xcxin.filexpert");
            this.f1131b.dismiss();
        }
    }
}
