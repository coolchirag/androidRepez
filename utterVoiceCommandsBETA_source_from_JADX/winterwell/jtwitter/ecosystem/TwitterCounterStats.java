package winterwell.jtwitter.ecosystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import winterwell.json.JSONObject;

public class TwitterCounterStats {
    static final SimpleDateFormat duformat = new SimpleDateFormat("yyyy-MM-dd");
    static final SimpleDateFormat format = new SimpleDateFormat("'date'yyyy-MM-dd");
    public final double avgGrowth;
    public final ArrayList<DateValue> data;
    public final Date dateUpdated;
    public final int followDays;
    public final long rank;
    public final String screenName;
    public final String website;

    public final class DateValue implements Comparable<DateValue> {
        public final Date date;
        public final int value;

        DateValue(Date date, int i) {
            this.date = date;
            this.value = i;
        }

        public final int compareTo(DateValue dateValue) {
            return this.date.compareTo(dateValue.date);
        }

        public final String toString() {
            return this.date + ": " + this.value;
        }
    }

    TwitterCounterStats(JSONObject jSONObject) {
        this.screenName = jSONObject.getString("username");
        this.dateUpdated = duformat.parse(jSONObject.getString("date_updated"));
        this.followDays = jSONObject.getInt("follow_days");
        this.avgGrowth = jSONObject.getDouble("average_growth");
        this.website = jSONObject.optString("url");
        this.rank = jSONObject.getLong("rank");
        Map map = jSONObject.getJSONObject("followersperdate").getMap();
        this.data = new ArrayList(map.size());
        for (String str : map.keySet()) {
            this.data.add(new DateValue(format.parse(str), ((Integer) map.get(str)).intValue()));
        }
        Collections.sort(this.data);
    }

    public String toString() {
        if (this.data.isEmpty()) {
            return "TwitterCounterStats[@" + this.screenName + " no data]";
        }
        Date date = ((DateValue) this.data.get(0)).date;
        return "TwitterCounterStats[@" + this.screenName + " " + this.data.size() + " pts from " + date + " to " + ((DateValue) this.data.get(this.data.size() - 1)).date + "]";
    }
}
