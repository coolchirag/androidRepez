package com.sun.mail.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import myjava.awt.datatransfer.DataFlavor;

public class message_rfc822 implements DataContentHandler {
    ActivationDataFlavor ourDataFlavor = new ActivationDataFlavor(Message.class, "message/rfc822", "Message");

    public Object getContent(DataSource dataSource) {
        try {
            return new MimeMessage(dataSource instanceof MessageAware ? ((MessageAware) dataSource).getMessageContext().getSession() : Session.getDefaultInstance(new Properties(), null), dataSource.getInputStream());
        } catch (MessagingException e) {
            throw new IOException("Exception creating MimeMessage in message/rfc822 DataContentHandler: " + e.toString());
        }
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) {
        return this.ourDataFlavor.equals(dataFlavor) ? getContent(dataSource) : null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{this.ourDataFlavor};
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) {
        if (obj instanceof Message) {
            try {
                ((Message) obj).writeTo(outputStream);
                return;
            } catch (MessagingException e) {
                throw new IOException(e.toString());
            }
        }
        throw new IOException("unsupported object");
    }
}
