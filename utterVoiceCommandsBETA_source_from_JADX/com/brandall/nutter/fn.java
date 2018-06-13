package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

final class fn implements OnClickListener {
    final /* synthetic */ ActivitySettings f1198a;
    private final /* synthetic */ RadioGroup f1199b;
    private final /* synthetic */ Dialog f1200c;

    fn(ActivitySettings activitySettings, RadioGroup radioGroup, Dialog dialog) {
        this.f1198a = activitySettings;
        this.f1199b = radioGroup;
        this.f1200c = dialog;
    }

    public final void onClick(View view) {
        if (this.f1199b.getCheckedRadioButtonId() == R.id.radio0) {
            lx.m1415d(this.f1198a, "c");
            lc.m1313a(this.f1198a, false, "Your preference has been set to Celsius");
        } else if (this.f1199b.getCheckedRadioButtonId() == R.id.radio1) {
            lx.m1415d(this.f1198a, "f");
            lc.m1313a(this.f1198a, false, "Your preference has been set to fahrenheit");
        } else {
            lx.m1415d(this.f1198a, "");
            lc.m1313a(this.f1198a, false, "I will use both temperature units");
        }
        this.f1200c.dismiss();
    }
}
