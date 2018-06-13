package com.faceture.rest;

import java.util.Map;

public class RestResponse {
    private String body;
    private Map<String, String> cookies;
    private Map<String, String> headers;
    private int statusCode;

    public RestResponse(int i, Map<String, String> map, Map<String, String> map2, String str) {
        this.statusCode = i;
        this.cookies = map;
        this.headers = map2;
        this.body = str;
    }

    public String getBody() {
        return this.body;
    }

    public Map<String, String> getCookies() {
        return this.cookies;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
