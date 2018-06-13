package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class cu implements OnClickListener {
    final /* synthetic */ ActivityLinkApps f1028a;

    cu(ActivityLinkApps activityLinkApps) {
        this.f1028a = activityLinkApps;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1028a, false, "E-mail authentication failed.");
    }
}
