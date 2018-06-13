package wei.mark.standout;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import wei.mark.standout.StandOutWindow.Window;

final class C0617i implements OnTouchListener {
    final /* synthetic */ Window f3167a;
    private final /* synthetic */ int f3168b;

    C0617i(Window window, int i) {
        this.f3167a = window;
        this.f3168b = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = C0624p.m2851a(this.f3168b, C0616h.f3154e) ? this.f3167a.f3127g.m744a(this.f3167a.f3123c, this.f3167a, motionEvent) : false;
        this.f3167a.f3127g;
        int i = this.f3167a.f3123c;
        Window window = this.f3167a;
        StandOutWindow.m755g();
        return z;
    }
}
