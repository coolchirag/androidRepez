package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class go implements OnClickListener {
    final /* synthetic */ ActivityUserWords f1242a;
    private final /* synthetic */ EditText f1243b;
    private final /* synthetic */ EditText f1244c;
    private final /* synthetic */ Dialog f1245d;

    go(ActivityUserWords activityUserWords, EditText editText, EditText editText2, Dialog dialog) {
        this.f1242a = activityUserWords;
        this.f1243b = editText;
        this.f1244c = editText2;
        this.f1245d = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f1243b.getText().toString();
        String editable2 = this.f1244c.getText().toString();
        if (editable == null || editable.isEmpty() || editable.trim().matches("") || editable.trim().replaceAll("\\s", "").matches("") || editable.trim().length() <= 0 || editable2 == null || editable2.isEmpty() || editable2.trim().matches("") || editable2.trim().replaceAll("\\s", "").matches("") || editable2.trim().length() <= 0) {
            lc.m1313a(this.f1242a, false, "The format of your custom replacement is incorrect");
            return;
        }
        this.f1242a.m720a(editable.trim(), editable2.trim());
        this.f1245d.dismiss();
    }
}
