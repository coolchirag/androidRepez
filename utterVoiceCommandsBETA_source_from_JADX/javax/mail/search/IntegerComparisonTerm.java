package javax.mail.search;

public abstract class IntegerComparisonTerm extends ComparisonTerm {
    private static final long serialVersionUID = -6963571240154302484L;
    protected int number;

    protected IntegerComparisonTerm(int i, int i2) {
        this.comparison = i;
        this.number = i2;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof IntegerComparisonTerm) ? false : ((IntegerComparisonTerm) obj).number == this.number && super.equals(obj);
    }

    public int getComparison() {
        return this.comparison;
    }

    public int getNumber() {
        return this.number;
    }

    public int hashCode() {
        return this.number + super.hashCode();
    }

    protected boolean match(int i) {
        switch (this.comparison) {
            case 1:
                return i <= this.number;
            case 2:
                return i < this.number;
            case 3:
                return i == this.number;
            case 4:
                return i != this.number;
            case 5:
                return i > this.number;
            case 6:
                return i >= this.number;
            default:
                return false;
        }
    }
}
