package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ASCIIUtility {
    private ASCIIUtility() {
    }

    public static byte[] getBytes(InputStream inputStream) {
        if (inputStream instanceof ByteArrayInputStream) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, 1024);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static byte[] getBytes(String str) {
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            bArr[i] = (byte) toCharArray[i];
            i = i2;
        }
        return bArr;
    }

    public static int parseInt(byte[] bArr, int i, int i2) {
        return parseInt(bArr, i, i2, 10);
    }

    public static int parseInt(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            throw new NumberFormatException("null");
        } else if (i2 > i) {
            Object obj;
            int i4;
            int i5;
            int i6;
            if (bArr[i] == (byte) 45) {
                obj = 1;
                i4 = Integer.MIN_VALUE;
                i5 = i + 1;
            } else {
                i4 = -2147483647;
                i5 = i;
                obj = null;
            }
            int i7 = i4 / i3;
            if (i5 < i2) {
                i6 = i5 + 1;
                i5 = Character.digit((char) bArr[i5], i3);
                if (i5 < 0) {
                    throw new NumberFormatException("illegal number: " + toString(bArr, i, i2));
                }
                i5 = -i5;
            } else {
                int i8 = i5;
                i5 = 0;
                i6 = i8;
            }
            while (i6 < i2) {
                int i9 = i6 + 1;
                i6 = Character.digit((char) bArr[i6], i3);
                if (i6 < 0) {
                    throw new NumberFormatException("illegal number");
                } else if (i5 < i7) {
                    throw new NumberFormatException("illegal number");
                } else {
                    i5 *= i3;
                    if (i5 < i4 + i6) {
                        throw new NumberFormatException("illegal number");
                    }
                    i5 -= i6;
                    i6 = i9;
                }
            }
            if (obj == null) {
                return -i5;
            }
            if (i6 > i + 1) {
                return i5;
            }
            throw new NumberFormatException("illegal number");
        } else {
            throw new NumberFormatException("illegal number");
        }
    }

    public static long parseLong(byte[] bArr, int i, int i2) {
        return parseLong(bArr, i, i2, 10);
    }

    public static long parseLong(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            throw new NumberFormatException("null");
        }
        long j = 0;
        if (i2 > i) {
            Object obj;
            long j2;
            int i4;
            if (bArr[i] == (byte) 45) {
                obj = 1;
                j2 = Long.MIN_VALUE;
                i4 = i + 1;
            } else {
                j2 = -9223372036854775807L;
                obj = null;
                i4 = i;
            }
            long j3 = j2 / ((long) i3);
            if (i4 < i2) {
                int i5 = i4 + 1;
                i4 = Character.digit((char) bArr[i4], i3);
                if (i4 < 0) {
                    throw new NumberFormatException("illegal number: " + toString(bArr, i, i2));
                }
                long j4 = (long) (-i4);
                i4 = i5;
                j = j4;
            }
            while (i4 < i2) {
                int i6 = i4 + 1;
                i4 = Character.digit((char) bArr[i4], i3);
                if (i4 < 0) {
                    throw new NumberFormatException("illegal number");
                } else if (j < j3) {
                    throw new NumberFormatException("illegal number");
                } else {
                    j *= (long) i3;
                    if (j < ((long) i4) + j2) {
                        throw new NumberFormatException("illegal number");
                    }
                    j -= (long) i4;
                    i4 = i6;
                }
            }
            if (obj == null) {
                return -j;
            }
            if (i4 > i + 1) {
                return j;
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("illegal number");
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int i = 0;
        int available = byteArrayInputStream.available();
        char[] cArr = new char[available];
        byte[] bArr = new byte[available];
        byteArrayInputStream.read(bArr, 0, available);
        while (i < available) {
            int i2 = i + 1;
            cArr[i] = (char) (bArr[i] & 255);
            i = i2;
        }
        return new String(cArr);
    }

    public static String toString(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        char[] cArr = new char[i3];
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 + 1;
            int i6 = i + 1;
            cArr[i4] = (char) (bArr[i] & 255);
            i4 = i5;
            i = i6;
        }
        return new String(cArr);
    }
}
