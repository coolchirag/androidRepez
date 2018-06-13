package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class C0170z implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1837a;
    private final /* synthetic */ Dialog f1838b;

    C0170z(ActivityAdvancedSettings activityAdvancedSettings, Dialog dialog) {
        this.f1837a = activityAdvancedSettings;
        this.f1838b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1837a, false, " ");
        this.f1838b.dismiss();
    }
}
