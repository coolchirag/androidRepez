package winterwell.jtwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.TwitterException.E403;
import winterwell.jtwitter.TwitterException.E404;
import winterwell.jtwitter.TwitterException.Parsing;
import winterwell.jtwitter.TwitterException.RateLimit;
import winterwell.jtwitter.TwitterException.SuspendedUser;

public class Twitter_Users {
    static final /* synthetic */ boolean $assertionsDisabled = (!Twitter_Users.class.desiredAssertionStatus());
    private final IHttpClient http;
    private final Twitter jtwit;

    Twitter_Users(Twitter twitter) {
        this.jtwit = twitter;
        this.http = twitter.getHttpClient();
    }

    private List<Number> getUserIDs(String str, String str2) {
        Long valueOf = Long.valueOf(-1);
        List<Number> arrayList = new ArrayList();
        Map asMap = InternalUtils.asMap("screen_name", str2);
        while (valueOf.longValue() != 0 && !this.jtwit.enoughResults(arrayList)) {
            asMap.put("cursor", String.valueOf(valueOf));
            String page = this.http.getPage(str, asMap, this.http.canAuthenticate());
            try {
                JSONArray jSONArray;
                JSONArray jSONArray2;
                if (page.charAt(0) == '[') {
                    jSONArray2 = new JSONArray(page);
                    valueOf = Long.valueOf(0);
                    jSONArray = jSONArray2;
                } else {
                    JSONObject jSONObject = new JSONObject(page);
                    jSONArray2 = (JSONArray) jSONObject.get("ids");
                    valueOf = new Long(jSONObject.getString("next_cursor"));
                    jSONArray = jSONArray2;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException e) {
                throw new Parsing(page, e);
            }
        }
        return arrayList;
    }

    private List<User> getUsers(String str, String str2) {
        Map asMap = InternalUtils.asMap("screen_name", str2);
        List<User> arrayList = new ArrayList();
        Long valueOf = Long.valueOf(-1);
        while (valueOf.longValue() != 0 && !this.jtwit.enoughResults(arrayList)) {
            asMap.put("cursor", valueOf.toString());
            try {
                JSONObject jSONObject = new JSONObject(this.http.getPage(str, asMap, this.http.canAuthenticate()));
                arrayList.addAll(User.getUsers(jSONObject.getString("users")));
                valueOf = new Long(jSONObject.getString("next_cursor"));
            } catch (JSONException e) {
                throw new Parsing(null, e);
            }
        }
        return arrayList;
    }

    public User block(String str) {
        Map hashMap = new HashMap();
        hashMap.put("screen_name", str);
        return InternalUtils.user(this.http.post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/blocks/create.json").toString(), hashMap, true));
    }

    List<User> bulkShow2(String str, Class cls, Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        if (collection instanceof List) {
            List list = (List) collection;
        } else {
            Object arrayList2 = new ArrayList(collection);
        }
        for (int i = 0; i < list.size(); i += 100) {
            String join = InternalUtils.join(list, i, i + 100);
            String str2 = cls == String.class ? "screen_name" : "user_id";
            try {
                arrayList.addAll(User.getUsers(this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append(str).toString(), InternalUtils.asMap(str2, join), this.http.canAuthenticate())));
            } catch (E404 e) {
            } catch (TwitterException e2) {
                if (arrayList.size() == 0) {
                    throw e2;
                }
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public winterwell.jtwitter.User follow(java.lang.String r6) {
        /*
        r5 = this;
        r1 = 0;
        if (r6 != 0) goto L_0x0009;
    L_0x0003:
        r0 = new java.lang.NullPointerException;
        r0.<init>();
        throw r0;
    L_0x0009:
        r0 = r5.jtwit;
        r0 = r0.getScreenName();
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "follow yourself makes no sense";
        r0.<init>(r1);
        throw r0;
    L_0x001d:
        r0 = 2;
        r0 = new java.lang.Object[r0];	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r2 = 0;
        r3 = "screen_name";
        r0[r2] = r3;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r2 = 1;
        r0[r2] = r6;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r0 = winterwell.jtwitter.InternalUtils.asMap(r0);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r2 = r5.http;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r4 = r5.jtwit;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r4 = r4.TWITTER_URL;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r3.<init>(r4);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r4 = "/friendships/create.json";
        r3 = r3.append(r4);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r3 = r3.toString();	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r4 = 1;
        r2 = r2.post(r3, r0, r4);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x0066 }
        r0 = new winterwell.jtwitter.User;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x006d }
        r3 = new winterwell.json.JSONObject;	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x006d }
        r3.<init>(r2);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x006d }
        r4 = 0;
        r0.<init>(r3, r4);	 Catch:{ SuspendedUser -> 0x0056, Repetition -> 0x0058, E403 -> 0x005b, JSONException -> 0x006d }
    L_0x0055:
        return r0;
    L_0x0056:
        r0 = move-exception;
        throw r0;
    L_0x0058:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0055;
    L_0x005b:
        r0 = move-exception;
        r2 = r5.isFollowing(r6);	 Catch:{ TwitterException -> 0x0064 }
        if (r2 == 0) goto L_0x0065;
    L_0x0062:
        r0 = r1;
        goto L_0x0055;
    L_0x0064:
        r1 = move-exception;
    L_0x0065:
        throw r0;
    L_0x0066:
        r0 = move-exception;
    L_0x0067:
        r2 = new winterwell.jtwitter.TwitterException$Parsing;
        r2.<init>(r1, r0);
        throw r2;
    L_0x006d:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: winterwell.jtwitter.Twitter_Users.follow(java.lang.String):winterwell.jtwitter.User");
    }

    public User follow(User user) {
        return follow(user.screenName);
    }

    public List<Number> getBlockedIds() {
        String page = this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/blocks/blocking/ids.json").toString(), null, true);
        try {
            JSONArray jSONArray = new JSONArray(page);
            List<Number> arrayList = new ArrayList(jSONArray.length());
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public List<User> getFeatured() {
        List<User> arrayList = new ArrayList();
        for (Status user : this.jtwit.getPublicTimeline()) {
            arrayList.add(user.getUser());
        }
        return arrayList;
    }

    public List<Number> getFollowerIDs() {
        return getUserIDs(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/followers/ids.json").toString(), null);
    }

    public List<Number> getFollowerIDs(String str) {
        return getUserIDs(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/followers/ids.json").toString(), str);
    }

    @Deprecated
    public List<User> getFollowers() {
        return getUsers(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/statuses/followers.json").toString(), null);
    }

    public List<User> getFollowers(String str) {
        return getUsers(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/statuses/followers.json").toString(), str);
    }

    public List<Number> getFriendIDs() {
        return getUserIDs(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/friends/ids.json").toString(), null);
    }

    public List<Number> getFriendIDs(String str) {
        return getUserIDs(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/friends/ids.json").toString(), str);
    }

    @Deprecated
    public List<User> getFriends() {
        return getUsers(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/statuses/friends.json").toString(), null);
    }

    public List<User> getFriends(String str) {
        return getUsers(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/statuses/friends.json").toString(), str);
    }

    public List<User> getRelationshipInfo(List<String> list) {
        return list.size() == 0 ? Collections.EMPTY_LIST : bulkShow2("/friendships/lookup.json", String.class, list);
    }

    public List<User> getRelationshipInfoById(List<? extends Number> list) {
        return list.size() == 0 ? Collections.EMPTY_LIST : bulkShow2("/friendships/lookup.json", Number.class, list);
    }

    public User getUser(long j) {
        return show(Long.valueOf(j));
    }

    public User getUser(String str) {
        return show(str);
    }

    public boolean isBlocked(Long l) {
        try {
            Map hashMap = new HashMap();
            hashMap.put("user_id", Long.toString(l.longValue()));
            this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/blocks/exists.json").toString(), hashMap, true);
            return true;
        } catch (E404 e) {
            return false;
        }
    }

    public boolean isBlocked(String str) {
        try {
            Map hashMap = new HashMap();
            hashMap.put("screen_name", str);
            this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/blocks/exists.json").toString(), hashMap, true);
            return true;
        } catch (E404 e) {
            return false;
        }
    }

    public boolean isFollower(String str) {
        return isFollower(str, this.jtwit.getScreenName());
    }

    public boolean isFollower(String str, String str2) {
        E403 e403;
        if ($assertionsDisabled || !(str == null || str2 == null)) {
            try {
                return Boolean.valueOf(this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/friendships/exists.json").toString(), InternalUtils.asMap("user_a", str, "user_b", str2), this.http.canAuthenticate())).booleanValue();
            } catch (E403 e) {
                e403 = e;
                if (e403 instanceof SuspendedUser) {
                    throw e403;
                }
                String str3 = str2.equals(this.jtwit.getScreenName()) ? str : str2;
                show(str3);
                if (!str3.equals(str2)) {
                    str = str2;
                }
                if (str.equals(this.jtwit.getScreenName())) {
                    throw e403;
                }
                show(str);
            } catch (TwitterException e2) {
                if (e2.getMessage() == null || !e2.getMessage().contains("Two user ids or screen_names must be supplied")) {
                    throw e2;
                }
                throw new TwitterException("WTF? inputs: follower=" + str + ", followed=" + str2 + ", call-by=" + this.jtwit.getScreenName() + "; " + e2.getMessage());
            } catch (RateLimit e3) {
            }
        } else {
            throw new AssertionError();
        }
        throw e403;
    }

    public boolean isFollowing(String str) {
        return isFollower(this.jtwit.getScreenName(), str);
    }

    public boolean isFollowing(User user) {
        return isFollowing(user.screenName);
    }

    public User leaveNotifications(String str) {
        String page = this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/notifications/leave.json").toString(), InternalUtils.asMap("screen_name", str), true);
        try {
            return new User(new JSONObject(page), null);
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public User notify(String str) {
        String page = this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/notifications/follow.json").toString(), InternalUtils.asMap("screen_name", str), true);
        try {
            return new User(new JSONObject(page), null);
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public User reportSpammer(String str) {
        Map hashMap = new HashMap();
        hashMap.put("screen_name", str);
        return InternalUtils.user(this.http.post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/report_spam.json").toString(), hashMap, true));
    }

    public List<User> searchUsers(String str) {
        if ($assertionsDisabled || str != null) {
            Map asMap = InternalUtils.asMap("q", str);
            if (this.jtwit.pageNumber != null) {
                asMap.put("page", this.jtwit.pageNumber.toString());
            }
            if (this.jtwit.count != null && this.jtwit.count.intValue() < 20) {
                asMap.put("per_page", String.valueOf(this.jtwit.count));
            }
            return User.getUsers(this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/users/search.json").toString(), asMap, true));
        }
        throw new AssertionError();
    }

    public List<User> show(Collection<String> collection) {
        return collection.size() == 0 ? Collections.EMPTY_LIST : bulkShow2("/users/lookup.json", String.class, collection);
    }

    public User show(Number number) {
        String page = this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/users/show.json").toString(), InternalUtils.asMap("user_id", number.toString()), this.http.canAuthenticate());
        try {
            return new User(new JSONObject(page), null);
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public User show(String str) {
        try {
            String page = this.http.getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/users/show.json").toString(), InternalUtils.asMap("screen_name", str), this.http.canAuthenticate());
            if (page.length() == 0) {
                throw new E404(new StringBuilder(String.valueOf(str)).append(" does not seem to exist").toString());
            }
            try {
                return new User(new JSONObject(page), null);
            } catch (JSONException e) {
                throw new Parsing(page, e);
            }
        } catch (Exception e2) {
            throw new E404("User " + str + " does not seem to exist, their user account may have been removed from the service");
        }
    }

    public List<User> showById(Collection<? extends Number> collection) {
        return collection.size() == 0 ? Collections.EMPTY_LIST : bulkShow2("/users/lookup.json", Number.class, collection);
    }

    public User stopFollowing(String str) {
        try {
            String post = this.jtwit.http.post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/friendships/destroy.json").toString(), InternalUtils.asMap("screen_name", str), true);
            try {
                return new User(new JSONObject(post), null);
            } catch (JSONException e) {
                throw new Parsing(post, e);
            }
        } catch (TwitterException e2) {
            if (e2.getMessage() != null && e2.getMessage().contains("not friends")) {
                return null;
            }
            throw e2;
        }
    }

    public User stopFollowing(User user) {
        return stopFollowing(user.screenName);
    }

    public User unblock(String str) {
        Map hashMap = new HashMap();
        hashMap.put("screen_name", str);
        return InternalUtils.user(this.http.post(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/blocks/destroy.json").toString(), hashMap, true));
    }

    public boolean userExists(String str) {
        try {
            show(str);
            return true;
        } catch (SuspendedUser e) {
            return false;
        } catch (E404 e2) {
            return false;
        }
    }
}
