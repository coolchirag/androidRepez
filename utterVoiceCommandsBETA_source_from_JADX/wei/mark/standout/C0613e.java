package wei.mark.standout;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import wei.mark.standout.StandOutWindow.Window;

final class C0613e implements AnimationListener {
    final /* synthetic */ StandOutWindow f3139a;
    private final /* synthetic */ Window f3140b;

    C0613e(StandOutWindow standOutWindow, Window window) {
        this.f3139a = standOutWindow;
        this.f3140b = window;
    }

    public final void onAnimationEnd(Animation animation) {
        this.f3139a.f760c.removeView(this.f3140b);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
