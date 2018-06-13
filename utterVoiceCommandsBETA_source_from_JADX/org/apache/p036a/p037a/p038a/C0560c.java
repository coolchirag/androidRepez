package org.apache.p036a.p037a.p038a;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

final class C0560c extends C0558a implements Serializable {
    private final Comparator<File> f3086a;

    public C0560c(Comparator<File> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Delegate comparator is missing");
        }
        this.f3086a = comparator;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return this.f3086a.compare((File) obj2, (File) obj);
    }

    public final String toString() {
        return super.toString() + "[" + this.f3086a.toString() + "]";
    }
}
