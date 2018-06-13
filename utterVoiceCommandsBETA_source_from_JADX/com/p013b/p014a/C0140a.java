package com.p013b.p014a;

import com.faceture.google.play.HeaderName;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.p033a.p034a.C0556c;
import org.p033a.p034a.C0557d;

public abstract class C0140a {
    protected static String f639a;
    private static String f640b = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";
    private static String f641c;
    private static String f642d;
    private static String f643e;
    private static String f644f;
    private static long f645g = 0;
    private static String f646h = "text/plain";

    private static String m465a(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        if (inputStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine.replaceAll("﻿", ""));
                }
            } catch (Throwable e) {
                throw new Exception("[microsoft-translator-api] Error reading translation stream.", e);
            }
        }
        return stringBuilder.toString();
    }

    private static String m466a(String str, String str2) {
        String str3 = "grant_type=client_credentials&scope=http://api.microsofttranslator.com&client_id=" + URLEncoder.encode(str, "UTF-8") + "&client_secret=" + URLEncoder.encode(str2, "UTF-8");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f640b).openConnection();
        if (f641c != null) {
            httpURLConnection.setRequestProperty("referer", f641c);
        }
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        String outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
        outputStreamWriter.write(str3);
        outputStreamWriter.flush();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            outputStreamWriter = C0140a.m465a(httpURLConnection.getInputStream());
            if (responseCode == 200) {
                return outputStreamWriter;
            }
            throw new Exception("Error from Microsoft Translator API: " + outputStreamWriter);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    protected static String m467a(URL url) {
        try {
            return ((String) C0557d.m2818a(C0140a.m470b(url))).toString();
        } catch (Throwable e) {
            throw new Exception("[microsoft-translator-api] Error retrieving translation : " + e.getMessage(), e);
        }
    }

    protected static void m468a() {
        if (f639a != null && f639a.length() < 16) {
            throw new RuntimeException("INVALID_API_KEY - Please set the API Key with your Bing Developer's Key");
        } else if (f639a != null) {
        } else {
            if (f642d == null || f643e == null) {
                throw new RuntimeException("Must provide a Windows Azure Marketplace Client Id and Client Secret - Please see http://msdn.microsoft.com/en-us/library/hh454950.aspx for further documentation");
            }
        }
    }

    public static void m469a(String str) {
        f642d = str;
    }

    private static String m470b(URL url) {
        if (!(f642d == null || f643e == null || System.currentTimeMillis() <= f645g)) {
            String a = C0140a.m466a(f642d, f643e);
            f645g = System.currentTimeMillis() + ((long) ((Integer.valueOf(Integer.parseInt((String) ((C0556c) C0557d.m2818a(a)).get("expires_in"))).intValue() * 1000) - 1));
            f644f = "Bearer " + ((String) ((C0556c) C0557d.m2818a(a)).get("access_token"));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (f641c != null) {
            httpURLConnection.setRequestProperty("referer", f641c);
        }
        httpURLConnection.setRequestProperty("Content-Type", f646h + "; charset=UTF-8");
        String str = "UTF-8";
        httpURLConnection.setRequestProperty("Accept-Charset", str);
        if (f644f != null) {
            a = HeaderName.AUTHORIZATION;
            str = f644f;
            httpURLConnection.setRequestProperty(a, str);
        }
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoOutput(true);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            str = C0140a.m465a(httpURLConnection.getInputStream());
            if (responseCode == 200) {
                return str;
            }
            throw new Exception("Error from Microsoft Translator API: " + str);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public static void m471b(String str) {
        f643e = str;
    }
}
