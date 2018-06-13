package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ca implements OnClickListener {
    final /* synthetic */ ActivityCustomise f999a;

    ca(ActivityCustomise activityCustomise) {
        this.f999a = activityCustomise;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        lc.m1313a(this.f999a, false, "Cancelled.");
        GlobalV.m886s(false);
        GlobalV.m858k(0);
    }
}
