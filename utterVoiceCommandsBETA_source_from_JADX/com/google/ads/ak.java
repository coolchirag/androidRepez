package com.google.ads;

import com.google.ads.util.C0288b;
import com.google.ads.util.C0290d;

final class ak implements Runnable {
    final /* synthetic */ aj f1982a;

    ak(aj ajVar) {
        this.f1982a = ajVar;
    }

    public final void run() {
        if (this.f1982a.m1622h()) {
            C0288b.m1854a(this.f1982a.f1969b);
            try {
                this.f1982a.f1969b.m1598a();
                C0290d.m1862a("Called destroy() for adapter with class: " + this.f1982a.f1969b.getClass().getName());
            } catch (Throwable th) {
                C0290d.m1866b("Error while destroying adapter (" + this.f1982a.m1620f() + "):", th);
            }
        }
    }
}
