package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class bx implements OnClickListener {
    final /* synthetic */ ActivityCustomise f993a;
    private final /* synthetic */ Dialog f994b;

    bx(ActivityCustomise activityCustomise, Dialog dialog) {
        this.f993a = activityCustomise;
        this.f994b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f993a, false, " ");
        this.f994b.dismiss();
    }
}
