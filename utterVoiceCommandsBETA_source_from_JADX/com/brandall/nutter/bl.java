package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;

final class bl implements OnClickListener {
    final /* synthetic */ ActivityCustomise f970a;
    private final /* synthetic */ EditText f971b;
    private final /* synthetic */ EditText f972c;
    private final /* synthetic */ CheckBox f973d;
    private final /* synthetic */ Dialog f974e;

    bl(ActivityCustomise activityCustomise, EditText editText, EditText editText2, CheckBox checkBox, Dialog dialog) {
        this.f970a = activityCustomise;
        this.f971b = editText;
        this.f972c = editText2;
        this.f973d = checkBox;
        this.f974e = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f971b.getText().toString();
        String editable2 = this.f972c.getText().toString();
        if (hc.f1269b) {
            ls.m1346c("userPhrase: " + editable);
        }
        if (editable == null || editable.isEmpty() || editable.matches("") || editable.length() <= 0 || editable2 == null || editable2.isEmpty() || editable2.matches("") || editable2.length() <= 0) {
            lc.m1313a(this.f970a, false, "The format of your custom phrase is incorrect.");
            return;
        }
        lx.m1439l(this.f970a, true);
        ActivityCustomise.m529a(this.f970a, editable.trim(), editable2.trim(), this.f973d.isChecked());
        this.f974e.dismiss();
    }
}
