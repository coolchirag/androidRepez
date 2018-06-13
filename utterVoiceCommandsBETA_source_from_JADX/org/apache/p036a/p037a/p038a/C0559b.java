package org.apache.p036a.p037a.p038a;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public final class C0559b extends C0558a implements Serializable {
    public static final Comparator<File> f3084a = new C0559b();
    public static final Comparator<File> f3085b = new C0560c(f3084a);

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
        return lastModified < 0 ? -1 : lastModified > 0 ? 1 : 0;
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
