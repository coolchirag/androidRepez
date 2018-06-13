package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class fm implements OnCancelListener {
    final /* synthetic */ ActivitySettings f1197a;

    fm(ActivitySettings activitySettings) {
        this.f1197a = activitySettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1197a, false, " ");
    }
}
