package com.faceture.google.play;

public class LoginResponseFactory {
    public LoginResponse create(LoginResult loginResult, PlaySession playSession) {
        return new LoginResponse(loginResult, playSession);
    }
}
