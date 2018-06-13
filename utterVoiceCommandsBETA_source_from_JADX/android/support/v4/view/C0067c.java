package android.support.v4.view;

import android.view.KeyEvent;

final class C0067c implements C0065d {
    C0067c() {
    }

    public final boolean mo37a(int i) {
        return KeyEvent.metaStateHasModifiers(i, 1);
    }

    public final boolean mo38b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
