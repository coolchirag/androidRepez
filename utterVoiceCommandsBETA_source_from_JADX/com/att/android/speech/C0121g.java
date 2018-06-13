package com.att.android.speech;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class C0121g implements Serializable {
    private final byte[] f522a;
    private final int f523b;
    private final String[] f524c;
    private final String[] f525d;
    private transient boolean f526e = false;
    private transient JSONObject f527f = null;
    private transient boolean f528g = false;
    private transient ArrayList<String> f529h = null;

    public C0121g(byte[] bArr, int i, String[] strArr, String[] strArr2) {
        this.f522a = bArr;
        this.f523b = i;
        if (strArr == null || (strArr2 != null && strArr2.length == strArr.length)) {
            this.f524c = strArr;
            this.f525d = strArr2;
            return;
        }
        throw new IllegalArgumentException("headerNames and headerValues must be same size");
    }

    private JSONObject m402e() {
        if (!this.f526e) {
            try {
                this.f527f = (JSONObject) new JSONTokener(new String(this.f522a, "UTF8")).nextValue();
            } catch (UnsupportedEncodingException e) {
                this.f527f = null;
            } catch (JSONException e2) {
                this.f527f = null;
            } catch (ClassCastException e3) {
                this.f527f = null;
            }
            this.f526e = true;
        }
        return this.f527f;
    }

    public final byte[] m403a() {
        return this.f522a;
    }

    public final int m404b() {
        return this.f523b;
    }

    public final Map<String, String> m405c() {
        Map treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if (this.f524c != null) {
            int length = this.f524c.length;
            for (int i = 0; i < length; i++) {
                treeMap.put(this.f524c[i], this.f525d[i]);
            }
        }
        return treeMap;
    }

    public final List<String> m406d() {
        if (!this.f528g) {
            JSONObject e = m402e();
            if (e != null) {
                JSONObject optJSONObject = e.optJSONObject("Recognition");
                e = optJSONObject == null ? e.optJSONObject("recognition") : optJSONObject;
                if (e != null) {
                    JSONArray optJSONArray = e.optJSONArray("NBest");
                    JSONArray optJSONArray2 = optJSONArray == null ? e.optJSONArray("nbest") : optJSONArray;
                    if (optJSONArray2 != null) {
                        this.f529h = new ArrayList();
                        int length = optJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                Object optString = optJSONObject2.optString("Hypothesis", null);
                                if (optString == null) {
                                    optString = optJSONObject2.optString("hypothesis", null);
                                }
                                if (optString != null) {
                                    this.f529h.add(optString);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f528g = true;
        return this.f529h;
    }
}
