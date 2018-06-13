package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.mail.Address;
import javax.mail.Session;

public class InternetAddress extends Address implements Cloneable {
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace(' ', '\u0000').replace('\t', '\u0000');
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    protected String address;
    protected String encodedPersonal;
    protected String personal;

    public InternetAddress(String str) {
        InternetAddress[] parse = parse(str, true);
        if (parse.length != 1) {
            throw new AddressException("Illegal address", str);
        }
        this.address = parse[0].address;
        this.personal = parse[0].personal;
        this.encodedPersonal = parse[0].encodedPersonal;
    }

    public InternetAddress(String str, String str2) {
        this(str, str2, null);
    }

    public InternetAddress(String str, String str2, String str3) {
        this.address = str;
        setPersonal(str2, str3);
    }

    public InternetAddress(String str, boolean z) {
        this(str);
        if (z) {
            checkAddress(this.address, true, true);
        }
    }

    private static void checkAddress(String str, boolean z, boolean z2) {
        int i = 0;
        if (str.indexOf(34) < 0) {
            int indexOfAny;
            String substring;
            String substring2;
            if (z) {
                while (true) {
                    indexOfAny = indexOfAny(str, ",:", i);
                    if (indexOfAny < 0) {
                        break;
                    } else if (str.charAt(i) != '@') {
                        throw new AddressException("Illegal route-addr", str);
                    } else if (str.charAt(indexOfAny) == ':') {
                        break;
                    } else {
                        i = indexOfAny + 1;
                    }
                }
                i = indexOfAny + 1;
            }
            indexOfAny = str.indexOf(64, i);
            if (indexOfAny >= 0) {
                if (indexOfAny == i) {
                    throw new AddressException("Missing local name", str);
                } else if (indexOfAny == str.length() - 1) {
                    throw new AddressException("Missing domain", str);
                } else {
                    substring = str.substring(i, indexOfAny);
                    substring2 = str.substring(indexOfAny + 1);
                }
            } else if (z2) {
                throw new AddressException("Missing final '@domain'", str);
            } else {
                substring2 = null;
                substring = str;
            }
            if (indexOfAny(str, " \t\n\r") >= 0) {
                throw new AddressException("Illegal whitespace in address", str);
            } else if (indexOfAny(substring, specialsNoDot) >= 0) {
                throw new AddressException("Illegal character in local name", str);
            } else if (substring2 != null && substring2.indexOf(91) < 0 && indexOfAny(substring2, specialsNoDot) >= 0) {
                throw new AddressException("Illegal character in domain", str);
            }
        }
    }

