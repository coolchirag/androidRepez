package com.brandall.nutter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;

final class fe implements OnClickListener {
    final /* synthetic */ ActivitySettings f1183a;
    private final /* synthetic */ SeekBar f1184b;
    private final /* synthetic */ Dialog f1185c;

    fe(ActivitySettings activitySettings, SeekBar seekBar, Dialog dialog) {
        this.f1183a = activitySettings;
        this.f1184b = seekBar;
        this.f1185c = dialog;
    }

    public final void onClick(View view) {
        boolean z = false;
        lc.m1313a(this.f1183a, false, "Thank you. I've updated your preference.");
        Context context = this.f1183a;
        int progress = this.f1184b.getProgress();
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        if (progress != 0) {
            z = true;
        }
        edit.putInt("pause_timeout", progress);
        edit.putBoolean("pause_timeout_condition", z);
        edit.commit();
        lx.ar(context);
        this.f1185c.dismiss();
    }
}
