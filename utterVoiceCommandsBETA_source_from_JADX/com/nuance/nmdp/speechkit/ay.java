package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.C0396l.C0394a;
import java.util.Vector;

public final class ay extends C0396l {

    public final class C0395a extends C0394a {
        public C0395a(ay ayVar) {
            super(ayVar);
        }
    }

    public ay() {
        super(0);
    }

    private ay(int i) {
        super(i);
    }

    public final C0395a m2069d() {
        return new C0395a(this);
    }

    public final ay m2070e() {
        ay ayVar = new ay(m2067c());
        C0395a d = m2069d();
        while (d.m2059a()) {
            ayVar.m2064a(d.m2060b());
        }
        return ayVar;
    }

    public final Vector m2071f() {
        Vector vector = new Vector(m2067c());
        C0395a d = m2069d();
        while (d.m2059a()) {
            vector.addElement(d.m2060b());
        }
        return vector;
    }
}
