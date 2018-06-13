package com.att.android.speech;

final class ae implements Runnable {
    final /* synthetic */ ad f421a;

    ae(ad adVar) {
        this.f421a = adVar;
    }

    public final void run() {
        this.f421a.f413r.mo58b();
        this.f421a.m354e();
        while (this.f421a.f413r != null) {
            if (Thread.interrupted()) {
                return;
            }
        }
    }
}