    public static InternetAddress getLocalAddress(Session session) {
        String property;
        String hostName;
        String str;
        if (session == null) {
            try {
                property = System.getProperty("user.name");
                hostName = InetAddress.getLocalHost().getHostName();
                str = null;
            } catch (SecurityException e) {
                return null;
            } catch (AddressException e2) {
                return null;
            } catch (UnknownHostException e3) {
                return null;
            }
        }
        str = session.getProperty("mail.from");
        if (str == null) {
            property = session.getProperty("mail.user");
            if (property == null || property.length() == 0) {
                property = session.getProperty("user.name");
            }
            if (property == null || property.length() == 0) {
                property = System.getProperty("user.name");
            }
            hostName = session.getProperty("mail.host");
            if (hostName == null || hostName.length() == 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                if (localHost != null) {
                    hostName = localHost.getHostName();
                }
            }
        } else {
            hostName = null;
            property = null;
        }
        hostName = (str != null || property == null || property.length() == 0 || hostName == null || hostName.length() == 0) ? str : new StringBuilder(String.valueOf(property)).append("@").append(hostName).toString();
        return hostName != null ? new InternetAddress(hostName) : null;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            for (int i2 = i; i2 < length; i2++) {
                if (str2.indexOf(str.charAt(i2)) >= 0) {
                    return i2;
                }
            }
            return -1;
        } catch (StringIndexOutOfBoundsException e) {
            return -1;
        }
    }

    private boolean isSimple() {
        return this.address == null || indexOfAny(this.address, specialsNoDotNoAt) < 0;
    }

    private static int lengthOfFirstSegment(String str) {
        int indexOf = str.indexOf("\r\n");
        return indexOf != -1 ? indexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i) {
        int lastIndexOf = str.lastIndexOf("\r\n");
        return lastIndexOf != -1 ? (str.length() - lastIndexOf) - 2 : str.length() + i;
    }

    public static InternetAddress[] parse(String str) {
        return parse(str, true);
    }

    public static InternetAddress[] parse(String str, boolean z) {
        return parse(str, z, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.mail.internet.InternetAddress[] parse(java.lang.String r14, boolean r15, boolean r16) {
        /*
        r0 = -1;
        r3 = -1;
        r9 = r14.length();
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r10 = new java.util.Vector;
        r10.<init>();
        r2 = -1;
        r1 = 0;
        r4 = r2;
    L_0x0011:
        if (r1 < r9) goto L_0x0053;
    L_0x0013:
        if (r4 < 0) goto L_0x0049;
    L_0x0015:
        r7 = -1;
        if (r2 != r7) goto L_0x0240;
    L_0x0018:
        r1 = r14.substring(r4, r1);
        r1 = r1.trim();
        if (r5 != 0) goto L_0x0026;
    L_0x0022:
        if (r15 != 0) goto L_0x0026;
    L_0x0024:
        if (r16 == 0) goto L_0x0220;
    L_0x0026:
        if (r15 != 0) goto L_0x002a;
    L_0x0028:
        if (r16 != 0) goto L_0x002e;
    L_0x002a:
        r2 = 0;
        checkAddress(r1, r6, r2);
    L_0x002e:
        r2 = new javax.mail.internet.InternetAddress;
        r2.<init>();
        r2.setAddress(r1);
        if (r0 < 0) goto L_0x0046;
    L_0x0038:
        r0 = r14.substring(r0, r3);
        r0 = r0.trim();
        r0 = unquote(r0);
        r2.encodedPersonal = r0;
    L_0x0046:
        r10.addElement(r2);
    L_0x0049:
        r0 = r10.size();
        r0 = new javax.mail.internet.InternetAddress[r0];
        r10.copyInto(r0);
        return r0;
    L_0x0053:
        r8 = r14.charAt(r1);
        switch(r8) {
            case 9: goto L_0x0216;
            case 10: goto L_0x0216;
            case 13: goto L_0x0216;
            case 32: goto L_0x0216;
            case 34: goto L_0x010f;
            case 40: goto L_0x0070;
            case 41: goto L_0x00ae;
            case 44: goto L_0x0149;
            case 58: goto L_0x01ca;
            case 59: goto L_0x01e3;
            case 60: goto L_0x00b6;
            case 62: goto L_0x0107;
            case 91: goto L_0x012f;
            default: goto L_0x005a;
        };
    L_0x005a:
        r8 = -1;
        if (r4 != r8) goto L_0x0243;
    L_0x005d:
        r4 = r0;
        r0 = r5;
        r5 = r1;
        r12 = r6;
        r6 = r2;
        r2 = r7;
        r7 = r1;
        r1 = r12;
    L_0x0065:
        r5 = r5 + 1;
        r12 = r0;
        r0 = r4;
        r4 = r7;
        r7 = r2;
        r2 = r6;
        r6 = r1;
        r1 = r5;
        r5 = r12;
        goto L_0x0011;
    L_0x0070:
        r5 = 1;
        if (r4 < 0) goto L_0x025f;
    L_0x0073:
        r8 = -1;
        if (r2 != r8) goto L_0x025f;
    L_0x0076:
        r8 = r1;
    L_0x0077:
        r2 = -1;
        if (r0 != r2) goto L_0x007c;
    L_0x007a:
        r0 = r1 + 1;
    L_0x007c:
        r2 = r1 + 1;
        r1 = 1;
    L_0x007f:
        if (r2 >= r9) goto L_0x0083;
    L_0x0081:
        if (r1 > 0) goto L_0x008d;
    L_0x0083:
        if (r1 <= 0) goto L_0x00a0;
    L_0x0085:
        r0 = new javax.mail.internet.AddressException;
        r1 = "Missing ')'";
        r0.<init>(r1, r14, r2);
        throw r0;
    L_0x008d:
        r11 = r14.charAt(r2);
        switch(r11) {
            case 40: goto L_0x009a;
            case 41: goto L_0x009d;
            case 92: goto L_0x0097;
            default: goto L_0x0094;
        };
    L_0x0094:
        r2 = r2 + 1;
        goto L_0x007f;
    L_0x0097:
        r2 = r2 + 1;
        goto L_0x0094;
    L_0x009a:
        r1 = r1 + 1;
        goto L_0x0094;
    L_0x009d:
        r1 = r1 + -1;
        goto L_0x0094;
    L_0x00a0:
        r1 = r2 + -1;
        r2 = -1;
        if (r3 != r2) goto L_0x0256;
    L_0x00a5:
        r2 = r7;
        r3 = r1;
        r7 = r4;
        r4 = r0;
        r0 = r5;
        r5 = r1;
        r1 = r6;
        r6 = r8;
        goto L_0x0065;
    L_0x00ae:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Missing '('";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x00b6:
        r5 = 1;
        if (r6 == 0) goto L_0x00c1;
    L_0x00b9:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Extra route-addr";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x00c1:
        if (r7 != 0) goto L_0x0252;
    L_0x00c3:
        if (r4 < 0) goto L_0x024f;
    L_0x00c5:
        r0 = r1;
    L_0x00c6:
        r2 = r1 + 1;
        r12 = r4;
        r4 = r2;
        r2 = r12;
    L_0x00cb:
        r3 = 0;
        r12 = r1;
        r1 = r3;
        r3 = r12;
    L_0x00cf:
        r3 = r3 + 1;
        if (r3 < r9) goto L_0x00df;
    L_0x00d3:
        if (r3 < r9) goto L_0x00fb;
    L_0x00d5:
        if (r1 == 0) goto L_0x00f3;
    L_0x00d7:
        r0 = new javax.mail.internet.AddressException;
        r1 = "Missing '\"'";
        r0.<init>(r1, r14, r3);
        throw r0;
    L_0x00df:
        r6 = r14.charAt(r3);
        switch(r6) {
            case 34: goto L_0x00e7;
            case 62: goto L_0x00f0;
            case 92: goto L_0x00eb;
            default: goto L_0x00e6;
        };
    L_0x00e6:
        goto L_0x00cf;
    L_0x00e7:
        if (r1 == 0) goto L_0x00ee;
    L_0x00e9:
        r1 = 0;
        goto L_0x00cf;
    L_0x00eb:
        r3 = r3 + 1;
        goto L_0x00cf;
    L_0x00ee:
        r1 = 1;
        goto L_0x00cf;
    L_0x00f0:
        if (r1 == 0) goto L_0x00d3;
    L_0x00f2:
        goto L_0x00cf;
    L_0x00f3:
        r0 = new javax.mail.internet.AddressException;
        r1 = "Missing '>'";
        r0.<init>(r1, r14, r3);
        throw r0;
    L_0x00fb:
        r1 = 1;
        r6 = r3;
        r12 = r7;
        r7 = r4;
        r4 = r2;
        r2 = r12;
        r13 = r3;
        r3 = r0;
        r0 = r5;
        r5 = r13;
        goto L_0x0065;
    L_0x0107:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Missing '<'";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x010f:
        r5 = 1;
        r8 = -1;
        if (r4 != r8) goto L_0x0114;
    L_0x0113:
        r4 = r1;
    L_0x0114:
        r1 = r1 + 1;
    L_0x0116:
        if (r1 < r9) goto L_0x0122;
    L_0x0118:
        if (r1 < r9) goto L_0x0243;
    L_0x011a:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Missing '\"'";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x0122:
        r8 = r14.charAt(r1);
        switch(r8) {
            case 34: goto L_0x0118;
            case 92: goto L_0x012c;
            default: goto L_0x0129;
        };
    L_0x0129:
        r1 = r1 + 1;
        goto L_0x0116;
    L_0x012c:
        r1 = r1 + 1;
        goto L_0x0129;
    L_0x012f:
        r5 = 1;
    L_0x0130:
        r1 = r1 + 1;
        if (r1 < r9) goto L_0x013e;
    L_0x0134:
        if (r1 < r9) goto L_0x0243;
    L_0x0136:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Missing ']'";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x013e:
        r8 = r14.charAt(r1);
        switch(r8) {
            case 92: goto L_0x0146;
            case 93: goto L_0x0134;
            default: goto L_0x0145;
        };
    L_0x0145:
        goto L_0x0130;
    L_0x0146:
        r1 = r1 + 1;
        goto L_0x0130;
    L_0x0149:
        r8 = -1;
        if (r4 != r8) goto L_0x0159;
    L_0x014c:
        r4 = 0;
        r2 = 0;
        r5 = -1;
        r6 = r5;
        r12 = r4;
        r4 = r0;
        r0 = r2;
        r2 = r7;
        r7 = r5;
        r5 = r1;
        r1 = r12;
        goto L_0x0065;
    L_0x0159:
        if (r7 == 0) goto L_0x0166;
    L_0x015b:
        r6 = 0;
        r12 = r5;
        r5 = r1;
        r1 = r6;
        r6 = r2;
        r2 = r7;
        r7 = r4;
        r4 = r0;
        r0 = r12;
        goto L_0x0065;
    L_0x0166:
        r8 = -1;
        if (r2 != r8) goto L_0x016a;
    L_0x0169:
        r2 = r1;
    L_0x016a:
        r2 = r14.substring(r4, r2);
        r2 = r2.trim();
        if (r5 != 0) goto L_0x0178;
    L_0x0174:
        if (r15 != 0) goto L_0x0178;
    L_0x0176:
        if (r16 == 0) goto L_0x01aa;
    L_0x0178:
        if (r15 != 0) goto L_0x017c;
    L_0x017a:
        if (r16 != 0) goto L_0x0180;
    L_0x017c:
        r4 = 0;
        checkAddress(r2, r6, r4);
    L_0x0180:
        r4 = new javax.mail.internet.InternetAddress;
        r4.<init>();
        r4.setAddress(r2);
        if (r0 < 0) goto L_0x019a;
    L_0x018a:
        r0 = r14.substring(r0, r3);
        r0 = r0.trim();
        r0 = unquote(r0);
        r4.encodedPersonal = r0;
        r3 = -1;
        r0 = r3;
    L_0x019a:
        r10.addElement(r4);
    L_0x019d:
        r4 = 0;
        r2 = 0;
        r5 = -1;
        r6 = r5;
        r12 = r4;
        r4 = r0;
        r0 = r2;
        r2 = r7;
        r7 = r5;
        r5 = r1;
        r1 = r12;
        goto L_0x0065;
    L_0x01aa:
        r4 = new java.util.StringTokenizer;
        r4.<init>(r2);
    L_0x01af:
        r2 = r4.hasMoreTokens();
        if (r2 == 0) goto L_0x019d;
    L_0x01b5:
        r2 = r4.nextToken();
        r5 = 0;
        r6 = 0;
        checkAddress(r2, r5, r6);
        r5 = new javax.mail.internet.InternetAddress;
        r5.<init>();
        r5.setAddress(r2);
        r10.addElement(r5);
        goto L_0x01af;
    L_0x01ca:
        r5 = 1;
        if (r7 == 0) goto L_0x01d5;
    L_0x01cd:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Nested group";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x01d5:
        r7 = 1;
        r8 = -1;
        if (r4 != r8) goto L_0x0243;
    L_0x01d9:
        r4 = r0;
        r0 = r5;
        r5 = r1;
        r12 = r6;
        r6 = r2;
        r2 = r7;
        r7 = r1;
        r1 = r12;
        goto L_0x0065;
    L_0x01e3:
        r2 = -1;
        if (r4 != r2) goto L_0x024d;
    L_0x01e6:
        r2 = r1;
    L_0x01e7:
        if (r7 != 0) goto L_0x01f1;
    L_0x01e9:
        r0 = new javax.mail.internet.AddressException;
        r2 = "Illegal semicolon, not in group";
        r0.<init>(r2, r14, r1);
        throw r0;
    L_0x01f1:
        r4 = 0;
        r6 = -1;
        if (r2 != r6) goto L_0x01f6;
    L_0x01f5:
        r2 = r1;
    L_0x01f6:
        r6 = new javax.mail.internet.InternetAddress;
        r6.<init>();
        r7 = r1 + 1;
        r2 = r14.substring(r2, r7);
        r2 = r2.trim();
        r6.setAddress(r2);
        r10.addElement(r6);
        r2 = 0;
        r6 = -1;
        r7 = r6;
        r12 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r5;
        r5 = r1;
        r1 = r12;
        goto L_0x0065;
    L_0x0216:
        r12 = r5;
        r5 = r1;
        r1 = r6;
        r6 = r2;
        r2 = r7;
        r7 = r4;
        r4 = r0;
        r0 = r12;
        goto L_0x0065;
    L_0x0220:
        r0 = new java.util.StringTokenizer;
        r0.<init>(r1);
    L_0x0225:
        r1 = r0.hasMoreTokens();
        if (r1 == 0) goto L_0x0049;
    L_0x022b:
        r1 = r0.nextToken();
        r2 = 0;
        r3 = 0;
        checkAddress(r1, r2, r3);
        r2 = new javax.mail.internet.InternetAddress;
        r2.<init>();
        r2.setAddress(r1);
        r10.addElement(r2);
        goto L_0x0225;
    L_0x0240:
        r1 = r2;
        goto L_0x0018;
    L_0x0243:
        r12 = r5;
        r5 = r1;
        r1 = r6;
        r6 = r2;
        r2 = r7;
        r7 = r4;
        r4 = r0;
        r0 = r12;
        goto L_0x0065;
    L_0x024d:
        r2 = r4;
        goto L_0x01e7;
    L_0x024f:
        r0 = r3;
        goto L_0x00c6;
    L_0x0252:
        r2 = r0;
        r0 = r3;
        goto L_0x00cb;
    L_0x0256:
        r2 = r7;
        r7 = r4;
        r4 = r0;
        r0 = r5;
        r5 = r1;
        r1 = r6;
        r6 = r8;
        goto L_0x0065;
    L_0x025f:
        r8 = r2;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetAddress.parse(java.lang.String, boolean, boolean):javax.mail.internet.InternetAddress[]");
    }

    public static InternetAddress[] parseHeader(String str, boolean z) {
        return parse(str, z, true);
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        Object obj = null;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 == '\"' || charAt2 == '\\') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
            if ((charAt < ' ' && charAt != '\r' && charAt != '\n' && charAt != '\t') || charAt >= '' || rfc822phrase.indexOf(charAt) >= 0) {
                obj = 1;
            }
        }
        if (obj == null) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer(length + 2);
        stringBuffer2.append('\"').append(str).append('\"');
        return stringBuffer2.toString();
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public static String toString(Address[] addressArr, int i) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
                i += 2;
            }
            String address = addressArr[i2].toString();
            if (lengthOfFirstSegment(address) + i > 76) {
                stringBuffer.append("\r\n\t");
                i = 8;
            }
            stringBuffer.append(address);
            i = lengthOfLastSegment(address, i);
        }
        return stringBuffer.toString();
    }

    private static String unquote(String str) {
        if (!str.startsWith("\"") || !str.endsWith("\"")) {
            return str;
        }
        str = str.substring(1, str.length() - 1);
        if (str.indexOf(92) < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        int i = 0;
        while (i < str.length()) {
            int i2;
            char c;
            char charAt = str.charAt(i);
            if (charAt != '\\' || i >= str.length() - 1) {
                char c2 = charAt;
                i2 = i;
                c = c2;
            } else {
                i2 = i + 1;
                c = str.charAt(i2);
            }
            stringBuffer.append(c);
            i = i2 + 1;
        }
        return stringBuffer.toString();
    }

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternetAddress)) {
            return false;
        }
        String address = ((InternetAddress) obj).getAddress();
        return address == this.address ? true : this.address != null && this.address.equalsIgnoreCase(address);
    }

    public String getAddress() {
        return this.address;
    }

    public InternetAddress[] getGroup(boolean z) {
        String address = getAddress();
        if (!address.endsWith(";")) {
            return null;
        }
        int indexOf = address.indexOf(58);
        return indexOf >= 0 ? parseHeader(address.substring(indexOf + 1, address.length() - 1), z) : null;
    }

    public String getPersonal() {
        if (this.personal != null) {
            return this.personal;
        }
        if (this.encodedPersonal == null) {
            return null;
        }
        try {
            this.personal = MimeUtility.decodeText(this.encodedPersonal);
            return this.personal;
        } catch (Exception e) {
            return this.encodedPersonal;
        }
    }

    public String getType() {
        return "rfc822";
    }

    public int hashCode() {
        return this.address == null ? 0 : this.address.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public boolean isGroup() {
        return this.address != null && this.address.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPersonal(String str) {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str);
        } else {
            this.encodedPersonal = null;
        }
    }

    public void setPersonal(String str, String str2) {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, null);
        } else {
            this.encodedPersonal = null;
        }
    }

    public String toString() {
        if (this.encodedPersonal == null && this.personal != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(this.personal);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return this.encodedPersonal != null ? new StringBuilder(String.valueOf(quotePhrase(this.encodedPersonal))).append(" <").append(this.address).append(">").toString() : (isGroup() || isSimple()) ? this.address : "<" + this.address + ">";
    }

    public String toUnicodeString() {
        String personal = getPersonal();
        return personal != null ? quotePhrase(personal) + " <" + this.address + ">" : (isGroup() || isSimple()) ? this.address : "<" + this.address + ">";
    }

    public void validate() {
        checkAddress(getAddress(), true, true);
    }
}
