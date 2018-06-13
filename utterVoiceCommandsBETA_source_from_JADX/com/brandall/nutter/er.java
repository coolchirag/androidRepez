package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class er implements OnClickListener {
    final /* synthetic */ ActivitySettings f1126a;
    private final /* synthetic */ Dialog f1127b;

    er(ActivitySettings activitySettings, Dialog dialog) {
        this.f1126a = activitySettings;
        this.f1127b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1126a, "com.speedsoftware.rootexplorer")) {
            jy.m1264o(this.f1126a, "com.speedsoftware.rootexplorer");
            this.f1127b.dismiss();
        }
    }
}
