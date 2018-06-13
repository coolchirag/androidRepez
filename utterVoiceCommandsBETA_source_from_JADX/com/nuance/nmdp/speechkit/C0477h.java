package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Vocalizer.Listener;
import org.ispeech.core.HttpRequestParams;

final class C0477h extends C0443i implements Vocalizer {
    private C0467g f2812b;
    private Listener f2813c;
    private final C0464f f2814d;

    final class C04712 implements Listener {
        final /* synthetic */ C0477h f2800a;

        C04712(C0477h c0477h) {
            this.f2800a = c0477h;
        }

        public final void onSpeakingBegin(Vocalizer vocalizer, final String str, final Object obj) {
            this.f2800a.m2211a(new Runnable(this) {
                private /* synthetic */ C04712 f2795c;

                public final void run() {
                    this.f2795c.f2800a.m2555a().onSpeakingBegin(this.f2795c.f2800a, str, obj);
                }
            });
        }

        public final void onSpeakingDone(Vocalizer vocalizer, final String str, final SpeechError speechError, final Object obj) {
            this.f2800a.m2211a(new Runnable(this) {
                private /* synthetic */ C04712 f2799d;

                public final void run() {
                    this.f2799d.f2800a.m2555a().onSpeakingDone(this.f2799d.f2800a, str, speechError, obj);
                }
            });
        }
    }

    final class C04723 implements Runnable {
        private /* synthetic */ C0477h f2801a;

        C04723(C0477h c0477h) {
            this.f2801a = c0477h;
        }

        public final void run() {
            this.f2801a.f2812b.cancel();
        }
    }

    public C0477h(C0464f c0464f, final String str, final String str2, Listener listener, Object obj) {
        super(obj);
        this.f2813c = listener;
        this.f2814d = c0464f;
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0477h f2792c;

            public final void run() {
                this.f2792c.f2812b = new C0467g(this.f2792c.f2814d.m2528c(), str, str2, new C04712(this.f2792c));
            }
        });
    }

    private Listener m2555a() {
        Listener listener;
        synchronized (this.a) {
            listener = this.f2813c;
        }
        return listener;
    }

    public final void cancel() {
        this.f2814d.m2530e();
        ax.m2055a(new C04723(this));
    }

    public final void setLanguage(final String str) {
        this.f2814d.m2530e();
        C0464f.m2512a(str, "language");
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0477h f2809b;

            public final void run() {
                this.f2809b.f2812b.setLanguage(str);
            }
        });
    }

    public final void setListener(Listener listener) {
        C0464f.m2510a((Object) listener, "listener");
        synchronized (this.a) {
            this.f2813c = listener;
        }
    }

    public final void setVoice(final String str) {
        this.f2814d.m2530e();
        C0464f.m2512a(str, HttpRequestParams.VOICE);
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0477h f2811b;

            public final void run() {
                this.f2811b.f2812b.setVoice(str);
            }
        });
    }

    public final void speakMarkupString(final String str, final Object obj) {
        this.f2814d.m2530e();
        C0464f.m2510a((Object) str, HttpRequestParams.TEXT);
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0477h f2804c;

            public final void run() {
                this.f2804c.f2812b.speakMarkupString(str, obj);
            }
        });
    }

    public final void speakString(final String str, final Object obj) {
        this.f2814d.m2530e();
        C0464f.m2510a((Object) str, HttpRequestParams.TEXT);
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0477h f2807c;

            public final void run() {
                this.f2807c.f2812b.speakString(str, obj);
            }
        });
    }
}
