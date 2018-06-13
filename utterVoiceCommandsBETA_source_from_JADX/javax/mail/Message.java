package javax.mail;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Date;
import javax.mail.Flags.Flag;
import javax.mail.search.SearchTerm;

public abstract class Message implements Part {
    protected boolean expunged = false;
    protected Folder folder = null;
    protected int msgnum = 0;
    protected Session session = null;

    public class RecipientType implements Serializable {
        public static final RecipientType BCC = new RecipientType("Bcc");
        public static final RecipientType CC = new RecipientType("Cc");
        public static final RecipientType TO = new RecipientType("To");
        private static final long serialVersionUID = -7479791750606340008L;
        protected String type;

        public RecipientType(String str) {
            this.type = str;
        }

        public Object readResolve() {
            if (this.type.equals("To")) {
                return TO;
            }
            if (this.type.equals("Cc")) {
                return CC;
            }
            if (this.type.equals("Bcc")) {
                return BCC;
            }
            throw new InvalidObjectException("Attempt to resolve unknown RecipientType: " + this.type);
        }

        public String toString() {
            return this.type;
        }
    }

    protected Message() {
    }

    public Message(Folder folder, int i) {
        this.folder = folder;
        this.msgnum = i;
        this.session = folder.store.session;
    }

    public Message(Session session) {
        this.session = session;
    }

    public abstract void addFrom(Address[] addressArr);

    public void addRecipient(RecipientType recipientType, Address address) {
        addRecipients(recipientType, new Address[]{address});
    }

    public abstract void addRecipients(RecipientType recipientType, Address[] addressArr);

    public Address[] getAllRecipients() {
        Object recipients = getRecipients(RecipientType.TO);
        Object recipients2 = getRecipients(RecipientType.CC);
        Object recipients3 = getRecipients(RecipientType.BCC);
        if (recipients2 == null && recipients3 == null) {
            return recipients;
        }
        int length;
        Object obj = new Address[((recipients3 != null ? recipients3.length : 0) + ((recipients != null ? recipients.length : 0) + (recipients2 != null ? recipients2.length : 0)))];
        if (recipients != null) {
            System.arraycopy(recipients, 0, obj, 0, recipients.length);
            length = recipients.length + 0;
        } else {
            length = 0;
        }
        if (recipients2 != null) {
            System.arraycopy(recipients2, 0, obj, length, recipients2.length);
            length += recipients2.length;
        }
        if (recipients3 == null) {
            return obj;
        }
        System.arraycopy(recipients3, 0, obj, length, recipients3.length);
        return obj;
    }

    public abstract Flags getFlags();

    public Folder getFolder() {
        return this.folder;
    }

    public abstract Address[] getFrom();

    public int getMessageNumber() {
        return this.msgnum;
    }

    public abstract Date getReceivedDate();

    public abstract Address[] getRecipients(RecipientType recipientType);

    public Address[] getReplyTo() {
        return getFrom();
    }

    public abstract Date getSentDate();

    public abstract String getSubject();

    public boolean isExpunged() {
        return this.expunged;
    }

    public boolean isSet(Flag flag) {
        return getFlags().contains(flag);
    }

    public boolean match(SearchTerm searchTerm) {
        return searchTerm.match(this);
    }

    public abstract Message reply(boolean z);

    public abstract void saveChanges();

    protected void setExpunged(boolean z) {
        this.expunged = z;
    }

    public void setFlag(Flag flag, boolean z) {
        setFlags(new Flags(flag), z);
    }

    public abstract void setFlags(Flags flags, boolean z);

    public abstract void setFrom();

    public abstract void setFrom(Address address);

    protected void setMessageNumber(int i) {
        this.msgnum = i;
    }

    public void setRecipient(RecipientType recipientType, Address address) {
        setRecipients(recipientType, new Address[]{address});
    }

    public abstract void setRecipients(RecipientType recipientType, Address[] addressArr);

    public void setReplyTo(Address[] addressArr) {
        throw new MethodNotSupportedException("setReplyTo not supported");
    }

    public abstract void setSentDate(Date date);

    public abstract void setSubject(String str);
}
