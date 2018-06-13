package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class ee implements OnClickListener {
    final /* synthetic */ ActivitySettings f1092a;

    ee(ActivitySettings activitySettings) {
        this.f1092a = activitySettings;
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
        lc.m1313a(this.f1092a, false, "Here you can select under what circumstances I will continue to provide vocal responses. You may prefer that I adhere to your device based volume profiles, or perhaps just the media stream. Please tick the boxes you wish, and then I'll know.");
    }
}
