package com.dropbox.client2;

import com.dropbox.client2.p021a.C0195i;
import com.dropbox.client2.p022c.C0197m;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;

public final class C0196a<SESS_T extends C0197m> {
    public static final String f1853a = "<insert-version-number-here>";
    protected final SESS_T f1854b;

    public C0196a(SESS_T sess_t) {
        if (sess_t == null) {
            throw new IllegalArgumentException("Session must not be null.");
        }
        this.f1854b = sess_t;
    }

    protected static boolean m1520a(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        return (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
    }

    protected static long m1521b(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj != null) {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof String) {
                return Long.parseLong((String) obj, 16);
            }
        }
        return 0;
    }

    public final SESS_T m1522a() {
        return this.f1854b;
    }

    public final C0202e m1523a(String str, InputStream inputStream, long j, C0154f c0154f) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("path is null or empty.");
        } else if (this.f1854b.mo99c()) {
            if (!str.startsWith("/")) {
                str = "/" + str;
            }
            HttpRequest httpPut = new HttpPut(C0222i.m1549a(this.f1854b.mo102f(), "/files_put/" + this.f1854b.mo95a() + str, new String[]{"overwrite", String.valueOf(true), "parent_rev", "", "locale", this.f1854b.mo98b().toString()}));
            this.f1854b.mo96a(httpPut);
            HttpEntity inputStreamEntity = new InputStreamEntity(inputStream, j);
            inputStreamEntity.setContentEncoding("application/octet-stream");
            inputStreamEntity.setChunked(false);
            httpPut.setEntity(c0154f != null ? new C0220g(inputStreamEntity, c0154f) : inputStreamEntity);
            return new C0203b(httpPut, this.f1854b);
        } else {
            throw new C0195i();
        }
    }
}
