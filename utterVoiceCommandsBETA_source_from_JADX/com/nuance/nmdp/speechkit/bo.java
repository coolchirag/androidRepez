package com.nuance.nmdp.speechkit;

public class bo {
    private static final bj f2484a = C0478j.m2563a(bo.class);

    public static byte[] m2174a(byte b, byte b2, short s, byte[] bArr) {
        if (f2484a.mo317b()) {
            f2484a.mo316b("Building XMode buffer: protocol=" + b + " version=" + b2 + " cmd=" + s + " payload len:" + bArr.length);
            f2484a.m2143a(bArr);
        }
        int length = bArr.length;
        Object obj = new byte[(length + 8)];
        System.arraycopy(new bp(b, b2, s, length).m2176a(), 0, obj, 0, 8);
        System.arraycopy(bArr, 0, obj, 8, length);
        return obj;
    }

    public static byte[] m2175a(byte[] bArr, byte[] bArr2) {
        if (f2484a.mo317b()) {
            f2484a.mo316b((Object) "Appending session ID");
            f2484a.m2143a(bArr2);
            f2484a.m2143a(bArr);
        }
        Object obj = new byte[(bArr.length + 16)];
        System.arraycopy(bArr2, 0, obj, 0, 16);
        System.arraycopy(bArr, 0, obj, 16, bArr.length);
        return obj;
    }
}
