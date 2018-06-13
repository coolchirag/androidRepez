package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class C0146do implements OnClickListener {
    final /* synthetic */ ActivityPowerUser f1064a;

    C0146do(ActivityPowerUser activityPowerUser) {
        this.f1064a = activityPowerUser;
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
        lc.m1313a(this.f1064a, false, "In order to use the remote access feature, you'll need to first configure a password for your security. Information is available in the user guide, about using the remote control feature and how it can help you recover your device it is lost or stolen.");
    }
}
