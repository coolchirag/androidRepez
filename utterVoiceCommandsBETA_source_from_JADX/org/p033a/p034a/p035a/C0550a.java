package org.p033a.p034a.p035a;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.p033a.p034a.C0555a;
import org.p033a.p034a.C0556c;

public final class C0550a {
    private LinkedList f3054a;
    private C0552c f3055b = new C0552c();
    private C0553d f3056c = null;
    private int f3057d = 0;

    private static int m2806a(LinkedList linkedList) {
        return linkedList.size() == 0 ? -1 : ((Integer) linkedList.getFirst()).intValue();
    }

    public final Object m2807a(Reader reader) {
        this.f3055b.m2810a(reader);
        this.f3056c = null;
        this.f3057d = 0;
        this.f3054a = null;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            this.f3056c = this.f3055b.m2811b();
            if (this.f3056c == null) {
                this.f3056c = new C0553d(-1, null);
            }
            switch (this.f3057d) {
                case -1:
                    throw new C0551b(this.f3055b.m2809a(), 1, this.f3056c);
                case 0:
                    try {
                        switch (this.f3056c.f3082a) {
                            case 0:
                                this.f3057d = 1;
                                linkedList.addFirst(new Integer(this.f3057d));
                                linkedList2.addFirst(this.f3056c.f3083b);
                                break;
                            case 1:
                                this.f3057d = 2;
                                linkedList.addFirst(new Integer(this.f3057d));
                                linkedList2.addFirst(new C0556c());
                                break;
                            case 3:
                                this.f3057d = 3;
                                linkedList.addFirst(new Integer(this.f3057d));
                                linkedList2.addFirst(new C0555a());
                                break;
                            default:
                                this.f3057d = -1;
                                break;
                        }
                    } catch (IOException e) {
                        throw e;
                    }
                case 1:
                    if (this.f3056c.f3082a == -1) {
                        return linkedList2.removeFirst();
                    }
                    throw new C0551b(this.f3055b.m2809a(), 1, this.f3056c);
                case 2:
                    switch (this.f3056c.f3082a) {
                        case 0:
                            if (!(this.f3056c.f3083b instanceof String)) {
                                this.f3057d = -1;
                                break;
                            }
                            linkedList2.addFirst((String) this.f3056c.f3083b);
                            this.f3057d = 4;
                            linkedList.addFirst(new Integer(this.f3057d));
                            break;
                        case 2:
                            if (linkedList2.size() <= 1) {
                                this.f3057d = 1;
                                break;
                            }
                            linkedList.removeFirst();
                            linkedList2.removeFirst();
                            this.f3057d = C0550a.m2806a(linkedList);
                            break;
                        case 5:
                            break;
                        default:
                            this.f3057d = -1;
                            break;
                    }
                case 3:
                    List list;
                    switch (this.f3056c.f3082a) {
                        case 0:
                            ((List) linkedList2.getFirst()).add(this.f3056c.f3083b);
                            break;
                        case 1:
                            list = (List) linkedList2.getFirst();
                            C0556c c0556c = new C0556c();
                            list.add(c0556c);
                            this.f3057d = 2;
                            linkedList.addFirst(new Integer(this.f3057d));
                            linkedList2.addFirst(c0556c);
                            break;
                        case 3:
                            list = (List) linkedList2.getFirst();
                            C0555a c0555a = new C0555a();
                            list.add(c0555a);
                            this.f3057d = 3;
                            linkedList.addFirst(new Integer(this.f3057d));
                            linkedList2.addFirst(c0555a);
                            break;
                        case 4:
                            if (linkedList2.size() <= 1) {
                                this.f3057d = 1;
                                break;
                            }
                            linkedList.removeFirst();
                            linkedList2.removeFirst();
                            this.f3057d = C0550a.m2806a(linkedList);
                            break;
                        case 5:
                            break;
                        default:
                            this.f3057d = -1;
                            break;
                    }
                case 4:
                    String str;
                    Map map;
                    switch (this.f3056c.f3082a) {
                        case 0:
                            linkedList.removeFirst();
                            ((Map) linkedList2.getFirst()).put((String) linkedList2.removeFirst(), this.f3056c.f3083b);
                            this.f3057d = C0550a.m2806a(linkedList);
                            break;
                        case 1:
                            linkedList.removeFirst();
                            str = (String) linkedList2.removeFirst();
                            map = (Map) linkedList2.getFirst();
                            C0556c c0556c2 = new C0556c();
                            map.put(str, c0556c2);
                            this.f3057d = 2;
                            linkedList.addFirst(new Integer(this.f3057d));
                            linkedList2.addFirst(c0556c2);
                            break;
                        case 3:
                            linkedList.removeFirst();
                            str = (String) linkedList2.removeFirst();
                            map = (Map) linkedList2.getFirst();
                            C0555a c0555a2 = new C0555a();
                            map.put(str, c0555a2);
                            this.f3057d = 3;
                            linkedList.addFirst(new Integer(this.f3057d));
                            linkedList2.addFirst(c0555a2);
                            break;
                        case 6:
                            break;
                        default:
                            this.f3057d = -1;
                            break;
                    }
            }
            if (this.f3057d == -1) {
                throw new C0551b(this.f3055b.m2809a(), 1, this.f3056c);
            }
        } while (this.f3056c.f3082a != -1);
        throw new C0551b(this.f3055b.m2809a(), 1, this.f3056c);
    }
}
