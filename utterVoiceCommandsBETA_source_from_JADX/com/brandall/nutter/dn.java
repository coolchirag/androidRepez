package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class dn implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1062a;
    private final /* synthetic */ Dialog f1063b;

    dn(ActivityPowerUser activityPowerUser, Dialog dialog) {
        this.f1062a = activityPowerUser;
        this.f1063b = dialog;
    }

    public final void onClick(View view) {
        this.f1063b.dismiss();
        lc.m1313a(this.f1062a, false, " ");
    }
}
