package com.nuance.nmdp.speechkit;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Calendar;

public final class C0496t {
    private static int f2854k = 420611619;
    private static int f2855l = 418947094;
    private static int f2856m = 1434515842;
    private final String f2857a;
    private final byte[] f2858b;
    private final String f2859c;
    private final int f2860d;
    private final boolean f2861e;
    private final Object f2862f;
    private final String f2863g;
    private final C0478j f2864h;
    private String f2865i = null;
    private boolean f2866j = false;

    public C0496t(Object obj, String str, int i, boolean z, String str2, byte[] bArr) {
        this.f2857a = str2;
        this.f2858b = bArr;
        this.f2859c = str;
        this.f2860d = i;
        this.f2861e = z;
        this.f2862f = obj;
        this.f2864h = new C0478j(obj);
        this.f2863g = this.f2864h.m2571c();
    }

    public static String m2607l() {
        return aw.m2053b();
    }

    public static String m2608o() {
        return aw.m2052a();
    }

    public final Object m2609a() {
        return this.f2862f;
    }

    public final byte[] m2610a(byte[] bArr) {
        int[] iArr = new int[]{26, 233, 231, 106, 177, 47, 122, 185, 154, 158, 116, 173, 122, 152, 94, 156, 182, 175, 122, 187, 114, 37, 234, 222, 155, 36, 165, 106, 215, 171, 41, 93};
        byte[] bArr2 = new byte[96];
        C0478j c0478j = this.f2864h;
        int i = Calendar.getInstance().get(13);
        C0478j c0478j2 = this.f2864h;
        int i2 = (i + Calendar.getInstance().get(14)) + 1793583386;
        byte[] f = this.f2864h.m2574f();
        byte[] g = this.f2864h.m2575g();
        int[] iArr2 = new int[f.length];
        int[] iArr3 = new int[g.length];
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i] = f[i];
            if (iArr2[i] < 0) {
                iArr2[i] = iArr2[i] + 256;
            }
        }
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i] = g[i];
            if (iArr3[i] < 0) {
                iArr3[i] = iArr3[i] + 256;
            }
        }
        int i3 = i2;
        int[] iArr4 = iArr2;
        long j = 0;
        int[] iArr5 = iArr4;
        for (int i4 = 0; i4 < 32; i4++) {
            i3 = ((i3 * (f2854k - f2855l)) + f2856m) - f2854k;
            if (iArr5 == null) {
                j = (long) i3;
            } else if (i4 >= iArr5.length) {
                iArr5 = null;
            } else {
                j = (j >> 8) + ((long) ((iArr[i4] + iArr5[i4]) + (i3 & 255)));
            }
            bArr2[i4] = (byte) ((int) j);
        }
        j = 0;
        iArr4 = iArr3;
        int i5 = i3;
        i3 = 0;
        iArr5 = iArr4;
        while (i3 < 64) {
            i5 = ((i5 * (f2854k - f2855l)) + f2856m) - f2854k;
            if (iArr5 == null) {
                j = (long) i5;
            } else if (i3 >= iArr5.length || i3 >= iArr.length) {
                iArr5 = null;
            } else {
                j = (j >> 8) + ((long) ((iArr[i3] + iArr5[i3]) + (i5 & 255)));
            }
            bArr2[i3 + 32] = (byte) ((int) j);
            i3++;
        }
        long j2 = (long) ((((f2854k - f2855l) * i5) + f2856m) - f2854k);
        j2 = j2 == 0 ? 1 : j2 & 127;
        for (int i6 = 0; i6 < bArr2.length; i6++) {
            while (true) {
                j2 = ((((j2 >> 6) ^ (((j2 >> 1) ^ j2) ^ (j2 >> 3))) & 1) << 6) | (j2 >> 1);
                if (j2 <= ((long) bArr2.length) && j2 >= 0) {
                    break;
                }
            }
            if (j2 > 26) {
                bArr[((int) j2) + 3] = bArr2[i6];
            } else {
                bArr[((int) j2) - 1] = bArr2[i6];
            }
        }
        bArr[26] = (byte) (i2 & 255);
        bArr[27] = (byte) ((i2 >> 8) & 255);
        bArr[28] = (byte) ((i2 >> 16) & 255);
        bArr[29] = (byte) ((i2 >> 24) & 255);
        return bArr;
    }

    public final String m2611b() {
        return this.f2857a;
    }

    public final byte[] m2612c() {
        return this.f2858b;
    }

    public final String m2613d() {
        return this.f2859c;
    }

    public final int m2614e() {
        return this.f2860d;
    }

    public final boolean m2615f() {
        return this.f2861e;
    }

    public final String m2616g() {
        String a = this.f2864h.m2569a();
        return a == null ? "unknown" : a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m2617h() {
        /*
        r2 = this;
        r0 = r2.f2864h;
        r0 = java.util.Locale.getDefault();
        if (r0 == 0) goto L_0x0019;
    L_0x0008:
        r0 = r0.toString();
        if (r0 == 0) goto L_0x0019;
    L_0x000e:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x0019;
    L_0x0014:
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        r0 = "unknown";
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = 0;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.t.h():java.lang.String");
    }

    public final String m2618i() {
        C0478j c0478j = this.f2864h;
        String str = Build.MODEL;
        return str == null ? "unknown" : str;
    }

    public final String m2619j() {
        C0478j c0478j = this.f2864h;
        String str = VERSION.RELEASE;
        return str == null ? "unknown" : str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m2620k() {
        /*
        r2 = this;
        r0 = r2.f2864h;
        r0 = java.util.Locale.getDefault();
        if (r0 == 0) goto L_0x0019;
    L_0x0008:
        r0 = r0.getCountry();
        if (r0 == 0) goto L_0x0019;
    L_0x000e:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x0019;
    L_0x0014:
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        r0 = "unknown";
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = 0;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.t.k():java.lang.String");
    }

    public final String m2621m() {
        String b = this.f2864h.m2570b();
        return b == null ? "unknown" : b;
    }

    public final String m2622n() {
        return this.f2863g == null ? "unknown" : this.f2863g;
    }

    public final bh m2623p() {
        return this.f2864h.m2573e();
    }

    public final bh m2624q() {
        return this.f2864h.m2572d();
    }

    public final String m2625r() {
        if (!this.f2866j) {
            this.f2866j = true;
            try {
                String str = this.f2859c;
                int i = this.f2860d;
                this.f2865i = ca.m2225g();
            } catch (RuntimeException e) {
                C0478j c0478j = this.f2864h;
                this.f2865i = null;
            }
        }
        return this.f2865i;
    }
}
