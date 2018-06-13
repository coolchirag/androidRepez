package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class fu implements OnClickListener {
    final /* synthetic */ ActivityUserNickNames f1208a;

    fu(ActivityUserNickNames activityUserNickNames) {
        this.f1208a = activityUserNickNames;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                ActivityUserNickNames.m691a(this.f1208a, this.f1208a.f729h.m1096b((long) ((Integer) this.f1208a.f724c.get(this.f1208a.f728g)).intValue()), this.f1208a.f729h.m1098c((long) ((Integer) this.f1208a.f724c.get(this.f1208a.f728g)).intValue()), this.f1208a.f729h.m1100d((long) ((Integer) this.f1208a.f724c.get(this.f1208a.f728g)).intValue()));
                return;
            case 1:
                this.f1208a.m695a();
                return;
            default:
                return;
        }
    }
}
