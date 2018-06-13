package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class gb implements OnClickListener {
    final /* synthetic */ ActivityUserPhrases f1221a;

    gb(ActivityUserPhrases activityUserPhrases) {
        this.f1221a = activityUserPhrases;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1221a.f738i.setChecked(false);
        lc.m1313a(this.f1221a, false, "I will use your default voice engine and language");
        this.f1221a.f739j = "";
    }
}
