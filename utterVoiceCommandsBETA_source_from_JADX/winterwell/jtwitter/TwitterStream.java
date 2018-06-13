package winterwell.jtwitter;

import android.util.Log;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import winterwell.jtwitter.AStream.Outage;
import winterwell.jtwitter.TwitterEvent.Type;
import winterwell.jtwitter.TwitterException.TooManyLogins;

public class TwitterStream extends AStream {
    public static int MAX_KEYWORDS = 400;
    public static final int MAX_KEYWORD_LENGTH = 60;
    public static final int MAX_USERS = 5000;
    static Map<String, AStream> user2stream = new ConcurrentHashMap();
    private List<Long> follow;
    private List<double[]> locns;
    KMethod method = KMethod.sample;
    private List<String> track;

    public enum KMethod {
        filter,
        firehose,
        links,
        retweet,
        sample
    }

    public TwitterStream(Twitter twitter) {
        super(twitter);
    }

    private void connect3_rateLimit() {
        if (this.jtwit.getScreenName() != null) {
            AStream aStream = (AStream) user2stream.get(this.jtwit.getScreenName());
            if (aStream == null || !aStream.isConnected()) {
                if (user2stream.size() > 1000) {
                    Log.w("Twitter", "User to stream map too big! Killing it");
                    user2stream = new ConcurrentHashMap();
                }
                user2stream.put(this.jtwit.getScreenName(), this);
                return;
            }
            throw new TooManyLogins("One account, one stream (running: " + aStream + "; trying to run" + this + ").\n\tBut streams OR their filter parameters, so one stream can do a lot.");
        }
    }

    HttpURLConnection connect2() {
        connect3_rateLimit();
        String str = "https://stream.twitter.com/1/statuses/" + this.method + ".json";
        Map hashMap = new HashMap();
        if (!(this.follow == null || this.follow.size() == 0)) {
            hashMap.put(Type.FOLLOW, InternalUtils.join(this.follow, 0, Integer.MAX_VALUE));
        }
        if (!(this.track == null || this.track.size() == 0)) {
            hashMap.put("track", InternalUtils.join(this.track, 0, Integer.MAX_VALUE));
        }
        if (hashMap.isEmpty() && this.method == KMethod.filter) {
            throw new IllegalStateException("No filters set for " + this);
        }
        hashMap.put("delimited", "length");
        return this.client.post2_connect(str, hashMap);
    }

    void fillInOutages2(Twitter twitter, Outage outage) {
        if (this.method != KMethod.filter) {
            throw new UnsupportedOperationException();
        }
        if (this.track != null) {
            for (String search : this.track) {
                for (Status status : this.jtwit.search(search)) {
                    if (!this.tweets.contains(status)) {
                        this.tweets.add(status);
                    }
                }
            }
        }
        if (this.follow != null) {
            for (Long userTimeline : this.follow) {
                for (Status status2 : this.jtwit.getUserTimeline(userTimeline)) {
                    if (!this.tweets.contains(status2)) {
                        this.tweets.add(status2);
                    }
                }
            }
        }
        if (this.locns != null && !this.locns.isEmpty()) {
            throw new UnsupportedOperationException("TODO");
        }
    }

    public List<Long> getFollowUsers() {
        return this.follow;
    }

    public List<String> getTrackKeywords() {
        return this.track;
    }

    public void setFollowUsers(List<Long> list) {
        this.method = KMethod.filter;
        if (list == null || list.size() <= MAX_USERS) {
            this.follow = list;
            return;
        }
        throw new IllegalArgumentException("Track upto 5000 users - not " + list.size());
    }

    public void setListenersOnly(boolean z) {
        this.listenersOnly = z;
    }

    @Deprecated
    public void setLocation(List<double[]> list) {
        this.method = KMethod.filter;
        this.locns = list;
        throw new RuntimeException("TODO! Not implemented yet (sorry)");
    }

    void setMethod(KMethod kMethod) {
        this.method = kMethod;
    }

    public void setTrackKeywords(List<String> list) {
        if (list.size() > MAX_KEYWORDS) {
            throw new IllegalArgumentException("Too many tracked terms: " + list.size() + " (" + MAX_KEYWORDS + " limit)");
        }
        for (String str : list) {
            if (str.length() > 60) {
                throw new IllegalArgumentException("Track term too long: " + str + " (60 char limit)");
            }
        }
        this.track = list;
        this.method = KMethod.filter;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TwitterStream");
        stringBuilder.append("[" + this.method);
        if (this.track != null) {
            stringBuilder.append(" track:" + InternalUtils.join(this.track, 0, 5));
        }
        if (this.follow != null && this.follow.size() > 0) {
            stringBuilder.append(" follow:" + InternalUtils.join(this.follow, 0, 5));
        }
        if (this.locns != null) {
            stringBuilder.append(" in:" + InternalUtils.join(this.locns, 0, 5));
        }
        stringBuilder.append(" by:" + this.jtwit.getScreenNameIfKnown());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
