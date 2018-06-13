package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class gk implements OnClickListener {
    final /* synthetic */ ActivityUserPhrases f1238a;

    gk(ActivityUserPhrases activityUserPhrases) {
        this.f1238a = activityUserPhrases;
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
        lc.m1313a(this.f1238a, false, "If you are finding it tedious to create and edit these phrases, then at the bottom of the customisation section, you can click, export commands. Your phrases will then be exported to the, utter, directory on your external storage. Then you can create phrases faster and more easily in a text editor, or on your P C. When you’re done, just click import, and they will appear. ");
    }
}
