package com.google.ads.internal;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.faceture.google.play.HeaderName;
import com.google.ads.C0243e;
import com.google.ads.C0245g;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class C0266r implements Runnable {
    volatile boolean f2180a;
    boolean f2181b;
    private final C0256h f2182c;
    private final C0264p f2183d;
    private final C0267t f2184e;
    private String f2185f;
    private Thread f2186g;

    C0266r(C0256h c0256h, C0264p c0264p) {
        this(c0256h, c0264p, new C0268s());
    }

    private C0266r(C0256h c0256h, C0264p c0264p, C0267t c0267t) {
        this.f2186g = null;
        this.f2182c = c0256h;
        this.f2183d = c0264p;
        this.f2184e = c0267t;
    }

    private void m1759a(HttpURLConnection httpURLConnection) {
        String[] split;
        int i = 0;
        Object headerField = httpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
        if (!TextUtils.isEmpty(headerField)) {
            this.f2182c.m1714e(headerField);
        }
        headerField = httpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String b : headerField.trim().split("\\s+")) {
                this.f2183d.m1736b(b);
            }
        }
        headerField = httpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            split = headerField.trim().split("\\s+");
            int length = split.length;
            while (i < length) {
                this.f2182c.m1704a(split[i]);
                i++;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                float parseFloat = Float.parseFloat(headerField2);
                if (parseFloat > 0.0f) {
                    this.f2183d.m1722a(parseFloat);
                    if (!this.f2183d.m1751p()) {
                        this.f2183d.m1741f();
                    }
                } else if (this.f2183d.m1751p()) {
                    this.f2183d.m1740e();
                }
            } catch (Throwable e) {
                C0290d.m1870d("Could not get refresh value: " + headerField2, e);
            }
        }
        String headerField3 = httpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
        if (!TextUtils.isEmpty(headerField3)) {
            try {
                this.f2183d.m1724a((long) (Float.parseFloat(headerField3) * 1000.0f));
            } catch (Throwable e2) {
                C0290d.m1870d("Could not get timeout value: " + headerField3, e2);
            }
        }
        headerField2 = httpURLConnection.getHeaderField("X-Afma-Orientation");
        if (!TextUtils.isEmpty(headerField2)) {
            if (headerField2.equals("portrait")) {
                this.f2182c.m1699a(AdUtil.m1834b());
            } else if (headerField2.equals("landscape")) {
                this.f2182c.m1699a(AdUtil.m1819a());
            }
        }
        if (!TextUtils.isEmpty(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {
            try {
                this.f2183d.m1734b(Long.parseLong(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life")));
            } catch (NumberFormatException e3) {
                C0290d.m1871e("Got bad value of Doritos cookie cache life from header: " + httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
            }
        }
        headerField2 = httpURLConnection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(headerField2)) {
            this.f2182c.m1711c(headerField2);
        }
        Object headerField4 = httpURLConnection.getHeaderField("X-Afma-Mediation");
        if (!TextUtils.isEmpty(headerField4)) {
            this.f2182c.m1706a(Boolean.valueOf(headerField4).booleanValue());
        }
        headerField2 = httpURLConnection.getHeaderField("Content-Type");
        if (!TextUtils.isEmpty(headerField2)) {
            this.f2182c.m1708b(headerField2);
        }
        headerField2 = httpURLConnection.getHeaderField("X-Afma-Ad-Size");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                split = headerField2.split("x", 2);
                if (split.length != 2) {
                    C0290d.m1871e("Could not parse size header: " + headerField2);
                    return;
                }
                this.f2182c.m1702a(new C0245g(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            } catch (NumberFormatException e4) {
                C0290d.m1871e("Could not parse size header: " + headerField2);
            }
        }
    }

    final synchronized void m1760a(String str) {
        if (this.f2186g == null) {
            this.f2185f = str;
            this.f2180a = false;
            this.f2186g = new Thread(this);
            this.f2186g.start();
        }
    }

    public final void run() {
        while (!this.f2180a) {
            HttpURLConnection a;
            try {
                a = this.f2184e.mo114a(new URL(this.f2185f));
                String string = PreferenceManager.getDefaultSharedPreferences((Context) this.f2183d.m1742g().f2015f.m1850a()).getString("drt", "");
                if (this.f2181b && !TextUtils.isEmpty(string)) {
                    if (AdUtil.f2240a == 8) {
                        a.addRequestProperty("X-Afma-drt-Cookie", string);
                    } else {
                        a.addRequestProperty(HeaderName.COOKIE, string);
                    }
                }
                AdUtil.m1829a(a, (Context) this.f2183d.m1742g().f2015f.m1850a());
                a.setInstanceFollowRedirects(false);
                a.connect();
                int responseCode = a.getResponseCode();
                if (300 <= responseCode && responseCode < 400) {
                    String headerField = a.getHeaderField("Location");
                    if (headerField == null) {
                        C0290d.m1867c("Could not get redirect location from a " + responseCode + " redirect.");
                        this.f2182c.m1701a(C0243e.INTERNAL_ERROR);
                        this.f2180a = true;
                    } else {
                        m1759a(a);
                        this.f2185f = headerField;
                    }
                } else if (responseCode == 200) {
                    m1759a(a);
                    string = AdUtil.m1824a(new InputStreamReader(a.getInputStream())).trim();
                    C0290d.m1862a("Response content is: " + string);
                    if (TextUtils.isEmpty(string)) {
                        C0290d.m1862a("Response message is null or zero length: " + string);
                        this.f2182c.m1701a(C0243e.NO_FILL);
                        this.f2180a = true;
                    } else {
                        this.f2182c.m1705a(string, this.f2185f);
                        this.f2180a = true;
                    }
                } else if (responseCode == 400) {
                    C0290d.m1867c("Bad request");
                    this.f2182c.m1701a(C0243e.INVALID_REQUEST);
                    this.f2180a = true;
                } else {
                    C0290d.m1867c("Invalid response code: " + responseCode);
                    this.f2182c.m1701a(C0243e.INTERNAL_ERROR);
                    this.f2180a = true;
                }
                a.disconnect();
            } catch (Throwable e) {
                C0290d.m1866b("Received malformed ad url from javascript.", e);
                this.f2182c.m1701a(C0243e.INTERNAL_ERROR);
                return;
            } catch (Throwable e2) {
                C0290d.m1870d("IOException connecting to ad url.", e2);
                this.f2182c.m1701a(C0243e.NETWORK_ERROR);
                return;
            } catch (Throwable e22) {
                C0290d.m1866b("An unknown error occurred in AdResponseLoader.", e22);
                this.f2182c.m1701a(C0243e.INTERNAL_ERROR);
                return;
            }
        }
    }
}
