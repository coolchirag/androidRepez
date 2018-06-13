package com.nuance.nmdp.speechkit;

import com.faceture.google.play.QueryParamConst;
import java.io.UnsupportedEncodingException;

public abstract class bj {
    private static String[] f2476a = new String[]{QueryParamConst.U_VALUE, "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    private static String m2138a(byte b) {
        return f2476a[(byte) (((byte) (((byte) (b & 240)) >>> 4)) & 15)] + f2476a[(byte) (b & 15)];
    }

    public static String m2139b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < 16) {
            stringBuffer.append(m2138a(bArr[i]));
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append("-");
            }
            i++;
        }
        return stringBuffer.toString().toLowerCase();
    }

    private static String[] m2140c(byte[] bArr) {
        String str;
        int length = bArr.length / 8;
        if (bArr.length % 8 != 0) {
            length++;
        }
        String[] strArr = new String[length];
        try {
            str = new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            str = new String(bArr);
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3;
            char[] cArr = new char[41];
            for (i3 = 0; i3 < cArr.length; i3++) {
                cArr[i3] = ' ';
            }
            for (i3 = 0; i3 < 8 && i < bArr.length; i3++) {
                String a = m2138a(bArr[i]);
                cArr[i3 * 3] = a.charAt(0);
                cArr[(i3 * 3) + 1] = a.charAt(1);
                cArr[(i3 * 2) + 26] = str.charAt(i);
                i++;
            }
            strArr[i2] = new String(cArr);
        }
        return strArr;
    }

    public abstract void mo313a(Object obj);

    public abstract void mo314a(Object obj, Throwable th);

    public final void m2143a(byte[] bArr) {
        if (mo315a()) {
            mo313a((Object) "Buffer dump:");
            String[] c = m2140c(bArr);
            for (Object a : c) {
                mo313a(a);
            }
        }
    }

    public abstract boolean mo315a();

    public abstract void mo316b(Object obj);

    public abstract boolean mo317b();

    public abstract void mo318c(Object obj);

    public abstract boolean mo319c();

    public abstract void mo320d(Object obj);

    public abstract boolean mo321d();

    public abstract void mo322e(Object obj);

    public abstract boolean mo323e();

    public abstract void mo324f();

    public abstract void mo325g();
}
