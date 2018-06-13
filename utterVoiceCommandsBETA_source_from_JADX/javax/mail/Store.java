package javax.mail;

import java.util.Vector;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.StoreEvent;
import javax.mail.event.StoreListener;

public abstract class Store extends Service {
    private volatile Vector folderListeners = null;
    private volatile Vector storeListeners = null;

    protected Store(Session session, URLName uRLName) {
        super(session, uRLName);
    }

    public synchronized void addFolderListener(FolderListener folderListener) {
        if (this.folderListeners == null) {
            this.folderListeners = new Vector();
        }
        this.folderListeners.addElement(folderListener);
    }

    public synchronized void addStoreListener(StoreListener storeListener) {
        if (this.storeListeners == null) {
            this.storeListeners = new Vector();
        }
        this.storeListeners.addElement(storeListener);
    }

    public abstract Folder getDefaultFolder();

    public abstract Folder getFolder(String str);

    public abstract Folder getFolder(URLName uRLName);

    public Folder[] getPersonalNamespaces() {
        return new Folder[]{getDefaultFolder()};
    }

    public Folder[] getSharedNamespaces() {
        return new Folder[0];
    }

    public Folder[] getUserNamespaces(String str) {
        return new Folder[0];
    }

    protected void notifyFolderListeners(int i, Folder folder) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, folder, i), this.folderListeners);
        }
    }

    protected void notifyFolderRenamedListeners(Folder folder, Folder folder2) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, folder, folder2, 3), this.folderListeners);
        }
    }

    protected void notifyStoreListeners(int i, String str) {
        if (this.storeListeners != null) {
            queueEvent(new StoreEvent(this, i, str), this.storeListeners);
        }
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    public synchronized void removeStoreListener(StoreListener storeListener) {
        if (this.storeListeners != null) {
            this.storeListeners.removeElement(storeListener);
        }
    }
}
