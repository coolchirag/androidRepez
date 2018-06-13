package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognizer.Listener;
import org.ispeech.core.HttpRequestParams;
import org.ispeech.core.InternalResources;

final class C0464f {
    private static C0464f f2762a = null;
    private static Object f2763b = new Object();
    private C0502v f2764c = null;
    private final String f2765d;
    private final String f2766e;
    private final int f2767f;
    private boolean f2768g = true;
    private Object f2769h = null;
    private final ay f2770i = new ay();
    private Prompt f2771j = null;
    private Prompt f2772k = null;
    private Prompt f2773l = null;
    private Prompt f2774m = null;

    final class C04582 implements Runnable {
        private /* synthetic */ C0464f f2754a;

        C04582(C0464f c0464f) {
            this.f2754a = c0464f;
        }

        public final void run() {
            this.f2754a.f2764c.m2648a();
            int c = this.f2754a.f2770i.m2067c();
            for (int i = 0; i < c; i++) {
                ((Prompt) this.f2754a.f2770i.m2062a()).m1899a().mo294c();
            }
        }
    }

    final class C04593 implements Runnable {
        C04593() {
        }

        public final void run() {
            ax.m2057b();
        }
    }

    final class C04614 implements Runnable {
        private /* synthetic */ C0464f f2755a;

        final class C04601 implements C0380q {
            C04601() {
            }

            public final void mo207a(C0379p c0379p) {
            }

            public final void mo208a(C0379p c0379p, int i, String str, String str2) {
            }
        }

        C04614(C0464f c0464f) {
            this.f2755a = c0464f;
        }

        public final void run() {
            C0379p a = this.f2755a.f2764c.m2646a(new C04601());
            if (a != null) {
                a.mo190a();
            }
        }
    }

    final class C04636 implements Runnable {
        private /* synthetic */ C0464f f2761a;

        C04636(C0464f c0464f) {
            this.f2761a = c0464f;
        }

        public final void run() {
            this.f2761a.f2764c.m2651d();
        }
    }

