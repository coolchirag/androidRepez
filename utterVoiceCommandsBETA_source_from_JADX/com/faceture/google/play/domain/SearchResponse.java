package com.faceture.google.play.domain;

public class SearchResponse {
    private SearchResults results;

    public SearchResults getResults() {
        return this.results;
    }

    public void setResults(SearchResults searchResults) {
        this.results = searchResults;
    }
}
