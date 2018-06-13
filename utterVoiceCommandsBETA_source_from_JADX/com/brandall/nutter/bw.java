package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class bw implements OnClickListener {
    final /* synthetic */ ActivityCustomise f989a;
    private final /* synthetic */ EditText f990b;
    private final /* synthetic */ EditText f991c;
    private final /* synthetic */ Dialog f992d;

    bw(ActivityCustomise activityCustomise, EditText editText, EditText editText2, Dialog dialog) {
        this.f989a = activityCustomise;
        this.f990b = editText;
        this.f991c = editText2;
        this.f992d = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f990b.getText().toString();
        String editable2 = this.f991c.getText().toString();
        if (editable == null || editable.isEmpty() || editable.trim().matches("") || editable.trim().replaceAll("\\s", "").matches("") || editable.trim().length() <= 0 || editable2 == null || editable2.isEmpty() || editable2.trim().matches("") || editable2.trim().replaceAll("\\s", "").matches("") || editable2.trim().length() <= 0) {
            lc.m1313a(this.f989a, false, "The format of your custom replacement is incorrect");
            return;
        }
        ActivityCustomise.m528a(this.f989a, editable.trim(), editable2.trim());
        this.f992d.dismiss();
    }
}
