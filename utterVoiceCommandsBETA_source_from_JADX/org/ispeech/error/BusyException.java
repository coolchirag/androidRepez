package org.ispeech.error;

public class BusyException extends Exception {
    private static final long serialVersionUID = -7684356352903689318L;

    public BusyException(String str) {
        super(str);
    }
}
