package winterwell.jtwitter;

import java.net.HttpURLConnection;
import java.util.Collection;
import winterwell.jtwitter.AStream.Outage;

@Deprecated
public class UserStream extends AStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!UserStream.class.desiredAssertionStatus());
    boolean withFollowings;

    public UserStream(Twitter twitter) {
        super(twitter);
    }

    HttpURLConnection connect2() {
        String str = "https://userstream.twitter.com/2/user.json?delimited=length";
        Object[] objArr = new Object[2];
        objArr[0] = "with";
        objArr[1] = this.withFollowings ? "followings" : "user";
        return this.client.connect(str, InternalUtils.asMap(objArr), true);
    }

    void fillInOutages2(Twitter twitter, Outage outage) {
        if (this.withFollowings) {
            throw new UnsupportedOperationException("TODO");
        }
        for (Status status : twitter.getMentions()) {
            if (!this.tweets.contains(status)) {
                this.tweets.add(status);
            }
        }
        for (Status status2 : twitter.getUserTimeline(twitter.getScreenName())) {
            if (!this.tweets.contains(status2)) {
                this.tweets.add(status2);
            }
        }
    }

    public Collection<Long> getFriends() {
        return this.friends;
    }

    public void setWithFollowings(boolean z) {
        if ($assertionsDisabled || !isConnected()) {
            this.withFollowings = z;
            return;
        }
        throw new AssertionError();
    }
}
