package javax.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.BitSet;
import java.util.Locale;

public class URLName {
    static final int caseDiff = 32;
    private static boolean doEncode;
    static BitSet dontNeedEncoding = new BitSet(256);
    private String file;
    protected String fullURL;
    private int hashCode;
    private String host;
    private InetAddress hostAddress;
    private boolean hostAddressKnown;
    private String password;
    private int port;
    private String protocol;
    private String ref;
    private String username;

    static {
        int i;
        boolean z = true;
        doEncode = true;
        try {
            if (Boolean.getBoolean("mail.URLName.dontencode")) {
                z = false;
            }
            doEncode = z;
        } catch (Exception e) {
        }
        for (i = 97; i <= 122; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = 65; i <= 90; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = 48; i <= 57; i++) {
            dontNeedEncoding.set(i);
        }
        dontNeedEncoding.set(caseDiff);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
    }

    public URLName(String str) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        parseString(str);
    }

    public URLName(String str, String str2, int i, String str3, String str4, String str5) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        this.protocol = str;
        this.host = str2;
        this.port = i;
        if (str3 != null) {
            int indexOf = str3.indexOf(35);
            if (indexOf != -1) {
                this.file = str3.substring(0, indexOf);
                this.ref = str3.substring(indexOf + 1);
                if (doEncode) {
                    str4 = encode(str4);
                }
                this.username = str4;
                if (doEncode) {
                    str5 = encode(str5);
                }
                this.password = str5;
            }
        }
        this.file = str3;
        this.ref = null;
        if (doEncode) {
            str4 = encode(str4);
        }
        this.username = str4;
        if (doEncode) {
            str5 = encode(str5);
        }
        this.password = str5;
    }

    public URLName(URL url) {
        this(url.toString());
    }

    private static String _encode(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        for (int i = 0; i < str.length(); i++) {
            int charAt = str.charAt(i);
            if (dontNeedEncoding.get(charAt)) {
                if (charAt == caseDiff) {
                    charAt = 43;
                }
                stringBuffer.append((char) charAt);
            } else {
                try {
                    outputStreamWriter.write(charAt);
                    outputStreamWriter.flush();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    for (charAt = 0; charAt < toByteArray.length; charAt++) {
                        stringBuffer.append('%');
                        char forDigit = Character.forDigit((toByteArray[charAt] >> 4) & 15, 16);
                        if (Character.isLetter(forDigit)) {
                            forDigit = (char) (forDigit - 32);
                        }
                        stringBuffer.append(forDigit);
                        forDigit = Character.forDigit(toByteArray[charAt] & 15, 16);
                        if (Character.isLetter(forDigit)) {
                            forDigit = (char) (forDigit - 32);
                        }
                        stringBuffer.append(forDigit);
                    }
                    byteArrayOutputStream.reset();
                } catch (IOException e) {
                    byteArrayOutputStream.reset();
                }
            }
        }
        return stringBuffer.toString();
    }

    static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (indexOfAny(str, "+%") == -1) {
            return str;
        }
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '%':
                    try {
                        stringBuffer.append((char) Integer.parseInt(str.substring(i + 1, i + 3), 16));
                        i += 2;
                        break;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                case '+':
                    stringBuffer.append(' ');
                    break;
                default:
                    stringBuffer.append(charAt);
                    break;
            }
            i++;
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            str2 = new String(stringBuffer2.getBytes("8859_1"));
        } catch (UnsupportedEncodingException e2) {
            str2 = stringBuffer2;
        }
        return str2;
    }

    static String encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ' || !dontNeedEncoding.get(charAt)) {
                return _encode(str);
            }
        }
        return str;
    }

    private synchronized InetAddress getHostAddress() {
        InetAddress inetAddress = null;
        synchronized (this) {
            if (this.hostAddressKnown) {
                inetAddress = this.hostAddress;
            } else if (this.host != null) {
                try {
                    this.hostAddress = InetAddress.getByName(this.host);
                } catch (UnknownHostException e) {
                    this.hostAddress = null;
                }
                this.hostAddressKnown = true;
                inetAddress = this.hostAddress;
            }
        }
        return inetAddress;
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

    public boolean equals(Object obj) {
        if (!(obj instanceof URLName)) {
            return false;
        }
        URLName uRLName = (URLName) obj;
        if (uRLName.protocol == null || !uRLName.protocol.equals(this.protocol)) {
            return false;
        }
        InetAddress hostAddress = getHostAddress();
        InetAddress hostAddress2 = uRLName.getHostAddress();
        if (hostAddress == null || hostAddress2 == null) {
            if (this.host == null || uRLName.host == null) {
                if (this.host != uRLName.host) {
                    return false;
                }
            } else if (!this.host.equalsIgnoreCase(uRLName.host)) {
                return false;
            }
        } else if (!hostAddress.equals(hostAddress2)) {
            return false;
        }
        if (this.username != uRLName.username && (this.username == null || !this.username.equals(uRLName.username))) {
            return false;
        }
        return !(this.file == null ? "" : this.file).equals(uRLName.file == null ? "" : uRLName.file) ? false : this.port == uRLName.port;
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return doEncode ? decode(this.password) : this.password;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRef() {
        return this.ref;
    }

    public URL getURL() {
        return new URL(getProtocol(), getHost(), getPort(), getFile());
    }

    public String getUsername() {
        return doEncode ? decode(this.username) : this.username;
    }

    public int hashCode() {
        if (this.hashCode != 0) {
            return this.hashCode;
        }
        if (this.protocol != null) {
            this.hashCode += this.protocol.hashCode();
        }
        InetAddress hostAddress = getHostAddress();
        if (hostAddress != null) {
            this.hashCode = hostAddress.hashCode() + this.hashCode;
        } else if (this.host != null) {
            this.hashCode += this.host.toLowerCase(Locale.ENGLISH).hashCode();
        }
        if (this.username != null) {
            this.hashCode += this.username.hashCode();
        }
        if (this.file != null) {
            this.hashCode += this.file.hashCode();
        }
        this.hashCode += this.port;
        return this.hashCode;
    }

    protected void parseString(String str) {
        this.password = null;
        this.username = null;
        this.host = null;
        this.ref = null;
        this.file = null;
        this.protocol = null;
        this.port = -1;
        int length = str.length();
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            this.protocol = str.substring(0, indexOf);
        }
        if (str.regionMatches(indexOf + 1, "//", 0, 2)) {
            String substring;
            String substring2;
            int indexOf2 = str.indexOf(47, indexOf + 3);
            if (indexOf2 != -1) {
                substring = str.substring(indexOf + 3, indexOf2);
                if (indexOf2 + 1 < length) {
                    this.file = str.substring(indexOf2 + 1);
                } else {
                    this.file = "";
                }
            } else {
                substring = str.substring(indexOf + 3);
            }
            length = substring.indexOf(64);
            if (length != -1) {
                substring2 = substring.substring(0, length);
                substring = substring.substring(length + 1);
                length = substring2.indexOf(58);
                if (length != -1) {
                    this.username = substring2.substring(0, length);
                    this.password = substring2.substring(length + 1);
                } else {
                    this.username = substring2;
                }
            }
            length = (substring.length() <= 0 || substring.charAt(0) != '[') ? substring.indexOf(58) : substring.indexOf(58, substring.indexOf(93));
            if (length != -1) {
                substring2 = substring.substring(length + 1);
                if (substring2.length() > 0) {
                    try {
                        this.port = Integer.parseInt(substring2);
                    } catch (NumberFormatException e) {
                        this.port = -1;
                    }
                }
                this.host = substring.substring(0, length);
            } else {
                this.host = substring;
            }
        } else if (indexOf + 1 < length) {
            this.file = str.substring(indexOf + 1);
        }
        if (this.file != null) {
            indexOf = this.file.indexOf(35);
            if (indexOf != -1) {
                this.ref = this.file.substring(indexOf + 1);
                this.file = this.file.substring(0, indexOf);
            }
        }
    }

    public String toString() {
        if (this.fullURL == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.protocol != null) {
                stringBuffer.append(this.protocol);
                stringBuffer.append(":");
            }
            if (!(this.username == null && this.host == null)) {
                stringBuffer.append("//");
                if (this.username != null) {
                    stringBuffer.append(this.username);
                    if (this.password != null) {
                        stringBuffer.append(":");
                        stringBuffer.append(this.password);
                    }
                    stringBuffer.append("@");
                }
                if (this.host != null) {
                    stringBuffer.append(this.host);
                }
                if (this.port != -1) {
                    stringBuffer.append(":");
                    stringBuffer.append(Integer.toString(this.port));
                }
                if (this.file != null) {
                    stringBuffer.append("/");
                }
            }
            if (this.file != null) {
                stringBuffer.append(this.file);
            }
            if (this.ref != null) {
                stringBuffer.append("#");
                stringBuffer.append(this.ref);
            }
            this.fullURL = stringBuffer.toString();
        }
        return this.fullURL;
    }
}
