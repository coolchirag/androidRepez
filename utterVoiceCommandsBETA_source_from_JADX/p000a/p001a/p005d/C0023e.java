package p000a.p001a.p005d;

import com.faceture.http.Scheme;
import java.net.URI;
import p000a.p001a.C0017c;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0016a;
import p000a.p001a.p004b.C0014d;

public final class C0023e {
    private C0004b f27a;
    private C0016a f28b;

    public C0023e(C0004b c0004b, C0016a c0016a) {
        this.f27a = c0004b;
        this.f28b = c0016a;
    }

    private String m42b() {
        if (this.f28b == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.f28b.keySet()) {
            if (!("oauth_signature".equals(str) || "realm".equals(str))) {
                if (i > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(this.f28b.m25b(str));
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public final String m43a() {
        Object obj = null;
        try {
            String substring;
            URI uri = new URI(this.f27a.getRequestUrl());
            String toLowerCase = uri.getScheme().toLowerCase();
            String toLowerCase2 = uri.getAuthority().toLowerCase();
            if ((toLowerCase.equals(Scheme.HTTP) && uri.getPort() == 80) || (toLowerCase.equals(Scheme.HTTPS) && uri.getPort() == 443)) {
                obj = 1;
            }
            if (obj != null) {
                int lastIndexOf = toLowerCase2.lastIndexOf(":");
                if (lastIndexOf >= 0) {
                    substring = toLowerCase2.substring(0, lastIndexOf);
                    toLowerCase2 = uri.getRawPath();
                    if (toLowerCase2 == null || toLowerCase2.length() <= 0) {
                        toLowerCase2 = "/";
                    }
                    return this.f27a.getMethod() + '&' + C0017c.m28a(toLowerCase + "://" + substring + toLowerCase2) + '&' + C0017c.m28a(m42b());
                }
            }
            substring = toLowerCase2;
            toLowerCase2 = uri.getRawPath();
            toLowerCase2 = "/";
            return this.f27a.getMethod() + '&' + C0017c.m28a(toLowerCase + "://" + substring + toLowerCase2) + '&' + C0017c.m28a(m42b());
        } catch (Exception e) {
            throw new C0014d(e);
        }
    }
}
