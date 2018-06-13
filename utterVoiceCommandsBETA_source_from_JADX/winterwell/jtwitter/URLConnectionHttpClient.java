package winterwell.jtwitter;

import com.faceture.google.play.HeaderName;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.Twitter.KRequestType;
import winterwell.jtwitter.TwitterException.AccessLevel;
import winterwell.jtwitter.TwitterException.BadParameter;
import winterwell.jtwitter.TwitterException.E401;
import winterwell.jtwitter.TwitterException.E403;
import winterwell.jtwitter.TwitterException.E404;
import winterwell.jtwitter.TwitterException.E406;
import winterwell.jtwitter.TwitterException.E413;
import winterwell.jtwitter.TwitterException.E416;
import winterwell.jtwitter.TwitterException.E50X;
import winterwell.jtwitter.TwitterException.FollowerLimit;
import winterwell.jtwitter.TwitterException.IO;
import winterwell.jtwitter.TwitterException.RateLimit;
import winterwell.jtwitter.TwitterException.Repetition;
import winterwell.jtwitter.TwitterException.SuspendedUser;
import winterwell.jtwitter.TwitterException.Timeout;
import winterwell.jtwitter.TwitterException.TooManyLogins;
import winterwell.jtwitter.TwitterException.TooRecent;
import winterwell.jtwitter.TwitterException.UpdateToOAuth;
import winterwell.jtwitter.guts.Base64Encoder;
import winterwell.jtwitter.guts.ClientHttpRequest;

