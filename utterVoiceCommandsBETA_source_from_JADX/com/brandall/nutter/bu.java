package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bu implements OnClickListener {
    final /* synthetic */ ActivityCustomise f986a;

    bu(ActivityCustomise activityCustomise) {
        this.f986a = activityCustomise;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f986a.f673f.setChecked(false);
        lc.m1313a(this.f986a, false, "I will use your default voice engine and language");
        this.f986a.f675h = "";
    }
}
