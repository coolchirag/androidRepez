package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

final class dc implements OnClickListener {
    final /* synthetic */ ActivityPickerActivity f1040a;
    private final /* synthetic */ EditText f1041b;
    private final /* synthetic */ EditText f1042c;
    private final /* synthetic */ EditText f1043d;

    dc(ActivityPickerActivity activityPickerActivity, EditText editText, EditText editText2, EditText editText3) {
        this.f1040a = activityPickerActivity;
        this.f1041b = editText;
        this.f1042c = editText2;
        this.f1043d = editText3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = this.f1041b.getText().toString().trim();
        String trim2 = this.f1042c.getText().toString().trim();
        ls.m1344a("myAction: " + trim + " : myExtra1: " + trim2 + " : myExtra2: " + this.f1043d.getText().toString().trim());
    }
}
