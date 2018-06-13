package com.p011a.p012a;

public final class C0106f extends RuntimeException {
    private int f352a = 0;
    private String f353b;

    public C0106f(String str) {
        super(str);
    }

    public C0106f(String str, String str2, int i) {
        super(str);
        this.f353b = str2;
        this.f352a = i;
    }

    public final String m320a() {
        return this.f353b;
    }
}
