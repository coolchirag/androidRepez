package com.att.android.speech;

final class C0125l implements ai {
    final /* synthetic */ C0122i f566a;

    C0125l(C0122i c0122i) {
        this.f566a = c0122i;
    }

    public final void mo62a(int i) {
        if (i == 2) {
            if (!(this.f566a.f544g || this.f566a.f539a == -3)) {
                if (this.f566a.f550m != null) {
                    this.f566a.f550m.mo65a(C0133t.PROCESSING);
                }
                if (this.f566a.f542e != null) {
                    this.f566a.f542e.mo65a(C0133t.PROCESSING);
                }
            }
        } else if (i == 1) {
            if (this.f566a.f550m != null) {
                this.f566a.f550m.mo65a(C0133t.RECORDING);
            }
            if (this.f566a.f542e != null) {
                this.f566a.f542e.mo65a(C0133t.RECORDING);
            }
        }
        if (this.f566a.f539a != -3) {
            this.f566a.f539a = i;
        }
    }

    public final void mo63b(int i) {
        if (!(this.f566a.f551n == null || this.f566a.f551n == null)) {
            this.f566a.f551n.mo64a(i);
        }
        if (this.f566a.f543f != null && this.f566a.f543f != null) {
            this.f566a.f543f.mo64a(i);
        }
    }
}
