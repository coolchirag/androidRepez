package com.sun.mail.smtp;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.StringTokenizer;
import javax.mail.internet.HeaderTokenizer.Token;

public class DigestMD5 {
    private static char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String clientResponse;
    private PrintStream debugout;
    private MessageDigest md5;
    private String uri;

    public DigestMD5(PrintStream printStream) {
        this.debugout = printStream;
        if (printStream != null) {
            printStream.println("DEBUG DIGEST-MD5: Loaded");
        }
    }

    private static String toHex(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[(bArr.length * 2)];
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            cArr[i] = digits[i2 >> 4];
            i = i3 + 1;
            cArr[i3] = digits[i2 & 15];
        }
        return new String(cArr);
    }

    private Hashtable tokenize(String str) {
        Hashtable hashtable = new Hashtable();
        byte[] bytes = str.getBytes();
        StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(new BASE64DecoderStream(new ByteArrayInputStream(bytes, 4, bytes.length - 4))));
        streamTokenizer.ordinaryChars(48, 57);
        streamTokenizer.wordChars(48, 57);
        String str2 = null;
        while (true) {
            int nextToken = streamTokenizer.nextToken();
            if (nextToken != -1) {
                switch (nextToken) {
                    case Token.COMMENT /*-3*/:
                        if (str2 == null) {
                            str2 = streamTokenizer.sval;
                            break;
                        }
                    case 34:
                        if (this.debugout != null) {
                            this.debugout.println("DEBUG DIGEST-MD5: Received => " + str2 + "='" + streamTokenizer.sval + "'");
                        }
                        if (hashtable.containsKey(str2)) {
                            hashtable.put(str2, hashtable.get(str2) + "," + streamTokenizer.sval);
                        } else {
                            hashtable.put(str2, streamTokenizer.sval);
                        }
                        str2 = null;
                        break;
                    default:
                        break;
                }
            }
            return hashtable;
        }
    }

    public byte[] authClient(String str, String str2, String str3, String str4, String str5) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        try {
            String str6;
            SecureRandom secureRandom = new SecureRandom();
            this.md5 = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            this.uri = "smtp/" + str;
            String str7 = "00000001";
            String str8 = "auth";
            byte[] bArr = new byte[32];
            if (this.debugout != null) {
                this.debugout.println("DEBUG DIGEST-MD5: Begin authentication ...");
            }
            Hashtable tokenize = tokenize(str5);
            if (str4 == null) {
                str6 = (String) tokenize.get("realm");
                if (str6 != null) {
                    str = new StringTokenizer(str6, ",").nextToken();
                }
            } else {
                str = str4;
            }
            str6 = (String) tokenize.get("nonce");
            secureRandom.nextBytes(bArr);
            bASE64EncoderStream.write(bArr);
            bASE64EncoderStream.flush();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            byteArrayOutputStream.reset();
            this.md5.update(this.md5.digest(ASCIIUtility.getBytes(new StringBuilder(String.valueOf(str2)).append(":").append(str).append(":").append(str3).toString())));
            this.md5.update(ASCIIUtility.getBytes(":" + str6 + ":" + byteArrayOutputStream2));
            this.clientResponse = new StringBuilder(String.valueOf(toHex(this.md5.digest()))).append(":").append(str6).append(":").append(str7).append(":").append(byteArrayOutputStream2).append(":").append(str8).append(":").toString();
            this.md5.update(ASCIIUtility.getBytes("AUTHENTICATE:" + this.uri));
            this.md5.update(ASCIIUtility.getBytes(this.clientResponse + toHex(this.md5.digest())));
            stringBuffer.append("username=\"" + str2 + "\"");
            stringBuffer.append(",realm=\"" + str + "\"");
            stringBuffer.append(",qop=" + str8);
            stringBuffer.append(",nc=" + str7);
            stringBuffer.append(",nonce=\"" + str6 + "\"");
            stringBuffer.append(",cnonce=\"" + byteArrayOutputStream2 + "\"");
            stringBuffer.append(",digest-uri=\"" + this.uri + "\"");
            stringBuffer.append(",response=" + toHex(this.md5.digest()));
            if (this.debugout != null) {
                this.debugout.println("DEBUG DIGEST-MD5: Response => " + stringBuffer.toString());
            }
            bASE64EncoderStream.write(ASCIIUtility.getBytes(stringBuffer.toString()));
            bASE64EncoderStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (NoSuchAlgorithmException e) {
            if (this.debugout != null) {
                this.debugout.println("DEBUG DIGEST-MD5: " + e);
            }
            throw new IOException(e.toString());
        }
    }

    public boolean authServer(String str) {
        Hashtable tokenize = tokenize(str);
        this.md5.update(ASCIIUtility.getBytes(":" + this.uri));
        this.md5.update(ASCIIUtility.getBytes(this.clientResponse + toHex(this.md5.digest())));
        String toHex = toHex(this.md5.digest());
        if (toHex.equals((String) tokenize.get("rspauth"))) {
            return true;
        }
        if (this.debugout != null) {
            this.debugout.println("DEBUG DIGEST-MD5: Expected => rspauth=" + toHex);
        }
        return false;
    }
}
