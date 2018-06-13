package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class C0160p implements OnCancelListener {
    final /* synthetic */ ActivityAdvancedSettings f1819a;

    C0160p(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f1819a = activityAdvancedSettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1819a, false, " ");
    }
}
