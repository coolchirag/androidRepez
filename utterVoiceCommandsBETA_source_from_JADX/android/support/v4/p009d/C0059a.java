package android.support.v4.p009d;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class C0059a {
    private static final C0060d f219b;
    private Object f220a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f219b = new C0062c();
        } else {
            f219b = new C0061b();
        }
    }

    public C0059a(Context context) {
        this.f220a = f219b.mo28a(context);
    }

    public final void m175a(int i, int i2) {
        f219b.mo29a(this.f220a, i, i2);
    }

    public final boolean m176a() {
        return f219b.mo30a(this.f220a);
    }

    public final boolean m177a(float f) {
        return f219b.mo31a(this.f220a, f);
    }

    public final boolean m178a(Canvas canvas) {
        return f219b.mo32a(this.f220a, canvas);
    }

    public final void m179b() {
        f219b.mo33b(this.f220a);
    }

    public final boolean m180c() {
        return f219b.mo34c(this.f220a);
    }
}
