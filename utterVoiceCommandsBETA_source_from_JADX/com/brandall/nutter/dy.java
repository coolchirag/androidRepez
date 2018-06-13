package com.brandall.nutter;

import java.util.ArrayList;
import org.ispeech.SpeechRecognizerEvent;
import org.ispeech.SpeechResult;
import wei.mark.standout.StandOutWindow;

final class dy extends SpeechRecognizerEvent {
    final /* synthetic */ ActivityRecognitionVoices f1079a;

    dy(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1079a = activityRecognitionVoices;
    }

    public final void onError(Exception exception) {
        ls.m1346c("ERROR: " + exception.getMessage());
        exception.printStackTrace();
    }

    public final void onRecognitionComplete(SpeechResult speechResult) {
        ls.m1346c("Recognition complete");
        if (speechResult != null) {
            ls.m1346c("Text Result:" + speechResult.getText());
            ls.m1346c("Text Conf:" + speechResult.getConfidence());
            ArrayList arrayList = new ArrayList();
            arrayList.add(speechResult.getText());
            arrayList.add("**PLUGIN AVAILABLE SOON!**");
            GlobalV.m823b(arrayList);
            StandOutWindow.m741a(this.f1079a.getApplicationContext(), VoiceResultsWindow.class, 0);
            return;
        }
        ls.m1346c("Result is null...");
    }

    public final void onRecordingCancelled() {
        ls.m1346c("Recording cancelled.");
    }

    public final void onRecordingComplete() {
        ls.m1346c("Recording completed.");
    }
}
