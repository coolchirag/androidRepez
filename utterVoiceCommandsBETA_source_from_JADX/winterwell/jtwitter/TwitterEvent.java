package winterwell.jtwitter;

import java.util.Date;
import winterwell.json.JSONObject;

public class TwitterEvent {
    public final Date createdAt;
    public final User source;
    public final User target;
    private Object targetObject;
    public final String type;

    public interface Type {
        public static final String ADDED_TO_LIST = "list_member_added";
        public static final String FAVORITE = "favorite";
        public static final String FOLLOW = "follow";
        public static final String LIST_CREATED = "list_created";
        public static final String REMOVED_FROM_LIST = "list_member_removed";
        public static final String UNFAVORITE = "unfavorite";
        public static final String USER_UPDATE = "user_update";
    }

    TwitterEvent(Date date, User user, String str, User user2, Object obj) {
        this.createdAt = date;
        this.source = user;
        this.type = str;
        this.target = user2;
        this.targetObject = obj;
    }

    public TwitterEvent(JSONObject jSONObject, Twitter twitter) {
        this.type = jSONObject.getString("event");
        this.target = new User(jSONObject.getJSONObject("target"), null);
        this.source = new User(jSONObject.getJSONObject("source"), null);
        this.createdAt = InternalUtils.parseDate(jSONObject.getString("created_at"));
        JSONObject optJSONObject = jSONObject.optJSONObject("target_object");
        if (optJSONObject != null) {
            if (optJSONObject.has("member_count")) {
                this.targetObject = new TwitterList(optJSONObject, twitter);
            } else {
                this.targetObject = optJSONObject;
            }
        }
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public User getSource() {
        return this.source;
    }

    public User getTarget() {
        return this.target;
    }

    public Object getTargetObject() {
        return this.targetObject;
    }

    public String getType() {
        return this.type;
    }

    public boolean is(String str) {
        return this.type.equals(str);
    }

    public String toString() {
        return this.source + " " + this.type + " " + this.target + " " + getTargetObject();
    }
}
