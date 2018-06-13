package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class fx implements OnClickListener {
    final /* synthetic */ ActivityUserNickNames f1215a;
    private final /* synthetic */ Dialog f1216b;

    fx(ActivityUserNickNames activityUserNickNames, Dialog dialog) {
        this.f1215a = activityUserNickNames;
        this.f1216b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f1215a, false, " ");
        this.f1216b.dismiss();
    }
}
