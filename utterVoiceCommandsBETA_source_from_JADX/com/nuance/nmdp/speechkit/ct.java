package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import java.io.ByteArrayOutputStream;

public class ct extends dd implements C0417b, bz {
    private static final bj f2652a = C0478j.m2563a(ct.class);
    private int f2653b;
    private co f2654c;
    private boolean f2655d = false;
    private bk f2656e;

    public ct(String str, co coVar, bk bkVar) {
        super(str, (byte) 1);
        this.f2654c = coVar;
        this.f2656e = bkVar;
        this.f2653b = coVar.m2283a();
        C0416a c0416a = new C0416a((byte) 1, null);
        Thread currentThread = Thread.currentThread();
        bkVar.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    protected final int m2355a() {
        return this.f2653b;
    }

    public final void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        switch (c0416a.f2477a) {
            case (byte) 1:
                this.f2654c.m2285a(this.f2653b);
                return;
            case (byte) 2:
                Object[] objArr = (Object[]) c0416a.f2478b;
                byte[] bArr = (byte[]) objArr[0];
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                if (bArr != null) {
                    if (bu.m2186b(this.f2654c.m2301g())) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        if (bArr.length < 128) {
                            byteArrayOutputStream.write(bArr.length & 127);
                        } else if (bArr.length < 16384) {
                            byteArrayOutputStream.write(((bArr.length >> 7) & 127) | 128);
                            byteArrayOutputStream.write(bArr.length & 127);
                        } else if (bArr.length < 2097152) {
                            byteArrayOutputStream.write(((bArr.length >> 14) & 127) | 128);
                            byteArrayOutputStream.write(((bArr.length >> 7) & 127) | 128);
                            byteArrayOutputStream.write(bArr.length & 127);
                        } else if (bArr.length < 268435456) {
                            byteArrayOutputStream.write(((bArr.length >> 21) & 127) | 128);
                            byteArrayOutputStream.write(((bArr.length >> 14) & 127) | 128);
                            byteArrayOutputStream.write(((bArr.length >> 7) & 127) | 128);
                            byteArrayOutputStream.write(bArr.length & 127);
                        } else {
                            f2652a.mo322e("buffer size is too big!");
                            return;
                        }
                        byteArrayOutputStream.write(bArr, 0, bArr.length);
                        this.f2654c.m2294a(byteArrayOutputStream.toByteArray(), this.f2653b);
                    } else {
                        this.f2654c.m2294a(bArr, this.f2653b);
                    }
                }
                if (booleanValue) {
                    this.f2654c.m2295b(this.f2653b);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void mo219a(byte[] bArr, int i, int i2, boolean z) {
        if (bArr == null && !z) {
            f2652a.mo322e("PDXAudioParam.addAudioBuf() in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
            throw new NullPointerException("in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
        } else if (bArr != null && i < 0) {
            f2652a.mo322e("PDXAudioParam.addAudioBuf() the offset of the \"buffer\" is less than 0");
            throw new IllegalArgumentException("the offset of the \"buffer\" is less than 0");
        } else if (bArr != null && i2 <= 0) {
            f2652a.mo322e("PDXAudioParam.addAudioBuf() the indicated length of the \"buffer\" is less than 1 byte");
            throw new IllegalArgumentException("the indicated length of the \"buffer\" is less than 1 byte");
        } else if (this.f2655d) {
            f2652a.mo322e("PDXAudioParam.addAudioBuf() last audio buffer already added!");
            throw new ce("last audio buffer already added!");
        } else {
            if (z) {
                this.f2655d = true;
            }
            Object obj = null;
            if (bArr != null) {
                obj = new byte[i2];
                System.arraycopy(bArr, i, obj, 0, i2);
            }
            Object obj2 = new Object[]{obj, new Boolean(z)};
            bk bkVar = this.f2656e;
            C0416a c0416a = new C0416a((byte) 2, obj2);
            Thread currentThread = Thread.currentThread();
            this.f2656e.mo329a();
            bkVar.mo327a(c0416a, this, currentThread);
        }
    }
}
