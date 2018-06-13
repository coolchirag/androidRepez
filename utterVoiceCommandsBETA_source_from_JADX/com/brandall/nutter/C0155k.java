package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class C0155k implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1587a;

    C0155k(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f1587a = activityAdvancedSettings;
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
        lc.m1313a(this.f1587a, false, "Users have found wave to wake extremely difficult to activate with the default settings, and it appears that the sensitivity of the proximity sensor varies greatly from device to device. With your hand about 1cm above the proximity sensor, wave your hand back and forth in a pendulum action, starting quite quickly, and gradually slowing down, until hopefully I detect your wave and start listening. The four selections vary in sensitivity, with configuration X being the most likely to activate. To conserve your battery, be sure to disable this feature when it's no longer required. You can do this by saying, disable wave.");
    }
}
