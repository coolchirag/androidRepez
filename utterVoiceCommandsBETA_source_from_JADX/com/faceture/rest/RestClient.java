package com.faceture.rest;

import com.faceture.http.HttpClientFactory;
import com.faceture.http.HttpUtil;
import java.util.Map;
import org.apache.http.client.methods.HttpRequestBase;

public class RestClient {
    private HttpClientFactory httpClientFactory;
    private HttpUtil httpUtil;
    private RestClientUtil restClientUtil;

    public RestClient(HttpClientFactory httpClientFactory, HttpUtil httpUtil, RestClientUtil restClientUtil) {
        if (httpClientFactory == null) {
            throw new IllegalArgumentException("httpClientFactory is null");
        } else if (httpUtil == null) {
            throw new IllegalArgumentException("httpUtil is null");
        } else if (restClientUtil == null) {
            throw new IllegalArgumentException("restClientUtil is null");
        } else {
            this.httpClientFactory = httpClientFactory;
            this.httpUtil = httpUtil;
            this.restClientUtil = restClientUtil;
        }
    }

    public RestResponse doGet(boolean z, String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("hostName is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty");
        } else {
            return this.restClientUtil.doRequest(this.httpClientFactory.createHttpGet(), z, str, str2, map, map2, map3);
        }
    }

    public RestResponse doPost(boolean z, String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("hostName is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty");
        } else {
            HttpRequestBase createHttpPost = this.httpClientFactory.createHttpPost();
            if (!(map4 == null || map4.isEmpty())) {
                this.httpUtil.setFormData(createHttpPost, map4);
            }
            return this.restClientUtil.doRequest(createHttpPost, z, str, str2, map, map2, map3);
        }
    }
}
