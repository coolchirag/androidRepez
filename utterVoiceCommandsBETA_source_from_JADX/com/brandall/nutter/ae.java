package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class ae implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f918a;

    ae(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f918a = activityAdvancedSettings;
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
        lc.m1313a(this.f918a, false, "Please enter a signature I will include in your emails, or save a blank field if you don't require one.");
    }
}
