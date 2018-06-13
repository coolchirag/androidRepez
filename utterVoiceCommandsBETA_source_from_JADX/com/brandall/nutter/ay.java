package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class ay implements OnClickListener {
    final /* synthetic */ ActivityContactPicker f947a;
    private final /* synthetic */ EditText f948b;
    private final /* synthetic */ String f949c;
    private final /* synthetic */ String f950d;
    private final /* synthetic */ Dialog f951e;

    ay(ActivityContactPicker activityContactPicker, EditText editText, String str, String str2, Dialog dialog) {
        this.f947a = activityContactPicker;
        this.f948b = editText;
        this.f949c = str;
        this.f950d = str2;
        this.f951e = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f948b.getText().toString();
        if (editable == null || editable.isEmpty() || editable.matches("") || editable.replaceAll("\\s", "").isEmpty() || editable.replaceAll("\\s", "").length() <= 0) {
            lc.m1313a(this.f947a, false, "Sorry, but the format of the nickname was incorrect");
            this.f947a.m520a();
            return;
        }
        lc.m1313a(this.f947a, false, "Ok, I linked the nickname, " + editable.trim() + ", with the contact, " + this.f949c);
        lx.m1427g(this.f947a, true);
        new hh(this.f947a).m1094a(editable.trim(), this.f949c, this.f950d);
        this.f951e.dismiss();
        this.f947a.finish();
    }
}
