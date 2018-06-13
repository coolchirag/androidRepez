package com.brandall.nutter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ne implements OnCheckedChangeListener {
    final /* synthetic */ TaskerPluginActivity f1764a;

    ne(TaskerPluginActivity taskerPluginActivity) {
        this.f1764a = taskerPluginActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            TaskerPluginActivity.m955c(this.f1764a);
        } else {
            this.f1764a.f889d.setText("Non-English Recognition Language");
        }
    }
}
