package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class bb implements OnCancelListener {
    final /* synthetic */ ActivityContactPicker f956a;

    bb(ActivityContactPicker activityContactPicker) {
        this.f956a = activityContactPicker;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f956a, false, "The command creation has been cancelled.");
        this.f956a.m523b();
    }
}
