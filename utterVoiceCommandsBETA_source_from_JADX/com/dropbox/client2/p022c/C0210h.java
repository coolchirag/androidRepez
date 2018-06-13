package com.dropbox.client2.p022c;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HttpContext;

final class C0210h implements ConnectionKeepAliveStrategy {
    private C0210h() {
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long j = 20000;
        HeaderElementIterator basicHeaderElementIterator = new BasicHeaderElementIterator(httpResponse.headerIterator("Keep-Alive"));
        while (basicHeaderElementIterator.hasNext()) {
            HeaderElement nextElement = basicHeaderElementIterator.nextElement();
            String name = nextElement.getName();
            String value = nextElement.getValue();
            if (value != null && name.equalsIgnoreCase("timeout")) {
                try {
                    j = Math.min(j, Long.parseLong(value) * 1000);
                } catch (NumberFormatException e) {
                }
            }
        }
        return j;
    }
}
