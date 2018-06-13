package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class dk implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1056a;

    dk(ActivityPowerUser activityPowerUser) {
        this.f1056a = activityPowerUser;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1056a, false, "Disclaimer declined. You can return to this dialog at any time.");
        lx.m1429h(this.f1056a, false);
    }
}
