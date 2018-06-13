package p000a.p001a.p002a;

import java.io.InputStream;
import p000a.p001a.p003c.C0004b;

public final class C0008d implements C0004b {
    private String f19a;

    public C0008d(String str) {
        this.f19a = str;
    }

    public final String getContentType() {
        return null;
    }

    public final String getHeader(String str) {
        return null;
    }

    public final InputStream getMessagePayload() {
        return null;
    }

    public final String getMethod() {
        return "GET";
    }

    public final String getRequestUrl() {
        return this.f19a;
    }

    public final void setHeader(String str, String str2) {
    }

    public final void setRequestUrl(String str) {
        this.f19a = str;
    }

    public final Object unwrap() {
        return this.f19a;
    }
}
