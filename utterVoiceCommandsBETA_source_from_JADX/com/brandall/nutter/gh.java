package com.brandall.nutter;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class gh implements OnCheckedChangeListener {
    final /* synthetic */ ActivityUserPhrases f1231a;

    gh(ActivityUserPhrases activityUserPhrases) {
        this.f1231a = activityUserPhrases;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1231a.f739j = "";
        if (z) {
            lc.m1313a(this.f1231a, false, "You only need to select this option if I'm going to respond in a different voice, or language, to that of your default.");
            if (ly.m1468e(this.f1231a)) {
                Intent intent = new Intent();
                intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
                intent.getStringArrayListExtra("availableVoices");
                intent.setPackage(ServiceTTS.m926e());
                this.f1231a.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 0);
                return;
            }
            this.f1231a.f738i.setChecked(false);
            lc.m1313a(this.f1231a, false, "To configure this feature, you need to enable the application in the main page");
            return;
        }
        this.f1231a.f738i.setText(R.string.ve_hint);
        this.f1231a.f739j = "";
    }
}
