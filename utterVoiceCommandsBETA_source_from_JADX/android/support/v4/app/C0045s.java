package android.support.v4.app;

final class C0045s<E> {
    private static final Object f178a = new Object();
    private boolean f179b;
    private int[] f180c;
    private Object[] f181d;
    private int f182e;

    public C0045s() {
        this((byte) 0);
    }

    private C0045s(byte b) {
        this.f179b = false;
        this.f180c = new int[13];
        this.f181d = new Object[13];
        this.f182e = 0;
    }

    private static int m137a(int[] iArr, int i, int i2) {
        int i3 = -1;
        int i4 = i + 0;
        while (i4 - i3 > 1) {
            int i5 = (i4 + i3) / 2;
            if (iArr[i5] < i2) {
                i3 = i5;
            } else {
                i4 = i5;
            }
        }
        return i4 == i + 0 ? (i + 0) ^ -1 : iArr[i4] != i2 ? i4 ^ -1 : i4;
    }

    private void m138c() {
        int i = this.f182e;
        int[] iArr = this.f180c;
        Object[] objArr = this.f181d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f178a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.f179b = false;
        this.f182e = i2;
    }

    public final int m139a() {
        if (this.f179b) {
            m138c();
        }
        return this.f182e;
    }

    public final E m140a(int i) {
        int a = C0045s.m137a(this.f180c, this.f182e, i);
        return (a < 0 || this.f181d[a] == f178a) ? null : this.f181d[a];
    }

    public final void m141b() {
        int i = this.f182e;
        Object[] objArr = this.f181d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f182e = 0;
        this.f179b = false;
    }

    public final void m142b(int i) {
        int a = C0045s.m137a(this.f180c, this.f182e, i);
        if (a >= 0 && this.f181d[a] != f178a) {
            this.f181d[a] = f178a;
            this.f179b = true;
        }
    }

    public final void m143c(int i) {
        if (this.f181d[i] != f178a) {
            this.f181d[i] = f178a;
            this.f179b = true;
        }
    }

    public final int m144d(int i) {
        if (this.f179b) {
            m138c();
        }
        return this.f180c[i];
    }

    public final E m145e(int i) {
        if (this.f179b) {
            m138c();
        }
        return this.f181d[i];
    }
}
