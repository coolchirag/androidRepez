package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

final class ef implements OnClickListener {
    final /* synthetic */ ActivitySettings f1093a;
    private final /* synthetic */ CheckBox f1094b;
    private final /* synthetic */ CheckBox f1095c;
    private final /* synthetic */ CheckBox f1096d;

    ef(ActivitySettings activitySettings, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3) {
        this.f1093a = activitySettings;
        this.f1094b = checkBox;
        this.f1095c = checkBox2;
        this.f1096d = checkBox3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1094b.isChecked()) {
            lx.m1403b(this.f1093a, "com.evernote", true);
            lc.m1313a(this.f1093a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1095c.isChecked()) {
            lx.m1403b(this.f1093a, "com.threebanana.notes", true);
            lc.m1313a(this.f1093a, false, "Thank you. Your selection has been stored.");
        } else if (this.f1096d.isChecked()) {
            lx.m1403b(this.f1093a, "com.springpad", true);
            lc.m1313a(this.f1093a, false, "Thank you. Your selection has been stored.");
        } else {
            lc.m1313a(this.f1093a, false, "I didn't detect a selection?");
        }
    }
}
