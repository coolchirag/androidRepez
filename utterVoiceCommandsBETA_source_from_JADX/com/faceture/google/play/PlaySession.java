package com.faceture.google.play;

public class PlaySession {
    private String authToken;
    private String sjsaidCookie;
    private String xtCookie;

    public PlaySession(String str, String str2, String str3) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("xtCookie is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("sjsaidCookie is null or empty");
        } else if (str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException("authToken is null or empty");
        } else {
            this.xtCookie = str;
            this.sjsaidCookie = str2;
            this.authToken = str3;
        }
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getSjsaidCookie() {
        return this.sjsaidCookie;
    }

    public String getXtCookie() {
        return this.xtCookie;
    }
}
