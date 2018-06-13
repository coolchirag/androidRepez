package com.google.gson.internal;

import java.math.BigInteger;

public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    public final double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public final float floatValue() {
        return Float.parseFloat(this.value);
    }

    public final int intValue() {
        try {
            return Integer.parseInt(this.value);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.value);
            } catch (NumberFormatException e2) {
                return new BigInteger(this.value).intValue();
            }
        }
    }

    public final long longValue() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException e) {
            return new BigInteger(this.value).longValue();
        }
    }

    public final String toString() {
        return this.value;
    }
}
