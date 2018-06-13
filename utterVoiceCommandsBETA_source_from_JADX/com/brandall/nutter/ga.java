package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ga implements OnCancelListener {
    final /* synthetic */ ActivityUserPhrases f1220a;

    ga(ActivityUserPhrases activityUserPhrases) {
        this.f1220a = activityUserPhrases;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f1220a.f738i.setChecked(false);
        lc.m1313a(this.f1220a, false, "I will use your default voice engine and language");
        this.f1220a.f739j = "";
    }
}
