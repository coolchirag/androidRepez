package com.brandall.nutter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class fc implements OnCheckedChangeListener {
    final /* synthetic */ ActivitySettings f1175a;
    private final /* synthetic */ CheckBox f1176b;
    private final /* synthetic */ CheckBox f1177c;
    private final /* synthetic */ CheckBox f1178d;
    private final /* synthetic */ CheckBox f1179e;
    private final /* synthetic */ CheckBox f1180f;
    private final /* synthetic */ CheckBox f1181g;

    fc(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1175a = activitySettings;
        this.f1176b = checkBox;
        this.f1177c = checkBox2;
        this.f1178d = checkBox3;
        this.f1179e = checkBox4;
        this.f1180f = checkBox5;
        this.f1181g = checkBox6;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("cb6oc:");
        }
        if (z) {
            this.f1176b.setChecked(false);
            this.f1177c.setChecked(false);
            this.f1178d.setChecked(false);
            this.f1179e.setChecked(false);
            this.f1180f.setChecked(false);
            this.f1181g.setChecked(true);
        }
    }
}
