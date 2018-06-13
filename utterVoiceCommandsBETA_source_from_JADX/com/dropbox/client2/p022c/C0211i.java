package com.dropbox.client2.p022c;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

final class C0211i extends HttpEntityWrapper {
    public C0211i(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public final InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }

    public final long getContentLength() {
        return -1;
    }
}
