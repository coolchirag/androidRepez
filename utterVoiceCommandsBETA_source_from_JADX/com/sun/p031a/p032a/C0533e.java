package com.sun.p031a.p032a;

import winterwell.jtwitter.TwitterStream;

public final class C0533e {
    String f3038a;
    boolean f3039b;
    private String f3040c;
    private int f3041d = 0;
    private int f3042e;
    private int f3043f;
    private char f3044g;

    public C0533e(String str) {
        this.f3040c = str;
        this.f3042e = str.length();
        this.f3043f = 1;
        this.f3038a = "";
        this.f3039b = false;
        this.f3044g = ';';
    }

    public static String m2799a(int i) {
        String str = "really unknown";
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "start";
            case 2:
                return "string";
            case 5:
                return "EOI";
            case 47:
                return "'/'";
            case 59:
                return "';'";
            case 61:
                return "'='";
            default:
                return str;
        }
    }

    private static boolean m2800a(char c) {
        boolean z;
        switch (c) {
            case '\"':
            case '(':
            case ')':
            case ',':
            case '/':
            case ':':
            case ';':
            case TwitterStream.MAX_KEYWORD_LENGTH /*60*/:
            case '=':
            case '>':
            case '?':
            case '@':
            case '[':
            case '\\':
            case ']':
                z = true;
                break;
            default:
                z = false;
                break;
        }
        return (z || Character.isISOControl(c) || Character.isWhitespace(c)) ? false : true;
    }

    private void m2801b() {
        int i = this.f3041d;
        while (this.f3041d < this.f3042e && C0533e.m2800a(this.f3040c.charAt(this.f3041d))) {
            this.f3041d++;
        }
        this.f3043f = 2;
        this.f3038a = this.f3040c.substring(i, this.f3041d);
    }

    private void m2802c() {
        int i = this.f3041d;
        Object obj = null;
        while (this.f3041d < this.f3042e && r0 == null) {
            if (this.f3040c.charAt(this.f3041d) != this.f3044g) {
                this.f3041d++;
            } else {
                obj = 1;
            }
        }
        this.f3043f = 2;
        String substring = this.f3040c.substring(i, this.f3041d);
        int length = substring.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = substring.charAt(i2);
            if (charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (i2 < length - 1) {
                stringBuffer.append(substring.charAt(i2 + 1));
                i2++;
            } else {
                stringBuffer.append(charAt);
            }
            i2++;
        }
        this.f3038a = stringBuffer.toString();
    }

    public final int m2803a() {
        if (this.f3041d < this.f3042e) {
            while (this.f3041d < this.f3042e && Character.isWhitespace(this.f3040c.charAt(this.f3041d))) {
                this.f3041d++;
            }
            if (this.f3041d < this.f3042e) {
                char charAt = this.f3040c.charAt(this.f3041d);
                if (this.f3039b) {
                    if (charAt == ';' || charAt == '=') {
                        this.f3043f = charAt;
                        this.f3038a = new Character(charAt).toString();
                        this.f3041d++;
                    } else {
                        m2802c();
                    }
                } else if (C0533e.m2800a(charAt)) {
                    m2801b();
                } else if (charAt == '/' || charAt == ';' || charAt == '=') {
                    this.f3043f = charAt;
                    this.f3038a = new Character(charAt).toString();
                    this.f3041d++;
                } else {
                    this.f3043f = 0;
                    this.f3038a = new Character(charAt).toString();
                    this.f3041d++;
                }
            } else {
                this.f3043f = 5;
                this.f3038a = null;
            }
        } else {
            this.f3043f = 5;
            this.f3038a = null;
        }
        return this.f3043f;
    }
}
