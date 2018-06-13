package com.att.android.speech;

import android.content.Context;
import android.media.AmrInputStream;
import android.media.AudioRecord;
import android.os.Binder;
import android.os.Handler;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

final class al extends C0115x {
    private Handler f450A = new Handler();
    private Context f451B = null;
    private ConcurrentLinkedQueue<byte[]> f452C = new ConcurrentLinkedQueue();
    private volatile ArrayList<byte[]> f453D = new ArrayList();
    private volatile int f454E = -1;
    private volatile int f455F = -1;
    private Handler f456G = null;
    private ai f457H = null;
    private C0116f f458I = null;
    private aj f459J;
    private boolean f460K = false;
    private int f461L = 0;
    private boolean f462M = false;
    private an f463N = new an(this);
    private int f464O = -1;
    private int f465P = 6400;
    private byte[] f466Q = new byte[this.f465P];
    private ConcurrentLinkedQueue<ap> f467R = new ConcurrentLinkedQueue();
    protected aq f468l = null;
    protected boolean f469m = false;
    protected PipedInputStream f470n = null;
    protected PipedOutputStream f471o = null;
    protected long f472p = 100;
    protected int f473q = 0;
    protected long f474r = 0;
    ao f475s = new ao(this);
    ap f476t = null;
    private AudioRecord f477u;
    private int f478v = 8000;
    private int f479w = 2;
    private int f480x = 2;
    private int f481y = 0;
    private Runnable f482z;

    al(aj ajVar, ai aiVar, C0116f c0116f, Handler handler, PipedInputStream pipedInputStream, Context context) {
        this.f451B = context;
        this.f457H = aiVar;
        this.f458I = c0116f;
        this.f456G = handler;
        this.f459J = ajVar;
        this.g = 32767;
        this.h = 1500;
        this.f470n = pipedInputStream;
        this.f471o = new PipedOutputStream(this.f470n);
    }

    public static AmrInputStream m374a(InputStream inputStream) {
        return new AmrInputStream(inputStream);
    }

    static /* synthetic */ void m377a(al alVar, byte[] bArr) {
        if (alVar.f480x == 2) {
            for (int i = 0; i < bArr.length - 1; i += 32) {
                short abs = (short) Math.abs((short) ((bArr[i + 1] << 8) + (bArr[i] & 255)));
                if (alVar.f461L < abs) {
                    alVar.f461L = abs;
                }
            }
        }
        if (alVar.f466Q == null || alVar.f464O < 0) {
            alVar.f466Q = new byte[alVar.f465P];
            alVar.f464O = 0;
        } else if (alVar.f464O + bArr.length > alVar.f466Q.length) {
            alVar.f454E++;
            alVar.f453D.add(alVar.f454E, null);
            alVar.f476t = new ap(alVar, alVar.f466Q, alVar.f454E);
            alVar.f476t.start();
            alVar.f467R.add(alVar.f476t);
            alVar.f466Q = new byte[alVar.f465P];
            alVar.f464O = 0;
        }
        System.arraycopy(bArr, 0, alVar.f466Q, alVar.f464O, bArr.length);
        alVar.f464O += bArr.length;
    }

    private void m383f() {
        ac.m345a("StreamingAudioRecorder", "StopRecorder was called");
        this.f450A.removeCallbacks(this.f482z);
        ac.m345a("StreamingAudioRecorder", "Stopped the recorder");
        if (this.f468l != null && this.f468l.isAlive()) {
            this.f468l.m395a();
        }
        if (this.f469m) {
            this.f469m = false;
            if (!this.f && this.f459J.f431e) {
                this.f458I.mo61a(new C0119d(C0120e.INAUDIBLE, "No sound was detected."));
                this.f457H.mo62a(-3);
            } else if (this.f474r < ((long) this.f459J.f429c)) {
                this.f458I.mo61a(new C0119d(C0120e.BELOW_MINIMUM_LENGTH, "Didn't catch that.  Try again."));
                this.f457H.mo62a(-3);
            }
        }
        this.f457H.mo62a(2);
    }

    protected final boolean mo57a() {
        if (this.f477u == null) {
            this.f481y = AudioRecord.getMinBufferSize(this.f478v, this.f479w, this.f480x) * 2;
            ac.m345a("StreamingAudioRecorder", "buffer size is " + this.f481y);
            this.f477u = new AudioRecord(0, this.f478v, this.f479w, this.f480x, this.f481y);
        }
        this.j = Long.MAX_VALUE;
        this.f468l = new aq(this);
        this.f468l.start();
        this.f469m = true;
        this.f457H.mo62a(1);
        this.f482z = new am(this);
        this.f450A.postDelayed(this.f482z, this.f472p);
        return true;
    }

    public final boolean mo58b() {
        return true;
    }

    public final void mo59c() {
        mo60d();
        this.e = true;
    }

