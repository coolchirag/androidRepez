package com.dropbox.client2.p022c;

import java.io.Serializable;

public abstract class C0213p implements Serializable {
    public final String f1876a;
    public final String f1877b;

    public C0213p(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("'key' must be non-null");
        } else if (str.contains("|")) {
            throw new IllegalArgumentException("'key' must not contain a \"|\" character: \"" + str + "\"");
        } else if (str2 == null) {
            throw new IllegalArgumentException("'secret' must be non-null");
        } else {
            this.f1876a = str;
            this.f1877b = str2;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0213p) {
            C0213p c0213p = (C0213p) obj;
            boolean z = this.f1876a.equals(c0213p.f1876a) && this.f1877b.equals(c0213p.f1877b);
            if (z) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f1876a.hashCode() ^ (this.f1877b.hashCode() << 1);
    }

    public String toString() {
        return "{key=\"" + this.f1876a + "\", secret=\"" + this.f1877b + "\"}";
    }
}
