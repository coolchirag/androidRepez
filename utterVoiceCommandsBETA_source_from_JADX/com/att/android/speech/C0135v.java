package com.att.android.speech;

import org.apache.http.entity.AbstractHttpEntity;

abstract class C0135v extends AbstractHttpEntity {
    protected long f583a = 0;
    protected aj f584b = null;
    protected boolean f585c = false;

    public C0135v(aj ajVar) {
        this.f584b = ajVar;
    }

    protected final void m463a() {
        this.f585c = true;
    }

    protected final boolean m464b() {
        return this.f585c;
    }
}
