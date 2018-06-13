package winterwell.jtwitter.ecosystem;

import java.util.Map;
import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.InternalUtils;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.TwitterException.Parsing;
import winterwell.jtwitter.URLConnectionHttpClient;

public class Topsy {
    private String apikey;
    private IHttpClient client = new URLConnectionHttpClient();

    public final class UrlInfo {
        public final String desc;
        public final int linkCount;
        public final String title;
        public final String url;

        public UrlInfo(JSONObject jSONObject) {
            this.url = jSONObject.getString("url");
            this.title = jSONObject.getString("title");
            this.linkCount = jSONObject.getInt("trackback_total");
            this.desc = jSONObject.getString("description");
        }

        public final String toString() {
            return this.url + " " + this.linkCount + " " + this.title;
        }
    }

    public Topsy(String str) {
        this.apikey = str;
    }

    public UrlInfo getUrlInfo(String str) {
        Map asMap = InternalUtils.asMap("url", str);
        if (this.apikey != null) {
            asMap.put(HttpRequestParams.APIKEY, this.apikey);
        }
        String page = this.client.getPage("http://otter.topsy.com/urlinfo.json", asMap, false);
        try {
            return new UrlInfo(new JSONObject(page).getJSONObject("response"));
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }
}
