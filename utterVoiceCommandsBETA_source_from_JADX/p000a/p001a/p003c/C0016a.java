package p000a.p001a.p003c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import p000a.p001a.C0017c;

public final class C0016a implements Serializable, Map<String, SortedSet<String>> {
    private TreeMap<String, SortedSet<String>> f22a = new TreeMap();

    private SortedSet<String> m18d(Object obj) {
        return (SortedSet) this.f22a.get(obj);
    }

    public final String m19a(Object obj) {
        SortedSet sortedSet = (SortedSet) this.f22a.get(obj);
        return (sortedSet == null || sortedSet.isEmpty()) ? null : (String) sortedSet.first();
    }

    public final String m20a(String str) {
        String a = m19a((Object) str);
        return a == null ? null : str + "=\"" + a + "\"";
    }

    public final String m21a(String str, String str2) {
        return m22a(str, str2, false);
    }

    public final String m22a(String str, String str2, boolean z) {
        SortedSet sortedSet = (SortedSet) this.f22a.get(str);
        if (sortedSet == null) {
            Object a;
            sortedSet = new TreeSet();
            TreeMap treeMap = this.f22a;
            if (z) {
                a = C0017c.m28a(str);
            }
            treeMap.put(a, sortedSet);
        }
        if (str2 != null) {
            if (z) {
                str2 = C0017c.m28a(str2);
            }
            sortedSet.add(str2);
        }
        return str2;
    }

    public final void m23a(Map<? extends String, ? extends SortedSet<String>> map, boolean z) {
        if (z) {
            for (String str : map.keySet()) {
                SortedSet<String> sortedSet = (SortedSet) map.get(str);
                m26c(str);
                for (String a : sortedSet) {
                    m22a(str, a, true);
                }
                m18d(str);
            }
            return;
        }
        this.f22a.putAll(map);
    }

    public final void m24a(String[] strArr) {
        for (int i = 0; i < strArr.length - 1; i += 2) {
            m22a(strArr[i], strArr[i + 1], true);
        }
    }

    public final String m25b(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = C0017c.m28a((String) obj);
        Set set = (Set) this.f22a.get(a);
        if (set == null) {
            return a + "=";
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            stringBuilder.append(a + "=" + ((String) it.next()));
            if (it.hasNext()) {
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }

    public final SortedSet<String> m26c(Object obj) {
        return (SortedSet) this.f22a.remove(obj);
    }

    public final void clear() {
        this.f22a.clear();
    }

    public final boolean containsKey(Object obj) {
        return this.f22a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        for (SortedSet contains : this.f22a.values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Set<Entry<String, SortedSet<String>>> entrySet() {
        return this.f22a.entrySet();
    }

    public final /* synthetic */ Object get(Object obj) {
        return m18d(obj);
    }

    public final boolean isEmpty() {
        return this.f22a.isEmpty();
    }

    public final Set<String> keySet() {
        return this.f22a.keySet();
    }

    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return (SortedSet) this.f22a.put((String) obj, (SortedSet) obj2);
    }

    public final void putAll(Map<? extends String, ? extends SortedSet<String>> map) {
        this.f22a.putAll(map);
    }

    public final /* synthetic */ Object remove(Object obj) {
        return m26c(obj);
    }

    public final int size() {
        int i = 0;
        for (String str : this.f22a.keySet()) {
            i = ((SortedSet) this.f22a.get(str)).size() + i;
        }
        return i;
    }

    public final Collection<SortedSet<String>> values() {
        return this.f22a.values();
    }
}
