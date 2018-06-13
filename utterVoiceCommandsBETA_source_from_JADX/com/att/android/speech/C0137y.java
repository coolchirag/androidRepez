package com.att.android.speech;

final class C0137y implements Runnable {
    final /* synthetic */ C0115x f589a;
    private int f590b = 0;
    private int f591c = 0;
    private int f592d = 0;
    private ai f593e = null;

    public C0137y(C0115x c0115x, ai aiVar, int i, int i2, int i3) {
        this.f589a = c0115x;
        this.f593e = aiVar;
        this.f590b = i;
        this.f591c = i2;
        this.f592d = i3;
    }

    public final void run() {
        ai aiVar = this.f593e;
        int i = this.f590b;
        int i2 = this.f591c;
        i2 = this.f592d;
        aiVar.mo63b(i);
    }
}
