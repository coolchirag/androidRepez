package com.brandall.nutter;

public final class ln {
    final String f1689a;
    final int f1690b;
    int f1691c;
    int f1692d;
    final /* synthetic */ lm f1693e;

    ln(lm lmVar, String str, int i, int i2) {
        this.f1693e = lmVar;
        this.f1689a = str;
        this.f1690b = i2;
        int i3 = i + 1;
        this.f1692d = i3;
        this.f1691c = i3;
        while (this.f1691c < this.f1690b && Character.isWhitespace(this.f1689a.charAt(this.f1691c))) {
            this.f1691c++;
        }
    }

    public final double m1338a() {
        if (this.f1691c < this.f1690b) {
            if (this.f1689a.charAt(this.f1691c) == ',') {
                this.f1691c++;
            }
            this.f1692d = this.f1691c;
            int i = 0;
            while (this.f1691c < this.f1690b && i >= 0) {
                char charAt = this.f1689a.charAt(this.f1691c);
                if (charAt == '(') {
                    i++;
                } else if (charAt == ')') {
                    i--;
                }
                if (i == 0 && charAt == ',') {
                    break;
                }
                this.f1691c++;
            }
            if (i == 0) {
                return this.f1693e.m1333b(this.f1689a.substring(this.f1692d, this.f1691c).trim());
            }
            throw lm.m1336b(this.f1689a, this.f1691c, "Function has mismatched parenthesis");
        } else if (!Double.isNaN(Double.NaN)) {
            return Double.NaN;
        } else {
            throw new IndexOutOfBoundsException("Function has too few arguments");
        }
    }

    public final boolean m1339b() {
        return this.f1691c < this.f1690b;
    }
}
