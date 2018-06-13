package org.ispeech.tools;

public class Base64Coder {
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];
    private static final String systemLineSeparator = System.getProperty("line.separator");

    static {
        int i;
        int i2 = 0;
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            map1[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            map1[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            map1[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        map1[i3] = '+';
        map1[i] = '/';
        for (int i4 = 0; i4 < map2.length; i4++) {
            map2[i4] = (byte) -1;
        }
        while (i2 < 64) {
            map2[map1[i2]] = (byte) i2;
            i2++;
        }
    }

    private Base64Coder() {
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static byte[] decode(char[] cArr) {
        return decode(cArr, 0, cArr.length);
    }

    public static byte[] decode(char[] cArr, int i, int i2) {
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = i + i2;
        int i5 = i;
        int i6 = 0;
        while (i5 < i4) {
            int i7;
            int i8 = i5 + 1;
            char c = cArr[i5];
            int i9 = i8 + 1;
            char c2 = cArr[i8];
            if (i9 < i4) {
                i8 = i9 + 1;
                i7 = cArr[i9];
                i9 = i8;
            } else {
                i7 = 65;
            }
            if (i9 < i4) {
                i8 = i9 + 1;
                i9 = cArr[i9];
                i5 = i8;
            } else {
                i5 = i9;
                i9 = 65;
            }
            if (c > '' || c2 > '' || i7 > 127 || i9 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = map2[c];
            byte b2 = map2[c2];
            byte b3 = map2[i7];
            byte b4 = map2[i9];
            if (b < (byte) 0 || b2 < (byte) 0 || b3 < (byte) 0 || b4 < (byte) 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i10 = (b2 >>> 4) | (b << 2);
            int i11 = (b3 >>> 2) | ((b2 & 15) << 4);
            i7 = ((b3 & 3) << 6) | b4;
            i8 = i6 + 1;
            bArr[i6] = (byte) i10;
            if (i8 < i3) {
                i9 = i8 + 1;
                bArr[i8] = (byte) i11;
            } else {
                i9 = i8;
            }
            if (i9 < i3) {
                i8 = i9 + 1;
                bArr[i9] = (byte) i7;
                i6 = i8;
            } else {
                i6 = i9;
            }
        }
        return bArr;
    }

    public static byte[] decodeLines(String str) {
        char[] cArr = new char[str.length()];
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!(charAt == ' ' || charAt == '\r' || charAt == '\n' || charAt == '\t')) {
                int i3 = i + 1;
                cArr[i] = charAt;
                i = i3;
            }
        }
        return decode(cArr, 0, i);
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static char[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, i);
    }

    public static char[] encode(byte[] bArr, int i, int i2) {
        int i3 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            int i8 = i + 1;
            int i9 = bArr[i] & 255;
            if (i8 < i4) {
                i6 = bArr[i8] & 255;
                i8++;
            } else {
                i6 = 0;
            }
            if (i8 < i4) {
                i7 = i8 + 1;
                i8 = bArr[i8] & 255;
            } else {
                i7 = i8;
                i8 = 0;
            }
            int i10 = i9 >>> 2;
            i9 = ((i9 & 3) << 4) | (i6 >>> 4);
            i6 = ((i6 & 15) << 2) | (i8 >>> 6);
            int i11 = i8 & 63;
            i8 = i5 + 1;
            cArr[i5] = map1[i10];
            i5 = i8 + 1;
            cArr[i8] = map1[i9];
            cArr[i5] = i5 < i3 ? map1[i6] : '=';
            i6 = i5 + 1;
            cArr[i6] = i6 < i3 ? map1[i11] : '=';
            i = i7;
            i5 = i6 + 1;
        }
        return cArr;
    }

    public static String encodeLines(byte[] bArr) {
        return encodeLines(bArr, 0, bArr.length, 76, systemLineSeparator);
    }

    public static String encodeLines(byte[] bArr, int i, int i2, int i3, String str) {
        int i4 = (i3 * 3) / 4;
        if (i4 <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuffer stringBuffer = new StringBuffer(((((i2 + i4) - 1) / i4) * str.length()) + (((i2 + 2) / 3) * 4));
        int i5 = 0;
        while (i5 < i2) {
            int min = Math.min(i2 - i5, i4);
            stringBuffer.append(encode(bArr, i + i5, min));
            stringBuffer.append(str);
            i5 += min;
        }
        return stringBuffer.toString();
    }

    public static String encodeString(String str) {
        return new String(encode(str.getBytes()));
    }
}
