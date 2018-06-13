package org.ispeech.error;

public class NoNetworkException extends Exception {
    private static final long serialVersionUID = 4852493392525365174L;

    public NoNetworkException(String str) {
        super(str);
    }
}
