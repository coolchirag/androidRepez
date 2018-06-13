package com.sun.mail.util;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BASE64DecoderStream extends FilterInputStream {
    private static final char[] pem_array = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] pem_convert_array = new byte[256];
    private byte[] buffer;
    private int bufsize;
    private boolean ignoreErrors;
    private int index;
    private byte[] input_buffer;
    private int input_len;
    private int input_pos;

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            pem_convert_array[i2] = (byte) -1;
        }
        while (i < pem_array.length) {
            pem_convert_array[pem_array[i]] = (byte) i;
            i++;
        }
    }

    public BASE64DecoderStream(InputStream inputStream) {
        boolean z = false;
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        try {
            String property = System.getProperty("mail.mime.base64.ignoreerrors");
            if (!(property == null || property.equalsIgnoreCase("false"))) {
                z = true;
            }
            this.ignoreErrors = z;
        } catch (SecurityException e) {
        }
    }

    public BASE64DecoderStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        this.ignoreErrors = z;
    }

    private int decode(byte[] bArr, int i, int i2) {
        int i3 = 1;
        int i4 = i;
        while (i2 >= 3) {
            int i5;
            int i6 = 0;
            for (i5 = 0; i5 < 4; i5++) {
                int i7 = getByte();
                if (i7 == -1 || i7 == -2) {
                    int i8;
                    if (i7 == -1) {
                        if (i5 == 0) {
                            return i4 - i;
                        }
                        if (this.ignoreErrors) {
                            i8 = 1;
                        } else {
                            throw new IOException("Error in encoded stream: needed 4 valid base64 characters but only got " + i5 + " before EOF" + recentChars());
                        }
                    } else if (i5 < 2 && !this.ignoreErrors) {
                        throw new IOException("Error in encoded stream: needed at least 2 valid base64 characters, but only got " + i5 + " before padding character (=)" + recentChars());
                    } else if (i5 == 0) {
                        return i4 - i;
                    } else {
                        i8 = 0;
                    }
                    int i9 = i5 - 1;
                    if (i9 != 0) {
                        i3 = i9;
                    }
                    i9 = i6 << 6;
                    for (i5++; i5 < 4; i5++) {
                        if (i8 == 0) {
                            i6 = getByte();
                            if (i6 == -1) {
                                if (!this.ignoreErrors) {
                                    throw new IOException("Error in encoded stream: hit EOF while looking for padding characters (=)" + recentChars());
                                }
                            } else if (!(i6 == -2 || this.ignoreErrors)) {
                                throw new IOException("Error in encoded stream: found valid base64 character after a padding character (=)" + recentChars());
                            }
                        }
                        i9 <<= 6;
                    }
                    i9 >>= 8;
                    if (i3 == 2) {
                        bArr[i4 + 1] = (byte) (i9 & 255);
                    }
                    bArr[i4] = (byte) ((i9 >> 8) & 255);
                    return (i3 + i4) - i;
                }
                i6 = (i6 << 6) | i7;
            }
            bArr[i4 + 2] = (byte) (i6 & 255);
            i5 = i6 >> 8;
            bArr[i4 + 1] = (byte) (i5 & 255);
            bArr[i4] = (byte) ((i5 >> 8) & 255);
            i2 -= 3;
            i4 += 3;
        }
        return i4 - i;
    }

    public static byte[] decode(byte[] bArr) {
        int i = 0;
        int length = (bArr.length / 4) * 3;
        if (length == 0) {
            return bArr;
        }
        if (bArr[bArr.length - 1] == (byte) 61) {
            length--;
            if (bArr[bArr.length - 2] == (byte) 61) {
                length--;
            }
        }
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        int length2 = bArr.length;
        while (length2 > 0) {
            int i3;
            length = 3;
            int i4 = i + 1;
            int i5 = i4 + 1;
            i = ((pem_convert_array[bArr[i] & 255] << 6) | pem_convert_array[bArr[i4] & 255]) << 6;
            if (bArr[i5] != (byte) 61) {
                i3 = i5 + 1;
                i |= pem_convert_array[bArr[i5] & 255];
            } else {
                length = 2;
                i3 = i5;
            }
            i <<= 6;
            if (bArr[i3] != (byte) 61) {
                i |= pem_convert_array[bArr[i3] & 255];
                i3++;
            } else {
                length--;
            }
            if (length > 2) {
                bArr2[i2 + 2] = (byte) (i & 255);
            }
            i >>= 8;
            if (length > 1) {
                bArr2[i2 + 1] = (byte) (i & 255);
            }
            bArr2[i2] = (byte) ((i >> 8) & 255);
            i2 = length + i2;
            length2 -= 4;
            i = i3;
        }
        return bArr2;
    }

    private int getByte() {
        byte b;
        do {
            if (this.input_pos >= this.input_len) {
                try {
                    this.input_len = this.in.read(this.input_buffer);
                    if (this.input_len <= 0) {
                        return -1;
                    }
                    this.input_pos = 0;
                } catch (EOFException e) {
                    return -1;
                }
            }
            byte[] bArr = this.input_buffer;
            int i = this.input_pos;
            this.input_pos = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 == 61) {
                return -2;
            }
            b = pem_convert_array[i2];
        } while (b == (byte) -1);
        return b;
    }

    private String recentChars() {
        String str = "";
        int i = this.input_pos > 10 ? 10 : this.input_pos;
        if (i <= 0) {
            return str;
        }
        Object stringBuilder = new StringBuilder(String.valueOf(str)).append(", the ").append(i).append(" most recent characters were: \"").toString();
        for (int i2 = this.input_pos - i; i2 < this.input_pos; i2++) {
            char c = (char) (this.input_buffer[i2] & 255);
            switch (c) {
                case '\t':
                    stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("\\t").toString();
                    break;
                case '\n':
                    stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("\\n").toString();
                    break;
                case '\r':
                    stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("\\r").toString();
                    break;
                default:
                    if (c >= ' ' && c < '') {
                        stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append(c).toString();
                        break;
                    }
                    stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("\\").append(c).toString();
                    break;
                    break;
            }
        }
        return new StringBuilder(String.valueOf(stringBuilder)).append("\"").toString();
    }

    public int available() {
        return ((this.in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        if (this.index >= this.bufsize) {
            this.bufsize = decode(this.buffer, 0, this.buffer.length);
            if (this.bufsize <= 0) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int decode;
        int i4 = i;
        while (this.index < this.bufsize && i2 > 0) {
            i3 = i4 + 1;
            byte[] bArr2 = this.buffer;
            int i5 = this.index;
            this.index = i5 + 1;
            bArr[i4] = bArr2[i5];
            i2--;
            i4 = i3;
        }
        if (this.index >= this.bufsize) {
            this.index = 0;
            this.bufsize = 0;
        }
        i3 = (i2 / 3) * 3;
        if (i3 > 0) {
            decode = decode(bArr, i4, i3);
            i4 += decode;
            i2 -= decode;
            if (decode != i3) {
                return i4 == i ? -1 : i4 - i;
            }
        }
        while (i2 > 0) {
            decode = read();
            if (decode == -1) {
                break;
            }
            i3 = i4 + 1;
            bArr[i4] = (byte) decode;
            i2--;
            i4 = i3;
        }
        return i4 == i ? -1 : i4 - i;
    }
}
