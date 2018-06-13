package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognizer.Listener;

final class C0444c extends C0443i implements Recognizer {
    private C0398b f2547b;
    private Listener f2548c;
    private final C0464f f2549d;
    private float f2550e = 0.0f;
    private final Object f2551f = new Object();

    final class C04332 implements ag {
        private /* synthetic */ C0444c f2531a;

        C04332(C0444c c0444c) {
            this.f2531a = c0444c;
        }

        public final void mo226a(float f) {
            synchronized (this.f2531a.f2551f) {
                this.f2531a.f2550e = f;
            }
        }
    }

    final class C04383 implements Listener {
        final /* synthetic */ C0444c f2538a;

        final class C04352 implements Runnable {
            private /* synthetic */ C04383 f2534a;

            C04352(C04383 c04383) {
                this.f2534a = c04383;
            }

            public final void run() {
                this.f2534a.f2538a.m2213a().onRecordingBegin(this.f2534a.f2538a);
            }
        }

        final class C04363 implements Runnable {
            private /* synthetic */ C04383 f2535a;

            C04363(C04383 c04383) {
                this.f2535a = c04383;
            }

            public final void run() {
                this.f2535a.f2538a.m2213a().onRecordingDone(this.f2535a.f2538a);
            }
        }

        C04383(C0444c c0444c) {
            this.f2538a = c0444c;
        }

        public final void onError(Recognizer recognizer, final SpeechError speechError) {
            this.f2538a.m2211a(new Runnable(this) {
                private /* synthetic */ C04383 f2533b;

                public final void run() {
                    this.f2533b.f2538a.m2213a().onError(this.f2533b.f2538a, speechError);
                }
            });
        }

        public final void onRecordingBegin(Recognizer recognizer) {
            this.f2538a.m2211a(new C04352(this));
        }

        public final void onRecordingDone(Recognizer recognizer) {
            this.f2538a.m2211a(new C04363(this));
        }

        public final void onResults(Recognizer recognizer, final Recognition recognition) {
            this.f2538a.m2211a(new Runnable(this) {
                private /* synthetic */ C04383 f2537b;

                public final void run() {
                    this.f2537b.f2538a.m2213a().onResults(this.f2537b.f2538a, recognition);
                }
            });
        }
    }

    final class C04405 implements Runnable {
        private /* synthetic */ C0444c f2542a;

        C04405(C0444c c0444c) {
            this.f2542a = c0444c;
        }

        public final void run() {
            this.f2542a.f2547b.start();
        }
    }

    final class C04416 implements Runnable {
        private /* synthetic */ C0444c f2543a;

        C04416(C0444c c0444c) {
            this.f2543a = c0444c;
        }

        public final void run() {
            this.f2543a.f2547b.stopRecording();
        }
    }

    final class C04427 implements Runnable {
        private /* synthetic */ C0444c f2544a;

        C04427(C0444c c0444c) {
            this.f2544a = c0444c;
        }

        public final void run() {
            this.f2544a.f2547b.cancel();
        }
    }

    public C0444c(C0464f c0464f, final String str, final int i, final String str2, Listener listener, Object obj) {
        super(obj);
        this.f2549d = c0464f;
        this.f2548c = listener;
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0444c f2530d;

            public final void run() {
                this.f2530d.f2547b = new C0398b(this.f2530d.f2549d.m2528c(), str, i, str2, new C04332(this.f2530d), new C04383(this.f2530d));
            }
        });
    }

    private Listener m2213a() {
        Listener listener;
        synchronized (this.a) {
            listener = this.f2548c;
        }
        return listener;
    }

    public final void cancel() {
        this.f2549d.m2530e();
        ax.m2055a(new C04427(this));
    }

    public final float getAudioLevel() {
        float f;
        synchronized (this.f2551f) {
            f = this.f2550e;
        }
        return f;
    }

    public final void setListener(Listener listener) {
        C0464f.m2510a((Object) listener, "listener");
        synchronized (this.a) {
            this.f2548c = listener;
        }
    }

    public final void setPrompt(final int i, final Prompt prompt) {
        this.f2549d.m2530e();
        ax.m2055a(new Runnable(this) {
            private /* synthetic */ C0444c f2541c;

            public final void run() {
                this.f2541c.f2547b.setPrompt(i, prompt);
            }
        });
    }

    public final void start() {
        this.f2549d.m2530e();
        ax.m2055a(new C04405(this));
    }

    public final void stopRecording() {
        this.f2549d.m2530e();
        ax.m2055a(new C04416(this));
    }
}
