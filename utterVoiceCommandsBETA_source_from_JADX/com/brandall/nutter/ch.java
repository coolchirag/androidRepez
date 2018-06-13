package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ch implements OnClickListener {
    final /* synthetic */ ActivityHome f1008a;

    ch(ActivityHome activityHome) {
        this.f1008a = activityHome;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1008a.finish();
    }
}
