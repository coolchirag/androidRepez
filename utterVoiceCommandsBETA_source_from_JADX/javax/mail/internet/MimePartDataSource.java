package javax.mail.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownServiceException;
import javax.activation.DataSource;
import javax.mail.MessageAware;
import javax.mail.MessageContext;
import javax.mail.MessagingException;

public class MimePartDataSource implements DataSource, MessageAware {
    private static boolean ignoreMultipartEncoding;
    private MessageContext context;
    protected MimePart part;

    static {
        boolean z = true;
        ignoreMultipartEncoding = true;
        try {
            String property = System.getProperty("mail.mime.ignoremultipartencoding");
            if (property != null && property.equalsIgnoreCase("false")) {
                z = false;
            }
            ignoreMultipartEncoding = z;
        } catch (SecurityException e) {
        }
    }

    public MimePartDataSource(MimePart mimePart) {
        this.part = mimePart;
    }

    private static String restrictEncoding(String str, MimePart mimePart) {
        if (!ignoreMultipartEncoding || str == null || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit") || str.equalsIgnoreCase("binary")) {
            return str;
        }
        String contentType = mimePart.getContentType();
        if (contentType == null) {
            return str;
        }
        try {
            ContentType contentType2 = new ContentType(contentType);
            return (contentType2.match("multipart/*") || contentType2.match("message/*")) ? null : str;
        } catch (ParseException e) {
            return str;
        }
    }

    public String getContentType() {
        try {
            return this.part.getContentType();
        } catch (MessagingException e) {
            return "application/octet-stream";
        }
    }

    public InputStream getInputStream() {
        try {
            InputStream contentStream;
            if (this.part instanceof MimeBodyPart) {
                contentStream = ((MimeBodyPart) this.part).getContentStream();
            } else if (this.part instanceof MimeMessage) {
                contentStream = ((MimeMessage) this.part).getContentStream();
            } else {
                throw new MessagingException("Unknown part");
            }
            String restrictEncoding = restrictEncoding(this.part.getEncoding(), this.part);
            return restrictEncoding != null ? MimeUtility.decode(contentStream, restrictEncoding) : contentStream;
        } catch (MessagingException e) {
            throw new IOException(e.getMessage());
        }
    }

    public synchronized MessageContext getMessageContext() {
        if (this.context == null) {
            this.context = new MessageContext(this.part);
        }
        return this.context;
    }

    public String getName() {
        try {
            if (this.part instanceof MimeBodyPart) {
                return ((MimeBodyPart) this.part).getFileName();
            }
        } catch (MessagingException e) {
        }
        return "";
    }

    public OutputStream getOutputStream() {
        throw new UnknownServiceException();
    }
}
