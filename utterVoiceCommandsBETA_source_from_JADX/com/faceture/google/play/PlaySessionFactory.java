package com.faceture.google.play;

public class PlaySessionFactory {
    public PlaySession create(String str, String str2, String str3) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("xtCookie is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("sjsaidCookie is null or empty");
        } else if (str3 != null && !str3.isEmpty()) {
            return new PlaySession(str, str2, str3);
        } else {
            throw new IllegalArgumentException("authToken is null or empty");
        }
    }
}
