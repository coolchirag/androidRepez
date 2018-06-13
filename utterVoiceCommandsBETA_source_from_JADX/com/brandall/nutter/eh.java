package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class eh implements OnClickListener {
    final /* synthetic */ ActivitySettings f1098a;
    private final /* synthetic */ Dialog f1099b;

    eh(ActivitySettings activitySettings, Dialog dialog) {
        this.f1098a = activitySettings;
        this.f1099b = dialog;
    }

    public final void onClick(View view) {
        if (!jy.m1262m(this.f1098a, "com.evernote")) {
            jy.m1264o(this.f1098a, "com.evernote");
            this.f1099b.dismiss();
        }
    }
}
