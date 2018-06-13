package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class eq implements OnClickListener {
    final /* synthetic */ ActivitySettings f1124a;
    private final /* synthetic */ Dialog f1125b;

    eq(ActivitySettings activitySettings, Dialog dialog) {
        this.f1124a = activitySettings;
        this.f1125b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1124a, "com.ghisler.android.TotalCommander")) {
            jy.m1264o(this.f1124a, "com.ghisler.android.TotalCommander");
            this.f1125b.dismiss();
        }
    }
}
