package javax.mail.search;

import javax.mail.Message;

public final class AndTerm extends SearchTerm {
    private static final long serialVersionUID = -3583274505380989582L;
    protected SearchTerm[] terms;

    public AndTerm(SearchTerm searchTerm, SearchTerm searchTerm2) {
        this.terms = new SearchTerm[2];
        this.terms[0] = searchTerm;
        this.terms[1] = searchTerm2;
    }

    public AndTerm(SearchTerm[] searchTermArr) {
        this.terms = new SearchTerm[searchTermArr.length];
        for (int i = 0; i < searchTermArr.length; i++) {
            this.terms[i] = searchTermArr[i];
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AndTerm)) {
            return false;
        }
        AndTerm andTerm = (AndTerm) obj;
        if (andTerm.terms.length != this.terms.length) {
            return false;
        }
        for (int i = 0; i < this.terms.length; i++) {
            if (!this.terms[i].equals(andTerm.terms[i])) {
                return false;
            }
        }
        return true;
    }

    public final SearchTerm[] getTerms() {
        return (SearchTerm[]) this.terms.clone();
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 0;
        while (i < this.terms.length) {
            i2 += this.terms[i].hashCode();
            i++;
        }
        return i2;
    }

    public final boolean match(Message message) {
        for (SearchTerm match : this.terms) {
            if (!match.match(message)) {
                return false;
            }
        }
        return true;
    }
}