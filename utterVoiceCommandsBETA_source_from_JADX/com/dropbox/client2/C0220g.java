package com.dropbox.client2;

import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public final class C0220g extends HttpEntityWrapper {
    private final C0154f f1897a;
    private final long f1898b;

    public C0220g(HttpEntity httpEntity, C0154f c0154f) {
        super(httpEntity);
        this.f1897a = c0154f;
        this.f1898b = httpEntity.getContentLength();
    }

    public final void writeTo(OutputStream outputStream) {
        this.wrappedEntity.writeTo(new C0221h(this, outputStream));
    }
}
