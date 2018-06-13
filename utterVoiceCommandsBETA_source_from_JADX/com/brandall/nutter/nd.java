package com.brandall.nutter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class nd implements OnCheckedChangeListener {
    final /* synthetic */ TaskerPluginActivity f1763a;

    nd(TaskerPluginActivity taskerPluginActivity) {
        this.f1763a = taskerPluginActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1763a.f889d.setVisibility(0);
        } else {
            this.f1763a.f889d.setVisibility(8);
        }
    }
}
