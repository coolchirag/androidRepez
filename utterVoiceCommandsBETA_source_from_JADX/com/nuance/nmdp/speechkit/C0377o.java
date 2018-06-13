package com.nuance.nmdp.speechkit;

public abstract class C0377o extends C0376r {
    private final int f2336b;
    private final String f2337c;
    private final String f2338d;
    private final boolean f2339e;

    public C0377o(C0387s c0387s, int i, String str, String str2, boolean z) {
        super(c0387s);
        this.f2336b = i;
        this.f2337c = str;
        this.f2338d = str2;
        this.f2339e = z;
    }

    public void mo189a() {
        C0478j.m2564a(this, "Transaction error code: " + this.f2336b);
        if (this.f2337c != null && this.f2337c.length() > 0) {
            C0478j.m2564a(this, "Transaction error text: " + this.f2337c);
        }
        if (this.f2338d != null && this.f2338d.length() > 0) {
            C0478j.m2564a(this, "Transaction suggestion: " + this.f2338d);
        }
        this.a.m1985e();
        final C0380q c = this.a.m1983c();
        if (this.f2339e) {
            c.mo208a(this.a, this.f2336b, this.f2337c, this.f2338d);
            c.mo207a(this.a);
            return;
        }
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0377o f2839b;

            public final void run() {
                c.mo208a(this.f2839b.a, this.f2839b.f2336b, this.f2839b.f2337c, this.f2839b.f2338d);
                c.mo207a(this.f2839b.a);
            }
        });
    }
}
