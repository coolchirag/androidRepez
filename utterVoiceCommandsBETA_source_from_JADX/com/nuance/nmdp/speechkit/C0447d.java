package com.nuance.nmdp.speechkit;

final class C0447d implements SpeechError {
    private final int f2664a;
    private final String f2665b;
    private final String f2666c;

    public C0447d(int i, String str, String str2) {
        this.f2664a = i;
        this.f2666c = str2;
        if (str == null) {
            switch (i) {
                case 1:
                    str = "Failed to connect to speech server.";
                    break;
                case 2:
                    str = "Please retry your query.";
                    break;
                case 5:
                    str = "Query cancelled.";
                    break;
                default:
                    str = "An error occurred.";
                    break;
            }
        }
        this.f2665b = str;
    }

    public final int getErrorCode() {
        return this.f2664a;
    }

    public final String getErrorDetail() {
        return this.f2665b;
    }

    public final String getSuggestion() {
        return this.f2666c;
    }
}
