package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ej implements OnClickListener {
    final /* synthetic */ ActivitySettings f1102a;
    private final /* synthetic */ Dialog f1103b;

    ej(ActivitySettings activitySettings, Dialog dialog) {
        this.f1102a = activitySettings;
        this.f1103b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1102a, "com.springpad")) {
            jy.m1264o(this.f1102a, "com.springpad");
            this.f1103b.dismiss();
        }
    }
}
