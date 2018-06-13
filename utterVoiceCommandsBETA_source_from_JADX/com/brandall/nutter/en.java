package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class en implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1113a;
    private final /* synthetic */ CheckBox f1114b;
    private final /* synthetic */ CheckBox f1115c;

    en(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2) {
        this.f1113a = activitySettings;
        this.f1114b = checkBox;
        this.f1115c = checkBox2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb3oc:");
        }
        if (z) {
            this.f1114b.setChecked(false);
            this.f1115c.setChecked(false);
        }
    }
}
