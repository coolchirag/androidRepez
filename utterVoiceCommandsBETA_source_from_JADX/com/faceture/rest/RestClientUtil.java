package com.faceture.rest;

import com.faceture.http.HttpClientFactory;
import com.faceture.http.HttpUtil;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public class RestClientUtil {
    private HttpClientFactory httpClientFactory;
    private HttpUtil httpUtil;
    private RestResponseFactory restResponseFactory;

    public RestClientUtil(HttpClientFactory httpClientFactory, HttpUtil httpUtil, RestResponseFactory restResponseFactory) {
        if (httpClientFactory == null) {
            throw new IllegalArgumentException("httpClientFactory is null");
        } else if (httpUtil == null) {
            throw new IllegalArgumentException("httpUtil is null");
        } else if (restResponseFactory == null) {
            throw new IllegalArgumentException("restResponseFactory is null");
        } else {
            this.httpClientFactory = httpClientFactory;
            this.httpUtil = httpUtil;
            this.restResponseFactory = restResponseFactory;
        }
    }

    public RestResponse doRequest(HttpRequestBase httpRequestBase, boolean z, String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        if (httpRequestBase == null) {
            throw new IllegalArgumentException("httpRequest is null");
        } else if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("hostName is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty");
        } else {
            if (!(map2 == null || map2.isEmpty())) {
                this.httpUtil.setHeaders(httpRequestBase, map2);
            }
            httpRequestBase.setHeader("User-Agent", "");
            String str3 = null;
            if (!(map == null || map.isEmpty())) {
                str3 = this.httpUtil.getQueryString(map);
            }
            this.httpUtil.setUri(httpRequestBase, z, str, str2, str3);
            Object createHttpClient = this.httpClientFactory.createHttpClient();
            if (!(map3 == null || map3.isEmpty())) {
                this.httpUtil.setCookies(httpRequestBase, map3);
            }
            HttpResponse execute = this.httpUtil.execute(createHttpClient, httpRequestBase);
            String responseString = this.httpUtil.getResponseString(execute);
            return this.restResponseFactory.create(execute.getStatusLine().getStatusCode(), this.httpUtil.getCookies(createHttpClient), this.httpUtil.getHeaders(execute), responseString);
        }
    }
}
