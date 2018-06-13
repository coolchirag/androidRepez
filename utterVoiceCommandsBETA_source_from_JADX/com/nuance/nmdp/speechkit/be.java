package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.ay.C0395a;
import com.nuance.nmdp.speechkit.cb.C0445a;
import java.util.Vector;

public final class be {
    private static final ay f2433a = new ay();
    private final C0395a f2434b;
    private final bb f2435c;
    private bx f2436d;
    private final Object f2437e;
    private final bw f2438f = new C04032(this);
    private boolean f2439g;
    private boolean f2440h;
    private boolean f2441i;
    private boolean f2442j;
    private final Object f2443k;
    private final Object f2444l;

    final class C04032 implements bw {
        private int f2430a = 0;
        private boolean f2431b = false;
        private /* synthetic */ be f2432c;

        C04032(be beVar) {
            this.f2432c = beVar;
        }

        private void m2105a() {
            synchronized (this.f2432c.f2443k) {
                this.f2432c.f2441i = true;
                if (this.f2432c.f2442j) {
                    this.f2432c.f2443k.notify();
                    this.f2432c.f2442j = false;
                }
            }
        }

        public final void mo220a(bx bxVar, String str, Object obj) {
            if (bxVar != this.f2432c.f2436d) {
                C0478j.m2566b(this.f2432c, "Event " + str + " received for invalid recorder");
            } else if (str == "BUFFER_RECORDED") {
                if (obj instanceof Float) {
                    r0 = this.f2432c.f2435c;
                    this.f2432c.f2437e;
                    r0.mo194a(((Float) obj).floatValue());
                }
            } else if (str == "STARTED") {
                this.f2431b = true;
                r0 = this.f2432c.f2435c;
                this.f2432c.f2437e;
                r0.mo193a();
            } else if (str == "STOPPED") {
                C0478j.m2564a(this.f2432c, "Recorder stopped");
                m2105a();
                r0 = this.f2432c.f2435c;
                this.f2432c.f2437e;
                r0.mo195a(this.f2430a);
            } else if (str == "RECORD_ERROR") {
                C0478j.m2567c(this.f2432c, "Recorder error");
                this.f2430a = 4;
                if (!this.f2431b) {
                    m2105a();
                    r0 = this.f2432c.f2435c;
                    this.f2432c.f2437e;
                    r0.mo195a(this.f2430a);
                }
            } else if (str == "END_OF_SPEECH") {
                C0478j.m2564a(this.f2432c, "Recorder event (end of speech)");
                this.f2430a = 2;
            } else if (str == "CAPTURE_TIMEOUT") {
                C0478j.m2564a(this.f2432c, "Recorder event (timeout)");
                this.f2430a = 3;
            }
        }
    }

    public be(ch chVar, boolean z, boolean z2, Object obj, Object obj2, bb bbVar) {
        this.f2435c = bbVar;
        this.f2437e = obj;
        this.f2439g = false;
        this.f2440h = false;
        this.f2442j = false;
        this.f2441i = false;
        this.f2443k = new Object();
        this.f2444l = obj2;
        this.f2434b = f2433a.m2067c() == 0 ? null : f2433a.m2070e().m2069d();
        ay ayVar = new ay();
        if (this.f2434b == null) {
            if (z) {
                ayVar.m2064a((Object) new cb("ep.enable", "TRUE".getBytes(), C0445a.f2559a));
            } else if (z2) {
                ayVar.m2064a((Object) new cb("ep.enable", "TRUE".getBytes(), C0445a.f2559a));
                ayVar.m2064a((Object) new cb("ep.VadLongUtterance", "TRUE".getBytes(), C0445a.f2559a));
            }
        }
        ayVar.m2064a((Object) new cb("USE_ENERGY_LEVEL", "TRUE".getBytes(), C0445a.f2559a));
        ayVar.m2064a((Object) new cb("Android_Context", this.f2444l, C0445a.f2559a));
        try {
            bw bwVar = this.f2438f;
            Vector f = ayVar.m2071f();
            bf bfVar = bf.f2446a;
            if (bwVar == null) {
                throw new NullPointerException("NMSPAudioRecordListener can not be null!");
            } else if (chVar == null) {
                throw new NullPointerException("Manager can not be null!");
            } else {
                this.f2436d = new cg(bwVar, chVar, f, bfVar);
            }
        } catch (Throwable th) {
            C0478j.m2565a(this, "Error creating recorder", th);
            this.f2436d = null;
        }
    }

    public final void m2116a() {
        if (this.f2439g) {
            C0478j.m2567c(this, "Recorder already started");
        } else {
            this.f2439g = true;
            if (this.f2436d != null) {
                try {
                    C0478j.m2564a(this, "Starting recorder");
                    this.f2436d.mo236f();
                    return;
                } catch (Throwable th) {
                    C0478j.m2565a(this, "Error starting recorder", th);
                }
            }
        }
        bb bbVar = this.f2435c;
        Object obj = this.f2437e;
        bbVar.mo195a(4);
    }

    public final void m2117a(final bz bzVar) {
        C0478j.m2564a(this, "Capturing audio from recorder");
        if (this.f2434b != null) {
            this.f2436d.mo231a(new bz(this) {
                final /* synthetic */ be f2428a;

                final class C04011 implements Runnable {
                    private /* synthetic */ C04021 f2427a;

                    C04011(C04021 c04021) {
                        this.f2427a = c04021;
                    }

                    public final void run() {
                        this.f2427a.f2428a.m2118b();
                    }
                }

                public final void mo219a(byte[] bArr, int i, int i2, boolean z) {
                    if (this.f2428a.f2434b == null) {
                        bzVar.mo219a(bArr, i, i2, z);
                    } else if (this.f2428a.f2434b.m2059a()) {
                        byte[] bArr2 = (byte[]) this.f2428a.f2434b.m2060b();
                        boolean z2 = !this.f2428a.f2434b.m2059a();
                        bzVar.mo219a(bArr2, 0, bArr2.length, z2);
                        if (z2) {
                            ax.m2055a(new C04011(this));
                        }
                    }
                    be beVar = this.f2428a;
                    null;
                }
            });
        } else {
            this.f2436d.mo231a(bzVar);
        }
    }

    public final void m2118b() {
        if (this.f2439g && !this.f2440h) {
            this.f2440h = true;
            if (this.f2436d != null) {
                synchronized (this.f2443k) {
                    try {
                        if (!this.f2441i) {
                            C0478j.m2564a(this, "Stopping recorder");
                            this.f2436d.mo237g();
                            this.f2442j = true;
                            while (!this.f2441i) {
                                try {
                                    this.f2443k.wait();
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                    } catch (Throwable th) {
                        C0478j.m2565a(this, "Error stopping recorder", th);
                        this.f2441i = true;
                    }
                }
                return;
            }
            C0478j.m2567c(this, "Can't stop recorder because it wasn't started");
            bb bbVar = this.f2435c;
            Object obj = this.f2437e;
            bbVar.mo195a(4);
        }
    }
}
