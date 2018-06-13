package com.brandall.nutter;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer.Listener;

final class du implements Listener {
    final /* synthetic */ ActivityRecognitionVoices f1075a;

    du(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1075a = activityRecognitionVoices;
    }

    public final void onSpeakingBegin(Vocalizer vocalizer, String str, Object obj) {
        ls.m1346c("onSpeaking Begin");
    }

    public final void onSpeakingDone(Vocalizer vocalizer, String str, SpeechError speechError, Object obj) {
        ls.m1344a("onSpeakingDone");
        ActivityRecognitionVoices.m653o(this.f1075a);
    }
}
