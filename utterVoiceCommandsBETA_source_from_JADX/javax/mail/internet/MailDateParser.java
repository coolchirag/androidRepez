package javax.mail.internet;

import java.text.ParseException;

class MailDateParser {
    int index = 0;
    char[] orig = null;

    public MailDateParser(char[] cArr) {
        this.orig = cArr;
    }

    int getIndex() {
        return this.index;
    }

    public int parseAlphaTimeZone() {
        int i = 0;
        int i2 = 1;
        try {
            char[] cArr;
            int i3;
            char c;
            char[] cArr2 = this.orig;
            int i4 = this.index;
            this.index = i4 + 1;
            switch (cArr2[i4]) {
                case 'C':
                case 'c':
                    i = 360;
                    break;
                case 'E':
                case 'e':
                    i = 300;
                    break;
                case 'G':
                case 'g':
                    cArr = this.orig;
                    i3 = this.index;
                    this.index = i3 + 1;
                    c = cArr[i3];
                    if (c == 'M' || c == 'm') {
                        cArr = this.orig;
                        i3 = this.index;
                        this.index = i3 + 1;
                        c = cArr[i3];
                        if (c == 'T' || c == 't') {
                            i2 = 0;
                            break;
                        }
                    }
                    throw new ParseException("Bad Alpha TimeZone", this.index);
                case 'M':
                case 'm':
                    i = 420;
                    break;
                case 'P':
                case 'p':
                    i = 480;
                    break;
                case 'U':
                case 'u':
                    cArr = this.orig;
                    i3 = this.index;
                    this.index = i3 + 1;
                    c = cArr[i3];
                    if (c == 'T' || c == 't') {
                        i2 = 0;
                        break;
                    }
                    throw new ParseException("Bad Alpha TimeZone", this.index);
                    break;
                default:
                    throw new ParseException("Bad Alpha TimeZone", this.index);
            }
            if (i2 == 0) {
                return i;
            }
            cArr = this.orig;
            i3 = this.index;
            this.index = i3 + 1;
            c = cArr[i3];
            if (c == 'S' || c == 's') {
                cArr = this.orig;
                i3 = this.index;
                this.index = i3 + 1;
                c = cArr[i3];
                if (c == 'T' || c == 't') {
                    return i;
                }
                throw new ParseException("Bad Alpha TimeZone", this.index);
            } else if (c != 'D' && c != 'd') {
                return i;
            } else {
                cArr = this.orig;
                i3 = this.index;
                this.index = i3 + 1;
                c = cArr[i3];
                if (c == 'T' || c != 't') {
                    return i - 60;
                }
                throw new ParseException("Bad Alpha TimeZone", this.index);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParseException("Bad Alpha TimeZone", this.index);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseMonth() {
        /*
        r8 = this;
        r7 = 80;
        r6 = 78;
        r5 = 67;
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r3 = 69;
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        switch(r0) {
            case 65: goto L_0x00af;
            case 68: goto L_0x0161;
            case 70: goto L_0x005d;
            case 74: goto L_0x0021;
            case 77: goto L_0x007f;
            case 78: goto L_0x0139;
            case 79: goto L_0x0113;
            case 83: goto L_0x00f1;
            case 97: goto L_0x00af;
            case 100: goto L_0x0161;
            case 102: goto L_0x005d;
            case 106: goto L_0x0021;
            case 109: goto L_0x007f;
            case 110: goto L_0x0139;
            case 111: goto L_0x0113;
            case 115: goto L_0x00f1;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = new java.text.ParseException;
        r1 = "Bad Month";
        r2 = r8.index;
        r0.<init>(r1, r2);
        throw r0;
    L_0x0021:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        switch(r0) {
            case 65: goto L_0x002f;
            case 85: goto L_0x0041;
            case 97: goto L_0x002f;
            case 117: goto L_0x0041;
            default: goto L_0x002e;
        };	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
    L_0x002e:
        goto L_0x0017;
    L_0x002f:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r6) goto L_0x003f;
    L_0x003b:
        r1 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x003f:
        r0 = 0;
    L_0x0040:
        return r0;
    L_0x0041:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r6) goto L_0x0051;
    L_0x004d:
        r1 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r0 != r1) goto L_0x0053;
    L_0x0051:
        r0 = 5;
        goto L_0x0040;
    L_0x0053:
        r1 = 76;
        if (r0 == r1) goto L_0x005b;
    L_0x0057:
        r1 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x005b:
        r0 = 6;
        goto L_0x0040;
    L_0x005d:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r3) goto L_0x006b;
    L_0x0069:
        if (r0 != r4) goto L_0x0017;
    L_0x006b:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 66;
        if (r0 == r1) goto L_0x007d;
    L_0x0079:
        r1 = 98;
        if (r0 != r1) goto L_0x0017;
    L_0x007d:
        r0 = 1;
        goto L_0x0040;
    L_0x007f:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 65;
        if (r0 == r1) goto L_0x0091;
    L_0x008d:
        r1 = 97;
        if (r0 != r1) goto L_0x0017;
    L_0x0091:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 82;
        if (r0 == r1) goto L_0x00a3;
    L_0x009f:
        r1 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r0 != r1) goto L_0x00a5;
    L_0x00a3:
        r0 = 2;
        goto L_0x0040;
    L_0x00a5:
        r1 = 89;
        if (r0 == r1) goto L_0x00ad;
    L_0x00a9:
        r1 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x00ad:
        r0 = 4;
        goto L_0x0040;
    L_0x00af:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r7) goto L_0x00bf;
    L_0x00bb:
        r1 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r0 != r1) goto L_0x00d4;
    L_0x00bf:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 82;
        if (r0 == r1) goto L_0x00d1;
    L_0x00cd:
        r1 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x00d1:
        r0 = 3;
        goto L_0x0040;
    L_0x00d4:
        r1 = 85;
        if (r0 == r1) goto L_0x00dc;
    L_0x00d8:
        r1 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x00dc:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 71;
        if (r0 == r1) goto L_0x00ee;
    L_0x00ea:
        r1 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x00ee:
        r0 = 7;
        goto L_0x0040;
    L_0x00f1:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r3) goto L_0x00ff;
    L_0x00fd:
        if (r0 != r4) goto L_0x0017;
    L_0x00ff:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r7) goto L_0x010f;
    L_0x010b:
        r1 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x010f:
        r0 = 8;
        goto L_0x0040;
    L_0x0113:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r5) goto L_0x0123;
    L_0x011f:
        r1 = 99;
        if (r0 != r1) goto L_0x0017;
    L_0x0123:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 84;
        if (r0 == r1) goto L_0x0135;
    L_0x0131:
        r1 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x0135:
        r0 = 9;
        goto L_0x0040;
    L_0x0139:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 79;
        if (r0 == r1) goto L_0x014b;
    L_0x0147:
        r1 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x014b:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = 86;
        if (r0 == r1) goto L_0x015d;
    L_0x0159:
        r1 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        if (r0 != r1) goto L_0x0017;
    L_0x015d:
        r0 = 10;
        goto L_0x0040;
    L_0x0161:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r3) goto L_0x016f;
    L_0x016d:
        if (r0 != r4) goto L_0x0017;
    L_0x016f:
        r0 = r8.orig;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r1 = r8.index;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r2 = r1 + 1;
        r8.index = r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0183 }
        if (r0 == r5) goto L_0x017f;
    L_0x017b:
        r1 = 99;
        if (r0 != r1) goto L_0x0017;
    L_0x017f:
        r0 = 11;
        goto L_0x0040;
    L_0x0183:
        r0 = move-exception;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseMonth():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseNumber() {
        /*
        r6 = this;
        r0 = 0;
        r2 = 1;
        r1 = r6.orig;
        r3 = r1.length;
        r1 = r0;
    L_0x0006:
        r4 = r6.index;
        if (r4 < r3) goto L_0x000d;
    L_0x000a:
        if (r1 == 0) goto L_0x0059;
    L_0x000c:
        return r0;
    L_0x000d:
        r4 = r6.orig;
        r5 = r6.index;
        r4 = r4[r5];
        switch(r4) {
            case 48: goto L_0x0022;
            case 49: goto L_0x002c;
            case 50: goto L_0x0031;
            case 51: goto L_0x0036;
            case 52: goto L_0x003b;
            case 53: goto L_0x0040;
            case 54: goto L_0x0045;
            case 55: goto L_0x004a;
            case 56: goto L_0x004f;
            case 57: goto L_0x0054;
            default: goto L_0x0016;
        };
    L_0x0016:
        if (r1 != 0) goto L_0x000c;
    L_0x0018:
        r0 = new java.text.ParseException;
        r1 = "No Number found";
        r2 = r6.index;
        r0.<init>(r1, r2);
        throw r0;
    L_0x0022:
        r0 = r0 * 10;
    L_0x0024:
        r1 = r6.index;
        r1 = r1 + 1;
        r6.index = r1;
        r1 = r2;
        goto L_0x0006;
    L_0x002c:
        r0 = r0 * 10;
        r0 = r0 + 1;
        goto L_0x0024;
    L_0x0031:
        r0 = r0 * 10;
        r0 = r0 + 2;
        goto L_0x0024;
    L_0x0036:
        r0 = r0 * 10;
        r0 = r0 + 3;
        goto L_0x0024;
    L_0x003b:
        r0 = r0 * 10;
        r0 = r0 + 4;
        goto L_0x0024;
    L_0x0040:
        r0 = r0 * 10;
        r0 = r0 + 5;
        goto L_0x0024;
    L_0x0045:
        r0 = r0 * 10;
        r0 = r0 + 6;
        goto L_0x0024;
    L_0x004a:
        r0 = r0 * 10;
        r0 = r0 + 7;
        goto L_0x0024;
    L_0x004f:
        r0 = r0 * 10;
        r0 = r0 + 8;
        goto L_0x0024;
    L_0x0054:
        r0 = r0 * 10;
        r0 = r0 + 9;
        goto L_0x0024;
    L_0x0059:
        r0 = new java.text.ParseException;
        r1 = "No Number found";
        r2 = r6.index;
        r0.<init>(r1, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseNumber():int");
    }

    public int parseNumericTimeZone() {
        Object obj = null;
        char[] cArr = this.orig;
        int i = this.index;
        this.index = i + 1;
        char c = cArr[i];
        if (c == '+') {
            obj = 1;
        } else if (c != '-') {
            throw new ParseException("Bad Numeric TimeZone", this.index);
        }
        int parseNumber = parseNumber();
        parseNumber = (parseNumber % 100) + ((parseNumber / 100) * 60);
        return obj != null ? -parseNumber : parseNumber;
    }

    public int parseTimeZone() {
        if (this.index >= this.orig.length) {
            throw new ParseException("No more characters", this.index);
        }
        char c = this.orig[this.index];
        return (c == '+' || c == '-') ? parseNumericTimeZone() : parseAlphaTimeZone();
    }

    public int peekChar() {
        if (this.index < this.orig.length) {
            return this.orig[this.index];
        }
        throw new ParseException("No more characters", this.index);
    }

    public void skipChar(char c) {
        if (this.index >= this.orig.length) {
            throw new ParseException("No more characters", this.index);
        } else if (this.orig[this.index] == c) {
            this.index++;
        } else {
            throw new ParseException("Wrong char", this.index);
        }
    }

    public boolean skipIfChar(char c) {
        if (this.index >= this.orig.length) {
            throw new ParseException("No more characters", this.index);
        } else if (this.orig[this.index] != c) {
            return false;
        } else {
            this.index++;
            return true;
        }
    }

    public void skipUntilNumber() {
        while (true) {
            try {
                switch (this.orig[this.index]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return;
                    default:
                        this.index++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParseException("No Number Found", this.index);
            }
        }
    }

    public void skipWhiteSpace() {
        int length = this.orig.length;
        while (this.index < length) {
            switch (this.orig[this.index]) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    this.index++;
                default:
                    return;
            }
        }
    }
}
