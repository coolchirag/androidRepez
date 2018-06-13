package winterwell.jtwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.ITweet;
import winterwell.jtwitter.Twitter.KEntityType;
import winterwell.jtwitter.Twitter.TweetEntity;
import winterwell.jtwitter.TwitterException.Parsing;

public final class Message implements ITweet {
    private static final long serialVersionUID = 1;
    private final Date createdAt;
    private EnumMap<KEntityType, List<TweetEntity>> entities;
    public final Long id;
    public Number inReplyToMessageId;
    private String location;
    private Place place;
    private final User recipient;
    private final User sender;
    public final String text;

    Message(JSONObject jSONObject) {
        String str = null;
        this.id = Long.valueOf(jSONObject.getLong("id"));
        String string = jSONObject.getString(HttpRequestParams.TEXT);
        this.text = InternalUtils.unencode(string);
        this.createdAt = InternalUtils.parseDate(InternalUtils.jsonGet("created_at", jSONObject));
        this.sender = new User(jSONObject.getJSONObject("sender"), null);
        Object opt = jSONObject.opt("recipient");
        if (opt instanceof JSONObject) {
            this.recipient = new User((JSONObject) opt, null);
        } else {
            this.recipient = null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("entities");
        if (optJSONObject != null) {
            this.entities = new EnumMap(KEntityType.class);
            for (Enum enumR : KEntityType.values()) {
                this.entities.put(enumR, TweetEntity.parse(this, string, enumR, optJSONObject));
            }
        }
        opt = Status.jsonGetLocn(jSONObject);
        if (opt != null) {
            str = opt.toString();
        }
        this.location = str;
        if (opt instanceof Place) {
            this.place = (Place) opt;
        }
    }

    static List<Message> getMessages(String str) {
        if (str.trim().equals("")) {
            return Collections.emptyList();
        }
        try {
            List<Message> arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new Message(jSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(str, e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.id.equals(((Message) obj).id);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getDisplayText() {
        return Status.getDisplayText2(this);
    }

    public final Long getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<String> getMentions() {
        return Collections.singletonList(this.recipient.screenName);
    }

    public final Place getPlace() {
        return this.place;
    }

    public final User getRecipient() {
        return this.recipient;
    }

    public final User getSender() {
        return this.sender;
    }

    public final String getText() {
        return this.text;
    }

    public final List<TweetEntity> getTweetEntities(KEntityType kEntityType) {
        return this.entities == null ? null : (List) this.entities.get(kEntityType);
    }

    public final User getUser() {
        return getSender();
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    public final String toString() {
        return this.text;
    }
}
