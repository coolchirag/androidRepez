package com.nuance.nmdp.speechkit;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public final class ea {
    public static String f2730a;
    public static String f2731b;
    public static int f2732c;
    private static final bj f2733d = C0478j.m2563a(dy.class);
    private Context f2734e;
    private boolean f2735f;
    private dz f2736g = null;
    private boolean f2737h = false;
    private boolean f2738i = false;
    private Object f2739j = null;
    private final eb f2740k;
    private Object f2741l = new Object();

    public final class C0454a {
        final /* synthetic */ ea f2727a;

        C0454a(ea eaVar) {
            this.f2727a = eaVar;
        }
    }

    final class C0455b implements InvocationHandler {
        private /* synthetic */ ea f2728a;

        C0455b(ea eaVar) {
            this.f2728a = eaVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals("onServiceConnected")) {
                if (ea.f2733d.mo319c()) {
                    ea.f2733d.mo318c((Object) "BluetoothHeadsetOEM native onServiceConnected()");
                }
                synchronized (this.f2728a.f2741l) {
                    if (this.f2728a.f2737h) {
                        this.f2728a.m2474a(objArr[1]);
                    } else {
                        this.f2728a.f2738i = true;
                        this.f2728a.f2739j = objArr[1];
                        this.f2728a.f2741l.notify();
                    }
                }
            } else if (method.getName().equals("onServiceDisconnected")) {
                if (ea.f2733d.mo319c()) {
                    ea.f2733d.mo318c((Object) "BluetoothHeadsetOEM native onServiceDisconnected()");
                }
                synchronized (this.f2728a.f2741l) {
                    if (!this.f2728a.f2737h) {
                        this.f2728a.f2738i = true;
                        this.f2728a.f2741l.notify();
                    }
                }
            }
            return null;
        }
    }

    final class C0456c implements Runnable {
        private /* synthetic */ Object[] f2729a;

        C0456c(Object[] objArr) {
            this.f2729a = objArr;
        }

        public final void run() {
            Looper.prepare();
            this.f2729a[1] = BluetoothAdapter.getDefaultAdapter();
            this.f2729a[0] = new Boolean(true);
            Looper.loop();
        }
    }

    public ea(Context context) {
        this.f2734e = context;
        this.f2740k = new eb();
        if (dw.f2702a <= 10) {
            this.f2735f = true;
            f2730a = dz.f2716a;
            f2731b = dz.f2717b;
            f2732c = dz.f2718c;
            C0454a c0454a = new C0454a(this);
            synchronized (this.f2741l) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f2736g = new dz(this.f2734e, c0454a);
                try {
                    this.f2741l.wait(1000);
                } catch (InterruptedException e) {
                    if (f2733d.mo323e()) {
                        f2733d.mo322e("BluetoothHeadsetOEM reflected mHeadsetSyncObj.wait() threw exception:" + e);
                    }
                }
                if (!this.f2738i) {
                    if (f2733d.mo323e()) {
                        f2733d.mo322e("BluetoothHeadsetOEM reflected service NOT connected in time. Gave up!!!");
                    }
                    this.f2737h = true;
                    m2480f();
                } else if (f2733d.mo319c()) {
                    f2733d.mo318c("BluetoothHeadsetOEM reflected service connection took " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
            }
            return;
        }
        Object obj;
        this.f2735f = false;
        eb ebVar = this.f2740k;
        Class a = eb.m2485a("android.bluetooth.BluetoothHeadset");
        ebVar = this.f2740k;
        f2730a = (String) eb.m2486a(a, "ACTION_AUDIO_STATE_CHANGED");
        ebVar = this.f2740k;
        f2731b = (String) eb.m2486a(a, "EXTRA_STATE");
        ebVar = this.f2740k;
        f2732c = ((Integer) eb.m2486a(a, "STATE_AUDIO_CONNECTED")).intValue();
        if (dw.f2702a == 11 || dw.f2702a == 12 || dw.f2702a == 13) {
            Object[] objArr = new Object[2];
            new Thread(new C0456c(objArr)).start();
            while (objArr[0] == null) {
                try {
                    Thread.sleep(10);
                } catch (Exception e2) {
                }
            }
            obj = (BluetoothAdapter) objArr[1];
        } else {
            obj = BluetoothAdapter.getDefaultAdapter();
        }
        eb ebVar2 = this.f2740k;
        a = eb.m2485a("android.bluetooth.BluetoothProfile$ServiceListener");
        Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{a}, new C0455b(this));
        synchronized (this.f2741l) {
            long currentTimeMillis2 = System.currentTimeMillis();
            eb ebVar3 = this.f2740k;
            Class a2 = eb.m2485a("android.bluetooth.BluetoothProfile");
            eb ebVar4 = this.f2740k;
            Class a3 = eb.m2485a("android.bluetooth.BluetoothAdapter");
            eb ebVar5 = this.f2740k;
            Method a4 = eb.m2489a(a3, "getProfileProxy", Context.class, a, Integer.TYPE);
            try {
                Object[] objArr2 = new Object[3];
                objArr2[0] = context;
                objArr2[1] = newProxyInstance;
                ebVar5 = this.f2740k;
                objArr2[2] = eb.m2486a(a2, "HEADSET");
                a4.invoke(obj, objArr2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                this.f2741l.wait(1000);
            } catch (InterruptedException e4) {
                if (f2733d.mo323e()) {
                    f2733d.mo322e("BluetoothHeadsetOEM native mHeadsetSyncObj.wait() threw exception:" + e4);
                }
            }
            if (!this.f2738i) {
                if (f2733d.mo323e()) {
                    f2733d.mo322e("BluetoothHeadsetOEM native service NOT connected in time. Gave up!!!");
                }
                this.f2737h = true;
            } else if (f2733d.mo319c()) {
                f2733d.mo318c("BluetoothHeadsetOEM native service connection took " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
            }
        }
    }

    private void m2474a(Object obj) {
        eb ebVar = this.f2740k;
        Class a = eb.m2485a("android.bluetooth.BluetoothProfile");
        eb ebVar2 = this.f2740k;
        Class a2 = eb.m2485a("android.bluetooth.BluetoothAdapter");
        eb ebVar3 = this.f2740k;
        Method b = eb.m2490b(a2, "closeProfileProxy", Integer.TYPE, a);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            r3 = new Object[2];
            eb ebVar4 = this.f2740k;
            r3[0] = (Integer) eb.m2486a(a, "HEADSET");
            r3[1] = obj;
            b.invoke(defaultAdapter, r3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m2480f() {
        if (this.f2736g != null) {
            this.f2736g.m2471d();
            this.f2736g = null;
        }
    }

    public final BluetoothDevice m2481a() {
        if (this.f2735f && this.f2736g != null) {
            return this.f2736g.m2468a();
        }
        if (this.f2735f || this.f2739j == null) {
            return null;
        }
        List list;
        eb ebVar = this.f2740k;
        Class a = eb.m2485a("android.bluetooth.BluetoothProfile");
        eb ebVar2 = this.f2740k;
        try {
            list = (List) eb.m2490b(a, "getConnectedDevices", new Class[0]).invoke(this.f2739j, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        return (list == null || list.size() <= 0) ? null : (BluetoothDevice) list.get(0);
    }

    public final boolean m2482b() {
        if (this.f2735f) {
            return this.f2736g == null ? false : this.f2736g.m2469b();
        } else {
            if (!f2733d.mo323e()) {
                return false;
            }
            f2733d.mo322e("BluetoothHeadsetOEM startVoiceRecognition() called on native headset!!!");
            return false;
        }
    }

    public final boolean m2483c() {
        if (this.f2735f) {
            return this.f2736g == null ? false : this.f2736g.m2470c();
        } else {
            if (!f2733d.mo323e()) {
                return false;
            }
            f2733d.mo322e("BluetoothHeadsetOEM stopVoiceRecognition() called on native headset!!!");
            return false;
        }
    }

    public final void m2484d() {
        if (this.f2735f) {
            m2480f();
        } else if (this.f2739j != null) {
            m2474a(this.f2739j);
            this.f2739j = null;
        }
    }
}
