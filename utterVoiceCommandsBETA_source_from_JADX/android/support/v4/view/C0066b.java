package android.support.v4.view;

final class C0066b implements C0065d {
    C0066b() {
    }

    private static int m237a(int i, int i2, int i3, int i4) {
        Object obj = 1;
        Object obj2 = (i2 & 1) != 0 ? 1 : null;
        int i5 = i3 | i4;
        if ((i5 & 1) == 0) {
            obj = null;
        }
        if (obj2 == null) {
            return obj != null ? i & (i2 ^ -1) : i;
        } else {
            if (obj == null) {
                return i & (i5 ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        }
    }

    private static int m238c(int i) {
        int i2 = (i & 192) != 0 ? i | 1 : i;
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    public final boolean mo37a(int i) {
        return C0066b.m237a(C0066b.m237a(C0066b.m238c(i) & 247, 1, 64, 128), 2, 16, 32) == 1;
    }

    public final boolean mo38b(int i) {
        return (C0066b.m238c(i) & 247) == 0;
    }
}
