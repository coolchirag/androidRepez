package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.faceture.google.play.QueryParamConst;

final class fk implements OnClickListener {
    final /* synthetic */ ActivitySettings f1193a;

    fk(ActivitySettings activitySettings) {
        this.f1193a = activitySettings;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1193a, false, "Cancelled");
        lx.m1393a(this.f1193a, QueryParamConst.HL_VALUE, "USA", false);
    }
}
