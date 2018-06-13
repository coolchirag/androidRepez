package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class ac implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f913a;
    private final /* synthetic */ EditText f914b;
    private final /* synthetic */ Dialog f915c;

    ac(ActivityAdvancedSettings activityAdvancedSettings, EditText editText, Dialog dialog) {
        this.f913a = activityAdvancedSettings;
        this.f914b = editText;
        this.f915c = dialog;
    }

    public final void onClick(View view) {
        String editable = this.f914b.getText().toString();
        if (editable == null || editable.isEmpty() || editable.replaceAll("\\s", "").matches("") || editable.length() <= 0) {
            lc.m1313a(this.f913a, false, "I won't include a signature in your emails.");
            lx.m1428h(this.f913a, " ");
            this.f915c.dismiss();
            return;
        }
        lc.m1313a(this.f913a, false, "I've updated your email signature");
        lx.m1428h(this.f913a, editable.trim());
        this.f915c.dismiss();
    }
}
