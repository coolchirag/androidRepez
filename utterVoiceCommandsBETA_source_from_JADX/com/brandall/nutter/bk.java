package com.brandall.nutter;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class bk implements OnCheckedChangeListener {
    final /* synthetic */ ActivityCustomise f969a;

    bk(ActivityCustomise activityCustomise) {
        this.f969a = activityCustomise;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f969a.f675h = "";
        if (z) {
            lc.m1313a(this.f969a, false, "You only need to select this option if I'm going to respond in a different voice, or language, to that of your default.");
            if (ly.m1468e(this.f969a)) {
                Intent intent = new Intent();
                intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
                intent.getStringArrayListExtra("availableVoices");
                intent.setPackage(ServiceTTS.m926e());
                this.f969a.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 0);
                return;
            }
            this.f969a.f673f.setChecked(false);
            lc.m1313a(this.f969a, false, "To configure this feature, you need to enable the application in the main page");
            return;
        }
        this.f969a.f673f.setText(R.string.ve_hint);
        this.f969a.f675h = "";
    }
}
