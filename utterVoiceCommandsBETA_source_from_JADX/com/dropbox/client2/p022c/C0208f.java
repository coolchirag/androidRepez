package com.dropbox.client2.p022c;

import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

final class C0208f extends ThreadSafeClientConnManager {
    public C0208f(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        super(httpParams, schemeRegistry);
    }

    public final ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        C0212j.m1545a(this);
        return super.requestConnection(httpRoute, obj);
    }
}
