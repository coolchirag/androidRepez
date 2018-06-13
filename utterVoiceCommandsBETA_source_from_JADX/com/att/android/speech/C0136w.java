package com.att.android.speech;

final class C0136w implements Runnable {
    final /* synthetic */ C0135v f586a;
    private int f587b = 0;
    private ai f588c = null;

    public C0136w(C0135v c0135v, ai aiVar) {
        this.f586a = c0135v;
        this.f588c = aiVar;
        this.f587b = 2;
    }

    public final void run() {
        this.f588c.mo62a(this.f587b);
    }
}
