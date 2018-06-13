package com.dropbox.client2;

import com.dropbox.client2.p021a.C0187a;
import com.dropbox.client2.p021a.C0189c;
import com.dropbox.client2.p021a.C0190d;
import com.dropbox.client2.p021a.C0192f;
import com.dropbox.client2.p021a.C0193g;
import com.dropbox.client2.p021a.C0195i;
import com.dropbox.client2.p022c.C0197m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpConnectionParams;
import org.p033a.p034a.p035a.C0550a;
import org.p033a.p034a.p035a.C0551b;

public final class C0222i {
    private static final DateFormat f1903a = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss ZZZZZ", Locale.US);

    public static Object m1548a(HttpResponse httpResponse) {
        Reader bufferedReader;
        IOException e;
        Throwable th;
        Reader reader;
        BufferedReader bufferedReader2 = null;
        try {
            Object a;
            BufferedReader bufferedReader3;
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()), 16384);
                try {
                    bufferedReader.mark(16384);
                    a = new C0550a().m2807a(bufferedReader);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        throw new C0189c(e);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                } catch (C0551b e4) {
                    reader = bufferedReader;
                    if (C0193g.m1519a(httpResponse)) {
                        throw new C0190d(bufferedReader2);
                    }
                    throw new C0193g(httpResponse);
                } catch (OutOfMemoryError e5) {
                    th = e5;
                    reader = bufferedReader;
                    throw new C0187a(th);
                }
            }
            bufferedReader3 = null;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e6) {
                }
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return a;
            }
            if (statusCode == 401) {
                throw new C0195i();
            }
            throw new C0193g(httpResponse, a);
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
            throw new C0189c(e);
        } catch (C0551b e8) {
            if (C0193g.m1519a(httpResponse)) {
                throw new C0190d(bufferedReader2);
            }
            throw new C0193g(httpResponse);
        } catch (OutOfMemoryError e9) {
            th = e9;
            throw new C0187a(th);
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static String m1549a(String str, String str2, String[] strArr) {
        if (!str2.startsWith("/")) {
            str2 = "/" + str2;
        }
        try {
            String replace = URLEncoder.encode("/1" + str2, "UTF-8").replace("%2F", "/");
            if (strArr != null && strArr.length > 0) {
                replace = replace + "?" + C0222i.m1550a(strArr);
            }
            return "https://" + str + ":443" + replace.replace("+", "%20").replace("*", "%2A");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static String m1550a(String[] strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Params must have an even number of elements.");
        }
        String str = "";
        Object obj = 1;
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i + 1] != null) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        str = str + "&";
                    }
                    str = str + URLEncoder.encode(strArr[i], "UTF-8") + "=" + URLEncoder.encode(strArr[i + 1], "UTF-8");
                }
                i += 2;
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
        str.replace("*", "%2A");
        return str;
    }

    public static HttpResponse m1551a(C0197m c0197m, HttpUriRequest httpUriRequest) {
        HttpClient a = C0222i.m1552a(c0197m);
        c0197m.mo97a(httpUriRequest);
        HttpConnectionParams.setSoTimeout(httpUriRequest.getParams(), 180000);
        HttpResponse httpResponse = null;
        int i = 0;
        while (httpResponse == null && i < 5) {
            try {
                httpResponse = a.execute(httpUriRequest);
            } catch (NullPointerException e) {
            }
            if (httpResponse == null) {
                try {
                    C0222i.m1553a(a, c0197m);
                } catch (SSLException e2) {
                    throw new C0192f(e2);
                } catch (IOException e3) {
                    throw new C0189c(e3);
                } catch (Throwable e4) {
                    throw new C0187a(e4);
                }
            }
            i++;
        }
        if (httpResponse == null) {
            throw new C0189c("Apache HTTPClient encountered an error. No response, try again.");
        }
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            C0222i.m1548a(httpResponse);
        }
        return httpResponse;
    }

    private static synchronized HttpClient m1552a(C0197m c0197m) {
        HttpClient e;
        synchronized (C0222i.class) {
            e = c0197m.mo101e();
            C0222i.m1553a(e, c0197m);
        }
        return e;
    }

    private static void m1553a(HttpClient httpClient, C0197m c0197m) {
        c0197m.mo100d();
        httpClient.getParams().removeParameter("http.route.default-proxy");
    }
}
