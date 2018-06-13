package android.support.v4.view;

import android.view.MotionEvent;

final class C0070f implements C0069h {
    C0070f() {
    }

    public final int mo39a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public final int mo40b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public final float mo41c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public final float mo42d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}
