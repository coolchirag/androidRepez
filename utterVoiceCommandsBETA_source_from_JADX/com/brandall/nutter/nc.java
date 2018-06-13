package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class nc implements OnClickListener {
    final /* synthetic */ TaskerPluginActivity f1762a;

    nc(TaskerPluginActivity taskerPluginActivity) {
        this.f1762a = taskerPluginActivity;
    }

    public final void onClick(View view) {
        this.f1762a.f897l = true;
        this.f1762a.finish();
    }
}
