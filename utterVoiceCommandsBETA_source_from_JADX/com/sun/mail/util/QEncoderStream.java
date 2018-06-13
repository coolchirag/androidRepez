package com.sun.mail.util;

import java.io.OutputStream;

public class QEncoderStream extends QPEncoderStream {
    private static String TEXT_SPECIALS = "=_?";
    private static String WORD_SPECIALS = "=_?\"#$%&'(),.:;<>@[\\]^`{|}~";
    private String specials;

    public QEncoderStream(OutputStream outputStream, boolean z) {
        super(outputStream, Integer.MAX_VALUE);
        this.specials = z ? WORD_SPECIALS : TEXT_SPECIALS;
    }

    public static int encodedLength(byte[] bArr, boolean z) {
        int i = 0;
        String str = z ? WORD_SPECIALS : TEXT_SPECIALS;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = bArr[i] & 255;
            i2 = (i3 < 32 || i3 >= 127 || str.indexOf(i3) >= 0) ? i2 + 3 : i2 + 1;
            i++;
        }
        return i2;
    }

    public void write(int i) {
        int i2 = i & 255;
        if (i2 == 32) {
            output(95, false);
        } else if (i2 < 32 || i2 >= 127 || this.specials.indexOf(i2) >= 0) {
            output(i2, true);
        } else {
            output(i2, false);
        }
    }
}
