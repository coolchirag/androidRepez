package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ni implements OnClickListener {
    final /* synthetic */ TaskerPluginActivity f1768a;

    ni(TaskerPluginActivity taskerPluginActivity) {
        this.f1768a = taskerPluginActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1768a.f889d.setChecked(false);
        this.f1768a.f889d.setText("Non-English Recognition Language");
        this.f1768a.f902q = "";
    }
}
