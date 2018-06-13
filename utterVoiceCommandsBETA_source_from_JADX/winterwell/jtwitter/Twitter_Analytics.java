package winterwell.jtwitter;

import winterwell.json.JSONObject;
import winterwell.jtwitter.Twitter.IHttpClient;

public class Twitter_Analytics {
    private IHttpClient http;

    Twitter_Analytics(IHttpClient iHttpClient) {
        this.http = iHttpClient;
    }

    public int getUrlCount(String str) {
        return new JSONObject(this.http.getPage("http://urls.api.twitter.com/1/urls/count.json", InternalUtils.asMap("url", str), false)).getInt("count");
    }
}
