package com.brandall.nutter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class bi implements OnCheckedChangeListener {
    final /* synthetic */ ActivityCustomise f967a;

    bi(ActivityCustomise activityCustomise) {
        this.f967a = activityCustomise;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f967a.f674g.setVisibility(0);
        } else {
            this.f967a.f674g.setVisibility(8);
        }
    }
}
