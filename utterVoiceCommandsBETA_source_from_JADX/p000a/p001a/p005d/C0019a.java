package p000a.p001a.p005d;

import com.faceture.google.play.HeaderName;
import p000a.p001a.C0017c;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0016a;

public final class C0019a implements C0018f {
    public final String mo23a(String str, C0004b c0004b, C0016a c0016a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth ");
        if (c0016a.containsKey("realm")) {
            stringBuilder.append(c0016a.m20a("realm"));
            stringBuilder.append(", ");
        }
        if (c0016a.containsKey("oauth_token")) {
            stringBuilder.append(c0016a.m20a("oauth_token"));
            stringBuilder.append(", ");
        }
        if (c0016a.containsKey("oauth_callback")) {
            stringBuilder.append(c0016a.m20a("oauth_callback"));
            stringBuilder.append(", ");
        }
        if (c0016a.containsKey("oauth_verifier")) {
            stringBuilder.append(c0016a.m20a("oauth_verifier"));
            stringBuilder.append(", ");
        }
        stringBuilder.append(c0016a.m20a("oauth_consumer_key"));
        stringBuilder.append(", ");
        stringBuilder.append(c0016a.m20a("oauth_version"));
        stringBuilder.append(", ");
        stringBuilder.append(c0016a.m20a("oauth_signature_method"));
        stringBuilder.append(", ");
        stringBuilder.append(c0016a.m20a("oauth_timestamp"));
        stringBuilder.append(", ");
        stringBuilder.append(c0016a.m20a("oauth_nonce"));
        stringBuilder.append(", ");
        stringBuilder.append(C0017c.m29a("oauth_signature", str));
        String stringBuilder2 = stringBuilder.toString();
        c0004b.setHeader(HeaderName.AUTHORIZATION, stringBuilder2);
        return stringBuilder2;
    }
}
