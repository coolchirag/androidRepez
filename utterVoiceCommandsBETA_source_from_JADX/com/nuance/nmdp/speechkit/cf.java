package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bi.C0404a;
import com.nuance.nmdp.speechkit.bi.C0405b;
import com.nuance.nmdp.speechkit.bi.C0406c;
import com.nuance.nmdp.speechkit.bi.C0412i;
import com.nuance.nmdp.speechkit.bi.C0413k;
import com.nuance.nmdp.speechkit.bi.C0415m;
import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0509c;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Vector;

public class cf implements ad, C0404a, C0406c, C0415m, C0417b, bz {
    private static final bj f2572a = C0478j.m2563a(cf.class);
    private bh f2573b;
    private bi f2574c;
    private bv f2575d;
    private ByteArrayOutputStream f2576e;
    private Vector f2577f;
    private boolean f2578g;
    private LinkedList<byte[]> f2579h;
    private boolean f2580i;
    private short f2581j = (short) -1;
    private Vector f2582k;
    private bk f2583l = null;
    private Object f2584m = new Object();
    private C0413k f2585n;

    public cf(bv bvVar, bh bhVar, ch chVar, Vector vector, bg bgVar) {
        this.f2573b = ((cn) chVar).m2233f();
        this.f2575d = bvVar;
        this.f2583l = ((cn) chVar).m2226a();
        this.f2582k = vector;
        this.f2574c = new AudioSystemOEM(this.f2583l, bhVar, vector);
        this.f2576e = new ByteArrayOutputStream();
        this.f2577f = new Vector();
        this.f2580i = false;
        this.f2578g = false;
        if (bgVar.equals(bg.f2453d)) {
            this.f2585n = C0413k.f2474d;
        } else if (bgVar.equals(bg.f2452c)) {
            this.f2585n = C0413k.f2473c;
        } else if (bgVar.equals(bg.f2451b)) {
            this.f2585n = C0413k.f2472b;
        } else if (bgVar.equals(bg.f2450a)) {
            this.f2585n = C0413k.f2471a;
        } else if (bgVar.equals(bg.f2454e)) {
            this.f2585n = C0413k.f2475e;
        }
        if (bu.m2186b(bhVar)) {
            this.f2579h = new LinkedList();
        }
    }

