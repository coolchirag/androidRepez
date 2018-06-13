package org.apache.p040b.p041a.p042a.p043a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class C0567d extends C0566a {
    private final byte[] f3091a;
    private final Charset f3092b;

    public C0567d(String str) {
        this(str, "text/plain");
    }

    private C0567d(String str, String str2) {
        super(str2);
        if (str == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        Charset forName = Charset.forName("US-ASCII");
        this.f3091a = str.getBytes(forName.name());
        this.f3092b = forName;
    }

    public final void mo476a(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.f3091a);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public final String mo477b() {
        return this.f3092b.name();
    }

    public final String mo478c() {
        return "8bit";
    }

    public final long mo479d() {
        return (long) this.f3091a.length;
    }
}
