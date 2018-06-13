package com.brandall.nutter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class bj implements OnCheckedChangeListener {
    final /* synthetic */ ActivityCustomise f968a;

    bj(ActivityCustomise activityCustomise) {
        this.f968a = activityCustomise;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            ActivityCustomise.m552r(this.f968a);
        } else {
            this.f968a.f674g.setText("Non-English Recognition Language");
        }
    }
}
