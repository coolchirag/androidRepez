package android.support.v4.app;

import android.os.Build.VERSION;

public final class C0051y {
    private static final aa f204a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f204a = new ac();
        } else {
            f204a = new ab();
        }
    }
}
