package winterwell.jtwitter.ecosystem;

import org.ispeech.core.HttpRequestParams;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.InternalUtils;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.TwitterException.Parsing;
import winterwell.jtwitter.URLConnectionHttpClient;
import winterwell.jtwitter.User;

public class ThirdParty {
    private IHttpClient client;

    public ThirdParty() {
        this(new URLConnectionHttpClient());
    }

    public ThirdParty(IHttpClient iHttpClient) {
        this.client = iHttpClient;
    }

    public double getInfochimpTrustRank(User user, String str) {
        String page = this.client.getPage("http://api.infochimps.com/soc/net/tw/trstrank.json", InternalUtils.asMap("screen_name", user.screenName, HttpRequestParams.APIKEY, str), false);
        try {
            return Double.valueOf(new JSONObject(page).getDouble("trstrank")).doubleValue();
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }
}
