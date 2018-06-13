package com.att.android.speech;

import android.os.Handler;
import java.io.InputStream;
import java.io.OutputStream;

final class C0138z extends C0135v {
    protected InputStream f594d = null;
    protected Handler f595e = null;
    protected ai f596f = null;

    C0138z(aj ajVar, ai aiVar, InputStream inputStream, Handler handler) {
        super(ajVar);
        this.f594d = inputStream;
        this.f595e = handler;
        this.f596f = aiVar;
    }

    public final InputStream getContent() {
        return this.f594d;
    }

    public final long getContentLength() {
        return -1;
    }

    public final boolean isChunked() {
        return true;
    }

    public final boolean isRepeatable() {
        return false;
    }

    public final boolean isStreaming() {
        return this.f594d != null;
    }

    public final void writeTo(OutputStream outputStream) {
        if (this.f594d != null) {
            byte[] bArr = new byte[512];
            while (true) {
                int read = this.f594d.read(bArr, 0, bArr.length);
                if (read >= 0 && !m464b()) {
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        this.a += (long) read;
                    }
                }
            }
            ac.m345a("AudioStreamingHttpEntity", "Closing");
            if (this.f594d != null) {
                this.f594d.close();
                this.f594d = null;
            }
            ac.m345a("AudioStreamingHttpEntity", "Closed");
            if (this.f595e != null) {
                this.f595e.post(new C0136w(this, this.f596f));
            }
            this.b.f433g = System.currentTimeMillis();
            return;
        }
        ac.m345a("AudioStreamingHttpEntity", "The input stream is null");
    }
}
