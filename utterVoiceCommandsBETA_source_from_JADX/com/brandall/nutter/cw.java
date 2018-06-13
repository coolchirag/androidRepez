package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class cw implements OnClickListener {
    final /* synthetic */ ActivityLinkApps f1032a;

    cw(ActivityLinkApps activityLinkApps) {
        this.f1032a = activityLinkApps;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1032a, false, "Play Music authentication failed.");
    }
}
