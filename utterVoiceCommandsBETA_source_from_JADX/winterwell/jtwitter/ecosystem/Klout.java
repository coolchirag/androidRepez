package winterwell.jtwitter.ecosystem;

import java.util.HashMap;
import java.util.Map;
import winterwell.json.JSONArray;
import winterwell.json.JSONObject;
import winterwell.jtwitter.InternalUtils;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.URLConnectionHttpClient;

public class Klout {
    final String API_KEY;
    IHttpClient client = new URLConnectionHttpClient();

    public Klout(String str) {
        this.API_KEY = str;
    }

    public Map<String, Double> getScore(String... strArr) {
        int i = 0;
        String join = InternalUtils.join(strArr);
        JSONArray jSONArray = new JSONObject(this.client.getPage("http://api.klout.com/1/klout.json", InternalUtils.asMap("key", this.API_KEY, "users", join), false)).getJSONArray("users");
        Map<String, Double> hashMap = new HashMap(jSONArray.length());
        int length = jSONArray.length();
        while (i < length) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            hashMap.put(jSONObject.getString("twitter_screen_name"), Double.valueOf(jSONObject.getDouble("kscore")));
            i++;
        }
        return hashMap;
    }
}
