package com.att.android.speech;

final class C0124k implements C0116f {
    final /* synthetic */ C0122i f565a;

    C0124k(C0122i c0122i) {
        this.f565a = c0122i;
    }

    public final void mo61a(C0119d c0119d) {
        if (!this.f565a.f544g || c0119d.m399a() == C0120e.USER_CANCELED) {
            if (this.f565a.f549l != null) {
                this.f565a.f549l.mo61a(c0119d);
            }
            if (this.f565a.f550m != null) {
                this.f565a.f550m.mo65a(C0133t.IDLE);
            }
            if (this.f565a.f542e != null) {
                this.f565a.f542e.mo65a(C0133t.IDLE);
            }
            this.f565a.m438d();
            this.f565a.m419k();
        }
    }
}
