package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class dl implements OnCancelListener {
    final /* synthetic */ ActivityPowerUser f1057a;

    dl(ActivityPowerUser activityPowerUser) {
        this.f1057a = activityPowerUser;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1057a, false, " ");
    }
}
