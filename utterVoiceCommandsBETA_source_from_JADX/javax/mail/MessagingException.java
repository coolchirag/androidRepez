package javax.mail;

public class MessagingException extends Exception {
    private static final long serialVersionUID = -7569192289819959253L;
    private Exception next;

    public MessagingException() {
        initCause(null);
    }

    public MessagingException(String str) {
        super(str);
        initCause(null);
    }

    public MessagingException(String str, Exception exception) {
        super(str);
        this.next = exception;
        initCause(null);
    }

    private final String superToString() {
        return super.toString();
    }

    public synchronized Throwable getCause() {
        return this.next;
    }

    public synchronized Exception getNextException() {
        return this.next;
    }

    public synchronized boolean setNextException(Exception exception) {
        boolean z;
        Exception exception2 = this;
        while ((exception2 instanceof MessagingException) && ((MessagingException) exception2).next != null) {
            exception2 = ((MessagingException) exception2).next;
        }
        if (exception2 instanceof MessagingException) {
            ((MessagingException) exception2).next = exception;
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized String toString() {
        String exception;
        exception = super.toString();
        Exception exception2 = this.next;
        if (exception2 != null) {
            if (exception == null) {
                exception = "";
            }
            StringBuffer stringBuffer = new StringBuffer(exception);
            Exception exception3 = exception2;
            while (exception3 != null) {
                stringBuffer.append(";\n  nested exception is:\n\t");
                if (exception3 instanceof MessagingException) {
                    MessagingException messagingException = (MessagingException) exception3;
                    stringBuffer.append(messagingException.superToString());
                    exception3 = messagingException.next;
                } else {
                    stringBuffer.append(exception3.toString());
                    exception3 = null;
                }
            }
            exception = stringBuffer.toString();
        }
        return exception;
    }
}
