package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class aq implements OnClickListener {
    final /* synthetic */ ActivityCommunity f935a;
    private final /* synthetic */ Dialog f936b;

    aq(ActivityCommunity activityCommunity, Dialog dialog) {
        this.f935a = activityCommunity;
        this.f936b = dialog;
    }

    public final void onClick(View view) {
        lc.m1313a(this.f935a, false, " ");
        this.f936b.dismiss();
    }
}
