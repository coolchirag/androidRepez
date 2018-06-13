package org.apache.p040b.p041a.p042a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.p040b.p041a.p042a.p043a.C0565b;

public final class C0570c {
    private static final ByteArrayBuffer f3098a = C0570c.m2834a(C0573f.f3110a, ": ");
    private static final ByteArrayBuffer f3099b = C0570c.m2834a(C0573f.f3110a, "\r\n");
    private static final ByteArrayBuffer f3100c = C0570c.m2834a(C0573f.f3110a, "--");
    private final String f3101d;
    private final Charset f3102e;
    private final String f3103f;
    private final List<C0568a> f3104g;
    private final C0572e f3105h;

    public C0570c(String str, String str2, C0572e c0572e) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        } else {
            this.f3101d = str;
            this.f3102e = C0573f.f3110a;
            this.f3103f = str2;
            this.f3104g = new ArrayList();
            this.f3105h = c0572e;
        }
    }

    private static ByteArrayBuffer m2834a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void m2835a(String str, OutputStream outputStream) {
        C0570c.m2838a(C0570c.m2834a(C0573f.f3110a, str), outputStream);
    }

    private static void m2836a(String str, Charset charset, OutputStream outputStream) {
        C0570c.m2838a(C0570c.m2834a(charset, str), outputStream);
    }

    private void m2837a(C0572e c0572e, OutputStream outputStream, boolean z) {
        ByteArrayBuffer a = C0570c.m2834a(this.f3102e, this.f3103f);
        for (C0568a c0568a : this.f3104g) {
            C0570c.m2838a(f3100c, outputStream);
            C0570c.m2838a(a, outputStream);
            C0570c.m2838a(f3099b, outputStream);
            C0569b c0569b = c0568a.f3093a;
            C0574g c0574g;
            switch (C0571d.f3106a[c0572e.ordinal()]) {
                case 1:
                    Iterator it = c0569b.iterator();
                    while (it.hasNext()) {
                        c0574g = (C0574g) it.next();
                        C0570c.m2835a(c0574g.f3111a, outputStream);
                        C0570c.m2838a(f3098a, outputStream);
                        C0570c.m2835a(c0574g.f3112b, outputStream);
                        C0570c.m2838a(f3099b, outputStream);
                    }
                    break;
                case 2:
                    c0574g = c0568a.f3093a.m2832a("Content-Disposition");
                    Charset charset = this.f3102e;
                    C0570c.m2836a(c0574g.f3111a, charset, outputStream);
                    C0570c.m2838a(f3098a, outputStream);
                    C0570c.m2836a(c0574g.f3112b, charset, outputStream);
                    C0570c.m2838a(f3099b, outputStream);
                    C0565b c0565b = c0568a.f3094b;
                    break;
            }
            C0570c.m2838a(f3099b, outputStream);
            if (z) {
                c0568a.f3094b.mo476a(outputStream);
            }
            C0570c.m2838a(f3099b, outputStream);
        }
        C0570c.m2838a(f3100c, outputStream);
        C0570c.m2838a(a, outputStream);
        C0570c.m2838a(f3100c, outputStream);
        C0570c.m2838a(f3099b, outputStream);
    }

    private static void m2838a(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    public final List<C0568a> m2839a() {
        return this.f3104g;
    }

    public final void m2840a(OutputStream outputStream) {
        m2837a(this.f3105h, outputStream, true);
    }

    public final void m2841a(C0568a c0568a) {
        if (c0568a != null) {
            this.f3104g.add(c0568a);
        }
    }

    public final long m2842b() {
        long j = 0;
        for (C0568a c0568a : this.f3104g) {
            long d = c0568a.f3094b.mo479d();
            if (d < 0) {
                return -1;
            }
            j += d;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m2837a(this.f3105h, byteArrayOutputStream, false);
            return j + ((long) byteArrayOutputStream.toByteArray().length);
        } catch (IOException e) {
            return -1;
        }
    }
}
