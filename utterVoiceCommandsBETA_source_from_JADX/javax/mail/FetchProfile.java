package javax.mail;

import java.util.Vector;

public class FetchProfile {
    private Vector headers = null;
    private Vector specials = null;

    public class Item {
        public static final Item CONTENT_INFO = new Item("CONTENT_INFO");
        public static final Item ENVELOPE = new Item("ENVELOPE");
        public static final Item FLAGS = new Item("FLAGS");
        private String name;

        protected Item(String str) {
            this.name = str;
        }
    }

    public void add(String str) {
        if (this.headers == null) {
            this.headers = new Vector();
        }
        this.headers.addElement(str);
    }

    public void add(Item item) {
        if (this.specials == null) {
            this.specials = new Vector();
        }
        this.specials.addElement(item);
    }

    public boolean contains(String str) {
        return this.headers != null && this.headers.contains(str);
    }

    public boolean contains(Item item) {
        return this.specials != null && this.specials.contains(item);
    }

    public String[] getHeaderNames() {
        if (this.headers == null) {
            return new String[0];
        }
        String[] strArr = new String[this.headers.size()];
        this.headers.copyInto(strArr);
        return strArr;
    }

    public Item[] getItems() {
        if (this.specials == null) {
            return new Item[0];
        }
        Item[] itemArr = new Item[this.specials.size()];
        this.specials.copyInto(itemArr);
        return itemArr;
    }
}
