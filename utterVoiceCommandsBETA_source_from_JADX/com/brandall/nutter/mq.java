package com.brandall.nutter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import winterwell.jtwitter.TwitterStream;

public final class mq {
    mu f1733a;
    HttpURLConnection f1734b;
    byte[] f1735c;

    private mq(HttpURLConnection httpURLConnection, byte[] bArr) {
        this.f1734b = httpURLConnection;
        this.f1735c = bArr;
    }

    public static mq m1483a(String str, String str2, String str3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            byte[] bytes = String.format(Locale.US, "client_id=%s&client_secret=%s&grant_type=client_credentials&scope=SPEECH", new Object[]{str2, str3}).getBytes("UTF8");
            httpURLConnection.setConnectTimeout(TwitterStream.MAX_USERS);
            httpURLConnection.setReadTimeout(TwitterStream.MAX_USERS);
            return new mq(httpURLConnection, bytes);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("URL must be HTTP: " + str, e2);
        }
    }
}
