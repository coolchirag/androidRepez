package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ci implements OnCancelListener {
    final /* synthetic */ ActivityHome f1009a;

    ci(ActivityHome activityHome) {
        this.f1009a = activityHome;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f1009a.finish();
    }
}
