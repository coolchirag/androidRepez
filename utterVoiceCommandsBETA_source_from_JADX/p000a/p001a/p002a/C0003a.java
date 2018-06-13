package p000a.p001a.p002a;

import com.faceture.google.play.QueryParamConst;
import java.net.HttpURLConnection;
import java.net.URL;
import p000a.p001a.C0002b;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0006c;

public final class C0003a extends C0002b {
    public C0003a(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    protected final C0004b mo1a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setRequestProperty("Content-Length", QueryParamConst.U_VALUE);
        return new C0005b(httpURLConnection);
    }

    protected final C0006c mo2a(C0004b c0004b) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) c0004b.unwrap();
        httpURLConnection.connect();
        return new C0007c(httpURLConnection);
    }

    protected final void mo3b(C0004b c0004b) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) c0004b.unwrap();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
