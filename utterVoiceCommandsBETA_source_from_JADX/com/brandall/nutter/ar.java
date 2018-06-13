package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class ar implements OnClickListener {
    final /* synthetic */ ActivityCommunity f937a;

    ar(ActivityCommunity activityCommunity) {
        this.f937a = activityCommunity;
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
        lc.m1313a(this.f937a, false, "Here you can submit knowledge that I will use as a response to all users of, Utter. Please do be mindful, that many of the application's users are children, who have delicate ears.");
    }
}
