package winterwell.jtwitter;

import com.winterwell.jgeoplanet.BoundingBox;
import com.winterwell.jgeoplanet.IPlace;
import com.winterwell.jgeoplanet.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import winterwell.json.JSONArray;
import winterwell.json.JSONObject;

public class Place implements IPlace, Serializable {
    private static final long serialVersionUID = 1;
    private BoundingBox boundingBox;
    private String country;
    private String countryCode;
    private List<Location> geometry;
    private String id;
    private String name;
    private String type;

    public Place(JSONObject jSONObject) {
        this.id = InternalUtils.jsonGet("id", jSONObject);
        if (this.id == null) {
            this.id = InternalUtils.jsonGet("woeid", jSONObject);
        }
        this.type = InternalUtils.jsonGet("place_type", jSONObject);
        this.name = InternalUtils.jsonGet("full_name", jSONObject);
        if (this.name == null) {
            this.name = InternalUtils.jsonGet("name", jSONObject);
        }
        this.countryCode = InternalUtils.jsonGet("country_code", jSONObject);
        this.country = InternalUtils.jsonGet(IPlace.TYPE_COUNTRY, jSONObject);
        Object opt = jSONObject.opt("bounding_box");
        if (opt instanceof JSONObject) {
            double d = 180.0d;
            double d2 = 90.0d;
            double d3 = -90.0d;
            double d4 = -180.0d;
            for (Location location : parseCoords((JSONObject) opt)) {
                d3 = Math.max(location.latitude, d3);
                d2 = Math.min(location.latitude, d2);
                d4 = Math.max(location.longitude, d4);
                d = Math.min(location.longitude, d);
            }
            this.boundingBox = new BoundingBox(new Location(d3, d4), new Location(d2, d));
        }
        opt = jSONObject.opt("geometry");
        if (opt instanceof JSONObject) {
            this.geometry = parseCoords((JSONObject) opt);
        }
    }

    private List<Location> parseCoords(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("coordinates").getJSONArray(0);
        List<Location> arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            arrayList.add(new Location(jSONArray2.getDouble(1), jSONArray2.getDouble(0)));
        }
        return arrayList;
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public Location getCentroid() {
        return this.boundingBox == null ? null : this.boundingBox.getCenter();
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryName() {
        return this.country;
    }

    public List<Location> getGeometry() {
        return this.geometry;
    }

    public String getId() {
        return this.id;
    }

    public String getInfoUrl() {
        return "http://api.twitter.com/1/geo/id/" + this.id + ".json";
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getUID() {
        return this.id + "@twitter";
    }

    public String toString() {
        return getName();
    }
}
