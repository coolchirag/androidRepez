package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

final class C0159o implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1816a;
    private final /* synthetic */ RadioGroup f1817b;
    private final /* synthetic */ Dialog f1818c;

    C0159o(ActivityAdvancedSettings activityAdvancedSettings, RadioGroup radioGroup, Dialog dialog) {
        this.f1816a = activityAdvancedSettings;
        this.f1817b = radioGroup;
        this.f1818c = dialog;
    }

    public final void onClick(View view) {
        if (this.f1817b.getCheckedRadioButtonId() == R.id.radio0) {
            lx.m1399b(this.f1816a, 16);
        } else if (this.f1817b.getCheckedRadioButtonId() == R.id.radio1) {
            lx.m1399b(this.f1816a, 14);
        } else {
            if (this.f1817b.getCheckedRadioButtonId() != R.id.radio2) {
                if (this.f1817b.getCheckedRadioButtonId() == R.id.radio3) {
                    lx.m1399b(this.f1816a, 8);
                } else if (this.f1817b.getCheckedRadioButtonId() == R.id.radio4) {
                    lx.m1399b(this.f1816a, 6);
                }
            }
            lx.m1399b(this.f1816a, 11);
        }
        this.f1818c.dismiss();
        lc.m1313a(this.f1816a, false, "Preference saved.");
        if (ly.m1467d(this.f1816a)) {
            jy.m1241b(this.f1816a, true);
        }
    }
}
