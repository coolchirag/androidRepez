package com.faceture.google.play.domain;

public class PlayDomainFactory {
    public SearchRequest createSearchRequest(String str) {
        if (str != null && !str.isEmpty()) {
            return new SearchRequest(str);
        }
        throw new IllegalArgumentException("q is null or empty");
    }
}
