package com.nuance.nmdp.speechkit;

public final class ax extends Thread {
    private static C0480k f2386a = null;
    private static final Object f2387b = new Object();
    private static int f2388c;

    final class C03921 implements Runnable {
        private /* synthetic */ C0480k f2384a;

        C03921(C0480k c0480k) {
            this.f2384a = c0480k;
        }

        public final void run() {
            C0480k c0480k = this.f2384a;
            C0480k.m2576a();
        }
    }

    final class C03932 implements Runnable {
        private /* synthetic */ Runnable f2385a;

        C03932(Runnable runnable) {
            this.f2385a = runnable;
        }

        public final void run() {
            try {
                this.f2385a.run();
            } catch (Throwable th) {
                C0478j.m2565a(ax.f2386a, "Error running job", th);
            }
        }
    }

    public static void m2054a() {
        synchronized (f2387b) {
            if (f2386a == null) {
                f2386a = new C0480k(f2387b);
            }
            f2388c++;
        }
    }

    public static void m2055a(Runnable runnable) {
        m2056a(runnable, 0);
    }

    public static void m2056a(Runnable runnable, int i) {
        synchronized (f2387b) {
            if (f2386a == null) {
                C0478j.m2567c(null, "Job added while JobRunner not active");
            } else {
                f2386a.m2577a(new C03932(runnable), i);
            }
        }
    }

    public static void m2057b() {
        synchronized (f2387b) {
            if (f2386a != null) {
                int i = f2388c - 1;
                f2388c = i;
                if (i < 0) {
                    C0478j.m2566b(f2386a, "JobRunner shutdown more often than initialized");
                    f2388c = 0;
                }
                if (f2388c <= 0) {
                    m2056a(new C03921(f2386a), 0);
                    f2386a = null;
                }
            } else {
                C0478j.m2567c(null, "JobRunner shutdown when not active");
            }
        }
    }
}
