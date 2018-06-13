package p000a.p001a.p003c;

import java.io.InputStream;

public interface C0004b {
    String getContentType();

    String getHeader(String str);

    InputStream getMessagePayload();

    String getMethod();

    String getRequestUrl();

    void setHeader(String str, String str2);

    void setRequestUrl(String str);

    Object unwrap();
}
