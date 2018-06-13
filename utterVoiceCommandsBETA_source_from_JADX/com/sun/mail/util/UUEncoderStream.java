package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class UUEncoderStream extends FilterOutputStream {
    private byte[] buffer;
    private int bufsize;
    protected int mode;
    protected String name;
    private boolean wrotePrefix;

    public UUEncoderStream(OutputStream outputStream) {
        this(outputStream, "encoder.buf", 644);
    }

    public UUEncoderStream(OutputStream outputStream, String str) {
        this(outputStream, str, 644);
    }

    public UUEncoderStream(OutputStream outputStream, String str, int i) {
        super(outputStream);
        this.bufsize = 0;
        this.wrotePrefix = false;
        this.name = str;
        this.mode = i;
        this.buffer = new byte[45];
    }

    private void encode() {
        int i = 0;
        this.out.write((this.bufsize & 63) + 32);
        while (i < this.bufsize) {
            int i2;
            int i3 = i + 1;
            byte b = this.buffer[i];
            if (i3 < this.bufsize) {
                i2 = i3 + 1;
                i3 = this.buffer[i3];
                if (i2 < this.bufsize) {
                    i = i2 + 1;
                    i2 = this.buffer[i2];
                } else {
                    i = i2;
                    i2 = 1;
                }
            } else {
                i = i3;
                i2 = 1;
                i3 = 1;
            }
            int i4 = (b >>> 2) & 63;
            int i5 = ((b << 4) & 48) | ((i3 >>> 4) & 15);
            i3 = ((i3 << 2) & 60) | ((i2 >>> 6) & 3);
            i2 &= 63;
            this.out.write(i4 + 32);
            this.out.write(i5 + 32);
            this.out.write(i3 + 32);
            this.out.write(i2 + 32);
        }
        this.out.write(10);
    }

    private void writePrefix() {
        if (!this.wrotePrefix) {
            PrintStream printStream = new PrintStream(this.out);
            printStream.println("begin " + this.mode + " " + this.name);
            printStream.flush();
            this.wrotePrefix = true;
        }
    }

    private void writeSuffix() {
        PrintStream printStream = new PrintStream(this.out);
        printStream.println(" \nend");
        printStream.flush();
    }

    public void close() {
        flush();
        this.out.close();
    }

    public void flush() {
        if (this.bufsize > 0) {
            writePrefix();
            encode();
        }
        writeSuffix();
        this.out.flush();
    }

    public void setNameMode(String str, int i) {
        this.name = str;
        this.mode = i;
    }

    public void write(int i) {
        byte[] bArr = this.buffer;
        int i2 = this.bufsize;
        this.bufsize = i2 + 1;
        bArr[i2] = (byte) i;
        if (this.bufsize == 45) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }
}
