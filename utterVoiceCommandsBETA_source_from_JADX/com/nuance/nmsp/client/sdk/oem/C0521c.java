package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmdp.speechkit.C0478j;
import com.nuance.nmdp.speechkit.bj;
import com.nuance.nmdp.speechkit.bk;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.bn;
import java.util.Vector;

public class C0521c implements bk {
    private static final bj f2990a = C0478j.m2563a(C0521c.class);
    private Object f2991b = new Object();
    private Vector f2992c = new Vector();
    private C0528f f2993d = new C0528f();

    public final class C0519a {
        public Thread f2986a;
        public C0417b f2987b;
        public Object f2988c;

        public C0519a(Object obj, C0417b c0417b) {
            this.f2988c = obj;
            this.f2987b = c0417b;
        }
    }

    final class C0520b implements bn {
        private /* synthetic */ C0521c f2989a;

        C0520b(C0521c c0521c) {
            this.f2989a = c0521c;
        }

        public final void run() {
            C0519a c0519a = null;
            try {
                synchronized (this.f2989a.f2991b) {
                    if (!this.f2989a.f2992c.isEmpty()) {
                        c0519a = (C0519a) this.f2989a.f2992c.elementAt(0);
                        this.f2989a.f2992c.removeElementAt(0);
                    }
                }
                if (c0519a == null) {
                    return;
                }
                if (c0519a.f2987b != null) {
                    if (C0521c.f2990a.mo315a()) {
                        C0521c.f2990a.mo313a((Object) "Executing Message");
                    }
                    c0519a.f2987b.mo225a(c0519a.f2988c, c0519a.f2986a);
                    if (C0521c.f2990a.mo315a()) {
                        C0521c.f2990a.mo313a((Object) "Done Executing Message");
                    }
                } else if (C0521c.f2990a.mo323e()) {
                    C0521c.f2990a.mo322e("MessageSystemOEM.send() msg.msgHandler is null");
                }
            } catch (Exception e) {
                if (C0521c.f2990a.mo323e()) {
                    C0521c.f2990a.mo322e("MessageSystemOEM.send() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    public final void mo326a(bn bnVar, long j) {
        Object obj = null;
        synchronized (this.f2991b) {
            if (this.f2993d != null) {
                this.f2993d.m2781a(bnVar, j);
            } else {
                obj = 1;
            }
        }
        if (obj != null && f2990a.mo317b()) {
            f2990a.mo316b((Object) "MessageSystemOEM.scheduleTask() timer already stopped!");
        }
    }

    public final void mo327a(Object obj, C0417b c0417b, Object obj2) {
        C0519a c0519a = new C0519a(obj, c0417b);
        c0519a.f2986a = (Thread) obj2;
        bn c0520b = new C0520b(this);
        Object obj3 = null;
        synchronized (this.f2991b) {
            if (this.f2993d != null) {
                this.f2992c.addElement(c0519a);
                mo326a(c0520b, 0);
            } else {
                obj3 = 1;
            }
        }
        if (obj3 != null && f2990a.mo317b()) {
            f2990a.mo316b((Object) "MessageSystemOEM.send() timer already stopped!");
        }
    }

    public final boolean mo328a(bn bnVar) {
        boolean a;
        Object obj = null;
        synchronized (this.f2991b) {
            if (this.f2993d != null) {
                a = this.f2993d.m2782a(bnVar);
            } else {
                int i = 1;
                a = false;
            }
        }
        if (obj != null && f2990a.mo317b()) {
            f2990a.mo316b((Object) "MessageSystemOEM.cancelTask() timer already stopped!");
        }
        return a;
    }

    public final Object[] mo329a() {
        return new Object[]{Thread.currentThread()};
    }

    public final Object mo330b() {
        return Thread.currentThread();
    }

    public final void mo331c() {
        Object obj = null;
        synchronized (this.f2991b) {
            if (this.f2993d != null) {
                this.f2993d.m2780a();
                this.f2993d = null;
                this.f2992c.removeAllElements();
                this.f2992c = null;
            } else {
                obj = 1;
            }
        }
        if (obj != null && f2990a.mo317b()) {
            f2990a.mo316b((Object) "MessageSystemOEM.stop() timer already stopped!");
        }
    }
}
