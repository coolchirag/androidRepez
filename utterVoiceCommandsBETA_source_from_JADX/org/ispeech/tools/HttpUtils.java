package org.ispeech.tools;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
    private static final String TAG = "HttpUtils";

    public static String addParamsToUrl(String str, List<NameValuePair> list) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (NameValuePair nameValuePair : list) {
            try {
                stringBuffer.append("&" + URLEncoder.encode(nameValuePair.getName(), "utf-8") + "=" + URLEncoder.encode(nameValuePair.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return stringBuffer.toString().replaceFirst("&", "?");
    }

    public static Map<String, String> parseNameValuePairEntity(HttpEntity httpEntity) {
        return parseNameValuePairString(EntityUtils.toString(httpEntity));
    }

    public static Map<String, String> parseNameValuePairString(String str) {
        String replaceAll = str.replaceAll("\\p{Cntrl}", "");
        Map<String, String> hashMap = new HashMap();
        Log.d(TAG, "parsed result: " + replaceAll);
        for (String replaceAll2 : replaceAll2.split("&")) {
            String[] split = replaceAll2.split("=");
            hashMap.put(split[0], split.length == 1 ? "" : URLDecoder.decode(split[1]));
        }
        return hashMap;
    }
}
