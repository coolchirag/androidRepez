package DrawImage;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

final class C0000a extends Thread {
    Canvas f7a;
    final /* synthetic */ DrawCanvas f8b;
    private SurfaceHolder f9c;
    private boolean f10d = false;

    public C0000a(DrawCanvas drawCanvas, SurfaceHolder surfaceHolder) {
        this.f8b = drawCanvas;
        this.f9c = surfaceHolder;
    }

    public final void m1a() {
        try {
            this.f7a.drawColor(-16777216);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m2a(boolean z) {
        this.f10d = z;
    }

    public final void run() {
        while (this.f10d) {
            this.f7a = null;
            try {
                this.f7a = this.f9c.lockCanvas();
                synchronized (this.f9c) {
                    this.f8b.onDraw(this.f7a);
                }
                this.f9c.unlockCanvasAndPost(this.f7a);
            } catch (Exception e) {
                this.f10d = false;
                e.printStackTrace();
            }
        }
    }
}
