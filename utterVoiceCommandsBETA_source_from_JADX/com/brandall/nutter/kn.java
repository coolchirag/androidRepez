package com.brandall.nutter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

final class kn extends Drawable {
    private Bitmap f1615a;

    kn(Bitmap bitmap) {
        this.f1615a = bitmap;
    }

    public final void draw(Canvas canvas) {
        canvas.drawBitmap(this.f1615a, 0.0f, 0.0f, null);
    }

    public final int getIntrinsicHeight() {
        return this.f1615a.getHeight();
    }

    public final int getIntrinsicWidth() {
        return this.f1615a.getWidth();
    }

    public final int getMinimumHeight() {
        return this.f1615a.getHeight();
    }

    public final int getMinimumWidth() {
        return this.f1615a.getWidth();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
