package com.att.android.speech;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

final class aa extends Drawable {
    private static int[] f371d;
    private static ab f372l = null;
    private static Bitmap f373m = null;
    private static Bitmap f374n = null;
    protected Runnable f375a = null;
    final Bitmap f376b;
    final Bitmap f377c;
    private final int f378e;
    private final int f379f;
    private final int f380g;
    private final int[] f381h;
    private int f382i = 0;
    private final Bitmap f383j;
    private boolean f384k = false;
    private Path f385o = new Path();

    static {
        int[] iArr = new int[20];
        iArr[1] = 1200;
        iArr[2] = 1600;
        iArr[3] = 2400;
        iArr[4] = 3200;
        iArr[5] = 4800;
        iArr[6] = 6400;
        iArr[7] = 8000;
        iArr[8] = 9600;
        iArr[9] = 11200;
        iArr[10] = 12800;
        iArr[11] = 14100;
        iArr[12] = 16000;
        iArr[13] = 17600;
        iArr[14] = 19200;
        iArr[15] = 20800;
        iArr[16] = 22400;
        iArr[17] = 25600;
        iArr[18] = 28800;
        iArr[19] = 32000;
        f371d = iArr;
    }

    public aa(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ab a = ab.m344a(displayMetrics.densityDpi);
        ac.m345a("GraphMeter", "Screen resolution scale factor is " + displayMetrics.density);
        ac.m345a("GraphMeter", "Meter scale factor is " + a.f392f);
        ac.m345a("GraphMeter", "Screen target DPI is " + displayMetrics.densityDpi);
        ac.m345a("GraphMeter", "Meter DPI is " + a.f391e);
        if (f372l != a) {
            f373m = BitmapFactory.decodeStream(getClass().getResourceAsStream(a.f393g));
            f374n = BitmapFactory.decodeStream(getClass().getResourceAsStream(a.f394h));
        }
        this.f376b = f373m;
        this.f377c = f374n;
        this.f383j = this.f376b;
        int i = (int) (a.f392f * 4.0f);
        int i2 = (int) (a.f392f * 4.0f);
        this.f379f = i;
        this.f380g = i2;
        this.f378e = 20;
        this.f381h = new int[52];
        ac.m345a("GraphMeter", "max level blocks: " + this.f378e);
        ac.m345a("GraphMeter", "block height: " + this.f379f);
        ac.m345a("GraphMeter", "block width: " + this.f380g);
        ac.m345a("GraphMeter", "Graph meter height = " + this.f376b.getHeight());
        ac.m345a("GraphMeter", "Graph meter width = " + this.f376b.getWidth());
    }

    public final void m343a(int i) {
        int i2;
        int length;
        if (this.f382i < this.f381h.length) {
            i2 = this.f382i;
        } else {
            length = this.f381h.length - 1;
            for (i2 = 1; i2 < this.f381h.length; i2++) {
                this.f381h[i2 - 1] = this.f381h[i2];
            }
            i2 = length;
        }
        length = 0;
        while (length < f371d.length) {
            if (f371d[length] > i) {
                break;
            }
            length++;
        }
        length = -1;
        if (length == -1) {
            length = this.f378e;
        }
        this.f381h[i2] = length * this.f379f;
        this.f382i++;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        canvas.save();
        canvas.getWidth();
        canvas.getHeight();
        this.f385o.rewind();
        float f = (float) (this.f378e * this.f379f);
        if (this.f382i > 0) {
            float f2 = (float) this.f381h[0];
            this.f385o.moveTo(0.0f, f);
            if (f2 > 0.0f) {
                this.f385o.lineTo(0.0f, f - f2);
            }
            float f3 = 0.0f;
            float f4 = f2;
            int i = 1;
            while (i < this.f381h.length) {
                float f5 = (float) this.f381h[i];
                if (f5 < f4) {
                    f3 = (float) (this.f380g * i);
                    this.f385o.lineTo(f3, f - f4);
                    this.f385o.lineTo(f3, f - f5);
                } else if (f5 > f4) {
                    f3 = (float) (this.f380g * i);
                    this.f385o.lineTo(f3, f - f4);
                    this.f385o.lineTo(f3, f - f5);
                } else {
                    f3 = (float) (this.f380g * i);
                }
                i++;
                f4 = f5;
            }
            this.f385o.lineTo(((float) this.f380g) + f3, f - f4);
            this.f385o.lineTo(f3 + ((float) this.f380g), f);
            this.f385o.lineTo(0.0f, f);
        }
        canvas.clipPath(this.f385o);
        canvas.drawBitmap(this.f383j, 0.0f, 0.0f, null);
        canvas.restore();
        if (!this.f384k) {
            this.f375a.run();
            this.f384k = true;
        }
    }

    public final int getIntrinsicHeight() {
        return this.f383j.getHeight();
    }

    public final int getIntrinsicWidth() {
        return this.f383j.getWidth();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
