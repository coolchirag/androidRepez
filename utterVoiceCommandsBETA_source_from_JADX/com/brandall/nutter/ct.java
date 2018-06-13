package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

final class ct implements OnClickListener {
    final /* synthetic */ ActivityLinkApps f1024a;
    private final /* synthetic */ EditText f1025b;
    private final /* synthetic */ EditText f1026c;
    private final /* synthetic */ EditText f1027d;

    ct(ActivityLinkApps activityLinkApps, EditText editText, EditText editText2, EditText editText3) {
        this.f1024a = activityLinkApps;
        this.f1025b = editText;
        this.f1026c = editText2;
        this.f1027d = editText3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = this.f1025b.getText().toString().trim();
        String trim2 = this.f1026c.getText().toString().trim();
        String trim3 = this.f1027d.getText().toString().trim();
        if (trim2 == null || trim2.isEmpty() || trim2.matches("") || trim2.length() <= 0 || trim == null || trim.isEmpty() || trim.matches("") || !trim.contains("@") || trim.length() <= 0) {
            lc.m1313a(this.f1024a, false, "There was something wrong with the structure of your account details.");
            return;
        }
        if (trim3 == null || trim3.isEmpty() || trim3.matches("")) {
            lx.m1428h(this.f1024a, " ");
        } else {
            lx.m1428h(this.f1024a, trim3);
        }
        lc.m1313a(this.f1024a, false, "E-mail authentication successful. A test message has been sent.");
        lx.m1402b(this.f1024a, trim, trim2, true);
        new kj(this.f1024a).execute(new String[]{trim});
    }
}
