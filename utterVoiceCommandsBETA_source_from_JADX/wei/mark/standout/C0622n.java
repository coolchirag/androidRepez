package wei.mark.standout;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import wei.mark.standout.StandOutWindow.Window;

final class C0622n implements OnTouchListener {
    final /* synthetic */ Window f3173a;

    C0622n(Window window) {
        this.f3173a = window;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        StandOutWindow a = this.f3173a.f3127g;
        int i = this.f3173a.f3123c;
        return a.m745a(this.f3173a, motionEvent);
    }
}
