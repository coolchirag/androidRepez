package android.support.v4.p006a;

import android.support.v4.p008c.C0057a;

public final class C0025a<D> {
    public int f29a;
    public C0026b<D> f30b;
    public boolean f31c;
    public boolean f32d;
    public boolean f33e;
    public boolean f34f;

    public final void m45a(C0026b<D> c0026b) {
        if (this.f30b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f30b != c0026b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f30b = null;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0057a.m173a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f29a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
