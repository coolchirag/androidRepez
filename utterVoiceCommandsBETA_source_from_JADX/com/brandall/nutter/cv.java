package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

final class cv implements OnClickListener {
    final /* synthetic */ ActivityLinkApps f1029a;
    private final /* synthetic */ EditText f1030b;
    private final /* synthetic */ EditText f1031c;

    cv(ActivityLinkApps activityLinkApps, EditText editText, EditText editText2) {
        this.f1029a = activityLinkApps;
        this.f1030b = editText;
        this.f1031c = editText2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String editable = this.f1030b.getText().toString();
        String editable2 = this.f1031c.getText().toString();
        if (editable2 == null || editable2.trim().isEmpty() || editable2.matches("") || editable2.length() <= 0 || editable == null || editable.trim().isEmpty() || editable.matches("") || !editable.contains("@") || editable.length() <= 0) {
            lc.m1313a(this.f1029a, false, "There was something wrong with the structure of your account details.");
            return;
        }
        lc.m1313a(this.f1029a, false, "Attempting authorisation.");
        ActivityLinkApps.m590c(this.f1029a, editable.trim(), editable2.trim());
    }
}
