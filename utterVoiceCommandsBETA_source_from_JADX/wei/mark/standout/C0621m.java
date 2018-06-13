package wei.mark.standout;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import wei.mark.standout.StandOutWindow.Window;

final class C0621m implements OnTouchListener {
    final /* synthetic */ Window f3172a;

    C0621m(Window window) {
        this.f3172a = window;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        StandOutWindow a = this.f3172a.f3127g;
        int i = this.f3172a.f3123c;
        return a.m745a(this.f3172a, motionEvent);
    }
}
