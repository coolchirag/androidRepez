package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class gq implements OnClickListener {
    final /* synthetic */ ActivityUserWords f1248a;

    gq(ActivityUserWords activityUserWords) {
        this.f1248a = activityUserWords;
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
        lc.m1313a(this.f1248a, false, "For more information on how replacing words can help you say the commands in a more natural way, or using this feature for translation, please click on the user guide from the main page.");
    }
}
