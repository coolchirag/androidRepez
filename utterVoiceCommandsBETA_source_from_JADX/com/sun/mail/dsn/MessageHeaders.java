package com.sun.mail.dsn;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;

public class MessageHeaders extends MimeMessage {
    public MessageHeaders() {
        super(null);
        this.content = new byte[0];
    }

    public MessageHeaders(InputStream inputStream) {
        super(null, inputStream);
        this.content = new byte[0];
    }

    public MessageHeaders(InternetHeaders internetHeaders) {
        super(null);
        this.headers = internetHeaders;
        this.content = new byte[0];
    }

    protected InputStream getContentStream() {
        return new ByteArrayInputStream(this.content);
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.content);
    }

    public int getSize() {
        return 0;
    }

    public void setDataHandler(DataHandler dataHandler) {
        throw new MessagingException("Can't set content for MessageHeaders");
    }
}
