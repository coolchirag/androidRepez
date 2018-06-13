package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ao implements OnCancelListener {
    final /* synthetic */ ActivityCommunity f930a;

    ao(ActivityCommunity activityCommunity) {
        this.f930a = activityCommunity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f930a, false, " ");
    }
}
