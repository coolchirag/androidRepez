package com.google.p024a.p025a.p026a.p027a;

public abstract class C0223b {
    private static final ThreadLocal<char[]> f1905a = new C0225c();

    private static final char[] m1554a(char[] cArr, int i, int i2) {
        Object obj = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, obj, 0, i);
        }
        return obj;
    }

    private static int m1555b(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < '?' || charAt > '?') {
                return charAt;
            }
            if (charAt > '?') {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + charAt + " at index " + (i3 - 1));
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i3);
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    protected int mo104a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int b = C0223b.m1555b(charSequence, i, i2);
            if (b < 0 || mo106a(b) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(b) ? 2 : 1;
        }
        return i;
    }

    public String mo105a(String str) {
        int length = str.length();
        int a = mo104a((CharSequence) str, 0, length);
        return a == length ? str : m1558a(str, a);
    }

    protected final String m1558a(String str, int i) {
        int b;
        int length = str.length();
        int i2 = 0;
        char[] cArr = (char[]) f1905a.get();
        int i3 = 0;
        while (i < length) {
            b = C0223b.m1555b(str, i, length);
            if (b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            Object a = mo106a(b);
            if (a != null) {
                int i4 = i - i2;
                int length2 = (i3 + i4) + a.length;
                if (cArr.length < length2) {
                    cArr = C0223b.m1554a(cArr, i3, (length2 + (length - i)) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArr, i3);
                    i3 += i4;
                }
                if (a.length > 0) {
                    System.arraycopy(a, 0, cArr, i3, a.length);
                    i3 += a.length;
                }
            }
            b = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + i;
            i = mo104a((CharSequence) str, b, length);
            i2 = b;
        }
        b = length - i2;
        if (b > 0) {
            b += i3;
            if (cArr.length < b) {
                cArr = C0223b.m1554a(cArr, i3, b);
            }
            str.getChars(i2, length, cArr, i3);
            i3 = b;
        }
        return new String(cArr, 0, i3);
    }

    protected abstract char[] mo106a(int i);
}
