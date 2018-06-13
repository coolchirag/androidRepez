package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition.Result;

final class C0375a implements Recognition {
    private String[] f2331a;
    private int[] f2332b;
    private String f2333c;

    final class C0374a implements Result {
        private final String f2329a;
        private final int f2330b;

        C0374a(String str, int i) {
            this.f2329a = str;
            this.f2330b = i;
        }

        public final int getScore() {
            return this.f2330b;
        }

        public final String getText() {
            return this.f2329a;
        }
    }

    public C0375a(String[] strArr, int[] iArr, String str) {
        if (strArr != null) {
            this.f2331a = strArr;
        } else {
            this.f2331a = new String[0];
        }
        if (iArr != null) {
            this.f2332b = iArr;
        } else {
            this.f2332b = new int[0];
        }
        this.f2333c = str;
    }

    public final Result getResult(int i) {
        if (i >= 0 && i < this.f2332b.length) {
            return new C0374a(this.f2331a[i], this.f2332b[i]);
        }
        throw new IndexOutOfBoundsException("index must be >= 0 and < getResultCount().");
    }

    public final int getResultCount() {
        return this.f2332b.length;
    }

    public final String getSuggestion() {
        return this.f2333c;
    }
}
