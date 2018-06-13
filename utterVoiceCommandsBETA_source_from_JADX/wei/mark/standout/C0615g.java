package wei.mark.standout;

import android.view.Display;
import android.view.WindowManager.LayoutParams;

public final class C0615g extends LayoutParams {
    public int f3143a;
    public int f3144b;
    public int f3145c;
    public int f3146d;
    public int f3147e;
    public float f3148f;
    final /* synthetic */ StandOutWindow f3149g;

    private C0615g(StandOutWindow standOutWindow, int i) {
        this.f3149g = standOutWindow;
        super(200, 200, 2002, 262176, -3);
        m2850a(false);
        if (!C0624p.m2851a(standOutWindow.mo71c(), C0616h.f3158i)) {
            this.flags |= 512;
        }
        int i2 = this.width;
        this.x = ((StandOutWindow.f758a.size() * 100) + (i * 100)) % (this.f3149g.f760c.getDefaultDisplay().getWidth() - i2);
        i2 = this.height;
        Display defaultDisplay = this.f3149g.f760c.getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        this.y = (((((i * 100) * 200) / (width - this.width)) + this.x) + (StandOutWindow.f758a.size() * 100)) % (height - i2);
        this.gravity = 51;
        this.f3143a = 10;
        this.f3145c = 0;
        this.f3144b = 0;
        this.f3147e = Integer.MAX_VALUE;
        this.f3146d = Integer.MAX_VALUE;
    }

    public C0615g(StandOutWindow standOutWindow, int i, int i2, int i3) {
        this(standOutWindow, i);
        this.width = i2;
        this.height = i3;
    }

    private void m2850a(boolean z) {
        if (z) {
            this.flags ^= 8;
        } else {
            this.flags |= 8;
        }
    }
}
