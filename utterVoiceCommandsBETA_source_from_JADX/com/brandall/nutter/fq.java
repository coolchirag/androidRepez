package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class fq implements OnCancelListener {
    final /* synthetic */ ActivitySettings f1204a;

    fq(ActivitySettings activitySettings) {
        this.f1204a = activitySettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1204a, false, " ");
    }
}
