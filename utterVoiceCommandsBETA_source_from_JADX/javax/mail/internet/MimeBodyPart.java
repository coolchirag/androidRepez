package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.HeaderTokenizer.Token;

public class MimeBodyPart extends BodyPart implements MimePart {
    static boolean cacheMultipart;
    private static boolean decodeFileName;
    private static boolean encodeFileName;
    private static boolean setContentTypeFileName;
    private static boolean setDefaultTextCharset;
    private Object cachedContent;
    protected byte[] content;
    protected InputStream contentStream;
    protected DataHandler dh;
    protected InternetHeaders headers;

    static {
        boolean z = false;
        setDefaultTextCharset = true;
        setContentTypeFileName = true;
        encodeFileName = false;
        decodeFileName = false;
        cacheMultipart = true;
        try {
            String property = System.getProperty("mail.mime.setdefaulttextcharset");
            boolean z2 = property == null || !property.equalsIgnoreCase("false");
            setDefaultTextCharset = z2;
            property = System.getProperty("mail.mime.setcontenttypefilename");
            z2 = property == null || !property.equalsIgnoreCase("false");
            setContentTypeFileName = z2;
            property = System.getProperty("mail.mime.encodefilename");
            z2 = (property == null || property.equalsIgnoreCase("false")) ? false : true;
            encodeFileName = z2;
            property = System.getProperty("mail.mime.decodefilename");
            z2 = (property == null || property.equalsIgnoreCase("false")) ? false : true;
            decodeFileName = z2;
            property = System.getProperty("mail.mime.cachemultipart");
            if (property == null || !property.equalsIgnoreCase("false")) {
                z = true;
            }
            cacheMultipart = z;
        } catch (SecurityException e) {
        }
    }

    public MimeBodyPart() {
        this.headers = new InternetHeaders();
    }

