package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.util.SharedByteArrayInputStream;

public class MimeMessage extends Message implements MimePart {
    private static final Flags answeredFlag = new Flags(Flag.ANSWERED);
    private static MailDateFormat mailDateFormat = new MailDateFormat();
    Object cachedContent;
    protected byte[] content;
    protected InputStream contentStream;
    protected DataHandler dh;
    protected Flags flags;
    protected InternetHeaders headers;
    protected boolean modified;
    protected boolean saved;
    private boolean strict;

    public class RecipientType extends javax.mail.Message.RecipientType {
        public static final RecipientType NEWSGROUPS = new RecipientType("Newsgroups");
        private static final long serialVersionUID = -5468290701714395543L;

        protected RecipientType(String str) {
            super(str);
        }

        protected Object readResolve() {
            return this.type.equals("Newsgroups") ? NEWSGROUPS : super.readResolve();
        }
    }

    protected MimeMessage(Folder folder, int i) {
        super(folder, i);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.flags = new Flags();
        this.saved = true;
        initStrict();
    }

    protected MimeMessage(Folder folder, InputStream inputStream, int i) {
        this(folder, i);
        initStrict();
        parse(inputStream);
    }

    protected MimeMessage(Folder folder, InternetHeaders internetHeaders, byte[] bArr, int i) {
        this(folder, i);
        this.headers = internetHeaders;
        this.content = bArr;
        initStrict();
    }

    public MimeMessage(Session session) {
        super(session);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.modified = true;
        this.headers = new InternetHeaders();
        this.flags = new Flags();
        initStrict();
    }

    public MimeMessage(Session session, InputStream inputStream) {
        super(session);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.flags = new Flags();
        initStrict();
        parse(inputStream);
        this.saved = true;
    }

    public MimeMessage(MimeMessage mimeMessage) {
        super(mimeMessage.session);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.flags = mimeMessage.getFlags();
        int size = mimeMessage.getSize();
        OutputStream byteArrayOutputStream = size > 0 ? new ByteArrayOutputStream(size) : new ByteArrayOutputStream();
        try {
            this.strict = mimeMessage.strict;
            mimeMessage.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.close();
            InputStream sharedByteArrayInputStream = new SharedByteArrayInputStream(byteArrayOutputStream.toByteArray());
            parse(sharedByteArrayInputStream);
            sharedByteArrayInputStream.close();
            this.saved = true;
        } catch (Exception e) {
            throw new MessagingException("IOException while copying message", e);
        }
    }

    private void addAddressHeader(String str, Address[] addressArr) {
        String internetAddress = InternetAddress.toString(addressArr);
        if (internetAddress != null) {
            addHeader(str, internetAddress);
        }
    }

    private Address[] eliminateDuplicates(Vector vector, Address[] addressArr) {
        int i = 0;
        if (addressArr == null) {
            return null;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < addressArr.length; i2++) {
            int i4;
            for (int i5 = 0; i5 < vector.size(); i5++) {
                if (((InternetAddress) vector.elementAt(i5)).equals(addressArr[i2])) {
                    i4 = 1;
                    i3++;
                    addressArr[i2] = null;
                    break;
                }
            }
            i4 = 0;
            if (i4 == 0) {
                vector.addElement(addressArr[i2]);
            }
        }
        if (i3 == 0) {
            return addressArr;
        }
        Address[] addressArr2 = addressArr instanceof InternetAddress[] ? new InternetAddress[(addressArr.length - i3)] : new Address[(addressArr.length - i3)];
        for (i2 = 0; i2 < addressArr.length; i2++) {
            if (addressArr[i2] != null) {
                i3 = i + 1;
                addressArr2[i] = addressArr[i2];
                i = i3;
            }
        }
        return addressArr2;
    }

    private Address[] getAddressHeader(String str) {
        String header = getHeader(str, ",");
        return header == null ? null : InternetAddress.parseHeader(header, this.strict);
    }

    private String getHeaderName(javax.mail.Message.RecipientType recipientType) {
        if (recipientType == javax.mail.Message.RecipientType.TO) {
            return "To";
        }
        if (recipientType == javax.mail.Message.RecipientType.CC) {
            return "Cc";
        }
        if (recipientType == javax.mail.Message.RecipientType.BCC) {
            return "Bcc";
        }
        if (recipientType == RecipientType.NEWSGROUPS) {
            return "Newsgroups";
        }
        throw new MessagingException("Invalid Recipient Type");
    }

