package com.dropbox.client2;

import java.io.FilterOutputStream;
import java.io.OutputStream;

final class C0221h extends FilterOutputStream {
    final /* synthetic */ C0220g f1899a;
    private long f1900b = 0;
    private long f1901c = 0;
    private long f1902d = 0;

    public C0221h(C0220g c0220g, OutputStream outputStream) {
        this.f1899a = c0220g;
        super(outputStream);
        c0220g.f1897a;
        this.f1901c = 500;
    }

    public final void write(int i) {
        super.write(i);
        this.f1902d++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1900b > this.f1901c) {
            this.f1900b = currentTimeMillis;
            C0154f a = this.f1899a.f1897a;
            long j = this.f1902d;
            this.f1899a.f1898b;
            a.mo92a(j);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.f1902d += (long) i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1900b > this.f1901c) {
            this.f1900b = currentTimeMillis;
            C0154f a = this.f1899a.f1897a;
            long j = this.f1902d;
            this.f1899a.f1898b;
            a.mo92a(j);
        }
    }
}
