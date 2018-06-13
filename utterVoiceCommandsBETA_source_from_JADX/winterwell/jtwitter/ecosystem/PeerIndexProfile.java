package winterwell.jtwitter.ecosystem;

import java.util.ArrayList;
import java.util.List;
import winterwell.json.JSONArray;
import winterwell.json.JSONObject;

public class PeerIndexProfile {
    public final int activity;
    public final int audience;
    public final int authority;
    public final String name;
    public final int peerIndex;
    public final String slug;
    public final List<String> topics = new ArrayList();
    public final String twitterScreenName;
    public final String url;

    PeerIndexProfile(JSONObject jSONObject) {
        this.peerIndex = jSONObject.getInt("peerindex");
        this.authority = jSONObject.getInt("authority");
        this.audience = jSONObject.getInt("audience");
        this.activity = jSONObject.getInt("activity");
        this.twitterScreenName = jSONObject.getString("twitter");
        JSONArray jSONArray = jSONObject.getJSONArray("topics");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.topics.add((String) jSONArray.get(i));
        }
        this.slug = jSONObject.getString("slug");
        this.url = jSONObject.getString("url");
        this.name = jSONObject.optString("name");
    }

    public String toString() {
        return "PeerIndexProfile[" + this.twitterScreenName + " " + this.peerIndex + " " + this.authority + ":" + this.audience + ":" + this.activity + " " + this.topics + "]";
    }
}
