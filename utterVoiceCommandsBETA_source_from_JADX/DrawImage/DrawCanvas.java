package DrawImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import winterwell.jtwitter.Twitter;

public class DrawCanvas extends SurfaceView implements Callback {
    public boolean f0a = false;
    private C0000a f1b;
    private int f2c = 193;
    private int f3d = 0;
    private boolean f4e = false;
    private int f5f = 0;
    private boolean f6g = true;

    public DrawCanvas(Context context) {
        super(context);
        getHolder().addCallback(this);
        this.f1b = new C0000a(this, getHolder());
        setFocusable(true);
    }

    public DrawCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getHolder().addCallback(this);
        this.f1b = new C0000a(this, getHolder());
        setFocusable(true);
    }

    public DrawCanvas(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m0a() {
        this.f1b.m2a(true);
        this.f1b.start();
        this.f0a = true;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f6g) {
            this.f6g = false;
            canvas.drawBitmap(Bitmap.createBitmap(BitmapFactory.decodeStream(DrawCanvas.class.getClassLoader().getResourceAsStream("org/ispeech/raw/please_wait_v1.png"))), 0.0f, 0.0f, null);
            return;
        }
        Bitmap createBitmap = !this.f4e ? Bitmap.createBitmap(BitmapFactory.decodeStream(DrawCanvas.class.getClassLoader().getResourceAsStream("org/ispeech/raw/microphone_back_v_7.png"))) : Bitmap.createBitmap(BitmapFactory.decodeStream(DrawCanvas.class.getClassLoader().getResourceAsStream("org/ispeech/raw/processing_v3.png")));
        Rect rect = new Rect();
        if (!this.f4e) {
            int i;
            if (this.f3d > this.f2c) {
                i = (this.f3d - this.f2c) / 2;
                if (i == 0) {
                    i = 1;
                }
                this.f2c = i + this.f2c;
            } else if (this.f3d < this.f2c) {
                i = (this.f2c - this.f3d) / 2;
                if (i == 0) {
                    i = 1;
                }
                this.f2c -= i;
            }
            if (this.f2c > 193) {
                this.f3d = 193;
                this.f2c = 193;
            }
            rect.set(0, this.f2c, Twitter.MAX_CHARS, 193);
        }
        Paint paint = new Paint();
        paint.setColor(-1);
        this.f1b.m1a();
        if (!this.f4e) {
            canvas.drawRect(rect, paint);
        }
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, null);
        if (this.f4e) {
            Paint paint2 = new Paint();
            paint2.setColor(-3355444);
            paint = new Paint();
            paint.setColor(-1);
            Paint paint3 = new Paint();
            paint3.setColor(-16777216);
            if (this.f5f != 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.f5f == 0) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint3);
                this.f5f = 1;
            } else if (this.f5f == 1) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint3);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint);
                this.f5f = 2;
            } else if (this.f5f == 2) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint3);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint2);
                this.f5f = 3;
            } else if (this.f5f == 3) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint3);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint2);
                this.f5f = 4;
            } else if (this.f5f == 4) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint3);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint2);
                this.f5f = 5;
            } else if (this.f5f == 5) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint3);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint2);
                this.f5f = 6;
            } else if (this.f5f == 6) {
                canvas.drawCircle(95.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 65.0f, 4.0f, paint2);
                canvas.drawCircle(110.0f, 73.0f, 4.0f, paint2);
                canvas.drawCircle(105.0f, 81.0f, 4.0f, paint2);
                canvas.drawCircle(95.0f, 81.0f, 4.0f, paint);
                canvas.drawCircle(90.0f, 73.0f, 4.0f, paint3);
                this.f5f = 1;
            }
        }
    }

    public void setProcessing() {
        this.f4e = true;
    }

    public void setY(int i) {
        this.f3d = 193 - i;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f1b.m2a(false);
        boolean z = true;
        while (z) {
            try {
                this.f1b.join();
                z = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
