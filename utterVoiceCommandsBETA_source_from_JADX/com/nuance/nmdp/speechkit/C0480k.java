package com.nuance.nmdp.speechkit;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public final class C0480k extends Thread {
    private Handler f2819a = null;
    private final ArrayList<C0479a> f2820b = new ArrayList();
    private final Object f2821c;

    final class C0479a {
        public final Runnable f2817a;
        public final int f2818b;

        public C0479a(Runnable runnable, int i) {
            this.f2817a = runnable;
            this.f2818b = i;
        }
    }

    public C0480k(Object obj) {
        this.f2821c = obj;
        start();
    }

    public static void m2576a() {
        Looper.myLooper().quit();
    }

    public final void m2577a(Runnable runnable, int i) {
        if (this.f2819a == null) {
            this.f2820b.add(new C0479a(runnable, i));
        } else if (i > 0) {
            this.f2819a.postDelayed(runnable, (long) i);
        } else {
            this.f2819a.post(runnable);
        }
    }

    public final void run() {
        Looper.prepare();
        synchronized (this.f2821c) {
            this.f2819a = new Handler();
            int size = this.f2820b.size();
            for (int i = 0; i < size; i++) {
                C0479a c0479a = (C0479a) this.f2820b.get(i);
                if (c0479a.f2818b > 0) {
                    this.f2819a.postDelayed(c0479a.f2817a, (long) c0479a.f2818b);
                } else {
                    this.f2819a.post(c0479a.f2817a);
                }
            }
            this.f2820b.clear();
        }
        Looper.loop();
    }
}
