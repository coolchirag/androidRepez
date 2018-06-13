package com.brandall.nutter;

import android.content.Context;

final class lz implements Runnable {
    private final /* synthetic */ int f1702a;
    private final /* synthetic */ Context f1703b;

    lz(int i, Context context) {
        this.f1702a = i;
        this.f1703b = context;
    }

    public final void run() {
        try {
            Thread.sleep((long) this.f1702a);
            if (ServiceTTS.m925d() && ServiceTTS.f854f) {
                lt.m1354a(this.f1703b, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
