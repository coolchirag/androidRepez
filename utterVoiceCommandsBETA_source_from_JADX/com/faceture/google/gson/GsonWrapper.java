package com.faceture.google.gson;

import com.google.gson.Gson;

public class GsonWrapper {
    private Gson gson;

    public GsonWrapper(Gson gson) {
        if (gson == null) {
            throw new IllegalArgumentException("gson is null");
        }
        this.gson = gson;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("json is null or empty");
        } else if (cls != null) {
            return this.gson.fromJson(str, (Class) cls);
        } else {
            throw new IllegalArgumentException("classOfT is null");
        }
    }

    public String toJson(Object obj) {
        if (obj != null) {
            return this.gson.toJson(obj);
        }
        throw new IllegalArgumentException("obj is null");
    }
}
