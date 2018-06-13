package com.nuance.nmdp.speechkit;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.nuance.nmdp.speechkit.ea.C0454a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class dz {
    public static final String f2716a;
    public static final String f2717b;
    public static final int f2718c;
    private static final Constructor<?> f2719d;
    private static final Method f2720e;
    private static final Method f2721f;
    private static final Method f2722g;
    private static final Method f2723h;
    private static final Class<?> f2724i;
    private Object f2725j;
    private C0454a f2726k;

    final class C0453a implements InvocationHandler {
        private /* synthetic */ dz f2715a;

        C0453a(dz dzVar) {
            this.f2715a = dzVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            C0454a a;
            if (method.getName().equals("onServiceConnected")) {
                if (this.f2715a.f2726k != null) {
                    a = this.f2715a.f2726k;
                    if (ea.f2733d.mo319c()) {
                        ea.f2733d.mo318c((Object) "BluetoothHeadsetOEM reflected onServiceConnected()");
                    }
                    synchronized (a.f2727a.f2741l) {
                        if (a.f2727a.f2737h) {
                            a.f2727a.m2480f();
                        } else {
                            a.f2727a.f2738i = true;
                            a.f2727a.f2741l.notify();
                        }
                    }
                }
            } else if (method.getName().equals("onServiceDisconnected") && this.f2715a.f2726k != null) {
                a = this.f2715a.f2726k;
                if (ea.f2733d.mo319c()) {
                    ea.f2733d.mo318c((Object) "BluetoothHeadsetOEM reflected onServiceDisconnected()");
                }
                synchronized (a.f2727a.f2741l) {
                    a.f2727a.m2480f();
                    if (!a.f2727a.f2737h) {
                        a.f2727a.f2738i = true;
                        a.f2727a.f2741l.notify();
                    }
                }
            }
            return null;
        }
    }

    static {
        eb ebVar = new eb();
        Class a = eb.m2485a("android.bluetooth.BluetoothHeadset");
        f2719d = eb.m2488a(a, Context.class, eb.m2485a("android.bluetooth.BluetoothHeadset$ServiceListener"));
        if (eb.m2490b(a, "getState", new Class[0]) == null) {
            eb.m2489a(a, "getState", BluetoothDevice.class);
        }
        f2722g = eb.m2489a(a, "getCurrentHeadset", new Class[0]);
        eb.m2489a(a, "connectHeadset", BluetoothDevice.class);
        if (eb.m2490b(a, "disconnectHeadset", new Class[0]) == null) {
            eb.m2489a(a, "disconnectHeadset", BluetoothDevice.class);
        }
        f2720e = eb.m2489a(a, "startVoiceRecognition", new Class[0]);
        f2721f = eb.m2489a(a, "stopVoiceRecognition", new Class[0]);
        f2723h = eb.m2489a(a, "close", new Class[0]);
        eb.m2489a(a, "getPriority", BluetoothDevice.class);
        eb.m2489a(a, "setPriority", BluetoothDevice.class, Integer.TYPE);
        f2724i = r0;
        eb.m2486a(a, "ACTION_STATE_CHANGED");
        f2716a = (String) eb.m2486a(a, "ACTION_AUDIO_STATE_CHANGED");
        eb.m2486a(a, "EXTRA_STATE");
        f2717b = (String) eb.m2486a(a, "EXTRA_AUDIO_STATE");
        eb.m2486a(a, "STATE_ERROR");
        eb.m2486a(a, "STATE_DISCONNECTED");
        eb.m2486a(a, "STATE_CONNECTING");
        eb.m2486a(a, "STATE_CONNECTED");
        eb.m2486a(a, "AUDIO_STATE_DISCONNECTED");
        f2718c = ((Integer) eb.m2486a(a, "AUDIO_STATE_CONNECTED")).intValue();
        eb.m2486a(a, "PRIORITY_OFF");
        eb.m2487a(a, "PRIORITY_UNDEFINED", Integer.valueOf(-1));
    }

    public dz(Context context, C0454a c0454a) {
        this.f2726k = c0454a;
        Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{f2724i}, new C0453a(this));
        try {
            this.f2725j = f2719d.newInstance(new Object[]{context, newProxyInstance});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final BluetoothDevice m2468a() {
        try {
            if (f2722g != null) {
                return (BluetoothDevice) f2722g.invoke(this.f2725j, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public final boolean m2469b() {
        try {
            return ((Boolean) f2720e.invoke(this.f2725j, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean m2470c() {
        try {
            return ((Boolean) f2721f.invoke(this.f2725j, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void m2471d() {
        try {
            f2723h.invoke(this.f2725j, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
