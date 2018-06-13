package winterwell.jtwitter;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import p000a.p001a.C0009d;
import p000a.p001a.C0010a;
import p000a.p001a.p002a.C0003a;
import p000a.p001a.p002a.C0005b;
import p000a.p001a.p003c.C0004b;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.TwitterException.E401;

public class OAuthSignpostClient extends URLConnectionHttpClient implements Serializable, IHttpClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!OAuthSignpostClient.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final C0003a FOURSQUARE_PROVIDER = new C0003a("http://foursquare.com/oauth/request_token", "http://foursquare.com/oauth/access_token", "http://foursquare.com/oauth/authorize");
    public static final String JTWITTER_OAUTH_KEY = "456217334-5YBpUrFErhEcR2tdALVaNTBkWi879mb7uGxTxY5e";
    public static final String JTWITTER_OAUTH_SECRET = "Xjq9eLcP9RYEtxqKgJfRc4hyrBFdTf4YRBkVJBYI";
    private static final C0003a LINKEDIN_PROVIDER = new C0003a("https://api.linkedin.com/uas/oauth/requestToken", "https://api.linkedin.com/uas/oauth/accessToken", "https://www.linkedin.com/uas/oauth/authorize");
    private static final long serialVersionUID = 1;
    private String accessToken;
    private String accessTokenSecret;
    private String callbackUrl;
    private C0009d consumer;
    private String consumerKey;
    private String consumerSecret;
    private C0003a provider;

    public OAuthSignpostClient(String str, String str2, String str3) {
        if ($assertionsDisabled || !(str == null || str2 == null || str3 == null)) {
            this.consumerKey = str;
            this.consumerSecret = str2;
            this.callbackUrl = str3;
            init();
            return;
        }
        throw new AssertionError();
    }

    public OAuthSignpostClient(String str, String str2, String str3, String str4) {
        this.consumerKey = str;
        this.consumerSecret = str2;
        this.accessToken = str3;
        this.accessTokenSecret = str4;
        init();
    }

    public static String askUser(String str) {
        try {
            return (String) Class.forName("javax.swing.JOptionPane").getMethod("showInputDialog", new Class[]{Object.class}).invoke(null, new Object[]{str});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void init() {
        this.consumer = new C0010a(this.consumerKey, this.consumerSecret) {
            private static final long serialVersionUID = 1;

            protected C0004b wrap(Object obj) {
                return obj instanceof C0004b ? (C0004b) obj : new C0005b((HttpURLConnection) obj);
            }
        };
        if (this.accessToken != null) {
            this.consumer.setTokenWithSecret(this.accessToken, this.accessTokenSecret);
        }
        this.provider = new C0003a("https://api.twitter.com/oauth/request_token", "https://api.twitter.com/oauth/access_token", "https://api.twitter.com/oauth/authorize");
    }

    @Deprecated
    public void authorizeDesktop() {
        URI authorizeUrl = authorizeUrl();
        try {
            Class cls = Class.forName("java.awt.Desktop");
            Object invoke = cls.getMethod("getDesktop", null).invoke(null, null);
            cls.getMethod("browse", new Class[]{URI.class}).invoke(invoke, new Object[]{authorizeUrl});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public URI authorizeUrl() {
        try {
            return new URI(this.provider.m6a(this.consumer, this.callbackUrl));
        } catch (Exception e) {
            throw new TwitterException(e);
        }
    }

    public boolean canAuthenticate() {
        return this.consumer.getToken() != null ? true : $assertionsDisabled;
    }

    public IHttpClient copy() {
        IHttpClient oAuthSignpostClient;
        if (this.accessToken != null) {
            oAuthSignpostClient = new OAuthSignpostClient(this.consumerKey, this.consumerSecret, this.accessToken, this.accessTokenSecret);
            oAuthSignpostClient.callbackUrl = this.callbackUrl;
        } else {
            oAuthSignpostClient = new OAuthSignpostClient(this.consumerKey, this.consumerSecret, this.callbackUrl);
        }
        oAuthSignpostClient.setTimeout(this.timeout);
        oAuthSignpostClient.setRetryOnError(this.retryOnError);
        oAuthSignpostClient.setMinRateLimit(this.minRateLimit);
        oAuthSignpostClient.rateLimits.putAll(this.rateLimits);
        return oAuthSignpostClient;
    }

    public String[] getAccessToken() {
        if (this.accessToken == null) {
            return null;
        }
        return new String[]{this.accessToken, this.accessTokenSecret};
    }

    String getName() {
        return this.name == null ? "?user" : this.name;
    }

    public HttpURLConnection post2_connect(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setReadTimeout(this.timeout);
        httpURLConnection.setConnectTimeout(this.timeout);
        final String post2_getPayload = post2_getPayload(map);
        this.consumer.sign(new C0005b(httpURLConnection) {
            public InputStream getMessagePayload() {
                return new StringBufferInputStream(post2_getPayload);
            }
        });
        Closeable outputStream = httpURLConnection.getOutputStream();
        outputStream.write(post2_getPayload.getBytes());
        URLConnectionHttpClient.close(outputStream);
        processError(httpURLConnection);
        processHeaders(httpURLConnection);
        return httpURLConnection;
    }

    protected void setAuthentication(URLConnection uRLConnection, String str, String str2) {
        try {
            this.consumer.sign((Object) uRLConnection);
        } catch (Exception e) {
            throw new TwitterException(e);
        }
    }

    public void setAuthorizationCode(String str) {
        if ($assertionsDisabled || this.accessToken == null) {
            try {
                this.provider.m8b(this.consumer, str);
                this.accessToken = this.consumer.getToken();
                this.accessTokenSecret = this.consumer.getTokenSecret();
                return;
            } catch (Exception e) {
                if (e.getMessage().contains("401")) {
                    throw new E401(e.getMessage());
                }
                throw new TwitterException(e);
            }
        }
        throw new AssertionError("This JTwitter already has an access token and is ready for use.");
    }

    public void setFoursquareProvider() {
        setProvider(FOURSQUARE_PROVIDER);
    }

    public void setLinkedInProvider() {
        setProvider(LINKEDIN_PROVIDER);
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProvider(C0003a c0003a) {
        this.provider = c0003a;
    }
}
