package winterwell.json;

public class JSONTokener {
    private int myIndex = 0;
    private String mySource;

    public JSONTokener(String str) {
        this.mySource = str;
    }

    public static int dehexchar(char c) {
        return (c < '0' || c > '9') ? (c < 'A' || c > 'F') ? (c < 'a' || c > 'f') ? -1 : c - 87 : c - 55 : c - 48;
    }

    public void back() {
        if (this.myIndex > 0) {
            this.myIndex--;
        }
    }

    public boolean more() {
        return this.myIndex < this.mySource.length();
    }

    public char next() {
        if (!more()) {
            return '\u0000';
        }
        char charAt = this.mySource.charAt(this.myIndex);
        this.myIndex++;
        return charAt;
    }

    public char next(char c) {
        char next = next();
        if (next == c) {
            return next;
        }
        throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
    }

    public String next(int i) {
        int i2 = this.myIndex;
        int i3 = i2 + i;
        if (i3 >= this.mySource.length()) {
            throw syntaxError("Substring bounds error");
        }
        this.myIndex += i;
        return this.mySource.substring(i2, i3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char nextClean() {
        /*
        r5 = this;
        r4 = 13;
        r3 = 10;
        r0 = 47;
    L_0x0006:
        r1 = r5.next();
        if (r1 != r0) goto L_0x003c;
    L_0x000c:
        r1 = r5.next();
        switch(r1) {
            case 42: goto L_0x002f;
            case 47: goto L_0x0017;
            default: goto L_0x0013;
        };
    L_0x0013:
        r5.back();
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = r5.next();
        if (r1 == r3) goto L_0x0006;
    L_0x001d:
        if (r1 == r4) goto L_0x0006;
    L_0x001f:
        if (r1 != 0) goto L_0x0017;
    L_0x0021:
        goto L_0x0006;
    L_0x0022:
        r2 = 42;
        if (r1 != r2) goto L_0x002f;
    L_0x0026:
        r1 = r5.next();
        if (r1 == r0) goto L_0x0006;
    L_0x002c:
        r5.back();
    L_0x002f:
        r1 = r5.next();
        if (r1 != 0) goto L_0x0022;
    L_0x0035:
        r0 = "Unclosed comment";
        r0 = r5.syntaxError(r0);
        throw r0;
    L_0x003c:
        r2 = 35;
        if (r1 != r2) goto L_0x004b;
    L_0x0040:
        r1 = r5.next();
        if (r1 == r3) goto L_0x0006;
    L_0x0046:
        if (r1 == r4) goto L_0x0006;
    L_0x0048:
        if (r1 != 0) goto L_0x0040;
    L_0x004a:
        goto L_0x0006;
    L_0x004b:
        if (r1 == 0) goto L_0x0051;
    L_0x004d:
        r2 = 32;
        if (r1 <= r2) goto L_0x0006;
    L_0x0051:
        r0 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: winterwell.json.JSONTokener.nextClean():char");
    }

    public String nextString(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            switch (next) {
                case '\u0000':
                case '\n':
                case '\r':
                    throw syntaxError("Unterminated string");
                case '\\':
                    next = next();
                    switch (next) {
                        case 'b':
                            stringBuffer.append('\b');
                            break;
                        case 'f':
                            stringBuffer.append('\f');
                            break;
                        case 'n':
                            stringBuffer.append('\n');
                            break;
                        case 'r':
                            stringBuffer.append('\r');
                            break;
                        case 't':
                            stringBuffer.append('\t');
                            break;
                        case 'u':
                            stringBuffer.append((char) Integer.parseInt(next(4), 16));
                            break;
                        case 'x':
                            stringBuffer.append((char) Integer.parseInt(next(2), 16));
                            break;
                        default:
                            stringBuffer.append(next);
                            break;
                    }
                default:
                    if (next != c) {
                        stringBuffer.append(next);
                        break;
                    }
                    return stringBuffer.toString();
            }
        }
    }

    public String nextTo(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            if (next != c && next != '\u0000' && next != '\n' && next != '\r') {
                stringBuffer.append(next);
            } else if (next != '\u0000') {
                back();
            }
        }
        if (next != '\u0000') {
            back();
        }
        return stringBuffer.toString().trim();
    }

    public String nextTo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            if (str.indexOf(next) < 0 && next != '\u0000' && next != '\n' && next != '\r') {
                stringBuffer.append(next);
            } else if (next != '\u0000') {
                back();
            }
        }
        if (next != '\u0000') {
            back();
        }
        return stringBuffer.toString().trim();
    }

    public Object nextValue() {
        char nextClean = nextClean();
        switch (nextClean) {
            case '\"':
            case '\'':
                return nextString(nextClean);
            case '[':
                back();
                return new JSONArray(this);
            case '{':
                back();
                return new JSONObject(this);
            default:
                StringBuffer stringBuffer = new StringBuffer();
                char c = nextClean;
                while (c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0) {
                    stringBuffer.append(c);
                    c = next();
                }
                back();
                String trim = stringBuffer.toString().trim();
                if (trim.equals("")) {
                    throw syntaxError("Missing value");
                } else if (trim.equalsIgnoreCase("true")) {
                    return Boolean.TRUE;
                } else {
                    if (trim.equalsIgnoreCase("false")) {
                        return Boolean.FALSE;
                    }
                    if (trim.equalsIgnoreCase("null")) {
                        return JSONObject.NULL;
                    }
                    if ((nextClean < '0' || nextClean > '9') && nextClean != '.' && nextClean != '-' && nextClean != '+') {
                        return trim;
                    }
                    if (nextClean == '0') {
                        if (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) {
                            try {
                                return new Integer(Integer.parseInt(trim, 8));
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                return new Integer(Integer.parseInt(trim.substring(2), 16));
                            } catch (Exception e2) {
                            }
                        }
                    }
                    try {
                        return new Integer(trim);
                    } catch (Exception e3) {
                        try {
                            return new Long(trim);
                        } catch (Exception e4) {
                            try {
                                return new Double(trim);
                            } catch (Exception e5) {
                                return trim;
                            }
                        }
                    }
                }
        }
    }

    public boolean skipPast(String str) {
        this.myIndex = this.mySource.indexOf(str, this.myIndex);
        if (this.myIndex < 0) {
            this.myIndex = this.mySource.length();
            return false;
        }
        this.myIndex += str.length();
        return true;
    }

    public char skipTo(char c) {
        char next;
        int i = this.myIndex;
        do {
            next = next();
            if (next == '\u0000') {
                this.myIndex = i;
                break;
            }
        } while (next != c);
        back();
        return next;
    }

    public JSONException syntaxError(String str) {
        return new JSONException(new StringBuilder(String.valueOf(str)).append(toString()).toString());
    }

    public String toString() {
        return " at character " + this.myIndex + " of " + this.mySource;
    }
}
