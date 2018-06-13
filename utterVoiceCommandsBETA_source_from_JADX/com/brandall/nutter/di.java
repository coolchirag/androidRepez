package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class di implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1054a;

    di(ActivityPowerUser activityPowerUser) {
        this.f1054a = activityPowerUser;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1054a, false, "Accepted");
        lx.m1429h(this.f1054a, true);
    }
}
