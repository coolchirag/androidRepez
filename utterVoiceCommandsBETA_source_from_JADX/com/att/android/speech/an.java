package com.att.android.speech;

final class an extends Thread {
    volatile boolean f484a = false;
    final /* synthetic */ al f485b;
    private byte[] f486c = null;
    private volatile boolean f487d = false;

    an(al alVar) {
        this.f485b = alVar;
    }

    public final void m392a() {
        this.f487d = true;
    }

    public final void run() {
        ac.m345a("StreamingAudioRecorder", "AudioPriorityThread now running");
        while (!this.f487d) {
            if (this.f485b.f455F < this.f485b.f454E && this.f485b.f453D.size() > 0) {
                this.f486c = (byte[]) this.f485b.f453D.get(this.f485b.f455F + 1);
                if (this.f486c != null) {
                    this.f485b.f452C.add(this.f486c);
                    al alVar = this.f485b;
                    alVar.f455F = alVar.f455F + 1;
                }
            }
            if (this.f484a && this.f485b.f455F == this.f485b.f454E) {
                ac.m345a("StreamingAudioRecorder", "Audio counter is " + this.f485b.f454E);
                this.f487d = true;
            }
        }
    }
}
