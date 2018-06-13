package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class C0167w implements OnCancelListener {
    final /* synthetic */ ActivityAdvancedSettings f1832a;

    C0167w(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f1832a = activityAdvancedSettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1832a, false, "Cancelled");
    }
}