    private void m2238a(String str) {
        if (this.f2575d != null) {
            try {
                this.f2575d.mo218a(str);
            } catch (Throwable th) {
                if (f2572a.mo323e()) {
                    f2572a.mo322e("Got an exp while calling NMSPAudioPlaybackListener.playerUpdate(" + str + ")[" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    public final void mo190a() {
        if (f2572a.mo317b()) {
            f2572a.mo316b((Object) "PlayerImpl.start()");
        }
        bk bkVar = this.f2583l;
        C0416a c0416a = new C0416a((byte) 1, this);
        Thread currentThread = Thread.currentThread();
        this.f2583l.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    public final void mo227a(C0405b c0405b) {
        if (f2572a.mo317b()) {
            f2572a.mo316b((Object) "audio stop call back is called");
        }
        this.f2581j = (short) 5;
        m2238a(c0405b.equals(C0405b.f2465b) ? "PLAYBACK_ERROR" : "STOPPED");
    }

    public final void mo228a(C0405b c0405b, Object obj) {
        if (f2572a.mo317b()) {
            f2572a.mo316b((Object) "PlayerImpl.doneCallback()");
        }
        bk bkVar = this.f2583l;
        C0416a c0416a = new C0416a((byte) 7, new Object[]{c0405b, obj});
        Thread currentThread = Thread.currentThread();
        this.f2583l.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    public final void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        if (f2572a.mo317b()) {
            f2572a.mo316b("\nXMode handleMessage - [" + c0416a.f2477a + "]");
        }
        switch (c0416a.f2477a) {
            case (byte) 1:
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "PlayerImpl.handleStartPlayback()");
                }
                if (new C0509c(this.f2582k).m2665a()) {
                    this.f2573b = bu.m2187c(this.f2573b);
                }
                if (this.f2581j == (short) -1) {
                    this.f2581j = (short) 0;
                } else if (this.f2581j == (short) 2) {
                    this.f2581j = (short) 3;
                } else {
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handleStartPlayback() wrong state [state != STATE_INIT]!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                }
                if (this.f2581j != (short) 0 && this.f2581j != (short) 3) {
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handleStartPlayback() wrong state [state != STATE_STARTING]!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                } else if (this.f2581j != (short) 0) {
                    this.f2574c.mo307a();
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handleStartPlayback() audioSys.pausePlayback() return false!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                } else if (!this.f2574c.mo309a(this.f2585n, this, this)) {
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handleStartPlayback() audioSys.startPlayback() return false!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                } else {
                    return;
                }
            case (byte) 2:
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "PlayerImpl.handleStopPlayback()");
                }
                if (this.f2581j != (short) 5 && this.f2581j != (short) 4) {
                    this.f2581j = (short) 4;
                    this.f2574c.mo310b(this);
                    return;
                }
                return;
            case (byte) 3:
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "PlayerImpl.handlePausePlayback()");
                }
                if (this.f2581j == (short) 5 || this.f2581j == (short) 4) {
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handlePausePlayback() wrong state [state == " + this.f2581j + "]!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                }
                this.f2581j = (short) 2;
                this.f2574c.mo307a();
                this.f2581j = (short) 5;
                if (f2572a.mo323e()) {
                    f2572a.mo322e("PlayImpl.handleStartPlayback() audioSys.pausePlayback() return false!!!");
                }
                m2238a("PLAYBACK_ERROR");
                return;
            case (byte) 4:
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "PlayerImpl.handlePrevious()");
                }
                if (this.f2581j == (short) 5 || this.f2581j == (short) 4) {
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handlePausePlayback() wrong state [state == " + this.f2581j + "]!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                }
                this.f2574c.mo311b();
                this.f2581j = (short) 5;
                if (f2572a.mo323e()) {
                    f2572a.mo322e("PlayImpl.handleStartPlayback() audioSys.previousPlayback() return false!!!");
                }
                m2238a("PLAYBACK_ERROR");
                return;
            case (byte) 5:
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "PlayerImpl.handleNext()");
                }
                if (this.f2581j == (short) 5 || this.f2581j == (short) 4) {
                    this.f2581j = (short) 5;
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("PlayImpl.handlePausePlayback() wrong state [state == " + this.f2581j + "]!!!");
                    }
                    m2238a("PLAYBACK_ERROR");
                    return;
                }
                this.f2574c.mo312c();
                this.f2581j = (short) 5;
                if (f2572a.mo323e()) {
                    f2572a.mo322e("PlayImpl.handleStartPlayback() audioSys.nextPlayback() return false!!!");
                }
                m2238a("PLAYBACK_ERROR");
                return;
            case (byte) 6:
                Object[] objArr = (Object[]) c0416a.f2478b;
                byte[] bArr = (byte[]) objArr[0];
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "PlayerImpl.handleAddBuffer()");
                }
                synchronized (this.f2584m) {
                    if (bArr != null) {
                        bh bhVar = this.f2573b;
                        bu.m2183a();
                        if (bu.m2186b(this.f2573b)) {
                            this.f2579h.add(bArr);
                        } else {
                            this.f2576e.write(bArr, 0, bArr.length);
                            this.f2577f.addElement(bArr);
                        }
                    }
                    if (booleanValue) {
                        this.f2580i = true;
                    }
                }
                return;
            case (byte) 7:
                C0405b c0405b = (C0405b) ((Object[]) c0416a.f2478b)[0];
                if (f2572a.mo317b()) {
                    f2572a.mo316b((Object) "audio done call back is called");
                }
                if (c0405b.equals(C0405b.f2465b)) {
                    this.f2581j = (short) 5;
                    m2238a("PLAYBACK_ERROR");
                    return;
                }
                this.f2581j = (short) 5;
                m2238a("STOPPED");
                return;
            default:
                return;
        }
    }

    public final void mo219a(byte[] bArr, int i, int i2, boolean z) {
        if (f2572a.mo319c()) {
            f2572a.mo318c("addAudioBuf(" + bArr + ", " + z + ")");
        }
        if (bArr == null && !z) {
            throw new NullPointerException("buffer is null!");
        } else if (bArr != null && i < 0) {
            throw new IllegalArgumentException("offset cannot be negative!!!");
        } else if (bArr != null && i2 <= 0) {
            throw new IllegalArgumentException("length can only be positive!!!");
        } else if ((this.f2573b == bh.f2458c || this.f2573b == bh.f2457b || this.f2573b == bh.f2456a) && i2 > 153600) {
            m2238a("PLAYBACK_ERROR");
            a_();
        } else if (this.f2578g) {
            throw new ce("audio player is full, the last buffer has already apended!");
        } else {
            if (!this.f2578g && z) {
                this.f2578g = true;
            }
            Object obj = null;
            if (bArr != null) {
                obj = new byte[i2];
                System.arraycopy(bArr, i, obj, 0, i2);
            }
            Object obj2 = new Object[]{obj, new Boolean(z)};
            bk bkVar = this.f2583l;
            C0416a c0416a = new C0416a((byte) 6, obj2);
            Thread currentThread = Thread.currentThread();
            this.f2583l.mo329a();
            bkVar.mo327a(c0416a, this, currentThread);
        }
    }

    public final void mo229a(byte[] bArr, Object obj, C0412i c0412i, C0412i c0412i2, Float f) {
        Object obj2;
        int i;
        if (f2572a.mo317b()) {
            f2572a.mo316b("audio call back is called time: [" + System.currentTimeMillis() + "]");
        }
        if (this.f2581j == (short) 0) {
            this.f2581j = (short) 1;
            m2238a("STARTED");
        }
        bh bhVar = this.f2573b;
        bu.m2183a();
        if (bu.m2186b(this.f2573b)) {
            obj2 = (byte[]) obj;
        } else {
            bhVar = this.f2573b;
            bu.m2185b();
            if (!bu.m2184a(this.f2573b)) {
                obj2 = null;
            }
        }
        int length = obj2.length;
        if (!bu.m2186b(this.f2573b)) {
            synchronized (this.f2584m) {
                if (this.f2576e.size() <= 0) {
                    i = this.f2580i ? -1 : 0;
                } else {
                    Object toByteArray = this.f2576e.toByteArray();
                    try {
                        this.f2576e.close();
                    } catch (Exception e) {
                        System.out.println("got an exception [" + e.getClass().getName() + "] message [" + e.getMessage() + "]");
                    }
                    this.f2576e = null;
                    this.f2576e = new ByteArrayOutputStream();
                    bh bhVar2;
                    if (length < toByteArray.length) {
                        bhVar2 = this.f2573b;
                        bu.m2183a();
                        if (bu.m2184a(this.f2573b)) {
                            i = length;
                        }
                        i = 0;
                    } else {
                        bhVar2 = this.f2573b;
                        bu.m2183a();
                        if (bu.m2184a(this.f2573b)) {
                            i = toByteArray.length;
                        }
                        i = 0;
                    }
                    if (i < toByteArray.length) {
                        this.f2576e.write(toByteArray, i, toByteArray.length - i);
                    }
                    if (f2572a.mo317b()) {
                        f2572a.mo316b("feed oem audio data len [" + i + "] complete buffer size [" + toByteArray.length + "]");
                    }
                    System.arraycopy(toByteArray, 0, obj2, 0, i);
                }
            }
        } else if (this.f2579h.isEmpty()) {
            i = this.f2580i ? -1 : 0;
        } else {
            try {
                byte[] bArr2 = (byte[]) this.f2579h.removeFirst();
                if (length < bArr2.length) {
                    if (f2572a.mo323e()) {
                        f2572a.mo322e("Buffer is too small to contain the Speex buffer.");
                    }
                    i = 0;
                } else {
                    int length2 = bArr2.length;
                    System.arraycopy(bArr2, 0, obj2, 0, length2);
                    i = length2;
                }
            } catch (NoSuchElementException e2) {
                i = 0;
            }
        }
        if (i > 0) {
            m2238a("BUFFER_PLAYED");
        }
        bh bhVar3 = this.f2573b;
        bu.m2183a();
        if (bu.m2186b(this.f2573b)) {
            c0412i2.f2470a = i;
            return;
        }
        bhVar3 = this.f2573b;
        bu.m2185b();
        if (bu.m2184a(this.f2573b)) {
            c0412i.f2470a = i;
        }
    }

    public final void a_() {
        if (f2572a.mo317b()) {
            f2572a.mo316b((Object) "PlayerImpl.start()");
        }
        bk bkVar = this.f2583l;
        C0416a c0416a = new C0416a((byte) 2, this);
        Thread currentThread = Thread.currentThread();
        this.f2583l.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }
}
