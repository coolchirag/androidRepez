package com.nuance.nmdp.speechkit;

public final class Prompt {
    private final ba f2323a;
    private final C0464f f2324b;

    final class C03711 implements Runnable {
        private /* synthetic */ Prompt f2322a;

        C03711(Prompt prompt) {
            this.f2322a = prompt;
        }

        public final void run() {
            if (this.f2322a.f2324b != null) {
                this.f2322a.f2324b.m2522a(this.f2322a);
            }
        }
    }

    Prompt(ba baVar, C0464f c0464f) {
        this.f2323a = baVar;
        this.f2324b = c0464f;
    }

    public static Prompt vibration(int i) {
        return i <= 0 ? null : new Prompt(new C0486n(i), null);
    }

    final ba m1899a() {
        return this.f2323a;
    }

    public final void release() {
        ax.m2055a(new C03711(this));
    }
}
