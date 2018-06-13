package com.faceture.google;

import com.faceture.google.play.Const;

public class GoogleUtil {
    public String createAuthHeaderValue(String str) {
        if (str != null && !str.isEmpty()) {
            return new StringBuilder(GoogleConst.AUTH_HEADER_START).append(str).toString();
        }
        throw new IllegalArgumentException("authToken is null or empty");
    }

    public String getAuthTokenFromLoginResponse(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("loginResponseBody is null or empty");
        }
        int indexOf = str.indexOf(Const.GOOLE_LOGIN_AUTH) + 5;
        return str.substring(indexOf, str.indexOf("\n", indexOf));
    }
}
