package com.sun.mail.smtp;

import com.sun.mail.util.CRLFOutputStream;
import java.io.OutputStream;

public class SMTPOutputStream extends CRLFOutputStream {
    public SMTPOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void ensureAtBOL() {
        if (!this.atBOL) {
            super.writeln();
        }
    }

    public void flush() {
    }

    public void write(int i) {
        if ((this.lastb == 10 || this.lastb == 13 || this.lastb == -1) && i == 46) {
            this.out.write(46);
        }
        super.write(i);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        byte b = this.lastb == -1 ? (byte) 10 : this.lastb;
        int i4 = i;
        int i5 = i;
        while (i4 < i3) {
            if ((b == (byte) 10 || b == (byte) 13) && bArr[i4] == (byte) 46) {
                super.write(bArr, i5, i4 - i5);
                this.out.write(46);
                i5 = i4;
            }
            b = bArr[i4];
            i4++;
        }
        if (i3 - i5 > 0) {
            super.write(bArr, i5, i3 - i5);
        }
    }
}
