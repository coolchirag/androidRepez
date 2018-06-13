package com.nuance.nmdp.speechkit;

public interface Recognition {

    public interface Result {
        int getScore();

        String getText();
    }

    Result getResult(int i);

    int getResultCount();

    String getSuggestion();
}
