package com.nuance.nmdp.speechkit;

final class an extends aa {
    public an(aj ajVar) {
        super(ajVar);
    }

    public final void mo189a() {
        try {
            this.b.m1986f();
        } catch (Throwable e) {
            C0478j.m2565a(this, "Error ending command", e);
            m1902a(3);
        }
    }

    public final void mo203a(dp dpVar) {
        String e;
        int i;
        dv dvVar = null;
        dv g = dpVar.mo265g("transcriptions");
        int a = g.mo275a();
        if (a > 0) {
            String[] strArr = new String[a];
            int[] iArr = new int[a];
            try {
                e = dpVar.mo263e("prompt");
            } catch (Throwable th) {
                C0478j.m2565a(this, "Unable to extract transcriptions from result", th);
            }
            try {
                dv g2 = dpVar.mo265g("confidences");
                try {
                    if (a != g2.mo275a()) {
                        C0478j.m2566b(this, "Size mismatch between transcriptions and confidences");
                    } else {
                        dvVar = g2;
                    }
                } catch (Throwable th2) {
                    dvVar = g2;
                    C0478j.m2566b(this, "Unable to extract confidences from result");
                    i = 0;
                    while (i < a) {
                        strArr[i] = g.mo277c(i).replace('\r', ' ');
                        iArr[i] = dvVar != null ? dvVar.mo276b(i) : 100;
                        i++;
                    }
                    this.b.m1977a(new ac(this.b, strArr, iArr, e));
                    return;
                }
            } catch (Throwable th3) {
                C0478j.m2566b(this, "Unable to extract confidences from result");
                i = 0;
                while (i < a) {
                    strArr[i] = g.mo277c(i).replace('\r', ' ');
                    if (dvVar != null) {
                    }
                    iArr[i] = dvVar != null ? dvVar.mo276b(i) : 100;
                    i++;
                }
                this.b.m1977a(new ac(this.b, strArr, iArr, e));
                return;
            }
            i = 0;
            while (i < a) {
                strArr[i] = g.mo277c(i).replace('\r', ' ');
                if (dvVar != null) {
                }
                iArr[i] = dvVar != null ? dvVar.mo276b(i) : 100;
                i++;
            }
            this.b.m1977a(new ac(this.b, strArr, iArr, e));
            return;
        }
        m1902a(3);
    }

    public final void mo192d() {
        m1902a(5);
    }

    public final void mo179g() {
        m1902a(3);
    }
}
