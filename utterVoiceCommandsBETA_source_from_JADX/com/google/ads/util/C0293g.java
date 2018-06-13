package com.google.ads.util;

import java.io.UnsupportedEncodingException;

public class C0293g {
    static final /* synthetic */ boolean f2273a = (!C0293g.class.desiredAssertionStatus());

    private C0293g() {
    }

    public static String m1872a(byte[] bArr) {
        try {
            int i;
            int length = bArr.length;
            C0296j c0296j = new C0296j();
            int i2 = (length / 3) * 4;
            if (!c0296j.f2285d) {
                switch (length % 3) {
                    case 0:
                        break;
                    case 1:
                        i2 += 2;
                        break;
                    case 2:
                        i2 += 3;
                        break;
                    default:
                        break;
                }
            } else if (length % 3 > 0) {
                i2 += 4;
            }
            if (!c0296j.f2286e || length <= 0) {
                i = i2;
            } else {
                i = ((c0296j.f2287f ? 2 : 1) * (((length - 1) / 57) + 1)) + i2;
            }
            c0296j.a = new byte[i];
            c0296j.m1875a(bArr, length);
            if (f2273a || c0296j.b == i) {
                return new String(c0296j.a, "US-ASCII");
            }
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] m1873a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        C0295i c0295i = new C0295i(new byte[((length * 3) / 4)]);
        if (!c0295i.m1874a(bytes, length)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c0295i.b == c0295i.a.length) {
            return c0295i.a;
        } else {
            Object obj = new byte[c0295i.b];
            System.arraycopy(c0295i.a, 0, obj, 0, c0295i.b);
            return obj;
        }
    }
}
