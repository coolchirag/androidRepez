package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class fh implements OnClickListener {
    final /* synthetic */ ActivitySettings f1190a;

    fh(ActivitySettings activitySettings) {
        this.f1190a = activitySettings;
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
        lc.m1313a(this.f1190a, false, "This setting will tell me how long to wait before assuming you have stopped speaking. The default setting doesn't allow too much time to pause for thought, or a breath, so you may wish to increase it.");
    }
}
