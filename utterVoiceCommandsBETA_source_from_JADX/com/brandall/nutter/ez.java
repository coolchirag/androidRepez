package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ez implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1152a;
    private final /* synthetic */ CheckBox f1153b;
    private final /* synthetic */ CheckBox f1154c;
    private final /* synthetic */ CheckBox f1155d;
    private final /* synthetic */ CheckBox f1156e;
    private final /* synthetic */ CheckBox f1157f;
    private final /* synthetic */ CheckBox f1158g;

    ez(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1152a = activitySettings;
        this.f1153b = checkBox;
        this.f1154c = checkBox2;
        this.f1155d = checkBox3;
        this.f1156e = checkBox4;
        this.f1157f = checkBox5;
        this.f1158g = checkBox6;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb3oc:");
        }
        if (z) {
            this.f1153b.setChecked(false);
            this.f1154c.setChecked(false);
            this.f1155d.setChecked(true);
            this.f1156e.setChecked(false);
            this.f1157f.setChecked(false);
            this.f1158g.setChecked(false);
        }
    }
}
