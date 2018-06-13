package com.google.ads.util;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class C0236z {
    private static final Object f1991a = new Object();
    private static int f1992b = 0;
    private static HashMap<Class<?>, Integer> f1993c = new HashMap();
    private final ArrayList<aa<?>> f1994d = new ArrayList();
    public final int f1995o;

    public C0236z() {
        synchronized (f1991a) {
            int i = f1992b;
            f1992b = i + 1;
            this.f1995o = i;
            Integer num = (Integer) f1993c.get(getClass());
            if (num == null) {
                f1993c.put(getClass(), Integer.valueOf(1));
            } else {
                f1993c.put(getClass(), Integer.valueOf(num.intValue() + 1));
            }
        }
        C0290d.m1869d("State created: " + toString());
    }

    protected void finalize() {
        synchronized (f1991a) {
            f1993c.put(getClass(), Integer.valueOf(((Integer) f1993c.get(getClass())).intValue() - 1));
        }
        super.finalize();
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.f1995o + "]";
    }
}