    public MimeBodyPart(InputStream inputStream) {
        InputStream bufferedInputStream = ((inputStream instanceof ByteArrayInputStream) || (inputStream instanceof BufferedInputStream) || (inputStream instanceof SharedInputStream)) ? inputStream : new BufferedInputStream(inputStream);
        this.headers = new InternetHeaders(bufferedInputStream);
        if (bufferedInputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) bufferedInputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1);
            return;
        }
        try {
            this.content = ASCIIUtility.getBytes(bufferedInputStream);
        } catch (Exception e) {
            throw new MessagingException("Error reading input stream", e);
        }
    }

    public MimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) {
        this.headers = internetHeaders;
        this.content = bArr;
    }

    static String[] getContentLanguage(MimePart mimePart) {
        String header = mimePart.getHeader("Content-Language", null);
        if (header == null) {
            return null;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(header, HeaderTokenizer.MIME);
        Vector vector = new Vector();
        while (true) {
            Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            } else if (type == -1) {
                vector.addElement(next.getValue());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    static String getDescription(MimePart mimePart) {
        String header = mimePart.getHeader("Content-Description", null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException e) {
            return header;
        }
    }

    static String getDisposition(MimePart mimePart) {
        String header = mimePart.getHeader("Content-Disposition", null);
        return header == null ? null : new ContentDisposition(header).getDisposition();
    }

    static String getEncoding(MimePart mimePart) {
        String header = mimePart.getHeader("Content-Transfer-Encoding", null);
        if (header == null) {
            return null;
        }
        String trim = header.trim();
        if (trim.equalsIgnoreCase("7bit") || trim.equalsIgnoreCase("8bit") || trim.equalsIgnoreCase("quoted-printable") || trim.equalsIgnoreCase("binary") || trim.equalsIgnoreCase("base64")) {
            return trim;
        }
        Token next;
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(trim, HeaderTokenizer.MIME);
        int type;
        do {
            next = headerTokenizer.next();
            type = next.getType();
            if (type == -4) {
                return trim;
            }
        } while (type != -1);
        return next.getValue();
    }

    static String getFileName(MimePart mimePart) {
        String header = mimePart.getHeader("Content-Disposition", null);
        header = header != null ? new ContentDisposition(header).getParameter("filename") : null;
        if (header == null) {
            String header2 = mimePart.getHeader("Content-Type", null);
            if (header2 != null) {
                try {
                    header = new ContentType(header2).getParameter("name");
                } catch (ParseException e) {
                }
            }
        }
        if (decodeFileName && header != null) {
            try {
                header = MimeUtility.decodeText(header);
            } catch (Exception e2) {
                throw new MessagingException("Can't decode filename", e2);
            }
        }
        return header;
    }

    static void invalidateContentHeaders(MimePart mimePart) {
        mimePart.removeHeader("Content-Type");
        mimePart.removeHeader("Content-Transfer-Encoding");
    }

    static boolean isMimeType(MimePart mimePart, String str) {
        try {
            return new ContentType(mimePart.getContentType()).match(str);
        } catch (ParseException e) {
            return mimePart.getContentType().equalsIgnoreCase(str);
        }
    }

    static void setContentLanguage(MimePart mimePart, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuffer.append(',').append(strArr[i]);
        }
        mimePart.setHeader("Content-Language", stringBuffer.toString());
    }

    static void setDescription(MimePart mimePart, String str, String str2) {
        if (str == null) {
            mimePart.removeHeader("Content-Description");
            return;
        }
        try {
            mimePart.setHeader("Content-Description", MimeUtility.fold(21, MimeUtility.encodeText(str, str2, null)));
        } catch (Exception e) {
            throw new MessagingException("Encoding error", e);
        }
    }

    static void setDisposition(MimePart mimePart, String str) {
        if (str == null) {
            mimePart.removeHeader("Content-Disposition");
            return;
        }
        String header = mimePart.getHeader("Content-Disposition", null);
        if (header != null) {
            ContentDisposition contentDisposition = new ContentDisposition(header);
            contentDisposition.setDisposition(str);
            str = contentDisposition.toString();
        }
        mimePart.setHeader("Content-Disposition", str);
    }

    static void setEncoding(MimePart mimePart, String str) {
        mimePart.setHeader("Content-Transfer-Encoding", str);
    }

    static void setFileName(MimePart mimePart, String str) {
        if (encodeFileName && str != null) {
            try {
                str = MimeUtility.encodeText(str);
            } catch (Exception e) {
                throw new MessagingException("Can't encode filename", e);
            }
        }
        String header = mimePart.getHeader("Content-Disposition", null);
        if (header == null) {
            header = Part.ATTACHMENT;
        }
        ContentDisposition contentDisposition = new ContentDisposition(header);
        contentDisposition.setParameter("filename", str);
        mimePart.setHeader("Content-Disposition", contentDisposition.toString());
        if (setContentTypeFileName) {
            header = mimePart.getHeader("Content-Type", null);
            if (header != null) {
                try {
                    ContentType contentType = new ContentType(header);
                    contentType.setParameter("name", str);
                    mimePart.setHeader("Content-Type", contentType.toString());
                } catch (ParseException e2) {
                }
            }
        }
    }

    static void setText(MimePart mimePart, String str, String str2, String str3) {
        if (str2 == null) {
            str2 = MimeUtility.checkAscii(str) != 1 ? MimeUtility.getDefaultMIMECharset() : "us-ascii";
        }
        mimePart.setContent(str, "text/" + str3 + "; charset=" + MimeUtility.quote(str2, HeaderTokenizer.MIME));
    }

    static void updateHeaders(MimePart mimePart) {
        Object obj = null;
        DataHandler dataHandler = mimePart.getDataHandler();
        if (dataHandler != null) {
            try {
                String encoding;
                String contentType = dataHandler.getContentType();
                Object obj2 = mimePart.getHeader("Content-Type") == null ? 1 : null;
                ContentType contentType2 = new ContentType(contentType);
                if (contentType2.match("multipart/*")) {
                    if (mimePart instanceof MimeBodyPart) {
                        MimeBodyPart mimeBodyPart = (MimeBodyPart) mimePart;
                        obj = mimeBodyPart.cachedContent != null ? mimeBodyPart.cachedContent : dataHandler.getContent();
                    } else if (mimePart instanceof MimeMessage) {
                        MimeMessage mimeMessage = (MimeMessage) mimePart;
                        obj = mimeMessage.cachedContent != null ? mimeMessage.cachedContent : dataHandler.getContent();
                    } else {
                        obj = dataHandler.getContent();
                    }
                    if (obj instanceof MimeMultipart) {
                        ((MimeMultipart) obj).updateHeaders();
                        obj = 1;
                    } else {
                        throw new MessagingException("MIME part of type \"" + contentType + "\" contains object of type " + obj.getClass().getName() + " instead of MimeMultipart");
                    }
                } else if (contentType2.match("message/rfc822")) {
                    int i = 1;
                }
                if (obj == null) {
                    if (mimePart.getHeader("Content-Transfer-Encoding") == null) {
                        setEncoding(mimePart, MimeUtility.getEncoding(dataHandler));
                    }
                    if (obj2 != null && setDefaultTextCharset && contentType2.match("text/*") && contentType2.getParameter("charset") == null) {
                        encoding = mimePart.getEncoding();
                        encoding = (encoding == null || !encoding.equalsIgnoreCase("7bit")) ? MimeUtility.getDefaultMIMECharset() : "us-ascii";
                        contentType2.setParameter("charset", encoding);
                        encoding = contentType2.toString();
                        if (obj2 != null) {
                            contentType = mimePart.getHeader("Content-Disposition", null);
                            if (contentType != null) {
                                contentType = new ContentDisposition(contentType).getParameter("filename");
                                if (contentType != null) {
                                    contentType2.setParameter("name", contentType);
                                    encoding = contentType2.toString();
                                }
                            }
                            mimePart.setHeader("Content-Type", encoding);
                        }
                    }
                }
                encoding = contentType;
                if (obj2 != null) {
                    contentType = mimePart.getHeader("Content-Disposition", null);
                    if (contentType != null) {
                        contentType = new ContentDisposition(contentType).getParameter("filename");
                        if (contentType != null) {
                            contentType2.setParameter("name", contentType);
                            encoding = contentType2.toString();
                        }
                    }
                    mimePart.setHeader("Content-Type", encoding);
                }
            } catch (Exception e) {
                throw new MessagingException("IOException updating headers", e);
            }
        }
    }

    static void writeTo(MimePart mimePart, OutputStream outputStream, String[] strArr) {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration nonMatchingHeaderLines = mimePart.getNonMatchingHeaderLines(strArr);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        OutputStream encode = MimeUtility.encode(outputStream, mimePart.getEncoding());
        mimePart.getDataHandler().writeTo(encode);
        encode.flush();
    }

    public void addHeader(String str, String str2) {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) {
        this.headers.addHeaderLine(str);
    }

    public void attachFile(File file) {
        DataSource fileDataSource = new FileDataSource(file);
        setDataHandler(new DataHandler(fileDataSource));
        setFileName(fileDataSource.getName());
    }

    public void attachFile(String str) {
        attachFile(new File(str));
    }

    public Enumeration getAllHeaderLines() {
        return this.headers.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() {
        return this.headers.getAllHeaders();
    }

    public Object getContent() {
        if (this.cachedContent != null) {
            return this.cachedContent;
        }
        try {
            Object content = getDataHandler().getContent();
            if (!cacheMultipart) {
                return content;
            }
            if (!(content instanceof Multipart) && !(content instanceof Message)) {
                return content;
            }
            if (this.content == null && this.contentStream == null) {
                return content;
            }
            this.cachedContent = content;
            return content;
        } catch (FolderClosedIOException e) {
            throw new FolderClosedException(e.getFolder(), e.getMessage());
        } catch (MessageRemovedIOException e2) {
            throw new MessageRemovedException(e2.getMessage());
        }
    }

    public String getContentID() {
        return getHeader("Content-Id", null);
    }

    public String[] getContentLanguage() {
        return getContentLanguage(this);
    }

    public String getContentMD5() {
        return getHeader("Content-MD5", null);
    }

    protected InputStream getContentStream() {
        if (this.contentStream != null) {
            return ((SharedInputStream) this.contentStream).newStream(0, -1);
        }
        if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    public String getContentType() {
        String header = getHeader("Content-Type", null);
        return header == null ? "text/plain" : header;
    }

    public DataHandler getDataHandler() {
        if (this.dh == null) {
            this.dh = new DataHandler(new MimePartDataSource(this));
        }
        return this.dh;
    }

    public String getDescription() {
        return getDescription(this);
    }

    public String getDisposition() {
        return getDisposition(this);
    }

    public String getEncoding() {
        return getEncoding(this);
    }

    public String getFileName() {
        return getFileName(this);
    }

    public String getHeader(String str, String str2) {
        return this.headers.getHeader(str, str2);
    }

    public String[] getHeader(String str) {
        return this.headers.getHeader(str);
    }

    public InputStream getInputStream() {
        return getDataHandler().getInputStream();
    }

    public int getLineCount() {
        return -1;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) {
        return this.headers.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) {
        return this.headers.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public InputStream getRawInputStream() {
        return getContentStream();
    }

    public int getSize() {
        if (this.content != null) {
            return this.content.length;
        }
        if (this.contentStream != null) {
            try {
                int available = this.contentStream.available();
                if (available > 0) {
                    return available;
                }
            } catch (IOException e) {
            }
        }
        return -1;
    }

    public boolean isMimeType(String str) {
        return isMimeType(this, str);
    }

    public void removeHeader(String str) {
        this.headers.removeHeader(str);
    }

    public void saveFile(File file) {
        Throwable th;
        InputStream inputStream = null;
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                inputStream = getInputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    public void saveFile(String str) {
        saveFile(new File(str));
    }

    public void setContent(Object obj, String str) {
        if (obj instanceof Multipart) {
            setContent((Multipart) obj);
        } else {
            setDataHandler(new DataHandler(obj, str));
        }
    }

    public void setContent(Multipart multipart) {
        setDataHandler(new DataHandler(multipart, multipart.getContentType()));
        multipart.setParent(this);
    }

    public void setContentID(String str) {
        if (str == null) {
            removeHeader("Content-ID");
        } else {
            setHeader("Content-ID", str);
        }
    }

    public void setContentLanguage(String[] strArr) {
        setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) {
        setHeader("Content-MD5", str);
    }

    public void setDataHandler(DataHandler dataHandler) {
        this.dh = dataHandler;
        this.cachedContent = null;
        invalidateContentHeaders(this);
    }

    public void setDescription(String str) {
        setDescription(str, null);
    }

    public void setDescription(String str, String str2) {
        setDescription(this, str, str2);
    }

    public void setDisposition(String str) {
        setDisposition(this, str);
    }

    public void setFileName(String str) {
        setFileName(this, str);
    }

    public void setHeader(String str, String str2) {
        this.headers.setHeader(str, str2);
    }

    public void setText(String str) {
        setText(str, null);
    }

    public void setText(String str, String str2) {
        setText(this, str, str2, "plain");
    }

    public void setText(String str, String str2, String str3) {
        setText(this, str, str2, str3);
    }

    protected void updateHeaders() {
        updateHeaders(this);
        if (this.cachedContent != null) {
            this.dh = new DataHandler(this.cachedContent, getContentType());
            this.cachedContent = null;
            this.content = null;
            if (this.contentStream != null) {
                try {
                    this.contentStream.close();
                } catch (IOException e) {
                }
            }
            this.contentStream = null;
        }
    }

    public void writeTo(OutputStream outputStream) {
        writeTo(this, outputStream, null);
    }
}
