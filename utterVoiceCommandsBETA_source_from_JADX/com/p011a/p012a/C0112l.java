package com.p011a.p012a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.faceture.http.Scheme;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.ispeech.core.InternalResources;
import org.json.JSONObject;

public final class C0112l {
    private static boolean f366a = false;

    public static Bundle m326a(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", Scheme.HTTP));
            Bundle c = C0112l.m334c(url.getQuery());
            c.putAll(C0112l.m334c(url.getRef()));
            return c;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static String m327a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            if (bundle.get(str) instanceof String) {
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append("&");
                }
                stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
            }
        }
        return stringBuilder.toString();
    }

    private static String m328a(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                stringBuilder.append("\r\n--" + str + "\r\n");
            }
        }
        return stringBuilder.toString();
    }

    private static String m329a(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static String m330a(String str, String str2, Bundle bundle) {
        String str3 = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
        String str4 = "\r\n";
        if (str2.equals("GET")) {
            str = new StringBuilder(String.valueOf(str)).append("?").append(C0112l.m327a(bundle)).toString();
        }
        C0112l.m332a("Facebook-Util", new StringBuilder(String.valueOf(str2)).append(" URL: ").append(str).toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", new StringBuilder(String.valueOf(System.getProperties().getProperty("http.agent"))).append(" FacebookAndroidSDK").toString());
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str5 : bundle.keySet()) {
                Object obj = bundle.get(str5);
                if (obj instanceof byte[]) {
                    bundle2.putByteArray(str5, (byte[]) obj);
                }
            }
            if (!bundle.containsKey("method")) {
                bundle.putString("method", str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str3);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("--" + str3 + str4).getBytes());
            bufferedOutputStream.write(C0112l.m328a(bundle, str3).getBytes());
            bufferedOutputStream.write(new StringBuilder(String.valueOf(str4)).append("--").append(str3).append(str4).toString().getBytes());
            if (!bundle2.isEmpty()) {
                for (String str6 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str6 + "\"" + str4).getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown" + str4 + str4).getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str6));
                    bufferedOutputStream.write(new StringBuilder(String.valueOf(str4)).append("--").append(str3).append(str4).toString().getBytes());
                }
            }
            bufferedOutputStream.flush();
        }
        try {
            return C0112l.m329a(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            return C0112l.m329a(httpURLConnection.getErrorStream());
        }
    }

    public static void m331a(Context context, String str, String str2) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }

    public static void m332a(String str, String str2) {
        if (f366a) {
            Log.d(str, str2);
        }
    }

    public static JSONObject m333b(String str) {
        if (str.equals("false")) {
            throw new C0106f("request failed");
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("error")) {
            jSONObject = jSONObject.getJSONObject("error");
            throw new C0106f(jSONObject.getString("message"), jSONObject.getString(InternalResources.ISPEECH_SCREEN_TYPE), 0);
        } else if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
            throw new C0106f(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
        } else if (jSONObject.has("error_code")) {
            throw new C0106f("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
        } else if (jSONObject.has("error_msg")) {
            throw new C0106f(jSONObject.getString("error_msg"));
        } else if (!jSONObject.has("error_reason")) {
            return jSONObject;
        } else {
            throw new C0106f(jSONObject.getString("error_reason"));
        }
    }

    private static Bundle m334c(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
        }
        return bundle;
    }
}
