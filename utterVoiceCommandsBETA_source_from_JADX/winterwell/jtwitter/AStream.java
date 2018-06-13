package winterwell.jtwitter;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.Twitter.ITweet;
import winterwell.jtwitter.TwitterEvent.Type;
import winterwell.jtwitter.TwitterException.E40X;
import winterwell.jtwitter.TwitterException.E50X;
import winterwell.jtwitter.TwitterException.Parsing;

public abstract class AStream implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = (!AStream.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static int MAX_BUFFER = 10000;
    private static final int MAX_WAIT_SECONDS = 900;
    boolean autoReconnect;
    final IHttpClient client;
    List<TwitterEvent> events = new ArrayList();
    boolean fillInFollows = true;
    private int forgotten;
    List<Long> friends;
    final Twitter jtwit;
    private BigInteger lastId = BigInteger.ZERO;
    final List<IListen> listeners = new ArrayList(0);
    boolean listenersOnly;
    final List<Outage> outages = new ArrayList();
    int previousCount;
    StreamGobbler readThread;
    InputStream stream;
    List<Object[]> sysEvents = new ArrayList();
    List<ITweet> tweets = new ArrayList();

    public interface IListen {
        boolean processEvent(TwitterEvent twitterEvent);

        boolean processSystemEvent(Object[] objArr);

        boolean processTweet(ITweet iTweet);
    }

    public final class Outage implements Serializable {
        private static final long serialVersionUID = 1;
        public final BigInteger sinceId;
        public final long untilTime;

        public Outage(BigInteger bigInteger, long j) {
            this.sinceId = bigInteger;
            this.untilTime = j;
        }

        public final String toString() {
            return "Outage[id:" + this.sinceId + " to time:" + this.untilTime + "]";
        }
    }

    public AStream(Twitter twitter) {
        this.client = twitter.getHttpClient();
        this.jtwit = twitter;
        this.client.setTimeout(91000);
    }

    static int forgetIfFull(List list) {
        if (list.size() < MAX_BUFFER) {
            return 0;
        }
        int i = MAX_BUFFER / 10;
        for (int i2 = 0; i2 < i; i2++) {
            list.remove(0);
        }
        return i;
    }

    private final void read() {
        String[] popJsons = this.readThread.popJsons();
        int length = popJsons.length;
        int i = 0;
        while (i < length) {
            String str = popJsons[i];
            try {
                read2(str);
                i++;
            } catch (JSONException e) {
                throw new Parsing(str, e);
            }
        }
        if (!isConnected()) {
            if (this.readThread == null || !this.readThread.stopFlag) {
                Exception exception = this.readThread == null ? null : this.readThread.ex;
                close();
                if (this.autoReconnect) {
                    reconnect();
                } else if (exception instanceof TwitterException) {
                    throw ((TwitterException) exception);
                } else {
                    throw new TwitterException(exception);
                }
            }
        }
    }

    private void read2(String str) {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("friends");
        if (optJSONArray != null) {
            read3_friends(optJSONArray);
            return;
        }
        Object read3_parse = read3_parse(jSONObject, this.jtwit);
        if (read3_parse instanceof Status) {
            Status status = (Status) read3_parse;
            if (!this.tweets.contains(status)) {
                this.tweets.add(status);
                if (status.id.compareTo(this.lastId) > 0) {
                    this.lastId = status.id;
                }
                this.forgotten += forgetIfFull(this.tweets);
            }
        } else if (read3_parse instanceof TwitterEvent) {
            this.events.add((TwitterEvent) read3_parse);
            this.forgotten += forgetIfFull(this.events);
        } else {
            if (read3_parse instanceof Object[]) {
                Object[] objArr = (Object[]) read3_parse;
                if ("delete".equals(objArr[0])) {
                    if (!this.tweets.remove((Status) objArr[1])) {
                        this.sysEvents.add(objArr);
                        this.forgotten += forgetIfFull(this.sysEvents);
                        return;
                    }
                    return;
                } else if ("limit".equals(objArr[0])) {
                    Integer num = (Integer) objArr[1];
                    this.sysEvents.add(objArr);
                    this.forgotten += num.intValue();
                    return;
                }
            }
            System.out.println(jSONObject);
        }
    }

    private void read3_friends(JSONArray jSONArray) {
        Collection collection = this.friends;
        this.friends = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            this.friends.add(Long.valueOf(jSONArray.getLong(i)));
        }
        if (collection != null && this.fillInFollows) {
            Collection hashSet = new HashSet(this.friends);
            hashSet.removeAll(collection);
            if (hashSet.size() != 0) {
                List<User> showById = new Twitter_Users(this.jtwit).showById(hashSet);
                User self = this.jtwit.getSelf();
                for (User twitterEvent : showById) {
                    this.events.add(new TwitterEvent(new Date(), self, Type.FOLLOW, twitterEvent, null));
                }
                this.forgotten += forgetIfFull(this.events);
            }
        }
    }

    static Object read3_parse(JSONObject jSONObject, Twitter twitter) {
        if (jSONObject.has(HttpRequestParams.TEXT)) {
            return new Status(jSONObject, null);
        }
        if (jSONObject.optString("event") != "") {
            return new TwitterEvent(jSONObject, twitter);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("delete");
        if (optJSONObject != null) {
            optJSONObject = optJSONObject.getJSONObject("status");
            Number bigInteger = new BigInteger(optJSONObject.getString("id_str"));
            long j = optJSONObject.getLong("user_id");
            Status status = new Status(null, null, bigInteger, null);
            return new Object[]{"delete", status, Long.valueOf(j)};
        }
        optJSONObject = jSONObject.optJSONObject("limit");
        if (optJSONObject != null) {
            if (optJSONObject.optInt("track") == 0) {
                System.out.println(jSONObject);
            }
            return new Object[]{"limit", Integer.valueOf(r0)};
        }
        System.out.println(jSONObject);
        return jSONObject;
    }

    private void reconnect2() {
        try {
            connect();
        } catch (E40X e) {
            throw e;
        } catch (Exception e2) {
            System.out.println(e2);
            int nextInt = new Random().nextInt(40) + 20;
            while (0 < MAX_WAIT_SECONDS) {
                try {
                    Thread.sleep((long) (nextInt * 1000));
                    int i = 0 + nextInt;
                    if (nextInt < 300) {
                        nextInt *= 2;
                    }
                    connect();
                    return;
                } catch (E40X e3) {
                    throw e3;
                } catch (Exception e22) {
                    System.out.println(e22);
                }
            }
            throw new E50X("Could not connect to streaming server");
        }
    }

    public void addListener(IListen iListen) {
        synchronized (this.listeners) {
            this.listeners.remove(iListen);
            this.listeners.add(0, iListen);
        }
    }

    public void addOutage(Outage outage) {
        for (int i = 0; i < this.outages.size(); i++) {
            if (((Outage) this.outages.get(i)).sinceId.compareTo(outage.sinceId) > 0) {
                this.outages.add(i, outage);
                return;
            }
        }
        this.outages.add(outage);
    }

    void addSysEvent(Object[] objArr) {
        this.sysEvents.add(objArr);
        if (this.listeners.size() != 0) {
            synchronized (this.listeners) {
                try {
                    for (IListen processSystemEvent : this.listeners) {
                        if (processSystemEvent.processSystemEvent(objArr)) {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clear() {
        this.outages.clear();
        popEvents();
        popSystemEvents();
        popTweets();
    }

    public synchronized void close() {
        if (!(this.readThread == null || Thread.currentThread() == this.readThread)) {
            this.readThread.pleaseStop();
            if (this.readThread.isAlive()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                this.readThread.interrupt();
            }
            this.readThread = null;
        }
        URLConnectionHttpClient.close(this.stream);
        this.stream = null;
    }

    public synchronized void connect() {
        if (!isConnected()) {
            close();
            if ($assertionsDisabled || this.readThread == null || this.readThread.stream == this) {
                try {
                    this.stream = connect2().getInputStream();
                    if (this.readThread == null) {
                        this.readThread = new StreamGobbler(this);
                        this.readThread.setName("Gobble:" + toString());
                        this.readThread.start();
                    } else if (!$assertionsDisabled && Thread.currentThread() != this.readThread) {
                        throw new AssertionError(this);
                    } else if (!($assertionsDisabled || this.readThread.stream == this)) {
                        throw new AssertionError(this.readThread);
                    }
                    if (!isConnected()) {
                        Thread.sleep(10);
                        if (!isConnected()) {
                            throw new TwitterException(this.readThread.ex);
                        }
                    }
                } catch (Exception e) {
                    if (e instanceof TwitterException) {
                        throw ((TwitterException) e);
                    }
                    throw new TwitterException(e);
                }
            }
            throw new AssertionError(this);
        }
    }

    abstract HttpURLConnection connect2();

    public final void fillInOutages() {
        int i = 0;
        if (this.outages.size() != 0) {
            Outage[] outageArr = (Outage[]) this.outages.toArray(new Outage[0]);
            Twitter twitter = new Twitter(this.jtwit);
            int length = outageArr.length;
            while (i < length) {
                Outage outage = outageArr[i];
                if (System.currentTimeMillis() - outage.untilTime >= 60000) {
                    twitter.setSinceId(outage.sinceId);
                    twitter.setUntilDate(new Date(outage.untilTime));
                    twitter.setMaxResults(100000);
                    fillInOutages2(twitter, outage);
                    this.outages.remove(outage);
                }
                i++;
            }
        }
    }

    abstract void fillInOutages2(Twitter twitter, Outage outage);

    protected void finalize() {
        close();
    }

    public final List<TwitterEvent> getEvents() {
        read();
        return this.events;
    }

    public final int getForgotten() {
        return this.forgotten;
    }

    public final List<Outage> getOutages() {
        return this.outages;
    }

    public final List<Object[]> getSystemEvents() {
        read();
        return this.sysEvents;
    }

    public final List<ITweet> getTweets() {
        read();
        return this.tweets;
    }

    public final boolean isAlive() {
        return isConnected() ? true : !this.autoReconnect ? $assertionsDisabled : (this.readThread == null || !this.readThread.isAlive() || this.readThread.stopFlag) ? $assertionsDisabled : true;
    }

    public final boolean isConnected() {
        return (this.readThread == null || !this.readThread.isAlive() || this.readThread.ex != null || this.readThread.stopFlag) ? $assertionsDisabled : true;
    }

    public final List<TwitterEvent> popEvents() {
        List<TwitterEvent> events = getEvents();
        this.events = new ArrayList();
        return events;
    }

    public final List<Object[]> popSystemEvents() {
        List<Object[]> systemEvents = getSystemEvents();
        this.sysEvents = new ArrayList();
        return systemEvents;
    }

    public final List<ITweet> popTweets() {
        List<ITweet> tweets = getTweets();
        this.tweets = new ArrayList();
        return tweets;
    }

    synchronized void reconnect() {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            reconnect2();
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            addSysEvent(new Object[]{"reconnect", Long.valueOf(currentTimeMillis)});
            if (this.lastId != BigInteger.ZERO) {
                this.outages.add(new Outage(this.lastId, System.currentTimeMillis()));
                if (this.outages.size() > 100000) {
                    for (int i = 0; i < 1000; i++) {
                        this.outages.remove(0);
                    }
                    this.forgotten += 10000;
                }
            }
        }
    }

    synchronized void reconnectFromGobblerThread() {
        if (!$assertionsDisabled && Thread.currentThread() != this.readThread && this.readThread != null) {
            throw new AssertionError(this);
        } else if (!isConnected()) {
            reconnect();
        }
    }

    public boolean removeListener(IListen iListen) {
        boolean remove;
        synchronized (this.listeners) {
            remove = this.listeners.remove(iListen);
        }
        return remove;
    }

    public void setAutoReconnect(boolean z) {
        this.autoReconnect = z;
    }

    @Deprecated
    public void setPreviousCount(int i) {
        this.previousCount = i;
    }
}
