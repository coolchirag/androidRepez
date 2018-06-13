package com.sun.p031a.p032a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.ispeech.core.InternalResources;

public final class C0535g {
    public Hashtable f3047a = new Hashtable();
    private String f3048b = null;

    public C0535g(InputStream inputStream) {
        m2805a(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public C0535g(String str) {
        this.f3048b = str;
        Reader fileReader = new FileReader(new File(this.f3048b));
        try {
            m2805a(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            }
        }
    }

    private void m2804a(String str) {
        String trim = str.trim();
        if (trim.length() != 0 && trim.charAt(0) != '#') {
            String b;
            if (trim.indexOf(61) > 0) {
                C0529a c0529a = new C0529a(trim);
                String str2 = null;
                while (c0529a.m2784a()) {
                    String b2 = c0529a.m2785b();
                    b = (c0529a.m2784a() && c0529a.m2785b().equals("=") && c0529a.m2784a()) ? c0529a.m2785b() : null;
                    if (b == null) {
                        if (C0530b.m2788a()) {
                            C0530b.m2786a("Bad .mime.types entry: " + trim);
                            return;
                        }
                        return;
                    } else if (b2.equals(InternalResources.ISPEECH_SCREEN_TYPE)) {
                        str2 = b;
                    } else if (b2.equals("exts")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(b, ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            b = stringTokenizer.nextToken();
                            C0534f c0534f = new C0534f(str2, b);
                            this.f3047a.put(b, c0534f);
                            if (C0530b.m2788a()) {
                                C0530b.m2786a("Added: " + c0534f.toString());
                            }
                        }
                    }
                }
                return;
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(trim);
            if (stringTokenizer2.countTokens() != 0) {
                String nextToken = stringTokenizer2.nextToken();
                while (stringTokenizer2.hasMoreTokens()) {
                    b = stringTokenizer2.nextToken();
                    C0534f c0534f2 = new C0534f(nextToken, b);
                    this.f3047a.put(b, c0534f2);
                    if (C0530b.m2788a()) {
                        C0530b.m2786a("Added: " + c0534f2.toString());
                    }
                }
            }
        }
    }

    public final void m2805a(BufferedReader bufferedReader) {
        String str = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (str != null) {
                readLine = new StringBuilder(String.valueOf(str)).append(readLine).toString();
            }
            int length = readLine.length();
            if (readLine.length() <= 0 || readLine.charAt(length - 1) != '\\') {
                m2804a(readLine);
                str = null;
            } else {
                str = readLine.substring(0, length - 1);
            }
        }
        if (str != null) {
            m2804a(str);
        }
    }
}
