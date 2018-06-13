package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ax implements OnCancelListener {
    final /* synthetic */ ActivityContactPicker f946a;

    ax(ActivityContactPicker activityContactPicker) {
        this.f946a = activityContactPicker;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f946a, false, " ");
        this.f946a.finish();
    }
}
