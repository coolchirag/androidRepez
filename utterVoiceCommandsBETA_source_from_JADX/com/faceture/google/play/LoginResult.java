package com.faceture.google.play;

public enum LoginResult {
    SUCCESS("Success"),
    BAD_CREDENTIALS("Bad Credentials"),
    FAILURE("Failure");
    
    private final String value;

    private LoginResult(String str) {
        this.value = str;
    }

    public final String getKey() {
        return name();
    }

    public final String toString() {
        return this.value;
    }
}
