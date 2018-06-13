package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class fv implements OnCancelListener {
    final /* synthetic */ ActivityUserNickNames f1209a;

    fv(ActivityUserNickNames activityUserNickNames) {
        this.f1209a = activityUserNickNames;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1209a, false, " ");
    }
}
