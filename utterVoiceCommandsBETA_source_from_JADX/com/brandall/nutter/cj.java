package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.faceture.google.play.QueryParamConst;

final class cj implements OnCancelListener {
    final /* synthetic */ ActivityHome f1010a;

    cj(ActivityHome activityHome) {
        this.f1010a = activityHome;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1010a, false, "Cancelled");
        lx.m1393a(this.f1010a, QueryParamConst.HL_VALUE, "USA", false);
        if (!lx.m1456y(this.f1010a)) {
            this.f1010a.m560b();
        }
    }
}
