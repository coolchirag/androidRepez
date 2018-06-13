package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Vocalizer.Listener;

final class C0467g implements Vocalizer {
    private String f2781a;
    private String f2782b;
    private final Listener f2783c;
    private final C0502v f2784d;
    private final aq f2785e = new C04651(this);
    private C0379p f2786f = null;
    private C0466a f2787g = null;
    private SpeechError f2788h = null;
    private final ay f2789i = new ay();

    final class C04651 implements aq {
        private /* synthetic */ C0467g f2775a;

        C04651(C0467g c0467g) {
            this.f2775a = c0467g;
        }

        public final void mo207a(C0379p c0379p) {
            if (this.f2775a.f2788h != null) {
                if (this.f2775a.f2786f == c0379p) {
                    this.f2775a.m2548a(this.f2775a.f2787g.f2777b, this.f2775a.f2787g.f2780e, this.f2775a.f2788h);
                    this.f2775a.f2786f = null;
                    this.f2775a.f2787g = null;
                    this.f2775a.f2788h = null;
                }
            } else if (this.f2775a.f2786f == c0379p) {
                this.f2775a.f2783c.onSpeakingDone(this.f2775a, this.f2775a.f2787g.f2777b, null, this.f2775a.f2787g.f2780e);
                if (this.f2775a.f2789i.m2067c() > 0) {
                    this.f2775a.m2545a((C0466a) this.f2775a.f2789i.m2062a());
                    return;
                }
                this.f2775a.f2786f = null;
                this.f2775a.f2787g = null;
            }
        }

        public final void mo208a(C0379p c0379p, int i, String str, String str2) {
            if (this.f2775a.f2786f == c0379p) {
                this.f2775a.f2788h = new C0447d(i, str, str2);
            }
        }

        public final void mo284b(C0379p c0379p) {
            if (this.f2775a.f2786f == c0379p) {
                this.f2775a.f2783c.onSpeakingBegin(this.f2775a, this.f2775a.f2787g.f2777b, this.f2775a.f2787g.f2780e);
            }
        }
    }

    final class C0466a {
        private final boolean f2776a;
        private final String f2777b;
        private final String f2778c;
        private final String f2779d;
        private final Object f2780e;

        public C0466a(boolean z, String str, String str2, String str3, Object obj) {
            this.f2776a = z;
            this.f2777b = str;
            this.f2778c = str2;
            this.f2779d = str3;
            this.f2780e = obj;
        }
    }

    C0467g(C0502v c0502v, String str, String str2, Listener listener) {
        this.f2781a = str;
        this.f2782b = str2;
        this.f2783c = listener;
        this.f2784d = c0502v;
    }

    private void m2545a(C0466a c0466a) {
        if (this.f2784d.m2649b()) {
            this.f2788h = null;
            this.f2786f = this.f2784d.m2647a(c0466a.f2777b, c0466a.f2778c, c0466a.f2779d, c0466a.f2776a, this.f2785e);
            if (this.f2786f == null) {
                C0478j.m2567c(this, "Unable to create TTS transaction");
                m2548a(c0466a.f2777b, c0466a.f2780e, new C0447d(0, null, null));
                return;
            }
            this.f2787g = c0466a;
            this.f2786f.mo190a();
            return;
        }
        C0478j.m2567c(this, "Unable to create TTS transaction. Transaction runner is invalid.");
        m2548a(c0466a.f2777b, c0466a.f2780e, new C0447d(0, null, null));
    }

    private void m2548a(String str, Object obj, SpeechError speechError) {
        this.f2783c.onSpeakingDone(this, str, speechError, obj);
        int c = this.f2789i.m2067c();
        for (int i = 0; i < c; i++) {
            C0466a c0466a = (C0466a) this.f2789i.m2063a(i);
            this.f2783c.onSpeakingDone(this, c0466a.f2777b, speechError, c0466a.f2780e);
        }
        this.f2789i.m2065b();
    }

    public final void cancel() {
        if (this.f2786f != null) {
            this.f2786f.mo199b();
        }
    }

    public final void setLanguage(String str) {
        this.f2782b = str;
        this.f2781a = null;
    }

    public final void setListener(Listener listener) {
    }

    public final void setVoice(String str) {
        this.f2782b = null;
        this.f2781a = str;
    }

    public final void speakMarkupString(String str, Object obj) {
        C0466a c0466a = new C0466a(true, str, this.f2781a, this.f2782b, obj);
        if (this.f2786f == null) {
            m2545a(c0466a);
        } else {
            this.f2789i.m2064a((Object) c0466a);
        }
    }

    public final void speakString(String str, Object obj) {
        C0466a c0466a = new C0466a(false, str, this.f2781a, this.f2782b, obj);
        if (this.f2786f == null) {
            m2545a(c0466a);
        } else {
            this.f2789i.m2064a((Object) c0466a);
        }
    }
}
