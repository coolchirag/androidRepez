package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.faceture.google.play.QueryParamConst;
import com.faceture.http.Scheme;
import com.google.ads.AdActivity;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AdUtil {
    public static final int f2240a = m1836b(VERSION.SDK);
    private static Boolean f2241b = null;
    private static String f2242c = null;
    private static String f2243d;
    private static String f2244e = null;
    private static AudioManager f2245f;
    private static boolean f2246g = true;
    private static boolean f2247h = false;
    private static String f2248i = null;

    public class UserActivityReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                AdUtil.m1830a(true);
            } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                AdUtil.m1830a(false);
            }
        }
    }

    public static int m1819a() {
        return f2240a >= 9 ? 6 : 0;
    }

    public static int m1820a(Context context, DisplayMetrics displayMetrics) {
        return f2240a >= 4 ? C0298l.m1877a(context, displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
    }

    public static DisplayMetrics m1821a(Activity activity) {
        if (activity.getWindowManager() == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String m1822a(Context context) {
        if (f2242c == null) {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            string = (string == null || m1841c()) ? m1825a("emulator") : m1825a(string);
            if (string == null) {
                return null;
            }
            f2242c = string.toUpperCase(Locale.US);
        }
        return f2242c;
    }

    public static String m1823a(Location location) {
        if (location == null) {
            return null;
        }
        return "e1+" + m1840c(String.format(Locale.US, "role: 6 producer: 24 historical_role: 1 historical_producer: 12 timestamp: %d latlng < latitude_e7: %d longitude_e7: %d> radius: %d", new Object[]{Long.valueOf(location.getTime() * 1000), Long.valueOf((long) (location.getLatitude() * 1.0E7d)), Long.valueOf((long) (location.getLongitude() * 1.0E7d)), Long.valueOf((long) (location.getAccuracy() * 1000.0f))}));
    }

    public static String m1824a(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    public static String m1825a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            MessageDigest.getInstance("MD5").update(str.getBytes(), 0, str.length());
            return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r0.digest())});
        } catch (NoSuchAlgorithmException e) {
            return str.substring(0, 32);
        }
    }

    public static String m1826a(Map<String, Object> map) {
        String str = null;
        try {
            str = m1838b((Map) map).toString();
        } catch (Throwable e) {
            C0290d.m1870d("JsonException in serialization: ", e);
        }
        return str;
    }

    private static JSONArray m1827a(Set<Object> set) {
        JSONArray jSONArray = new JSONArray();
        if (set == null || set.isEmpty()) {
            return jSONArray;
        }
        for (Object next : set) {
            if ((next instanceof String) || (next instanceof Integer) || (next instanceof Double) || (next instanceof Long) || (next instanceof Float)) {
                jSONArray.put(next);
            } else if (next instanceof Map) {
                try {
                    jSONArray.put(m1838b((Map) next));
                } catch (Throwable e) {
                    C0290d.m1870d("Unknown map type in json serialization: ", e);
                }
            } else if (next instanceof Set) {
                try {
                    jSONArray.put(m1827a((Set) next));
                } catch (Throwable e2) {
                    C0290d.m1870d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0290d.m1871e("Unknown value in json serialization: " + next);
            }
        }
        return jSONArray;
    }

    public static void m1828a(WebView webView) {
        webView.getSettings().setUserAgentString(m1849i(webView.getContext().getApplicationContext()));
    }

    public static void m1829a(HttpURLConnection httpURLConnection, Context context) {
        httpURLConnection.setRequestProperty("User-Agent", m1849i(context));
    }

    public static void m1830a(boolean z) {
        f2246g = z;
    }

    private static boolean m1831a(int i, int i2, String str) {
        if ((i & i2) != 0) {
            return true;
        }
        C0290d.m1865b("The android:configChanges value of the com.google.ads.AdActivity must include " + str + ".");
        return false;
    }

    public static boolean m1832a(Intent intent, Context context) {
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    public static boolean m1833a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        return Scheme.HTTP.equalsIgnoreCase(scheme) || Scheme.HTTPS.equalsIgnoreCase(scheme);
    }

    public static int m1834b() {
        return f2240a >= 9 ? 7 : 1;
    }

    public static int m1835b(Context context, DisplayMetrics displayMetrics) {
        return f2240a >= 4 ? C0298l.m1877a(context, displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
    }

    private static int m1836b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C0290d.m1871e("The Android SDK version couldn't be parsed to an int: " + VERSION.SDK);
            C0290d.m1871e("Defaulting to Android SDK version 3.");
            return 3;
        }
    }

    public static HashMap<String, String> m1837b(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap();
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            for (String str : encodedQuery.split("&")) {
                int indexOf = str.indexOf("=");
                if (indexOf < 0) {
                    hashMap.put(Uri.decode(str), null);
                } else {
                    hashMap.put(Uri.decode(str.substring(0, indexOf)), Uri.decode(str.substring(indexOf + 1, str.length())));
                }
            }
        }
        return hashMap;
    }

    private static JSONObject m1838b(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return jSONObject;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float)) {
                jSONObject.put(str, obj);
            } else if (obj instanceof Map) {
                try {
                    jSONObject.put(str, m1838b((Map) obj));
                } catch (Throwable e) {
                    C0290d.m1870d("Unknown map type in json serialization: ", e);
                }
            } else if (obj instanceof Set) {
                try {
                    jSONObject.put(str, m1827a((Set) obj));
                } catch (Throwable e2) {
                    C0290d.m1870d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0290d.m1871e("Unknown value in json serialization: " + obj);
            }
        }
        return jSONObject;
    }

    public static boolean m1839b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) == -1) {
            C0290d.m1865b("INTERNET permissions must be enabled in AndroidManifest.xml.");
            return false;
        } else if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", packageName) != -1) {
            return true;
        } else {
            C0290d.m1865b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
            return false;
        }
    }

    private static String m1840c(String str) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(new byte[]{(byte) 10, (byte) 55, (byte) -112, (byte) -47, (byte) -6, (byte) 7, (byte) 11, (byte) 75, (byte) -7, (byte) -121, (byte) 121, (byte) 69, (byte) 80, (byte) -61, (byte) 15, (byte) 5}, "AES"));
            Object iv = instance.getIV();
            Object doFinal = instance.doFinal(str.getBytes());
            byte[] bArr = new byte[(iv.length + doFinal.length)];
            System.arraycopy(iv, 0, bArr, 0, iv.length);
            System.arraycopy(doFinal, 0, bArr, iv.length, doFinal.length);
            return C0293g.m1872a(bArr);
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    public static boolean m1841c() {
        return C0297k.f2291d.equals(C0297k.f2292e);
    }

    public static boolean m1842c(Context context) {
        if (f2241b != null) {
            return f2241b.booleanValue();
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent(context, AdActivity.class), 65536);
        f2241b = Boolean.valueOf(true);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C0290d.m1865b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
            f2241b = Boolean.valueOf(false);
        } else {
            if (!m1831a(resolveActivity.activityInfo.configChanges, 16, "keyboard")) {
                f2241b = Boolean.valueOf(false);
            }
            if (!m1831a(resolveActivity.activityInfo.configChanges, 32, "keyboardHidden")) {
                f2241b = Boolean.valueOf(false);
            }
            if (!m1831a(resolveActivity.activityInfo.configChanges, 128, "orientation")) {
                f2241b = Boolean.valueOf(false);
            }
            if (!m1831a(resolveActivity.activityInfo.configChanges, 256, "screenLayout")) {
                f2241b = Boolean.valueOf(false);
            }
            if (!m1831a(resolveActivity.activityInfo.configChanges, 512, "uiMode")) {
                f2241b = Boolean.valueOf(false);
            }
            if (!m1831a(resolveActivity.activityInfo.configChanges, 1024, "screenSize")) {
                f2241b = Boolean.valueOf(false);
            }
            if (!m1831a(resolveActivity.activityInfo.configChanges, 2048, "smallestScreenSize")) {
                f2241b = Boolean.valueOf(false);
            }
        }
        return f2241b.booleanValue();
    }

    public static String m1843d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return "ed";
            case 1:
                return "wi";
            default:
                return "unknown";
        }
    }

    public static boolean m1844d() {
        return f2246g;
    }

    public static String m1845e(Context context) {
        if (f2243d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            List queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                stringBuilder.append("m");
            }
            queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("a");
            }
            List queryIntentActivities2 = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("tel://6509313940")), 65536);
            if (queryIntentActivities2 == null || queryIntentActivities2.size() == 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("t");
            }
            f2243d = stringBuilder.toString();
        }
        return f2243d;
    }

    public static String m1846f(Context context) {
        if (f2244e != null) {
            return f2244e;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 65536);
            if (resolveActivity == null) {
                return null;
            }
            ActivityInfo activityInfo = resolveActivity.activityInfo;
            if (activityInfo == null) {
                return null;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            String str = packageInfo.versionCode + "." + activityInfo.packageName;
            f2244e = str;
            return str;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static C0287a m1847g(Context context) {
        if (f2245f == null) {
            f2245f = (AudioManager) context.getSystemService("audio");
        }
        C0287a c0287a = C0287a.OTHER;
        int mode = f2245f.getMode();
        if (m1841c()) {
            return C0287a.EMULATOR;
        }
        if (f2245f.isMusicActive() || f2245f.isSpeakerphoneOn() || mode == 2 || mode == 1) {
            return C0287a.VIBRATE;
        }
        mode = f2245f.getRingerMode();
        return (mode == 0 || mode == 1) ? C0287a.VIBRATE : C0287a.SPEAKER;
    }

    public static void m1848h(Context context) {
        if (!f2247h) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new UserActivityReceiver(), intentFilter);
            f2247h = true;
        }
    }

    private static String m1849i(Context context) {
        if (f2248i == null) {
            String userAgentString = new WebView(context).getSettings().getUserAgentString();
            if (userAgentString == null || userAgentString.length() == 0 || userAgentString.equals("Java0")) {
                String property = System.getProperty("os.name", "Linux");
                String str = "Android " + VERSION.RELEASE;
                Locale locale = Locale.getDefault();
                userAgentString = locale.getLanguage().toLowerCase(Locale.US);
                if (userAgentString.length() == 0) {
                    userAgentString = QueryParamConst.HL_VALUE;
                }
                String toLowerCase = locale.getCountry().toLowerCase(Locale.US);
                if (toLowerCase.length() > 0) {
                    userAgentString = userAgentString + "-" + toLowerCase;
                }
                userAgentString = "Mozilla/5.0 (" + property + "; U; " + str + "; " + userAgentString + "; " + (Build.MODEL + " Build/" + Build.ID) + ") AppleWebKit/0.0 (KHTML, like Gecko) Version/0.0 Mobile Safari/0.0";
            }
            f2248i = userAgentString + " (Mobile; afma-sdk-a-v6.2.1)";
        }
        return f2248i;
    }
}
