package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class C0150h implements OnCancelListener {
    final /* synthetic */ ActivityAdvancedSettings f1263a;

    C0150h(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f1263a = activityAdvancedSettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1263a, false, " ");
    }
}
