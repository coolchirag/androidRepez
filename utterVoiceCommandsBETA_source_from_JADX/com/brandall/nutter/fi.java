package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class fi implements OnClickListener {
    final /* synthetic */ ActivitySettings f1191a;

    fi(ActivitySettings activitySettings) {
        this.f1191a = activitySettings;
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
        lc.m1313a(this.f1191a, false, "This setting lets you decide whether I should automatically dictate the content of your tweets, texts, emails and notes, before asking if you'd like to proof read the content for yourself. ");
    }
}
