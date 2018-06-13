package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ab implements OnCancelListener {
    final /* synthetic */ ActivityAdvancedSettings f912a;

    ab(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f912a = activityAdvancedSettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f912a, false, " ");
    }
}
