package com.nuance.nmdp.speechkit;

public final class bq {
    private static byte[] f2490a = new byte[64];
    private static String f2491b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    static {
        for (int i = 0; i < 64; i++) {
            f2490a[i] = (byte) f2491b.charAt(i);
        }
    }

    public static String m2177a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(((length + 2) / 3) * 4)];
        int i = length + 0;
        int i2 = 0;
        int i3 = 0;
        length = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5;
            byte b = bArr[i2];
            length++;
            switch (length) {
                case 1:
                    i5 = i4 + 1;
                    bArr2[i4] = f2490a[(b >> 2) & 63];
                    break;
                case 2:
                    i5 = i4 + 1;
                    bArr2[i4] = f2490a[((i3 << 4) & 48) | ((b >> 4) & 15)];
                    break;
                case 3:
                    i5 = i4 + 1;
                    bArr2[i4] = f2490a[((i3 << 2) & 60) | ((b >> 6) & 3)];
                    length = i5 + 1;
                    bArr2[i5] = f2490a[b & 63];
                    i5 = length;
                    length = 0;
                    break;
                default:
                    i5 = i4;
                    break;
            }
            i2++;
            byte b2 = b;
            i4 = i5;
        }
        switch (length) {
            case 1:
                length = i4 + 1;
                bArr2[i4] = f2490a[(i3 << 4) & 48];
                int i6 = length + 1;
                bArr2[length] = (byte) 61;
                bArr2[i6] = (byte) 61;
                break;
            case 2:
                length = i4 + 1;
                bArr2[i4] = f2490a[(i3 << 2) & 60];
                bArr2[length] = (byte) 61;
                break;
        }
        return new String(bArr2);
    }
}
