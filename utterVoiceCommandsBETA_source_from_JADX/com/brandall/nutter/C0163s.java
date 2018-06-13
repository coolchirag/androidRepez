package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class C0163s implements OnClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1825a;
    private final /* synthetic */ boolean f1826b;

    C0163s(ActivityAdvancedSettings activityAdvancedSettings, boolean z) {
        this.f1825a = activityAdvancedSettings;
        this.f1826b = z;
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
        if (this.f1826b) {
            lc.m1313a(this.f1825a, false, "This feature lets you decide what I should do if I don't understand a command. I could perform a web search, send the question to Wolfram Alpha, ask you to repeat the question, apologise, or let you decide at the time. If you are going to decide at the time, you can say, send it to Google, or, ask Wolfram Alpha. Alternatively, you can say the command again, or say cancel. It's up to you.");
        } else {
            lc.m1313a(this.f1825a, false, "This feature lets you decide what I should do if I don't understand a command. I could perform a web search, ask you to repeat the question, apologise, or let you decide at the time. If you are going to decide at the time, you can say, send it to Google, or you can say the command again, or say cancel. It's up to you.");
        }
    }
}
