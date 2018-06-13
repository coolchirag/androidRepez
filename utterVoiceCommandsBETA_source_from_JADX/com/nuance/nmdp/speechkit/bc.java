package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.cb.C0445a;
import java.util.Vector;

public final class bc {
    private final bv f2407a = new C03991(this);
    private final az f2408b;
    private final ch f2409c;
    private ad f2410d;
    private final Object f2411e;
    private boolean f2412f;
    private boolean f2413g;
    private boolean f2414h;
    private boolean f2415i;
    private Object f2416j;
    private final Object f2417k;

    final class C03991 implements bv {
        private boolean f2405a = false;
        private /* synthetic */ bc f2406b;

        C03991(bc bcVar) {
            this.f2406b = bcVar;
        }

        private void m2085a() {
            synchronized (this.f2406b.f2416j) {
                this.f2406b.f2414h = true;
                if (this.f2406b.f2415i) {
                    this.f2406b.f2416j.notify();
                    this.f2406b.f2415i = false;
                }
            }
        }

        public final void mo218a(String str) {
            if (str == "BUFFER_PLAYED") {
                if (!this.f2405a) {
                    C0478j.m2564a(this.f2406b, "First audio buffer played");
                    this.f2406b.f2408b.mo197b(this.f2406b.f2411e);
                    this.f2405a = true;
                }
            } else if (str == "BUFFERING") {
            } else {
                if (str == "STARTED") {
                    C0478j.m2564a(this.f2406b, "Audio playback started");
                } else if (str == "STOPPED") {
                    C0478j.m2564a(this.f2406b, "Audio playback stopped");
                    m2085a();
                    this.f2406b.f2408b.mo198c(this.f2406b.f2411e);
                } else if (str == "PLAYBACK_ERROR") {
                    C0478j.m2567c(this.f2406b, "Audio playback error");
                    m2085a();
                    this.f2406b.f2408b.mo196a(this.f2406b.f2411e);
                }
            }
        }
    }

    public bc(ch chVar, Object obj, Object obj2, az azVar, bh bhVar) {
        this.f2408b = azVar;
        this.f2409c = chVar;
        this.f2411e = obj;
        this.f2412f = false;
        this.f2413g = false;
        this.f2414h = false;
        this.f2415i = false;
        this.f2416j = new Object();
        this.f2417k = obj2;
        ay ayVar = new ay();
        ayVar.m2064a((Object) new cb("Android_Context", this.f2417k, C0445a.f2559a));
        try {
            bv bvVar = this.f2407a;
            ch chVar2 = this.f2409c;
            Vector f = ayVar.m2071f();
            bg bgVar = bg.f2450a;
            if (bvVar == null) {
                throw new NullPointerException("NMSPAudioPlaybackListener can not be null!");
            } else if (chVar2 == null) {
                throw new NullPointerException("Manager can not be null!");
            } else {
                this.f2410d = new cf(bvVar, bhVar, chVar2, f, bgVar);
            }
        } catch (Throwable th) {
            C0478j.m2565a(this, "Error creating player", th);
            this.f2410d = null;
        }
    }

    public final void m2093a() {
        if (this.f2412f) {
            C0478j.m2567c(this, "Player already started");
        } else if (this.f2410d != null) {
            this.f2412f = true;
            try {
                C0478j.m2564a(this, "Starting audio player");
                this.f2410d.mo190a();
                return;
            } catch (Throwable th) {
                C0478j.m2565a(this, "Error starting player", th);
            }
        }
        this.f2408b.mo196a(this.f2411e);
    }

    public final void m2094b() {
        if (this.f2412f && !this.f2413g) {
            if (this.f2410d != null) {
                this.f2413g = true;
                synchronized (this.f2416j) {
                    try {
                        if (!this.f2414h) {
                            C0478j.m2564a(this, "Stopping audio player");
                            this.f2410d.a_();
                            this.f2415i = true;
                            while (!this.f2414h) {
                                try {
                                    this.f2416j.wait();
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                    } catch (Throwable th) {
                        C0478j.m2565a(this, "Error stopping player", th);
                        this.f2414h = true;
                    }
                }
                return;
            }
            this.f2408b.mo196a(this.f2411e);
        }
    }

    public final ad m2095c() {
        return this.f2410d;
    }
}
