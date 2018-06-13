package com.google.ads;

import android.content.Context;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.net.HttpURLConnection;
import java.net.URL;

public final class C0278m implements Runnable {
    private final Context f2225a;
    private final String f2226b;

    public C0278m(String str, Context context) {
        this.f2226b = str;
        this.f2225a = context;
    }

    public final void run() {
        HttpURLConnection httpURLConnection;
        try {
            C0290d.m1862a("Pinging URL: " + this.f2226b);
            httpURLConnection = (HttpURLConnection) new URL(this.f2226b).openConnection();
            AdUtil.m1829a(httpURLConnection, this.f2225a);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                C0290d.m1871e("Did not receive 2XX (got " + responseCode + ") from pinging URL: " + this.f2226b);
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            C0290d.m1870d("Unable to ping the URL: " + this.f2226b, th);
        }
    }
}
