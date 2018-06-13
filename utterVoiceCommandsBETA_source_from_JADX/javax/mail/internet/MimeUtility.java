package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.QDecoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;

public class MimeUtility {
    public static final int ALL = -1;
    static final int ALL_ASCII = 1;
    static final int MOSTLY_ASCII = 2;
    static final int MOSTLY_NONASCII = 3;
    private static boolean decodeStrict;
    private static String defaultJavaCharset;
    private static String defaultMIMECharset;
    private static boolean encodeEolStrict;
    private static boolean foldEncodedWords;
    private static boolean foldText;
    private static Hashtable java2mime = new Hashtable(40);
    private static Hashtable mime2java = new Hashtable(10);

    static {
        Throwable th;
        boolean z = false;
        decodeStrict = true;
        encodeEolStrict = false;
        foldEncodedWords = false;
        foldText = true;
        try {
            String property = System.getProperty("mail.mime.decodetext.strict");
            boolean z2 = property == null || !property.equalsIgnoreCase("false");
            decodeStrict = z2;
            property = System.getProperty("mail.mime.encodeeol.strict");
            z2 = property != null && property.equalsIgnoreCase("true");
            encodeEolStrict = z2;
            property = System.getProperty("mail.mime.foldencodedwords");
            z2 = property != null && property.equalsIgnoreCase("true");
            foldEncodedWords = z2;
            property = System.getProperty("mail.mime.foldtext");
            if (property == null || !property.equalsIgnoreCase("false")) {
                z = true;
            }
            foldText = z;
        } catch (SecurityException e) {
        }
        try {
            InputStream resourceAsStream = MimeUtility.class.getResourceAsStream("/META-INF/javamail.charset.map");
            if (resourceAsStream != null) {
                InputStream lineInputStream;
                try {
                    lineInputStream = new LineInputStream(resourceAsStream);
                    try {
                        loadMappings((LineInputStream) lineInputStream, java2mime);
                        loadMappings((LineInputStream) lineInputStream, mime2java);
                        try {
                            lineInputStream.close();
                        } catch (Exception e2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            lineInputStream.close();
                        } catch (Exception e3) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    lineInputStream = resourceAsStream;
                    lineInputStream.close();
                    throw th;
                }
            }
        } catch (Exception e4) {
        }
        if (java2mime.isEmpty()) {
            java2mime.put("8859_1", "ISO-8859-1");
            java2mime.put("iso8859_1", "ISO-8859-1");
            java2mime.put("iso8859-1", "ISO-8859-1");
            java2mime.put("8859_2", "ISO-8859-2");
            java2mime.put("iso8859_2", "ISO-8859-2");
            java2mime.put("iso8859-2", "ISO-8859-2");
            java2mime.put("8859_3", "ISO-8859-3");
            java2mime.put("iso8859_3", "ISO-8859-3");
            java2mime.put("iso8859-3", "ISO-8859-3");
            java2mime.put("8859_4", "ISO-8859-4");
            java2mime.put("iso8859_4", "ISO-8859-4");
            java2mime.put("iso8859-4", "ISO-8859-4");
            java2mime.put("8859_5", "ISO-8859-5");
            java2mime.put("iso8859_5", "ISO-8859-5");
            java2mime.put("iso8859-5", "ISO-8859-5");
            java2mime.put("8859_6", "ISO-8859-6");
            java2mime.put("iso8859_6", "ISO-8859-6");
            java2mime.put("iso8859-6", "ISO-8859-6");
            java2mime.put("8859_7", "ISO-8859-7");
            java2mime.put("iso8859_7", "ISO-8859-7");
            java2mime.put("iso8859-7", "ISO-8859-7");
            java2mime.put("8859_8", "ISO-8859-8");
            java2mime.put("iso8859_8", "ISO-8859-8");
            java2mime.put("iso8859-8", "ISO-8859-8");
            java2mime.put("8859_9", "ISO-8859-9");
            java2mime.put("iso8859_9", "ISO-8859-9");
            java2mime.put("iso8859-9", "ISO-8859-9");
            java2mime.put("sjis", "Shift_JIS");
            java2mime.put("jis", "ISO-2022-JP");
            java2mime.put("iso2022jp", "ISO-2022-JP");
            java2mime.put("euc_jp", "euc-jp");
            java2mime.put("koi8_r", "koi8-r");
            java2mime.put("euc_cn", "euc-cn");
            java2mime.put("euc_tw", "euc-tw");
            java2mime.put("euc_kr", "euc-kr");
        }
        if (mime2java.isEmpty()) {
            mime2java.put("iso-2022-cn", "ISO2022CN");
            mime2java.put("iso-2022-kr", "ISO2022KR");
            mime2java.put("utf-8", "UTF8");
            mime2java.put("utf8", "UTF8");
            mime2java.put("ja_jp.iso2022-7", "ISO2022JP");
            mime2java.put("ja_jp.eucjp", "EUCJIS");
            mime2java.put("euc-kr", "KSC5601");
            mime2java.put("euckr", "KSC5601");
            mime2java.put("us-ascii", "ISO-8859-1");
            mime2java.put("x-us-ascii", "ISO-8859-1");
        }
    }

    private MimeUtility() {
    }

    static int checkAscii(InputStream inputStream, int i, boolean z) {
        byte[] bArr;
        int i2;
        int i3;
        Object obj;
        Object obj2;
        int i4;
        int i5;
        Object obj3;
        Object obj4 = (encodeEolStrict && z) ? 1 : null;
        if (i != 0) {
            int min = i == -1 ? 4096 : Math.min(i, 4096);
            bArr = new byte[min];
            i2 = 0;
            i3 = min;
            obj = null;
            obj2 = null;
            i4 = 0;
            i5 = 0;
        } else {
            bArr = null;
            i2 = 0;
            i3 = 4096;
            obj = null;
            obj2 = null;
            i4 = 0;
            i5 = 0;
        }
        while (i != 0) {
            try {
                int read = inputStream.read(bArr, 0, i3);
                if (read == -1) {
                    break;
                }
                int i6 = i2;
                int i7 = 0;
                int i8 = 0;
                Object obj5 = obj2;
                int i9 = i5;
                Object obj6 = obj5;
                int i10 = i4;
                Object obj7 = obj;
                min = i10;
                while (i7 < read) {
                    try {
                        i2 = bArr[i7] & 255;
                        if (obj4 != null && ((r5 == 13 && i2 != 10) || (r5 != 13 && i2 == 10))) {
                            obj7 = 1;
                        }
                        if (i2 == 13 || i2 == 10) {
                            i8 = 0;
                        } else {
                            i8 = i6 + 1;
                            if (i8 > 998) {
                                obj6 = 1;
                            }
                        }
                        if (!nonascii(i2)) {
                            i9++;
                        } else if (z) {
                            return 3;
                        } else {
                            min++;
                        }
                        i7++;
                        i6 = i8;
                        i8 = i2;
                    } catch (IOException e) {
                        obj3 = obj7;
                        i4 = min;
                        obj = obj3;
                        obj5 = obj6;
                        i5 = i9;
                        obj2 = obj5;
                    }
                }
                int i11;
                if (i != -1) {
                    i -= read;
                    i2 = i6;
                    obj3 = obj6;
                    i5 = i9;
                    obj2 = obj3;
                    i11 = min;
                    obj = obj7;
                    i4 = i11;
                } else {
                    i2 = i6;
                    obj3 = obj6;
                    i5 = i9;
                    obj2 = obj3;
                    i11 = min;
                    obj = obj7;
                    i4 = i11;
                }
            } catch (IOException e2) {
            }
        }
        return (i == 0 && z) ? 3 : i4 == 0 ? obj != null ? 3 : obj2 != null ? 2 : 1 : i5 > i4 ? 2 : 3;
    }

    static int checkAscii(String str) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (nonascii(str.charAt(i3))) {
                i++;
            } else {
                i2++;
            }
        }
        return i == 0 ? 1 : i2 > i ? 2 : 3;
    }

    static int checkAscii(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length) {
            if (nonascii(bArr[i] & 255)) {
                i2++;
            } else {
                i3++;
            }
            i++;
        }
        return i2 == 0 ? 1 : i3 > i2 ? 2 : 3;
    }

    public static InputStream decode(InputStream inputStream, String str) {
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return inputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    private static String decodeInnerWords(String str) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int indexOf = str.indexOf("=?", i);
            if (indexOf >= 0) {
                stringBuffer.append(str.substring(i, indexOf));
                int indexOf2 = str.indexOf(63, indexOf + 2);
                if (indexOf2 < 0) {
                    break;
                }
                indexOf2 = str.indexOf(63, indexOf2 + 1);
                if (indexOf2 < 0) {
                    break;
                }
                indexOf2 = str.indexOf("?=", indexOf2 + 1);
                if (indexOf2 < 0) {
                    break;
                }
                String substring = str.substring(indexOf, indexOf2 + 2);
                try {
                    substring = decodeWord(substring);
                } catch (ParseException e) {
                }
                stringBuffer.append(substring);
                i = indexOf2 + 2;
            } else {
                break;
            }
        }
        if (i == 0) {
            return str;
        }
        if (i < str.length()) {
            stringBuffer.append(str.substring(i));
        }
        return stringBuffer.toString();
    }

    public static String decodeText(String str) {
        String decodeWord;
        String str2 = " \t\n\r";
        if (str.indexOf("=?") == -1) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2, true);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            char charAt = nextToken.charAt(0);
            if (charAt == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n') {
                stringBuffer2.append(charAt);
            } else {
                try {
                    decodeWord = decodeWord(nextToken);
                    if (!z && stringBuffer2.length() > 0) {
                        stringBuffer.append(stringBuffer2);
                    }
                    z = true;
                } catch (ParseException e) {
                    if (decodeStrict) {
                        if (stringBuffer2.length() > 0) {
                            stringBuffer.append(stringBuffer2);
                        }
                        decodeWord = nextToken;
                        z = false;
                    } else {
                        decodeWord = decodeInnerWords(nextToken);
                        if (decodeWord != nextToken) {
                            if (!(z && nextToken.startsWith("=?")) && stringBuffer2.length() > 0) {
                                stringBuffer.append(stringBuffer2);
                            }
                            z = nextToken.endsWith("?=");
                        } else {
                            if (stringBuffer2.length() > 0) {
                                stringBuffer.append(stringBuffer2);
                            }
                            decodeWord = nextToken;
                            z = false;
                        }
                    }
                }
                stringBuffer.append(decodeWord);
                stringBuffer2.setLength(0);
            }
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    public static String decodeWord(String str) {
        if (str.startsWith("=?")) {
            int indexOf = str.indexOf(63, 2);
            if (indexOf == -1) {
                throw new ParseException("encoded word does not include charset: " + str);
            }
            String javaCharset = javaCharset(str.substring(2, indexOf));
            indexOf++;
            int indexOf2 = str.indexOf(63, indexOf);
            if (indexOf2 == -1) {
                throw new ParseException("encoded word does not include encoding: " + str);
            }
            String substring = str.substring(indexOf, indexOf2);
            indexOf2++;
            int indexOf3 = str.indexOf("?=", indexOf2);
            if (indexOf3 == -1) {
                throw new ParseException("encoded word does not end with \"?=\": " + str);
            }
            String substring2 = str.substring(indexOf2, indexOf3);
            try {
                if (substring2.length() > 0) {
                    InputStream bASE64DecoderStream;
                    InputStream byteArrayInputStream = new ByteArrayInputStream(ASCIIUtility.getBytes(substring2));
                    if (substring.equalsIgnoreCase("B")) {
                        bASE64DecoderStream = new BASE64DecoderStream(byteArrayInputStream);
                    } else if (substring.equalsIgnoreCase("Q")) {
                        bASE64DecoderStream = new QDecoderStream(byteArrayInputStream);
                    } else {
                        throw new UnsupportedEncodingException("unknown encoding: " + substring);
                    }
                    indexOf2 = byteArrayInputStream.available();
                    byte[] bArr = new byte[indexOf2];
                    indexOf2 = bASE64DecoderStream.read(bArr, 0, indexOf2);
                    substring = indexOf2 <= 0 ? "" : new String(bArr, 0, indexOf2, javaCharset);
                } else {
                    substring = "";
                }
                if (indexOf3 + 2 >= str.length()) {
                    return substring;
                }
                substring2 = str.substring(indexOf3 + 2);
                if (!decodeStrict) {
                    substring2 = decodeInnerWords(substring2);
                }
                return new StringBuilder(String.valueOf(substring)).append(substring2).toString();
            } catch (UnsupportedEncodingException e) {
                throw e;
            } catch (IOException e2) {
                throw new ParseException(e2.toString());
            } catch (IllegalArgumentException e3) {
                throw new UnsupportedEncodingException(javaCharset);
            }
        }
        throw new ParseException("encoded word does not start with \"=?\": " + str);
    }

    private static void doEncode(String str, boolean z, String str2, int i, String str3, boolean z2, boolean z3, StringBuffer stringBuffer) {
        boolean z4 = z2;
        String str4 = str3;
        int i2 = i;
        String str5 = str2;
        boolean z5 = z;
        while (true) {
            byte[] bytes = str.getBytes(str5);
            if ((z5 ? BEncoderStream.encodedLength(bytes) : QEncoderStream.encodedLength(bytes, z3)) <= i2) {
                break;
            }
            int length = str.length();
            if (length <= 1) {
                break;
            }
            doEncode(str.substring(0, length / 2), z5, str5, i2, str4, z4, z3, stringBuffer);
            str = str.substring(length / 2, length);
            z4 = false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream bEncoderStream = z5 ? new BEncoderStream(byteArrayOutputStream) : new QEncoderStream(byteArrayOutputStream, z3);
        try {
            bEncoderStream.write(bytes);
            bEncoderStream.close();
        } catch (IOException e) {
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        if (!z4) {
            if (foldEncodedWords) {
                stringBuffer.append("\r\n ");
            } else {
                stringBuffer.append(" ");
            }
        }
        stringBuffer.append(str4);
        for (byte b : toByteArray) {
            stringBuffer.append((char) b);
        }
        stringBuffer.append("?=");
    }

    public static OutputStream encode(OutputStream outputStream, String str) {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream, str2);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static String encodeText(String str) {
        return encodeText(str, null, null);
    }

    public static String encodeText(String str, String str2, String str3) {
        return encodeWord(str, str2, str3, false);
    }

    public static String encodeWord(String str) {
        return encodeWord(str, null, null);
    }

    public static String encodeWord(String str, String str2, String str3) {
        return encodeWord(str, str2, str3, true);
    }

    private static String encodeWord(String str, String str2, String str3, boolean z) {
        int checkAscii = checkAscii(str);
        if (checkAscii == 1) {
            return str;
        }
        String defaultJavaCharset;
        boolean z2;
        if (str2 == null) {
            defaultJavaCharset = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            defaultJavaCharset = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = checkAscii != 3 ? "Q" : "B";
        }
        if (str3.equalsIgnoreCase("B")) {
            z2 = true;
        } else if (str3.equalsIgnoreCase("Q")) {
            z2 = false;
        } else {
            throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        doEncode(str, z2, defaultJavaCharset, 68 - str2.length(), "=?" + str2 + "?" + str3 + "?", true, z, stringBuffer);
        return stringBuffer.toString();
    }

    public static String fold(int i, String str) {
        if (!foldText) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                break;
            }
            length--;
        }
        if (length != str.length() - 1) {
            str = str.substring(0, length + 1);
        }
        if (str.length() + i <= 76) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 4);
        char c = '\u0000';
        while (str.length() + i > 76) {
            int i2 = -1;
            char c2 = c;
            length = 0;
            while (length < str.length() && (i2 == -1 || i + length <= 76)) {
                char charAt2 = str.charAt(length);
                if (!((charAt2 != ' ' && charAt2 != '\t') || r4 == ' ' || r4 == '\t')) {
                    i2 = length;
                }
                length++;
                c2 = charAt2;
            }
            if (i2 == -1) {
                stringBuffer.append(str);
                str = "";
                break;
            }
            stringBuffer.append(str.substring(0, i2));
            stringBuffer.append("\r\n");
            c = str.charAt(i2);
            stringBuffer.append(c);
            str = str.substring(i2 + 1);
            i = 1;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String getDefaultJavaCharset() {
        if (defaultJavaCharset == null) {
            String str = null;
            try {
                str = System.getProperty("mail.mime.charset");
            } catch (SecurityException e) {
            }
            if (str == null || str.length() <= 0) {
                try {
                    defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
                } catch (SecurityException e2) {
                    str = new InputStreamReader(new InputStream() {
                        public int read() {
                            return 0;
                        }
                    }).getEncoding();
                    defaultJavaCharset = str;
                    if (str == null) {
                        defaultJavaCharset = "8859_1";
                    }
                }
            } else {
                str = javaCharset(str);
                defaultJavaCharset = str;
                return str;
            }
        }
        return defaultJavaCharset;
    }

    static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty("mail.mime.charset");
            } catch (SecurityException e) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            OutputStream asciiOutputStream;
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException e) {
                }
                switch (asciiOutputStream.getAscii()) {
                    case 1:
                        return "7bit";
                    case 2:
                        return "quoted-printable";
                    default:
                        return "base64";
                }
            }
            asciiOutputStream = new AsciiOutputStream(true, encodeEolStrict);
            try {
                dataHandler.writeTo(asciiOutputStream);
            } catch (IOException e2) {
            }
            return asciiOutputStream.getAscii() == 1 ? "7bit" : "base64";
        } catch (Exception e3) {
            return "base64";
        }
    }

    public static String getEncoding(DataSource dataSource) {
        try {
            String str;
            ContentType contentType = new ContentType(dataSource.getContentType());
            InputStream inputStream = dataSource.getInputStream();
            switch (checkAscii(inputStream, -1, !contentType.match("text/*"))) {
                case 1:
                    str = "7bit";
                    break;
                case 2:
                    str = "quoted-printable";
                    break;
                default:
                    str = "base64";
                    break;
            }
            try {
                inputStream.close();
                return str;
            } catch (IOException e) {
                return str;
            }
        } catch (Exception e2) {
            return "base64";
        }
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

    public static String javaCharset(String str) {
        if (mime2java == null || str == null) {
            return str;
        }
        String str2 = (String) mime2java.get(str.toLowerCase(Locale.ENGLISH));
        return str2 != null ? str2 : str;
    }

    private static void loadMappings(LineInputStream lineInputStream, Hashtable hashtable) {
        while (true) {
            try {
                String readLine = lineInputStream.readLine();
                if (readLine == null) {
                    return;
                }
                if (!readLine.startsWith("--") || !readLine.endsWith("--")) {
                    if (!(readLine.trim().length() == 0 || readLine.startsWith("#"))) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                        try {
                            readLine = stringTokenizer.nextToken();
                            hashtable.put(readLine.toLowerCase(Locale.ENGLISH), stringTokenizer.nextToken());
                        } catch (NoSuchElementException e) {
                        }
                    }
                } else {
                    return;
                }
            } catch (IOException e2) {
                return;
            }
        }
    }

    public static String mimeCharset(String str) {
        if (java2mime == null || str == null) {
            return str;
        }
        String str2 = (String) java2mime.get(str.toLowerCase(Locale.ENGLISH));
        return str2 != null ? str2 : str;
    }

    static final boolean nonascii(int i) {
        return i >= 127 || !(i >= 32 || i == 13 || i == 10 || i == 9);
    }

    public static String quote(String str, String str2) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\"' || charAt == '\\' || charAt == '\r' || charAt == '\n') {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                stringBuffer.append(str.substring(0, i2));
                i = i2;
                i2 = 0;
                while (i < length) {
                    char charAt2 = str.charAt(i);
                    if ((charAt2 == '\"' || charAt2 == '\\' || charAt2 == '\r' || charAt2 == '\n') && !(charAt2 == '\n' && r1 == 13)) {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
                    i++;
                    char c = charAt2;
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
            if (charAt < ' ' || charAt >= '' || str2.indexOf(charAt) >= 0) {
                i = 1;
            }
        }
        if (i == 0) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer(length + 2);
        stringBuffer2.append('\"').append(str).append('\"');
        return stringBuffer2.toString();
    }

    public static String unfold(String str) {
        if (!foldText) {
            return str;
        }
        StringBuffer stringBuffer = null;
        while (true) {
            int indexOfAny = indexOfAny(str, "\r\n");
            if (indexOfAny < 0) {
                break;
            }
            int length = str.length();
            int i = indexOfAny + 1;
            if (i < length && str.charAt(i - 1) == '\r' && str.charAt(i) == '\n') {
                i++;
            }
            if (indexOfAny == 0 || str.charAt(indexOfAny - 1) != '\\') {
                if (i < length) {
                    char charAt = str.charAt(i);
                    if (charAt == ' ' || charAt == '\t') {
                        i++;
                        while (i < length) {
                            charAt = str.charAt(i);
                            if (charAt != ' ' && charAt != '\t') {
                                break;
                            }
                            i++;
                        }
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer(str.length());
                        }
                        if (indexOfAny != 0) {
                            stringBuffer.append(str.substring(0, indexOfAny));
                            stringBuffer.append(' ');
                        }
                        str = str.substring(i);
                    }
                }
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length());
                }
                stringBuffer.append(str.substring(0, i));
                str = str.substring(i);
            } else {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length());
                }
                stringBuffer.append(str.substring(0, indexOfAny - 1));
                stringBuffer.append(str.substring(indexOfAny, i));
                str = str.substring(i);
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
