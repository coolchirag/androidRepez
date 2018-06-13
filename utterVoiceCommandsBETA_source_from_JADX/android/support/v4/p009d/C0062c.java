package android.support.v4.p009d;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

final class C0062c implements C0060d {
    C0062c() {
    }

    public final Object mo28a(Context context) {
        return new EdgeEffect(context);
    }

    public final void mo29a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public final boolean mo30a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public final boolean mo31a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public final boolean mo32a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }

    public final void mo33b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public final boolean mo34c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}
