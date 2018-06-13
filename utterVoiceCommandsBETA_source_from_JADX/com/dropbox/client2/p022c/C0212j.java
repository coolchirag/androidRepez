package com.dropbox.client2.p022c;

import java.util.concurrent.TimeUnit;
import winterwell.jtwitter.TwitterStream;

class C0212j extends Thread {
    private static C0212j f1872d = null;
    private final C0208f f1873a;
    private final int f1874b = 20;
    private final int f1875c = TwitterStream.MAX_USERS;

    private C0212j(C0208f c0208f) {
        this.f1873a = c0208f;
    }

    public static synchronized void m1545a(C0208f c0208f) {
        synchronized (C0212j.class) {
            if (f1872d == null) {
                C0212j c0212j = new C0212j(c0208f);
                f1872d = c0212j;
                c0212j.start();
            }
        }
    }

    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    wait((long) this.f1875c);
                }
                this.f1873a.closeExpiredConnections();
                this.f1873a.closeIdleConnections((long) this.f1874b, TimeUnit.SECONDS);
                synchronized (C0212j.class) {
                    if (this.f1873a.getConnectionsInPool() == 0) {
                        f1872d = null;
                        return;
                    }
                }
            } catch (InterruptedException e) {
                f1872d = null;
                return;
            }
        }
    }
}
