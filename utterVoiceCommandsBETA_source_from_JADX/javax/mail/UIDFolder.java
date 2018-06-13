package javax.mail;

import javax.mail.FetchProfile.Item;

public interface UIDFolder {
    public static final long LASTUID = -1;

    public class FetchProfileItem extends Item {
        public static final FetchProfileItem UID = new FetchProfileItem("UID");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    Message getMessageByUID(long j);

    Message[] getMessagesByUID(long j, long j2);

    Message[] getMessagesByUID(long[] jArr);

    long getUID(Message message);

    long getUIDValidity();
}
