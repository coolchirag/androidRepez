package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ParameterList {
    private static boolean applehack;
    private static boolean decodeParameters;
    private static boolean decodeParametersStrict;
    private static boolean encodeParameters;
    private static final char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private String lastName;
    private Map list;
    private Set multisegmentNames;
    private Map slist;

    class MultiValue extends ArrayList {
        String value;

        private MultiValue() {
        }
    }

    class ParamEnum implements Enumeration {
        private Iterator it;

        ParamEnum(Iterator it) {
            this.it = it;
        }

        public boolean hasMoreElements() {
            return this.it.hasNext();
        }

        public Object nextElement() {
            return this.it.next();
        }
    }

    class ToStringBuffer {
        private StringBuffer sb = new StringBuffer();
        private int used;

        public ToStringBuffer(int i) {
            this.used = i;
        }

        public void addNV(String str, String str2) {
            String access$0 = ParameterList.quote(str2);
            this.sb.append("; ");
            this.used += 2;
            if (((str.length() + access$0.length()) + 1) + this.used > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            this.sb.append(str).append('=');
            this.used += str.length() + 1;
            if (this.used + access$0.length() > 76) {
                access$0 = MimeUtility.fold(this.used, access$0);
                this.sb.append(access$0);
                int lastIndexOf = access$0.lastIndexOf(10);
                if (lastIndexOf >= 0) {
                    this.used = ((access$0.length() - lastIndexOf) - 1) + this.used;
                    return;
                }
                this.used = access$0.length() + this.used;
                return;
            }
            this.sb.append(access$0);
            this.used = access$0.length() + this.used;
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    class Value {
        String charset;
        String encodedValue;
        String value;

        private Value() {
        }
    }

    static {
        boolean z = true;
        encodeParameters = false;
        decodeParameters = false;
        decodeParametersStrict = false;
        applehack = false;
        try {
            String property = System.getProperty("mail.mime.encodeparameters");
            boolean z2 = property != null && property.equalsIgnoreCase("true");
            encodeParameters = z2;
            property = System.getProperty("mail.mime.decodeparameters");
            z2 = property != null && property.equalsIgnoreCase("true");
            decodeParameters = z2;
            property = System.getProperty("mail.mime.decodeparameters.strict");
            z2 = property != null && property.equalsIgnoreCase("true");
            decodeParametersStrict = z2;
            property = System.getProperty("mail.mime.applefilenames");
            if (property == null || !property.equalsIgnoreCase("true")) {
                z = false;
            }
            applehack = z;
        } catch (SecurityException e) {
        }
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParameterList(java.lang.String r8) {
        /*
        r7 = this;
        r6 = -4;
        r5 = -1;
        r7.<init>();
        r1 = new javax.mail.internet.HeaderTokenizer;
        r0 = "()<>@,;:\\\"\t []/?=";
        r1.<init>(r8, r0);
    L_0x000c:
        r2 = r1.next();
        r0 = r2.getType();
        if (r0 == r6) goto L_0x012d;
    L_0x0016:
        r3 = (char) r0;
        r4 = 59;
        if (r3 != r4) goto L_0x00c2;
    L_0x001b:
        r0 = r1.next();
        r2 = r0.getType();
        if (r2 == r6) goto L_0x012d;
    L_0x0025:
        r2 = r0.getType();
        if (r2 == r5) goto L_0x004a;
    L_0x002b:
        r1 = new javax.mail.internet.ParseException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expected parameter name, got \"";
        r2.<init>(r3);
        r0 = r0.getValue();
        r0 = r2.append(r0);
        r2 = "\"";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r0.getValue();
        r2 = java.util.Locale.ENGLISH;
        r0 = r0.toLowerCase(r2);
        r2 = r1.next();
        r3 = r2.getType();
        r3 = (char) r3;
        r4 = 61;
        if (r3 == r4) goto L_0x0080;
    L_0x0061:
        r0 = new javax.mail.internet.ParseException;
        r1 = new java.lang.StringBuilder;
        r3 = "Expected '=', got \"";
        r1.<init>(r3);
        r2 = r2.getValue();
        r1 = r1.append(r2);
        r2 = "\"";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0080:
        r2 = r1.next();
        r3 = r2.getType();
        if (r3 == r5) goto L_0x00ac;
    L_0x008a:
        r4 = -2;
        if (r3 == r4) goto L_0x00ac;
    L_0x008d:
        r0 = new javax.mail.internet.ParseException;
        r1 = new java.lang.StringBuilder;
        r3 = "Expected parameter value, got \"";
        r1.<init>(r3);
        r2 = r2.getValue();
        r1 = r1.append(r2);
        r2 = "\"";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ac:
        r2 = r2.getValue();
        r7.lastName = r0;
        r3 = decodeParameters;
        if (r3 == 0) goto L_0x00bb;
    L_0x00b6:
        r7.putEncodedName(r0, r2);
        goto L_0x000c;
    L_0x00bb:
        r3 = r7.list;
        r3.put(r0, r2);
        goto L_0x000c;
    L_0x00c2:
        r3 = applehack;
        if (r3 == 0) goto L_0x010e;
    L_0x00c6:
        if (r0 != r5) goto L_0x010e;
    L_0x00c8:
        r0 = r7.lastName;
        if (r0 == 0) goto L_0x010e;
    L_0x00cc:
        r0 = r7.lastName;
        r3 = "name";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00e0;
    L_0x00d6:
        r0 = r7.lastName;
        r3 = "filename";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x010e;
    L_0x00e0:
        r0 = r7.list;
        r3 = r7.lastName;
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r3 = new java.lang.StringBuilder;
        r0 = java.lang.String.valueOf(r0);
        r3.<init>(r0);
        r0 = " ";
        r0 = r3.append(r0);
        r2 = r2.getValue();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = r7.list;
        r3 = r7.lastName;
        r2.put(r3, r0);
        goto L_0x000c;
    L_0x010e:
        r0 = new javax.mail.internet.ParseException;
        r1 = new java.lang.StringBuilder;
        r3 = "Expected ';', got \"";
        r1.<init>(r3);
        r2 = r2.getValue();
        r1 = r1.append(r2);
        r2 = "\"";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x012d:
        r0 = decodeParameters;
        if (r0 == 0) goto L_0x0135;
    L_0x0131:
        r0 = 0;
        r7.combineMultisegmentNames(r0);
    L_0x0135:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    private void combineMultisegmentNames(boolean z) {
        StringBuffer stringBuffer;
        int i;
        String str;
        String stringBuilder;
        String str2;
        String str3;
        for (String str4 : this.multisegmentNames) {
            stringBuffer = new StringBuffer();
            MultiValue multiValue = new MultiValue();
            i = 0;
            str = null;
            while (true) {
                stringBuilder = new StringBuilder(String.valueOf(str4)).append("*").append(i).toString();
                Object obj = this.slist.get(stringBuilder);
                if (obj == null) {
                    break;
                }
                multiValue.add(obj);
                if (obj instanceof Value) {
                    try {
                        Value value = (Value) obj;
                        str2 = value.encodedValue;
                        if (i == 0) {
                            try {
                                Value decodeValue = decodeValue(str2);
                                str3 = decodeValue.charset;
                                value.charset = str3;
                                try {
                                    str = decodeValue.value;
                                    value.value = str;
                                    str2 = str;
                                    str = str3;
                                } catch (NumberFormatException e) {
                                    e = e;
                                    if (decodeParametersStrict) {
                                        NumberFormatException e2;
                                        throw new ParseException(e2.toString());
                                    }
                                    str = str3;
                                    stringBuffer.append(str2);
                                    this.slist.remove(stringBuilder);
                                    i++;
                                } catch (UnsupportedEncodingException e3) {
                                    e = e3;
                                    str = str3;
                                    if (decodeParametersStrict) {
                                        UnsupportedEncodingException e4;
                                        throw new ParseException(e4.toString());
                                    }
                                    stringBuffer.append(str2);
                                    this.slist.remove(stringBuilder);
                                    i++;
                                } catch (StringIndexOutOfBoundsException e5) {
                                    e = e5;
                                    str = str3;
                                    if (decodeParametersStrict) {
                                        StringIndexOutOfBoundsException e6;
                                        throw new ParseException(e6.toString());
                                    }
                                    stringBuffer.append(str2);
                                    this.slist.remove(stringBuilder);
                                    i++;
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    if (z) {
                                        if (this.slist.size() > 0) {
                                            for (Object next : this.slist.values()) {
                                                if (next instanceof Value) {
                                                    Value value2 = (Value) next;
                                                    Value decodeValue2 = decodeValue(value2.encodedValue);
                                                    value2.charset = decodeValue2.charset;
                                                    value2.value = decodeValue2.value;
                                                }
                                            }
                                            this.list.putAll(this.slist);
                                        }
                                        this.multisegmentNames.clear();
                                        this.slist.clear();
                                    }
                                }
                            } catch (NumberFormatException e7) {
                                e2 = e7;
                                str3 = str;
                            } catch (UnsupportedEncodingException e8) {
                                e4 = e8;
                                if (decodeParametersStrict) {
                                    throw new ParseException(e4.toString());
                                }
                                stringBuffer.append(str2);
                                this.slist.remove(stringBuilder);
                                i++;
                            } catch (StringIndexOutOfBoundsException e9) {
                                e6 = e9;
                                if (decodeParametersStrict) {
                                    throw new ParseException(e6.toString());
                                }
                                stringBuffer.append(str2);
                                this.slist.remove(stringBuilder);
                                i++;
                            }
                        } else if (str == null) {
                            this.multisegmentNames.remove(str4);
                            break;
                        } else {
                            str3 = decodeBytes(str2, str);
                            value.value = str3;
                            str2 = str3;
                        }
                    } catch (NumberFormatException e10) {
                        e2 = e10;
                        str2 = null;
                        str3 = str;
                        if (decodeParametersStrict) {
                            throw new ParseException(e2.toString());
                        }
                        str = str3;
                        stringBuffer.append(str2);
                        this.slist.remove(stringBuilder);
                        i++;
                    } catch (UnsupportedEncodingException e11) {
                        e4 = e11;
                        str2 = null;
                        if (decodeParametersStrict) {
                            throw new ParseException(e4.toString());
                        }
                        stringBuffer.append(str2);
                        this.slist.remove(stringBuilder);
                        i++;
                    } catch (StringIndexOutOfBoundsException e12) {
                        e6 = e12;
                        str2 = null;
                        if (decodeParametersStrict) {
                            throw new ParseException(e6.toString());
                        }
                        stringBuffer.append(str2);
                        this.slist.remove(stringBuilder);
                        i++;
                    }
                } else {
                    str2 = (String) obj;
                }
                stringBuffer.append(str2);
                this.slist.remove(stringBuilder);
                i++;
            }
            if (i == 0) {
                this.list.remove(str4);
            } else {
                multiValue.value = stringBuffer.toString();
                this.list.put(str4, multiValue);
            }
        }
        if (this.slist.size() > 0) {
            for (Object next2 : this.slist.values()) {
                if (next2 instanceof Value) {
                    value2 = (Value) next2;
                    Value decodeValue3 = decodeValue(value2.encodedValue);
                    value2.charset = decodeValue3.charset;
                    value2.value = decodeValue3.value;
                }
            }
            this.list.putAll(this.slist);
        }
        this.multisegmentNames.clear();
        this.slist.clear();
    }

    private static String decodeBytes(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        int i = 0;
        int i2 = 0;
        while (i2 < str.length()) {
            int i3;
            int charAt = str.charAt(i2);
            if (charAt == 37) {
                charAt = (char) Integer.parseInt(str.substring(i2 + 1, i2 + 3), 16);
                i3 = i2 + 2;
            } else {
                i3 = i2;
            }
            i2 = i + 1;
            bArr[i] = (byte) charAt;
            int i4 = i2;
            i2 = i3 + 1;
            i = i4;
        }
        return new String(bArr, 0, i, MimeUtility.javaCharset(str2));
    }

    private static Value decodeValue(String str) {
        Value value = new Value();
        value.encodedValue = str;
        value.value = str;
        try {
            int indexOf = str.indexOf(39);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int indexOf2 = str.indexOf(39, indexOf + 1);
                if (indexOf2 >= 0) {
                    str.substring(indexOf + 1, indexOf2);
                    String substring2 = str.substring(indexOf2 + 1);
                    value.charset = substring;
                    value.value = decodeBytes(substring2, substring);
                } else if (decodeParametersStrict) {
                    throw new ParseException("Missing language in encoded value: " + str);
                }
            } else if (decodeParametersStrict) {
                throw new ParseException("Missing charset in encoded value: " + str);
            }
        } catch (NumberFormatException e) {
            if (decodeParametersStrict) {
                throw new ParseException(e.toString());
            }
        } catch (UnsupportedEncodingException e2) {
            if (decodeParametersStrict) {
                throw new ParseException(e2.toString());
            }
        } catch (StringIndexOutOfBoundsException e3) {
            if (decodeParametersStrict) {
                throw new ParseException(e3.toString());
            }
        }
        return value;
    }

    private static Value encodeValue(String str, String str2) {
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer((bytes.length + str2.length()) + 2);
            stringBuffer.append(str2).append("''");
            for (byte b : bytes) {
                char c = (char) (b & 255);
                if (c <= ' ' || c >= '' || c == '*' || c == '\'' || c == '%' || HeaderTokenizer.MIME.indexOf(c) >= 0) {
                    stringBuffer.append('%').append(hex[c >> 4]).append(hex[c & 15]);
                } else {
                    stringBuffer.append(c);
                }
            }
            Value value = new Value();
            value.charset = str2;
            value.value = str;
            value.encodedValue = stringBuffer.toString();
            return value;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private void putEncodedName(String str, String str2) {
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            this.list.put(str, str2);
        } else if (indexOf == str.length() - 1) {
            this.list.put(str.substring(0, indexOf), decodeValue(str2));
        } else {
            Object value;
            Object substring;
            String substring2 = str.substring(0, indexOf);
            this.multisegmentNames.add(substring2);
            this.list.put(substring2, "");
            if (str.endsWith("*")) {
                value = new Value();
                ((Value) value).encodedValue = str2;
                ((Value) value).value = str2;
                substring = str.substring(0, str.length() - 1);
            } else {
                String str3 = str2;
            }
            this.slist.put(substring, value);
        }
    }

    private static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        return obj instanceof MultiValue ? ((MultiValue) obj).value : obj instanceof Value ? ((Value) obj).value : (String) obj;
    }

    public Enumeration getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        if (str != null || str2 == null || !str2.equals("DONE")) {
            String toLowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            if (decodeParameters) {
                try {
                    putEncodedName(toLowerCase, str2);
                    return;
                } catch (ParseException e) {
                    this.list.put(toLowerCase, str2);
                    return;
                }
            }
            this.list.put(toLowerCase, str2);
        } else if (decodeParameters && this.multisegmentNames.size() > 0) {
            try {
                combineMultisegmentNames(true);
            } catch (ParseException e2) {
            }
        }
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value encodeValue = encodeValue(str2, str3);
            if (encodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), encodeValue);
                return;
            } else {
                set(str, str2);
                return;
            }
        }
        set(str, str2);
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        ToStringBuffer toStringBuffer = new ToStringBuffer(i);
        for (String str : this.list.keySet()) {
            Object obj = this.list.get(str);
            if (obj instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) obj;
                String stringBuilder = new StringBuilder(String.valueOf(str)).append("*").toString();
                for (int i2 = 0; i2 < multiValue.size(); i2++) {
                    Object obj2 = multiValue.get(i2);
                    if (obj2 instanceof Value) {
                        toStringBuffer.addNV(new StringBuilder(String.valueOf(stringBuilder)).append(i2).append("*").toString(), ((Value) obj2).encodedValue);
                    } else {
                        toStringBuffer.addNV(new StringBuilder(String.valueOf(stringBuilder)).append(i2).toString(), (String) obj2);
                    }
                }
            } else if (obj instanceof Value) {
                toStringBuffer.addNV(new StringBuilder(String.valueOf(str)).append("*").toString(), ((Value) obj).encodedValue);
            } else {
                toStringBuffer.addNV(str, (String) obj);
            }
        }
        return toStringBuffer.toString();
    }
}
