package winterwell.jtwitter.ecosystem;

import java.text.ParseException;
import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.InternalUtils;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.TwitterException.Parsing;
import winterwell.jtwitter.URLConnectionHttpClient;

public class TwitterCounter {
    final String apiKey;
    IHttpClient client = new URLConnectionHttpClient();

    public TwitterCounter(String str) {
        this.apiKey = str;
    }

    public IHttpClient getClient() {
        return this.client;
    }

    public TwitterCounterStats getStats(Number number) {
        String page = this.client.getPage("http://api.twittercounter.com/", InternalUtils.asMap("twitter_id", number, HttpRequestParams.APIKEY, this.apiKey), false);
        try {
            return new TwitterCounterStats(new JSONObject(page));
        } catch (JSONException e) {
            throw new Parsing(page, e);
        } catch (ParseException e2) {
            throw new Parsing(page, e2);
        }
    }
}
