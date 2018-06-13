package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

final class C0161q implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1820a;
    private final /* synthetic */ RadioGroup f1821b;
    private final /* synthetic */ Dialog f1822c;

    C0161q(ActivityAdvancedSettings activityAdvancedSettings, RadioGroup radioGroup, Dialog dialog) {
        this.f1820a = activityAdvancedSettings;
        this.f1821b = radioGroup;
        this.f1822c = dialog;
    }

    public final void onClick(View view) {
        if (this.f1821b.getCheckedRadioButtonId() == R.id.radio0) {
            lx.m1389a(this.f1820a, 2);
            lc.m1313a(this.f1820a, false, "I'll execute a web search for all unknown commands");
        } else if (this.f1821b.getCheckedRadioButtonId() == R.id.radio1) {
            lx.m1389a(this.f1820a, 3);
            lc.m1313a(this.f1820a, false, "I'll send all unknown commands to Wolfram Alpha.");
        } else if (this.f1821b.getCheckedRadioButtonId() == R.id.radio2) {
            lx.m1389a(this.f1820a, 1);
            lc.m1313a(this.f1820a, false, "I'll ask you to repeat the question.");
        } else if (this.f1821b.getCheckedRadioButtonId() == R.id.radio3) {
            lx.m1389a(this.f1820a, 4);
            lc.m1313a(this.f1820a, false, "You can decide which action to take at the time");
        } else {
            lx.m1389a(this.f1820a, 0);
            lc.m1313a(this.f1820a, false, "I'll let you know if I don't understand the command");
        }
        this.f1822c.dismiss();
    }
}
