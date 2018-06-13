package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class gm implements OnClickListener {
    final /* synthetic */ ActivityUserWords f1240a;

    gm(ActivityUserWords activityUserWords) {
        this.f1240a = activityUserWords;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                ActivityUserWords.m715a(this.f1240a, this.f1240a.f748h.m1119b((long) ((Integer) this.f1240a.f743c.get(this.f1240a.f747g)).intValue()), this.f1240a.f748h.m1121c((long) ((Integer) this.f1240a.f743c.get(this.f1240a.f747g)).intValue()));
                return;
            case 1:
                this.f1240a.m719a();
                return;
            default:
                return;
        }
    }
}
