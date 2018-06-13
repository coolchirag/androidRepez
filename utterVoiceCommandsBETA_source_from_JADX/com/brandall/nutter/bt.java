package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class bt implements OnCancelListener {
    final /* synthetic */ ActivityCustomise f985a;

    bt(ActivityCustomise activityCustomise) {
        this.f985a = activityCustomise;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f985a.f673f.setChecked(false);
        lc.m1313a(this.f985a, false, "I will use your default voice engine and language");
        this.f985a.f675h = "";
    }
}
