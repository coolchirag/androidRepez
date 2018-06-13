package winterwell.jtwitter;

import com.faceture.google.play.PropertyConsts;
import com.winterwell.jgeoplanet.IGeoCode;
import com.winterwell.jgeoplanet.IPlace;
import com.winterwell.jgeoplanet.MFloat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import winterwell.json.JSONArray;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.TwitterException.Parsing;

public class Twitter_Geo implements IGeoCode {
    static final /* synthetic */ boolean $assertionsDisabled = (!Twitter_Geo.class.desiredAssertionStatus());
    private double accuracy;
    private final Twitter jtwit;

    Twitter_Geo(Twitter twitter) {
        if ($assertionsDisabled || twitter != null) {
            this.jtwit = twitter;
            return;
        }
        throw new AssertionError();
    }

    public List geoSearch(double d, double d2) {
        throw new RuntimeException();
    }

    public List<Place> geoSearch(String str) {
        int i = 0;
        String stringBuilder = new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/geo/search.json").toString();
        Map asMap = InternalUtils.asMap(PropertyConsts.QUERY, str);
        if (this.accuracy != 0.0d) {
            asMap.put("accuracy", String.valueOf(this.accuracy));
        }
        stringBuilder = this.jtwit.getHttpClient().getPage(stringBuilder, asMap, this.jtwit.getHttpClient().canAuthenticate());
        try {
            JSONArray jSONArray = new JSONObject(stringBuilder).getJSONObject("result").getJSONArray("places");
            List<Place> arrayList = new ArrayList(jSONArray.length());
            while (i < jSONArray.length()) {
                arrayList.add(new Place(jSONArray.getJSONObject(i)));
                i++;
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(stringBuilder, e);
        }
    }

    public List geoSearchByIP(String str) {
        throw new RuntimeException();
    }

    public IPlace getPlace(String str, MFloat mFloat) {
        List geoSearch = geoSearch(str);
        if (geoSearch.size() == 0) {
            return null;
        }
        if (geoSearch.size() != 1) {
            return InternalUtils.prefer(geoSearch, IPlace.TYPE_CITY, mFloat, 0.8f);
        }
        if (mFloat != null) {
            mFloat.value = 0.8f;
        }
        return (IPlace) geoSearch.get(0);
    }

    public List<Place> getTrendRegions() {
        int i = 0;
        String page = this.jtwit.getHttpClient().getPage(new StringBuilder(String.valueOf(this.jtwit.TWITTER_URL)).append("/trends/available.json").toString(), null, false);
        try {
            JSONArray jSONArray = new JSONArray(page);
            List<Place> arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                arrayList.add(new Place(jSONArray.getJSONObject(i)));
                i++;
            }
            return arrayList;
        } catch (JSONException e) {
            throw new Parsing(page, e);
        }
    }

    public void setAccuracy(double d) {
        this.accuracy = d;
    }
}
