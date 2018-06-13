package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmdp.speechkit.C0478j;
import com.nuance.nmdp.speechkit.bi.C0378j;
import com.nuance.nmdp.speechkit.bj;
import com.nuance.nmdp.speechkit.bn;
import java.util.Vector;

public class C0528f implements C0378j, Runnable {
    private static final bj f3023a = C0478j.m2563a(C0528f.class);
    private Vector f3024b = new Vector();
    private Object f3025c = new Object();
    private boolean f3026d = false;

    final class C0527a {
        public long f3021a;
        public bn f3022b;

        public C0527a(bn bnVar, long j) {
            this.f3021a = j;
            this.f3022b = bnVar;
        }
    }

    public C0528f() {
        new Thread(this).start();
    }

    public final void m2780a() {
        this.f3026d = true;
        synchronized (this.f3025c) {
            this.f3025c.notify();
        }
    }

    public final void m2781a(bn bnVar, long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (f3023a.mo317b()) {
            f3023a.mo316b("Scheduling TimerSystemTask for time: " + currentTimeMillis);
        }
        C0527a c0527a = new C0527a(bnVar, currentTimeMillis);
        synchronized (this.f3025c) {
            int size = this.f3024b.size();
            for (int i = 0; i < size; i++) {
                if (((C0527a) this.f3024b.elementAt(i)).f3021a > c0527a.f3021a) {
                    if (f3023a.mo315a()) {
                        f3023a.mo313a("Inserting new timer task at index " + i);
                    }
                    this.f3024b.insertElementAt(c0527a, i);
                    this.f3025c.notify();
                    return;
                }
            }
            if (f3023a.mo315a()) {
                f3023a.mo313a((Object) "Inserting new timer task at index 0");
            }
            this.f3024b.addElement(c0527a);
            this.f3025c.notify();
        }
    }

    public final boolean m2782a(bn bnVar) {
        boolean z;
        if (f3023a.mo317b()) {
            f3023a.mo316b((Object) "Canceling task");
        }
        synchronized (this.f3025c) {
            for (int i = 0; i < this.f3024b.size(); i++) {
                if (((C0527a) this.f3024b.elementAt(i)).f3022b == bnVar) {
                    z = true;
                    this.f3024b.removeElementAt(i);
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void run() {
        while (!this.f3026d) {
            synchronized (this.f3025c) {
                if (this.f3024b.size() > 0) {
                    C0527a c0527a = (C0527a) this.f3024b.elementAt(0);
                    if (c0527a.f3021a < System.currentTimeMillis()) {
                        this.f3024b.removeElementAt(0);
                        if (f3023a.mo315a()) {
                            f3023a.mo313a((Object) "Removed a task from the queue");
                        }
                        if (c0527a != null) {
                            try {
                                if (f3023a.mo317b()) {
                                    f3023a.mo316b((Object) "Executing timer task");
                                }
                                c0527a.f3022b.run();
                                if (f3023a.mo317b()) {
                                    f3023a.mo316b((Object) "Done executing timer task");
                                }
                            } catch (Exception e) {
                                f3023a.mo322e("TimerSystemJ2me caught an exception:" + e);
                            }
                        } else {
                            Thread.sleep(20);
                        }
                    } else {
                        try {
                            long currentTimeMillis = c0527a.f3021a - System.currentTimeMillis();
                            if (currentTimeMillis > 0) {
                                if (f3023a.mo315a()) {
                                    f3023a.mo313a("Waiting on condition for " + currentTimeMillis);
                                }
                                this.f3025c.wait(currentTimeMillis);
                            }
                        } catch (Throwable e2) {
                            if (f3023a.mo321d()) {
                                f3023a.mo314a("Waiting on syncObj threw an exception: ", e2);
                            }
                        }
                    }
                } else {
                    try {
                        if (f3023a.mo315a()) {
                            f3023a.mo313a((Object) "No task in queue. Waiting.");
                        }
                        this.f3025c.wait();
                    } catch (Throwable e22) {
                        if (f3023a.mo321d()) {
                            f3023a.mo314a("Waiting on syncObj threw an exception: ", e22);
                        }
                    }
                }
            }
        }
    }
}
