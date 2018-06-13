package com.dropbox.client2.p021a;

import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public final class C0193g extends C0187a {
    public C0194h f1845a;
    public int f1846b;
    public String f1847c;
    public String f1848d;
    public String f1849e;
    public Map<String, Object> f1850f;

    public C0193g(HttpResponse httpResponse) {
        fillInStackTrace();
        StatusLine statusLine = httpResponse.getStatusLine();
        this.f1846b = statusLine.getStatusCode();
        this.f1847c = statusLine.getReasonPhrase();
        this.f1848d = C0193g.m1518a(httpResponse, "server");
        this.f1849e = C0193g.m1518a(httpResponse, "location");
    }

    public C0193g(HttpResponse httpResponse, Object obj) {
        this(httpResponse);
        if (obj != null && (obj instanceof Map)) {
            this.f1850f = (Map) obj;
            this.f1845a = new C0194h(this.f1850f);
        }
    }

    private static String m1518a(HttpResponse httpResponse, String str) {
        Header firstHeader = httpResponse.getFirstHeader(str);
        return firstHeader != null ? firstHeader.getValue() : null;
    }

    public static boolean m1519a(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 302) {
            String a = C0193g.m1518a(httpResponse, "location");
            if (a != null) {
                int indexOf = a.indexOf("://");
                if (indexOf >= 0) {
                    a = a.substring(indexOf + 3);
                    indexOf = a.indexOf("/");
                    if (indexOf >= 0 && a.substring(0, indexOf).toLowerCase().contains("dropbox.com")) {
                        return true;
                    }
                }
            }
        } else if (statusCode == 304) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "DropboxServerException (" + this.f1848d + "): " + this.f1846b + " " + this.f1847c + " (" + this.f1845a.f1851a + ")";
    }
}
