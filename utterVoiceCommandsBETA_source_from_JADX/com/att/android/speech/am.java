package com.att.android.speech;

final class am implements Runnable {
    final /* synthetic */ al f483a;

    am(al alVar) {
        this.f483a = alVar;
    }

    public final void run() {
        if (this.f483a.f469m) {
            this.f483a.m391e();
            this.f483a.f450A.postDelayed(this, this.f483a.f472p);
            return;
        }
        ac.m345a("StreamingAudioRecorder", "Recorder is now stopped");
    }
}
