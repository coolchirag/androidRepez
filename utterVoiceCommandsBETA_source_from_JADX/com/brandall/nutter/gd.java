package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class gd implements OnClickListener {
    final /* synthetic */ ActivityUserPhrases f1224a;

    gd(ActivityUserPhrases activityUserPhrases) {
        this.f1224a = activityUserPhrases;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f1224a.m708a();
                return;
            case 1:
                this.f1224a.m711b();
                return;
            default:
                return;
        }
    }
}