    private C0464f(Object obj, String str, String str2, int i, boolean z, byte[] bArr) {
        this.f2765d = str;
        this.f2766e = str2;
        this.f2767f = i;
        final C0496t c0496t = new C0496t(obj, this.f2766e, this.f2767f, z, this.f2765d, bArr);
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0464f f2753b;

            public final void run() {
                this.f2753b.f2764c = new C0502v(c0496t);
            }
        });
    }

    public static C0464f m2507a(Object obj, String str, String str2, int i, boolean z, byte[] bArr) {
        C0464f.m2510a(obj, "appContext");
        C0464f.m2510a((Object) str, "id");
        C0464f.m2512a(str2, "host");
        C0464f.m2510a((Object) bArr, "applicationKey");
        if (i < 0 || i > 65535) {
            C0464f.m2511a(new IllegalArgumentException("port must be between 0 and 65535"));
        }
        synchronized (f2763b) {
            C0478j.m2564a(null, "Initializing SpeechKit");
            if (f2762a == null) {
                ax.m2054a();
            }
            if (f2762a != null) {
                C0464f c0464f = f2762a;
                Object obj2 = (c0464f.f2765d.equals(str) && c0464f.f2766e.equals(str2) && c0464f.f2767f == i) ? 1 : null;
                if (obj2 == null) {
                    C0478j.m2564a(null, "Releasing old SpeechKit before creating new instance");
                    f2762a.m2519k();
                    f2762a = null;
                }
            }
            if (f2762a == null) {
                C0478j.m2564a(null, "Creating fresh SpeechKit instance");
                f2762a = new C0464f(obj, str, str2, i, z, bArr);
            }
        }
        return f2762a;
    }

    static final void m2510a(Object obj, String str) {
        if (obj == null) {
            C0464f.m2511a(new IllegalArgumentException(str + " must not be null"));
        }
    }

    private static void m2511a(RuntimeException runtimeException) {
        C0478j.m2567c(null, runtimeException.getMessage());
        throw runtimeException;
    }

    static final void m2512a(String str, String str2) {
        if (str == null || str.length() == 0) {
            C0464f.m2511a(new IllegalArgumentException(str2 + " must not be null or empty"));
        }
    }

    static Object m2515b() {
        return f2763b;
    }

    static final void m2518f() {
        C0464f.m2511a(new IllegalStateException("SpeechKit instance is released"));
    }

    private void m2519k() {
        this.f2768g = false;
        ax.m2055a(new C04582(this));
    }

    public final Recognizer m2520a(String str, int i, String str2, Listener listener, Object obj) {
        Recognizer c0444c;
        C0464f.m2510a((Object) str, InternalResources.ISPEECH_SCREEN_TYPE);
        C0464f.m2510a((Object) str2, "language");
        C0464f.m2510a((Object) listener, "listener");
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
            c0444c = new C0444c(this, str, i, str2, listener, obj);
            if (this.f2771j != null) {
                c0444c.setPrompt(0, this.f2771j);
            }
            if (this.f2772k != null) {
                c0444c.setPrompt(1, this.f2772k);
            }
            if (this.f2773l != null) {
                c0444c.setPrompt(2, this.f2773l);
            }
            if (this.f2774m != null) {
                c0444c.setPrompt(3, this.f2774m);
            }
        }
        return c0444c;
    }

    public final Vocalizer m2521a(String str, Vocalizer.Listener listener, Object obj) {
        Vocalizer c0477h;
        C0464f.m2510a((Object) str, "language");
        C0464f.m2510a((Object) listener, "listener");
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
            c0477h = new C0477h(this, null, str, listener, obj);
        }
        return c0477h;
    }

    final void m2522a(Prompt prompt) {
        if (this.f2770i.m2068c(prompt)) {
            this.f2770i.m2066b(prompt);
        }
        prompt.m1899a().mo294c();
        if (prompt == this.f2771j) {
            this.f2771j = null;
        }
        if (prompt == this.f2772k) {
            this.f2772k = null;
        }
        if (prompt == this.f2773l) {
            this.f2773l = null;
        }
        if (prompt == this.f2774m) {
            this.f2774m = null;
        }
    }

    public final void m2523a(Prompt prompt, Prompt prompt2, Prompt prompt3, Prompt prompt4) {
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
        }
        final Prompt prompt5 = prompt;
        final Prompt prompt6 = prompt2;
        final Prompt prompt7 = prompt3;
        final Prompt prompt8 = prompt4;
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0464f f2760e;

            public final void run() {
                this.f2760e.f2771j = null;
                this.f2760e.f2772k = null;
                this.f2760e.f2773l = null;
                this.f2760e.f2774m = null;
                if (prompt5 != null) {
                    if (prompt5.m1899a().mo293b()) {
                        C0478j.m2566b(this, "Recording start prompt is invalid");
                    } else {
                        this.f2760e.f2771j = prompt5;
                    }
                }
                if (prompt6 != null) {
                    if (prompt6.m1899a().mo293b()) {
                        C0478j.m2566b(this, "Recording stop prompt is invalid");
                    } else {
                        this.f2760e.f2772k = prompt6;
                    }
                }
                if (prompt7 != null) {
                    if (prompt7.m1899a().mo293b()) {
                        C0478j.m2566b(this, "Result prompt is invalid");
                    } else {
                        this.f2760e.f2773l = prompt7;
                    }
                }
                if (prompt8 == null) {
                    return;
                }
                if (prompt8.m1899a().mo293b()) {
                    C0478j.m2566b(this, "Error prompt is invalid");
                } else {
                    this.f2760e.f2774m = prompt8;
                }
            }
        });
    }

    final void m2524a(Object obj) {
        this.f2769h = obj;
    }

    final boolean m2525a() {
        return this.f2768g;
    }

    public final Vocalizer m2526b(String str, Vocalizer.Listener listener, Object obj) {
        Vocalizer c0477h;
        C0464f.m2510a((Object) str, HttpRequestParams.VOICE);
        C0464f.m2510a((Object) listener, "listener");
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
            c0477h = new C0477h(this, str, null, listener, obj);
        }
        return c0477h;
    }

    public final void m2527b(Prompt prompt) {
        synchronized (f2763b) {
            this.f2770i.m2064a((Object) prompt);
        }
    }

    final C0502v m2528c() {
        return this.f2764c;
    }

    final Object m2529d() {
        return this.f2769h;
    }

    final void m2530e() {
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
        }
    }

    public final void m2531g() {
        synchronized (f2763b) {
            if (this == f2762a) {
                C0478j.m2564a(this, "Releasing SpeechKit instance");
                m2519k();
                f2762a = null;
                ax.m2055a(new C04593());
            } else {
                C0478j.m2566b(this, "SpeechKit instance already released");
            }
        }
    }

    public final void m2532h() {
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
            ax.m2055a(new C04614(this));
        }
    }

    public final String m2533i() {
        String c;
        synchronized (f2763b) {
            if (this.f2764c != null) {
                c = this.f2764c.m2650c();
            } else {
                c = null;
            }
        }
        return c;
    }

    public final void m2534j() {
        synchronized (f2763b) {
            if (!this.f2768g) {
                C0464f.m2518f();
            }
            ax.m2055a(new C04636(this));
        }
    }
}
