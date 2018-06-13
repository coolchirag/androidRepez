package javax.mail.search;

import javax.mail.Message;

public final class NotTerm extends SearchTerm {
    private static final long serialVersionUID = 7152293214217310216L;
    protected SearchTerm term;

    public NotTerm(SearchTerm searchTerm) {
        this.term = searchTerm;
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof NotTerm) ? false : ((NotTerm) obj).term.equals(this.term);
    }

    public final SearchTerm getTerm() {
        return this.term;
    }

    public final int hashCode() {
        return this.term.hashCode() << 1;
    }

    public final boolean match(Message message) {
        return !this.term.match(message);
    }
}
