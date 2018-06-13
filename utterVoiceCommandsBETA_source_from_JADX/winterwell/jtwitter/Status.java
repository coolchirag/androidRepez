package winterwell.jtwitter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.ITweet;
import winterwell.jtwitter.Twitter.KEntityType;
import winterwell.jtwitter.Twitter.TweetEntity;
import winterwell.jtwitter.TwitterException.Parsing;

public final class Status implements ITweet {
    static final Pattern AT_YOU_SIR = Pattern.compile("@(\\w+)");
    private static final String FAKE = "fake";
    private static final long serialVersionUID = 1;
    public final Date createdAt;
    private EnumMap<KEntityType, List<TweetEntity>> entities;
    private boolean favorited;
    public final BigInteger id;
    public final BigInteger inReplyToStatusId;
    private String location;
    private Status original;
    private Place place;
    public final int retweetCount;
    boolean sensitive;
    public final String source;
    public final String text;
    public final User user;

    Status(JSONObject jSONObject, User user) {
        try {
            String str;
            String optString = jSONObject.optString("id_str");
            if (optString == "") {
                optString = jSONObject.get("id").toString();
            }
            this.id = new BigInteger(optString);
            JSONObject optJSONObject = jSONObject.optJSONObject("retweeted_status");
            if (optJSONObject != null) {
                this.original = new Status(optJSONObject, null);
            }
            String jsonGet = InternalUtils.jsonGet(HttpRequestParams.TEXT, jSONObject);
            if (jSONObject.optBoolean("truncated") && this.original != null && jsonGet.startsWith("RT ")) {
                optString = "RT @" + this.original.getUser() + ": ";
                str = optString;
                optString = new StringBuilder(String.valueOf(optString)).append(this.original.getText()).toString();
            } else {
                optString = InternalUtils.unencode(jsonGet);
                str = null;
            }
            this.text = optString;
            this.createdAt = InternalUtils.parseDate(InternalUtils.jsonGet("created_at", jSONObject));
            optString = InternalUtils.jsonGet("source", jSONObject);
            if (optString != null && optString.contains("&lt;")) {
                optString = InternalUtils.unencode(optString);
            }
            this.source = optString;
            optString = InternalUtils.jsonGet("in_reply_to_status_id", jSONObject);
            if (optString == null) {
                this.inReplyToStatusId = this.original == null ? null : this.original.getId();
            } else {
                this.inReplyToStatusId = new BigInteger(optString);
            }
            this.favorited = jSONObject.optBoolean("favorited");
            if (user != null) {
                this.user = user;
            } else {
                optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject == null) {
                    this.user = null;
                } else if (optJSONObject.length() < 3) {
                    optString = optJSONObject.optString("id_str");
                    if (optString == "") {
                        optString = jSONObject.get("id").toString();
                    }
                    try {
                        user = new Twitter().show(new BigInteger(optString));
                    } catch (Exception e) {
                    }
                    this.user = user;
                } else {
                    this.user = new User(optJSONObject, this);
                }
            }
            Object jsonGetLocn = jsonGetLocn(jSONObject);
            this.location = jsonGetLocn == null ? null : jsonGetLocn.toString();
            if (jsonGetLocn instanceof Place) {
                this.place = (Place) jsonGetLocn;
            }
            this.retweetCount = jSONObject.optInt("retweet_count", -1);
            optJSONObject = jSONObject.optJSONObject("entities");
            if (optJSONObject != null) {
                this.entities = new EnumMap(KEntityType.class);
                setupEntities(jsonGet, str, optJSONObject);
            }
            this.sensitive = jSONObject.optBoolean("possibly_sensitive");
        } catch (JSONException e2) {
            throw new Parsing(null, e2);
        }
    }

    @Deprecated
    public Status(User user, String str, Number number, Date date) {
        this.text = str;
        this.user = user;
        this.createdAt = date;
        BigInteger bigInteger = number == null ? null : number instanceof BigInteger ? (BigInteger) number : new BigInteger(number.toString());
        this.id = bigInteger;
        this.inReplyToStatusId = null;
        this.source = FAKE;
        this.retweetCount = -1;
    }

    static String getDisplayText2(ITweet iTweet) {
        List<TweetEntity> tweetEntities = iTweet.getTweetEntities(KEntityType.urls);
        String text = iTweet.getText();
        if (tweetEntities == null || tweetEntities.size() == 0) {
            return text;
        }
        StringBuilder stringBuilder = new StringBuilder(200);
        int i = 0;
        for (TweetEntity tweetEntity : tweetEntities) {
            stringBuilder.append(text.substring(i, tweetEntity.start));
            stringBuilder.append(tweetEntity.displayVersion());
            i = tweetEntity.end;
        }
        if (i < text.length()) {
            stringBuilder.append(text.substring(i));
        }
        return stringBuilder.toString();
    }

    static List<Status> getStatuses(String str) {
        if (str.trim().equals("")) {
            return Collections.emptyList();
        }
        try {
            List<Status> arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (!JSONObject.NULL.equals(obj)) {
                    arrayList.add(new Status((JSONObject) obj, null));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(str, e);
        }
    }

    static List<Status> getStatusesFromSearch(Twitter twitter, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            List<Status> arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("from_user");
                String string2 = jSONObject2.getString("profile_image_url");
                User user = new User(string);
                user.profileImageUrl = InternalUtils.URI(string2);
                arrayList.add(new Status(jSONObject2, user));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(str, e);
        }
    }

    static Object jsonGetLocn(JSONObject jSONObject) {
        CharSequence jsonGet = InternalUtils.jsonGet("location", jSONObject);
        if (jsonGet != null && jsonGet.length() == 0) {
            jsonGet = null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("place");
        if (jsonGet != null) {
            Matcher matcher = InternalUtils.latLongLocn.matcher(jsonGet);
            return matcher.matches() ? matcher.group(2) + "," + matcher.group(3) : jsonGet;
        } else if (optJSONObject != null) {
            return new Place(optJSONObject);
        } else {
            optJSONObject = jSONObject.optJSONObject("geo");
            if (optJSONObject == null || optJSONObject == JSONObject.NULL) {
                return jsonGet;
            }
            JSONArray jSONArray = optJSONObject.getJSONArray("coordinates");
            return jSONArray.get(0) + "," + jSONArray.get(1);
        }
    }

    private void setupEntities(String str, String str2, JSONObject jSONObject) {
        if (str2 != null) {
            int length = str2.length();
            for (Enum enumR : KEntityType.values()) {
                List<TweetEntity> tweetEntities = this.original.getTweetEntities(enumR);
                if (tweetEntities != null) {
                    ArrayList arrayList = new ArrayList(tweetEntities.size());
                    for (TweetEntity tweetEntity : tweetEntities) {
                        arrayList.add(new TweetEntity((ITweet) this, tweetEntity.type, Math.min(tweetEntity.start + length, this.text.length()), Math.min(tweetEntity.end + length, this.text.length()), tweetEntity.display));
                    }
                    this.entities.put(enumR, arrayList);
                }
            }
            return;
        }
        for (Enum enumR2 : KEntityType.values()) {
            this.entities.put(enumR2, TweetEntity.parse(this, str, enumR2, jSONObject));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.id.equals(((Status) obj).id);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getDisplayText() {
        return getDisplayText2(this);
    }

    public final BigInteger getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<String> getMentions() {
        Matcher matcher = AT_YOU_SIR.matcher(this.text);
        List<String> arrayList = new ArrayList(2);
        while (matcher.find()) {
            if (matcher.start() == 0 || !Character.isLetterOrDigit(this.text.charAt(matcher.start() - 1))) {
                Object group = matcher.group(1);
                if (!Twitter.CASE_SENSITIVE_SCREENNAMES) {
                    group = group.toLowerCase();
                }
                arrayList.add(group);
            }
        }
        return arrayList;
    }

    public final Status getOriginal() {
        return this.original;
    }

    public final Place getPlace() {
        return this.place;
    }

    public final String getText() {
        return this.text;
    }

    public final List<TweetEntity> getTweetEntities(KEntityType kEntityType) {
        return this.entities == null ? null : (List) this.entities.get(kEntityType);
    }

    public final User getUser() {
        return this.user;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    public final boolean isFavorite() {
        return this.favorited;
    }

    public final boolean isSensitive() {
        return this.sensitive;
    }

    public final String toString() {
        return this.text;
    }
}
