package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class fd implements OnCancelListener {
    final /* synthetic */ ActivitySettings f1182a;

    fd(ActivitySettings activitySettings) {
        this.f1182a = activitySettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1182a, false, " ");
    }
}
