package javax.mail.search;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

public abstract class AddressStringTerm extends StringTerm {
    private static final long serialVersionUID = 3086821234204980368L;

    protected AddressStringTerm(String str) {
        super(str, true);
    }

    public boolean equals(Object obj) {
        return !(obj instanceof AddressStringTerm) ? false : super.equals(obj);
    }

    protected boolean match(Address address) {
        return address instanceof InternetAddress ? super.match(((InternetAddress) address).toUnicodeString()) : super.match(address.toString());
    }
}
