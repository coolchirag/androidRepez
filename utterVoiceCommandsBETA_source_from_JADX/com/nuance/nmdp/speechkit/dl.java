package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bi.C0378j;

public final class dl extends dd implements C0378j {
    private cx f2676a;
    private bz f2677b;
    private int f2678c;

    public dl(String str, co coVar, cx cxVar, bz bzVar) {
        super(str, Byte.MAX_VALUE);
        this.f2676a = cxVar;
        this.f2677b = bzVar;
        this.f2678c = coVar.m2283a();
        cxVar.mo260b("audio_id", this.f2678c);
    }

    protected final int m2417a() {
        return this.f2678c;
    }

    protected final byte[] m2418d() {
        return this.f2676a.m2383b();
    }

    protected final bz m2419e() {
        return this.f2677b;
    }
}
