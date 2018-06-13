package javax.mail.search;

import javax.mail.Address;

public abstract class AddressTerm extends SearchTerm {
    private static final long serialVersionUID = 2005405551929769980L;
    protected Address address;

    protected AddressTerm(Address address) {
        this.address = address;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof AddressTerm) ? false : ((AddressTerm) obj).address.equals(this.address);
    }

    public Address getAddress() {
        return this.address;
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    protected boolean match(Address address) {
        return address.equals(this.address);
    }
}
