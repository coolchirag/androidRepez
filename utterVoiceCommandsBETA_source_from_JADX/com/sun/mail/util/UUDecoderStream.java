package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize = 0;
    private boolean gotEnd = false;
    private boolean gotPrefix = false;
    private int index = 0;
    private LineInputStream lin;
    private int mode;
    private String name;

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.lin = new LineInputStream(inputStream);
        this.buffer = new byte[45];
    }

    private boolean decode() {
        if (this.gotEnd) {
            return false;
        }
        String readLine;
        this.bufsize = 0;
        do {
            readLine = this.lin.readLine();
            if (readLine == null) {
                throw new IOException("Missing End");
            } else if (readLine.regionMatches(true, 0, "end", 0, 3)) {
                this.gotEnd = true;
                return false;
            }
        } while (readLine.length() == 0);
        char charAt = readLine.charAt(0);
        if (charAt < ' ') {
            throw new IOException("Buffer format error");
        }
        int i = (charAt - 32) & 63;
        if (i == 0) {
            readLine = this.lin.readLine();
            if (readLine == null || !readLine.regionMatches(true, 0, "end", 0, 3)) {
                throw new IOException("Missing End");
            }
            this.gotEnd = true;
            return false;
        }
        if (readLine.length() < (((i * 8) + 5) / 6) + 1) {
            throw new IOException("Short buffer error");
        }
        int i2 = 1;
        while (this.bufsize < i) {
            int i3 = i2 + 1;
            byte charAt2 = (byte) ((readLine.charAt(i2) - 32) & 63);
            i2 = i3 + 1;
            byte charAt3 = (byte) ((readLine.charAt(i3) - 32) & 63);
            byte[] bArr = this.buffer;
            int i4 = this.bufsize;
            this.bufsize = i4 + 1;
            bArr[i4] = (byte) (((charAt2 << 2) & 252) | ((charAt3 >>> 4) & 3));
            if (this.bufsize < i) {
                int i5 = i2 + 1;
                byte charAt4 = (byte) ((readLine.charAt(i2) - 32) & 63);
                bArr = this.buffer;
                i4 = this.bufsize;
                this.bufsize = i4 + 1;
                bArr[i4] = (byte) (((charAt3 << 4) & 240) | ((charAt4 >>> 2) & 15));
                i3 = i5;
                i5 = charAt4;
            } else {
                charAt2 = charAt3;
                i3 = i2;
            }
            if (this.bufsize < i) {
                i2 = i3 + 1;
                charAt3 = (byte) ((readLine.charAt(i3) - 32) & 63);
                bArr = this.buffer;
                i4 = this.bufsize;
                this.bufsize = i4 + 1;
                bArr[i4] = (byte) ((charAt3 & 63) | ((i5 << 6) & 192));
            } else {
                i2 = i3;
            }
        }
        return true;
    }

    private void readPrefix() {
        if (!this.gotPrefix) {
            String readLine;
            do {
                readLine = this.lin.readLine();
                if (readLine == null) {
                    throw new IOException("UUDecoder error: No Begin");
                }
            } while (!readLine.regionMatches(true, 0, "begin", 0, 5));
            try {
                this.mode = Integer.parseInt(readLine.substring(6, 9));
                this.name = readLine.substring(10);
                this.gotPrefix = true;
            } catch (NumberFormatException e) {
                throw new IOException("UUDecoder error: " + e.toString());
            }
        }
    }

    public int available() {
        return ((this.in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public int getMode() {
        readPrefix();
        return this.mode;
    }

    public String getName() {
        readPrefix();
        return this.name;
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
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
        for (i3 = 0; i3 < i2; i3++) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i + i3] = (byte) read;
        }
        return i3;
    }
}
