package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

final class C0151i implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1421a;
    private final /* synthetic */ RadioGroup f1422b;
    private final /* synthetic */ Dialog f1423c;

    C0151i(ActivityAdvancedSettings activityAdvancedSettings, RadioGroup radioGroup, Dialog dialog) {
        this.f1421a = activityAdvancedSettings;
        this.f1422b = radioGroup;
        this.f1423c = dialog;
    }

    public final void onClick(View view) {
        if (this.f1422b.getCheckedRadioButtonId() == R.id.radio2) {
            lx.m1390a(this.f1421a, 250, 200, 650);
        } else if (this.f1422b.getCheckedRadioButtonId() == R.id.radio1) {
            lx.m1390a(this.f1421a, 190, 250, 550);
        } else if (this.f1422b.getCheckedRadioButtonId() == R.id.radio3) {
            lx.m1390a(this.f1421a, 350, 150, 800);
        } else {
            lx.m1390a(this.f1421a, 120, 300, 600);
        }
        this.f1423c.dismiss();
        lc.m1313a(this.f1421a, false, "Preference saved.");
        if (ly.m1466c(this.f1421a)) {
            jy.m1245c(this.f1421a, true);
        }
    }
}
