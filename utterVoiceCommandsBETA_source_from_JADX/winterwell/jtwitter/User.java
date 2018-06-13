package winterwell.jtwitter;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.TwitterException.Parsing;

public final class User implements Serializable {
    private static final long serialVersionUID = 1;
    public final Date createdAt;
    public final String description;
    public final int favoritesCount;
    public final boolean followRequestSent;
    private final Boolean followedByYou;
    public int followersCount;
    private final Boolean followingYou;
    public final int friendsCount;
    public final Long id;
    String lang;
    public final int listedCount;
    public final String location;
    public final String name;
    public final boolean notifications;
    private Place place;
    public final String profileBackgroundColor;
    public final URI profileBackgroundImageUrl;
    public final boolean profileBackgroundTile;
    public URI profileImageUrl;
    public final String profileLinkColor;
    public final String profileSidebarBorderColor;
    public final String profileSidebarFillColor;
    public final String profileTextColor;
    public final boolean protectedUser;
    public final String screenName;
    public final Status status;
    public final int statusesCount;
    public final String timezone;
    public final double timezoneOffSet;
    public final boolean verified;
    public final URI website;

    public User(String str) {
        this(str, null);
    }

    private User(String str, Long l) {
        this.id = l;
        this.name = null;
        if (!(str == null || Twitter.CASE_SENSITIVE_SCREENNAMES)) {
            str = str.toLowerCase();
        }
        this.screenName = str;
        this.status = null;
        this.location = null;
        this.description = null;
        this.profileImageUrl = null;
        this.website = null;
        this.protectedUser = false;
        this.followersCount = 0;
        this.profileBackgroundColor = null;
        this.profileLinkColor = null;
        this.profileTextColor = null;
        this.profileSidebarFillColor = null;
        this.profileSidebarBorderColor = null;
        this.friendsCount = 0;
        this.createdAt = null;
        this.favoritesCount = 0;
        this.timezoneOffSet = -1.0d;
        this.timezone = null;
        this.profileBackgroundImageUrl = null;
        this.profileBackgroundTile = false;
        this.statusesCount = 0;
        this.notifications = false;
        this.verified = false;
        this.followedByYou = null;
        this.followingYou = null;
        this.followRequestSent = false;
        this.listedCount = -1;
    }

