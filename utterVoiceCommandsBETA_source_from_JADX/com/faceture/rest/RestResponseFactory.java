package com.faceture.rest;

import java.util.Map;

public class RestResponseFactory {
    public RestResponse create(int i, Map<String, String> map, Map<String, String> map2, String str) {
        return new RestResponse(i, map, map2, str);
    }
}
