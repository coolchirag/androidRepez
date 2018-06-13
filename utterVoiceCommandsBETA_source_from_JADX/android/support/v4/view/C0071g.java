package android.support.v4.view;

import android.view.MotionEvent;

final class C0071g implements C0069h {
    C0071g() {
    }

    public final int mo39a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public final int mo40b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public final float mo41c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public final float mo42d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
