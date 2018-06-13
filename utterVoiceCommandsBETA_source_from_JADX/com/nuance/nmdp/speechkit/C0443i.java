package com.nuance.nmdp.speechkit;

import android.os.Handler;

public abstract class C0443i {
    protected final Object f2545a = new Object();
    private final Handler f2546b;

    public C0443i(Object obj) {
        this.f2546b = (Handler) obj;
    }

    protected final void m2211a(Runnable runnable) {
        if (this.f2546b == null) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                C0478j.m2565a(this, "Exception in application callback", th);
                return;
            }
        }
        try {
            if (!this.f2546b.post(runnable)) {
                C0478j.m2567c(this, "Unable to post callback to handler");
            }
        } catch (Throwable th2) {
            C0478j.m2565a(this, "Exception posting callback to handler", th2);
        }
    }
}
