package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bc implements OnClickListener {
    final /* synthetic */ ActivityContactPicker f957a;

    bc(ActivityContactPicker activityContactPicker) {
        this.f957a = activityContactPicker;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f957a, false, "The command creation has been cancelled.");
        this.f957a.m523b();
    }
}
