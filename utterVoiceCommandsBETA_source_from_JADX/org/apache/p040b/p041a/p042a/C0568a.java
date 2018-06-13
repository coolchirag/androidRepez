package org.apache.p040b.p041a.p042a;

import org.apache.p040b.p041a.p042a.p043a.C0565b;

public final class C0568a {
    final C0569b f3093a;
    final C0565b f3094b;
    private final String f3095c;

    public C0568a(String str, C0565b c0565b) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (c0565b == null) {
            throw new IllegalArgumentException("Body may not be null");
        } else {
            this.f3095c = str;
            this.f3094b = c0565b;
            this.f3093a = new C0569b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("form-data; name=\"");
            stringBuilder.append(this.f3095c);
            stringBuilder.append("\"");
            m2831a("Content-Disposition", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(c0565b.mo475a());
            if (c0565b.mo477b() != null) {
                stringBuilder.append("; charset=");
                stringBuilder.append(c0565b.mo477b());
            }
            m2831a("Content-Type", stringBuilder.toString());
            m2831a("Content-Transfer-Encoding", c0565b.mo478c());
        }
    }

    private void m2831a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Field name may not be null");
        }
        this.f3093a.m2833a(new C0574g(str, str2));
    }
}
