package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class es implements OnClickListener {
    final /* synthetic */ ActivitySettings f1128a;
    private final /* synthetic */ Dialog f1129b;

    es(ActivitySettings activitySettings, Dialog dialog) {
        this.f1128a = activitySettings;
        this.f1129b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1128a, "com.estrongs.android.pop")) {
            jy.m1264o(this.f1128a, "com.estrongs.android.pop");
            this.f1129b.dismiss();
        }
    }
}
