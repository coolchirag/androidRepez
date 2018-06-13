package com.brandall.nutter;

final class ma implements Runnable {
    private final /* synthetic */ int f1705a;

    ma(int i) {
        this.f1705a = i;
    }

    public final void run() {
        try {
            Thread.sleep((long) this.f1705a);
            ServiceTTS.m925d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
