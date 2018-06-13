package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class by implements OnClickListener {
    final /* synthetic */ ActivityCustomise f995a;

    by(ActivityCustomise activityCustomise) {
        this.f995a = activityCustomise;
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
        lc.m1313a(this.f995a, false, "This feature will enable you to replace common words and phrases, that are regularly returned incorrectly from the Google Speech Servers. Please be mindful, that I will replace every occurrence of the words you enter here, prior to searching for a command phrase. So, if you replace the word, call, with the word, balloon, I will forever more ignore instructions to balloon Joe Bloggs on his mobile. The most common use of this feature is to enable you to say a structured command in a way that is more natural to you. For example, if you don’t like saying, search Google, to perform a web search, then in the top box you could put, find me, and in the bottom box the command you want to link this to, which would be, search Google. Next time you say, find me cheap holidays, I will convert this command to, search Google, cheap holidays, and the results will be displayed. If your native language is not English, you can enter commands in your own language in the top box, and put the English equivalent in the bottom. Don’t forget, to do this you’ll need a custom launcher short cut, to start the recognition in your own language. Finally, one more example. If you want me to navigate to your home address from a simple command, in the top box put, drive me home, and in the bottom box, the full command of, navigate to, followed by your address. Ok, for more ways in which you can use this feature, please click on the user guide in the main application page.");
    }
}
