package com.dropbox.client2.p022c;

import com.dropbox.client2.C0196a;
import com.faceture.google.play.HeaderName;
import java.net.URLEncoder;
import java.util.Locale;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public abstract class C0198a implements C0197m {
    public final C0215l f1861a;
    public C0214k f1862b;
    private final C0216n f1863c;
    private HttpClient f1864d;

    public C0198a(C0215l c0215l, C0216n c0216n) {
        this(c0215l, c0216n, null);
    }

    public C0198a(C0215l c0215l, C0216n c0216n, C0214k c0214k) {
        this.f1862b = null;
        this.f1864d = null;
        if (c0215l == null) {
            throw new IllegalArgumentException("'appKeyPair' must be non-null");
        } else if (c0216n == null) {
            throw new IllegalArgumentException("'type' must be non-null");
        } else {
            this.f1861a = c0215l;
            this.f1863c = c0216n;
            this.f1862b = c0214k;
        }
    }

    private static String m1534a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("UTF-8 isn't available");
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public final C0216n mo95a() {
        return this.f1863c;
    }

    public final void mo96a(HttpRequest httpRequest) {
        String str;
        String str2 = HeaderName.AUTHORIZATION;
        C0215l c0215l = this.f1861a;
        C0214k c0214k = this.f1862b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth oauth_version=\"1.0\"");
        stringBuilder.append(", oauth_signature_method=\"PLAINTEXT\"");
        stringBuilder.append(", oauth_consumer_key=\"").append(C0198a.m1534a(c0215l.a)).append("\"");
        if (c0214k != null) {
            stringBuilder.append(", oauth_token=\"").append(C0198a.m1534a(c0214k.a)).append("\"");
            str = C0198a.m1534a(c0215l.b) + "&" + C0198a.m1534a(c0214k.b);
        } else {
            str = C0198a.m1534a(c0215l.b) + "&";
        }
        stringBuilder.append(", oauth_signature=\"").append(str).append("\"");
        httpRequest.addHeader(str2, stringBuilder.toString());
    }

    public final void mo97a(HttpUriRequest httpUriRequest) {
        HttpParams params = httpUriRequest.getParams();
        HttpConnectionParams.setSoTimeout(params, 30000);
        HttpConnectionParams.setConnectionTimeout(params, 30000);
    }

    public final Locale mo98b() {
        return Locale.ENGLISH;
    }

    public final boolean mo99c() {
        return this.f1862b != null;
    }

    public final synchronized C0217o mo100d() {
        return null;
    }

    public final synchronized HttpClient mo101e() {
        if (this.f1864d == null) {
            HttpParams basicHttpParams = new BasicHttpParams();
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new C0204b(this));
            ConnManagerParams.setMaxTotalConnections(basicHttpParams, 20);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(com.faceture.http.Scheme.HTTP, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(com.faceture.http.Scheme.HTTPS, SSLSocketFactory.getSocketFactory(), 443));
            ClientConnectionManager c0208f = new C0208f(basicHttpParams, schemeRegistry);
            basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
            HttpProtocolParams.setUserAgent(basicHttpParams, "OfficialDropboxJavaSDK/" + C0196a.f1853a);
            HttpClient c0205c = new C0205c(this, c0208f, basicHttpParams);
            c0205c.addRequestInterceptor(new C0206d(this));
            c0205c.addResponseInterceptor(new C0207e(this));
            this.f1864d = c0205c;
        }
        return this.f1864d;
    }

    public final String mo102f() {
        return "api-content.dropbox.com";
    }
}
