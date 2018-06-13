package p000a.p001a.p005d;

import p000a.p001a.C0017c;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0016a;

public final class C0022d implements C0018f {
    public final String mo23a(String str, C0004b c0004b, C0016a c0016a) {
        StringBuilder stringBuilder = new StringBuilder(C0017c.m30a(c0004b.getRequestUrl(), "oauth_signature", str));
        if (c0016a.containsKey("oauth_token")) {
            stringBuilder.append("&");
            stringBuilder.append(c0016a.m25b("oauth_token"));
        }
        if (c0016a.containsKey("oauth_callback")) {
            stringBuilder.append("&");
            stringBuilder.append(c0016a.m25b("oauth_callback"));
        }
        if (c0016a.containsKey("oauth_verifier")) {
            stringBuilder.append("&");
            stringBuilder.append(c0016a.m25b("oauth_verifier"));
        }
        stringBuilder.append("&");
        stringBuilder.append(c0016a.m25b("oauth_consumer_key"));
        stringBuilder.append("&");
        stringBuilder.append(c0016a.m25b("oauth_version"));
        stringBuilder.append("&");
        stringBuilder.append(c0016a.m25b("oauth_signature_method"));
        stringBuilder.append("&");
        stringBuilder.append(c0016a.m25b("oauth_timestamp"));
        stringBuilder.append("&");
        stringBuilder.append(c0016a.m25b("oauth_nonce"));
        String stringBuilder2 = stringBuilder.toString();
        c0004b.setRequestUrl(stringBuilder2);
        return stringBuilder2;
    }
}
