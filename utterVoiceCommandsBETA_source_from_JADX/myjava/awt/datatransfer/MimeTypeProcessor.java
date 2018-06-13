package myjava.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

final class MimeTypeProcessor {
    private static MimeTypeProcessor instance;

    final class MimeType implements Serializable, Cloneable {
        private static final long serialVersionUID = -6693571907475992044L;
        private Hashtable<String, String> parameters;
        private String primaryType;
        private String subType;
        private Hashtable<String, Object> systemParameters;

        MimeType() {
            this.primaryType = null;
            this.subType = null;
            this.parameters = null;
            this.systemParameters = null;
        }

        MimeType(String str, String str2) {
            this.primaryType = str;
            this.subType = str2;
            this.parameters = new Hashtable();
            this.systemParameters = new Hashtable();
        }

        final void addParameter(String str, String str2) {
            if (str2 != null) {
                if (str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                    str2 = str2.substring(1, str2.length() - 2);
                }
                if (str2.length() != 0) {
                    this.parameters.put(str, str2);
                }
            }
        }

        final void addSystemParameter(String str, Object obj) {
            this.systemParameters.put(str, obj);
        }

        public final Object clone() {
            MimeType mimeType = new MimeType(this.primaryType, this.subType);
            mimeType.parameters = (Hashtable) this.parameters.clone();
            mimeType.systemParameters = (Hashtable) this.systemParameters.clone();
            return mimeType;
        }

        final boolean equals(MimeType mimeType) {
            return mimeType == null ? false : getFullType().equals(mimeType.getFullType());
        }

        final String getFullType() {
            return this.primaryType + "/" + this.subType;
        }

        final String getParameter(String str) {
            return (String) this.parameters.get(str);
        }

        final String getPrimaryType() {
            return this.primaryType;
        }

        final String getSubType() {
            return this.subType;
        }

        final Object getSystemParameter(String str) {
            return this.systemParameters.get(str);
        }

        final void removeParameter(String str) {
            this.parameters.remove(str);
        }
    }

    final class StringPosition {
        int f3053i;

        private StringPosition() {
            this.f3053i = 0;
        }
    }

    private MimeTypeProcessor() {
    }

    static String assemble(MimeType mimeType) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mimeType.getFullType());
        Enumeration keys = mimeType.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            String str2 = (String) mimeType.parameters.get(str);
            stringBuilder.append("; ");
            stringBuilder.append(str);
            stringBuilder.append("=\"");
            stringBuilder.append(str2);
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    private static int getNextMeaningfulIndex(String str, int i) {
        while (i < str.length() && !isMeaningfulChar(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static boolean isMeaningfulChar(char c) {
        return c >= '!' && c <= '~';
    }

    private static boolean isTSpecialChar(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' || c == '<' || c == '>' || c == '@' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '\"' || c == '/' || c == '?' || c == '=';
    }

    static MimeType parse(String str) {
        if (instance == null) {
            instance = new MimeTypeProcessor();
        }
        MimeType mimeType = new MimeType();
        if (str != null) {
            StringPosition stringPosition = new StringPosition();
            retrieveType(str, mimeType, stringPosition);
            retrieveParams(str, mimeType, stringPosition);
        }
        return mimeType;
    }

    private static void retrieveParam(String str, MimeType mimeType, StringPosition stringPosition) {
        String toLowerCase = retrieveToken(str, stringPosition).toLowerCase();
        stringPosition.f3053i = getNextMeaningfulIndex(str, stringPosition.f3053i);
        if (stringPosition.f3053i >= str.length() || str.charAt(stringPosition.f3053i) != '=') {
            throw new IllegalArgumentException();
        }
        stringPosition.f3053i++;
        stringPosition.f3053i = getNextMeaningfulIndex(str, stringPosition.f3053i);
        if (stringPosition.f3053i >= str.length()) {
            throw new IllegalArgumentException();
        }
        mimeType.parameters.put(toLowerCase, str.charAt(stringPosition.f3053i) == '\"' ? retrieveQuoted(str, stringPosition) : retrieveToken(str, stringPosition));
    }

    private static void retrieveParams(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.parameters = new Hashtable();
        mimeType.systemParameters = new Hashtable();
        while (true) {
            stringPosition.f3053i = getNextMeaningfulIndex(str, stringPosition.f3053i);
            if (stringPosition.f3053i < str.length()) {
                if (str.charAt(stringPosition.f3053i) != ';') {
                    throw new IllegalArgumentException();
                }
                stringPosition.f3053i++;
                retrieveParam(str, mimeType, stringPosition);
            } else {
                return;
            }
        }
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        stringPosition.f3053i++;
        Object obj = 1;
        do {
            if (str.charAt(stringPosition.f3053i) != '\"' || obj == null) {
                int i = stringPosition.f3053i;
                stringPosition.f3053i = i + 1;
                char charAt = str.charAt(i);
                if (obj == null) {
                    obj = 1;
                } else if (charAt == '\\') {
                    obj = null;
                }
                if (obj != null) {
                    stringBuilder.append(charAt);
                }
            } else {
                stringPosition.f3053i++;
                return stringBuilder.toString();
            }
        } while (stringPosition.f3053i != str.length());
        throw new IllegalArgumentException();
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        stringPosition.f3053i = getNextMeaningfulIndex(str, stringPosition.f3053i);
        if (stringPosition.f3053i >= str.length() || isTSpecialChar(str.charAt(stringPosition.f3053i))) {
            throw new IllegalArgumentException();
        }
        do {
            int i = stringPosition.f3053i;
            stringPosition.f3053i = i + 1;
            stringBuilder.append(str.charAt(i));
            if (stringPosition.f3053i >= str.length() || !isMeaningfulChar(str.charAt(stringPosition.f3053i))) {
            }
        } while (!isTSpecialChar(str.charAt(stringPosition.f3053i)));
        return stringBuilder.toString();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.primaryType = retrieveToken(str, stringPosition).toLowerCase();
        stringPosition.f3053i = getNextMeaningfulIndex(str, stringPosition.f3053i);
        if (stringPosition.f3053i >= str.length() || str.charAt(stringPosition.f3053i) != '/') {
            throw new IllegalArgumentException();
        }
        stringPosition.f3053i++;
        mimeType.subType = retrieveToken(str, stringPosition).toLowerCase();
    }
}
