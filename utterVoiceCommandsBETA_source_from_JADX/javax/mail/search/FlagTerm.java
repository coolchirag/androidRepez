package javax.mail.search;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Message;

public final class FlagTerm extends SearchTerm {
    private static final long serialVersionUID = -142991500302030647L;
    protected Flags flags;
    protected boolean set;

    public FlagTerm(Flags flags, boolean z) {
        this.flags = flags;
        this.set = z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FlagTerm)) {
            return false;
        }
        FlagTerm flagTerm = (FlagTerm) obj;
        return flagTerm.set == this.set && flagTerm.flags.equals(this.flags);
    }

    public final Flags getFlags() {
        return (Flags) this.flags.clone();
    }

    public final boolean getTestSet() {
        return this.set;
    }

    public final int hashCode() {
        return this.set ? this.flags.hashCode() : this.flags.hashCode() ^ -1;
    }

    public final boolean match(Message message) {
        try {
            Flags flags = message.getFlags();
            if (this.set) {
                return flags.contains(this.flags);
            } else {
                Flag[] systemFlags = this.flags.getSystemFlags();
                for (Flag contains : systemFlags) {
                    if (flags.contains(contains)) {
                        return false;
                    }
                }
                String[] userFlags = this.flags.getUserFlags();
                for (String contains2 : userFlags) {
                    if (flags.contains(contains2)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
