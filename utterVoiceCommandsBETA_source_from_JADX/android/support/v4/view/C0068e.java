package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class C0068e {
    static final C0069h f286a;

    static {
        if (VERSION.SDK_INT >= 5) {
            f286a = new C0071g();
        } else {
            f286a = new C0070f();
        }
    }

    public static int m243a(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m244a(MotionEvent motionEvent, int i) {
        return f286a.mo39a(motionEvent, i);
    }

    public static int m245b(MotionEvent motionEvent, int i) {
        return f286a.mo40b(motionEvent, i);
    }

    public static float m246c(MotionEvent motionEvent, int i) {
        return f286a.mo41c(motionEvent, i);
    }

    public static float m247d(MotionEvent motionEvent, int i) {
        return f286a.mo42d(motionEvent, i);
    }
}
