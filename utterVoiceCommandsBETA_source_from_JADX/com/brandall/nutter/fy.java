package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class fy implements OnClickListener {
    final /* synthetic */ ActivityUserNickNames f1217a;

    fy(ActivityUserNickNames activityUserNickNames) {
        this.f1217a = activityUserNickNames;
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
        lc.m1313a(this.f1217a, false, "Please ensure the nickname you use for the contact is not already in use. Also, check that Google Voice Search correctly recognises the nickname you are intending to use. If I appear to be having problems detecting the contact from the nickname, please make sure that when calling contacts on their mobile, or texting them, they have a number listed in the mobile field of their contact card. Custom labels or work numbers will not be detected. If you are still having problems with nicknames being recognised, please refer to the troubleshooting section for more information on why this could be happening. ");
    }
}
