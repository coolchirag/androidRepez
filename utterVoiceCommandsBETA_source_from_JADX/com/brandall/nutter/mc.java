package com.brandall.nutter;

import android.speech.SpeechRecognizer;

final class mc implements Runnable {
    final /* synthetic */ ServiceTTS f1706a;

    mc(ServiceTTS serviceTTS) {
        this.f1706a = serviceTTS;
    }

    public final void run() {
        if (hc.f1269b) {
            ls.m1345b("IDLS Handler");
        }
        ServiceTTS.f869z = false;
        nm.m1501e(ServiceTTS.f849a);
        lt.m1349a(1);
        if (ServiceTTS.f860l) {
            ServiceTTS.m944w();
            return;
        }
        GlobalV.m899w(false);
        ly.m1458a(ServiceTTS.f849a, ServiceTTS.f863r, true, false);
        if (SpeechRecognizer.isRecognitionAvailable(this.f1706a.getApplicationContext())) {
            if (hc.f1269b) {
                ls.m1346c("Recogniser Ok");
            }
            if (ServiceTTS.f866w) {
                if (hc.f1269b) {
                    ls.m1346c("STOPPING recogs: true");
                }
                ServiceTTS.m920b();
                return;
            }
            if (hc.f1269b) {
                ls.m1346c("recogs: false");
            }
            ServiceTTS.f864s = SpeechRecognizer.createSpeechRecognizer(this.f1706a.getApplicationContext());
            ServiceTTS.f864s.setRecognitionListener(new mh(this.f1706a));
            ServiceTTS.m931j();
            return;
        }
        if (hc.f1269b) {
            ls.m1348e("Recognition unavailable");
        }
        ServiceTTS.m921b("Something's wrong. Please check your Google Voice Search installation.");
    }
}
