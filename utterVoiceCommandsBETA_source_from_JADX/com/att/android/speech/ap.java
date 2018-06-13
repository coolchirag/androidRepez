package com.att.android.speech;

import android.media.AmrInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class ap extends Thread {
    ByteArrayOutputStream f490a = new ByteArrayOutputStream();
    ByteArrayInputStream f491b = null;
    final /* synthetic */ al f492c;
    private byte[] f493d = null;
    private int f494e = -1;
    private volatile boolean f495f = false;

    public ap(al alVar, byte[] bArr, int i) {
        this.f492c = alVar;
        this.f493d = bArr;
        this.f494e = i;
    }

    public final void m394a() {
        this.f495f = true;
    }

    public final void run() {
        this.f491b = new ByteArrayInputStream(this.f493d);
        AmrInputStream a = al.m374a(this.f491b);
        this.f490a.reset();
        try {
            for (int read = a.read(); read >= 0 && !this.f495f; read = a.read()) {
                this.f490a.write(read);
            }
            a.close();
        } catch (IOException e) {
        }
        this.f492c.f453D.add(this.f494e, this.f490a.toByteArray());
    }
}
