package org.ispeech.error;

public class ApiException extends Exception {
    private static final long serialVersionUID = 2883987552548504763L;

    public ApiException(String str) {
        super(str);
    }
}
