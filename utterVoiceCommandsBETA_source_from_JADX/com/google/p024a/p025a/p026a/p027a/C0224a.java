package com.google.p024a.p025a.p026a.p027a;

public final class C0224a extends C0223b {
    private static final char[] f1906a = new char[]{'+'};
    private static final char[] f1907b = "0123456789ABCDEF".toCharArray();
    private final boolean f1908c;
    private final boolean[] f1909d;

    public C0224a(String str) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        } else {
            this.f1908c = false;
            this.f1909d = C0224a.m1560b(str);
        }
    }

    private static boolean[] m1560b(String str) {
        int i;
        int i2 = 0;
        char[] toCharArray = str.toCharArray();
        int i3 = 122;
        for (char max : toCharArray) {
            i3 = Math.max(max, i3);
        }
        boolean[] zArr = new boolean[(i3 + 1)];
        for (i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (i = 65; i <= 90; i++) {
            zArr[i] = true;
        }
        for (i = 97; i <= 122; i++) {
            zArr[i] = true;
        }
        i = toCharArray.length;
        while (i2 < i) {
            zArr[toCharArray[i2]] = true;
            i2++;
        }
        return zArr;
    }

    protected final int mo104a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt >= this.f1909d.length || !this.f1909d[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    public final String mo105a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= this.f1909d.length || !this.f1909d[charAt]) {
                return m1558a(str, i);
            }
        }
        return str;
    }

    protected final char[] mo106a(int i) {
        if (i < this.f1909d.length && this.f1909d[i]) {
            return null;
        }
        if (i == 32 && this.f1908c) {
            return f1906a;
        }
        if (i <= 127) {
            return new char[]{'%', f1907b[i & 15], f1907b[i >>> 4]};
        } else if (i <= 2047) {
            r0 = new char[6];
            r0[0] = '%';
            r0[3] = '%';
            r0[5] = f1907b[i & 15];
            r1 = i >>> 4;
            r0[4] = f1907b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[2] = f1907b[r1 & 15];
            r0[1] = f1907b[(r1 >>> 4) | 12];
            return r0;
        } else if (i <= 65535) {
            r0 = new char[9];
            r1 = i >>> 4;
            r0[7] = f1907b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[5] = f1907b[r1 & 15];
            r1 >>>= 4;
            r0[4] = f1907b[(r1 & 3) | 8];
            r0[2] = f1907b[r1 >>> 2];
            return r0;
        } else if (i <= 1114111) {
            r0 = new char[12];
            r1 = i >>> 4;
            r0[10] = f1907b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[8] = f1907b[r1 & 15];
            r1 >>>= 4;
            r0[7] = f1907b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[5] = f1907b[r1 & 15];
            r1 >>>= 4;
            r0[4] = f1907b[(r1 & 3) | 8];
            r0[2] = f1907b[(r1 >>> 2) & 7];
            return r0;
        } else {
            throw new IllegalArgumentException("Invalid unicode character value " + i);
        }
    }
}
