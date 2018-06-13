package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class nj implements OnCancelListener {
    final /* synthetic */ TaskerPluginActivity f1769a;

    nj(TaskerPluginActivity taskerPluginActivity) {
        this.f1769a = taskerPluginActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f1769a.f889d.setChecked(false);
        this.f1769a.f889d.setText("Non-English Recognition Language");
        this.f1769a.f902q = "";
    }
}
