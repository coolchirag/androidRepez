package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class mz implements OnCancelListener {
    final /* synthetic */ TaskerPluginActivity f1755a;

    mz(TaskerPluginActivity taskerPluginActivity) {
        this.f1755a = taskerPluginActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f1755a.f886a.setChecked(false);
        this.f1755a.f901p = "";
    }
}
