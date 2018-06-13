package com.dropbox.client2.p022c;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

final class C0205c extends DefaultHttpClient {
    final /* synthetic */ C0198a f1869a;

    C0205c(C0198a c0198a, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f1869a = c0198a;
        super(clientConnectionManager, httpParams);
    }

    protected final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new C0210h();
    }

    protected final ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new C0209g();
    }
}
