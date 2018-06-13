package com.nuance.nmdp.speechkit;

import org.ispeech.core.HttpRequestParams;

public final class au extends C0387s implements C0379p {
    private final String f2378e;
    private final String f2379f;
    private final String f2380g;
    private final az f2381h;
    private bc f2382i;

    final class C03911 implements az {
        final /* synthetic */ au f2377a;

        final class C03881 implements Runnable {
            private /* synthetic */ C03911 f2374a;

            C03881(C03911 c03911) {
                this.f2374a = c03911;
            }

            public final void run() {
                ((ar) this.f2374a.f2377a.a).mo204g();
            }
        }

        final class C03892 implements Runnable {
            private /* synthetic */ C03911 f2375a;

            C03892(C03911 c03911) {
                this.f2375a = c03911;
            }

            public final void run() {
                ((ar) this.f2375a.f2377a.a).mo205h();
            }
        }

        final class C03903 implements Runnable {
            private /* synthetic */ C03911 f2376a;

            C03903(C03911 c03911) {
                this.f2376a = c03911;
            }

            public final void run() {
                ((ar) this.f2376a.f2377a.a).mo206i();
            }
        }

        C03911(au auVar) {
            this.f2377a = auVar;
        }

        public final void mo196a(Object obj) {
            C0478j.m2567c(this.f2377a, "Player error");
            ax.m2055a(new C03881(this));
        }

        public final void mo197b(Object obj) {
            ax.m2055a(new C03892(this));
        }

        public final void mo198c(Object obj) {
            ax.m2055a(new C03903(this));
        }
    }

    public au(ch chVar, C0496t c0496t, String str, String str2, String str3, boolean z, bh bhVar, aq aqVar) {
        super(chVar, c0496t, aqVar);
        if (str3 != null) {
            this.b = str3;
        }
        this.f2379f = str;
        this.f2380g = z ? "ssml" : HttpRequestParams.TEXT;
        this.f2378e = str2;
        this.f2381h = new C03911(this);
        this.f2382i = new bc(this.c, this, c0496t.m2609a(), this.f2381h, bhVar);
        this.a = new as(this);
    }

    protected final void mo200a(dp dpVar) {
        if (this.f2378e != null) {
            dpVar.mo258a("tts_voice", this.f2378e);
        } else {
            dpVar.mo258a("tts_language", this.b);
        }
    }

    public final String m2047h() {
        return this.f2379f;
    }

    public final String m2048i() {
        return this.f2380g;
    }

    public final void m2049j() {
        this.f2382i.m2093a();
    }

    public final void m2050k() {
        this.f2382i.m2094b();
    }

    public final bz m2051l() {
        return this.f2382i.m2095c();
    }
}
