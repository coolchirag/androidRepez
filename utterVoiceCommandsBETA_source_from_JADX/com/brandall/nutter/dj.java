package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class dj implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1055a;

    dj(ActivityPowerUser activityPowerUser) {
        this.f1055a = activityPowerUser;
    }

    public final void onClick(View view) {
        if (GlobalV.ap()) {
            try {
                ServiceTTS.m911a();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        GlobalV.m899w(true);
        lc.m1313a(this.f1055a, false, "You must enter your current password in order to configure a new one.");
    }
}
