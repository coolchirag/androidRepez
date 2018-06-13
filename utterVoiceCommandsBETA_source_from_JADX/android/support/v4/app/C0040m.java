package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class C0040m implements AnimationListener {
    final /* synthetic */ C0032e f160a;
    final /* synthetic */ C0038k f161b;

    C0040m(C0038k c0038k, C0032e c0032e) {
        this.f161b = c0038k;
        this.f160a = c0032e;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.f160a.f100b != null) {
            this.f160a.f100b = null;
            this.f161b.m109a(this.f160a, this.f160a.f101c, 0, 0);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
