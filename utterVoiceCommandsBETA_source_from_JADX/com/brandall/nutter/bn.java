package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class bn implements OnClickListener {
    final /* synthetic */ ActivityCustomise f977a;

    bn(ActivityCustomise activityCustomise) {
        this.f977a = activityCustomise;
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
        lc.m1313a(this.f977a, false, "Using custom phrases, you can create entire conversations to baffle your friends, or responses that I'll give when you ask a question. The example shows you asking, who is the fairest of them all? And my response of, why you of course, followed by a giggle. Please see the user guide for details of how I can use any sound effect in my responses. If you want to create a conversation, you’ll need to tick the start listening box. When I’ve finished my response, I'll start listening again, and you could then say another custom phrase, which I will in turn answer. If your native language is not English, you can enter these phrases in your own language and tick the non English voice box. For me to detect a phrase in a different language to English, you’ll need to start the initial voice recognition using a custom launcher configuration. You can do this from the main page, or alternatively from your launcher, with a widget or a shortcut. Please refer to, translation, in the user guide for more information. Have fun!");
    }
}
