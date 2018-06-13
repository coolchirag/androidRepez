package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class au implements OnClickListener {
    final /* synthetic */ ActivityCommunity f942a;
    private final /* synthetic */ Dialog f943b;

    au(ActivityCommunity activityCommunity, Dialog dialog) {
        this.f942a = activityCommunity;
        this.f943b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f942a, false, " ");
        this.f943b.dismiss();
    }
}
