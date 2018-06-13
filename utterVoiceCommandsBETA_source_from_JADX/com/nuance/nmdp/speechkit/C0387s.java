package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bi.C0378j;

public abstract class C0387s implements C0379p {
    protected C0376r f2351a;
    protected String f2352b;
    protected final ch f2353c;
    protected final C0496t f2354d;
    private C0380q f2355e;
    private dq f2356f = null;
    private C0450do f2357g = null;
    private final cm f2358h = new C04901(this);
    private final ds f2359i = new C04952(this);

    final class C04901 implements cm {
        final /* synthetic */ C0387s f2843a;

        final class C04892 implements Runnable {
            private /* synthetic */ C04901 f2842a;

            C04892(C04901 c04901) {
                this.f2842a = c04901;
            }

            public final void run() {
                this.f2842a.f2843a.f2351a.mo187e();
            }
        }

        C04901(C0387s c0387s) {
            this.f2843a = c0387s;
        }

        public final void mo295a() {
            C0478j.m2567c(this.f2843a, "PDX Create Command Failed");
            ax.m2055a(new C04892(this));
        }

        public final void mo296a(final String str) {
            ax.m2055a(new Runnable(this) {
                private /* synthetic */ C04901 f2841b;

                public final void run() {
                    C0376r c0376r = this.f2841b.f2843a.f2351a;
                    String str = str;
                }
            });
        }
    }

    final class C04952 implements ds {
        final /* synthetic */ C0387s f2853a;

        C04952(C0387s c0387s) {
            this.f2853a = c0387s;
        }

        public final void mo297a(final dp dpVar) {
            C0478j.m2564a(this.f2853a, "PDX Query Result Returned");
            ax.m2055a(new Runnable(this) {
                private /* synthetic */ C04952 f2849b;

                public final void run() {
                    this.f2849b.f2853a.f2351a.mo203a(dpVar);
                }
            });
        }

        public final void mo298a(final dt dtVar) {
            C0478j.m2564a(this.f2853a, "PDX Query Error Returned: " + dtVar.mo270g() + "(" + dtVar.mo271h() + ")");
            ax.m2055a(new Runnable(this) {
                private /* synthetic */ C04952 f2847b;

                public final void run() {
                    C0376r c0376r = this.f2847b.f2853a.f2351a;
                    dtVar.mo270g();
                    c0376r.mo185a(dtVar.mo271h());
                }
            });
        }

        public final void mo299a(du duVar) {
            C0478j.m2564a(this.f2853a, "PDX Query Retry Returned: " + duVar.mo273h() + "(" + duVar.mo272g() + ")");
            final String i = duVar.mo274i();
            final String g = duVar.mo272g();
            ax.m2055a(new Runnable(this) {
                private /* synthetic */ C04952 f2852c;

                public final void run() {
                    C0376r c0376r = this.f2852c.f2853a.f2351a;
                    String str = i;
                    String str2 = g;
                    c0376r.mo186b(str);
                }
            });
        }

        public final void mo300a(final short s) {
            switch (s) {
                case (short) 1:
                case (short) 3:
                    C0478j.m2564a(this.f2853a, "PDX Command Event: " + s);
                    ax.m2055a(new Runnable(this) {
                        private /* synthetic */ C04952 f2845b;

                        public final void run() {
                            C0376r c0376r = this.f2845b.f2853a.f2351a;
                            short s = s;
                            c0376r.mo188f();
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    public C0387s(ch chVar, C0496t c0496t, C0380q c0380q) {
        this.f2355e = c0380q;
        this.f2353c = chVar;
        this.f2354d = c0496t;
        this.f2352b = c0496t.m2617h();
    }

    private void m1974a(C0378j c0378j) {
        try {
            this.f2357g.mo279a(c0378j);
        } catch (Throwable e) {
            throw new C0497u("Error sending parameter (TransactionAlreadyFinishedException)", e);
        } catch (Throwable e2) {
            throw new C0497u("Error sending parameter (TransactionExpiredException)", e2);
        }
    }

    public final void mo190a() {
        this.f2351a.mo191c();
    }

    protected void mo200a(dp dpVar) {
    }

    public final void m1977a(C0376r c0376r) {
        this.f2351a.mo202b();
        this.f2351a = c0376r;
        this.f2351a.mo189a();
    }

    public final void m1978a(String str) {
        if (this.f2356f != null) {
            dp g = m1987g();
            String g2 = this.f2354d.m2616g();
            String i = this.f2354d.m2618i();
            String j = this.f2354d.m2619j();
            String k = this.f2354d.m2620k();
            String m = this.f2354d.m2621m();
            C0496t c0496t = this.f2354d;
            String o = C0496t.m2608o();
            C0496t c0496t2 = this.f2354d;
            String l = C0496t.m2607l();
            String b = this.f2354d.m2611b();
            g.mo258a("ui_language", this.f2352b);
            g.mo258a("phone_submodel", i);
            g.mo258a("phone_OS", j);
            g.mo258a("locale", k);
            g.mo258a("nmdp_version", l);
            g.mo258a("nmaid", b);
            g.mo258a("network_type", m);
            byte[] bArr = new byte[100];
            try {
                bArr = this.f2354d.m2610a(bArr);
            } catch (Throwable th) {
            }
            g.mo259a("app_transaction_id", bArr);
            mo200a(g);
            this.f2357g = this.f2356f.mo254a(this.f2359i, str, o, this.f2352b, g2, i, g);
        }
    }

    public final void m1979a(String str, dp dpVar) {
        m1974a(this.f2356f.mo251a(str, dpVar));
    }

    public final void m1980a(String str, String str2, bz bzVar) {
        dp g = m1987g();
        g.mo258a("tts_input", str2);
        g.mo258a("tts_type", str);
        m1974a(this.f2356f.mo252a("TEXT_TO_READ", g, bzVar));
    }

    public final bz m1981b(String str) {
        C0378j a = this.f2356f.mo253a(str);
        m1974a(a);
        return a;
    }

    public final void mo199b() {
        this.f2351a.mo192d();
    }

    public final C0380q m1983c() {
        return this.f2355e;
    }

    public final void m1984d() {
        ch chVar = this.f2353c;
        cm cmVar = this.f2358h;
        this.f2354d.m2611b();
        this.f2356f = dr.m2452a(chVar, cmVar);
    }

    public final void m1985e() {
        if (this.f2356f != null) {
            try {
                this.f2356f.mo241a();
            } catch (cl e) {
            }
            this.f2356f = null;
        }
    }

    public final void m1986f() {
        try {
            this.f2357g.mo278a();
        } catch (Throwable e) {
            throw new C0497u("Error ending PDX command (TransactionAlreadyFinishedException)", e);
        } catch (Throwable e2) {
            throw new C0497u("Error ending PDX command (TransactionExpiredException)", e2);
        }
    }

    public final dp m1987g() {
        return this.f2356f.mo256g();
    }
}
