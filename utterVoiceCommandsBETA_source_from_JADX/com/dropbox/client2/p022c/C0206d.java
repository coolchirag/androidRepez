package com.dropbox.client2.p022c;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

final class C0206d implements HttpRequestInterceptor {
    final /* synthetic */ C0198a f1870a;

    C0206d(C0198a c0198a) {
        this.f1870a = c0198a;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
    }
}
