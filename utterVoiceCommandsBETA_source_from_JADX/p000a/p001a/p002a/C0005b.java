package p000a.p001a.p002a;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003c.C0004b;

public class C0005b implements C0004b {
    protected HttpURLConnection connection;

    public C0005b(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    public Map<String, String> getAllHeaders() {
        Map requestProperties = this.connection.getRequestProperties();
        Map<String, String> hashMap = new HashMap(requestProperties.size());
        for (String str : requestProperties.keySet()) {
            List list = (List) requestProperties.get(str);
            if (!list.isEmpty()) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    public String getContentType() {
        return this.connection.getRequestProperty("Content-Type");
    }

    public String getHeader(String str) {
        return this.connection.getRequestProperty(str);
    }

    public InputStream getMessagePayload() {
        return null;
    }

    public String getMethod() {
        return this.connection.getRequestMethod();
    }

    public String getRequestUrl() {
        return this.connection.getURL().toExternalForm();
    }

    public void setHeader(String str, String str2) {
        this.connection.setRequestProperty(str, str2);
    }

    public void setRequestUrl(String str) {
    }

    public HttpURLConnection unwrap() {
        return this.connection;
    }
}
