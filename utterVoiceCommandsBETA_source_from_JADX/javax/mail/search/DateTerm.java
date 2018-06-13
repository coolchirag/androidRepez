package javax.mail.search;

import java.util.Date;

public abstract class DateTerm extends ComparisonTerm {
    private static final long serialVersionUID = 4818873430063720043L;
    protected Date date;

    protected DateTerm(int i, Date date) {
        this.comparison = i;
        this.date = date;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof DateTerm) ? false : ((DateTerm) obj).date.equals(this.date) && super.equals(obj);
    }

    public int getComparison() {
        return this.comparison;
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    public int hashCode() {
        return this.date.hashCode() + super.hashCode();
    }

    protected boolean match(Date date) {
        switch (this.comparison) {
            case 1:
                return date.before(this.date) || date.equals(this.date);
            case 2:
                return date.before(this.date);
            case 3:
                return date.equals(this.date);
            case 4:
                return !date.equals(this.date);
            case 5:
                return date.after(this.date);
            case 6:
                return date.after(this.date) || date.equals(this.date);
            default:
                return false;
        }
    }
}
