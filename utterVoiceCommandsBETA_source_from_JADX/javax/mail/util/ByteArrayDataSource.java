package javax.mail.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParseException;

public class ByteArrayDataSource implements DataSource {
    private byte[] data;
    private int len = -1;
    private String name = "";
    private String type;

    class DSByteArrayOutputStream extends ByteArrayOutputStream {
        DSByteArrayOutputStream() {
        }

        public byte[] getBuf() {
            return this.buf;
        }

        public int getCount() {
            return this.count;
        }
    }

    public ByteArrayDataSource(InputStream inputStream, String str) {
        DSByteArrayOutputStream dSByteArrayOutputStream = new DSByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            dSByteArrayOutputStream.write(bArr, 0, read);
        }
        this.data = dSByteArrayOutputStream.getBuf();
        this.len = dSByteArrayOutputStream.getCount();
        if (this.data.length - this.len > 262144) {
            this.data = dSByteArrayOutputStream.toByteArray();
            this.len = this.data.length;
        }
        this.type = str;
    }

    public ByteArrayDataSource(String str, String str2) {
        String str3 = null;
        try {
            str3 = new ContentType(str2).getParameter("charset");
        } catch (ParseException e) {
        }
        if (str3 == null) {
            str3 = MimeUtility.getDefaultJavaCharset();
        }
        this.data = str.getBytes(str3);
        this.type = str2;
    }

    public ByteArrayDataSource(byte[] bArr, String str) {
        this.data = bArr;
        this.type = str;
    }

    public String getContentType() {
        return this.type;
    }

    public InputStream getInputStream() {
        if (this.data == null) {
            throw new IOException("no data");
        }
        if (this.len < 0) {
            this.len = this.data.length;
        }
        return new SharedByteArrayInputStream(this.data, 0, this.len);
    }

    public String getName() {
        return this.name;
    }

    public OutputStream getOutputStream() {
        throw new IOException("cannot do this");
    }

    public void setName(String str) {
        this.name = str;
    }
}
