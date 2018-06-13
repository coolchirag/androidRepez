package com.nuance.nmdp.speechkit;

final class ac extends ak {
    private final String[] f2341c;
    private final int[] f2342d;
    private final String f2343e;

    public ac(aj ajVar, String[] strArr, int[] iArr, String str) {
        super(ajVar);
        this.f2341c = strArr;
        this.f2342d = iArr;
        this.f2343e = str;
    }

    public final void mo189a() {
        if (this.f2341c.length > 0) {
            C0478j.m2564a(this, "Recognition result top choice: '" + this.f2341c[0] + "'");
        }
        if (this.f2343e != null && this.f2343e.length() > 0) {
            C0478j.m2564a(this, "Recognition suggestion: " + this.f2343e);
        }
        this.b.m1985e();
        m1926m().mo209a(this.b, this.f2341c, this.f2342d, this.f2343e);
        m1926m().mo207a(this.b);
        this.b.m1994k();
    }
}
