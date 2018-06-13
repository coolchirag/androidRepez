package com.brandall.nutter;

import org.ispeech.SpeechSynthesisEvent;

final class dx extends SpeechSynthesisEvent {
    final /* synthetic */ ActivityRecognitionVoices f1078a;

    dx(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1078a = activityRecognitionVoices;
    }

    public final void onPlayCanceled() {
        ls.m1346c("onPlayCanceled");
    }

    public final void onPlayFailed(Exception exception) {
        ls.m1348e("onPlayFailed");
        exception.printStackTrace();
    }

    public final void onPlayStart() {
        ls.m1346c("onPlayStart");
    }

    public final void onPlayStopped() {
        ls.m1346c("onPlayStopped");
    }

    public final void onPlaySuccessful() {
        ls.m1346c("onPlaySuccessful");
        ActivityRecognitionVoices.m658t(this.f1078a);
    }
}
