package winterwell.jtwitter;

import java.net.URLEncoder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.IHttpClient;

public class TwitterList extends AbstractList<User> {
    static final /* synthetic */ boolean $assertionsDisabled = (!TwitterList.class.desiredAssertionStatus());
    private boolean _private;
    private long cursor = -1;
    private String description;
    private final IHttpClient http;
    private Number id;
    private final Twitter jtwit;
    private int memberCount = -1;
    private String name;
    private User owner;
    private String slug;
    private int subscriberCount;
    private final List<User> users = new ArrayList();

    @Deprecated
    public TwitterList(String str, String str2, Twitter twitter) {
        if ($assertionsDisabled || !(str == null || str2 == null || twitter == null)) {
            this.jtwit = twitter;
            this.owner = new User(str);
            this.name = str2;
            this.slug = str2;
            this.http = twitter.getHttpClient();
            init();
            return;
        }
        throw new AssertionError();
    }

    public TwitterList(String str, Twitter twitter, boolean z, String str2) {
        if ($assertionsDisabled || !(str == null || twitter == null)) {
            this.jtwit = twitter;
            String screenName = twitter.getScreenName();
            if ($assertionsDisabled || screenName != null) {
                this.name = str;
                this.slug = str;
                this.http = twitter.getHttpClient();
                String str3 = twitter.TWITTER_URL + "/lists/create.json";
                Object[] objArr = new Object[6];
                objArr[0] = "name";
                objArr[1] = str;
                objArr[2] = "mode";
                objArr[3] = z ? "public" : "private";
                objArr[4] = "description";
                objArr[5] = str2;
                try {
                    init2(new JSONObject(this.http.post(str3, InternalUtils.asMap(objArr), true)));
                    return;
                } catch (JSONException e) {
                    throw new TwitterException("Could not parse response: " + e);
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    TwitterList(JSONObject jSONObject, Twitter twitter) {
        this.jtwit = twitter;
        this.http = twitter.getHttpClient();
        init2(jSONObject);
    }

    public static TwitterList get(String str, String str2, Twitter twitter) {
        return new TwitterList(str, str2, twitter);
    }

    private Map<String, String> getListVars() {
        Map<String, String> hashMap = new HashMap();
        if (this.id != null) {
            hashMap.put("list_id", this.id);
        } else {
            hashMap.put("owner_screen_name", this.owner.screenName);
            hashMap.put("slug", this.slug);
        }
        return hashMap;
    }

    private String idOrSlug() {
        return this.id != null ? this.id.toString() : this.slug;
    }

    private void init() {
        if (this.memberCount == -1) {
            try {
                init2(new JSONObject(this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/show.json").toString(), getListVars(), true)));
            } catch (JSONException e) {
                throw new TwitterException("Could not parse response: " + e);
            }
        }
    }

    private void init2(JSONObject jSONObject) {
        this.memberCount = jSONObject.getInt("member_count");
        this.subscriberCount = jSONObject.getInt("subscriber_count");
        this.name = jSONObject.getString("name");
        this.slug = jSONObject.getString("slug");
        this.id = Long.valueOf(jSONObject.getLong("id"));
        this._private = "private".equals(jSONObject.optString("mode"));
        this.description = jSONObject.optString("description");
        this.owner = new User(jSONObject.getJSONObject("user"), null);
    }

    public boolean add(User user) {
        if (this.users.contains(user)) {
            return false;
        }
        String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/members/create.json").toString();
        Map listVars = getListVars();
        listVars.put("screen_name", user.screenName);
        try {
            this.memberCount = new JSONObject(this.http.post(stringBuilder, listVars, true)).getInt("member_count");
            this.users.add(user);
            return true;
        } catch (JSONException e) {
            throw new TwitterException("Could not parse response: " + e);
        }
    }

    public boolean addAll(Collection<? extends User> collection) {
        int i = 0;
        List arrayList = new ArrayList(collection);
        arrayList.removeAll(this.users);
        if (arrayList.size() == 0) {
            return false;
        }
        String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/members/create_all.json").toString();
        Map listVars = getListVars();
        while (i < this.users.size()) {
            listVars.put("screen_name", InternalUtils.join(arrayList, i, i + 100));
            try {
                this.memberCount = new JSONObject(this.http.post(stringBuilder, listVars, true)).getInt("member_count");
                i += 100;
            } catch (JSONException e) {
                throw new TwitterException("Could not parse response: " + e);
            }
        }
        return true;
    }

    public void delete() {
        try {
            this.http.post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/").append(this.owner.screenName).append("/lists/").append(URLEncoder.encode(this.slug, "utf-8")).append(".json?_method=DELETE").toString(), null, this.http.canAuthenticate());
        } catch (Exception e) {
            throw new TwitterException(e);
        }
    }

    public User get(int i) {
        String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/members.json").toString();
        Map listVars = getListVars();
        while (this.users.size() < i + 1 && this.cursor != 0) {
            listVars.put("cursor", Long.toString(this.cursor));
            try {
                JSONObject jSONObject = new JSONObject(this.http.getPage(stringBuilder, listVars, true));
                this.users.addAll(User.getUsers(((JSONArray) jSONObject.get("users")).toString()));
                this.cursor = new Long(jSONObject.getString("next_cursor")).longValue();
            } catch (JSONException e) {
                throw new TwitterException("Could not parse user list" + e);
            }
        }
        return (User) this.users.get(i);
    }

    public String getDescription() {
        init();
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public User getOwner() {
        return this.owner;
    }

    public List<Status> getStatuses() {
        try {
            return Status.getStatuses(this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/").append(this.owner.screenName).append("/lists/").append(URLEncoder.encode(this.slug, "UTF-8")).append("/statuses.json").toString(), null, this.http.canAuthenticate()));
        } catch (Exception e) {
            throw new TwitterException(e);
        }
    }

    public int getSubscriberCount() {
        init();
        return this.subscriberCount;
    }

    public List<User> getSubscribers() {
        try {
            return User.getUsers2(new JSONObject(this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/subscribers.json").toString(), getListVars(), true)).getJSONArray("users"));
        } catch (JSONException e) {
            throw new TwitterException("Could not parse response: " + e);
        }
    }

    public boolean isPrivate() {
        init();
        return this._private;
    }

    public boolean remove(Object obj) {
        try {
            User user = (User) obj;
            String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/members/destroy.json").toString();
            Map listVars = getListVars();
            listVars.put("screen_name", user.screenName);
            this.memberCount = new JSONObject(this.http.post(stringBuilder, listVars, true)).getInt("member_count");
            this.users.remove(user);
            return true;
        } catch (JSONException e) {
            throw new TwitterException("Could not parse response: " + e);
        }
    }

    public void setDescription(String str) {
        String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/update.json").toString();
        Map listVars = getListVars();
        listVars.put("description", str);
        try {
            init2(new JSONObject(this.http.getPage(stringBuilder, listVars, true)));
        } catch (JSONException e) {
            throw new TwitterException("Could not parse response: " + e);
        }
    }

    public void setPrivate(boolean z) {
        String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/lists/update.json").toString();
        Map listVars = getListVars();
        listVars.put("mode", z ? "private" : "public");
        try {
            init2(new JSONObject(this.http.getPage(stringBuilder, listVars, true)));
        } catch (JSONException e) {
            throw new TwitterException("Could not parse response: " + e);
        }
    }

    public int size() {
        init();
        return this.memberCount;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("[").append(this.owner).append(".").append(this.name).append("]").toString();
    }
}
