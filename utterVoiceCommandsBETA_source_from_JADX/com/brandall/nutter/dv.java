package com.brandall.nutter;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognition.Result;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer.Listener;
import com.nuance.nmdp.speechkit.SpeechError;
import java.util.ArrayList;
import wei.mark.standout.StandOutWindow;

final class dv implements Listener {
    final /* synthetic */ ActivityRecognitionVoices f1076a;

    dv(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1076a = activityRecognitionVoices;
    }

    public final void onError(Recognizer recognizer, SpeechError speechError) {
        if (recognizer == this.f1076a.f712l) {
            if (this.f1076a.f713m.isShowing()) {
                this.f1076a.dismissDialog(0);
            }
            this.f1076a.f712l = null;
            this.f1076a.f713m.m1322a(false);
            String errorDetail = speechError.getErrorDetail();
            String suggestion = speechError.getSuggestion();
            if (suggestion == null) {
                suggestion = "";
            }
            ls.m1344a("error: " + errorDetail + " : " + suggestion);
        }
    }

    public final void onRecordingBegin(Recognizer recognizer) {
        this.f1076a.f713m.m1321a("Recording...");
        this.f1076a.showDialog(0);
        this.f1076a.f713m.m1324b(true);
        this.f1076a.f713m.m1322a(true);
        this.f1076a.f713m.m1323b("via utter!");
    }

    public final void onRecordingDone(Recognizer recognizer) {
        this.f1076a.f713m.m1321a("Processing...");
        this.f1076a.f713m.m1323b("");
        this.f1076a.f713m.m1322a(false);
        this.f1076a.f713m.m1324b(false);
    }

    public final void onResults(Recognizer recognizer, Recognition recognition) {
        if (this.f1076a.f713m.isShowing()) {
            this.f1076a.dismissDialog(0);
        }
        this.f1076a.f712l = null;
        this.f1076a.f713m.m1322a(false);
        ArrayList arrayList = new ArrayList();
        int resultCount = recognition.getResultCount();
        Object obj = new Result[resultCount];
        for (int i = 0; i < resultCount; i++) {
            obj[i] = recognition.getResult(i);
            arrayList.add(recognition.getResult(i).getText());
        }
        ls.m1344a("results: " + obj);
        arrayList.add("**PLUGIN AVAILABLE SOON!**");
        GlobalV.m823b(arrayList);
        StandOutWindow.m741a(this.f1076a.getApplicationContext(), VoiceResultsWindow.class, 0);
    }
}
