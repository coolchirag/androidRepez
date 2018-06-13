package com.google.ads.util;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(4)
public final class C0298l {
    static int m1877a(Context context, float f, int i) {
        return (context.getApplicationInfo().flags & 8192) != 0 ? (int) (((float) i) / f) : i;
    }
}
