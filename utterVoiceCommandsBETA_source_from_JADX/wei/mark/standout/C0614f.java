package wei.mark.standout;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import wei.mark.standout.StandOutWindow.Window;

final class C0614f implements AnimationListener {
    final /* synthetic */ StandOutWindow f3141a;
    private final /* synthetic */ Window f3142b;

    C0614f(StandOutWindow standOutWindow, Window window) {
        this.f3141a = standOutWindow;
        this.f3142b = window;
    }

    public final void onAnimationEnd(Animation animation) {
        this.f3141a.f760c.removeView(this.f3142b);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
