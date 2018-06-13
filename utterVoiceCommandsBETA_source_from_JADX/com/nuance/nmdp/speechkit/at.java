package com.nuance.nmdp.speechkit;

final class at extends av {
    private boolean f2372c = false;
    private boolean f2373d = false;

    public at(au auVar) {
        super(auVar);
    }

    public final void mo189a() {
        try {
            this.b.m1984d();
            this.b.m1978a("NMDP_TTS_CMD");
            this.b.m1980a(this.b.m2048i(), this.b.m2047h(), this.b.m2051l());
            this.b.m1986f();
            this.b.m2049j();
        } catch (Throwable th) {
            C0478j.m2565a(this, "Error starting PlayingState", th);
            m1902a(4);
        }
    }

    public final void mo203a(dp dpVar) {
        this.f2372c = true;
        if (this.f2373d) {
            this.b.m1977a(new ap(this.b));
        }
    }

    public final void mo185a(String str) {
        m1903a(4, str);
    }

    public final void mo202b() {
        this.b.m2050k();
    }

    public final void mo186b(String str) {
        mo178a(2, null, str);
    }

    public final void mo192d() {
        m1902a(5);
    }

    public final void mo187e() {
        m1903a(4, "createCommandFailed");
    }

    public final void mo188f() {
        m1902a(1);
    }

    public final void mo204g() {
        m1903a(4, "audioError");
    }

    public final void mo205h() {
        m2026j().mo284b(this.b);
    }

    public final void mo206i() {
        this.f2373d = true;
        if (this.f2372c) {
            this.b.m1977a(new ap(this.b));
        }
    }
}
