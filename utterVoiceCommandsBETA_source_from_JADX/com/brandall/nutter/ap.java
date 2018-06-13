package com.brandall.nutter;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class ap implements OnClickListener {
    final /* synthetic */ ActivityCommunity f931a;
    private final /* synthetic */ EditText f932b;
    private final /* synthetic */ EditText f933c;
    private final /* synthetic */ Dialog f934d;

    ap(ActivityCommunity activityCommunity, EditText editText, EditText editText2, Dialog dialog) {
        this.f931a = activityCommunity;
        this.f932b = editText;
        this.f933c = editText2;
        this.f934d = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f932b.getText().toString();
        String editable2 = this.f933c.getText().toString();
        if (editable == null || editable.isEmpty() || editable.trim().matches("") || editable.trim().replaceAll("\\s", "").matches("") || editable.trim().length() <= 0 || editable2 == null || editable2.isEmpty() || editable2.trim().matches("") || editable2.trim().replaceAll("\\s", "").matches("") || editable2.trim().length() <= 0) {
            lc.m1313a(this.f931a, false, "There was something wrong with the format of your submission");
            return;
        }
        if (mb.m1470a(this.f931a)) {
            this.f931a.m516a("Submitted - Thank you!");
            if (VERSION.SDK_INT >= 11) {
                kz.f1637f = true;
                kz.f1647p = editable.trim();
                kz.f1648q = editable2.trim();
                hc.f1270c = true;
                new kz(this.f931a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new kz(this.f931a).execute(new Void[0]);
            }
        } else {
            lc.m1313a(this.f931a, false, "You need to create an account or register this device before you can submit content.");
            if (VERSION.SDK_INT >= 11) {
                new kz(this.f931a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new kz(this.f931a).execute(new Void[0]);
            }
        }
        this.f934d.dismiss();
    }
}
