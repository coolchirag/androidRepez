package javax.mail;

public class IllegalWriteException extends MessagingException {
    private static final long serialVersionUID = 3974370223328268013L;

    public IllegalWriteException(String str) {
        super(str);
    }
}
