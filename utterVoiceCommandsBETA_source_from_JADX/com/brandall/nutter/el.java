package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class el implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1107a;
    private final /* synthetic */ CheckBox f1108b;
    private final /* synthetic */ CheckBox f1109c;

    el(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2) {
        this.f1107a = activitySettings;
        this.f1108b = checkBox;
        this.f1109c = checkBox2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb2oc:");
        }
        if (z) {
            this.f1108b.setChecked(false);
            this.f1109c.setChecked(false);
        }
    }
}
