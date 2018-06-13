package javax.mail.search;

import javax.mail.Message;

public final class MessageNumberTerm extends IntegerComparisonTerm {
    private static final long serialVersionUID = -5379625829658623812L;

    public MessageNumberTerm(int i) {
        super(3, i);
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof MessageNumberTerm) ? false : super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            return super.match(message.getMessageNumber());
        } catch (Exception e) {
            return false;
        }
    }
}
