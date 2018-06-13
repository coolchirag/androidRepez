package javax.mail;

import java.util.Vector;
import javax.mail.Flags.Flag;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.MailEvent;
import javax.mail.event.MessageChangedEvent;
import javax.mail.event.MessageChangedListener;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.search.SearchTerm;

public abstract class Folder {
    public static final int HOLDS_FOLDERS = 2;
    public static final int HOLDS_MESSAGES = 1;
    public static final int READ_ONLY = 1;
    public static final int READ_WRITE = 2;
    private volatile Vector connectionListeners = null;
    private volatile Vector folderListeners = null;
    private volatile Vector messageChangedListeners = null;
    private volatile Vector messageCountListeners = null;
    protected int mode = -1;
    private EventQueue f3051q;
    private Object qLock = new Object();
    protected Store store;

    class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 3765761925441296565L;

        TerminatorEvent() {
            super(new Object());
        }

        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    protected Folder(Store store) {
        this.store = store;
    }

    private void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.f3051q == null) {
                this.f3051q = new EventQueue();
            }
        }
        this.f3051q.enqueue(mailEvent, (Vector) vector.clone());
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.f3051q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.f3051q.enqueue(new TerminatorEvent(), vector);
                this.f3051q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void addFolderListener(FolderListener folderListener) {
        if (this.folderListeners == null) {
            this.folderListeners = new Vector();
        }
        this.folderListeners.addElement(folderListener);
    }

    public synchronized void addMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners == null) {
            this.messageChangedListeners = new Vector();
        }
        this.messageChangedListeners.addElement(messageChangedListener);
    }

    public synchronized void addMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners == null) {
            this.messageCountListeners = new Vector();
        }
        this.messageCountListeners.addElement(messageCountListener);
    }

    public abstract void appendMessages(Message[] messageArr);

    public abstract void close(boolean z);

    public void copyMessages(Message[] messageArr, Folder folder) {
        if (folder.exists()) {
            folder.appendMessages(messageArr);
            return;
        }
        throw new FolderNotFoundException(folder.getFullName() + " does not exist", folder);
    }

    public abstract boolean create(int i);

    public abstract boolean delete(boolean z);

    public abstract boolean exists();

    public abstract Message[] expunge();

    public void fetch(Message[] messageArr, FetchProfile fetchProfile) {
    }

    protected void finalize() {
        super.finalize();
        terminateQueue();
    }

    public synchronized int getDeletedMessageCount() {
        int i;
        if (isOpen()) {
            int messageCount = getMessageCount();
            i = 0;
            for (int i2 = 1; i2 <= messageCount; i2++) {
                try {
                    if (getMessage(i2).isSet(Flag.DELETED)) {
                        i++;
                    }
                } catch (MessageRemovedException e) {
                }
            }
        } else {
            i = -1;
        }
        return i;
    }

    public abstract Folder getFolder(String str);

    public abstract String getFullName();

    public abstract Message getMessage(int i);

    public abstract int getMessageCount();

    public synchronized Message[] getMessages() {
        Message[] messageArr;
        if (isOpen()) {
            int messageCount = getMessageCount();
            messageArr = new Message[messageCount];
            for (int i = 1; i <= messageCount; i++) {
                messageArr[i - 1] = getMessage(i);
            }
        } else {
            throw new IllegalStateException("Folder not open");
        }
        return messageArr;
    }

    public synchronized Message[] getMessages(int i, int i2) {
        Message[] messageArr;
        messageArr = new Message[((i2 - i) + 1)];
        for (int i3 = i; i3 <= i2; i3++) {
            messageArr[i3 - i] = getMessage(i3);
        }
        return messageArr;
    }

    public synchronized Message[] getMessages(int[] iArr) {
        Message[] messageArr;
        int length = iArr.length;
        messageArr = new Message[length];
        for (int i = 0; i < length; i++) {
            messageArr[i] = getMessage(iArr[i]);
        }
        return messageArr;
    }

    public int getMode() {
        if (isOpen()) {
            return this.mode;
        }
        throw new IllegalStateException("Folder not open");
    }

    public abstract String getName();

    public synchronized int getNewMessageCount() {
        int i;
        if (isOpen()) {
            int messageCount = getMessageCount();
            i = 0;
            for (int i2 = 1; i2 <= messageCount; i2++) {
                try {
                    if (getMessage(i2).isSet(Flag.RECENT)) {
                        i++;
                    }
                } catch (MessageRemovedException e) {
                }
            }
        } else {
            i = -1;
        }
        return i;
    }

    public abstract Folder getParent();

    public abstract Flags getPermanentFlags();

    public abstract char getSeparator();

    public Store getStore() {
        return this.store;
    }

    public abstract int getType();

    public URLName getURLName() {
        URLName uRLName = getStore().getURLName();
        String fullName = getFullName();
        StringBuffer stringBuffer = new StringBuffer();
        getSeparator();
        if (fullName != null) {
            stringBuffer.append(fullName);
        }
        return new URLName(uRLName.getProtocol(), uRLName.getHost(), uRLName.getPort(), stringBuffer.toString(), uRLName.getUsername(), null);
    }

    public synchronized int getUnreadMessageCount() {
        int i;
        if (isOpen()) {
            int messageCount = getMessageCount();
            i = 0;
            for (int i2 = 1; i2 <= messageCount; i2++) {
                try {
                    if (!getMessage(i2).isSet(Flag.SEEN)) {
                        i++;
                    }
                } catch (MessageRemovedException e) {
                }
            }
        } else {
            i = -1;
        }
        return i;
    }

    public abstract boolean hasNewMessages();

    public abstract boolean isOpen();

    public boolean isSubscribed() {
        return true;
    }

    public Folder[] list() {
        return list("%");
    }

    public abstract Folder[] list(String str);

    public Folder[] listSubscribed() {
        return listSubscribed("%");
    }

    public Folder[] listSubscribed(String str) {
        return list(str);
    }

    protected void notifyConnectionListeners(int i) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i), this.connectionListeners);
        }
        if (i == 3) {
            terminateQueue();
        }
    }

    protected void notifyFolderListeners(int i) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, i), this.folderListeners);
        }
        this.store.notifyFolderListeners(i, this);
    }

    protected void notifyFolderRenamedListeners(Folder folder) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, folder, 3), this.folderListeners);
        }
        this.store.notifyFolderRenamedListeners(this, folder);
    }

    protected void notifyMessageAddedListeners(Message[] messageArr) {
        if (this.messageCountListeners != null) {
            queueEvent(new MessageCountEvent(this, 1, false, messageArr), this.messageCountListeners);
        }
    }

    protected void notifyMessageChangedListeners(int i, Message message) {
        if (this.messageChangedListeners != null) {
            queueEvent(new MessageChangedEvent(this, i, message), this.messageChangedListeners);
        }
    }

    protected void notifyMessageRemovedListeners(boolean z, Message[] messageArr) {
        if (this.messageCountListeners != null) {
            queueEvent(new MessageCountEvent(this, 2, z, messageArr), this.messageCountListeners);
        }
    }

    public abstract void open(int i);

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners != null) {
            this.connectionListeners.removeElement(connectionListener);
        }
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    public synchronized void removeMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners != null) {
            this.messageChangedListeners.removeElement(messageChangedListener);
        }
    }

    public synchronized void removeMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners != null) {
            this.messageCountListeners.removeElement(messageCountListener);
        }
    }

    public abstract boolean renameTo(Folder folder);

    public Message[] search(SearchTerm searchTerm) {
        return search(searchTerm, getMessages());
    }

    public Message[] search(SearchTerm searchTerm, Message[] messageArr) {
        Vector vector = new Vector();
        for (int i = 0; i < messageArr.length; i++) {
            try {
                if (messageArr[i].match(searchTerm)) {
                    vector.addElement(messageArr[i]);
                }
            } catch (MessageRemovedException e) {
            }
        }
        Message[] messageArr2 = new Message[vector.size()];
        vector.copyInto(messageArr2);
        return messageArr2;
    }

    public synchronized void setFlags(int i, int i2, Flags flags, boolean z) {
        while (i <= i2) {
            try {
                getMessage(i).setFlags(flags, z);
            } catch (MessageRemovedException e) {
            }
            i++;
        }
    }

    public synchronized void setFlags(int[] iArr, Flags flags, boolean z) {
        for (int message : iArr) {
            try {
                getMessage(message).setFlags(flags, z);
            } catch (MessageRemovedException e) {
            }
        }
    }

    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z) {
        for (Message flags2 : messageArr) {
            try {
                flags2.setFlags(flags, z);
            } catch (MessageRemovedException e) {
            }
        }
    }

    public void setSubscribed(boolean z) {
        throw new MethodNotSupportedException();
    }

    public String toString() {
        String fullName = getFullName();
        return fullName != null ? fullName : super.toString();
    }
}
