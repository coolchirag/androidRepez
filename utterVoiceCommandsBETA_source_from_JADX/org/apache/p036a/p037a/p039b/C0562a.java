package org.apache.p036a.p037a.p039b;

import java.io.File;

public abstract class C0562a implements C0561c {
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
