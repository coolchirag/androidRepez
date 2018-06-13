package com.brandall.nutter;

import com.faceture.google.play.QueryParamConst;
import java.io.DataOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class mj {
    private static ml f1712a = ml.STDOUT;
    private static String f1713b;
    private static final String f1714c = System.getProperty("line.separator");
    private static final String f1715d = ("exit" + f1714c);
    private static /* synthetic */ int[] f1716e;

    private static mk m1472a(Process process) {
        mk mkVar;
        mk mkVar2;
        switch (m1478c()[f1712a.ordinal()]) {
            case 1:
                mkVar = new mk(process.getInputStream());
                mkVar = new mk(process.getErrorStream());
                return null;
            case 2:
                mkVar2 = new mk(process.getInputStream());
                mkVar = new mk(process.getErrorStream());
                return mkVar2;
            case 3:
                mkVar2 = new mk(process.getErrorStream());
                mkVar = new mk(process.getInputStream());
                return mkVar2;
            default:
                return null;
        }
    }

    public static synchronized String m1473a(String str) {
        String d;
        synchronized (mj.class) {
            d = m1474a() ? m1479d(str) : null;
        }
        return d;
    }

    public static synchronized boolean m1474a() {
        boolean z = true;
        synchronized (mj.class) {
            if (f1713b == null) {
                try {
                    mm[] values = mm.values();
                    int length = values.length;
                    int i = 0;
                    while (i < length) {
                        boolean z2;
                        f1713b = values[i].m1481a();
                        for (mo a : mo.values()) {
                            CharSequence a2 = m1473a(a.m1482a());
                            if (a2 != null && a2.length() > 0) {
                                Matcher matcher = Pattern.compile("^uid=(\\d+).*?").matcher(a2);
                                if (matcher.matches() && QueryParamConst.U_VALUE.equals(matcher.group(1))) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            i++;
                        }
                    }
                    f1713b = null;
                } catch (mn e) {
                    f1713b = null;
                }
            }
            if (f1713b == null) {
                z = false;
            }
        }
        return z;
    }

    public static synchronized String m1476b(String str) {
        String c;
        synchronized (mj.class) {
            c = m1477c(str);
        }
        return c;
    }

    private static String m1477c(String str) {
        try {
            Process exec = Runtime.getRuntime().exec(str);
            mk a = m1472a(exec);
            exec.waitFor();
            return a.m1480a();
        } catch (Exception e) {
            throw new mn();
        }
    }

    private static /* synthetic */ int[] m1478c() {
        int[] iArr = f1716e;
        if (iArr == null) {
            iArr = new int[ml.values().length];
            try {
                iArr[ml.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ml.STDERR.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ml.STDOUT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f1716e = iArr;
        }
        return iArr;
    }

    private static String m1479d(String str) {
        try {
            Process exec = Runtime.getRuntime().exec(f1713b);
            mk a = m1472a(exec);
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            dataOutputStream.writeBytes(new StringBuilder(String.valueOf(str)).append(f1714c).toString());
            dataOutputStream.flush();
            dataOutputStream.writeBytes(f1715d);
            dataOutputStream.flush();
            exec.waitFor();
            return a.m1480a();
        } catch (Exception e) {
            throw new mn();
        }
    }
}
