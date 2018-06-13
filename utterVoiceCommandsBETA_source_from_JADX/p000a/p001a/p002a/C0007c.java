package p000a.p001a.p002a;

import java.io.InputStream;
import java.net.HttpURLConnection;
import p000a.p001a.p003c.C0006c;

public final class C0007c implements C0006c {
    private HttpURLConnection f18a;

    public C0007c(HttpURLConnection httpURLConnection) {
        this.f18a = httpURLConnection;
    }

    public final InputStream mo12a() {
        return this.f18a.getInputStream();
    }

    public final int mo13b() {
        return this.f18a.getResponseCode();
    }

    public final String mo14c() {
        return this.f18a.getResponseMessage();
    }
}
