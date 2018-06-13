package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class TraceOutputStream extends FilterOutputStream {
    private boolean quote = false;
    private boolean trace = false;
    private OutputStream traceOut;

    public TraceOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.traceOut = outputStream2;
    }

    private final void writeByte(int i) {
        int i2 = i & 255;
        if (i2 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i2 &= 127;
        }
        if (i2 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
        } else if (i2 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i2 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i2 < 32) {
            this.traceOut.write(94);
            this.traceOut.write(i2 + 64);
        } else {
            this.traceOut.write(i2);
        }
    }

    public void setQuote(boolean z) {
        this.quote = z;
    }

    public void setTrace(boolean z) {
        this.trace = z;
    }

    public void write(int i) {
        if (this.trace) {
            if (this.quote) {
                writeByte(i);
            } else {
                this.traceOut.write(i);
            }
        }
        this.out.write(i);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.trace) {
            if (this.quote) {
                for (int i3 = 0; i3 < i2; i3++) {
                    writeByte(bArr[i + i3]);
                }
            } else {
                this.traceOut.write(bArr, i, i2);
            }
        }
        this.out.write(bArr, i, i2);
    }
}
