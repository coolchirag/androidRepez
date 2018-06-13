package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmdp.speechkit.C0478j;
import com.nuance.nmdp.speechkit.bj;
import com.nuance.nmdp.speechkit.cb;
import java.util.Vector;

public class EndPointerOEM {
    private bj f2980a = C0478j.m2563a(getClass());
    private boolean f2981b = false;
    private C0516b f2982c = new C0516b();

    public final class C0515a {
        public static final C0515a f2967a = new C0515a(1);
        public static final C0515a f2968b = new C0515a(2);
        public static final C0515a f2969c = new C0515a(3);
        private int f2970d = 1;

        private C0515a(int i) {
            this.f2970d = i;
        }

        public static C0515a m2735a(int i) {
            return f2968b.f2970d == i ? f2968b : f2969c.f2970d == i ? f2969c : f2967a;
        }
    }

    final class C0516b {
        int f2971a;
        int f2972b;
        int f2973c;
        int f2974d;
        int f2975e;
        int f2976f;
        int f2977g;
        int f2978h;
        int f2979i;

        private C0516b() {
        }
    }

    private static native int getCurrentEndPointerState();

    private static native void initializeEndPointer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private static native int resetVad();

    public final C0515a m2736a() {
        return this.f2981b ? C0515a.m2735a(getCurrentEndPointerState()) : C0515a.f2967a;
    }

    public final void m2737a(Vector vector) {
        boolean z = false;
        this.f2982c.f2971a = 0;
        this.f2982c.f2972b = 0;
        this.f2982c.f2973c = 50;
        this.f2982c.f2974d = 15;
        this.f2982c.f2975e = 7;
        this.f2982c.f2977g = 50;
        this.f2982c.f2978h = 5;
        this.f2982c.f2979i = 35;
        this.f2982c.f2976f = 0;
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                cb cbVar = (cb) vector.get(i);
                String a = cbVar.m2234a();
                if (a.equals("ep.enable")) {
                    if (new String(cbVar.m2235b()).equalsIgnoreCase("TRUE")) {
                        if (this.f2980a.mo317b()) {
                            this.f2980a.mo316b((Object) "Stop on end of speech is activated.");
                        }
                        this.f2982c.f2971a = 1;
                    }
                } else if (a.equals("ep.VadLongUtterance")) {
                    if (new String(cbVar.m2235b()).equalsIgnoreCase("TRUE")) {
                        this.f2982c.f2972b = 1;
                    }
                } else if (a.equals("ep.VadHistoryLength")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2973c = Integer.parseInt(a);
                } else if (a.equals("ep.VadBeginLength")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2974d = Integer.parseInt(a);
                } else if (a.equals("ep.VadBeginThreshold")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2975e = Integer.parseInt(a);
                } else if (a.equals("ep.VadEndLength")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2977g = Integer.parseInt(a);
                } else if (a.equals("ep.VadEndThreshold")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2978h = Integer.parseInt(a);
                } else if (a.equals("ep.VadInterSpeechLength")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2979i = Integer.parseInt(a);
                } else if (a.equals("ep.VadBeginDelay")) {
                    a = new String(cbVar.m2235b());
                    this.f2982c.f2976f = Integer.parseInt(a);
                }
            }
        }
        if (this.f2982c.f2971a == 1) {
            z = true;
        }
        this.f2981b = z;
        if (this.f2981b) {
            initializeEndPointer(this.f2982c.f2971a, this.f2982c.f2972b, this.f2982c.f2973c, this.f2982c.f2974d, this.f2982c.f2975e, this.f2982c.f2976f, this.f2982c.f2977g, this.f2982c.f2978h, this.f2982c.f2979i);
            m2738b();
        }
    }

    public final void m2738b() {
        if (this.f2981b) {
            resetVad();
        }
    }
}
