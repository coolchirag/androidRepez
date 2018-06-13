package com.nuance.nmdp.speechkit;

import org.ispeech.core.HttpRequestParams;

final class al extends aa {
    public al(aj ajVar) {
        super(ajVar);
    }

    public final void mo189a() {
        try {
            this.b.m1984d();
            this.b.m1978a("NMDP_ASR_CMD");
            dp g = this.b.m1987g();
            g.mo260b("start", 0);
            g.mo260b("end", 0);
            g.mo258a(HttpRequestParams.TEXT, "");
            this.b.m1979a("REQUEST_INFO", g);
            this.b.m1996m();
            this.b.m1997n();
        } catch (Throwable th) {
            C0478j.m2565a(this, "Error starting RecordStartingState", th);
            this.b.m1977a(new ab(this.b, 3, null, null, false));
        }
    }

    public final void mo192d() {
        m1902a(5);
    }

    public final void mo179g() {
        m1902a(3);
    }

    public final void mo180h() {
        this.b.m1977a(new ai(this.b));
    }

    public final void mo181i() {
        m1902a(3);
    }

    public final void mo182j() {
        m1902a(3);
    }
}
