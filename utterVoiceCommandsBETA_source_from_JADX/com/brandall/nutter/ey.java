package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ey implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1145a;
    private final /* synthetic */ CheckBox f1146b;
    private final /* synthetic */ CheckBox f1147c;
    private final /* synthetic */ CheckBox f1148d;
    private final /* synthetic */ CheckBox f1149e;
    private final /* synthetic */ CheckBox f1150f;
    private final /* synthetic */ CheckBox f1151g;

    ey(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1145a = activitySettings;
        this.f1146b = checkBox;
        this.f1147c = checkBox2;
        this.f1148d = checkBox3;
        this.f1149e = checkBox4;
        this.f1150f = checkBox5;
        this.f1151g = checkBox6;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb2oc:");
        }
        if (z) {
            this.f1146b.setChecked(false);
            this.f1147c.setChecked(true);
            this.f1148d.setChecked(false);
            this.f1149e.setChecked(false);
            this.f1150f.setChecked(false);
            this.f1151g.setChecked(false);
        }
    }
}
