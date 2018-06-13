package winterwell.jtwitter.ecosystem;

import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.InternalUtils;
import winterwell.jtwitter.Twitter.IHttpClient;
import winterwell.jtwitter.TwitterException.Parsing;
import winterwell.jtwitter.URLConnectionHttpClient;
import winterwell.jtwitter.User;

public class PeerIndex {
    final String API_KEY;
    IHttpClient client = new URLConnectionHttpClient();

    public PeerIndex(String str) {
        this.API_KEY = str;
    }

    public PeerIndexProfile getProfile(User user) {
        Object[] objArr = new Object[4];
        objArr[0] = "id";
        objArr[1] = user.screenName == null ? user.id : user.screenName;
        objArr[2] = "api_key";
        objArr[3] = this.API_KEY;
        String page = this.client.getPage("http://api.peerindex.net/v2/profile/show.json", InternalUtils.asMap(objArr), false);
        try {
            return new PeerIndexProfile(new JSONObject(page));
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }
}
