package org.apache.p040b.p041a.p042a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class C0569b implements Iterable<C0574g> {
    private final List<C0574g> f3096a = new LinkedList();
    private final Map<String, List<C0574g>> f3097b = new HashMap();

    public final C0574g m2832a(String str) {
        if (str == null) {
            return null;
        }
        List list = (List) this.f3097b.get(str.toLowerCase(Locale.US));
        return (list == null || list.isEmpty()) ? null : (C0574g) list.get(0);
    }

    public final void m2833a(C0574g c0574g) {
        if (c0574g != null) {
            String toLowerCase = c0574g.f3111a.toLowerCase(Locale.US);
            List list = (List) this.f3097b.get(toLowerCase);
            if (list == null) {
                list = new LinkedList();
                this.f3097b.put(toLowerCase, list);
            }
            list.add(c0574g);
            this.f3096a.add(c0574g);
        }
    }

    public final Iterator<C0574g> iterator() {
        return Collections.unmodifiableList(this.f3096a).iterator();
    }

    public final String toString() {
        return this.f3096a.toString();
    }
}
