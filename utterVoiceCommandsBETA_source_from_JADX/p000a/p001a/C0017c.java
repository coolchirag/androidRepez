package p000a.p001a;

import com.google.p024a.p025a.p026a.p027a.C0224a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import org.ispeech.core.InternalResources;
import p000a.p001a.p003c.C0016a;

public final class C0017c {
    private static final C0224a f23a = new C0224a("-._~");

    public static C0016a m27a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        return C0017c.m31b(stringBuilder.toString());
    }

    public static String m28a(String str) {
        return str == null ? "" : f23a.mo105a(str);
    }

    public static String m29a(String str, String str2) {
        return C0017c.m28a(str) + "=\"" + C0017c.m28a(str2) + "\"";
    }

    public static String m30a(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str + (str.contains("?") ? "&" : "?"));
        for (int i = 0; i < strArr.length; i += 2) {
            if (i > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(C0017c.m28a(strArr[i]) + "=" + C0017c.m28a(strArr[i + 1]));
        }
        return stringBuilder.toString();
    }

    public static C0016a m31b(String str) {
        C0016a c0016a = new C0016a();
        int i = (str == null || str.length() == 0) ? 1 : 0;
        if (i != 0) {
            return c0016a;
        }
        for (String str2 : str.split("\\&")) {
            String str22;
            String d;
            int indexOf = str22.indexOf(61);
            if (indexOf < 0) {
                d = C0017c.m34d(str22);
                str22 = null;
            } else {
                d = C0017c.m34d(str22.substring(0, indexOf));
                str22 = C0017c.m34d(str22.substring(indexOf + 1));
            }
            c0016a.m21a(d, str22);
        }
        return c0016a;
    }

    public static void m32b(String str, String str2) {
        if (System.getProperty(InternalResources.ISPEECH_SCREEN_DEBUG) != null) {
            System.out.println("[SIGNPOST] " + str + ": " + str2);
        }
    }

    public static C0016a m33c(String str) {
        C0016a c0016a = new C0016a();
        if (str != null && str.startsWith("OAuth ")) {
            for (String split : str.substring(6).split(",")) {
                String[] split2 = split.split("=");
                c0016a.m21a(split2[0].trim(), split2[1].replace("\"", "").trim());
            }
        }
        return c0016a;
    }

    private static String m34d(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