public class URLConnectionHttpClient implements Serializable, IHttpClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!URLConnectionHttpClient.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final int dfltTimeOutMilliSecs = 10000;
    private static final long serialVersionUID = 1;
    private Map<String, List<String>> headers;
    private boolean htmlImpliesError;
    int minRateLimit;
    protected String name;
    private final String password;
    final Map<KRequestType, RateLimit> rateLimits;
    boolean retryOnError;
    protected int timeout;

    public URLConnectionHttpClient() {
        this(null, null);
    }

    public URLConnectionHttpClient(String str, String str2) {
        this.rateLimits = new EnumMap(KRequestType.class);
        this.timeout = dfltTimeOutMilliSecs;
        this.htmlImpliesError = true;
        this.name = str;
        this.password = str2;
        if (!$assertionsDisabled) {
            if (str != null && str2 != null) {
                return;
            }
            if (str != null || str2 != null) {
                throw new AssertionError();
            }
        }
    }

    protected static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.getClass().getMethod("flush", new Class[0]).invoke(closeable, new Object[0]);
            } catch (Exception e) {
            }
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    private String getErrorStream(HttpURLConnection httpURLConnection) {
        try {
            return InternalUtils.toString(httpURLConnection.getErrorStream());
        } catch (NullPointerException e) {
            return null;
        }
    }

    private String getPage2(String str, Map<String, String> map, boolean z) {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = connect(str, map, z);
            String internalUtils = InternalUtils.toString(httpURLConnection.getInputStream());
            return internalUtils;
        } finally {
            disconnect(httpURLConnection);
        }
    }

    private TwitterException getPage2_ex(Exception exception, String str) {
        return exception instanceof TwitterException ? (TwitterException) exception : exception instanceof SocketTimeoutException ? new Timeout(str) : exception instanceof IOException ? new IO((IOException) exception) : new TwitterException(exception);
    }

    private String post2(String str, Map<String, String> map, boolean z) {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = post2_connect(str, map);
            String internalUtils = InternalUtils.toString(httpURLConnection.getInputStream());
            return internalUtils;
        } finally {
            disconnect(httpURLConnection);
        }
    }

    private void processError2_403(URL url, String str) {
        String str2 = this.name == null ? "anon" : this.name;
        if (str == null) {
            throw new E403(url + " (" + str2 + ")");
        } else if (str.contains("too old")) {
            throw new BadParameter(new StringBuilder(String.valueOf(str)).append("\n").append(url).toString());
        } else if (str.contains("suspended")) {
            throw new SuspendedUser(new StringBuilder(String.valueOf(str)).append("\n").append(url).toString());
        } else if (str.contains("Could not find")) {
            throw new SuspendedUser(new StringBuilder(String.valueOf(str)).append("\n").append(url).toString());
        } else if (str.contains("too recent")) {
            throw new TooRecent(new StringBuilder(String.valueOf(str)).append("\n").append(url).toString());
        } else if (str.contains("already requested to follow")) {
            throw new Repetition(new StringBuilder(String.valueOf(str)).append("\n").append(url).toString());
        } else if (str.contains("duplicate")) {
            throw new Repetition(str);
        } else if (str.contains("unable to follow more people")) {
            throw new FollowerLimit(this.name + " " + str);
        } else if (str.contains("application is not allowed to access")) {
            throw new AccessLevel(this.name + " " + str);
        } else {
            throw new E403(new StringBuilder(String.valueOf(str)).append("\n").append(url).append(" (").append(str2).append(")").toString());
        }
    }

    private void processError2_rateLimit(HttpURLConnection httpURLConnection, int i, String str) {
        if (str.contains("Rate limit exceeded")) {
            processHeaders(httpURLConnection);
            throw new RateLimit(getName() + ": " + str);
        } else if (i == 400) {
            try {
                if (new JSONObject(getPage("http://twitter.com/account/rate_limit_status.json", null, this.password != null ? true : $assertionsDisabled)).getInt("remaining_hits") <= 0) {
                    throw new RateLimit(str);
                }
            } catch (Exception e) {
            }
        }
    }

    private String processError2_reason(HttpURLConnection httpURLConnection) {
        String read;
        String string;
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream != null) {
            try {
                read = read(errorStream);
                try {
                    string = new JSONObject(read).getString("error");
                    if (!(string == null || string.length() == 0)) {
                        return string;
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                read = null;
            }
            string = read;
        } else {
            string = null;
        }
        String responseMessage = httpURLConnection.getResponseMessage();
        List list = (List) httpURLConnection.getHeaderFields().get(null);
        read = (list == null || list.isEmpty()) ? responseMessage : new StringBuilder(String.valueOf(responseMessage)).append("\n").append((String) list.get(0)).toString();
        return (string == null || string.isEmpty()) ? read : new StringBuilder(String.valueOf(read)).append("\n").append(string).toString();
    }

    static String read(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder(8192);
            char[] cArr = new char[8192];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringBuilder.append(cArr, 0, read);
            }
            String stringBuilder2 = stringBuilder.toString();
            return stringBuilder2;
        } finally {
            inputStream.close();
        }
    }

    public boolean canAuthenticate() {
        return (this.name == null || this.password == null) ? $assertionsDisabled : true;
    }

    public HttpURLConnection connect(String str, Map<String, String> map, boolean z) {
        if (!(map == null || map.size() == 0)) {
            StringBuilder stringBuilder = new StringBuilder(str);
            if (str.indexOf(63) == -1) {
                stringBuilder.append("?");
            } else if (!str.endsWith("&")) {
                stringBuilder.append("&");
            }
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    String encode = InternalUtils.encode(entry.getKey());
                    if ($assertionsDisabled || !str.contains(new StringBuilder(String.valueOf(encode)).append("=").toString())) {
                        stringBuilder.append(new StringBuilder(String.valueOf(encode)).append("=").append(InternalUtils.encode(entry.getValue())).append("&").toString());
                    } else {
                        throw new AssertionError(new StringBuilder(String.valueOf(str)).append(" ").append(map).toString());
                    }
                }
            }
            str = stringBuilder.toString();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (z) {
            setAuthentication(httpURLConnection, this.name, this.password);
        }
        httpURLConnection.setRequestProperty("User-Agent", "JTwitter/2.6.5");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(this.timeout);
        httpURLConnection.setReadTimeout(this.timeout);
        httpURLConnection.setConnectTimeout(this.timeout);
        processError(httpURLConnection);
        processHeaders(httpURLConnection);
        return httpURLConnection;
    }

    public IHttpClient copy() {
        IHttpClient uRLConnectionHttpClient = new URLConnectionHttpClient(this.name, this.password);
        uRLConnectionHttpClient.setTimeout(this.timeout);
        uRLConnectionHttpClient.setRetryOnError(this.retryOnError);
        uRLConnectionHttpClient.setMinRateLimit(this.minRateLimit);
        uRLConnectionHttpClient.rateLimits.putAll(this.rateLimits);
        return uRLConnectionHttpClient;
    }

    protected final void disconnect(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
            }
        }
    }

    public String getHeader(String str) {
        if (this.headers == null) {
            return null;
        }
        List list = (List) this.headers.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    String getName() {
        return this.name;
    }

    public final String getPage(String str, Map<String, String> map, boolean z) {
        if ($assertionsDisabled || str != null) {
            String page2;
            InternalUtils.count(str);
            try {
                page2 = getPage2(str, map, z);
                if (this.htmlImpliesError && ((page2.startsWith("<!DOCTYPE html") || page2.startsWith("<html")) && !str.startsWith("http://twitter.com"))) {
                    throw new E50X(InternalUtils.stripTags(page2));
                }
            } catch (Exception e) {
                if (this.retryOnError) {
                    try {
                        Thread.sleep(500);
                        page2 = getPage2(str, map, z);
                    } catch (Exception e2) {
                        throw getPage2_ex(e, str);
                    }
                }
                throw getPage2_ex(e, str);
            } catch (Exception e3) {
                if (this.retryOnError) {
                    try {
                        Thread.sleep(500);
                        page2 = getPage2(str, map, z);
                    } catch (Exception e4) {
                        throw getPage2_ex(e3, str);
                    }
                }
                throw getPage2_ex(e3, str);
            } catch (IOException e5) {
                throw new IO(e5);
            }
            return page2;
        }
        throw new AssertionError();
    }

    public RateLimit getRateLimit(KRequestType kRequestType) {
        return (RateLimit) this.rateLimits.get(kRequestType);
    }

    public boolean isRetryOnError() {
        return this.retryOnError;
    }

    public final String post(String str, Map<String, String> map, boolean z) {
        String post2;
        InternalUtils.count(str);
        try {
            post2 = post2(str, map, z);
        } catch (Exception e) {
            if (this.retryOnError) {
                try {
                    Thread.sleep(500);
                    post2 = post2(str, map, z);
                } catch (Exception e2) {
                    throw getPage2_ex(e, str);
                }
            }
            throw getPage2_ex(e, str);
        } catch (Exception e3) {
            if (this.retryOnError) {
                try {
                    Thread.sleep(500);
                    post2 = post2(str, map, z);
                } catch (Exception e4) {
                    throw getPage2_ex(e3, str);
                }
            }
            throw getPage2_ex(e3, str);
        } catch (Exception e32) {
            throw getPage2_ex(e32, str);
        }
        return post2;
    }

    public HttpURLConnection post2_connect(String str, Map<String, String> map) {
        InternalUtils.count(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        setAuthentication(httpURLConnection, this.name, this.password);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setReadTimeout(this.timeout);
        httpURLConnection.setConnectTimeout(this.timeout);
        String post2_getPayload = post2_getPayload(map);
        httpURLConnection.setRequestProperty("Content-Length", post2_getPayload.length());
        Closeable outputStream = httpURLConnection.getOutputStream();
        outputStream.write(post2_getPayload.getBytes());
        close(outputStream);
        processError(httpURLConnection);
        processHeaders(httpURLConnection);
        return httpURLConnection;
    }

    protected String post2_getPayload(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            String encode = InternalUtils.encode(map.get(str));
            stringBuilder.append(InternalUtils.encode(str));
            stringBuilder.append('=');
            stringBuilder.append(encode);
            stringBuilder.append('&');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public final String postMultipartForm(String str, Map<String, ?> map) {
        try {
            URLConnection uRLConnection = (HttpURLConnection) new URL(str).openConnection();
            setAuthentication(uRLConnection, this.name, this.password);
            InputStream post = new ClientHttpRequest(uRLConnection).post((Map) map);
            processError(uRLConnection);
            return InternalUtils.toString(post);
        } catch (TwitterException e) {
            throw e;
        } catch (Exception e2) {
            throw new TwitterException(e2);
        }
    }

    final void processError(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                URL url = httpURLConnection.getURL();
                String processError2_reason = processError2_reason(httpURLConnection);
                if (responseCode != 401) {
                    if (responseCode == 403) {
                        processError2_403(url, processError2_reason);
                    }
                    if (responseCode == 404) {
                        if (processError2_reason == null || !processError2_reason.contains("deleted")) {
                            throw new E404(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                        }
                        throw new SuspendedUser(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                    } else if (responseCode == 406) {
                        throw new E406(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                    } else if (responseCode == 413) {
                        throw new E413(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                    } else if (responseCode == 416) {
                        throw new E416(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                    } else if (responseCode == 420) {
                        throw new TooManyLogins(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                    } else if (responseCode < 500 || responseCode >= 600) {
                        processError2_rateLimit(httpURLConnection, responseCode, processError2_reason);
                        if (responseCode <= 299 || responseCode >= 400) {
                            throw new TwitterException(new StringBuilder(String.valueOf(responseCode)).append(" ").append(processError2_reason).append(" ").append(url).toString());
                        }
                        throw new TwitterException(new StringBuilder(String.valueOf(responseCode)).append(" ").append(processError2_reason).append(" ").append(url).append(" -> ").append(httpURLConnection.getHeaderField("Location")).toString());
                    } else {
                        throw new E50X(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).toString());
                    }
                } else if (processError2_reason.contains("Basic authentication is not supported")) {
                    throw new UpdateToOAuth();
                } else {
                    throw new E401(new StringBuilder(String.valueOf(processError2_reason)).append("\n").append(url).append(" (").append(this.name == null ? "anonymous" : this.name).append(")").toString());
                }
            }
        } catch (SocketTimeoutException e) {
            throw new Timeout(this.timeout + "milli-secs for " + httpURLConnection.getURL());
        } catch (ConnectException e2) {
            throw new Timeout(httpURLConnection.getURL().toString());
        } catch (SocketException e3) {
            throw new E50X(e3.toString());
        } catch (Exception e4) {
            throw new TwitterException(e4);
        }
    }

    protected final void processHeaders(HttpURLConnection httpURLConnection) {
        this.headers = httpURLConnection.getHeaderFields();
        updateRateLimits();
    }

    protected void setAuthentication(URLConnection uRLConnection, String str, String str2) {
        if ($assertionsDisabled || !(str == null || str2 == null)) {
            uRLConnection.setRequestProperty(HeaderName.AUTHORIZATION, "Basic " + Base64Encoder.encode(new StringBuilder(String.valueOf(str)).append(":").append(str2).toString()));
            return;
        }
        throw new AssertionError("Authentication requested but no login details are set!");
    }

    public void setHtmlImpliesError(boolean z) {
        this.htmlImpliesError = z;
    }

    public void setMinRateLimit(int i) {
        this.minRateLimit = i;
    }

    public void setRetryOnError(boolean z) {
        this.retryOnError = z;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append("[name=").append(this.name).append(", password=").append(this.password == null ? "null" : "XXX").append("]").toString();
    }

    void updateRateLimits() {
        for (KRequestType kRequestType : KRequestType.values()) {
            String header = getHeader("X-" + kRequestType.rateLimit + "RateLimit-Limit");
            if (header != null) {
                this.rateLimits.put(kRequestType, new RateLimit(header, getHeader("X-" + kRequestType.rateLimit + "RateLimit-Remaining"), getHeader("X-" + kRequestType.rateLimit + "RateLimit-Reset")));
                if (this.minRateLimit > 0 && Integer.valueOf(header).intValue() <= this.minRateLimit) {
                    throw new RateLimit("Pre-emptive rate-limit block.");
                }
            }
        }
    }
}
