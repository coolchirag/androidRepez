package org.apache.p040b.p041a.p042a.p043a;

public abstract class C0566a implements C0565b {
    private final String f3088a;
    private final String f3089b;
    private final String f3090c;

    public C0566a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.f3088a = str;
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            this.f3089b = str.substring(0, indexOf);
            this.f3090c = str.substring(indexOf + 1);
            return;
        }
        this.f3089b = str;
        this.f3090c = null;
    }

    public final String mo475a() {
        return this.f3088a;
    }
}
