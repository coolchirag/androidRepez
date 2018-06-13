package p000a.p001a.p005d;

import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p000a.p001a.C0017c;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0016a;
import p000a.p001a.p004b.C0014d;

public final class C0021b extends C0020c {
    public final String mo24a() {
        return "HMAC-SHA1";
    }

    public final String mo25a(C0004b c0004b, C0016a c0016a) {
        try {
            Key secretKeySpec = new SecretKeySpec((C0017c.m28a(this.f25b) + '&' + C0017c.m28a(this.f26c)).getBytes("UTF-8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            String a = new C0023e(c0004b, c0016a).m43a();
            C0017c.m32b("SBS", a);
            return new String(this.f24a.encode(instance.doFinal(a.getBytes("UTF-8")))).trim();
        } catch (Exception e) {
            throw new C0014d(e);
        } catch (Exception e2) {
            throw new C0014d(e2);
        }
    }
}
