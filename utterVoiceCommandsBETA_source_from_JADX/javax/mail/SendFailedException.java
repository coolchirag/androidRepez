package javax.mail;

public class SendFailedException extends MessagingException {
    private static final long serialVersionUID = -6457531621682372913L;
    protected transient Address[] invalid;
    protected transient Address[] validSent;
    protected transient Address[] validUnsent;

    public SendFailedException(String str) {
        super(str);
    }

    public SendFailedException(String str, Exception exception) {
        super(str, exception);
    }

    public SendFailedException(String str, Exception exception, Address[] addressArr, Address[] addressArr2, Address[] addressArr3) {
        super(str, exception);
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }
}
