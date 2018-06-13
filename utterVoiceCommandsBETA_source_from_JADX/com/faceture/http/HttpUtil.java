package com.faceture.http;

import com.faceture.google.play.HeaderName;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
    private HttpClientFactory httpClientFactory;

    public HttpUtil(HttpClientFactory httpClientFactory) {
        if (httpClientFactory == null) {
            throw new IllegalArgumentException("httpClientFactory is null");
        }
        this.httpClientFactory = httpClientFactory;
    }

    public HttpResponse execute(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        if (httpClient == null) {
            throw new IllegalArgumentException("httpClient is null");
        } else if (httpRequestBase != null) {
            return httpClient.execute(httpRequestBase);
        } else {
            throw new IllegalArgumentException("httpRequest is null");
        }
    }

    public Map<String, String> getCookies(DefaultHttpClient defaultHttpClient) {
        if (defaultHttpClient == null) {
            throw new IllegalArgumentException("defaultHttpClient is null");
        }
        List<Cookie> cookies = defaultHttpClient.getCookieStore().getCookies();
        Map<String, String> hashMap = new HashMap();
        for (Cookie cookie : cookies) {
            hashMap.put(cookie.getName(), cookie.getValue());
        }
        return hashMap;
    }

    public Map<String, String> getHeaders(HttpResponse httpResponse) {
        if (httpResponse == null) {
            throw new IllegalArgumentException("httpResponse is null");
        }
        Header[] allHeaders = httpResponse.getAllHeaders();
        Map<String, String> hashMap = new HashMap();
        for (Header header : allHeaders) {
            hashMap.put(header.getName(), header.getValue());
        }
        return hashMap;
    }

    public String getQueryString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("queryParams is null or empty");
        }
        List arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return URLEncodedUtils.format(arrayList, "UTF-8");
    }

    public String getResponseString(HttpResponse httpResponse) {
        if (httpResponse != null) {
            return EntityUtils.toString(httpResponse.getEntity());
        }
        throw new IllegalArgumentException("httpResponse is null");
    }

    public void setCookies(HttpRequestBase httpRequestBase, Map<String, String> map) {
        if (httpRequestBase == null) {
            throw new IllegalArgumentException("httpRequest is null");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("cookies is null or empty");
        } else {
            httpRequestBase.getParams().setParameter("http.protocol.cookie-policy", "best-match");
            String str = "";
            for (Entry entry : map.entrySet()) {
                Object stringBuilder;
                if (str.isEmpty()) {
                    String str2 = str;
                } else {
                    stringBuilder = new StringBuilder(String.valueOf(str)).append("; ").toString();
                }
                str = new StringBuilder(String.valueOf(stringBuilder)).append((String) entry.getKey()).append("=").append((String) entry.getValue()).toString();
            }
            httpRequestBase.addHeader(HeaderName.COOKIE, str);
        }
    }

    public void setFormData(HttpPost httpPost, Map<String, String> map) {
        if (httpPost == null) {
            throw new IllegalArgumentException("httpPost is null");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("formData is null or empty");
        } else {
            HttpEntity createMultipartEntity = this.httpClientFactory.createMultipartEntity();
            for (Entry entry : map.entrySet()) {
                createMultipartEntity.m2844a((String) entry.getKey(), this.httpClientFactory.createStringBody((String) entry.getValue()));
            }
            httpPost.setEntity(createMultipartEntity);
        }
    }

    public void setHeaders(HttpRequestBase httpRequestBase, Map<String, String> map) {
        if (httpRequestBase == null) {
            throw new IllegalArgumentException("httpRequest is null");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("headers is null or empty");
        } else {
            for (Entry entry : map.entrySet()) {
                httpRequestBase.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public void setUri(HttpRequestBase httpRequestBase, boolean z, String str, String str2, String str3) {
        if (httpRequestBase == null) {
            throw new IllegalArgumentException("httpRequest is null");
        } else if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("hostName is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty");
        } else {
            String str4 = z ? Scheme.HTTPS : Scheme.HTTP;
            URL url = (str3 == null || str3.isEmpty()) ? new URL(str4, str, str2) : new URL(str4, str, new StringBuilder(String.valueOf(str2)).append("?").append(str3).toString());
            httpRequestBase.setURI(url.toURI());
        }
    }
}
