package com.brandall.nutter;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class at implements OnClickListener {
    final /* synthetic */ ActivityCommunity f939a;
    private final /* synthetic */ EditText f940b;
    private final /* synthetic */ Dialog f941c;

    at(ActivityCommunity activityCommunity, EditText editText, Dialog dialog) {
        this.f939a = activityCommunity;
        this.f940b = editText;
        this.f941c = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f940b.getText().toString();
        if (editable == null || editable.isEmpty() || editable.matches("") || editable.length() <= 0 || editable.replaceAll("\\s", "").matches("")) {
            lc.m1313a(this.f939a, false, "Something was wrong with the format of that joke.");
        } else if (mb.m1470a(this.f939a)) {
            this.f939a.m516a("Submitted - Thank you!");
            if (VERSION.SDK_INT >= 11) {
                kz.f1636e = true;
                kz.f1646o = editable.trim();
                hc.f1270c = true;
                new kz(this.f939a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new kz(this.f939a).execute(new Void[0]);
            }
        } else {
            lc.m1313a(this.f939a, false, "You need to create an account or register this device before you can submit content.");
            if (VERSION.SDK_INT >= 11) {
                new kz(this.f939a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new kz(this.f939a).execute(new Void[0]);
            }
        }
        this.f941c.dismiss();
    }
}
