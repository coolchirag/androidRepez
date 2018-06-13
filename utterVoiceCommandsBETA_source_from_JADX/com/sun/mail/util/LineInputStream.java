package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class LineInputStream extends FilterInputStream {
    private char[] lineBuffer = null;

    public LineInputStream(InputStream inputStream) {
        super(inputStream);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readLine() {
        /*
        r10 = this;
        r9 = 13;
        r8 = 10;
        r7 = -1;
        r2 = 0;
        r5 = r10.in;
        r0 = r10.lineBuffer;
        if (r0 != 0) goto L_0x0012;
    L_0x000c:
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0 = new char[r0];
        r10.lineBuffer = r0;
    L_0x0012:
        r1 = r0.length;
        r3 = r0;
        r0 = r1;
        r1 = r2;
    L_0x0016:
        r6 = r5.read();
        if (r6 != r7) goto L_0x0022;
    L_0x001c:
        if (r6 != r7) goto L_0x0060;
    L_0x001e:
        if (r1 != 0) goto L_0x0060;
    L_0x0020:
        r0 = 0;
    L_0x0021:
        return r0;
    L_0x0022:
        if (r6 == r8) goto L_0x001c;
    L_0x0024:
        if (r6 != r9) goto L_0x0044;
    L_0x0026:
        r0 = r5.read();
        if (r0 != r9) goto L_0x006a;
    L_0x002c:
        r0 = r5.read();
        r4 = r0;
    L_0x0031:
        if (r4 == r8) goto L_0x001c;
    L_0x0033:
        r0 = r5 instanceof java.io.PushbackInputStream;
        if (r0 != 0) goto L_0x0068;
    L_0x0037:
        r0 = new java.io.PushbackInputStream;
        r0.<init>(r5);
        r10.in = r0;
    L_0x003e:
        r0 = (java.io.PushbackInputStream) r0;
        r0.unread(r4);
        goto L_0x001c;
    L_0x0044:
        r0 = r0 + -1;
        if (r0 >= 0) goto L_0x0065;
    L_0x0048:
        r0 = r1 + 128;
        r4 = new char[r0];
        r0 = r4.length;
        r0 = r0 - r1;
        r3 = r0 + -1;
        r0 = r10.lineBuffer;
        java.lang.System.arraycopy(r0, r2, r4, r2, r1);
        r10.lineBuffer = r4;
    L_0x0057:
        r0 = r1 + 1;
        r6 = (char) r6;
        r4[r1] = r6;
        r1 = r0;
        r0 = r3;
        r3 = r4;
        goto L_0x0016;
    L_0x0060:
        r0 = java.lang.String.copyValueOf(r3, r2, r1);
        goto L_0x0021;
    L_0x0065:
        r4 = r3;
        r3 = r0;
        goto L_0x0057;
    L_0x0068:
        r0 = r5;
        goto L_0x003e;
    L_0x006a:
        r4 = r0;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.LineInputStream.readLine():java.lang.String");
    }
}
