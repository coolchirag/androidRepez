package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class gg implements OnCancelListener {
    final /* synthetic */ ActivityUserPhrases f1230a;

    gg(ActivityUserPhrases activityUserPhrases) {
        this.f1230a = activityUserPhrases;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1230a, false, " ");
    }
}
