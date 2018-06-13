package com.nuance.nmdp.speechkit;

public class br {
    private static final bj f2492a = C0478j.m2563a(br.class);

    public static short m2178a(byte[] bArr, int i) {
        short s = (short) ((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8));
        if (f2492a.mo315a()) {
            f2492a.mo313a("Converted [" + bArr[i] + ", " + bArr[i + 1] + "] to short " + s);
        }
        return s;
    }

    public static void m2179a(int i, byte[] bArr, int i2) {
        short s = (short) ((i >> 16) & 65535);
        m2180a((short) (i & 65535), bArr, i2);
        m2180a(s, bArr, i2 + 2);
        if (f2492a.mo315a()) {
            f2492a.mo313a("Converted int " + i + " to [" + bArr[i2] + ", " + bArr[i2 + 1] + ", " + bArr[i2 + 2] + ", " + bArr[i2 + 3] + "]");
        }
    }

    public static void m2180a(short s, byte[] bArr, int i) {
        byte b = (byte) ((s >> 8) & 255);
        bArr[i] = (byte) (s & 255);
        bArr[i + 1] = b;
        if (f2492a.mo315a()) {
            f2492a.mo313a("Converted short " + s + " to [" + bArr[i] + ", " + bArr[i + 1] + "]");
        }
    }

    public static int m2181b(byte[] bArr, int i) {
        int a = (m2178a(bArr, i) & 65535) | ((m2178a(bArr, i + 2) & 65535) << 16);
        if (f2492a.mo315a()) {
            f2492a.mo313a("Converted [" + bArr[i] + ", " + bArr[i + 1] + ", " + bArr[i + 2] + ", " + bArr[i + 3] + "] to int " + a);
        }
        return a;
    }
}
