package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class C0153j implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1516a;
    private final /* synthetic */ Dialog f1517b;

    C0153j(ActivityAdvancedSettings activityAdvancedSettings, Dialog dialog) {
        this.f1516a = activityAdvancedSettings;
        this.f1517b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1516a, false, " ");
        this.f1517b.dismiss();
    }
}
