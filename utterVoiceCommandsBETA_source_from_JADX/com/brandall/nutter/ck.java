package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.faceture.google.play.QueryParamConst;

final class ck implements OnClickListener {
    final /* synthetic */ ActivityHome f1011a;

    ck(ActivityHome activityHome) {
        this.f1011a = activityHome;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f1011a, false, "Cancelled");
        lx.m1393a(this.f1011a, QueryParamConst.HL_VALUE, "USA", false);
        if (!lx.m1456y(this.f1011a)) {
            this.f1011a.m560b();
        }
    }
}
