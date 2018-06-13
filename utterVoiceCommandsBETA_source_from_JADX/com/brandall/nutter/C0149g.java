package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class C0149g implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1219a;

    C0149g(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f1219a = activityAdvancedSettings;
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
        lc.m1313a(this.f1219a, false, "Please enter a signature I will include in your text messages, or save a blank field if you don't require one.");
    }
}
