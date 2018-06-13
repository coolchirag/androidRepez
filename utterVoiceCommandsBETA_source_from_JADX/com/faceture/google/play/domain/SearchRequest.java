package com.faceture.google.play.domain;

public class SearchRequest {
    private String f1904q;

    public SearchRequest(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("q is null or empty");
        }
        this.f1904q = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SearchRequest searchRequest = (SearchRequest) obj;
        if (this.f1904q != null) {
            if (this.f1904q.equals(searchRequest.f1904q)) {
                return true;
            }
        } else if (searchRequest.f1904q == null) {
            return true;
        }
        return false;
    }

    public String getQ() {
        return this.f1904q;
    }

    public int hashCode() {
        return this.f1904q != null ? this.f1904q.hashCode() : 0;
    }
}
