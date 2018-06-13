package com.nuance.nmsp.client.sdk.oem;

import android.util.Log;
import com.nuance.nmdp.speechkit.bj;

public final class C0518b extends bj {
    private String f2985a;

    public C0518b(Class cls) {
        this.f2985a = cls.getSimpleName();
    }

    public final void mo313a(Object obj) {
        Log.v("NMSP_", "[" + this.f2985a + "] " + obj.toString());
    }

    public final void mo314a(Object obj, Throwable th) {
        th.printStackTrace();
        Log.w("NMSP", "[" + this.f2985a + "] " + obj.toString(), th);
    }

    public final boolean mo315a() {
        return Log.isLoggable("NMSP_", 2);
    }

    public final void mo316b(Object obj) {
        Log.d("NMSP_", "[" + this.f2985a + "] " + obj.toString());
    }

    public final boolean mo317b() {
        return Log.isLoggable("NMSP_", 3);
    }

    public final void mo318c(Object obj) {
        Log.i("NMSP", "[" + this.f2985a + "] " + obj.toString());
    }

    public final boolean mo319c() {
        return Log.isLoggable("NMSP", 4);
    }

    public final void mo320d(Object obj) {
        Log.w("NMSP", "[" + this.f2985a + "] " + obj.toString());
    }

    public final boolean mo321d() {
        return Log.isLoggable("NMSP", 5);
    }

    public final void mo322e(Object obj) {
        Log.e("NMSP", "[" + this.f2985a + "] " + obj.toString());
    }

    public final boolean mo323e() {
        return Log.isLoggable("NMSP", 6);
    }

    public final void mo324f() {
    }

    public final void mo325g() {
    }
}
