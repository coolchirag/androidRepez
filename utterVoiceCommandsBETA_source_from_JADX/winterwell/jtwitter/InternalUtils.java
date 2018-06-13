package winterwell.jtwitter;

import com.winterwell.jgeoplanet.IPlace;
import com.winterwell.jgeoplanet.MFloat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import winterwell.json.JSONException;
import winterwell.json.JSONObject;
import winterwell.jtwitter.TwitterException.Parsing;

public class InternalUtils {
    static final /* synthetic */ boolean $assertionsDisabled = (!InternalUtils.class.desiredAssertionStatus());
    static final Comparator<Status> NEWEST_FIRST = new C06251();
    public static final Pattern REGEX_JUST_DIGITS = Pattern.compile("\\d+");
    public static final Pattern TAG_REGEX = Pattern.compile("<!?/?[\\[\\-a-zA-Z][^>]*>", 32);
    static final Pattern URL_REGEX = Pattern.compile("[hf]tt?ps?://[a-zA-Z0-9_%\\-\\.,\\?&\\/=\\+'~#!\\*:]+[a-zA-Z0-9_%\\-&\\/=\\+]");
    static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    static final DateFormat dfMarko = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
    public static final Pattern latLongLocn = Pattern.compile("(\\S+:)?\\s*(-?[\\d\\.]+)\\s*,\\s*(-?[\\d\\.]+)");
    public static final Pattern pComment = Pattern.compile("<!-*.*?-+>", 32);
    public static final Pattern pDocType = Pattern.compile("<!DOCTYPE.*?>", 34);
    public static final Pattern pScriptOrStyle = Pattern.compile("<(script|style)[^<>]*>.+?</(script|style)>", 34);
    static ConcurrentHashMap<String, Long> usage;

    class C06251 implements Comparator<Status> {
        C06251() {
        }

        public int compare(Status status, Status status2) {
            return -status.id.compareTo(status2.id);
        }
    }

    static URI URI(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static Map asMap(Object... objArr) {
        if ($assertionsDisabled || objArr.length % 2 == 0) {
            Map hashMap = new HashMap(objArr.length / 2);
            for (int i = 0; i < objArr.length; i += 2) {
                Object obj = objArr[i + 1];
                if (obj != null) {
                    hashMap.put(objArr[i], obj);
                }
            }
            return hashMap;
        }
        throw new AssertionError();
    }

    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    static void count(String str) {
        if (usage != null) {
            int indexOf = str.indexOf("?");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            indexOf = str.indexOf("/1/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 3);
            }
            String replaceAll = str.replaceAll("\\d+", "");
            int i = 0;
            while (i < 100) {
                Long l = (Long) usage.get(replaceAll);
                boolean replace = l == null ? ((Long) usage.putIfAbsent(replaceAll, Long.valueOf(1))) == null : usage.replace(replaceAll, l, Long.valueOf(l.longValue() + 1));
                if (!replace) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    static String encode(Object obj) {
        String encode;
        try {
            encode = URLEncoder.encode(String.valueOf(obj), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            encode = URLEncoder.encode(String.valueOf(obj));
        }
        return encode.replace("+", "%20");
    }

    public static ConcurrentHashMap<String, Long> getAPIUsageStats() {
        return usage;
    }

    public static Date getDate(int i, String str, int i2) {
        try {
            return new GregorianCalendar(i, GregorianCalendar.class.getField(str.toUpperCase()).getInt(null), i2).getTime();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    static Boolean getOptBoolean(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        if (opt == null || opt.equals(JSONObject.NULL)) {
            return null;
        }
        if (opt.equals(Boolean.FALSE) || ((opt instanceof String) && ((String) opt).equalsIgnoreCase("false"))) {
            return Boolean.valueOf(false);
        }
        if (opt.equals(Boolean.TRUE) || ((opt instanceof String) && ((String) opt).equalsIgnoreCase("true"))) {
            return Boolean.valueOf(true);
        }
        throw new JSONException(opt + " (" + str + ") is not boolean");
    }

    static String join(List list, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        int min = Math.min(i2, list.size());
        while (i < min) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(",");
            i++;
        }
        if (stringBuilder.length() != 0) {
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
        return stringBuilder.toString();
    }

    public static String join(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() != 0) {
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }
        return stringBuilder.toString();
    }

    protected static String jsonGet(String str, JSONObject jSONObject) {
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError(jSONObject);
        } else if ($assertionsDisabled || jSONObject != null) {
            Object opt = jSONObject.opt(str);
            return (opt == null || JSONObject.NULL.equals(opt)) ? null : opt.toString();
        } else {
            throw new AssertionError();
        }
    }

    static Date parseDate(String str) {
        if (REGEX_JUST_DIGITS.matcher(str).matches()) {
            return new Date(Long.valueOf(str).longValue());
        }
        try {
            return new Date(str);
        } catch (Exception e) {
            try {
                return dfMarko.parse(str);
            } catch (ParseException e2) {
                throw new Parsing(str, e2);
            }
        }
    }

    public static <P extends IPlace> P prefer(List<P> list, String str, MFloat mFloat, float f) {
        if (!$assertionsDisabled && list.size() == 0) {
            throw new AssertionError();
        } else if ($assertionsDisabled || (f >= 0.0f && f <= 1.0f)) {
            List list2;
            List arrayList = new ArrayList();
            for (P p : list) {
                if (str.equals(p.getType())) {
                    arrayList.add(p);
                }
            }
            if (arrayList.size() != 0 && arrayList.size() != list.size()) {
                if (mFloat != null) {
                    mFloat.value = (0.95f * f) / ((float) arrayList.size());
                }
                list2 = arrayList;
            } else if (mFloat != null) {
                mFloat.set(f / ((float) list.size()));
            }
            return (IPlace) list2.get(0);
        } else {
            throw new AssertionError();
        }
    }

    public static void setTrackAPIUsage(boolean z) {
        if (!z) {
            usage = null;
        } else if (usage == null) {
            usage = new ConcurrentHashMap();
        }
    }

    public static void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String stripTags(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf(60) == -1) {
            return str;
        }
        return pDocType.matcher(TAG_REGEX.matcher(pComment.matcher(pScriptOrStyle.matcher(str).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll("");
    }

    public static String stripUrls(String str) {
        return URL_REGEX.matcher(str).replaceAll("");
    }

    protected static String toString(InputStream inputStream) {
        Reader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            inputStreamReader = new InputStreamReader(inputStream);
        }
        return toString(inputStreamReader);
    }

    static String toString(Reader reader) {
        try {
            Closeable closeable;
            if (reader instanceof BufferedReader) {
                closeable = (BufferedReader) reader;
            } else {
                Object bufferedReader = new BufferedReader(reader);
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                int read = closeable.read();
                if (read != -1) {
                    stringBuilder.append((char) read);
                } else {
                    String stringBuilder2 = stringBuilder.toString();
                    URLConnectionHttpClient.close(closeable);
                    return stringBuilder2;
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            URLConnectionHttpClient.close(reader);
        }
    }

    static String unencode(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace("&quot;", "\"").replace("&apos;", "'").replace("&nbsp;", " ").replace("&amp;", "&").replace("&gt;", ">").replace("&lt;", "<");
        return replace.indexOf(0) != -1 ? replace.replace('\u0000', ' ').trim() : replace;
    }

    static User user(String str) {
        try {
            return new User(new JSONObject(str), null);
        } catch (Exception e) {
            throw new TwitterException(e);
        }
    }
}
