package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ew implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1136a;
    private final /* synthetic */ CheckBox f1137b;
    private final /* synthetic */ CheckBox f1138c;
    private final /* synthetic */ CheckBox f1139d;
    private final /* synthetic */ CheckBox f1140e;
    private final /* synthetic */ CheckBox f1141f;
    private final /* synthetic */ CheckBox f1142g;

    ew(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1136a = activitySettings;
        this.f1137b = checkBox;
        this.f1138c = checkBox2;
        this.f1139d = checkBox3;
        this.f1140e = checkBox4;
        this.f1141f = checkBox5;
        this.f1142g = checkBox6;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb1oc:");
        }
        if (z) {
            this.f1137b.setChecked(true);
            this.f1138c.setChecked(false);
            this.f1139d.setChecked(false);
            this.f1140e.setChecked(false);
            this.f1141f.setChecked(false);
            this.f1142g.setChecked(false);
        }
    }
}
