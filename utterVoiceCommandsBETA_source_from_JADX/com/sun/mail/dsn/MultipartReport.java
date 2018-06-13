package com.sun.mail.dsn;

import java.util.Vector;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MultipartReport extends MimeMultipart {
    protected boolean constructed;

    public MultipartReport() {
        super("report");
        setBodyPart(new MimeBodyPart(), 0);
        setBodyPart(new MimeBodyPart(), 1);
        this.constructed = true;
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus) {
        super("report");
        ContentType contentType = new ContentType(this.contentType);
        contentType.setParameter("report-type", "delivery-status");
        this.contentType = contentType.toString();
        BodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str);
        setBodyPart(mimeBodyPart, 0);
        mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(deliveryStatus, "message/delivery-status");
        setBodyPart(mimeBodyPart, 1);
        this.constructed = true;
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus, InternetHeaders internetHeaders) {
        this(str, deliveryStatus);
        if (internetHeaders != null) {
            BodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(new MessageHeaders(internetHeaders), "text/rfc822-headers");
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus, MimeMessage mimeMessage) {
        this(str, deliveryStatus);
        if (mimeMessage != null) {
            BodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mimeMessage, "message/rfc822");
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public MultipartReport(DataSource dataSource) {
        super(dataSource);
        parse();
        this.constructed = true;
    }

    private synchronized void setBodyPart(BodyPart bodyPart, int i) {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        if (i < this.parts.size()) {
            super.removeBodyPart(i);
        }
        super.addBodyPart(bodyPart, i);
    }

    public synchronized void addBodyPart(BodyPart bodyPart) {
        if (this.constructed) {
            throw new MessagingException("Can't add body parts to multipart/report 1");
        }
        super.addBodyPart(bodyPart);
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i) {
        throw new MessagingException("Can't add body parts to multipart/report 2");
    }

    public synchronized DeliveryStatus getDeliveryStatus() {
        DeliveryStatus deliveryStatus = null;
        synchronized (this) {
            if (getCount() >= 2) {
                BodyPart bodyPart = getBodyPart(1);
                if (bodyPart.isMimeType("message/delivery-status")) {
                    try {
                        deliveryStatus = (DeliveryStatus) bodyPart.getContent();
                    } catch (Exception e) {
                        throw new MessagingException("IOException getting DeliveryStatus", e);
                    }
                }
            }
        }
        return deliveryStatus;
    }

    public synchronized MimeMessage getReturnedMessage() {
        MimeMessage mimeMessage = null;
        synchronized (this) {
            if (getCount() >= 3) {
                BodyPart bodyPart = getBodyPart(2);
                if (bodyPart.isMimeType("message/rfc822") || bodyPart.isMimeType("text/rfc822-headers")) {
                    try {
                        mimeMessage = (MimeMessage) bodyPart.getContent();
                    } catch (Exception e) {
                        throw new MessagingException("IOException getting ReturnedMessage", e);
                    }
                }
            }
        }
        return mimeMessage;
    }

    public synchronized String getText() {
        String str;
        synchronized (this) {
            try {
                BodyPart bodyPart = getBodyPart(0);
                if (bodyPart.isMimeType("text/plain")) {
                    str = (String) bodyPart.getContent();
                } else {
                    if (bodyPart.isMimeType("multipart/alternative")) {
                        Multipart multipart = (Multipart) bodyPart.getContent();
                        for (int i = 0; i < multipart.getCount(); i++) {
                            BodyPart bodyPart2 = multipart.getBodyPart(i);
                            if (bodyPart2.isMimeType("text/plain")) {
                                str = (String) bodyPart2.getContent();
                                break;
                            }
                        }
                    }
                    str = null;
                }
            } catch (Exception e) {
                throw new MessagingException("Exception getting text content", e);
            }
        }
        return str;
    }

    public synchronized MimeBodyPart getTextBodyPart() {
        return (MimeBodyPart) getBodyPart(0);
    }

    public void removeBodyPart(int i) {
        throw new MessagingException("Can't remove body parts from multipart/report");
    }

    public boolean removeBodyPart(BodyPart bodyPart) {
        throw new MessagingException("Can't remove body parts from multipart/report");
    }

    public synchronized void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        BodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(deliveryStatus, "message/delivery-status");
        setBodyPart(mimeBodyPart, 2);
        ContentType contentType = new ContentType(this.contentType);
        contentType.setParameter("report-type", "delivery-status");
        this.contentType = contentType.toString();
    }

    public synchronized void setReturnedMessage(MimeMessage mimeMessage) {
        if (mimeMessage == null) {
            this.parts.elementAt(2);
            super.removeBodyPart(2);
        } else {
            BodyPart mimeBodyPart = new MimeBodyPart();
            if (mimeMessage instanceof MessageHeaders) {
                mimeBodyPart.setContent(mimeMessage, "text/rfc822-headers");
            } else {
                mimeBodyPart.setContent(mimeMessage, "message/rfc822");
            }
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public synchronized void setSubType(String str) {
        throw new MessagingException("Can't change subtype of MultipartReport");
    }

    public synchronized void setText(String str) {
        BodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str);
        setBodyPart(mimeBodyPart, 0);
    }

    public synchronized void setTextBodyPart(MimeBodyPart mimeBodyPart) {
        setBodyPart(mimeBodyPart, 0);
    }
}
