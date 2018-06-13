package javax.mail.search;

import java.util.Date;
import javax.mail.Message;

public final class ReceivedDateTerm extends DateTerm {
    private static final long serialVersionUID = -2756695246195503170L;

    public ReceivedDateTerm(int i, Date date) {
        super(i, date);
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof ReceivedDateTerm) ? false : super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            Date receivedDate = message.getReceivedDate();
            return receivedDate == null ? false : super.match(receivedDate);
        } catch (Exception e) {
            return false;
        }
    }
}
