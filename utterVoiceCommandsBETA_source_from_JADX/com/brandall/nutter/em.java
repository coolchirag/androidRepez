package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

final class em implements OnClickListener {
    final /* synthetic */ ActivitySettings f1110a;
    private final /* synthetic */ RadioGroup f1111b;
    private final /* synthetic */ Dialog f1112c;

    em(ActivitySettings activitySettings, RadioGroup radioGroup, Dialog dialog) {
        this.f1110a = activitySettings;
        this.f1111b = radioGroup;
        this.f1112c = dialog;
    }

    public final void onClick(View view) {
        if (this.f1111b.getCheckedRadioButtonId() == R.id.radio0) {
            lx.m1412c(this.f1110a, true);
        } else {
            lx.m1412c(this.f1110a, false);
        }
        this.f1112c.dismiss();
        lc.m1313a(this.f1110a, false, "Thank you. Your preference has been saved.");
    }
}
