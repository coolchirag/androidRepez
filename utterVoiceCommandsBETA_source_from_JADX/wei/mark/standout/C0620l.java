package wei.mark.standout;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import wei.mark.standout.StandOutWindow.Window;

final class C0620l implements OnTouchListener {
    final /* synthetic */ Window f3171a;

    C0620l(Window window) {
        this.f3171a = window;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f3171a.f3127g.m744a(this.f3171a.f3123c, this.f3171a, motionEvent);
    }
}
