package com.brandall.nutter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public final class jj {
    private static ArrayList<String> f1545a = new ArrayList();

    public static String m1205a(ArrayList<String> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("EstablishURL urlArray");
        }
        String str = "false";
        if (arrayList.isEmpty()) {
            if (hc.f1269b) {
                ls.m1347d("EstablishURL urlArray empty");
            }
            return str;
        }
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (hc.f1269b) {
                ls.m1345b("urlPass: " + str2);
            }
            if (hc.f1269b) {
                ls.m1344a("toTidy start: " + str2);
            }
            if (str2.startsWith("go to ")) {
                str2 = str2.replaceFirst("go to ", "").trim();
            }
            if (str2.startsWith("goto ")) {
                str2 = str2.replaceFirst("goto ", "").trim();
            }
            if (str2.startsWith("www ")) {
                str2 = str2.replaceFirst("www ", "www.").trim();
            }
            if (str2.endsWith(" com")) {
                str2 = str2.replaceFirst(" com", ".com").trim();
            }
            if (str2.endsWith(" co uk")) {
                str2 = str2.replaceFirst(" co uk", ".co.uk").trim();
            }
            if (str2.endsWith(" net")) {
                str2 = str2.replaceFirst(" net", ".net").trim();
            }
            if (str2.endsWith(" org")) {
                str2 = str2.replaceFirst(" org", ".org").trim();
            }
            if (str2.endsWith(" org uk")) {
                str2 = str2.replaceFirst(" org uk", ".org.uk").trim();
            }
            if (str2.endsWith(" info")) {
                str2 = str2.replaceFirst(" info", ".info").trim();
            }
            if (str2.endsWith(" mobi")) {
                str2 = str2.replaceFirst(" mobi", ".mobi").trim();
            }
            if (str2.endsWith(" biz")) {
                str2 = str2.replaceFirst(" biz", ".biz").trim();
            }
            if (str2.endsWith(" xxx")) {
                str2 = str2.replaceFirst(" xxx", ".xxx").trim();
            }
            if (str2.endsWith(" tv")) {
                str2 = str2.replaceFirst(" tv", ".tv").trim();
            }
            str2 = str2.replaceAll("\\s", "").trim();
            if (str2.startsWith("www.")) {
                str2 = "http://" + str2;
            }
            if (!str2.startsWith("www.")) {
                str2 = "http://www." + str2;
            }
            if (hc.f1269b) {
                ls.m1344a("toTidy finish: " + str2);
            }
            if (f1545a.contains(str2)) {
                if (hc.f1269b) {
                    ls.m1347d("toTidy duplicate: " + str2);
                }
                str2 = "duplicate";
            } else {
                f1545a.add(str2);
            }
            if (str2.matches("duplicate") || str2.matches("")) {
                if (hc.f1269b) {
                    ls.m1345b("duplicate skipped: " + str2);
                }
            } else if (i >= 6) {
                if (hc.f1269b) {
                    ls.m1347d("http attemtps limit reached: " + i);
                }
                return "false";
            } else if (m1206a(str2)) {
                if (hc.f1269b) {
                    ls.m1344a("urlPassD: " + str2);
                }
                f1545a.clear();
                return str2;
            } else {
                i++;
            }
        }
        return str;
    }

    private static boolean m1206a(String str) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
            httpURLConnection.connect();
            httpURLConnection.getResponseCode();
            if (hc.f1269b) {
                ls.m1344a("huc.getResponseCode: " + httpURLConnection.getResponseCode());
            }
            return httpURLConnection.getResponseCode() == 200 || httpURLConnection.getResponseCode() == 301 || httpURLConnection.getResponseCode() == 302;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("urlReturnCode Exception");
            }
            e.printStackTrace();
            return false;
        }
    }
}
