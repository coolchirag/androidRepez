package com.nuance.nmdp.speechkit;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class C0396l {
    private final ArrayList<Object> f2390a;

    public abstract class C0394a {
        private final Iterator<Object> f2389a;

        public C0394a(C0396l c0396l) {
            this.f2389a = c0396l.f2390a.iterator();
        }

        public final boolean m2059a() {
            return this.f2389a.hasNext();
        }

        public final Object m2060b() {
            return this.f2389a.next();
        }
    }

    public C0396l(int i) {
        this.f2390a = new ArrayList(i);
    }

    public final Object m2062a() {
        return this.f2390a.remove(0);
    }

    public final Object m2063a(int i) {
        return this.f2390a.get(i);
    }

    public final void m2064a(Object obj) {
        this.f2390a.add(obj);
    }

    public final void m2065b() {
        this.f2390a.clear();
    }

    public final void m2066b(Object obj) {
        this.f2390a.remove(obj);
    }

    public final int m2067c() {
        return this.f2390a.size();
    }

    public final boolean m2068c(Object obj) {
        return this.f2390a.contains(obj);
    }
}
