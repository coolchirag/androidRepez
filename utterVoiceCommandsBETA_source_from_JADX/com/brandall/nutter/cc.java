package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class cc implements OnClickListener {
    final /* synthetic */ ActivityCustomise f1001a;
    private final /* synthetic */ EditText f1002b;
    private final /* synthetic */ Dialog f1003c;

    cc(ActivityCustomise activityCustomise, EditText editText, Dialog dialog) {
        this.f1001a = activityCustomise;
        this.f1002b = editText;
        this.f1003c = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f1002b.getText().toString();
        if (editable == null || editable.isEmpty() || editable.matches("") || editable.length() <= 0) {
            lc.m1313a(this.f1001a, false, "I will start listening immediately.");
            lx.m1416d(this.f1001a, "silence", true);
        } else {
            lc.m1313a(this.f1001a, false, "When activated, I'll say. " + editable.trim());
            lx.m1416d(this.f1001a, editable.trim(), true);
        }
        this.f1003c.dismiss();
    }
}
