package javax.activation;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

public class MimeTypeParameterList {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private Hashtable parameters = new Hashtable();

    public MimeTypeParameterList(String str) {
        parse(str);
    }

    private static boolean isTokenChar(char c) {
        return c > ' ' && c < '' && TSPECIALS.indexOf(c) < 0;
    }

    private static String quote(String str) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length && i2 == 0; i3++) {
            i2 = isTokenChar(str.charAt(i3)) ? 0 : 1;
        }
        if (i2 == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity((int) (((double) length) * 1.5d));
        stringBuffer.append('\"');
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\\' || charAt == '\"') {
                stringBuffer.append('\\');
            }
            stringBuffer.append(charAt);
            i++;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    private static int skipWhiteSpace(String str, int i) {
        int length = str.length();
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static String unquote(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        Object obj = null;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (obj == null && charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (obj != null) {
                stringBuffer.append(charAt);
                obj = null;
            } else {
                obj = 1;
            }
        }
        return stringBuffer.toString();
    }

    public String get(String str) {
        return (String) this.parameters.get(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public Enumeration getNames() {
        return this.parameters.keys();
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    protected void parse(String str) {
        if (str != null) {
            int length = str.length();
            if (length > 0) {
                int skipWhiteSpace = skipWhiteSpace(str, 0);
                while (skipWhiteSpace < length && str.charAt(skipWhiteSpace) == ';') {
                    int skipWhiteSpace2 = skipWhiteSpace(str, skipWhiteSpace + 1);
                    if (skipWhiteSpace2 < length) {
                        skipWhiteSpace = skipWhiteSpace2;
                        while (skipWhiteSpace < length && isTokenChar(str.charAt(skipWhiteSpace))) {
                            skipWhiteSpace++;
                        }
                        String toLowerCase = str.substring(skipWhiteSpace2, skipWhiteSpace).toLowerCase(Locale.ENGLISH);
                        skipWhiteSpace = skipWhiteSpace(str, skipWhiteSpace);
                        if (skipWhiteSpace >= length || str.charAt(skipWhiteSpace) != '=') {
                            throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
                        }
                        skipWhiteSpace = skipWhiteSpace(str, skipWhiteSpace + 1);
                        if (skipWhiteSpace >= length) {
                            throw new MimeTypeParseException("Couldn't find a value for parameter named " + toLowerCase);
                        }
                        Object unquote;
                        char charAt = str.charAt(skipWhiteSpace);
                        if (charAt == '\"') {
                            int i = skipWhiteSpace + 1;
                            if (i >= length) {
                                throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                            }
                            skipWhiteSpace = i;
                            while (skipWhiteSpace < length) {
                                charAt = str.charAt(skipWhiteSpace);
                                if (charAt == '\"') {
                                    break;
                                }
                                if (charAt == '\\') {
                                    skipWhiteSpace++;
                                }
                                skipWhiteSpace++;
                            }
                            if (charAt != '\"') {
                                throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                            }
                            skipWhiteSpace2 = skipWhiteSpace + 1;
                            unquote = unquote(str.substring(i, skipWhiteSpace));
                        } else if (isTokenChar(charAt)) {
                            skipWhiteSpace2 = skipWhiteSpace;
                            while (skipWhiteSpace2 < length && isTokenChar(str.charAt(skipWhiteSpace2))) {
                                skipWhiteSpace2++;
                            }
                            unquote = str.substring(skipWhiteSpace, skipWhiteSpace2);
                        } else {
                            throw new MimeTypeParseException("Unexpected character encountered at index " + skipWhiteSpace);
                        }
                        this.parameters.put(toLowerCase, unquote);
                        skipWhiteSpace = skipWhiteSpace(str, skipWhiteSpace2);
                    } else {
                        return;
                    }
                }
                if (skipWhiteSpace < length) {
                    throw new MimeTypeParseException("More characters encountered in input than expected.");
                }
            }
        }
    }

    public void remove(String str) {
        this.parameters.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        this.parameters.put(str.trim().toLowerCase(Locale.ENGLISH), str2);
    }

    public int size() {
        return this.parameters.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(this.parameters.size() * 16);
        Enumeration keys = this.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            stringBuffer.append("; ");
            stringBuffer.append(str);
            stringBuffer.append('=');
            stringBuffer.append(quote((String) this.parameters.get(str)));
        }
        return stringBuffer.toString();
    }
}
