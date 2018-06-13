package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ei implements OnClickListener {
    final /* synthetic */ ActivitySettings f1100a;
    private final /* synthetic */ Dialog f1101b;

    ei(ActivitySettings activitySettings, Dialog dialog) {
        this.f1100a = activitySettings;
        this.f1101b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1100a, "com.threebanana.notes")) {
            jy.m1264o(this.f1100a, "com.threebanana.notes");
            this.f1101b.dismiss();
        }
    }
}
