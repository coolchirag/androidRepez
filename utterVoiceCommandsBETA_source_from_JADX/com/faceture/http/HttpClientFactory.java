package com.faceture.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.p040b.p041a.p042a.C0572e;
import org.apache.p040b.p041a.p042a.C0575h;
import org.apache.p040b.p041a.p042a.p043a.C0567d;

public class HttpClientFactory {
    public DefaultHttpClient createHttpClient() {
        return new DefaultHttpClient();
    }

    public HttpGet createHttpGet() {
        return new HttpGet();
    }

    public HttpPost createHttpPost() {
        return new HttpPost();
    }

    public C0575h createMultipartEntity() {
        return new C0575h(C0572e.BROWSER_COMPATIBLE, (byte) 0);
    }

    public C0567d createStringBody(String str) {
        if (str != null && !str.isEmpty()) {
            return new C0567d(str);
        }
        throw new IllegalArgumentException("string is null or empty");
    }
}
