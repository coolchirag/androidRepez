package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class aa implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f911a;

    aa(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f911a = activityAdvancedSettings;
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
        lc.m1313a(this.f911a, false, "Here you can set the sensitivity of the shake to wake feature. To start with, try and set this as low as possible, as it will minimise the possibility of it activating when it's not supposed to in your pocket. Please be aware, monitoring your sensors will naturally increase the battery consumption.");
    }
}
