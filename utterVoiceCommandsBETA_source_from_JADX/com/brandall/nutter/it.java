package com.brandall.nutter;

import java.util.Comparator;
import java.util.Map;

final class it implements Comparator<K> {
    private final /* synthetic */ Map f1482a;

    it(Map map) {
        this.f1482a = map;
    }

    public final int compare(K k, K k2) {
        int compareTo = ((Comparable) this.f1482a.get(k2)).compareTo((Comparable) this.f1482a.get(k));
        return compareTo == 0 ? 1 : compareTo;
    }
}
