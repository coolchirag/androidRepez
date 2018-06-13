package com.att.android.speech;

final class ak implements Runnable {
    final /* synthetic */ ad f436a;
    private C0121g f437b = null;
    private C0113h f438c = null;

    public ak(ad adVar, C0113h c0113h, C0121g c0121g) {
        this.f436a = adVar;
        this.f438c = c0113h;
        this.f437b = c0121g;
    }

    public final void run() {
        this.f438c.mo56a(this.f437b);
    }
}
