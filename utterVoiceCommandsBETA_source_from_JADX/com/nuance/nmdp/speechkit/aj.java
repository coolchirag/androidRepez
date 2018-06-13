package com.nuance.nmdp.speechkit;

public final class aj extends C0387s implements ad {
    private final ag f2360e;
    private final bb f2361f = new C03831(this);
    private be f2362g = null;
    private final bd f2363h;
    private final bd f2364i;
    private final bd f2365j;
    private final bd f2366k;
    private final String f2367l;
    private final boolean f2368m;
    private final boolean f2369n;
    private final az f2370o = new C03862(this);

    final class C03831 implements bb {
        final /* synthetic */ aj f2347a;

        final class C03811 implements Runnable {
            private /* synthetic */ C03831 f2344a;

            C03811(C03831 c03831) {
                this.f2344a = c03831;
            }

            public final void run() {
                ((af) this.f2344a.f2347a.a).mo180h();
            }
        }

        C03831(aj ajVar) {
            this.f2347a = ajVar;
        }

        public final void mo193a() {
            ax.m2055a(new C03811(this));
        }

        public final void mo194a(float f) {
            this.f2347a.f2360e.mo226a(f);
        }

        public final void mo195a(final int i) {
            ax.m2055a(new Runnable(this) {
                private /* synthetic */ C03831 f2346b;

                public final void run() {
                    if (i == 4) {
                        C0478j.m2567c(this.f2346b.f2347a, "Recorder error");
                        ((af) this.f2346b.f2347a.a).mo179g();
                        return;
                    }
                    ((af) this.f2346b.f2347a.a).mo181i();
                }
            });
        }
    }

    final class C03862 implements az {
        final /* synthetic */ aj f2350a;

        final class C03841 implements Runnable {
            private /* synthetic */ C03862 f2348a;

            C03841(C03862 c03862) {
                this.f2348a = c03862;
            }

            public final void run() {
                ((af) this.f2348a.f2350a.a).mo183k();
            }
        }

        final class C03852 implements Runnable {
            private /* synthetic */ C03862 f2349a;

            C03852(C03862 c03862) {
                this.f2349a = c03862;
            }

            public final void run() {
                ((af) this.f2349a.f2350a.a).mo184l();
            }
        }

        C03862(aj ajVar) {
            this.f2350a = ajVar;
        }

        public final void mo196a(Object obj) {
            C0478j.m2567c(this.f2350a, "Prompt error");
            ax.m2055a(new C03841(this));
        }

        public final void mo197b(Object obj) {
        }

        public final void mo198c(Object obj) {
            ax.m2055a(new C03852(this));
        }
    }

    public aj(ch chVar, C0496t c0496t, String str, boolean z, boolean z2, String str2, ba baVar, ba baVar2, ba baVar3, ba baVar4, ag agVar, ae aeVar) {
        super(chVar, c0496t, aeVar);
        this.b = str2;
        this.f2360e = agVar;
        this.f2367l = str;
        this.f2368m = z;
        this.f2369n = z2;
        this.f2363h = baVar == null ? null : new bd(baVar, c0496t.m2609a(), this, this.f2370o);
        this.f2364i = baVar2 == null ? null : new bd(baVar2, c0496t.m2609a(), this, this.f2370o);
        this.f2365j = baVar3 == null ? null : new bd(baVar3, c0496t.m2609a(), this, this.f2370o);
        this.f2366k = baVar4 == null ? null : new bd(baVar4, c0496t.m2609a(), this, this.f2370o);
        this.a = new ah(this);
    }

    protected final void mo200a(dp dpVar) {
        dpVar.mo258a("dictation_language", this.b);
        dpVar.mo258a("dictation_type", this.f2367l);
    }

    public final void a_() {
        ((af) this.a).mo182j();
    }

    final boolean m1991h() {
        if (this.f2363h == null) {
            return false;
        }
        this.f2363h.m2101a();
        return true;
    }

    final void m1992i() {
        if (this.f2363h != null) {
            this.f2363h.m2102b();
        }
    }

    final void m1993j() {
        if (this.f2364i != null) {
            this.f2364i.m2101a();
        }
    }

    final void m1994k() {
        if (this.f2365j != null) {
            this.f2365j.m2101a();
        }
    }

    final void m1995l() {
        if (this.f2366k != null) {
            this.f2366k.m2101a();
        }
    }

    public final void m1996m() {
        this.f2362g = new be(this.c, this.f2368m, this.f2369n, this, this.d.m2609a(), this.f2361f);
    }

    public final void m1997n() {
        this.f2362g.m2116a();
    }

    public final void m1998o() {
        this.f2362g.m2117a(m1981b("AUDIO_INFO"));
    }

    public final void m1999p() {
        if (this.f2362g != null) {
            this.f2362g.m2118b();
            this.f2362g = null;
        }
    }
}
