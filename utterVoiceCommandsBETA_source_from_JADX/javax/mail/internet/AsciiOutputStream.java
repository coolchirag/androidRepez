package javax.mail.internet;

import java.io.EOFException;
import java.io.OutputStream;

class AsciiOutputStream extends OutputStream {
    private int ascii = 0;
    private boolean badEOL = false;
    private boolean breakOnNonAscii;
    private boolean checkEOL = false;
    private int lastb = 0;
    private int linelen = 0;
    private boolean longLine = false;
    private int non_ascii = 0;
    private int ret = 0;

    public AsciiOutputStream(boolean z, boolean z2) {
        boolean z3 = false;
        this.breakOnNonAscii = z;
        if (z2 && z) {
            z3 = true;
        }
        this.checkEOL = z3;
    }

    private final void check(int i) {
        int i2 = i & 255;
        if (this.checkEOL && ((this.lastb == 13 && i2 != 10) || (this.lastb != 13 && i2 == 10))) {
            this.badEOL = true;
        }
        if (i2 == 13 || i2 == 10) {
            this.linelen = 0;
        } else {
            this.linelen++;
            if (this.linelen > 998) {
                this.longLine = true;
            }
        }
        if (MimeUtility.nonascii(i2)) {
            this.non_ascii++;
            if (this.breakOnNonAscii) {
                this.ret = 3;
                throw new EOFException();
            }
        }
        this.ascii++;
        this.lastb = i2;
    }

    public int getAscii() {
        return this.ret != 0 ? this.ret : !this.badEOL ? this.non_ascii == 0 ? this.longLine ? 2 : 1 : this.ascii > this.non_ascii ? 2 : 3 : 3;
    }

    public void write(int i) {
        check(i);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            check(bArr[i]);
            i++;
        }
    }
}
