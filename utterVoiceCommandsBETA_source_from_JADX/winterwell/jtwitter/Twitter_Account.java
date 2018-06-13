package winterwell.jtwitter;

import com.faceture.google.play.PropertyConsts;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.TwitterException.E401;
import winterwell.jtwitter.TwitterException.Parsing;

public class Twitter_Account {
    static final /* synthetic */ boolean $assertionsDisabled = (!Twitter_Account.class.desiredAssertionStatus());
    public static String COLOR_BG = "profile_background_color";
    public static String COLOR_LINK = "profile_link_color";
    public static String COLOR_SIDEBAR_BORDER = "profile_sidebar_border_color";
    public static String COLOR_SIDEBAR_FILL = "profile_sidebar_fill_color";
    public static String COLOR_TEXT = "profile_text_color";
    private KAccessLevel accessLevel;
    final Twitter jtwit;

    public enum KAccessLevel {
        NONE,
        READ_ONLY,
        READ_WRITE,
        READ_WRITE_DM
    }

    public class Search {
        private Date createdAt;
        private Long id;
        private String query;

        public Search(Long l, Date date, String str) {
            this.id = l;
            this.createdAt = date;
            this.query = str;
        }

        public Date getCreatedAt() {
            return this.createdAt;
        }

        public Long getId() {
            return this.id;
        }

        public String getText() {
            return this.query;
        }
    }

    public Twitter_Account(Twitter twitter) {
        if ($assertionsDisabled || twitter.getHttpClient().canAuthenticate()) {
            this.jtwit = twitter;
            return;
        }
        throw new AssertionError(twitter);
    }

    private Search makeSearch(JSONObject jSONObject) {
        return new Search(Long.valueOf(jSONObject.getLong("id")), InternalUtils.parseDate(jSONObject.getString("created_at")), jSONObject.getString(PropertyConsts.QUERY));
    }

    public Search createSavedSearch(String str) {
        String post = this.jtwit.getHttpClient().post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("saved_searches/create.json").toString(), InternalUtils.asMap(PropertyConsts.QUERY, str), true);
        try {
            return makeSearch(new JSONObject(post));
        } catch (JSONException e) {
            throw new Parsing(post, e);
        }
    }

    public Search destroySavedSearch(Long l) {
        String post = this.jtwit.getHttpClient().post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("saved_searches/destroy/").append(l).append(".json").toString(), null, true);
        try {
            return makeSearch(new JSONObject(post));
        } catch (JSONException e) {
            throw new Parsing(post, e);
        }
    }

    public KAccessLevel getAccessLevel() {
        if (this.accessLevel != null) {
            return this.accessLevel;
        }
        try {
            verifyCredentials();
            return this.accessLevel;
        } catch (E401 e) {
            return KAccessLevel.NONE;
        }
    }

    public List<Search> getSavedSearches() {
        String page = this.jtwit.getHttpClient().getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("saved_searches.json").toString(), null, true);
        try {
            JSONArray jSONArray = new JSONArray(page);
            List<Search> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(makeSearch(jSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public User setProfile(String str, String str2, String str3, String str4) {
        Map asMap = InternalUtils.asMap("name", str, "url", str2, "location", str3, "description", str4);
        return InternalUtils.user(this.jtwit.getHttpClient().post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/account/update_profile.json").toString(), asMap, true));
    }

    public User setProfileColors(Map<String, String> map) {
        if ($assertionsDisabled || map.size() != 0) {
            return InternalUtils.user(this.jtwit.getHttpClient().post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/account/update_profile_colors.json").toString(), map, true));
        }
        throw new AssertionError();
    }

    public String toString() {
        return "TwitterAccount[" + this.jtwit.getScreenName() + "]";
    }

    public User verifyCredentials() {
        String page = this.jtwit.getHttpClient().getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/account/verify_credentials.json").toString(), null, true);
        String header = this.jtwit.getHttpClient().getHeader("X-Access-Level");
        if (header != null) {
            if ("read".equals(header)) {
                this.accessLevel = KAccessLevel.READ_ONLY;
            }
            if ("read-write".equals(header)) {
                this.accessLevel = KAccessLevel.READ_WRITE;
            }
            if ("read-write-directmessages".equals(header)) {
                this.accessLevel = KAccessLevel.READ_WRITE_DM;
            }
        }
        User user = InternalUtils.user(page);
        this.jtwit.self = user;
        return user;
    }
}
