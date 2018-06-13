package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class gn implements OnCancelListener {
    final /* synthetic */ ActivityUserWords f1241a;

    gn(ActivityUserWords activityUserWords) {
        this.f1241a = activityUserWords;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1241a, false, " ");
    }
}
