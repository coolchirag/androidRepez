package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class fb implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1168a;
    private final /* synthetic */ CheckBox f1169b;
    private final /* synthetic */ CheckBox f1170c;
    private final /* synthetic */ CheckBox f1171d;
    private final /* synthetic */ CheckBox f1172e;
    private final /* synthetic */ CheckBox f1173f;
    private final /* synthetic */ CheckBox f1174g;

    fb(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1168a = activitySettings;
        this.f1169b = checkBox;
        this.f1170c = checkBox2;
        this.f1171d = checkBox3;
        this.f1172e = checkBox4;
        this.f1173f = checkBox5;
        this.f1174g = checkBox6;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb5oc:");
        }
        if (z) {
            this.f1169b.setChecked(false);
            this.f1170c.setChecked(false);
            this.f1171d.setChecked(false);
            this.f1172e.setChecked(false);
            this.f1173f.setChecked(true);
            this.f1174g.setChecked(false);
        }
    }
}
