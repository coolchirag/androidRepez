package p000a.p001a;

import com.faceture.google.play.HeaderName;
import java.util.Random;
import p000a.p001a.p002a.C0008d;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0016a;
import p000a.p001a.p004b.C0012a;
import p000a.p001a.p004b.C0013c;
import p000a.p001a.p005d.C0018f;
import p000a.p001a.p005d.C0019a;
import p000a.p001a.p005d.C0020c;
import p000a.p001a.p005d.C0021b;
import p000a.p001a.p005d.C0022d;

public abstract class C0010a implements C0009d {
    private static final long serialVersionUID = 1;
    private C0016a additionalParameters;
    private String consumerKey;
    private String consumerSecret;
    private C0020c messageSigner;
    private C0016a requestParameters;
    private boolean sendEmptyTokens;
    private C0018f signingStrategy;
    private String token;

    public C0010a(String str, String str2) {
        this.consumerKey = str;
        this.consumerSecret = str2;
        setMessageSigner(new C0021b());
        setSigningStrategy(new C0019a());
    }

    protected void collectBodyParameters(C0004b c0004b, C0016a c0016a) {
        String contentType = c0004b.getContentType();
        if (contentType != null && contentType.startsWith("application/x-www-form-urlencoded")) {
            c0016a.m23a(C0017c.m27a(c0004b.getMessagePayload()), true);
        }
    }

    protected void collectHeaderParameters(C0004b c0004b, C0016a c0016a) {
        c0016a.m23a(C0017c.m33c(c0004b.getHeader(HeaderName.AUTHORIZATION)), false);
    }

    protected void collectQueryParameters(C0004b c0004b, C0016a c0016a) {
        String requestUrl = c0004b.getRequestUrl();
        int indexOf = requestUrl.indexOf(63);
        if (indexOf >= 0) {
            c0016a.m23a(C0017c.m31b(requestUrl.substring(indexOf + 1)), true);
        }
    }

    protected void completeOAuthParameters(C0016a c0016a) {
        if (!c0016a.containsKey("oauth_consumer_key")) {
            c0016a.m22a("oauth_consumer_key", this.consumerKey, true);
        }
        if (!c0016a.containsKey("oauth_signature_method")) {
            c0016a.m22a("oauth_signature_method", this.messageSigner.mo24a(), true);
        }
        if (!c0016a.containsKey("oauth_timestamp")) {
            c0016a.m22a("oauth_timestamp", generateTimestamp(), true);
        }
        if (!c0016a.containsKey("oauth_nonce")) {
            c0016a.m22a("oauth_nonce", generateNonce(), true);
        }
        if (!c0016a.containsKey("oauth_version")) {
            c0016a.m22a("oauth_version", "1.0", true);
        }
        if (!c0016a.containsKey("oauth_token")) {
            if ((this.token != null && !this.token.equals("")) || this.sendEmptyTokens) {
                c0016a.m22a("oauth_token", this.token, true);
            }
        }
    }

    protected String generateNonce() {
        return Long.toString(new Random().nextLong());
    }

    protected String generateTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public C0016a getRequestParameters() {
        return this.requestParameters;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.messageSigner.f26c;
    }

    public void setAdditionalParameters(C0016a c0016a) {
        this.additionalParameters = c0016a;
    }

    public void setMessageSigner(C0020c c0020c) {
        this.messageSigner = c0020c;
        c0020c.f25b = this.consumerSecret;
    }

    public void setSendEmptyTokens(boolean z) {
        this.sendEmptyTokens = z;
    }

    public void setSigningStrategy(C0018f c0018f) {
        this.signingStrategy = c0018f;
    }

    public void setTokenWithSecret(String str, String str2) {
        this.token = str;
        this.messageSigner.f26c = str2;
    }

    public C0004b sign(C0004b c0004b) {
        if (this.consumerKey == null) {
            throw new C0013c("consumer key not set");
        } else if (this.consumerSecret == null) {
            throw new C0013c("consumer secret not set");
        } else {
            this.requestParameters = new C0016a();
            try {
                if (this.additionalParameters != null) {
                    this.requestParameters.m23a(this.additionalParameters, false);
                }
                collectHeaderParameters(c0004b, this.requestParameters);
                collectQueryParameters(c0004b, this.requestParameters);
                collectBodyParameters(c0004b, this.requestParameters);
                completeOAuthParameters(this.requestParameters);
                this.requestParameters.m26c("oauth_signature");
                String a = this.messageSigner.mo25a(c0004b, this.requestParameters);
                C0017c.m32b("signature", a);
                this.signingStrategy.mo23a(a, c0004b, this.requestParameters);
                C0017c.m32b("Auth header", c0004b.getHeader(HeaderName.AUTHORIZATION));
                C0017c.m32b("Request URL", c0004b.getRequestUrl());
                return c0004b;
            } catch (Exception e) {
                throw new C0012a(e);
            }
        }
    }

    public C0004b sign(Object obj) {
        return sign(wrap(obj));
    }

    public String sign(String str) {
        C0004b c0008d = new C0008d(str);
        C0018f c0018f = this.signingStrategy;
        this.signingStrategy = new C0022d();
        sign(c0008d);
        this.signingStrategy = c0018f;
        return c0008d.getRequestUrl();
    }

    protected abstract C0004b wrap(Object obj);
}
