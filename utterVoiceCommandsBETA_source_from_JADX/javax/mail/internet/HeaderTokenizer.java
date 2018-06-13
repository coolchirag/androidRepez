package javax.mail.internet;

public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    public class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public Token(int i, String str) {
            this.type = i;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public HeaderTokenizer(String str) {
        this(str, RFC822);
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str, String str2, boolean z) {
        if (str == null) {
            str = "";
        }
        this.string = str;
        this.skipComments = z;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = this.string.length();
    }

    private static String filterToken(String str, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = null;
        Object obj2 = null;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == '\n' && r3 != null) {
                obj = obj2;
                obj2 = null;
            } else if (obj2 != null) {
                stringBuffer.append(charAt);
                obj2 = null;
                obj = null;
            } else if (charAt == '\\') {
                obj2 = null;
                int i3 = 1;
            } else if (charAt == '\r') {
                obj = obj2;
                int i4 = 1;
            } else {
                stringBuffer.append(charAt);
                obj = obj2;
                obj2 = null;
            }
            i++;
            Object obj3 = obj2;
            obj2 = obj;
            obj = obj3;
        }
        return stringBuffer.toString();
    }

    private Token getNext() {
        if (this.currentPos >= this.maxPos) {
            return EOFToken;
        }
        if (skipWhiteSpace() == -4) {
            return EOFToken;
        }
        int i = 0;
        do {
            char charAt = this.string.charAt(this.currentPos);
            int i2;
            if (charAt == '(') {
                int i3 = this.currentPos + 1;
                this.currentPos = i3;
                i2 = 1;
                while (i2 > 0 && this.currentPos < this.maxPos) {
                    int i4;
                    char charAt2 = this.string.charAt(this.currentPos);
                    if (charAt2 == '\\') {
                        this.currentPos++;
                        i = i2;
                        i2 = 1;
                    } else if (charAt2 == '\r') {
                        i = i2;
                        i2 = 1;
                    } else if (charAt2 == '(') {
                        i4 = i2 + 1;
                        i2 = i;
                        i = i4;
                    } else if (charAt2 == ')') {
                        i4 = i2 - 1;
                        i2 = i;
                        i = i4;
                    } else {
                        i4 = i2;
                        i2 = i;
                        i = i4;
                    }
                    this.currentPos++;
                    i4 = i;
                    i = i2;
                    i2 = i4;
                }
                if (i2 != 0) {
                    throw new ParseException("Unbalanced comments");
                } else if (!this.skipComments) {
                    return new Token(-3, i != 0 ? filterToken(this.string, i3, this.currentPos - 1) : this.string.substring(i3, this.currentPos - 1));
                }
            } else if (charAt == '\"') {
                i2 = this.currentPos + 1;
                this.currentPos = i2;
                while (this.currentPos < this.maxPos) {
                    char charAt3 = this.string.charAt(this.currentPos);
                    if (charAt3 == '\\') {
                        this.currentPos++;
                        i = 1;
                    } else if (charAt3 == '\r') {
                        i = 1;
                    } else if (charAt3 == '\"') {
                        this.currentPos++;
                        return new Token(-2, i != 0 ? filterToken(this.string, i2, this.currentPos - 1) : this.string.substring(i2, this.currentPos - 1));
                    }
                    this.currentPos++;
                }
                throw new ParseException("Unbalanced quoted string");
            } else if (charAt < ' ' || charAt >= '' || this.delimiters.indexOf(charAt) >= 0) {
                this.currentPos++;
                return new Token(charAt, new String(new char[]{charAt}));
            } else {
                i2 = this.currentPos;
                while (this.currentPos < this.maxPos) {
                    char charAt4 = this.string.charAt(this.currentPos);
                    if (charAt4 < ' ' || charAt4 >= '' || charAt4 == '(' || charAt4 == ' ' || charAt4 == '\"' || this.delimiters.indexOf(charAt4) >= 0) {
                        break;
                    }
                    this.currentPos++;
                }
                return new Token(-1, this.string.substring(i2, this.currentPos));
            }
        } while (skipWhiteSpace() != -4);
        return EOFToken;
    }

    private int skipWhiteSpace() {
        while (this.currentPos < this.maxPos) {
            char charAt = this.string.charAt(this.currentPos);
            if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                return this.currentPos;
            }
            this.currentPos++;
        }
        return -4;
    }

    public String getRemainder() {
        return this.string.substring(this.nextPos);
    }

    public Token next() {
        this.currentPos = this.nextPos;
        Token next = getNext();
        int i = this.currentPos;
        this.peekPos = i;
        this.nextPos = i;
        return next;
    }

    public Token peek() {
        this.currentPos = this.peekPos;
        Token next = getNext();
        this.peekPos = this.currentPos;
        return next;
    }
}
