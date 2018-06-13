package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class gp implements OnClickListener {
    final /* synthetic */ ActivityUserWords f1246a;
    private final /* synthetic */ Dialog f1247b;

    gp(ActivityUserWords activityUserWords, Dialog dialog) {
        this.f1246a = activityUserWords;
        this.f1247b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1246a, false, " ");
        this.f1247b.dismiss();
    }
}
