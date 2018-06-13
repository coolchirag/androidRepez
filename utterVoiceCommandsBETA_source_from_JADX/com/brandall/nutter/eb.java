package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class eb implements OnCancelListener {
    final /* synthetic */ ActivitySettings f1085a;

    eb(ActivitySettings activitySettings) {
        this.f1085a = activitySettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1085a, false, " ");
    }
}
