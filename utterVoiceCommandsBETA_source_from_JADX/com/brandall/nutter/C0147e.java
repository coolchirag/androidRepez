package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class C0147e implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1081a;
    private final /* synthetic */ EditText f1082b;
    private final /* synthetic */ Dialog f1083c;

    C0147e(ActivityAdvancedSettings activityAdvancedSettings, EditText editText, Dialog dialog) {
        this.f1081a = activityAdvancedSettings;
        this.f1082b = editText;
        this.f1083c = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f1082b.getText().toString();
        if (editable == null || editable.isEmpty() || editable.replaceAll("\\s", "").matches("") || editable.length() <= 0) {
            lc.m1313a(this.f1081a, false, "I won't include a signature in your text messages.");
            lx.m1426g(this.f1081a, " ");
            this.f1083c.dismiss();
            return;
        }
        lc.m1313a(this.f1081a, false, "I've updated your text message signature");
        lx.m1426g(this.f1081a, editable.trim());
        this.f1083c.dismiss();
    }
}
