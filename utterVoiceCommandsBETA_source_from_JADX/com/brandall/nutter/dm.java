package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import java.util.Locale;

final class dm implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1058a;
    private final /* synthetic */ EditText f1059b;
    private final /* synthetic */ EditText f1060c;
    private final /* synthetic */ Dialog f1061d;

    dm(ActivityPowerUser activityPowerUser, EditText editText, EditText editText2, Dialog dialog) {
        this.f1058a = activityPowerUser;
        this.f1059b = editText;
        this.f1060c = editText2;
        this.f1061d = dialog;
    }

    public final void onClick(View view) {
        String trim = this.f1059b.getText().toString().trim();
        String trim2 = this.f1060c.getText().toString().trim();
        if (trim == null || trim.isEmpty() || trim.replaceAll("\\s", "").isEmpty() || trim.matches("") || trim.length() <= 0 || trim2 == null || trim2.isEmpty() || trim2.replaceAll("\\s", "").isEmpty() || trim2.matches("") || trim2.length() <= 0) {
            lc.m1313a(this.f1058a, false, "Sorry, but the format of your password was incorrect. Please try again");
        } else if (trim.contains("\\s") || trim2.contains("\\s")) {
            lc.m1313a(this.f1058a, false, "Your password must not contain any spaces, please re-enter a password.");
        } else if (trim.matches(trim2)) {
            if (trim.toLowerCase(Locale.US).matches("child")) {
                lc.m1313a(this.f1058a, false, "Protection added");
                ActivityPowerUser.m633j(this.f1058a);
            } else if (lx.m1384W(this.f1058a)) {
                lc.m1313a(this.f1058a, false, "Password saved");
            } else {
                lc.m1313a(this.f1058a, false, "Your password has been saved");
                ActivityPowerUser.m626c(this.f1058a, trim);
            }
            this.f1061d.dismiss();
        } else {
            lc.m1313a(this.f1058a, false, "Sorry, but those passwords didn't match. Please try again.");
        }
    }
}
