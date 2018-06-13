package com.google.ads.p030b;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import java.util.Locale;
import java.util.Map;

public final class C0238a extends C0237d {
    private String f2039b;
    private int f2040c;
    private int f2041d;
    private int f2042e;
    private int f2043f;
    private int f2044g;
    private int f2045h;
    private String f2046i;
    private int f2047j;
    private int f2048k;
    private C0239b f2049l;
    private int f2050m;
    private String f2051n;

    private static String m1644a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    public final Map<String, Object> mo108a(Context context) {
        C0228a c0228a = (C0228a) m1640a(C0228a.class);
        if (c0228a == null) {
            c0228a = new C0228a();
            m1636a((C0227h) c0228a);
        }
        if (this.f2039b != null) {
            c0228a.m1597d().put("q", this.f2039b);
        }
        if (Color.alpha(this.f2040c) != 0) {
            c0228a.m1597d().put("bgcolor", C0238a.m1644a(this.f2040c));
        }
        if (Color.alpha(this.f2041d) == 255 && Color.alpha(this.f2042e) == 255) {
            c0228a.m1597d().put("gradientfrom", C0238a.m1644a(this.f2041d));
            c0228a.m1597d().put("gradientto", C0238a.m1644a(this.f2042e));
        }
        if (Color.alpha(this.f2043f) != 0) {
            c0228a.m1597d().put("hcolor", C0238a.m1644a(this.f2043f));
        }
        if (Color.alpha(this.f2044g) != 0) {
            c0228a.m1597d().put("dcolor", C0238a.m1644a(this.f2044g));
        }
        if (Color.alpha(this.f2045h) != 0) {
            c0228a.m1597d().put("acolor", C0238a.m1644a(this.f2045h));
        }
        if (this.f2046i != null) {
            c0228a.m1597d().put("font", this.f2046i);
        }
        c0228a.m1597d().put("headersize", Integer.toString(this.f2047j));
        if (Color.alpha(this.f2048k) != 0) {
            c0228a.m1597d().put("bcolor", C0238a.m1644a(this.f2048k));
        }
        if (this.f2049l != null) {
            c0228a.m1597d().put("btype", this.f2049l.toString());
        }
        c0228a.m1597d().put("bthick", Integer.toString(this.f2050m));
        if (this.f2051n != null) {
            c0228a.m1597d().put("channel", this.f2051n);
        }
        return super.mo108a(context);
    }
}
