package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class gj implements OnClickListener {
    final /* synthetic */ ActivityUserPhrases f1236a;
    private final /* synthetic */ Dialog f1237b;

    gj(ActivityUserPhrases activityUserPhrases, Dialog dialog) {
        this.f1236a = activityUserPhrases;
        this.f1237b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1236a, false, " ");
        this.f1237b.dismiss();
    }
}
