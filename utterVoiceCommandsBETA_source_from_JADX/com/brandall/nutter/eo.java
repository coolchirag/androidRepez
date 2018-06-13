package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

final class eo implements OnClickListener {
    final /* synthetic */ ActivitySettings f1116a;
    private final /* synthetic */ CheckBox f1117b;
    private final /* synthetic */ CheckBox f1118c;
    private final /* synthetic */ CheckBox f1119d;
    private final /* synthetic */ CheckBox f1120e;
    private final /* synthetic */ CheckBox f1121f;
    private final /* synthetic */ CheckBox f1122g;

    eo(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6) {
        this.f1116a = activitySettings;
        this.f1117b = checkBox;
        this.f1118c = checkBox2;
        this.f1119d = checkBox3;
        this.f1120e = checkBox4;
        this.f1121f = checkBox5;
        this.f1122g = checkBox6;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1117b.isChecked()) {
            lx.m1394a(this.f1116a, "com.ghisler.android.TotalCommander", true);
            lc.m1313a(this.f1116a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1118c.isChecked()) {
            lx.m1394a(this.f1116a, "com.speedsoftware.rootexplorer", true);
            lc.m1313a(this.f1116a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1119d.isChecked()) {
            lx.m1394a(this.f1116a, "com.estrongs.android.pop", true);
            lc.m1313a(this.f1116a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1120e.isChecked()) {
            lx.m1394a(this.f1116a, "xcxin.filexpert", true);
            lc.m1313a(this.f1116a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1121f.isChecked()) {
            lx.m1394a(this.f1116a, "com.speedsoftware.explorer", true);
            lc.m1313a(this.f1116a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1122g.isChecked()) {
            lx.m1394a(this.f1116a, "pl.solidexplorer", true);
            lc.m1313a(this.f1116a, false, "Thank you. Your selection has been stored.");
        } else {
            lc.m1313a(this.f1116a, false, "I didn't detect a selection?");
        }
    }
}
