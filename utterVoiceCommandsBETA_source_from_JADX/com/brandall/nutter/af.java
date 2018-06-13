package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class af implements OnCancelListener {
    final /* synthetic */ ActivityAdvancedSettings f919a;

    af(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f919a = activityAdvancedSettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f919a, false, " ");
    }
}