    private void initStrict() {
        if (this.session != null) {
            String property = this.session.getProperty("mail.mime.address.strict");
            boolean z = property == null || !property.equalsIgnoreCase("false");
            this.strict = z;
        }
    }

    private void setAddressHeader(String str, Address[] addressArr) {
        String internetAddress = InternetAddress.toString(addressArr);
        if (internetAddress == null) {
            removeHeader(str);
        } else {
            setHeader(str, internetAddress);
        }
    }

    public void addFrom(Address[] addressArr) {
        addAddressHeader("From", addressArr);
    }

    public void addHeader(String str, String str2) {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) {
        this.headers.addHeaderLine(str);
    }

    public void addRecipients(javax.mail.Message.RecipientType recipientType, String str) {
        if (recipientType != RecipientType.NEWSGROUPS) {
            addAddressHeader(getHeaderName(recipientType), InternetAddress.parse(str));
        } else if (str != null && str.length() != 0) {
            addHeader("Newsgroups", str);
        }
    }

    public void addRecipients(javax.mail.Message.RecipientType recipientType, Address[] addressArr) {
        if (recipientType == RecipientType.NEWSGROUPS) {
            String newsAddress = NewsAddress.toString(addressArr);
            if (newsAddress != null) {
                addHeader("Newsgroups", newsAddress);
                return;
            }
            return;
        }
        addAddressHeader(getHeaderName(recipientType), addressArr);
    }

    protected InternetHeaders createInternetHeaders(InputStream inputStream) {
        return new InternetHeaders(inputStream);
    }

    protected MimeMessage createMimeMessage(Session session) {
        return new MimeMessage(session);
    }

