package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class bf implements OnClickListener {
    final /* synthetic */ ActivityCustomise f963a;
    private final /* synthetic */ Dialog f964b;

    bf(ActivityCustomise activityCustomise, Dialog dialog) {
        this.f963a = activityCustomise;
        this.f964b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f963a, false, " ");
        this.f964b.dismiss();
    }
}
