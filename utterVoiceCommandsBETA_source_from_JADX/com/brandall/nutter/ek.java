package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ek implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1104a;
    private final /* synthetic */ CheckBox f1105b;
    private final /* synthetic */ CheckBox f1106c;

    ek(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2) {
        this.f1104a = activitySettings;
        this.f1105b = checkBox;
        this.f1106c = checkBox2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb1oc:");
        }
        if (z) {
            this.f1105b.setChecked(false);
            this.f1106c.setChecked(false);
        }
    }
}
