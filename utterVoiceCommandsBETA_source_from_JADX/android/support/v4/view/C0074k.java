package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class C0074k {
    static final C0075n f290a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f290a = new C0077m();
        } else {
            f290a = new C0076l();
        }
    }

    public static float m269a(VelocityTracker velocityTracker, int i) {
        return f290a.mo47a(velocityTracker, i);
    }
}
