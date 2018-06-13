package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C0168x implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1833a;

    C0168x(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f1833a = activityAdvancedSettings;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1833a, false, "Cancelled");
    }
}
