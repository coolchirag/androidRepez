package com.sun.p031a.p032a;

import java.util.NoSuchElementException;
import java.util.Vector;

final class C0529a {
    private int f3027a = 0;
    private int f3028b;
    private String f3029c;
    private Vector f3030d = new Vector();

    public C0529a(String str) {
        this.f3029c = str;
        this.f3028b = str.length();
    }

    private void m2783c() {
        while (this.f3027a < this.f3028b && Character.isWhitespace(this.f3029c.charAt(this.f3027a))) {
            this.f3027a++;
        }
    }

    public final boolean m2784a() {
        if (this.f3030d.size() > 0) {
            return true;
        }
        m2783c();
        return this.f3027a < this.f3028b;
    }

    public final String m2785b() {
        int size = this.f3030d.size();
        if (size > 0) {
            String str = (String) this.f3030d.elementAt(size - 1);
            this.f3030d.removeElementAt(size - 1);
            return str;
        }
        m2783c();
        if (this.f3027a >= this.f3028b) {
            throw new NoSuchElementException();
        }
        size = this.f3027a;
        char charAt = this.f3029c.charAt(size);
        if (charAt == '\"') {
            this.f3027a++;
            Object obj = null;
            while (this.f3027a < this.f3028b) {
                String str2 = this.f3029c;
                int i = this.f3027a;
                this.f3027a = i + 1;
                char charAt2 = str2.charAt(i);
                if (charAt2 == '\\') {
                    this.f3027a++;
                    obj = 1;
                } else if (charAt2 == '\"') {
                    if (obj == null) {
                        return this.f3029c.substring(size + 1, this.f3027a - 1);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = size + 1; i2 < this.f3027a - 1; i2++) {
                        char charAt3 = this.f3029c.charAt(i2);
                        if (charAt3 != '\\') {
                            stringBuffer.append(charAt3);
                        }
                    }
                    return stringBuffer.toString();
                }
            }
        } else if ("=".indexOf(charAt) >= 0) {
            this.f3027a++;
        } else {
            while (this.f3027a < this.f3028b && "=".indexOf(this.f3029c.charAt(this.f3027a)) < 0) {
                if (Character.isWhitespace(this.f3029c.charAt(this.f3027a))) {
                    break;
                }
                this.f3027a++;
            }
        }
        return this.f3029c.substring(size, this.f3027a);
    }
}
