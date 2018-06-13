package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class bg implements OnClickListener {
    final /* synthetic */ ActivityCustomise f965a;

    bg(ActivityCustomise activityCustomise) {
        this.f965a = activityCustomise;
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
        lc.m1313a(this.f965a, false, "Here you can configure how I address you when you first activate me. If you would prefer that I skipped the niceties, and started to listen immediately, then just press create, leaving the field blank. Soon you'll be able to enter multiple custom introductions, and I'll pick one at random to greet you with. To reset to the standard introductions, just say, call me, followed by your name. ");
    }
}
