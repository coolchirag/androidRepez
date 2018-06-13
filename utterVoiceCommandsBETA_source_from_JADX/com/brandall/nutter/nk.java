package com.brandall.nutter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;

final class nk {
    private static int f1770a = -1;
    private static int f1771b = -1;
    private static final Rect f1772c = new Rect();
    private static Canvas f1773d;

    static {
        Canvas canvas = new Canvas();
        f1773d = canvas;
        canvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
    }

    static Drawable m1493a(Drawable drawable, Context context) {
        int dimension;
        if (f1770a == -1) {
            dimension = (int) context.getResources().getDimension(17104896);
            f1771b = dimension;
            f1770a = dimension;
        }
        int i = f1770a;
        int i2 = f1771b;
        if (drawable instanceof PaintDrawable) {
            PaintDrawable paintDrawable = (PaintDrawable) drawable;
            paintDrawable.setIntrinsicWidth(i);
            paintDrawable.setIntrinsicHeight(i2);
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap().getDensity() == 0) {
                bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
            }
        }
        dimension = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (i <= 0 || i2 <= 0) {
            return drawable;
        }
        if (i < dimension || i2 < intrinsicHeight) {
            float f = ((float) dimension) / ((float) intrinsicHeight);
            if (dimension > intrinsicHeight) {
                dimension = (int) (((float) i) / f);
                i2 = i;
            } else if (intrinsicHeight > dimension) {
                int i3 = i2;
                i2 = (int) (((float) i2) * f);
                dimension = i3;
            } else {
                dimension = i2;
                i2 = i;
            }
            Bitmap createBitmap = Bitmap.createBitmap(f1770a, f1771b, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
            Canvas canvas = f1773d;
            canvas.setBitmap(createBitmap);
            f1772c.set(drawable.getBounds());
            int i4 = (f1770a - i2) / 2;
            int i5 = (f1771b - dimension) / 2;
            drawable.setBounds(i4, i5, i2 + i4, dimension + i5);
            drawable.draw(canvas);
            drawable.setBounds(f1772c);
            try {
                return new kn(createBitmap);
            } catch (Exception e) {
                e.printStackTrace();
                m1494a();
                createBitmap.recycle();
                if (!hc.f1269b) {
                    return drawable;
                }
                ls.m1346c("Utilities catch1");
                return drawable;
            }
        } else if (dimension >= i || intrinsicHeight >= i2) {
            return drawable;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(f1770a, f1771b, Config.ARGB_8888);
            Canvas canvas2 = f1773d;
            canvas2.setBitmap(createBitmap2);
            f1772c.set(drawable.getBounds());
            i = (i - dimension) / 2;
            i2 = (i2 - intrinsicHeight) / 2;
            drawable.setBounds(i, i2, dimension + i, intrinsicHeight + i2);
            drawable.draw(canvas2);
            drawable.setBounds(f1772c);
            try {
                return new kn(createBitmap2);
            } catch (Exception e2) {
                e2.printStackTrace();
                m1494a();
                createBitmap2.recycle();
                if (!hc.f1269b) {
                    return drawable;
                }
                ls.m1346c("Utilities catch2");
                return drawable;
            }
        }
    }

    private static void m1494a() {
        System.gc();
        Runtime.getRuntime().gc();
    }
}
