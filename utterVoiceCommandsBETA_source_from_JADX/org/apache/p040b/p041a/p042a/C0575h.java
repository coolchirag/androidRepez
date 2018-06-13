package org.apache.p040b.p041a.p042a;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.p040b.p041a.p042a.p043a.C0565b;

public final class C0575h implements HttpEntity {
    private static final char[] f3113a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final C0570c f3114b;
    private final Header f3115c;
    private long f3116d;
    private volatile boolean f3117e;

    public C0575h() {
        this(C0572e.STRICT);
    }

    private C0575h(C0572e c0572e) {
        String a = C0575h.m2843a();
        if (c0572e == null) {
            c0572e = C0572e.STRICT;
        }
        this.f3114b = new C0570c("form-data", a, c0572e);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/form-data; boundary=");
        stringBuilder.append(a);
        this.f3115c = new BasicHeader("Content-Type", stringBuilder.toString());
        this.f3117e = true;
    }

    public C0575h(C0572e c0572e, byte b) {
        this(c0572e);
    }

    private static String m2843a() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(f3113a[random.nextInt(f3113a.length)]);
        }
        return stringBuilder.toString();
    }

    public final void m2844a(String str, C0565b c0565b) {
        this.f3114b.m2841a(new C0568a(str, c0565b));
        this.f3117e = true;
    }

    public final void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public final InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public final Header getContentEncoding() {
        return null;
    }

    public final long getContentLength() {
        if (this.f3117e) {
            this.f3116d = this.f3114b.m2842b();
            this.f3117e = false;
        }
        return this.f3116d;
    }

    public final Header getContentType() {
        return this.f3115c;
    }

    public final boolean isChunked() {
        return !isRepeatable();
    }

    public final boolean isRepeatable() {
        for (C0568a c0568a : this.f3114b.m2839a()) {
            if (c0568a.f3094b.mo479d() < 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isStreaming() {
        return !isRepeatable();
    }

    public final void writeTo(OutputStream outputStream) {
        this.f3114b.m2840a(outputStream);
    }
}
