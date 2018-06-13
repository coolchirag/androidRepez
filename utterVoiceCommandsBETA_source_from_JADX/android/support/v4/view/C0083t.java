package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class C0083t {
    static final C0084w f292a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f292a = new C0086v();
        } else {
            f292a = new C0085u();
        }
    }

    public static int m281a(ViewConfiguration viewConfiguration) {
        return f292a.mo50a(viewConfiguration);
    }
}
