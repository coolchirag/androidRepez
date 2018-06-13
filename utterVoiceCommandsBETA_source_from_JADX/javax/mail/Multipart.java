package javax.mail;

import java.io.OutputStream;
import java.util.Vector;

public abstract class Multipart {
    protected String contentType = "multipart/mixed";
    protected Part parent;
    protected Vector parts = new Vector();

    public synchronized void addBodyPart(BodyPart bodyPart) {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.addElement(bodyPart);
        bodyPart.setParent(this);
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i) {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.insertElementAt(bodyPart, i);
        bodyPart.setParent(this);
    }

    public synchronized BodyPart getBodyPart(int i) {
        if (this.parts == null) {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
        return (BodyPart) this.parts.elementAt(i);
    }

    public String getContentType() {
        return this.contentType;
    }

    public synchronized int getCount() {
        return this.parts == null ? 0 : this.parts.size();
    }

    public synchronized Part getParent() {
        return this.parent;
    }

    public synchronized void removeBodyPart(int i) {
        if (this.parts == null) {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
        BodyPart bodyPart = (BodyPart) this.parts.elementAt(i);
        this.parts.removeElementAt(i);
        bodyPart.setParent(null);
    }

    public synchronized boolean removeBodyPart(BodyPart bodyPart) {
        boolean removeElement;
        if (this.parts == null) {
            throw new MessagingException("No such body part");
        }
        removeElement = this.parts.removeElement(bodyPart);
        bodyPart.setParent(null);
        return removeElement;
    }

    protected synchronized void setMultipartDataSource(MultipartDataSource multipartDataSource) {
        this.contentType = multipartDataSource.getContentType();
        int count = multipartDataSource.getCount();
        for (int i = 0; i < count; i++) {
            addBodyPart(multipartDataSource.getBodyPart(i));
        }
    }

    public synchronized void setParent(Part part) {
        this.parent = part;
    }

    public abstract void writeTo(OutputStream outputStream);
}
