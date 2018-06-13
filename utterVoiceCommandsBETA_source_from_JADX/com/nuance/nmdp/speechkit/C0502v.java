package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.cb.C0445a;

public final class C0502v {
    private C0379p f2874a = null;
    private ch f2875b = m2643e();
    private bh f2876c = this.f2879f.m2623p();
    private bh f2877d = this.f2879f.m2624q();
    private final cj f2878e = new C05014(this);
    private C0496t f2879f;
    private String f2880g = null;
    private boolean f2881h = true;
    private final Object f2882i = new Object();

    final class C05014 implements cj {
        private /* synthetic */ C0502v f2873a;

        C05014(C0502v c0502v) {
            this.f2873a = c0502v;
        }

        public final void mo301a() {
            C0478j.m2566b(this.f2873a, "Connection failed");
        }

        public final void mo302a(String str) {
            synchronized (this.f2873a.f2882i) {
                C0478j.m2564a(this.f2873a, "Connected with session ID " + str);
                this.f2873a.f2880g = str;
            }
        }

        public final void mo303b() {
            C0478j.m2564a(this.f2873a, "Disconnected");
        }
    }

    public C0502v(C0496t c0496t) {
        this.f2879f = c0496t;
        if (this.f2875b == null) {
            this.f2881h = false;
            this.f2879f = null;
        }
    }

    static /* synthetic */ void m2640a(C0502v c0502v) {
        C0478j.m2566b(c0502v, "Restarting NMSP manager");
        c0502v.f2876c = c0502v.f2879f.m2623p();
        c0502v.f2877d = c0502v.f2879f.m2624q();
        c0502v.f2874a = null;
        c0502v.f2875b.b_();
        c0502v.f2875b = c0502v.m2643e();
        if (c0502v.f2875b == null) {
            c0502v.f2879f = null;
            c0502v.f2881h = false;
        }
    }

    static /* synthetic */ void m2641a(C0502v c0502v, C0379p c0379p) {
        if (c0379p == c0502v.f2874a) {
            c0502v.f2874a = null;
        }
    }

    private ch m2643e() {
        try {
            short e = (short) this.f2879f.m2614e();
            String d = this.f2879f.m2613d();
            String r = this.f2879f.m2625r();
            boolean f = this.f2879f.m2615f();
            ay ayVar = new ay();
            ayVar.m2064a((Object) new cb("Android_Context", this.f2879f.m2609a(), C0445a.f2559a));
            if (r != null) {
                ayVar.m2064a((Object) new cb("SocketConnectionSetting", r.getBytes(), C0445a.f2559a));
            }
            if (f) {
                ayVar.m2064a((Object) new cb("SSL_Socket_Enable", "TRUE".getBytes(), C0445a.f2559a));
            }
            return ci.m2268a(d, e, this.f2879f.m2611b(), this.f2879f.m2612c(), this.f2879f.m2622n(), this.f2877d, this.f2876c, ayVar.m2071f(), this.f2878e);
        } catch (Throwable th) {
            C0478j.m2565a(this, "Unable to create NMSP manager", th);
            return null;
        }
    }

    private void m2644f() {
        bh p = this.f2879f.m2623p();
        bh q = this.f2879f.m2624q();
        if (this.f2876c != p || this.f2877d != q) {
            C0478j.m2566b(this, "Supported codecs changed, restarting NMSP manager");
            this.f2874a = null;
            this.f2876c = p;
            this.f2877d = q;
            this.f2875b.b_();
            this.f2875b = m2643e();
            if (this.f2875b == null) {
                this.f2879f = null;
                this.f2881h = false;
            }
        }
    }

    public final ad m2645a(String str, boolean z, boolean z2, String str2, ba baVar, ba baVar2, ba baVar3, ba baVar4, ag agVar, ae aeVar) {
        if (!this.f2881h) {
            return null;
        }
        if (this.f2874a != null) {
            this.f2874a.mo199b();
        }
        m2644f();
        final ae aeVar2 = aeVar;
        Object ajVar = new aj(this.f2875b, this.f2879f, str, z, z2, str2, baVar, baVar2, baVar3, baVar4, agVar, new ae(this) {
            private /* synthetic */ C0502v f2868b;

            public final void mo207a(C0379p c0379p) {
                C0502v.m2641a(this.f2868b, c0379p);
                aeVar2.mo207a(c0379p);
            }

            public final void mo208a(C0379p c0379p, int i, String str, String str2) {
                aeVar2.mo208a(c0379p, i, str, str2);
                if (i == 1) {
                    C0502v.m2640a(this.f2868b);
                }
            }

            public final void mo209a(C0379p c0379p, String[] strArr, int[] iArr, String str) {
                aeVar2.mo209a(c0379p, strArr, iArr, str);
            }

            public final void mo210b(C0379p c0379p) {
                aeVar2.mo210b(c0379p);
            }

            public final void mo211c(C0379p c0379p) {
                aeVar2.mo211c(c0379p);
            }
        });
        this.f2874a = ajVar;
        return ajVar;
    }

    public final C0379p m2646a(final C0380q c0380q) {
        if (!this.f2881h || this.f2874a != null) {
            return null;
        }
        m2644f();
        C0379p c0505y = new C0505y(this.f2875b, this.f2879f, new C0380q(this) {
            private /* synthetic */ C0502v f2872b;

            public final void mo207a(C0379p c0379p) {
                C0502v.m2641a(this.f2872b, c0379p);
                c0380q.mo207a(c0379p);
            }

            public final void mo208a(C0379p c0379p, int i, String str, String str2) {
                c0380q.mo208a(c0379p, i, str, str2);
                if (i == 1) {
                    C0502v.m2640a(this.f2872b);
                }
            }
        });
        this.f2874a = c0505y;
        return c0505y;
    }

    public final C0379p m2647a(String str, String str2, String str3, boolean z, final aq aqVar) {
        if (!this.f2881h) {
            return null;
        }
        if (this.f2874a != null) {
            this.f2874a.mo199b();
        }
        m2644f();
        C0379p auVar = new au(this.f2875b, this.f2879f, str, str2, str3, z, this.f2876c, new aq(this) {
            private /* synthetic */ C0502v f2870b;

            public final void mo207a(C0379p c0379p) {
                C0502v.m2641a(this.f2870b, c0379p);
                aqVar.mo207a(c0379p);
            }

            public final void mo208a(C0379p c0379p, int i, String str, String str2) {
                aqVar.mo208a(c0379p, i, str, str2);
                if (i == 1) {
                    C0502v.m2640a(this.f2870b);
                }
            }

            public final void mo284b(C0379p c0379p) {
                aqVar.mo284b(c0379p);
            }
        });
        this.f2874a = auVar;
        return auVar;
    }

    public final void m2648a() {
        this.f2881h = false;
        if (this.f2874a != null) {
            this.f2874a.mo199b();
            this.f2874a = null;
        }
        if (this.f2875b != null) {
            this.f2875b.b_();
            this.f2875b = null;
        }
        this.f2879f = null;
    }

    public final boolean m2649b() {
        return this.f2881h;
    }

    public final String m2650c() {
        String str;
        synchronized (this.f2882i) {
            str = this.f2880g;
        }
        return str;
    }

    public final void m2651d() {
        if (this.f2874a != null) {
            this.f2874a.mo199b();
            this.f2874a = null;
        }
    }
}
