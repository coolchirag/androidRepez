package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ev implements OnClickListener {
    final /* synthetic */ ActivitySettings f1134a;
    private final /* synthetic */ Dialog f1135b;

    ev(ActivitySettings activitySettings, Dialog dialog) {
        this.f1134a = activitySettings;
        this.f1135b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1134a, "pl.solidexplorer")) {
            jy.m1264o(this.f1134a, "pl.solidexplorer");
            this.f1135b.dismiss();
        }
    }
}
