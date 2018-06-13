package com.nuance.nmdp.speechkit;

import android.content.Context;
import android.os.Vibrator;

public final class C0486n implements ba {
    private boolean f2835a = false;
    private final int f2836b;
    private Vibrator f2837c;

    public C0486n(int i) {
        this.f2836b = i;
        this.f2837c = null;
    }

    public final void mo291a() {
        if (this.f2837c != null) {
            this.f2837c.cancel();
            this.f2837c = null;
        }
    }

    public final void mo292a(Object obj, final az azVar, final Object obj2) {
        this.f2837c = (Vibrator) ((Context) obj).getSystemService("vibrator");
        if (this.f2837c == null) {
            C0478j.m2567c(this, "Unable to get vibrator service");
            azVar.mo196a(obj2);
        } else if (this.f2835a) {
            C0478j.m2567c(this, "Can't start disposed vibration prompt.");
            azVar.mo196a(obj2);
        } else {
            try {
                C0478j.m2564a(this, "Starting vibration (" + this.f2836b + " ms)");
                this.f2837c.vibrate((long) this.f2836b);
                ax.m2056a(new Runnable(this) {
                    private /* synthetic */ C0486n f2834c;

                    public final void run() {
                        C0478j.m2564a(this, "Vibration finished");
                        azVar.mo198c(obj2);
                        this.f2834c.f2837c = null;
                    }
                }, this.f2836b);
            } catch (Throwable th) {
                C0478j.m2565a(this, "Unable to vibrate", th);
                azVar.mo196a(obj2);
            }
        }
    }

    public final boolean mo293b() {
        return this.f2835a;
    }

    public final void mo294c() {
        this.f2835a = true;
        if (this.f2837c != null) {
            this.f2837c.cancel();
            this.f2837c = null;
        }
    }
}
