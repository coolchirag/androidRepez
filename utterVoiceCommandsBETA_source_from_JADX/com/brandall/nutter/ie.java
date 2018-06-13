package com.brandall.nutter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class ie {
    public static C0152if m1167a(double d, double d2) {
        ie ieVar = new ie();
        ieVar.getClass();
        C0152if c0152if = new C0152if(ieVar);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(currentTimeMillis);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.foursquare.com/v2/venues/search?ll=" + (String.valueOf(d) + "," + String.valueOf(d2)) + "&oauth_token=XJQ50XVTLOUJIZRTJ0MJCPGLYAQJO5HRE1YHK0B2VTBI2NYK&v=" + simpleDateFormat.format(instance.getTime())).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            JSONArray jSONArray = ((JSONObject) new JSONTokener(m1168a(httpURLConnection.getInputStream())).nextValue()).getJSONObject("response").getJSONArray("venues");
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    c0152if.f1443b.add(jSONObject.getString("id"));
                    c0152if.f1442a.add(jSONObject.getString("name"));
                    if (hc.f1269b) {
                        ls.m1344a("venue name: " + jSONObject.getString("name"));
                        ls.m1344a("venue id: " + jSONObject.getString("id"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c0152if;
    }

    private static String m1168a(InputStream inputStream) {
        String str = "";
        if (inputStream == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } finally {
            inputStream.close();
        }
    }

    public static ArrayList<String> m1169a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList4 = new ArrayList();
        je a = jd.m1200a(arrayList, arrayList2, arrayList3, 0.7d);
        if (a.f1523a) {
            if (hc.f1269b) {
                ls.m1346c("myScoreProcess.exactMatch: true");
            }
            if (((String) a.f1528f.get(0)).matches("ALGORITHM")) {
                ls.m1346c("myScoreProcess.exactMatch ALGORITHM: true");
                arrayList4.add((String) a.f1528f.get(1));
                arrayList4.add((String) a.f1528f.get(2));
                arrayList4.add((String) a.f1528f.get(0));
            } else {
                if (hc.f1269b) {
                    ls.m1346c("myScoreProcess.exactMatch ALGORITHM: false");
                }
                arrayList4.add((String) a.f1528f.get(0));
                arrayList4.add((String) a.f1528f.get(1));
            }
        } else {
            if (hc.f1269b) {
                ls.m1346c("myScoreProcess.exactMatch: false");
            }
            if (a.f1524b) {
                if (hc.f1269b) {
                    ls.m1346c("myScoreProcess.testMaxResult: true");
                }
                arrayList4.add((String) a.f1529g.get(1));
                arrayList4.add((String) a.f1529g.get(2));
                arrayList4.add((String) a.f1529g.get(0));
            } else {
                if (hc.f1269b) {
                    ls.m1347d("myScoreProcess.testMaxResult: false");
                }
                arrayList4.clear();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("getVenueID elapsed: " + currentTimeMillis2);
        }
        return arrayList4;
    }
}
