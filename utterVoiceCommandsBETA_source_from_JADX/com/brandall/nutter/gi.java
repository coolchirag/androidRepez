package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class gi implements OnClickListener {
    final /* synthetic */ ActivityUserPhrases f1232a;
    private final /* synthetic */ EditText f1233b;
    private final /* synthetic */ EditText f1234c;
    private final /* synthetic */ Dialog f1235d;

    gi(ActivityUserPhrases activityUserPhrases, EditText editText, EditText editText2, Dialog dialog) {
        this.f1232a = activityUserPhrases;
        this.f1233b = editText;
        this.f1234c = editText2;
        this.f1235d = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f1233b.getText().toString();
        String editable2 = this.f1234c.getText().toString();
        if (editable == null || editable.isEmpty() || editable.matches("") || editable.length() <= 0 || editable2 == null || editable2.isEmpty() || editable2.matches("") || editable2.length() <= 0) {
            lc.m1313a(this.f1232a, false, "The format of your custom phrase is incorrect");
            return;
        }
        this.f1232a.m710a(editable.trim(), editable2.trim(), this.f1232a.f737h.isChecked());
        this.f1235d.dismiss();
    }
}
