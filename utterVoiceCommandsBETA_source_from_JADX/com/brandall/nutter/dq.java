package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import java.util.Locale;

final class dq implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1066a;
    private final /* synthetic */ EditText f1067b;
    private final /* synthetic */ EditText f1068c;
    private final /* synthetic */ EditText f1069d;
    private final /* synthetic */ Dialog f1070e;

    dq(ActivityPowerUser activityPowerUser, EditText editText, EditText editText2, EditText editText3, Dialog dialog) {
        this.f1066a = activityPowerUser;
        this.f1067b = editText;
        this.f1068c = editText2;
        this.f1069d = editText3;
        this.f1070e = dialog;
    }

    public final void onClick(View view) {
        String trim = this.f1067b.getText().toString().trim();
        String trim2 = this.f1068c.getText().toString().trim();
        String trim3 = this.f1069d.getText().toString().trim();
        if (trim == null || trim.isEmpty() || trim.replaceAll("\\s", "").isEmpty() || trim.matches("") || trim.length() <= 0 || trim2 == null || trim2.isEmpty() || trim2.replaceAll("\\s", "").isEmpty() || trim2.matches("") || trim2.length() <= 0 || trim3 == null || trim3.isEmpty() || trim3.replaceAll("\\s", "").isEmpty() || trim3.matches("") || trim3.length() <= 0) {
            lc.m1313a(this.f1066a, false, "Sorry, but the format of your password was incorrect. Please try again");
        } else if (trim3.contains("\\s") || trim2.contains("\\s")) {
            lc.m1313a(this.f1066a, false, "Your password must not contain any spaces, please re-enter a password.");
        } else if (!lx.m1385X(this.f1066a).matches(trim)) {
            lc.m1313a(this.f1066a, false, "Sorry, but you entered your existing password incorrectly. Please try again.");
        } else if (trim3.matches(trim2)) {
            if (trim3.toLowerCase(Locale.US).matches("child")) {
                lc.m1313a(this.f1066a, false, "Protection added");
                ActivityPowerUser.m633j(this.f1066a);
            } else if (lx.m1384W(this.f1066a)) {
                lc.m1313a(this.f1066a, false, "Password saved");
            } else {
                lc.m1313a(this.f1066a, false, "Your password has been updated successfully");
                ActivityPowerUser.m626c(this.f1066a, trim2);
            }
            this.f1070e.dismiss();
        } else {
            lc.m1313a(this.f1066a, false, "Sorry, but those passwords didn't match. Please try again.");
        }
    }
}
