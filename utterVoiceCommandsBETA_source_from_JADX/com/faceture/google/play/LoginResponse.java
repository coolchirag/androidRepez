package com.faceture.google.play;

public class LoginResponse {
    private LoginResult loginResult;
    private PlaySession playSession;

    public LoginResponse(LoginResult loginResult, PlaySession playSession) {
        if (loginResult == null) {
            throw new IllegalArgumentException("loginResult is null");
        }
        if (LoginResult.SUCCESS == loginResult) {
            if (playSession == null) {
                throw new IllegalArgumentException("When loginResult is SUCCESS, must provide a PlaySession");
            }
        } else if (playSession != null) {
            throw new IllegalArgumentException("playSession must be null when loginResult is not SUCCESS");
        }
        this.loginResult = loginResult;
        this.playSession = playSession;
    }

    public LoginResult getLoginResult() {
        return this.loginResult;
    }

    public PlaySession getPlaySession() {
        return this.playSession;
    }
}
