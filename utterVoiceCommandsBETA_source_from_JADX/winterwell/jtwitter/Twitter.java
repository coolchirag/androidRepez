package winterwell.jtwitter;

import java.io.File;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.TwitterException.E401;
import winterwell.jtwitter.TwitterException.E403;
import winterwell.jtwitter.TwitterException.E404;
import winterwell.jtwitter.TwitterException.Parsing;
import winterwell.jtwitter.TwitterException.Repetition;
import winterwell.jtwitter.TwitterException.TwitLongerException;
import winterwell.jtwitter.TwitterException.Unexplained;

public class Twitter implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Twitter.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static boolean CASE_SENSITIVE_SCREENNAMES = false;
    public static int LINK_LENGTH = 20;
    public static final int MAX_CHARS = 140;
    public static long PHOTO_SIZE_LIMIT = 0;
    public static final String SEARCH_MIXED = "mixed";
    public static final String SEARCH_POPULAR = "popular";
    public static final String SEARCH_RECENT = "recent";
    private static final String TWITTER_SEARCH_URL = "http://search.twitter.com";
    public static boolean WORRIED_ABOUT_TWITTER = $assertionsDisabled;
    static final Pattern contentTag = Pattern.compile("<content>(.+?)<\\/content>", 32);
    static final Pattern idTag = Pattern.compile("<id>(.+?)<\\/id>", 32);
    private static final long serialVersionUID = 1;
    public static final String version = "2.6.5";
    String TWITTER_URL;
    Integer count;
    private String geocode;
    final IHttpClient http;
    boolean includeRTs;
    private String lang;
    private BigInteger maxId;
    private int maxResults;
    private double[] myLatLong;
    private String name;
    Integer pageNumber;
    private String resultType;
    User self;
    private Date sinceDate;
    private Number sinceId;
    private String sourceApp;
    boolean tweetEntities;
    private String twitlongerApiKey;
    private String twitlongerAppName;
    private Date untilDate;
    private Number untilId;

    public interface ITweet extends Serializable {
        Date getCreatedAt();

        String getDisplayText();

        Number getId();

        String getLocation();

        List<String> getMentions();

        Place getPlace();

        String getText();

        List<TweetEntity> getTweetEntities(KEntityType kEntityType);

        User getUser();
    }

    public interface IHttpClient {
        boolean canAuthenticate();

        HttpURLConnection connect(String str, Map<String, String> map, boolean z);

        IHttpClient copy();

        String getHeader(String str);

        String getPage(String str, Map<String, String> map, boolean z);

        RateLimit getRateLimit(KRequestType kRequestType);

        boolean isRetryOnError();

        String post(String str, Map<String, String> map, boolean z);

        HttpURLConnection post2_connect(String str, Map<String, String> map);

        void setRetryOnError(boolean z);

        void setTimeout(int i);
    }

    public interface ICallback {
        boolean process(List<Status> list);
    }

    public enum KEntityType {
        hashtags,
        urls,
        user_mentions
    }

    public enum KRequestType {
        NORMAL(""),
        SEARCH("Feature"),
        SEARCH_USERS("Feature"),
        SHOW_USER(""),
        UPLOAD_MEDIA("Media");
        
        final String rateLimit;

        private KRequestType(String str) {
            this.rateLimit = str;
        }
    }

    public final class TweetEntity implements Serializable {
        private static /* synthetic */ int[] $SWITCH_TABLE$winterwell$jtwitter$Twitter$KEntityType = null;
        static final /* synthetic */ boolean $assertionsDisabled = (!Twitter.class.desiredAssertionStatus() ? true : $assertionsDisabled);
        private static final long serialVersionUID = 1;
        final String display;
        public final int end;
        public final int start;
        private final ITweet tweet;
        public final KEntityType type;

        static /* synthetic */ int[] $SWITCH_TABLE$winterwell$jtwitter$Twitter$KEntityType() {
            int[] iArr = $SWITCH_TABLE$winterwell$jtwitter$Twitter$KEntityType;
            if (iArr == null) {
                iArr = new int[KEntityType.values().length];
                try {
                    iArr[KEntityType.hashtags.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[KEntityType.urls.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[KEntityType.user_mentions.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $SWITCH_TABLE$winterwell$jtwitter$Twitter$KEntityType = iArr;
            }
            return iArr;
        }

        TweetEntity(ITweet iTweet, String str, KEntityType kEntityType, JSONObject jSONObject, ArrayList<TweetEntity> arrayList) {
            this.tweet = iTweet;
            this.type = kEntityType;
            switch ($SWITCH_TABLE$winterwell$jtwitter$Twitter$KEntityType()[kEntityType.ordinal()]) {
                case 2:
                    Object opt = jSONObject.opt("expanded_url");
                    this.display = JSONObject.NULL.equals(opt) ? null : (String) opt;
                    break;
                case 3:
                    this.display = jSONObject.getString("name");
                    break;
                default:
                    this.display = null;
                    break;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            int i = jSONArray.getInt(0);
            int i2 = jSONArray.getInt(1);
            if ($assertionsDisabled || (i >= 0 && i2 >= i)) {
                String text = iTweet.getText();
                if (str.regionMatches(i, text, i, i2 - i)) {
                    this.start = i;
                    this.end = i2;
                    return;
                }
                int min = Math.min(i2, str.length());
                int min2 = Math.min(i, min);
                if (min2 == min) {
                    this.start = min2;
                    this.end = min;
                    return;
                }
                String substring = str.substring(min2, min);
                Iterator it = arrayList.iterator();
                i = 0;
                while (it.hasNext()) {
                    TweetEntity tweetEntity = (TweetEntity) it.next();
                    if (iTweet.getText().regionMatches(tweetEntity.start, substring, 0, substring.length())) {
                        i = tweetEntity.end;
                    }
                }
                i2 = text.indexOf(substring, i);
                if (i2 == -1) {
                    i2 = text.indexOf(InternalUtils.unencode(substring));
                    if (i2 == -1) {
                        i2 = min2;
                    }
                }
                this.start = i2;
                this.end = (this.start + min) - min2;
                return;
            }
            throw new AssertionError(jSONObject);
        }

        TweetEntity(ITweet iTweet, KEntityType kEntityType, int i, int i2, String str) {
            this.tweet = iTweet;
            this.end = i2;
            this.start = i;
            this.type = kEntityType;
            this.display = str;
        }

        static List<TweetEntity> parse(ITweet iTweet, String str, KEntityType kEntityType, JSONObject jSONObject) {
            if ($assertionsDisabled || !(kEntityType == null || iTweet == null || str == null || jSONObject == null)) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray(kEntityType.toString());
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(new TweetEntity(iTweet, str, kEntityType, optJSONArray.getJSONObject(i), arrayList));
                    }
                    return arrayList;
                } catch (Throwable th) {
                    return null;
                }
            }
            throw new AssertionError(iTweet + "\t" + str + "\t" + kEntityType + "\t" + jSONObject);
        }

        public final String displayVersion() {
            return this.display == null ? toString() : this.display;
        }

        public final String toString() {
            String text = this.tweet.getText();
            int min = Math.min(this.end, text.length());
            return text.substring(Math.min(this.start, min), min);
        }
    }

    public Twitter() {
        this(null, new URLConnectionHttpClient());
    }

    @Deprecated
    public Twitter(String str, String str2) {
        this(str, new URLConnectionHttpClient(str, str2));
    }

    public Twitter(String str, IHttpClient iHttpClient) {
        this.includeRTs = true;
        this.maxResults = -1;
        this.sourceApp = "jtwitterlib";
        this.tweetEntities = true;
        this.TWITTER_URL = "http://api.twitter.com/1";
        this.name = str;
        this.http = iHttpClient;
        if (!$assertionsDisabled && iHttpClient == null) {
            throw new AssertionError();
        }
    }

    public Twitter(Twitter twitter) {
        this(twitter.getScreenName(), twitter.http.copy());
    }

    private Map<String, String> addStandardishParameters(Map<String, String> map) {
        if (this.sinceId != null) {
            map.put("since_id", this.sinceId.toString());
        }
        if (this.untilId != null) {
            map.put("max_id", this.untilId.toString());
        }
        if (this.pageNumber != null) {
            map.put("page", this.pageNumber.toString());
            this.pageNumber = null;
        }
        if (this.count != null) {
            map.put("count", this.count.toString());
        }
        if (this.tweetEntities) {
            map.put("include_entities", "1");
        }
        if (this.includeRTs) {
            map.put("include_rts", "1");
        }
        return map;
    }

    public static int countCharacters(String str) {
        int length = str.length();
        Matcher matcher = InternalUtils.URL_REGEX.matcher(str);
        while (matcher.find()) {
            length += LINK_LENGTH - matcher.group().length();
        }
        return length;
    }

    private <T extends ITweet> List<T> dateFilter(List<T> list) {
        if (this.sinceDate == null && this.untilDate == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (T t : list) {
            if (t.getCreatedAt() == null) {
                arrayList.add(t);
            } else if ((this.untilDate == null || !this.untilDate.before(t.getCreatedAt())) && (this.sinceDate == null || !this.sinceDate.after(t.getCreatedAt()))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    private void destroyMessage(Message message) {
        String post = post(this.TWITTER_URL + "/direct_messages/destroy/" + message.id + ".json", null, true);
        if (!$assertionsDisabled && post == null) {
            throw new AssertionError();
        }
    }

    public static Map<String, Double> getAPIStatus() {
        Map hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONObject(new URLConnectionHttpClient().getPage("https://api.io.watchmouse.com/synth/current/39657/folder/7617/?fields=info;cur;24h.uptime", null, $assertionsDisabled)).getJSONArray("result");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                hashMap.put(jSONObject.getJSONObject("info").getString("name"), Double.valueOf(jSONObject.getJSONObject("24h").getDouble("uptime")));
            }
        } catch (JSONException e) {
            throw new Parsing(null, e);
        } catch (Exception e2) {
        }
        return hashMap;
    }

    private List<Message> getMessages(String str, Map<String, String> map) {
        if (this.maxResults <= 0) {
            return dateFilter(Message.getMessages(this.http.getPage(str, map, true)));
        }
        this.pageNumber = Integer.valueOf(1);
        List<Message> arrayList = new ArrayList();
        while (arrayList.size() <= this.maxResults) {
            Object dateFilter = dateFilter(Message.getMessages(this.http.getPage(str, map, true)));
            arrayList.addAll(dateFilter);
            if (dateFilter.size() < 20) {
                return arrayList;
            }
            this.pageNumber = Integer.valueOf(this.pageNumber.intValue() + 1);
            map.put("page", Integer.toString(this.pageNumber.intValue()));
        }
        return arrayList;
    }

    private Map<String, String> getSearchParams(String str, int i) {
        Map<String, String> asMap = InternalUtils.asMap("rpp", Integer.toString(i), "q", str);
        if (this.sinceId != null) {
            asMap.put("since_id", this.sinceId.toString());
        }
        if (this.untilId != null) {
            asMap.put("max_id", this.untilId.toString());
        }
        if (this.untilDate != null) {
            asMap.put("until", InternalUtils.df.format(this.untilDate));
        }
        if (this.lang != null) {
            asMap.put("lang", this.lang);
        }
        if (this.geocode != null) {
            asMap.put("geocode", this.geocode);
        }
        if (this.resultType != null) {
            asMap.put("result_type", this.resultType);
        }
        addStandardishParameters(asMap);
        return asMap;
    }

    private List<Status> getStatuses(String str, Map<String, String> map, boolean z) {
        if (this.maxResults <= 0) {
            List statuses;
            try {
                statuses = Status.getStatuses(this.http.getPage(str, map, z));
            } catch (Parsing e) {
                if (this.http.isRetryOnError()) {
                    InternalUtils.sleep(250);
                    statuses = Status.getStatuses(this.http.getPage(str, map, z));
                } else {
                    throw e;
                }
            }
            return dateFilter(statuses);
        }
        this.maxId = null;
        List<Status> arrayList = new ArrayList();
        while (arrayList.size() <= this.maxResults) {
            List statuses2;
            try {
                statuses2 = Status.getStatuses(this.http.getPage(str, map, z));
            } catch (Parsing e2) {
                if (this.http.isRetryOnError()) {
                    InternalUtils.sleep(250);
                    statuses2 = Status.getStatuses(this.http.getPage(str, map, z));
                } else {
                    throw e2;
                }
            }
            if (statuses2.size() == 0) {
                break;
            }
            this.maxId = ((Status) statuses2.get(statuses2.size() - 1)).id.subtract(BigInteger.ONE);
            arrayList.addAll(dateFilter(statuses2));
            map.put("max_id", this.maxId.toString());
        }
        return arrayList;
    }

    public static User getUser(String str, List<User> list) {
        if ($assertionsDisabled || !(str == null || list == null)) {
            for (User user : list) {
                if (str.equals(user.screenName)) {
                    return user;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    private void isSuspended(String str) {
        show(str);
    }

    public static void main(String[] strArr) {
        if (strArr.length == 3) {
            System.out.println(new Twitter(strArr[0], strArr[1]).setStatus(strArr[2]));
            return;
        }
        System.out.println("Java interface for Twitter");
        System.out.println("--------------------------");
        System.out.println("Version 2.6.5");
        System.out.println("Released under LGPL by Winterwell Associates Ltd.");
        System.out.println("See source code, JavaDoc, or http://winterwell.com for details on how to use.");
    }

    private String post(String str, Map<String, String> map, boolean z) {
        return this.http.post(str, map, z);
    }

    private String search2_bugHack(String str) {
        return str.length() == 0 ? str : (!str.contains(" OR ") || str.contains("-") || this.geocode == null) ? (str.contains(" OR ") && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') ? new StringBuilder(String.valueOf(str)).append(" -kfz").toString() : str : new StringBuilder(String.valueOf(str)).append(" -kfz").toString();
    }

    private Map<String, String> standardishParameters() {
        return addStandardishParameters(new HashMap());
    }

    private Status updateStatus2_safetyCheck(String str, Status status) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("dm ") || toLowerCase.startsWith("d ")) {
            return null;
        }
        if (!WORRIED_ABOUT_TWITTER) {
            return status;
        }
        toLowerCase = str.trim();
        String trim = status.text.trim();
        toLowerCase = InternalUtils.stripUrls(toLowerCase);
        if (InternalUtils.stripUrls(trim).equals(toLowerCase)) {
            return status;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        status = getStatus();
        if (status != null && toLowerCase.equals(InternalUtils.stripUrls(status.text.trim()))) {
            return status;
        }
        throw new Unexplained("Unexplained failure for tweet: expected \"" + str + "\" but got " + status);
    }

    public Twitter_Account account() {
        return new Twitter_Account(this);
    }

    public Twitter_Analytics analytics() {
        return new Twitter_Analytics(this.http);
    }

    @Deprecated
    public User befriend(String str) {
        return follow(str);
    }

    @Deprecated
    public User breakFriendship(String str) {
        return stopFollowing(str);
    }

    public List<User> bulkShow(List<String> list) {
        return users().show((Collection) list);
    }

    public List<User> bulkShowById(List<? extends Number> list) {
        return users().showById(list);
    }

    public void destroy(ITweet iTweet) {
        if (iTweet instanceof Status) {
            destroyStatus(iTweet.getId());
        } else {
            destroyMessage((Message) iTweet);
        }
    }

    public void destroyMessage(Number number) {
        String post = post(this.TWITTER_URL + "/direct_messages/destroy/" + number + ".json", null, true);
        if (!$assertionsDisabled && post == null) {
            throw new AssertionError();
        }
    }

    public void destroyStatus(Number number) {
        String post = post(this.TWITTER_URL + "/statuses/destroy/" + number + ".json", null, true);
        flush();
        if (!$assertionsDisabled && post == null) {
            throw new AssertionError();
        }
    }

    @Deprecated
    public void destroyStatus(Status status) {
        destroyStatus(status.getId());
    }

    boolean enoughResults(List list) {
        return (this.maxResults == -1 || list.size() < this.maxResults) ? $assertionsDisabled : true;
    }

    void flush() {
        this.http.getPage("http://twitter.com/" + this.name, null, true);
    }

    @Deprecated
    public User follow(String str) {
        return users().follow(str);
    }

    @Deprecated
    public User follow(User user) {
        return follow(user.screenName);
    }

    public Twitter_Geo geo() {
        return new Twitter_Geo(this);
    }

    public List<Message> getDirectMessages() {
        return getMessages(this.TWITTER_URL + "/direct_messages.json", standardishParameters());
    }

    public List<Message> getDirectMessagesSent() {
        return getMessages(this.TWITTER_URL + "/direct_messages/sent.json", standardishParameters());
    }

    public List<Status> getFavorites() {
        return getStatuses(this.TWITTER_URL + "/favorites.json", standardishParameters(), true);
    }

    public List<Status> getFavorites(String str) {
        return getStatuses(this.TWITTER_URL + "/favorites.json", addStandardishParameters(InternalUtils.asMap("screen_name", str)), this.http.canAuthenticate());
    }

    @Deprecated
    public List<Number> getFollowerIDs() {
        return users().getFollowerIDs();
    }

    @Deprecated
    public List<Number> getFollowerIDs(String str) {
        return users().getFollowerIDs(str);
    }

    @Deprecated
    public List<User> getFollowers() {
        return users().getFollowers();
    }

    @Deprecated
    public List<User> getFollowers(String str) {
        return users().getFollowers(str);
    }

    @Deprecated
    public List<Number> getFriendIDs() {
        return users().getFriendIDs();
    }

    @Deprecated
    public List<Number> getFriendIDs(String str) {
        return users().getFriendIDs(str);
    }

    @Deprecated
    public List<User> getFriends() {
        return users().getFriends();
    }

    @Deprecated
    public List<User> getFriends(String str) {
        return users().getFriends(str);
    }

    @Deprecated
    public List<Status> getFriendsTimeline() {
        return getHomeTimeline();
    }

    public List<Status> getHomeTimeline() {
        if ($assertionsDisabled || this.http.canAuthenticate()) {
            return getStatuses(this.TWITTER_URL + "/statuses/home_timeline.json", standardishParameters(), true);
        }
        throw new AssertionError();
    }

    public IHttpClient getHttpClient() {
        return this.http;
    }

    public List<TwitterList> getLists() {
        return getLists(this.name);
    }

    public List<TwitterList> getLists(String str) {
        if ($assertionsDisabled || str != null) {
            try {
                JSONArray jSONArray = (JSONArray) new JSONObject(this.http.getPage(this.TWITTER_URL + "/" + str + "/lists.json", null, true)).get("lists");
                List<TwitterList> arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new TwitterList(jSONArray.getJSONObject(i), this));
                }
                return arrayList;
            } catch (JSONException e) {
                throw new Parsing(null, e);
            }
        }
        throw new AssertionError();
    }

    public List<TwitterList> getListsAll(User user) {
        if ($assertionsDisabled || user != null || this.http.canAuthenticate()) {
            try {
                Map asMap;
                String str = this.TWITTER_URL + "/lists/all.json";
                if (user.screenName == null) {
                    asMap = InternalUtils.asMap("user_id", user.id);
                } else {
                    asMap = InternalUtils.asMap("screen_name", user.screenName);
                }
                JSONArray jSONArray = (JSONArray) new JSONObject(this.http.getPage(str, asMap, this.http.canAuthenticate())).get("lists");
                List<TwitterList> arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new TwitterList(jSONArray.getJSONObject(i), this));
                }
                return arrayList;
            } catch (JSONException e) {
                throw new Parsing(null, e);
            }
        }
        throw new AssertionError("No authenticating user");
    }

    public List<TwitterList> getListsContaining(String str, boolean z) {
        if ($assertionsDisabled || str != null) {
            try {
                String str2 = this.TWITTER_URL + "/lists/memberships.json";
                Map asMap = InternalUtils.asMap("screen_name", str);
                if (z) {
                    if ($assertionsDisabled || this.http.canAuthenticate()) {
                        asMap.put("filter_to_owned_lists", "1");
                    } else {
                        throw new AssertionError();
                    }
                }
                JSONArray jSONArray = (JSONArray) new JSONObject(this.http.getPage(str2, asMap, this.http.canAuthenticate())).get("lists");
                List<TwitterList> arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new TwitterList(jSONArray.getJSONObject(i), this));
                }
                return arrayList;
            } catch (JSONException e) {
                throw new Parsing(null, e);
            }
        }
        throw new AssertionError();
    }

    public List<TwitterList> getListsContainingMe() {
        return getListsContaining(this.name, $assertionsDisabled);
    }

    public String getLongStatus(Status status) {
        int indexOf = status.text.indexOf("http://tl.gd/");
        if (indexOf == -1) {
            return status.text;
        }
        Object page = this.http.getPage("http://www.twitlonger.com/api_read/" + status.text.substring(indexOf + 13).trim(), null, $assertionsDisabled);
        Matcher matcher = contentTag.matcher(page);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        throw new TwitLongerException("TwitLonger call failed", page);
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public List<Status> getMentions() {
        return getStatuses(this.TWITTER_URL + "/statuses/mentions.json", standardishParameters(), true);
    }

    public List<Status> getPublicTimeline() {
        return getStatuses(this.TWITTER_URL + "/statuses/public_timeline.json", standardishParameters(), $assertionsDisabled);
    }

    public RateLimit getRateLimit(KRequestType kRequestType) {
        return this.http.getRateLimit(kRequestType);
    }

    public int getRateLimitStatus() {
        String page = this.http.getPage(this.TWITTER_URL + "/account/rate_limit_status.json", null, this.http.canAuthenticate());
        try {
            JSONObject jSONObject = new JSONObject(page);
            int i = jSONObject.getInt("remaining_hits");
            if (this.http instanceof URLConnectionHttpClient) {
                URLConnectionHttpClient uRLConnectionHttpClient = (URLConnectionHttpClient) this.http;
                uRLConnectionHttpClient.rateLimits.put(KRequestType.NORMAL, new RateLimit(jSONObject.getString("hourly_limit"), Integer.toString(i), jSONObject.getString("reset_time")));
            }
            return i;
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    @Deprecated
    public List<ITweet> getRelated(ITweet iTweet) {
        this.TWITTER_URL + "/related_results/show/" + iTweet.getId() + ".json";
        throw new RuntimeException("TODO");
    }

    public List<Status> getReplies() {
        return getMentions();
    }

    public List<User> getRetweeters(Status status) {
        return User.getUsers(this.http.getPage(this.TWITTER_URL + "/statuses/" + status.id + "/retweeted_by.json", addStandardishParameters(new HashMap()), this.http.canAuthenticate()));
    }

    public List<Status> getRetweets(Status status) {
        List<Status> statuses = Status.getStatuses(this.http.getPage(this.TWITTER_URL + "/statuses/retweets/" + status.id + ".json", addStandardishParameters(new HashMap()), true));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\"RT @" + status.getUser().getScreenName() + ": ");
            if ((stringBuilder.length() + status.text.length()) + 1 > MAX_CHARS) {
                stringBuilder.append(status.text.substring(0, status.text.lastIndexOf(32, (140 - stringBuilder.length()) - 1)));
            } else {
                stringBuilder.append(status.text);
            }
            stringBuilder.append('\"');
            statuses.addAll(search(stringBuilder.toString()));
            Collections.sort(statuses, InternalUtils.NEWEST_FIRST);
        } catch (TwitterException e) {
        }
        return statuses;
    }

    public List<Status> getRetweetsByMe() {
        return Status.getStatuses(this.http.getPage(this.TWITTER_URL + "/statuses/retweeted_by_me.json", addStandardishParameters(new HashMap()), true));
    }

    public List<Status> getRetweetsOfMe() {
        return Status.getStatuses(this.http.getPage(this.TWITTER_URL + "/statuses/retweets_of_me.json", addStandardishParameters(new HashMap()), true));
    }

    public String getScreenName() {
        if (this.name != null) {
            return this.name;
        }
        getSelf();
        return this.name;
    }

    public String getScreenNameIfKnown() {
        return this.name;
    }

    public String getSearchLocation() {
        return this.geocode;
    }

    public User getSelf() {
        if (this.self != null) {
            return this.self;
        }
        if (this.http.canAuthenticate()) {
            account().verifyCredentials();
            this.name = this.self.getScreenName();
            return this.self;
        } else if (this.name == null) {
            return null;
        } else {
            this.self = new User(this.name);
            return this.self;
        }
    }

    public Status getStatus() {
        List statuses = Status.getStatuses(this.http.getPage(this.TWITTER_URL + "/statuses/user_timeline.json", InternalUtils.asMap("count", Integer.valueOf(6)), true));
        return statuses.size() == 0 ? null : (Status) statuses.get(0);
    }

    public Status getStatus(Number number) {
        Map map = null;
        if (this.tweetEntities) {
            map = InternalUtils.asMap("include_entities", "1");
        }
        String page = this.http.getPage(this.TWITTER_URL + "/statuses/show/" + number + ".json", map, this.http.canAuthenticate());
        try {
            return new Status(new JSONObject(page), null);
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public Status getStatus(String str) {
        if ($assertionsDisabled || str != null) {
            List statuses = Status.getStatuses(this.http.getPage(this.TWITTER_URL + "/statuses/user_timeline.json", InternalUtils.asMap("id", str, "count", Integer.valueOf(6)), $assertionsDisabled));
            return statuses.size() == 0 ? null : (Status) statuses.get(0);
        } else {
            throw new AssertionError();
        }
    }

    public List<String> getTrends() {
        return getTrends(Integer.valueOf(1));
    }

    public List<String> getTrends(Number number) {
        int i = 0;
        String page = this.http.getPage(this.TWITTER_URL + "/trends/" + number + ".json", null, $assertionsDisabled);
        try {
            JSONArray jSONArray = new JSONArray(page).getJSONObject(0).getJSONArray("trends");
            List<String> arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                arrayList.add(jSONArray.getJSONObject(i).getString("name"));
                i++;
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public Date getUntilDate() {
        return this.untilDate;
    }

    @Deprecated
    public User getUser(long j) {
        return show(Long.valueOf(j));
    }

    @Deprecated
    public User getUser(String str) {
        return show(str);
    }

    public List<Status> getUserTimeline() {
        return getStatuses(this.TWITTER_URL + "/statuses/user_timeline.json", standardishParameters(), true);
    }

    public List<Status> getUserTimeline(Long l) {
        Map asMap = InternalUtils.asMap("user_id", l);
        addStandardishParameters(asMap);
        try {
            return getStatuses(this.TWITTER_URL + "/statuses/user_timeline.json", asMap, this.http.canAuthenticate());
        } catch (E401 e) {
            throw e;
        }
    }

    public List<Status> getUserTimeline(String str) {
        Map asMap = InternalUtils.asMap("screen_name", str);
        addStandardishParameters(asMap);
        try {
            return getStatuses(this.TWITTER_URL + "/statuses/user_timeline.json", asMap, this.http.canAuthenticate());
        } catch (E404 e) {
            throw new E404("Twitter does not return any information for " + str + ". They may have been deleted long ago.");
        } catch (E401 e2) {
            isSuspended(str);
            throw e2;
        }
    }

    public List<Status> getUserTimelineWithRetweets(String str) {
        Map asMap = InternalUtils.asMap("screen_name", str, "include_rts", "1");
        addStandardishParameters(asMap);
        try {
            return getStatuses(this.TWITTER_URL + "/statuses/user_timeline.json", asMap, this.http.canAuthenticate());
        } catch (E401 e) {
            isSuspended(str);
            throw e;
        }
    }

    @Deprecated
    public boolean isFollower(String str) {
        return isFollower(str, this.name);
    }

    @Deprecated
    public boolean isFollower(String str, String str2) {
        return users().isFollower(str, str2);
    }

    @Deprecated
    public boolean isFollowing(String str) {
        return isFollower(this.name, str);
    }

    @Deprecated
    public boolean isFollowing(User user) {
        return isFollowing(user.screenName);
    }

    public boolean isRateLimited(KRequestType kRequestType, int i) {
        if (kRequestType != KRequestType.NORMAL && isRateLimited(KRequestType.NORMAL, i)) {
            return true;
        }
        RateLimit rateLimit = getRateLimit(kRequestType);
        return rateLimit == null ? kRequestType == KRequestType.NORMAL ? getRateLimitStatus() < i ? $assertionsDisabled : true : $assertionsDisabled : rateLimit.getRemaining() >= i ? $assertionsDisabled : rateLimit.getReset().getTime() < System.currentTimeMillis() ? $assertionsDisabled : true;
    }

    public boolean isTwitlongerSetup() {
        return (this.twitlongerApiKey == null || this.twitlongerAppName == null) ? $assertionsDisabled : true;
    }

    public boolean isValidLogin() {
        if (!this.http.canAuthenticate()) {
            return $assertionsDisabled;
        }
        try {
            new Twitter_Account(this).verifyCredentials();
            return true;
        } catch (E403 e) {
            return $assertionsDisabled;
        } catch (E401 e2) {
            return $assertionsDisabled;
        } catch (TwitterException e3) {
            throw e3;
        }
    }

    public void reportSpam(String str) {
        this.http.getPage(this.TWITTER_URL + "/version/report_spam.json", InternalUtils.asMap("screen_name", str), true);
    }

    public Status retweet(Status status) {
        try {
            return new Status(new JSONObject(post(this.TWITTER_URL + "/statuses/retweet/" + status.getId() + ".json", null, true)), null);
        } catch (E403 e) {
            E403 e403 = e;
            for (Status status2 : getRetweetsByMe()) {
                if (status.equals(status2.getOriginal())) {
                    throw new Repetition(status2.getText());
                }
            }
            throw e403;
        } catch (JSONException e2) {
            throw new Parsing(null, e2);
        }
    }

    public List<Status> search(String str) {
        return search(str, null, 100);
    }

    public List<Status> search(String str, ICallback iCallback, int i) {
        if (i <= 100 || this.maxResults >= i) {
            String search2_bugHack = search2_bugHack(str);
            Map searchParams = (this.maxResults >= 100 || this.maxResults <= 0) ? getSearchParams(search2_bugHack, i) : getSearchParams(search2_bugHack, this.maxResults);
            List<Status> arrayList = new ArrayList(Math.max(this.maxResults, i));
            String str2 = "http://search.twitter.com/search.json";
            int i2 = 1;
            do {
                List statusesFromSearch;
                this.pageNumber = Integer.valueOf(i2);
                searchParams.put("page", Integer.toString(this.pageNumber.intValue()));
                try {
                    statusesFromSearch = Status.getStatusesFromSearch(this, this.http.getPage(str2, searchParams, $assertionsDisabled));
                } catch (Parsing e) {
                    if (this.http.isRetryOnError()) {
                        InternalUtils.sleep(250);
                        statusesFromSearch = Status.getStatusesFromSearch(this, this.http.getPage(str2, searchParams, $assertionsDisabled));
                    } else {
                        throw e;
                    }
                }
                int size = statusesFromSearch.size();
                Object dateFilter = dateFilter(statusesFromSearch);
                arrayList.addAll(dateFilter);
                if ((iCallback == null || !iCallback.process(dateFilter)) && size >= i) {
                    i2++;
                }
            } while (arrayList.size() < this.maxResults);
            this.pageNumber = null;
            return arrayList;
        }
        throw new IllegalArgumentException("You need to switch on paging to fetch more than 100 search results. First call setMaxResults() to raise the limit above " + i);
    }

    @Deprecated
    public List<User> searchUsers(String str) {
        return users().searchUsers(str);
    }

    public Message sendMessage(String str, String str2) {
        if (!$assertionsDisabled && (str == null || str2 == null)) {
            throw new AssertionError(new StringBuilder(String.valueOf(str)).append(" ").append(str2).toString());
        } else if (!$assertionsDisabled && str2.startsWith("d " + str)) {
            throw new AssertionError(new StringBuilder(String.valueOf(str)).append(" ").append(str2).toString());
        } else if (str2.length() > MAX_CHARS) {
            throw new IllegalArgumentException("Message is too long.");
        } else {
            Map asMap = InternalUtils.asMap("user", str, HttpRequestParams.TEXT, str2);
            if (this.tweetEntities) {
                asMap.put("include_entities", "1");
            }
            String str3 = null;
            try {
                str3 = post(this.TWITTER_URL + "/direct_messages/new.json", asMap, true);
                return new Message(new JSONObject(str3));
            } catch (JSONException e) {
                throw new Parsing(str3, e);
            } catch (E404 e2) {
                throw new E404(e2.getMessage() + " with recipient=" + str + ", text=" + str2);
            }
        }
    }

    public void setAPIRootUrl(String str) {
        if (!$assertionsDisabled && !str.startsWith("http://") && !str.startsWith("https://")) {
            throw new AssertionError();
        } else if ($assertionsDisabled || !str.endsWith("/")) {
            this.TWITTER_URL = str;
        } else {
            throw new AssertionError("Please remove the trailing / from " + str);
        }
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setFavorite(Status status, boolean z) {
        String str;
        if (z) {
            try {
                str = this.TWITTER_URL + "/favorites/create/" + status.id + ".json";
            } catch (E403 e) {
                if (e.getMessage() == null || !e.getMessage().contains("already favorited")) {
                    throw e;
                }
                throw new Repetition("You have already favorited this status.");
            }
        }
        str = this.TWITTER_URL + "/favorites/destroy/" + status.id + ".json";
        this.http.post(str, null, true);
    }

    public void setIncludeRTs(boolean z) {
        this.includeRTs = z;
    }

    public void setIncludeTweetEntities(boolean z) {
        this.tweetEntities = z;
    }

    public void setLanguage(String str) {
        this.lang = str;
    }

    public void setMaxResults(int i) {
        if ($assertionsDisabled || i != 0) {
            this.maxResults = i;
            return;
        }
        throw new AssertionError();
    }

    public void setMyLocation(double[] dArr) {
        this.myLatLong = dArr;
        if (this.myLatLong != null) {
            if (Math.abs(this.myLatLong[0]) > 90.0d) {
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(this.myLatLong[0])).append(" is not within +/- 90").toString());
            } else if (Math.abs(this.myLatLong[1]) > 180.0d) {
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(this.myLatLong[1])).append(" is not within +/- 180").toString());
            }
        }
    }

    public void setPageNumber(Integer num) {
        this.pageNumber = num;
    }

    public void setSearchLocation(double d, double d2, String str) {
        if ($assertionsDisabled || str.endsWith("mi") || str.endsWith("km")) {
            this.geocode = new StringBuilder(String.valueOf(d)).append(",").append(d2).append(",").append(str).toString();
            return;
        }
        throw new AssertionError(str);
    }

    public void setSearchResultType(String str) {
        this.resultType = str;
    }

    @Deprecated
    public void setSinceDate(Date date) {
        this.sinceDate = date;
    }

    public void setSinceId(Number number) {
        this.sinceId = number;
    }

    public void setSource(String str) {
        this.sourceApp = str;
    }

    public Status setStatus(String str) {
        return updateStatus(str);
    }

    @Deprecated
    public void setUntilDate(Date date) {
        this.untilDate = date;
    }

    public void setUntilId(Number number) {
        this.untilId = number;
    }

    public void setupTwitlonger(String str, String str2) {
        this.twitlongerAppName = str;
        this.twitlongerApiKey = str2;
    }

    @Deprecated
    public User show(Number number) {
        return users().show(number);
    }

    @Deprecated
    public User show(String str) {
        return users().show(str);
    }

    public List<String> splitMessage(String str) {
        if (str.length() <= MAX_CHARS) {
            return Collections.singletonList(str);
        }
        List<String> arrayList = new ArrayList(4);
        StringBuilder stringBuilder = new StringBuilder(MAX_CHARS);
        StringBuilder stringBuilder2 = stringBuilder;
        for (String str2 : str.split("\\s+")) {
            if ((stringBuilder2.length() + str2.length()) + 1 > MAX_CHARS) {
                stringBuilder2.append("...");
                arrayList.add(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder(MAX_CHARS);
                stringBuilder2.append(str2);
            } else {
                if (stringBuilder2.length() != 0) {
                    stringBuilder2.append(" ");
                }
                stringBuilder2.append(str2);
            }
        }
        if (stringBuilder2.length() != 0) {
            arrayList.add(stringBuilder2.toString());
        }
        return arrayList;
    }

    @Deprecated
    public User stopFollowing(String str) {
        return users().stopFollowing(str);
    }

    @Deprecated
    public User stopFollowing(User user) {
        return stopFollowing(user.screenName);
    }

    public String toString() {
        return this.name == null ? "Twitter" : "Twitter[" + this.name + "]";
    }

    public void updateConfiguration() {
        String page = this.http.getPage(this.TWITTER_URL + "/help/configuration.json", null, $assertionsDisabled);
        try {
            JSONObject jSONObject = new JSONObject(page);
            LINK_LENGTH = jSONObject.getInt("short_url_length");
            PHOTO_SIZE_LIMIT = jSONObject.getLong("photo_size_limit");
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public Status updateLongStatus(String str, Number number) {
        if (this.twitlongerApiKey == null || this.twitlongerAppName == null) {
            throw new IllegalStateException("Twitlonger api details have not been set! Call #setupTwitlonger() first.");
        } else if (str.length() < 141) {
            throw new IllegalArgumentException("Message too short (" + number + " chars). Just post a normal Twitter status. ");
        } else {
            String str2 = "http://www.twitlonger.com/api_post";
            Map asMap = InternalUtils.asMap("application", this.twitlongerAppName, "api_key", this.twitlongerApiKey, "username", this.name, "message", str);
            if (!(number == null || number.doubleValue() == 0.0d)) {
                asMap.put("in_reply", number.toString());
            }
            CharSequence post = this.http.post(str2, asMap, $assertionsDisabled);
            Matcher matcher = contentTag.matcher(post);
            if (matcher.find()) {
                Status updateStatus = updateStatus(matcher.group(1).trim(), number);
                Matcher matcher2 = idTag.matcher(post);
                if (matcher2.find()) {
                    String group = matcher2.group(1);
                    try {
                        asMap.remove("message");
                        asMap.remove("in_reply");
                        asMap.remove("username");
                        asMap.put("message_id", group);
                        asMap.put("twitter_id", updateStatus.getId());
                        this.http.post("http://www.twitlonger.com/api_set_id", asMap, $assertionsDisabled);
                    } catch (Exception e) {
                    }
                }
                return updateStatus;
            }
            throw new TwitLongerException("TwitLonger call failed", post);
        }
    }

    public Status updateStatus(String str) {
        return updateStatus(str, null);
    }

    public Status updateStatus(String str, Number number) {
        if (str.length() <= MAX_CHARS || countCharacters(str) <= MAX_CHARS) {
            Map asMap = InternalUtils.asMap("status", str);
            if (this.tweetEntities) {
                asMap.put("include_entities", "1");
            }
            if (this.myLatLong != null) {
                asMap.put("lat", Double.toString(this.myLatLong[0]));
                asMap.put("long", Double.toString(this.myLatLong[1]));
            }
            if (this.sourceApp != null) {
                asMap.put("source", this.sourceApp);
            }
            if (number != null) {
                double doubleValue = number.doubleValue();
                if ($assertionsDisabled || !(doubleValue == 0.0d || doubleValue == -1.0d)) {
                    asMap.put("in_reply_to_status_id", number.toString());
                } else {
                    throw new AssertionError();
                }
            }
            String post = this.http.post(this.TWITTER_URL + "/statuses/update.json", asMap, true);
            try {
                return updateStatus2_safetyCheck(str, new Status(new JSONObject(post), null));
            } catch (JSONException e) {
                throw new Parsing(post, e);
            }
        } else if (str.startsWith("RT")) {
            throw new IllegalArgumentException("Status text must be 140 characters or less -- use Twitter.retweet() to do new-style retweets which can be a bit longer: " + str.length() + " " + str);
        } else {
            throw new IllegalArgumentException("Status text must be 140 characters or less: " + str.length() + " " + str);
        }
    }

    Status updateStatusWithMedia(String str, Number number, File file) {
        String str2 = null;
        if (str.length() > MAX_CHARS && countCharacters(str) > MAX_CHARS) {
            throw new IllegalArgumentException("Status text must be 140 characters or less: " + str.length() + " " + str);
        } else if (file == null || file.isFile()) {
            Map asMap = InternalUtils.asMap("status", str);
            if (this.tweetEntities) {
                asMap.put("include_entities", "1");
            }
            if (this.myLatLong != null) {
                asMap.put("lat", Double.toString(this.myLatLong[0]));
                asMap.put("long", Double.toString(this.myLatLong[1]));
            }
            if (this.sourceApp != null) {
                asMap.put("source", this.sourceApp);
            }
            if (number != null) {
                double doubleValue = number.doubleValue();
                if ($assertionsDisabled || !(doubleValue == 0.0d || doubleValue == -1.0d)) {
                    asMap.put("in_reply_to_status_id", number.toString());
                } else {
                    throw new AssertionError();
                }
            }
            try {
                str2 = this.http.post("http://upload.twitter.com/1/statuses/update_with_media.json", asMap, true);
                return new Status(new JSONObject(str2), null);
            } catch (E403 e) {
                Status status = getStatus();
                if (status == null || !status.getText().equals(str)) {
                    throw e;
                }
                throw new Repetition(status.getText());
            } catch (JSONException e2) {
                throw new Parsing(str2, e2);
            }
        } else {
            throw new IllegalArgumentException("Not a valid file: " + file);
        }
    }

    public Twitter_Users users() {
        return new Twitter_Users(this);
    }
}
