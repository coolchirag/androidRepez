package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class fp implements OnClickListener {
    final /* synthetic */ ActivitySettings f1203a;

    fp(ActivitySettings activitySettings) {
        this.f1203a = activitySettings;
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
        lc.m1313a(this.f1203a, false, "Please select your default temperature units of, fahrenheit, or Celsius. This unit will be used across the application.");
    }
}