    public final void mo60d() {
        if (this.f469m) {
            m383f();
        }
        if (!this.f462M) {
            try {
                if (this.f477u == null || this.f477u.getState() != 1) {
                    ac.m345a("StreamingAudioRecorder", "Audio recorder state was NOT INITALIZED");
                } else {
                    ac.m345a("StreamingAudioRecorder", "Audio Recorder state was INITIALIZED");
                    this.f477u.stop();
                    this.f477u.release();
                    this.f477u = null;
                    ac.m345a("StreamingAudioRecorder", "Audio recorder should now be stopped");
                }
                ap apVar;
                if (this.e) {
                    apVar = (ap) this.f467R.poll();
                    while (apVar != null) {
                        apVar.m394a();
                        apVar = (ap) this.f467R.poll();
                    }
                    this.f463N.m392a();
                } else {
                    apVar = (ap) this.f467R.poll();
                    ac.m345a("StreamingAudioRecorder", "Polling for an encoding thread.");
                    while (apVar != null) {
                        ac.m345a("StreamingAudioRecorder", "Encoding thread != null -- " + apVar.getName());
                        do {
                        } while (apVar.isAlive());
                        ac.m345a("StreamingAudioRecorder", "Polling for an encoding thread.");
                        apVar = (ap) this.f467R.poll();
                    }
                    ac.m345a("StreamingAudioRecorder", "All out of encoding threads.");
                }
                this.f475s.m393a();
                Binder.flushPendingCommands();
                this.f462M = true;
            } catch (IllegalStateException e) {
                ac.m346b("StreamingAudioRecorder", "The audio recorder was called twice.");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void m391e() {
        /*
        r13 = this;
        r11 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r10 = 1;
        r0 = "StreamingAudioRecorder";
        r1 = "onAudioReceived() called";
        com.att.android.speech.ac.m345a(r0, r1);
        r0 = r13.f460K;
        if (r0 != 0) goto L_0x0013;
    L_0x0011:
        r13.f460K = r10;
    L_0x0013:
        r3 = r13.f461L;
        r0 = r13.f461L;
        if (r0 <= 0) goto L_0x0023;
    L_0x0019:
        r0 = r13.f461L;
        r0 = r0 + -5000;
        r13.f461L = r0;
        r0 = r13.f461L;
        if (r0 >= 0) goto L_0x0026;
    L_0x0023:
        r0 = 0;
        r13.f461L = r0;
    L_0x0026:
        r0 = android.os.SystemClock.uptimeMillis();
        r4 = r13.j;
        r4 = r0 - r4;
        r13.f474r = r4;
        if (r3 <= 0) goto L_0x0038;
    L_0x0032:
        r2 = r13.h;
        if (r3 >= r2) goto L_0x0038;
    L_0x0036:
        r13.h = r3;
    L_0x0038:
        r2 = r13.g;
        if (r3 <= r2) goto L_0x003e;
    L_0x003c:
        r13.g = r3;
    L_0x003e:
        r4 = (double) r3;
        r2 = r13.g;
        r6 = (double) r2;
        r4 = r4 / r6;
        r2 = r13.h;
        r2 = r3 / r2;
        r6 = r13.f474r;
        r8 = r13.f459J;
        r8 = r8.f427a;
        r8 = (long) r8;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x006d;
    L_0x0052:
        r13.d = r10;
        r13.m383f();
    L_0x0057:
        r0 = r13.f456G;
        if (r0 == 0) goto L_0x006c;
    L_0x005b:
        r6 = r13.f456G;
        r0 = new com.att.android.speech.y;
        r2 = r13.f457H;
        r4 = r13.h;
        r5 = r13.g;
        r1 = r13;
        r0.<init>(r1, r2, r3, r4, r5);
        r6.post(r0);
    L_0x006c:
        return;
    L_0x006d:
        r6 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        if (r3 >= r6) goto L_0x00c8;
    L_0x0071:
        r6 = c;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x007b;
    L_0x0077:
        r4 = b;
        if (r2 >= r4) goto L_0x0057;
    L_0x007b:
        r4 = r13.i;
        r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r2 == 0) goto L_0x00c5;
    L_0x0081:
        r2 = r13.f459J;
        r2 = r2.f431e;
        if (r2 == 0) goto L_0x00a8;
    L_0x0087:
        r2 = r13.f;
        if (r2 != 0) goto L_0x00a8;
    L_0x008b:
        r4 = r13.f474r;
        r2 = r13.f459J;
        r2 = r2.f429c;
        r6 = (long) r2;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x0057;
    L_0x0096:
        r2 = r13.f459J;
        r2 = r2.f430d;
        r4 = (long) r2;
        r6 = r13.i;
        r0 = r0 - r6;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x0057;
    L_0x00a2:
        r13.d = r10;
        r13.mo60d();
        goto L_0x0057;
    L_0x00a8:
        r4 = r13.f474r;
        r2 = r13.f459J;
        r2 = r2.f429c;
        r6 = (long) r2;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x0057;
    L_0x00b3:
        r2 = r13.f459J;
        r2 = r2.f428b;
        r4 = (long) r2;
        r6 = r13.i;
        r0 = r0 - r6;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x0057;
    L_0x00bf:
        r13.d = r10;
        r13.mo60d();
        goto L_0x0057;
    L_0x00c5:
        r13.i = r0;
        goto L_0x0057;
    L_0x00c8:
        r13.f = r10;
        r13.i = r11;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.att.android.speech.al.e():void");
    }
}
