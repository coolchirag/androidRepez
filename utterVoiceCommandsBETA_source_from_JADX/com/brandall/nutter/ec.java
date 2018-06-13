package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

final class ec implements OnClickListener {
    final /* synthetic */ ActivitySettings f1086a;
    private final /* synthetic */ CheckBox f1087b;
    private final /* synthetic */ CheckBox f1088c;
    private final /* synthetic */ Dialog f1089d;

    ec(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, Dialog dialog) {
        this.f1086a = activitySettings;
        this.f1087b = checkBox;
        this.f1088c = checkBox2;
        this.f1089d = dialog;
    }

    public final void onClick(View view) {
        if (this.f1087b.isChecked()) {
            lx.m1421e(this.f1086a, true);
        } else {
            lx.m1421e(this.f1086a, false);
        }
        if (this.f1088c.isChecked()) {
            lx.m1417d(this.f1086a, true);
        } else {
            lx.m1417d(this.f1086a, false);
        }
        lc.m1313a(this.f1086a, false, "Thank you. Your preferences have been stored");
        this.f1089d.dismiss();
    }
}
