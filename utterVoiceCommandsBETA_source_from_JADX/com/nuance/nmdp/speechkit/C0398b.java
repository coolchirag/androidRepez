package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognizer.Listener;

final class C0398b implements Recognizer {
    private final int f2392a;
    private final String f2393b;
    private final Listener f2394c;
    private final String f2395d;
    private final C0502v f2396e;
    private final ag f2397f;
    private final ae f2398g = new C03971(this);
    private ad f2399h;
    private boolean f2400i;
    private Prompt f2401j;
    private Prompt f2402k;
    private Prompt f2403l;
    private Prompt f2404m;

    final class C03971 implements ae {
        private /* synthetic */ C0398b f2391a;

        C03971(C0398b c0398b) {
            this.f2391a = c0398b;
        }

        public final void mo207a(C0379p c0379p) {
            if (this.f2391a.f2399h == c0379p) {
                this.f2391a.f2399h = null;
            }
        }

        public final void mo208a(C0379p c0379p, int i, String str, String str2) {
            if (this.f2391a.f2399h == c0379p) {
                this.f2391a.f2394c.onError(this.f2391a, new C0447d(i, str, str2));
            }
        }

        public final void mo209a(C0379p c0379p, String[] strArr, int[] iArr, String str) {
            if (this.f2391a.f2399h == c0379p) {
                this.f2391a.f2394c.onResults(this.f2391a, new C0375a(strArr, iArr, str));
            }
        }

        public final void mo210b(C0379p c0379p) {
            if (this.f2391a.f2399h == c0379p) {
                this.f2391a.f2394c.onRecordingBegin(this.f2391a);
            }
        }

        public final void mo211c(C0379p c0379p) {
            if (this.f2391a.f2399h == c0379p) {
                this.f2391a.f2394c.onRecordingDone(this.f2391a);
            }
        }
    }

    C0398b(C0502v c0502v, String str, int i, String str2, ag agVar, Listener listener) {
        this.f2392a = i;
        this.f2393b = str2;
        this.f2395d = str;
        this.f2394c = listener;
        this.f2396e = c0502v;
        this.f2397f = agVar;
        this.f2399h = null;
        this.f2400i = false;
        this.f2401j = null;
        this.f2402k = null;
        this.f2403l = null;
        this.f2404m = null;
    }

    public final void cancel() {
        if (this.f2399h != null) {
            this.f2399h.mo199b();
        }
    }

    public final float getAudioLevel() {
        return 0.0f;
    }

    public final void setListener(Listener listener) {
    }

    public final void setPrompt(int i, Prompt prompt) {
        switch (i) {
            case 0:
                this.f2401j = prompt;
                return;
            case 1:
                this.f2402k = prompt;
                return;
            case 2:
                this.f2403l = prompt;
                return;
            case 3:
                this.f2404m = prompt;
                return;
            default:
                return;
        }
    }

    public final void start() {
        if (!this.f2396e.m2649b()) {
            C0478j.m2567c(this, "Unable to create recognition transaction. Transaction runner is invalid.");
            this.f2394c.onError(this, new C0447d(0, null, null));
        } else if (!this.f2400i) {
            this.f2399h = this.f2396e.m2645a(this.f2395d, this.f2392a == 1, this.f2392a == 2, this.f2393b, this.f2401j == null ? null : this.f2401j.m1899a(), this.f2402k == null ? null : this.f2402k.m1899a(), this.f2403l == null ? null : this.f2403l.m1899a(), this.f2404m == null ? null : this.f2404m.m1899a(), this.f2397f, this.f2398g);
            if (this.f2399h == null) {
                C0478j.m2567c(this, "Unable to create recognition transaction");
                this.f2394c.onError(this, new C0447d(0, null, null));
                return;
            }
            this.f2400i = true;
            this.f2399h.mo190a();
        }
    }

    public final void stopRecording() {
        if (this.f2399h != null) {
            this.f2399h.a_();
        }
    }
}
