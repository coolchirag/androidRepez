package com.nuance.nmdp.speechkit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract class dy {
    private static final bj f2711c = C0478j.m2563a(dy.class);
    protected Context f2712a;
    protected ea f2713b;
    private Object f2714d = new Object();

    final class C0452a extends BroadcastReceiver {
        private /* synthetic */ dy f2710a;

        C0452a(dy dyVar) {
            this.f2710a = dyVar;
        }

        public final void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(ea.f2731b, -1);
            if (dy.f2711c.mo319c()) {
                dy.f2711c.mo318c("BluetoothHeadset BroadcastReceiver " + intExtra);
            }
            synchronized (this.f2710a.f2714d) {
                if (intExtra == ea.f2732c) {
                    if (dy.f2711c.mo319c()) {
                        dy.f2711c.mo318c((Object) "BluetoothHeadset SCO connected. Notify wait lock.");
                    }
                    this.f2710a.f2714d.notify();
                }
            }
        }
    }

    protected dy(Context context) {
        this.f2712a = context;
        this.f2713b = new ea(this.f2712a);
    }

    public static dy m2457a(Context context) {
        int i = dw.f2702a;
        return (i < 8 || dw.f2703b) ? new ed(context) : i < 9 ? new ec(context) : new ee(context);
    }

    public final void m2460a() {
        IntentFilter intentFilter = new IntentFilter(ea.f2730a);
        BroadcastReceiver c0452a = new C0452a(this);
        synchronized (this.f2714d) {
            this.f2712a.registerReceiver(c0452a, intentFilter);
            long currentTimeMillis = System.currentTimeMillis();
            mo280d();
            try {
                this.f2714d.wait(1500);
            } catch (InterruptedException e) {
                if (f2711c.mo323e()) {
                    f2711c.mo322e("BluetoothHeadset mHeadsetScoSyncObj.wait() threw exception:" + e);
                }
            }
            if (f2711c.mo319c()) {
                f2711c.mo318c("BluetoothHeadset " + (System.currentTimeMillis() - currentTimeMillis) + "ms to wait for SCO");
            }
        }
        this.f2712a.unregisterReceiver(c0452a);
    }

    public final boolean m2461b() {
        return this.f2713b.m2481a() != null;
    }

    public final void m2462c() {
        if (this.f2713b != null) {
            try {
                this.f2713b.m2484d();
            } catch (Throwable th) {
            }
            this.f2713b = null;
        }
    }

    public abstract void mo280d();

    public abstract void mo281e();

    public abstract int mo282f();

    public abstract int mo283g();
}
