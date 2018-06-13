package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class fw implements OnClickListener {
    final /* synthetic */ ActivityUserNickNames f1210a;
    private final /* synthetic */ EditText f1211b;
    private final /* synthetic */ String f1212c;
    private final /* synthetic */ String f1213d;
    private final /* synthetic */ Dialog f1214e;

    fw(ActivityUserNickNames activityUserNickNames, EditText editText, String str, String str2, Dialog dialog) {
        this.f1210a = activityUserNickNames;
        this.f1211b = editText;
        this.f1212c = str;
        this.f1213d = str2;
        this.f1214e = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f1211b.getText().toString();
        if (editable == null || editable.isEmpty() || editable.trim().matches("") || editable.trim().replaceAll("\\s", "").matches("") || editable.trim().length() <= 0) {
            lc.m1313a(this.f1210a, false, "The format of the nickname is incorrect");
            return;
        }
        this.f1210a.m696a(editable.trim(), this.f1212c, this.f1213d);
        this.f1214e.dismiss();
    }
}
