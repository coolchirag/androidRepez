package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.faceture.google.play.QueryParamConst;

final class fj implements OnCancelListener {
    final /* synthetic */ ActivitySettings f1192a;

    fj(ActivitySettings activitySettings) {
        this.f1192a = activitySettings;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        lc.m1313a(this.f1192a, false, "Cancelled");
        lx.m1393a(this.f1192a, QueryParamConst.HL_VALUE, "USA", false);
    }
}
