package com.google.ads.p028a;

import android.content.Context;
import com.google.ads.C0237d;

public final class C0229a {
    private C0237d f1934a;
    private boolean f1935b;
    private boolean f1936c;

    public C0229a(C0237d c0237d, Context context, boolean z) {
        this.f1934a = c0237d;
        this.f1936c = z;
        if (context == null) {
            this.f1935b = true;
        } else {
            this.f1935b = c0237d.m1643b(context);
        }
    }
}