    User(JSONObject jSONObject, Status status) {
        try {
            this.id = Long.valueOf(jSONObject.getLong("id"));
            this.name = InternalUtils.unencode(InternalUtils.jsonGet("name", jSONObject));
            String jsonGet = InternalUtils.jsonGet("screen_name", jSONObject);
            if (!Twitter.CASE_SENSITIVE_SCREENNAMES) {
                jsonGet = jsonGet.toLowerCase();
            }
            this.screenName = jsonGet;
            Object jsonGetLocn = Status.jsonGetLocn(jSONObject);
            this.location = jsonGetLocn == null ? null : jsonGetLocn.toString();
            if (jsonGetLocn instanceof Place) {
                this.place = (Place) jsonGetLocn;
            }
            this.lang = InternalUtils.jsonGet("lang", jSONObject);
            this.description = InternalUtils.unencode(InternalUtils.jsonGet("description", jSONObject));
            jsonGet = InternalUtils.jsonGet("profile_image_url", jSONObject);
            this.profileImageUrl = jsonGet == null ? null : InternalUtils.URI(jsonGet);
            jsonGet = InternalUtils.jsonGet("url", jSONObject);
            this.website = jsonGet == null ? null : InternalUtils.URI(jsonGet);
            this.protectedUser = jSONObject.optBoolean("protected");
            this.followersCount = jSONObject.optInt("followers_count");
            this.profileBackgroundColor = InternalUtils.jsonGet("profile_background_color", jSONObject);
            this.profileLinkColor = InternalUtils.jsonGet("profile_link_color", jSONObject);
            this.profileTextColor = InternalUtils.jsonGet("profile_text_color", jSONObject);
            this.profileSidebarFillColor = InternalUtils.jsonGet("profile_sidebar_fill_color", jSONObject);
            this.profileSidebarBorderColor = InternalUtils.jsonGet("profile_sidebar_border_color", jSONObject);
            this.friendsCount = jSONObject.optInt("friends_count");
            jsonGet = InternalUtils.jsonGet("created_at", jSONObject);
            this.createdAt = jsonGet == null ? null : InternalUtils.parseDate(jsonGet);
            this.favoritesCount = jSONObject.optInt("favourites_count");
            jsonGet = InternalUtils.jsonGet("utc_offset", jSONObject);
            this.timezoneOffSet = jsonGet == null ? 0.0d : Double.parseDouble(jsonGet);
            this.timezone = InternalUtils.jsonGet("time_zone", jSONObject);
            jsonGet = InternalUtils.jsonGet("profile_background_image_url", jSONObject);
            this.profileBackgroundImageUrl = jsonGet == null ? null : InternalUtils.URI(jsonGet);
            this.profileBackgroundTile = jSONObject.optBoolean("profile_background_tile");
            this.statusesCount = jSONObject.optInt("statuses_count");
            this.notifications = jSONObject.optBoolean("notifications");
            this.verified = jSONObject.optBoolean("verified");
            jsonGetLocn = jSONObject.opt("connections");
            if (jsonGetLocn instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) jsonGetLocn;
                int length = jSONArray.length();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if ("following".equals(string)) {
                        z3 = true;
                    } else if ("followed_by".equals(string)) {
                        z2 = true;
                    } else if ("following_requested".equals(string)) {
                        z = true;
                    }
                }
                this.followedByYou = Boolean.valueOf(z3);
                this.followingYou = Boolean.valueOf(z2);
                this.followRequestSent = z;
            } else {
                this.followedByYou = InternalUtils.getOptBoolean(jSONObject, "following");
                this.followingYou = InternalUtils.getOptBoolean(jSONObject, "followed_by");
                this.followRequestSent = jSONObject.optBoolean("follow_request_sent");
            }
            this.listedCount = jSONObject.optInt("listed_count", -1);
            if (status == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("status");
                this.status = optJSONObject == null ? null : new Status(optJSONObject, this);
                return;
            }
            this.status = status;
        } catch (JSONException e) {
            throw new Parsing(String.valueOf(jSONObject), e);
        } catch (NullPointerException e2) {
            throw new TwitterException(e2 + " from <" + jSONObject + ">, <" + status + ">\n\t" + e2.getStackTrace()[0] + "\n\t" + e2.getStackTrace()[1]);
        }
    }

    static List<User> getUsers(String str) {
        if (str.trim().equals("")) {
            return Collections.emptyList();
        }
        try {
            return getUsers2(new JSONArray(str));
        } catch (JSONException e) {
            throw new Parsing(str, e);
        }
    }

    static List<User> getUsers2(JSONArray jSONArray) {
        List<User> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new User(jSONArray.getJSONObject(i), null));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != User.class) {
            return false;
        }
        User user = (User) obj;
        return (this.screenName == null || user.screenName == null) ? (this.id == null || user.id == null) ? false : this.id == user.id : this.screenName.equals(user.screenName);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getFavoritesCount() {
        return this.favoritesCount;
    }

    public final int getFollowersCount() {
        return this.followersCount;
    }

    public final int getFriendsCount() {
        return this.friendsCount;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getName() {
        return this.name;
    }

    public final Place getPlace() {
        return this.place;
    }

    public final String getProfileBackgroundColor() {
        return this.profileBackgroundColor;
    }

    public final URI getProfileBackgroundImageUrl() {
        return this.profileBackgroundImageUrl;
    }

    public final URI getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final String getProfileLinkColor() {
        return this.profileLinkColor;
    }

    public final String getProfileSidebarBorderColor() {
        return this.profileSidebarBorderColor;
    }

    public final String getProfileSidebarFillColor() {
        return this.profileSidebarFillColor;
    }

    public final String getProfileTextColor() {
        return this.profileTextColor;
    }

    public final boolean getProtectedUser() {
        return this.protectedUser;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final int getStatusesCount() {
        return this.statusesCount;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final double getTimezoneOffSet() {
        return this.timezoneOffSet;
    }

    public final URI getWebsite() {
        return this.website;
    }

    public final int hashCode() {
        return this.screenName.hashCode();
    }

    public final boolean isDummyObject() {
        return this.name == null;
    }

    public final Boolean isFollowedByYou() {
        return this.followedByYou;
    }

    public final Boolean isFollowingYou() {
        return this.followingYou;
    }

    public final boolean isNotifications() {
        return this.notifications;
    }

    public final boolean isProfileBackgroundTile() {
        return this.profileBackgroundTile;
    }

    public final boolean isProtectedUser() {
        return this.protectedUser;
    }

    public final boolean isVerified() {
        return this.verified;
    }

    public final String toString() {
        return this.screenName;
    }
}
