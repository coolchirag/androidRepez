package winterwell.jtwitter.guts;

import java.io.ByteArrayOutputStream;

public final class Base64Encoder {
    static final char[] charTab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    static int decode(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 65;
        }
        if (c >= 'a' && c <= 'z') {
            return (c - 97) + 26;
        }
        if (c >= '0' && c <= '9') {
            return ((c - 48) + 26) + 26;
        }
        switch (c) {
            case '+':
                return 62;
            case '/':
                return 63;
            case '=':
                return 0;
            default:
                throw new RuntimeException(new StringBuffer("unexpected code: ").append(c).toString());
        }
    }

    public static byte[] decode(String str) {
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = str.length();
        while (true) {
            if (i >= length || str.charAt(i) > ' ') {
                if (i == length) {
                    break;
                }
                int decode = (((decode(str.charAt(i)) << 18) + (decode(str.charAt(i + 1)) << 12)) + (decode(str.charAt(i + 2)) << 6)) + decode(str.charAt(i + 3));
                byteArrayOutputStream.write((decode >> 16) & 255);
                if (str.charAt(i + 2) == '=') {
                    break;
                }
                byteArrayOutputStream.write((decode >> 8) & 255);
                if (str.charAt(i + 3) == '=') {
                    break;
                }
                byteArrayOutputStream.write(decode & 255);
                i += 4;
            } else {
                i++;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String encode(String str) {
        return encode(str.getBytes()).toString();
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length, null).toString();
    }

    public static StringBuffer encode(byte[] bArr, int i, int i2, StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        }
        int i3 = i2 - 3;
        int i4 = 0;
        int i5 = i;
        while (i5 <= i3) {
            int i6 = (((bArr[i5] & 255) << 16) | ((bArr[i5 + 1] & 255) << 8)) | (bArr[i5 + 2] & 255);
            stringBuffer.append(charTab[(i6 >> 18) & 63]);
            stringBuffer.append(charTab[(i6 >> 12) & 63]);
            stringBuffer.append(charTab[(i6 >> 6) & 63]);
            stringBuffer.append(charTab[i6 & 63]);
            i6 = i5 + 3;
            i5 = i4 + 1;
            if (i4 >= 14) {
                stringBuffer.append("\r\n");
                i4 = 0;
                i5 = i6;
            } else {
                i4 = i5;
                i5 = i6;
            }
        }
        if (i5 == (i + i2) - 2) {
            i4 = ((bArr[i5] & 255) << 16) | ((bArr[i5 + 1] & 255) << 8);
            stringBuffer.append(charTab[(i4 >> 18) & 63]);
            stringBuffer.append(charTab[(i4 >> 12) & 63]);
            stringBuffer.append(charTab[(i4 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i5 == (i + i2) - 1) {
            i4 = (bArr[i5] & 255) << 16;
            stringBuffer.append(charTab[(i4 >> 18) & 63]);
            stringBuffer.append(charTab[(i4 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer;
    }
}
