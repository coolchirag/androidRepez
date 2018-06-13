package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

public final class C0078o {
    static final C0079s f291a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f291a = new C0082r();
        } else if (i >= 9) {
            f291a = new C0081q();
        } else {
            f291a = new C0080p();
        }
    }

    public static int m273a(View view) {
        return f291a.mo48a(view);
    }

    public static boolean m274a(View view, int i) {
        return f291a.mo49a(view, i);
    }
}
