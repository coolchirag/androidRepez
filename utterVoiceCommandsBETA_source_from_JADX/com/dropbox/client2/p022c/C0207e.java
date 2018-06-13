package com.dropbox.client2.p022c;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

final class C0207e implements HttpResponseInterceptor {
    final /* synthetic */ C0198a f1871a;

    C0207e(C0198a c0198a) {
        this.f1871a = c0198a;
    }

    public final void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                for (HeaderElement name : contentEncoding.getElements()) {
                    if (name.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new C0211i(httpResponse.getEntity()));
                        return;
                    }
                }
            }
        }
    }
}
