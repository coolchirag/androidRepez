package com.google.ads;

public enum C0243e {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");
    
    private final String f2065e;

    private C0243e(String str) {
        this.f2065e = str;
    }

    public final String toString() {
        return this.f2065e;
    }
}
