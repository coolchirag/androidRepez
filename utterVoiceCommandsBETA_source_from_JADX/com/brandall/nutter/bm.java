package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class bm implements OnClickListener {
    final /* synthetic */ ActivityCustomise f975a;
    private final /* synthetic */ Dialog f976b;

    bm(ActivityCustomise activityCustomise, Dialog dialog) {
        this.f975a = activityCustomise;
        this.f976b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f975a, false, " ");
        this.f976b.dismiss();
    }
}
