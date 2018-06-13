package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class dr implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1071a;
    private final /* synthetic */ Dialog f1072b;

    dr(ActivityPowerUser activityPowerUser, Dialog dialog) {
        this.f1071a = activityPowerUser;
        this.f1072b = dialog;
    }

    public final void onClick(View view) {
        this.f1072b.dismiss();
        lc.m1313a(this.f1071a, false, " ");
    }
}
