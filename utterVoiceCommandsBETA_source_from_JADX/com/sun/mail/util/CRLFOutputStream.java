package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class CRLFOutputStream extends FilterOutputStream {
    private static final byte[] newline = new byte[]{(byte) 13, (byte) 10};
    protected boolean atBOL = true;
    protected int lastb = -1;

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(int i) {
        if (i == 13) {
            writeln();
        } else if (i != 10) {
            this.out.write(i);
            this.atBOL = false;
        } else if (this.lastb != 13) {
            writeln();
        }
        this.lastb = i;
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            if (bArr[i] == (byte) 13) {
                this.out.write(bArr, i4, i - i4);
                writeln();
            } else if (bArr[i] != (byte) 10) {
                this.lastb = bArr[i];
                i++;
            } else if (this.lastb != 13) {
                this.out.write(bArr, i4, i - i4);
                writeln();
            }
            i4 = i + 1;
            this.lastb = bArr[i];
            i++;
        }
        if (i3 - i4 > 0) {
            this.out.write(bArr, i4, i3 - i4);
            this.atBOL = false;
        }
    }

    public void writeln() {
        this.out.write(newline);
        this.atBOL = true;
    }
}
