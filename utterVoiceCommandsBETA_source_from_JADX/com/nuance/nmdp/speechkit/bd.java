package com.nuance.nmdp.speechkit;

public final class bd {
    private final ba f2420a;
    private final Object f2421b;
    private final Object f2422c;
    private final az f2423d;
    private final Object f2424e;
    private boolean f2425f = false;
    private boolean f2426g = false;

    public bd(ba baVar, Object obj, Object obj2, final az azVar) {
        this.f2420a = baVar;
        this.f2421b = obj2;
        this.f2422c = obj;
        this.f2424e = new Object();
        this.f2423d = new az(this) {
            private /* synthetic */ bd f2419b;

            public final void mo196a(Object obj) {
                synchronized (this.f2419b.f2424e) {
                    this.f2419b.f2426g = true;
                }
                azVar.mo196a(obj);
            }

            public final void mo197b(Object obj) {
                azVar.mo197b(obj);
            }

            public final void mo198c(Object obj) {
                synchronized (this.f2419b.f2424e) {
                    this.f2419b.f2426g = true;
                }
                azVar.mo198c(obj);
            }
        };
    }

    public final void m2101a() {
        if (this.f2425f) {
            C0478j.m2567c(this, "Prompt already started");
            return;
        }
        this.f2425f = true;
        this.f2420a.mo292a(this.f2422c, this.f2423d, this.f2421b);
    }

    public final void m2102b() {
        if (this.f2425f) {
            synchronized (this.f2424e) {
                if (!this.f2426g) {
                    C0478j.m2564a(this, "Stopping prompt");
                    this.f2426g = true;
                    this.f2420a.mo291a();
                }
            }
        }
    }
}
