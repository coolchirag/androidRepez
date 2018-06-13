package javax.mail;

public class Quota {
    public String quotaRoot;
    public Resource[] resources;

    public class Resource {
        public long limit;
        public String name;
        public long usage;

        public Resource(String str, long j, long j2) {
            this.name = str;
            this.usage = j;
            this.limit = j2;
        }
    }

    public Quota(String str) {
        this.quotaRoot = str;
    }

    public void setResourceLimit(String str, long j) {
        if (this.resources == null) {
            this.resources = new Resource[1];
            this.resources[0] = new Resource(str, 0, j);
            return;
        }
        for (int i = 0; i < this.resources.length; i++) {
            if (this.resources[i].name.equalsIgnoreCase(str)) {
                this.resources[i].limit = j;
                return;
            }
        }
        Object obj = new Resource[(this.resources.length + 1)];
        System.arraycopy(this.resources, 0, obj, 0, this.resources.length);
        obj[obj.length - 1] = new Resource(str, 0, j);
        this.resources = obj;
    }
}
