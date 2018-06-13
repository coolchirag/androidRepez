package com.dropbox.client2.p022c;

import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

final class C0204b implements ConnPerRoute {
    final /* synthetic */ C0198a f1868a;

    C0204b(C0198a c0198a) {
        this.f1868a = c0198a;
    }

    public final int getMaxForRoute(HttpRoute httpRoute) {
        return 10;
    }
}
