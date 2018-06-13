package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class eu implements OnClickListener {
    final /* synthetic */ ActivitySettings f1132a;
    private final /* synthetic */ Dialog f1133b;

    eu(ActivitySettings activitySettings, Dialog dialog) {
        this.f1132a = activitySettings;
        this.f1133b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1132a, "com.speedsoftware.explorer")) {
            jy.m1264o(this.f1132a, "com.speedsoftware.explorer");
            this.f1133b.dismiss();
        }
    }
}
