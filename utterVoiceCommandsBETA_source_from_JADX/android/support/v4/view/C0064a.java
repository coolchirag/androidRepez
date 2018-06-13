package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class C0064a {
    static final C0065d f275a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f275a = new C0067c();
        } else {
            f275a = new C0066b();
        }
    }

    public static boolean m227a(KeyEvent keyEvent) {
        return f275a.mo37a(keyEvent.getMetaState());
    }

    public static boolean m228b(KeyEvent keyEvent) {
        return f275a.mo38b(keyEvent.getMetaState());
    }
}
