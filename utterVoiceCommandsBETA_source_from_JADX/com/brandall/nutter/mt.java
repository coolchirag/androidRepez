package com.brandall.nutter;

final class mt implements Runnable {
    final /* synthetic */ mq f1740a;
    private final /* synthetic */ Exception f1741b;

    mt(mq mqVar, Exception exception) {
        this.f1740a = mqVar;
        this.f1741b = exception;
    }

    public final void run() {
        if (this.f1740a.f1733a != null) {
            this.f1740a.f1733a.mo91a(null, this.f1741b);
        }
    }
}
