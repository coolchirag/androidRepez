package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class av implements OnClickListener {
    final /* synthetic */ ActivityCommunity f944a;

    av(ActivityCommunity activityCommunity) {
        this.f944a = activityCommunity;
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
        lc.m1313a(this.f944a, false, "Here you can submit a joke that I will tell to all users of, Utter. Please do be mindful, that many of the application's users are children, who have delicate ears. If you hear a good joke and would like to quickly submit it by voice, just say the command, here's a joke, and I'll start listening. ");
    }
}