    public Enumeration getAllHeaderLines() {
        return this.headers.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() {
        return this.headers.getAllHeaders();
    }

    public Address[] getAllRecipients() {
        Object allRecipients = super.getAllRecipients();
        Object recipients = getRecipients(RecipientType.NEWSGROUPS);
        if (recipients == null) {
            return allRecipients;
        }
        if (allRecipients == null) {
            return recipients;
        }
        Object obj = new Address[(allRecipients.length + recipients.length)];
        System.arraycopy(allRecipients, 0, obj, 0, allRecipients.length);
        System.arraycopy(recipients, 0, obj, allRecipients.length, recipients.length);
        return obj;
    }

    public Object getContent() {
        if (this.cachedContent != null) {
            return this.cachedContent;
        }
        try {
            Object content = getDataHandler().getContent();
            if (!MimeBodyPart.cacheMultipart) {
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
        return MimeBodyPart.getContentLanguage(this);
    }

    public String getContentMD5() {
        return getHeader("Content-MD5", null);
    }

    protected InputStream getContentStream() {
        if (this.contentStream != null) {
            return ((SharedInputStream) this.contentStream).newStream(0, -1);
        }
        if (this.content != null) {
            return new SharedByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    public String getContentType() {
        String header = getHeader("Content-Type", null);
        return header == null ? "text/plain" : header;
    }

    public synchronized DataHandler getDataHandler() {
        if (this.dh == null) {
            this.dh = new DataHandler(new MimePartDataSource(this));
        }
        return this.dh;
    }

    public String getDescription() {
        return MimeBodyPart.getDescription(this);
    }

    public String getDisposition() {
        return MimeBodyPart.getDisposition(this);
    }

    public String getEncoding() {
        return MimeBodyPart.getEncoding(this);
    }

    public String getFileName() {
        return MimeBodyPart.getFileName(this);
    }

    public synchronized Flags getFlags() {
        return (Flags) this.flags.clone();
    }

    public Address[] getFrom() {
        Address[] addressHeader = getAddressHeader("From");
        return addressHeader == null ? getAddressHeader("Sender") : addressHeader;
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

    public String getMessageID() {
        return getHeader("Message-ID", null);
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

    public Date getReceivedDate() {
        return null;
    }

    public Address[] getRecipients(javax.mail.Message.RecipientType recipientType) {
        if (recipientType != RecipientType.NEWSGROUPS) {
            return getAddressHeader(getHeaderName(recipientType));
        }
        String header = getHeader("Newsgroups", ",");
        return header == null ? null : NewsAddress.parse(header);
    }

    public Address[] getReplyTo() {
        Address[] addressHeader = getAddressHeader("Reply-To");
        return addressHeader == null ? getFrom() : addressHeader;
    }

    public Address getSender() {
        Address[] addressHeader = getAddressHeader("Sender");
        return (addressHeader == null || addressHeader.length == 0) ? null : addressHeader[0];
    }

    public Date getSentDate() {
        String header = getHeader("Date", null);
        if (header == null) {
            return null;
        }
        try {
            Date parse;
            synchronized (mailDateFormat) {
                parse = mailDateFormat.parse(header);
            }
            return parse;
        } catch (ParseException e) {
            return null;
        }
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

    public String getSubject() {
        String header = getHeader("Subject", null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException e) {
            return header;
        }
    }

    public boolean isMimeType(String str) {
        return MimeBodyPart.isMimeType(this, str);
    }

    public synchronized boolean isSet(Flag flag) {
        return this.flags.contains(flag);
    }

    protected void parse(InputStream inputStream) {
        InputStream bufferedInputStream = ((inputStream instanceof ByteArrayInputStream) || (inputStream instanceof BufferedInputStream) || (inputStream instanceof SharedInputStream)) ? inputStream : new BufferedInputStream(inputStream);
        this.headers = createInternetHeaders(bufferedInputStream);
        if (bufferedInputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) bufferedInputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1);
        } else {
            try {
                this.content = ASCIIUtility.getBytes(bufferedInputStream);
            } catch (Exception e) {
                throw new MessagingException("IOException", e);
            }
        }
        this.modified = false;
    }

    public void removeHeader(String str) {
        this.headers.removeHeader(str);
    }

    public Message reply(boolean z) {
        boolean z2 = true;
        Message createMimeMessage = createMimeMessage(this.session);
        String header = getHeader("Subject", null);
        if (header != null) {
            if (!header.regionMatches(true, 0, "Re: ", 0, 4)) {
                header = "Re: " + header;
            }
            createMimeMessage.setHeader("Subject", header);
        }
        Address[] replyTo = getReplyTo();
        createMimeMessage.setRecipients(javax.mail.Message.RecipientType.TO, replyTo);
        if (z) {
            Vector vector = new Vector();
            InternetAddress localAddress = InternetAddress.getLocalAddress(this.session);
            if (localAddress != null) {
                vector.addElement(localAddress);
            }
            header = this.session != null ? this.session.getProperty("mail.alternates") : null;
            if (header != null) {
                eliminateDuplicates(vector, InternetAddress.parse(header, false));
            }
            header = this.session != null ? this.session.getProperty("mail.replyallcc") : null;
            if (header == null || !header.equalsIgnoreCase("true")) {
                z2 = false;
            }
            eliminateDuplicates(vector, replyTo);
            Address[] eliminateDuplicates = eliminateDuplicates(vector, getRecipients(javax.mail.Message.RecipientType.TO));
            if (eliminateDuplicates != null && eliminateDuplicates.length > 0) {
                if (z2) {
                    createMimeMessage.addRecipients(javax.mail.Message.RecipientType.CC, eliminateDuplicates);
                } else {
                    createMimeMessage.addRecipients(javax.mail.Message.RecipientType.TO, eliminateDuplicates);
                }
            }
            eliminateDuplicates = eliminateDuplicates(vector, getRecipients(javax.mail.Message.RecipientType.CC));
            if (eliminateDuplicates != null && eliminateDuplicates.length > 0) {
                createMimeMessage.addRecipients(javax.mail.Message.RecipientType.CC, eliminateDuplicates);
            }
            eliminateDuplicates = getRecipients(RecipientType.NEWSGROUPS);
            if (eliminateDuplicates != null && eliminateDuplicates.length > 0) {
                createMimeMessage.setRecipients(RecipientType.NEWSGROUPS, eliminateDuplicates);
            }
        }
        header = getHeader("Message-Id", null);
        if (header != null) {
            createMimeMessage.setHeader("In-Reply-To", header);
        }
        String header2 = getHeader("References", " ");
        if (header2 == null) {
            header2 = getHeader("In-Reply-To", " ");
        }
        if (header == null) {
            header = header2;
        } else if (header2 != null) {
            header = MimeUtility.unfold(header2) + " " + header;
        }
        if (header != null) {
            createMimeMessage.setHeader("References", MimeUtility.fold(12, header));
        }
        try {
            setFlags(answeredFlag, true);
        } catch (MessagingException e) {
        }
        return createMimeMessage;
    }

    public void saveChanges() {
        this.modified = true;
        this.saved = true;
        updateHeaders();
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
        MimeBodyPart.setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) {
        setHeader("Content-MD5", str);
    }

    public synchronized void setDataHandler(DataHandler dataHandler) {
        this.dh = dataHandler;
        this.cachedContent = null;
        MimeBodyPart.invalidateContentHeaders(this);
    }

    public void setDescription(String str) {
        setDescription(str, null);
    }

    public void setDescription(String str, String str2) {
        MimeBodyPart.setDescription(this, str, str2);
    }

    public void setDisposition(String str) {
        MimeBodyPart.setDisposition(this, str);
    }

    public void setFileName(String str) {
        MimeBodyPart.setFileName(this, str);
    }

    public synchronized void setFlags(Flags flags, boolean z) {
        if (z) {
            this.flags.add(flags);
        } else {
            this.flags.remove(flags);
        }
    }

    public void setFrom() {
        Address localAddress = InternetAddress.getLocalAddress(this.session);
        if (localAddress != null) {
            setFrom(localAddress);
            return;
        }
        throw new MessagingException("No From address");
    }

    public void setFrom(Address address) {
        if (address == null) {
            removeHeader("From");
        } else {
            setHeader("From", address.toString());
        }
    }

    public void setHeader(String str, String str2) {
        this.headers.setHeader(str, str2);
    }

    public void setRecipients(javax.mail.Message.RecipientType recipientType, String str) {
        if (recipientType != RecipientType.NEWSGROUPS) {
            setAddressHeader(getHeaderName(recipientType), InternetAddress.parse(str));
        } else if (str == null || str.length() == 0) {
            removeHeader("Newsgroups");
        } else {
            setHeader("Newsgroups", str);
        }
    }

    public void setRecipients(javax.mail.Message.RecipientType recipientType, Address[] addressArr) {
        if (recipientType != RecipientType.NEWSGROUPS) {
            setAddressHeader(getHeaderName(recipientType), addressArr);
        } else if (addressArr == null || addressArr.length == 0) {
            removeHeader("Newsgroups");
        } else {
            setHeader("Newsgroups", NewsAddress.toString(addressArr));
        }
    }

    public void setReplyTo(Address[] addressArr) {
        setAddressHeader("Reply-To", addressArr);
    }

    public void setSender(Address address) {
        if (address == null) {
            removeHeader("Sender");
        } else {
            setHeader("Sender", address.toString());
        }
    }

    public void setSentDate(Date date) {
        if (date == null) {
            removeHeader("Date");
            return;
        }
        synchronized (mailDateFormat) {
            setHeader("Date", mailDateFormat.format(date));
        }
    }

    public void setSubject(String str) {
        setSubject(str, null);
    }

    public void setSubject(String str, String str2) {
        if (str == null) {
            removeHeader("Subject");
            return;
        }
        try {
            setHeader("Subject", MimeUtility.fold(9, MimeUtility.encodeText(str, str2, null)));
        } catch (Exception e) {
            throw new MessagingException("Encoding error", e);
        }
    }

    public void setText(String str) {
        setText(str, null);
    }

    public void setText(String str, String str2) {
        MimeBodyPart.setText(this, str, str2, "plain");
    }

    public void setText(String str, String str2, String str3) {
        MimeBodyPart.setText(this, str, str2, str3);
    }

    protected void updateHeaders() {
        MimeBodyPart.updateHeaders(this);
        setHeader("MIME-Version", "1.0");
        updateMessageID();
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

    protected void updateMessageID() {
        setHeader("Message-ID", "<" + UniqueValue.getUniqueMessageIDValue(this.session) + ">");
    }

    public void writeTo(OutputStream outputStream) {
        writeTo(outputStream, null);
    }

    public void writeTo(OutputStream outputStream, String[] strArr) {
        if (!this.saved) {
            saveChanges();
        }
        if (this.modified) {
            MimeBodyPart.writeTo(this, outputStream, strArr);
            return;
        }
        Enumeration nonMatchingHeaderLines = getNonMatchingHeaderLines(strArr);
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        if (this.content == null) {
            InputStream contentStream = getContentStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = contentStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            contentStream.close();
        } else {
            outputStream.write(this.content);
        }
        outputStream.flush();
    }
}
