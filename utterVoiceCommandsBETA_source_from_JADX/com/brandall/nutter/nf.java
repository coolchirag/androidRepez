package com.brandall.nutter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class nf implements OnCheckedChangeListener {
    final /* synthetic */ TaskerPluginActivity f1765a;

    nf(TaskerPluginActivity taskerPluginActivity) {
        this.f1765a = taskerPluginActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1765a.f895j.setVisibility(0);
            this.f1765a.f886a.setVisibility(8);
            this.f1765a.f887b.setVisibility(8);
            this.f1765a.f890e.setVisibility(8);
            this.f1765a.f896k.setVisibility(8);
            this.f1765a.f899n = true;
            return;
        }
        this.f1765a.f895j.setVisibility(8);
        this.f1765a.f886a.setVisibility(0);
        this.f1765a.f887b.setVisibility(0);
        this.f1765a.f890e.setVisibility(0);
        this.f1765a.f896k.setVisibility(0);
        this.f1765a.f899n = false;
    }
}
