package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class fa implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1161a;
    private final /* synthetic */ CheckBox f1162b;
    private final /* synthetic */ CheckBox f1163c;
    private final /* synthetic */ CheckBox f1164d;
    private final /* synthetic */ CheckBox f1165e;
    private final /* synthetic */ CheckBox f1166f;
    private final /* synthetic */ CheckBox f1167g;

    fa(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1161a = activitySettings;
        this.f1162b = checkBox;
        this.f1163c = checkBox2;
        this.f1164d = checkBox3;
        this.f1165e = checkBox4;
        this.f1166f = checkBox5;
        this.f1167g = checkBox6;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb4oc:");
        }
        if (z) {
            this.f1162b.setChecked(false);
            this.f1163c.setChecked(false);
            this.f1164d.setChecked(false);
            this.f1165e.setChecked(true);
            this.f1166f.setChecked(false);
            this.f1167g.setChecked(false);
        }
    }
}
