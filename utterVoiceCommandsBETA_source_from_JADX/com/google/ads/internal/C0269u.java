package com.google.ads.internal;

import android.os.SystemClock;
import com.google.ads.ai;
import com.google.ads.util.C0290d;
import java.util.Iterator;
import java.util.LinkedList;

public final class C0269u {
    private static long f2187f = 0;
    private static long f2188g = 0;
    private static long f2189h = 0;
    private static long f2190i = 0;
    private static long f2191j = -1;
    private final LinkedList<Long> f2192a = new LinkedList();
    private long f2193b;
    private long f2194c;
    private long f2195d;
    private final LinkedList<Long> f2196e = new LinkedList();
    private boolean f2197k = false;
    private boolean f2198l = false;
    private String f2199m;
    private long f2200n;
    private final LinkedList<Long> f2201o = new LinkedList();
    private final LinkedList<ai> f2202p = new LinkedList();

    public C0269u() {
        m1769a();
    }

    public static long m1763E() {
        if (f2191j != -1) {
            return SystemClock.elapsedRealtime() - f2191j;
        }
        f2191j = SystemClock.elapsedRealtime();
        return 0;
    }

    protected static long m1764o() {
        return f2187f;
    }

    protected final boolean m1765A() {
        return this.f2198l;
    }

    protected final void m1766B() {
        C0290d.m1869d("Interstitial no fill.");
        this.f2198l = true;
    }

    public final void m1767C() {
        C0290d.m1869d("Landing page dismissed.");
        this.f2196e.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    protected final String m1768D() {
        return this.f2199m;
    }

    protected final synchronized void m1769a() {
        this.f2192a.clear();
        this.f2193b = 0;
        this.f2194c = 0;
        this.f2195d = 0;
        this.f2196e.clear();
        this.f2200n = -1;
        this.f2201o.clear();
        this.f2202p.clear();
        this.f2197k = false;
        this.f2198l = false;
    }

    public final synchronized void m1770a(ai aiVar) {
        this.f2201o.add(Long.valueOf(SystemClock.elapsedRealtime() - this.f2200n));
        this.f2202p.add(aiVar);
    }

    public final void m1771a(String str) {
        C0290d.m1869d("Prior impression ticket = " + str);
        this.f2199m = str;
    }

    public final synchronized void m1772b() {
        this.f2201o.clear();
        this.f2202p.clear();
    }

    public final synchronized void m1773c() {
        this.f2200n = SystemClock.elapsedRealtime();
    }

    public final synchronized String m1774d() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        Iterator it = this.f2201o.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(longValue);
        }
        return stringBuilder.toString();
    }

    public final synchronized String m1775e() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        Iterator it = this.f2202p.iterator();
        while (it.hasNext()) {
            ai aiVar = (ai) it.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(aiVar.ordinal());
        }
        return stringBuilder.toString();
    }

    protected final void m1776f() {
        C0290d.m1869d("Ad clicked.");
        this.f2192a.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    protected final void m1777g() {
        C0290d.m1869d("Ad request loaded.");
        this.f2193b = SystemClock.elapsedRealtime();
    }

    protected final synchronized void m1778h() {
        C0290d.m1869d("Ad request before rendering.");
        this.f2194c = SystemClock.elapsedRealtime();
    }

    protected final void m1779i() {
        C0290d.m1869d("Ad request started.");
        this.f2195d = SystemClock.elapsedRealtime();
        f2187f++;
    }

    protected final long m1780j() {
        return this.f2192a.size() != this.f2196e.size() ? -1 : (long) this.f2192a.size();
    }

    protected final String m1781k() {
        if (this.f2192a.isEmpty() || this.f2192a.size() != this.f2196e.size()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f2192a.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(((Long) this.f2196e.get(i)).longValue() - ((Long) this.f2192a.get(i)).longValue()));
        }
        return stringBuilder.toString();
    }

    protected final String m1782l() {
        if (this.f2192a.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f2192a.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(((Long) this.f2192a.get(i)).longValue() - this.f2193b));
        }
        return stringBuilder.toString();
    }

    protected final long m1783m() {
        return this.f2193b - this.f2195d;
    }

    protected final synchronized long m1784n() {
        return this.f2194c - this.f2195d;
    }

    protected final synchronized long m1785p() {
        return f2188g;
    }

    protected final synchronized void m1786q() {
        C0290d.m1869d("Ad request network error");
        f2188g++;
    }

    protected final synchronized void m1787r() {
        f2188g = 0;
    }

    protected final synchronized long m1788s() {
        return f2189h;
    }

    protected final synchronized void m1789t() {
        f2189h++;
    }

    protected final synchronized void m1790u() {
        f2189h = 0;
    }

    protected final synchronized long m1791v() {
        return f2190i;
    }

    protected final synchronized void m1792w() {
        f2190i++;
    }

    protected final synchronized void m1793x() {
        f2190i = 0;
    }

    protected final boolean m1794y() {
        return this.f2197k;
    }

    protected final void m1795z() {
        C0290d.m1869d("Interstitial network error.");
        this.f2197k = true;
    }
}
