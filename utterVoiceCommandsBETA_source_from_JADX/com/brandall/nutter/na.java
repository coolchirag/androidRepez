package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class na implements OnClickListener {
    final /* synthetic */ TaskerPluginActivity f1759a;

    na(TaskerPluginActivity taskerPluginActivity) {
        this.f1759a = taskerPluginActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1759a.f886a.setChecked(false);
        this.f1759a.f901p = "";
    }
}
