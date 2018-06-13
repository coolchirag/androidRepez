package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.media.AudioTrack;
import android.media.AudioTrack.OnPlaybackPositionUpdateListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.nuance.nmdp.speechkit.C0478j;
import com.nuance.nmdp.speechkit.bh;
import com.nuance.nmdp.speechkit.bi;
import com.nuance.nmdp.speechkit.bi.C0404a;
import com.nuance.nmdp.speechkit.bi.C0405b;
import com.nuance.nmdp.speechkit.bi.C0406c;
import com.nuance.nmdp.speechkit.bi.C0407d;
import com.nuance.nmdp.speechkit.bi.C0408e;
import com.nuance.nmdp.speechkit.bi.C0409f;
import com.nuance.nmdp.speechkit.bi.C0410g;
import com.nuance.nmdp.speechkit.bi.C0411h;
import com.nuance.nmdp.speechkit.bi.C0412i;
import com.nuance.nmdp.speechkit.bi.C0413k;
import com.nuance.nmdp.speechkit.bi.C0414l;
import com.nuance.nmdp.speechkit.bi.C0415m;
import com.nuance.nmdp.speechkit.bj;
import com.nuance.nmdp.speechkit.bk;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.bn;
import com.nuance.nmdp.speechkit.cb;
import com.nuance.nmdp.speechkit.cb.C0445a;
import com.nuance.nmdp.speechkit.dy;
import java.util.Vector;

public class AudioSystemOEM implements bi, C0417b {
    private static Object f2921B = new Object();
    private static Object f2922C = new Object();
    private static Object f2923D = new Object();
    private static final Integer f2924O = new Integer(1);
    private static final Integer f2925P = new Integer(2);
    private static final Integer f2926Q = new Integer(3);
    public static Object f2927a = new Object();
    public static Object f2928b = new Object();
    public static int f2929c = 0;
    public static int f2930d = 0;
    private C0510d f2931A;
    private EndPointerOEM f2932E = null;
    private short[] f2933F;
    private byte[] f2934G;
    private int f2935H;
    private int f2936I;
    private int f2937J;
    private C0508b f2938K;
    private boolean f2939L = false;
    private bk f2940M;
    private boolean f2941N = false;
    private Context f2942R = null;
    private dy f2943S = null;
    private bh f2944T;
    private bj f2945e = C0478j.m2563a(getClass());
    private int f2946f;
    private int f2947g;
    private int f2948h;
    private int f2949i;
    private int f2950j;
    private int f2951k;
    private int f2952l;
    private int f2953m;
    private int f2954n;
    private int f2955o;
    private int f2956p;
    private int f2957q;
    private int f2958r;
    private int f2959s;
    private int f2960t;
    private int f2961u;
    private int f2962v;
    private int f2963w;
    private int f2964x;
    private int f2965y;
    private C0514e f2966z;

    public final class C0507a extends Exception {
        public C0507a(String str) {
            super(str);
        }
    }

    public final class C0508b {
        public static C0508b f2883a = new C0508b();
        public static C0508b f2884b = new C0508b();

        private C0508b() {
        }
    }

    public final class C0509c {
        private bj f2885a = C0478j.m2563a(getClass());
        private Context f2886b = null;
        private boolean f2887c = false;

        public C0509c(Vector vector) {
            if (vector != null) {
                for (int i = 0; i < vector.size(); i++) {
                    cb cbVar = (cb) vector.get(i);
                    String a = cbVar.m2234a();
                    if (cbVar.m2237d() == C0445a.f2559a) {
                        if (a.equals("Android_Context")) {
                            this.f2886b = (Context) cbVar.m2236c();
                            if (this.f2885a.mo317b()) {
                                this.f2885a.mo316b("NMSP_DEFINES_ANDROID_CONTEXT is passed in as" + this.f2886b);
                            }
                        } else if (a.equals("Disable_Bluetooth") && new String(cbVar.m2235b()).equalsIgnoreCase("TRUE")) {
                            if (this.f2885a.mo317b()) {
                                this.f2885a.mo316b((Object) "Disable_Bluetooth is true.");
                            }
                            this.f2887c = true;
                        }
                    }
                }
            }
        }

        public final boolean m2665a() {
            if (this.f2887c) {
                return false;
            }
            if (this.f2886b != null) {
                dy a = dy.m2457a(this.f2886b);
                boolean b = a.m2461b();
                a.m2462c();
                return b;
            } else if (!this.f2885a.mo323e()) {
                return false;
            } else {
                this.f2885a.mo322e("ANDROID_CONTEXT parameter is not passed in!!!");
                return false;
            }
        }
    }

    final class C0510d implements OnRecordPositionUpdateListener, C0417b {
        private bj f2888a;
        private AudioRecord f2889b;
        private boolean f2890c;
        private C0404a f2891d;
        private C0407d f2892e;
        private C0414l f2893f;
        private C0408e f2894g;
        private C0409f f2895h;
        private C0415m f2896i;
        private C0410g f2897j;
        private boolean f2898k;
        private boolean f2899l;
        private int f2900m;
        private /* synthetic */ AudioSystemOEM f2901n;

        private C0510d(AudioSystemOEM audioSystemOEM) {
            this.f2901n = audioSystemOEM;
            this.f2888a = C0478j.m2563a(getClass());
            this.f2891d = null;
            this.f2892e = null;
            this.f2893f = null;
            this.f2894g = null;
            this.f2895h = null;
            this.f2896i = null;
            this.f2897j = null;
            this.f2898k = false;
            this.f2899l = false;
            this.f2900m = 0;
        }

        private static float m2666a(short[] sArr) {
            long j = 0;
            for (short s : sArr) {
                long j2 = (long) s;
                j += (j2 * j2) >> 9;
            }
            double d = ((double) j) / 1.073741824E9d;
            if (d < 1.0E-9d) {
                d = -90.0d;
            } else {
                d = Math.log10(d) * 10.0d;
                if (d > 0.0d) {
                    d = 0.0d;
                }
            }
            return (float) d;
        }

        private void m2667a(C0507a c0507a) {
            if (this.f2888a.mo323e()) {
                this.f2888a.mo322e(c0507a.getMessage());
            }
            if (this.f2890c) {
                this.f2889b.stop();
                synchronized (AudioSystemOEM.f2921B) {
                    this.f2890c = false;
                    this.f2889b.release();
                    this.f2889b = null;
                }
                this.f2897j.mo234d();
                if (this.f2901n.f2938K == C0508b.f2883a) {
                    synchronized (AudioSystemOEM.f2927a) {
                        AudioSystemOEM.encodeCleanupSpeex();
                    }
                }
                if (this.f2901n.f2943S != null) {
                    this.f2901n.f2943S.mo281e();
                    this.f2901n.m2707j();
                }
                if (this.f2896i != null) {
                    this.f2896i.mo227a(C0405b.f2465b);
                }
            }
        }

        public final void m2669a(C0408e c0408e) {
            this.f2894g = c0408e;
            bk p = this.f2901n.f2940M;
            Object obj = new Object[]{AudioSystemOEM.f2924O};
            Object b = this.f2901n.f2940M.mo330b();
            this.f2901n.f2940M.mo329a();
            p.mo327a(obj, this, b);
        }

        public final void m2670a(C0409f c0409f) {
            this.f2895h = c0409f;
            bk p = this.f2901n.f2940M;
            Object obj = new Object[]{AudioSystemOEM.f2925P};
            Object b = this.f2901n.f2940M.mo330b();
            this.f2901n.f2940M.mo329a();
            p.mo327a(obj, this, b);
        }

        public final void m2671a(C0415m c0415m, C0407d c0407d) {
            Object obj = null;
            if (this.f2890c) {
                try {
                    Thread.sleep((long) this.f2901n.f2961u);
                    if (this.f2890c) {
                        this.f2889b.stop();
                        int i = 1;
                    }
                    synchronized (AudioSystemOEM.f2921B) {
                        this.f2890c = false;
                        if (obj != null) {
                            this.f2889b.release();
                            this.f2889b = null;
                        }
                    }
                    if (obj != null) {
                        if (this.f2901n.f2938K == C0508b.f2883a) {
                            synchronized (AudioSystemOEM.f2927a) {
                                AudioSystemOEM.encodeCleanupSpeex();
                            }
                        }
                    }
                } catch (IllegalStateException e) {
                    if (this.f2888a.mo317b()) {
                        this.f2888a.mo316b((Object) "Could not stop audioRecord.");
                    }
                } catch (Exception e2) {
                }
            }
            if (this.f2901n.f2943S != null) {
                this.f2901n.f2943S.mo281e();
                this.f2901n.m2707j();
            }
            if (c0407d != null) {
                c0407d.mo230a();
            }
            if (c0415m != null) {
                c0415m.mo227a(C0405b.f2464a);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo225a(java.lang.Object r13, java.lang.Object r14) {
            /*
            r12 = this;
            r11 = 1;
            r1 = 0;
            r10 = 0;
            r13 = (java.lang.Object[]) r13;
            r0 = r13[r10];
            r0 = (java.lang.Integer) r0;
            r0 = r0.intValue();
            r2 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2924O;
            r2 = r2.intValue();
            if (r0 != r2) goto L_0x0032;
        L_0x0017:
            r0 = r12.f2898k;
            if (r0 != 0) goto L_0x0031;
        L_0x001b:
            r12.f2898k = r11;
            r0 = r12.f2901n;
            r0 = r0.f2932E;
            r0.m2738b();
            r12.f2899l = r10;
            r0 = r12.f2894g;
            if (r0 == 0) goto L_0x0031;
        L_0x002c:
            r0 = r12.f2894g;
            r0.mo232b();
        L_0x0031:
            return;
        L_0x0032:
            r0 = r13[r10];
            r0 = (java.lang.Integer) r0;
            r0 = r0.intValue();
            r2 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2925P;
            r2 = r2.intValue();
            if (r0 != r2) goto L_0x0054;
        L_0x0044:
            r0 = r12.f2898k;
            if (r0 == 0) goto L_0x0031;
        L_0x0048:
            r12.f2898k = r10;
            r0 = r12.f2895h;
            if (r0 == 0) goto L_0x0031;
        L_0x004e:
            r0 = r12.f2895h;
            r0.mo233c();
            goto L_0x0031;
        L_0x0054:
            r0 = r13[r10];
            r0 = (java.lang.Integer) r0;
            r0 = r0.intValue();
            r2 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2926Q;
            r2 = r2.intValue();
            if (r0 != r2) goto L_0x0031;
        L_0x0066:
            r0 = r13[r11];
            r0 = (java.lang.Integer) r0;
            r4 = r0.intValue();
            r0 = 2;
            r0 = r13[r0];
            r2 = r12.f2890c;
            if (r2 == 0) goto L_0x0031;
        L_0x0075:
            r2 = r12.f2901n;
            r2 = r2.f2938K;
            r3 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0508b.f2883a;
            if (r2 != r3) goto L_0x01b9;
        L_0x007f:
            r2 = r12.f2901n;
            r2 = r2.f2965y;
            r2 = new byte[r2];
            r3 = r12.f2890c;
            if (r3 == 0) goto L_0x0031;
        L_0x008b:
            r0 = (short[]) r0;
            if (r4 >= 0) goto L_0x00a7;
        L_0x008f:
            r0 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;
            r1 = new java.lang.StringBuilder;
            r2 = "Call to AudioRecord.read() failed with code: ";
            r1.<init>(r2);
            r1 = r1.append(r4);
            r1 = r1.toString();
            r0.<init>(r1);
            r12.m2667a(r0);
            goto L_0x0031;
        L_0x00a7:
            if (r4 != 0) goto L_0x00ba;
        L_0x00a9:
            r0 = r12.f2888a;
            r0 = r0.mo317b();
            if (r0 == 0) goto L_0x0031;
        L_0x00b1:
            r0 = r12.f2888a;
            r1 = "AudioRecorder has no audio.";
            r0.mo316b(r1);
            goto L_0x0031;
        L_0x00ba:
            r3 = com.nuance.nmsp.client.sdk.oem.EndPointerOEM.C0515a.f2967a;
            r5 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2927a;
            monitor-enter(r5);
            r6 = r12.f2890c;	 Catch:{ all -> 0x00c6 }
            if (r6 != 0) goto L_0x00c9;
        L_0x00c3:
            monitor-exit(r5);	 Catch:{ all -> 0x00c6 }
            goto L_0x0031;
        L_0x00c6:
            r0 = move-exception;
            monitor-exit(r5);
            throw r0;
        L_0x00c9:
            r6 = r12.f2901n;	 Catch:{ all -> 0x00c6 }
            r6 = r6.f2965y;	 Catch:{ all -> 0x00c6 }
            r7 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.encodeSpeex(r0, r2, r6);	 Catch:{ all -> 0x00c6 }
            r6 = r12.f2898k;	 Catch:{ all -> 0x00c6 }
            if (r6 == 0) goto L_0x0236;
        L_0x00d7:
            r6 = r12.f2899l;	 Catch:{ all -> 0x00c6 }
            if (r6 != 0) goto L_0x0236;
        L_0x00db:
            r3 = r12.f2901n;	 Catch:{ all -> 0x00c6 }
            r3 = r3.f2932E;	 Catch:{ all -> 0x00c6 }
            r3 = r3.m2736a();	 Catch:{ all -> 0x00c6 }
            r6 = r3;
        L_0x00e6:
            monitor-exit(r5);	 Catch:{ all -> 0x00c6 }
            if (r7 >= 0) goto L_0x0106;
        L_0x00e9:
            r0 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;
            r1 = new java.lang.StringBuilder;
            r2 = "Call to encodeSpeex() failed with code: ";
            r1.<init>(r2);
            r2 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.speexCodeToString(r7);
            r1 = r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            r12.m2667a(r0);
            goto L_0x0031;
        L_0x0106:
            r3 = r12.f2888a;
            r3 = r3.mo317b();
            if (r3 == 0) goto L_0x0142;
        L_0x010e:
            r3 = r12.f2888a;
            r5 = new java.lang.StringBuilder;
            r8 = "RECORDING: Sample #";
            r5.<init>(r8);
            r8 = r12.f2900m;
            r9 = r8 + 1;
            r12.f2900m = r9;
            r5 = r5.append(r8);
            r8 = ". Got ";
            r5 = r5.append(r8);
            r4 = r5.append(r4);
            r5 = " shorts from recorder, sending ";
            r4 = r4.append(r5);
            r4 = r4.append(r7);
            r5 = " SPEEX vocoded bytes. ";
            r4 = r4.append(r5);
            r4 = r4.toString();
            r3.mo316b(r4);
        L_0x0142:
            r3 = r12.f2888a;
            r3 = r3.mo317b();
            if (r3 == 0) goto L_0x0155;
        L_0x014a:
            r3 = com.nuance.nmsp.client.sdk.oem.EndPointerOEM.C0515a.f2968b;
            if (r6 != r3) goto L_0x019e;
        L_0x014e:
            r3 = r12.f2888a;
            r4 = "ENDPOINTING SPEECH_END";
            r3.mo316b(r4);
        L_0x0155:
            r3 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r4 = r12.f2901n;
            r4 = r4.f2939L;
            if (r4 == 0) goto L_0x0233;
        L_0x015f:
            r0 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0510d.m2666a(r0);
            r3 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
            r0 = r0 + r3;
            r3 = (long) r0;
            r0 = (float) r3;
            r5 = r0;
        L_0x0169:
            r0 = r12.f2891d;
            r3 = new com.nuance.nmdp.speechkit.bi$i;
            r3.<init>(r10);
            r4 = new com.nuance.nmdp.speechkit.bi$i;
            r4.<init>(r7);
            r7 = 0;
            r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
            if (r7 >= 0) goto L_0x01aa;
        L_0x017a:
            r5 = r1;
        L_0x017b:
            r0.mo229a(r1, r2, r3, r4, r5);
            r0 = com.nuance.nmsp.client.sdk.oem.EndPointerOEM.C0515a.f2968b;
            if (r6 != r0) goto L_0x0193;
        L_0x0182:
            r12.f2899l = r11;
            r0 = r12.f2901n;
            r0 = r0.f2941N;
            if (r0 != 0) goto L_0x01af;
        L_0x018c:
            r0 = r12.f2896i;
            r1 = r12.f2892e;
            r12.m2671a(r0, r1);
        L_0x0193:
            r0 = com.nuance.nmsp.client.sdk.oem.EndPointerOEM.C0515a.f2969c;
            if (r6 != r0) goto L_0x0031;
        L_0x0197:
            r0 = r12.f2893f;
            r0.mo235e();
            goto L_0x0031;
        L_0x019e:
            r3 = com.nuance.nmsp.client.sdk.oem.EndPointerOEM.C0515a.f2969c;
            if (r6 != r3) goto L_0x0155;
        L_0x01a2:
            r3 = r12.f2888a;
            r4 = "ENDPOINTING SPEECH_START";
            r3.mo316b(r4);
            goto L_0x0155;
        L_0x01aa:
            r5 = java.lang.Float.valueOf(r5);
            goto L_0x017b;
        L_0x01af:
            r0 = r12.f2892e;
            if (r0 == 0) goto L_0x0193;
        L_0x01b3:
            r0 = r12.f2892e;
            r0.mo230a();
            goto L_0x0193;
        L_0x01b9:
            r2 = r12.f2890c;
            if (r2 == 0) goto L_0x0031;
        L_0x01bd:
            r3 = r0;
            r3 = (byte[]) r3;
            if (r4 >= 0) goto L_0x01db;
        L_0x01c2:
            r0 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;
            r1 = new java.lang.StringBuilder;
            r2 = "Call to AudioRecord.read() failed with code: ";
            r1.<init>(r2);
            r1 = r1.append(r4);
            r1 = r1.toString();
            r0.<init>(r1);
            r12.m2667a(r0);
            goto L_0x0031;
        L_0x01db:
            if (r4 != 0) goto L_0x01ee;
        L_0x01dd:
            r0 = r12.f2888a;
            r0 = r0.mo317b();
            if (r0 == 0) goto L_0x0031;
        L_0x01e5:
            r0 = r12.f2888a;
            r1 = "AudioRecorder has no audio.";
            r0.mo316b(r1);
            goto L_0x0031;
        L_0x01ee:
            r0 = r12.f2888a;
            r0 = r0.mo317b();
            if (r0 == 0) goto L_0x0220;
        L_0x01f6:
            r0 = r12.f2888a;
            r2 = new java.lang.StringBuilder;
            r5 = "RECORDING: Sample #";
            r2.<init>(r5);
            r5 = r12.f2900m;
            r6 = r5 + 1;
            r12.f2900m = r6;
            r2 = r2.append(r5);
            r5 = ". Sending ";
            r2 = r2.append(r5);
            r2 = r2.append(r4);
            r5 = " bytes from recorder.";
            r2 = r2.append(r5);
            r2 = r2.toString();
            r0.mo316b(r2);
        L_0x0220:
            r5 = new com.nuance.nmdp.speechkit.bi$i;
            r5.<init>(r4);
            r2 = r12.f2891d;
            r6 = new com.nuance.nmdp.speechkit.bi$i;
            r6.<init>(r10);
            r4 = r1;
            r7 = r1;
            r2.mo229a(r3, r4, r5, r6, r7);
            goto L_0x0031;
        L_0x0233:
            r5 = r3;
            goto L_0x0169;
        L_0x0236:
            r6 = r3;
            goto L_0x00e6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.d.a(java.lang.Object, java.lang.Object):void");
        }

        public final void m2673a(boolean z, C0404a c0404a, C0415m c0415m, C0410g c0410g, C0414l c0414l, C0407d c0407d, C0408e c0408e, C0409f c0409f) {
            if (this.f2901n.f2943S != null) {
                this.f2901n.f2943S.m2460a();
            }
            synchronized (AudioSystemOEM.f2921B) {
                int encodeInitSpeex;
                this.f2900m = 0;
                this.f2891d = c0404a;
                this.f2892e = c0407d;
                this.f2893f = c0414l;
                this.f2894g = c0408e;
                this.f2895h = c0409f;
                this.f2896i = c0415m;
                this.f2897j = c0410g;
                if (z) {
                    m2669a(this.f2894g);
                }
                if (this.f2901n.f2938K == C0508b.f2883a) {
                    synchronized (AudioSystemOEM.f2927a) {
                        encodeInitSpeex = AudioSystemOEM.encodeInitSpeex(this.f2901n.f2935H, this.f2901n.f2937J, 3, this.f2901n.f2936I, 1);
                    }
                    if (encodeInitSpeex < 0) {
                        throw new C0507a("encodeInitSpeex failed with code:" + AudioSystemOEM.speexCodeToString(encodeInitSpeex));
                    }
                }
                try {
                    this.f2889b = new AudioRecord(this.f2901n.f2959s, this.f2901n.f2960t, 2, 2, this.f2901n.f2964x);
                    if (this.f2889b == null || this.f2889b.getState() != 1) {
                        throw new C0507a("AudioRecord object has not been initialized correctly. One or several parameters used to create it must be wrong.");
                    }
                    this.f2890c = true;
                    this.f2889b.setRecordPositionUpdateListener(this);
                    encodeInitSpeex = this.f2889b.setPositionNotificationPeriod(this.f2901n.f2962v);
                    if (encodeInitSpeex != 0) {
                        throw new C0507a("Call to AudioRecord.setPositionNotificationPeriod() failed with code:" + encodeInitSpeex);
                    }
                    this.f2889b.startRecording();
                    encodeInitSpeex = 0;
                    short[] sArr = new short[this.f2901n.f2962v];
                    do {
                        int read = this.f2889b.read(sArr, encodeInitSpeex, this.f2901n.f2962v - encodeInitSpeex);
                        if (read != -3 && read != -2) {
                            if (read <= 0) {
                                break;
                            }
                            encodeInitSpeex += read;
                        } else {
                            throw new C0507a("Call to AudioRecord.read() failed with code:" + read);
                        }
                    } while (encodeInitSpeex < this.f2901n.f2962v);
                } catch (IllegalStateException e) {
                    throw new C0507a("Call to AudioRecord.startRecording() failed.");
                } catch (IllegalArgumentException e2) {
                    throw new C0507a("Could not instanciate AudioRecord object.");
                }
            }
        }

        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            int i = 0;
            int read;
            bk p;
            Object obj;
            Object b;
            if (this.f2901n.f2938K == C0508b.f2883a) {
                synchronized (AudioSystemOEM.f2921B) {
                    if (this.f2890c) {
                        short[] sArr = new short[this.f2901n.f2962v];
                        do {
                            read = audioRecord.read(sArr, i, this.f2901n.f2962v - i);
                            if (read == -3 || read == -2 || read <= 0) {
                                p = this.f2901n.f2940M;
                                obj = new Object[]{AudioSystemOEM.f2926Q, new Integer(i), sArr};
                                b = this.f2901n.f2940M.mo330b();
                                this.f2901n.f2940M.mo329a();
                                p.mo327a(obj, this, b);
                            } else {
                                i += read;
                            }
                        } while (i < this.f2901n.f2962v);
                        p = this.f2901n.f2940M;
                        obj = new Object[]{AudioSystemOEM.f2926Q, new Integer(i), sArr};
                        b = this.f2901n.f2940M.mo330b();
                        this.f2901n.f2940M.mo329a();
                        p.mo327a(obj, this, b);
                    }
                }
                return;
            }
            synchronized (AudioSystemOEM.f2921B) {
                if (this.f2890c) {
                    byte[] bArr = new byte[this.f2901n.f2963w];
                    do {
                        read = audioRecord.read(bArr, i, this.f2901n.f2963w - i);
                        if (read == -3 || read == -2 || read <= 0) {
                            p = this.f2901n.f2940M;
                            obj = new Object[]{AudioSystemOEM.f2926Q, new Integer(i), bArr};
                            b = this.f2901n.f2940M.mo330b();
                            this.f2901n.f2940M.mo329a();
                            p.mo327a(obj, this, b);
                        } else {
                            i += read;
                        }
                    } while (i < this.f2901n.f2963w);
                    p = this.f2901n.f2940M;
                    obj = new Object[]{AudioSystemOEM.f2926Q, new Integer(i), bArr};
                    b = this.f2901n.f2940M.mo330b();
                    this.f2901n.f2940M.mo329a();
                    p.mo327a(obj, this, b);
                }
            }
        }
    }

    final class C0514e extends Thread implements OnPlaybackPositionUpdateListener {
        final /* synthetic */ AudioSystemOEM f2905a;
        private bj f2906b;
        private Handler f2907c;
        private AudioTrack f2908d;
        private byte[] f2909e;
        private short[] f2910f;
        private boolean f2911g;
        private int f2912h;
        private int f2913i;
        private boolean f2914j;
        private int f2915k;
        private boolean f2916l;
        private C0404a f2917m;
        private C0406c f2918n;
        private C0415m f2919o;
        private int f2920p;

        final class C0511a implements bn {
            private /* synthetic */ C0514e f2902a;

            C0511a(C0514e c0514e) {
                this.f2902a = c0514e;
            }

            public final void run() {
                this.f2902a.f2908d.stop();
                this.f2902a.f2908d.release();
                synchronized (AudioSystemOEM.f2928b) {
                    AudioSystemOEM.decodeCleanupSpeex();
                    this.f2902a.f2905a.f2933F = null;
                    this.f2902a.f2905a.f2934G = null;
                }
                if (this.f2902a.f2905a.f2943S != null) {
                    this.f2902a.f2905a.f2943S.mo281e();
                    this.f2902a.f2905a.m2707j();
                }
                C0406c d = this.f2902a.f2918n;
                C0405b c0405b = C0405b.f2464a;
                C0514e c0514e = this.f2902a;
                d.mo228a(c0405b, null);
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.quit();
                }
                this.f2902a.f2914j = false;
            }
        }

        final class C0512b implements bn {
            private /* synthetic */ C0514e f2903a;

            C0512b(C0514e c0514e) {
                this.f2903a = c0514e;
            }

            public final void run() {
                this.f2903a.f2908d.stop();
                this.f2903a.f2908d.release();
                if (this.f2903a.f2905a.f2943S != null) {
                    this.f2903a.f2905a.f2943S.mo281e();
                    this.f2903a.f2905a.m2707j();
                }
                C0406c d = this.f2903a.f2918n;
                C0405b c0405b = C0405b.f2464a;
                C0514e c0514e = this.f2903a;
                d.mo228a(c0405b, null);
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.quit();
                }
                this.f2903a.f2914j = false;
            }
        }

        final class C0513c extends Handler {
            private /* synthetic */ C0514e f2904a;

            C0513c(C0514e c0514e) {
                this.f2904a = c0514e;
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        try {
                            this.f2904a.m2679b();
                            return;
                        } catch (C0507a e) {
                            this.f2904a.m2676a(e);
                            return;
                        }
                    case 2:
                        C0514e.m2680b(this.f2904a);
                        return;
                    default:
                        return;
                }
            }
        }

        private C0514e(AudioSystemOEM audioSystemOEM) {
            this.f2905a = audioSystemOEM;
            this.f2906b = C0478j.m2563a(getClass());
            this.f2914j = true;
            this.f2916l = false;
            this.f2917m = null;
            this.f2918n = null;
            this.f2919o = null;
            this.f2920p = 0;
        }

        private int m2674a(short[] sArr, int i, C0412i c0412i) {
            if (i == 0) {
                return 0;
            }
            if (this.f2905a.f2938K == C0508b.f2883a) {
                int i2 = AudioSystemOEM.f2930d - AudioSystemOEM.f2929c;
                if (i2 >= i) {
                    System.arraycopy(this.f2905a.f2933F, AudioSystemOEM.f2929c, sArr, 0, i);
                    AudioSystemOEM.f2929c += i;
                    return i;
                }
                if (i2 > 0) {
                    System.arraycopy(this.f2905a.f2933F, AudioSystemOEM.f2929c, sArr, 0, i2);
                }
                AudioSystemOEM.f2929c = 0;
                this.f2917m.mo229a(null, this.f2905a.f2934G, new C0412i(0), c0412i, null);
                if (c0412i.f2470a > 0) {
                    int decodeSpeex;
                    synchronized (AudioSystemOEM.f2928b) {
                        decodeSpeex = AudioSystemOEM.decodeSpeex(this.f2905a.f2934G, c0412i.f2470a, this.f2905a.f2933F, this.f2905a.f2933F.length);
                        AudioSystemOEM.f2930d = decodeSpeex;
                        if (decodeSpeex > this.f2905a.f2933F.length) {
                            AudioSystemOEM.f2930d = this.f2905a.f2933F.length;
                        }
                    }
                    if (decodeSpeex < 0) {
                        throw new C0507a("Call to decodeSpeex() failed with code: " + AudioSystemOEM.speexCodeToString(decodeSpeex));
                    } else if (this.f2906b.mo317b()) {
                        this.f2906b.mo316b("Obtained " + decodeSpeex + " shorts of PCM data after decoding SPEEX.");
                    }
                }
                if (i2 > 0) {
                    return i2;
                }
            }
            return 0;
        }

        private void m2676a(C0507a c0507a) {
            synchronized (AudioSystemOEM.f2922C) {
                if (this.f2906b.mo323e()) {
                    this.f2906b.mo322e(c0507a.getMessage());
                }
                if (this.f2908d != null) {
                    this.f2908d.stop();
                    this.f2908d.release();
                    Looper myLooper = Looper.myLooper();
                    if (myLooper != null) {
                        myLooper.quit();
                    }
                    this.f2914j = false;
                }
                if (this.f2905a.f2943S != null) {
                    this.f2905a.f2943S.mo281e();
                    this.f2905a.m2707j();
                }
                this.f2918n.mo228a(C0405b.f2465b, null);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m2679b() {
            /*
            r11 = this;
            r6 = 0;
            r10 = -1;
            r8 = 0;
            r9 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2922C;
            monitor-enter(r9);
            r0 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r0 = r0.mo317b();	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x0018;
        L_0x0011:
            r0 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r1 = "++++++++++++========== onPlay()";
            r0.mo316b(r1);	 Catch:{ all -> 0x00a4 }
        L_0x0018:
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2938K;	 Catch:{ all -> 0x00a4 }
            r1 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0508b.f2883a;	 Catch:{ all -> 0x00a4 }
            if (r0 != r1) goto L_0x0188;
        L_0x0022:
            r0 = r11.f2914j;	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x02fb;
        L_0x0026:
            r1 = new com.nuance.nmdp.speechkit.bi$i;	 Catch:{ all -> 0x00a4 }
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2950j;	 Catch:{ all -> 0x00a4 }
            r1.<init>(r0);	 Catch:{ all -> 0x00a4 }
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2950j;	 Catch:{ all -> 0x00a4 }
            r2 = new short[r0];	 Catch:{ all -> 0x00a4 }
            r0 = r8;
        L_0x003a:
            r3 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r3 = r3.f2950j;	 Catch:{ all -> 0x00a4 }
            if (r0 >= r3) goto L_0x0050;
        L_0x0042:
            r3 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2923D;	 Catch:{ all -> 0x00a4 }
            monitor-enter(r3);	 Catch:{ all -> 0x00a4 }
            r4 = r11.f2916l;	 Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x007a;
        L_0x004b:
            r0 = 0;
            r11.f2914j = r0;	 Catch:{ all -> 0x00a7 }
            monitor-exit(r3);	 Catch:{ all -> 0x00a7 }
            r0 = r8;
        L_0x0050:
            if (r0 <= 0) goto L_0x00b8;
        L_0x0052:
            r1 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r1 = r1.f2950j;	 Catch:{ all -> 0x00a4 }
            if (r0 >= r1) goto L_0x00b8;
        L_0x005a:
            r1 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r1 = r1.mo317b();	 Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0069;
        L_0x0062:
            r1 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r2 = "Filling buffer with silence.";
            r1.mo316b(r2);	 Catch:{ all -> 0x00a4 }
        L_0x0069:
            r1 = r0;
        L_0x006a:
            r2 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r2 = r2.f2950j;	 Catch:{ all -> 0x00a4 }
            if (r1 >= r2) goto L_0x00b8;
        L_0x0072:
            r2 = r11.f2910f;	 Catch:{ all -> 0x00a4 }
            r3 = 0;
            r2[r1] = r3;	 Catch:{ all -> 0x00a4 }
            r1 = r1 + 1;
            goto L_0x006a;
        L_0x007a:
            monitor-exit(r3);	 Catch:{ all -> 0x00a4 }
            r3 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r3 = r3.f2950j;	 Catch:{ all -> 0x00a4 }
            r3 = r3 - r0;
            r3 = r11.m2674a(r2, r3, r1);	 Catch:{ all -> 0x00a4 }
            if (r3 != 0) goto L_0x008d;
        L_0x0088:
            r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
            com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0514e.sleep(r4);	 Catch:{ InterruptedException -> 0x02ee }
        L_0x008d:
            r4 = r1.f2470a;	 Catch:{ all -> 0x00a4 }
            if (r4 != r10) goto L_0x00aa;
        L_0x0091:
            r1 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r1 = r1.mo317b();	 Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x00a0;
        L_0x0099:
            r1 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r2 = "No more data to playback.";
            r1.mo316b(r2);	 Catch:{ all -> 0x00a4 }
        L_0x00a0:
            r1 = 0;
            r11.f2914j = r1;	 Catch:{ all -> 0x00a4 }
            goto L_0x0050;
        L_0x00a4:
            r0 = move-exception;
            monitor-exit(r9);
            throw r0;
        L_0x00a7:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00a4 }
            throw r0;	 Catch:{ all -> 0x00a4 }
        L_0x00aa:
            r4 = r1.f2470a;	 Catch:{ all -> 0x00a4 }
            if (r4 <= 0) goto L_0x003a;
        L_0x00ae:
            if (r3 <= 0) goto L_0x003a;
        L_0x00b0:
            r4 = 0;
            r5 = r11.f2910f;	 Catch:{ all -> 0x00a4 }
            java.lang.System.arraycopy(r2, r4, r5, r0, r3);	 Catch:{ all -> 0x00a4 }
            r0 = r0 + r3;
            goto L_0x003a;
        L_0x00b8:
            if (r0 <= 0) goto L_0x0101;
        L_0x00ba:
            if (r0 == 0) goto L_0x00d4;
        L_0x00bc:
            r1 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r2 = r11.f2910f;	 Catch:{ all -> 0x00a4 }
            r3 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r3 = r3.f2950j;	 Catch:{ all -> 0x00a4 }
            r1 = r1.write(r2, r8, r3);	 Catch:{ all -> 0x00a4 }
            if (r1 <= 0) goto L_0x00d4;
        L_0x00cc:
            r0 = r0 - r1;
            r8 = r8 + r1;
            r2 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            r1 = r1 + r2;
            r11.f2913i = r1;	 Catch:{ all -> 0x00a4 }
            goto L_0x00ba;
        L_0x00d4:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            r0 = r0.setNotificationMarkerPosition(r1);	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x00f3;
        L_0x00de:
            r1 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;	 Catch:{ all -> 0x00a4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a4 }
            r3 = "Call to AudioTrack.setNotificationMarkerPosition() SPEEX 0 failed with code: ";
            r2.<init>(r3);	 Catch:{ all -> 0x00a4 }
            r0 = r2.append(r0);	 Catch:{ all -> 0x00a4 }
            r0 = r0.toString();	 Catch:{ all -> 0x00a4 }
            r1.<init>(r0);	 Catch:{ all -> 0x00a4 }
            throw r1;	 Catch:{ all -> 0x00a4 }
        L_0x00f3:
            r0 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r2 = 1;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x00a4 }
            r0.sendMessage(r1);	 Catch:{ all -> 0x00a4 }
        L_0x00ff:
            monitor-exit(r9);	 Catch:{ all -> 0x00a4 }
        L_0x0100:
            return;
        L_0x0101:
            r0 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r1 = r1.f2957q;	 Catch:{ all -> 0x00a4 }
            if (r0 >= r1) goto L_0x0159;
        L_0x010b:
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2957q;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            r0 = r0 - r1;
            r1 = new short[r0];	 Catch:{ all -> 0x00a4 }
        L_0x0116:
            if (r8 >= r0) goto L_0x011e;
        L_0x0118:
            r2 = 0;
            r1[r8] = r2;	 Catch:{ all -> 0x00a4 }
            r8 = r8 + 1;
            goto L_0x0116;
        L_0x011e:
            r2 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r3 = 0;
            r0 = r2.write(r1, r3, r0);	 Catch:{ all -> 0x00a4 }
            if (r0 <= 0) goto L_0x012c;
        L_0x0127:
            r1 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            r0 = r0 + r1;
            r11.f2913i = r0;	 Catch:{ all -> 0x00a4 }
        L_0x012c:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            r0 = r0.setNotificationMarkerPosition(r1);	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x014b;
        L_0x0136:
            r1 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;	 Catch:{ all -> 0x00a4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a4 }
            r3 = "Call to AudioTrack.setNotificationMarkerPosition() SPEEX 1 failed with code: ";
            r2.<init>(r3);	 Catch:{ all -> 0x00a4 }
            r0 = r2.append(r0);	 Catch:{ all -> 0x00a4 }
            r0 = r0.toString();	 Catch:{ all -> 0x00a4 }
            r1.<init>(r0);	 Catch:{ all -> 0x00a4 }
            throw r1;	 Catch:{ all -> 0x00a4 }
        L_0x014b:
            r0 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r2 = 1;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x00a4 }
            r0.sendMessage(r1);	 Catch:{ all -> 0x00a4 }
            monitor-exit(r9);	 Catch:{ all -> 0x00a4 }
            goto L_0x0100;
        L_0x0159:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r1 = r0.getPlaybackHeadPosition();	 Catch:{ all -> 0x00a4 }
            r0 = r11.f2915k;	 Catch:{ all -> 0x00a4 }
            if (r1 != r0) goto L_0x02f8;
        L_0x0163:
            r0 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
        L_0x0165:
            r11.f2915k = r0;	 Catch:{ all -> 0x00a4 }
            r2 = r11.f2913i;	 Catch:{ all -> 0x00a4 }
            if (r0 < r2) goto L_0x00ff;
        L_0x016b:
            if (r0 <= r1) goto L_0x0178;
        L_0x016d:
            r0 = r0 - r1;
            r0 = r0 * 1000;
            r1 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r1 = r1.f2937J;	 Catch:{ all -> 0x00a4 }
            r0 = r0 / r1;
            r6 = (long) r0;	 Catch:{ all -> 0x00a4 }
        L_0x0178:
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2940M;	 Catch:{ all -> 0x00a4 }
            r1 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$e$a;	 Catch:{ all -> 0x00a4 }
            r1.<init>(r11);	 Catch:{ all -> 0x00a4 }
            r0.mo326a(r1, r6);	 Catch:{ all -> 0x00a4 }
            goto L_0x00ff;
        L_0x0188:
            r0 = r11.f2914j;	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x02f5;
        L_0x018c:
            r3 = new com.nuance.nmdp.speechkit.bi$i;	 Catch:{ all -> 0x00a4 }
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2951k;	 Catch:{ all -> 0x00a4 }
            r3.<init>(r0);	 Catch:{ all -> 0x00a4 }
            r0 = r11.f2917m;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2909e;	 Catch:{ all -> 0x00a4 }
            r2 = 0;
            r4 = new com.nuance.nmdp.speechkit.bi$i;	 Catch:{ all -> 0x00a4 }
            r5 = 0;
            r4.<init>(r5);	 Catch:{ all -> 0x00a4 }
            r5 = 0;
            r0.mo229a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x00a4 }
            r0 = r3.f2470a;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r1 = r1.mo317b();	 Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x01ea;
        L_0x01b0:
            r1 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a4 }
            r3 = "PLAYBACK: Sample #";
            r2.<init>(r3);	 Catch:{ all -> 0x00a4 }
            r3 = r11.f2920p;	 Catch:{ all -> 0x00a4 }
            r4 = r3 + 1;
            r11.f2920p = r4;	 Catch:{ all -> 0x00a4 }
            r2 = r2.append(r3);	 Catch:{ all -> 0x00a4 }
            r3 = ". Asked for ";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00a4 }
            r3 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r3 = r3.f2951k;	 Catch:{ all -> 0x00a4 }
            r2 = r2.append(r3);	 Catch:{ all -> 0x00a4 }
            r3 = " bytes of data, ";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00a4 }
            r2 = r2.append(r0);	 Catch:{ all -> 0x00a4 }
            r3 = " bytes received.";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00a4 }
            r2 = r2.toString();	 Catch:{ all -> 0x00a4 }
            r1.mo316b(r2);	 Catch:{ all -> 0x00a4 }
        L_0x01ea:
            if (r0 != 0) goto L_0x0219;
        L_0x01ec:
            r1 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r2 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r2 = r2.f2951k;	 Catch:{ all -> 0x00a4 }
            if (r1 >= r2) goto L_0x0219;
        L_0x01f6:
            r0 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r0 = r0.mo317b();	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x0205;
        L_0x01fe:
            r0 = r11.f2906b;	 Catch:{ all -> 0x00a4 }
            r1 = "Filling buffer with silence.";
            r0.mo316b(r1);	 Catch:{ all -> 0x00a4 }
        L_0x0205:
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2951k;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r0 = r0 - r1;
            r1 = r8;
        L_0x020f:
            if (r1 >= r0) goto L_0x0219;
        L_0x0211:
            r2 = r11.f2909e;	 Catch:{ all -> 0x00a4 }
            r3 = 0;
            r2[r1] = r3;	 Catch:{ all -> 0x00a4 }
            r1 = r1 + 1;
            goto L_0x020f;
        L_0x0219:
            if (r0 == r10) goto L_0x025e;
        L_0x021b:
            if (r0 == 0) goto L_0x022f;
        L_0x021d:
            r1 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r2 = r11.f2909e;	 Catch:{ all -> 0x00a4 }
            r1 = r1.write(r2, r8, r0);	 Catch:{ all -> 0x00a4 }
            if (r1 <= 0) goto L_0x022f;
        L_0x0227:
            r0 = r0 - r1;
            r8 = r8 + r1;
            r2 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r1 = r1 + r2;
            r11.f2912h = r1;	 Catch:{ all -> 0x00a4 }
            goto L_0x021b;
        L_0x022f:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r1 = r1 / 2;
            r0 = r0.setNotificationMarkerPosition(r1);	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x0250;
        L_0x023b:
            r1 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;	 Catch:{ all -> 0x00a4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a4 }
            r3 = "Call to AudioTrack.setNotificationMarkerPosition() PCM 0 failed with code: ";
            r2.<init>(r3);	 Catch:{ all -> 0x00a4 }
            r0 = r2.append(r0);	 Catch:{ all -> 0x00a4 }
            r0 = r0.toString();	 Catch:{ all -> 0x00a4 }
            r1.<init>(r0);	 Catch:{ all -> 0x00a4 }
            throw r1;	 Catch:{ all -> 0x00a4 }
        L_0x0250:
            r0 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r2 = 1;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x00a4 }
            r0.sendMessage(r1);	 Catch:{ all -> 0x00a4 }
            goto L_0x00ff;
        L_0x025e:
            r0 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r1 = r1.f2958r;	 Catch:{ all -> 0x00a4 }
            if (r0 >= r1) goto L_0x02bb;
        L_0x0268:
            r0 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r0 = r0.f2958r;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r1 = r0 - r1;
            r2 = new byte[r1];	 Catch:{ all -> 0x00a4 }
            r0 = r8;
        L_0x0275:
            if (r0 >= r1) goto L_0x027d;
        L_0x0277:
            r3 = 0;
            r2[r0] = r3;	 Catch:{ all -> 0x00a4 }
            r0 = r0 + 1;
            goto L_0x0275;
        L_0x027d:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r3 = 0;
            r0 = r0.write(r2, r3, r1);	 Catch:{ all -> 0x00a4 }
            if (r0 <= 0) goto L_0x028b;
        L_0x0286:
            r1 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r0 = r0 + r1;
            r11.f2912h = r0;	 Catch:{ all -> 0x00a4 }
        L_0x028b:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r1 = r1 / 2;
            r0 = r0.setNotificationMarkerPosition(r1);	 Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x02ac;
        L_0x0297:
            r1 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;	 Catch:{ all -> 0x00a4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a4 }
            r3 = "Call to AudioTrack.setNotificationMarkerPosition() PCM 1 failed with code: ";
            r2.<init>(r3);	 Catch:{ all -> 0x00a4 }
            r0 = r2.append(r0);	 Catch:{ all -> 0x00a4 }
            r0 = r0.toString();	 Catch:{ all -> 0x00a4 }
            r1.<init>(r0);	 Catch:{ all -> 0x00a4 }
            throw r1;	 Catch:{ all -> 0x00a4 }
        L_0x02ac:
            r0 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r1 = r11.f2907c;	 Catch:{ all -> 0x00a4 }
            r2 = 1;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x00a4 }
            r0.sendMessage(r1);	 Catch:{ all -> 0x00a4 }
            monitor-exit(r9);	 Catch:{ all -> 0x00a4 }
            goto L_0x0100;
        L_0x02bb:
            r0 = r11.f2908d;	 Catch:{ all -> 0x00a4 }
            r1 = r0.getPlaybackHeadPosition();	 Catch:{ all -> 0x00a4 }
            r0 = r11.f2915k;	 Catch:{ all -> 0x00a4 }
            if (r1 != r0) goto L_0x02f3;
        L_0x02c5:
            r0 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r0 = r0 / 2;
        L_0x02c9:
            r11.f2915k = r0;	 Catch:{ all -> 0x00a4 }
            r2 = r11.f2912h;	 Catch:{ all -> 0x00a4 }
            r2 = r2 / 2;
            if (r0 < r2) goto L_0x00ff;
        L_0x02d1:
            if (r0 <= r1) goto L_0x02f1;
        L_0x02d3:
            r0 = r0 - r1;
            r0 = r0 * 1000;
            r1 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r1 = r1.f2937J;	 Catch:{ all -> 0x00a4 }
            r0 = r0 / r1;
            r0 = (long) r0;	 Catch:{ all -> 0x00a4 }
        L_0x02de:
            r2 = r11.f2905a;	 Catch:{ all -> 0x00a4 }
            r2 = r2.f2940M;	 Catch:{ all -> 0x00a4 }
            r3 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$e$b;	 Catch:{ all -> 0x00a4 }
            r3.<init>(r11);	 Catch:{ all -> 0x00a4 }
            r2.mo326a(r3, r0);	 Catch:{ all -> 0x00a4 }
            goto L_0x00ff;
        L_0x02ee:
            r4 = move-exception;
            goto L_0x008d;
        L_0x02f1:
            r0 = r6;
            goto L_0x02de;
        L_0x02f3:
            r0 = r1;
            goto L_0x02c9;
        L_0x02f5:
            r0 = r8;
            goto L_0x01ea;
        L_0x02f8:
            r0 = r1;
            goto L_0x0165;
        L_0x02fb:
            r0 = r8;
            goto L_0x0050;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.e.b():void");
        }

        static /* synthetic */ void m2680b(C0514e c0514e) {
            try {
                c0514e.f2908d.stop();
            } catch (IllegalStateException e) {
                if (c0514e.f2906b.mo317b()) {
                    c0514e.f2906b.mo316b((Object) "Could not stop audioTrack.");
                }
            }
            synchronized (AudioSystemOEM.f2922C) {
                c0514e.f2914j = false;
                c0514e.f2908d.flush();
                c0514e.f2908d.release();
            }
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
            if (c0514e.f2905a.f2938K == C0508b.f2883a) {
                synchronized (AudioSystemOEM.f2928b) {
                    AudioSystemOEM.decodeCleanupSpeex();
                    c0514e.f2905a.f2933F = null;
                    c0514e.f2905a.f2934G = null;
                }
            }
            if (c0514e.f2905a.f2943S != null) {
                c0514e.f2905a.f2943S.mo281e();
                c0514e.f2905a.m2707j();
            }
            c0514e.f2919o.mo227a(C0405b.f2464a);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m2684a(com.nuance.nmdp.speechkit.bi.C0404a r6, com.nuance.nmdp.speechkit.bi.C0406c r7) {
            /*
            r5 = this;
            r0 = r5.f2905a;
            r0 = r0.f2943S;
            if (r0 == 0) goto L_0x0011;
        L_0x0008:
            r0 = r5.f2905a;
            r0 = r0.f2943S;
            r0.m2460a();
        L_0x0011:
            monitor-enter(r5);
            r0 = 0;
            r5.f2920p = r0;	 Catch:{ all -> 0x0055 }
            r5.f2917m = r6;	 Catch:{ all -> 0x0055 }
            r5.f2918n = r7;	 Catch:{ all -> 0x0055 }
            r0 = r5.f2905a;	 Catch:{ all -> 0x0055 }
            r0 = r0.f2938K;	 Catch:{ all -> 0x0055 }
            r1 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0508b.f2883a;	 Catch:{ all -> 0x0055 }
            if (r0 != r1) goto L_0x0071;
        L_0x0023:
            r1 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2928b;	 Catch:{ all -> 0x0055 }
            monitor-enter(r1);	 Catch:{ all -> 0x0055 }
            r0 = r5.f2905a;	 Catch:{ all -> 0x0052 }
            r0 = r0.f2935H;	 Catch:{ all -> 0x0052 }
            r2 = 0;
            r3 = r5.f2905a;	 Catch:{ all -> 0x0052 }
            r3 = r3.f2937J;	 Catch:{ all -> 0x0052 }
            r0 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.decodeInitSpeex(r0, r2, r3);	 Catch:{ all -> 0x0052 }
            if (r0 >= 0) goto L_0x0058;
        L_0x0039:
            r2 = new com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a;	 Catch:{ all -> 0x0052 }
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0052 }
            r4 = "decodeInitSpeex failed with code: ";
            r3.<init>(r4);	 Catch:{ all -> 0x0052 }
            r0 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.speexCodeToString(r0);	 Catch:{ all -> 0x0052 }
            r0 = r3.append(r0);	 Catch:{ all -> 0x0052 }
            r0 = r0.toString();	 Catch:{ all -> 0x0052 }
            r2.<init>(r0);	 Catch:{ all -> 0x0052 }
            throw r2;	 Catch:{ all -> 0x0052 }
        L_0x0052:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0055 }
            throw r0;	 Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception;
            monitor-exit(r5);
            throw r0;
        L_0x0058:
            r0 = r5.f2905a;	 Catch:{ all -> 0x0052 }
            r2 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
            r2 = new short[r2];	 Catch:{ all -> 0x0052 }
            r0.f2933F = r2;	 Catch:{ all -> 0x0052 }
            r0 = r5.f2905a;	 Catch:{ all -> 0x0052 }
            r2 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
            r2 = new byte[r2];	 Catch:{ all -> 0x0052 }
            r0.f2934G = r2;	 Catch:{ all -> 0x0052 }
            monitor-exit(r1);	 Catch:{ all -> 0x0052 }
            r0 = 0;
            com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2929c = r0;	 Catch:{ all -> 0x0055 }
            r0 = 0;
            com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2930d = r0;	 Catch:{ all -> 0x0055 }
        L_0x0071:
            r5.start();	 Catch:{ all -> 0x0055 }
        L_0x0074:
            r0 = r5.isAlive();	 Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0084;
        L_0x007a:
            r0 = r5.f2907c;	 Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x0084;
        L_0x007e:
            r5.wait();	 Catch:{ InterruptedException -> 0x0082 }
            goto L_0x0074;
        L_0x0082:
            r0 = move-exception;
            goto L_0x0074;
        L_0x0084:
            r0 = r5.isAlive();	 Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x008c;
        L_0x008a:
            monitor-exit(r5);	 Catch:{ all -> 0x0055 }
        L_0x008b:
            return;
        L_0x008c:
            r0 = r5.f2907c;	 Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x009c;
        L_0x0090:
            r0 = r5.f2907c;	 Catch:{ all -> 0x0055 }
            r1 = r5.f2907c;	 Catch:{ all -> 0x0055 }
            r2 = 1;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x0055 }
            r0.sendMessage(r1);	 Catch:{ all -> 0x0055 }
        L_0x009c:
            monitor-exit(r5);	 Catch:{ all -> 0x0055 }
            goto L_0x008b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.e.a(com.nuance.nmdp.speechkit.bi$a, com.nuance.nmdp.speechkit.bi$c):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m2685a(com.nuance.nmdp.speechkit.bi.C0415m r4) {
            /*
            r3 = this;
            r1 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2923D;
            monitor-enter(r1);
            r0 = 1;
            r3.f2916l = r0;	 Catch:{ all -> 0x0021 }
            monitor-exit(r1);	 Catch:{ all -> 0x0021 }
            r1 = com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.f2922C;
            monitor-enter(r1);
            r0 = 0;
            r3.f2914j = r0;	 Catch:{ all -> 0x0024 }
            monitor-exit(r1);	 Catch:{ all -> 0x0024 }
            monitor-enter(r3);
            r3.f2919o = r4;	 Catch:{ all -> 0x0049 }
            r0 = r3.isAlive();	 Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x001f;
        L_0x001b:
            r0 = r3.f2911g;	 Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0027;
        L_0x001f:
            monitor-exit(r3);	 Catch:{ all -> 0x0049 }
        L_0x0020:
            return;
        L_0x0021:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
        L_0x0024:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
        L_0x0027:
            r0 = r3.f2907c;	 Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0037;
        L_0x002b:
            r0 = r3.f2907c;	 Catch:{ all -> 0x0049 }
            r1 = r3.f2907c;	 Catch:{ all -> 0x0049 }
            r2 = 2;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x0049 }
            r0.sendMessage(r1);	 Catch:{ all -> 0x0049 }
        L_0x0037:
            r0 = r3.isAlive();	 Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0047;
        L_0x003d:
            r0 = r3.f2911g;	 Catch:{ all -> 0x0049 }
            if (r0 != 0) goto L_0x0047;
        L_0x0041:
            r3.wait();	 Catch:{ InterruptedException -> 0x0045 }
            goto L_0x0037;
        L_0x0045:
            r0 = move-exception;
            goto L_0x0037;
        L_0x0047:
            monitor-exit(r3);	 Catch:{ all -> 0x0049 }
            goto L_0x0020;
        L_0x0049:
            r0 = move-exception;
            monitor-exit(r3);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.e.a(com.nuance.nmdp.speechkit.bi$m):void");
        }

        public final void onMarkerReached(AudioTrack audioTrack) {
            if (this.f2906b.mo317b()) {
                this.f2906b.mo316b("++++++++++++========== onMarkerReached(). PlaybackHeadPosition:" + this.f2908d.getPlaybackHeadPosition());
            }
            try {
                m2679b();
            } catch (C0507a e) {
                m2676a(e);
            }
        }

        public final void onPeriodicNotification(AudioTrack audioTrack) {
            if (this.f2906b.mo317b()) {
                this.f2906b.mo316b("++++++++++++========== onPeriodicNotification(). PlaybackHeadPosition" + this.f2908d.getPlaybackHeadPosition());
            }
        }

        public final void run() {
            Looper.prepare();
            synchronized (this) {
                this.f2907c = new C0513c(this);
                try {
                    synchronized (AudioSystemOEM.f2922C) {
                        if (this.f2906b.mo317b()) {
                            this.f2906b.mo316b((Object) "Creating Audio Track");
                        }
                        this.f2909e = new byte[this.f2905a.f2951k];
                        this.f2910f = new short[this.f2905a.f2955o];
                        try {
                            this.f2915k = 0;
                            this.f2908d = new AudioTrack(this.f2905a.f2946f, this.f2905a.f2948h, 2, 2, this.f2905a.f2952l, this.f2905a.f2947g);
                            if (this.f2908d == null || this.f2908d.getState() != 1) {
                                throw new C0507a("AudioTrack object has not been initialized correctly. One or several parameters used to create it must be wrong.");
                            }
                            this.f2908d.setPlaybackPositionUpdateListener(this);
                            this.f2908d.play();
                        } catch (IllegalArgumentException e) {
                            throw new C0507a("Could not instanciate AudioTrack object.");
                        }
                    }
                    notifyAll();
                } catch (C0507a e2) {
                    m2676a(e2);
                    return;
                }
            }
            Looper.loop();
            synchronized (this) {
                this.f2911g = true;
                notifyAll();
            }
        }
    }

    static {
        System.loadLibrary("nmsp_speex");
    }

    public AudioSystemOEM(bk bkVar, bh bhVar, Vector vector) {
        this.f2944T = bhVar;
        m2689a(bhVar);
        this.f2940M = bkVar;
        this.f2932E = new EndPointerOEM();
        this.f2932E.m2737a(vector);
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                cb cbVar = (cb) vector.get(i);
                String a = cbVar.m2234a();
                if (cbVar.m2237d() == C0445a.f2559a) {
                    if (a.equals("USE_ENERGY_LEVEL")) {
                        if (new String(cbVar.m2235b()).equalsIgnoreCase("TRUE")) {
                            if (this.f2945e.mo317b()) {
                                this.f2945e.mo316b((Object) "Use energy level is activated.");
                            }
                            this.f2939L = true;
                        }
                    } else if (a.equals("NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING")) {
                        if (new String(cbVar.m2235b()).equalsIgnoreCase("TRUE")) {
                            if (this.f2945e.mo317b()) {
                                this.f2945e.mo316b((Object) "_continuesOnEndPointerAndTimerStopping is activated.");
                            }
                            this.f2941N = true;
                        }
                    } else if (a.equals("NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER")) {
                        if (new String(cbVar.m2235b()).equalsIgnoreCase("TRUE") && this.f2945e.mo317b()) {
                            this.f2945e.mo316b((Object) "_capturingContinuesOnEndPointer is activated.");
                        }
                    } else if (a.equals("Android_Context")) {
                        this.f2942R = (Context) cbVar.m2236c();
                        if (this.f2945e.mo317b()) {
                            this.f2945e.mo316b("NMSP_DEFINES_ANDROID_CONTEXT is passed in as" + this.f2942R);
                        }
                    }
                }
            }
        }
    }

    private void m2689a(bh bhVar) {
        int i;
        int minBufferSize;
        if (bhVar != bh.f2459d) {
            if (bhVar == bh.f2460e) {
                this.f2938K = C0508b.f2884b;
                this.f2937J = 11000;
                this.f2935H = -1;
                this.f2936I = -1;
            } else if (bhVar == bh.f2461f) {
                this.f2938K = C0508b.f2884b;
                this.f2937J = 16000;
                this.f2935H = -1;
                this.f2936I = -1;
            } else if (bhVar == bh.f2462g) {
                this.f2938K = C0508b.f2884b;
                this.f2937J = 32000;
                this.f2935H = -1;
                this.f2936I = -1;
            } else if (bhVar == bh.f2456a) {
                this.f2938K = C0508b.f2883a;
                this.f2937J = 8000;
                this.f2936I = 6;
                this.f2935H = 0;
            } else if (bhVar == bh.f2457b) {
                this.f2938K = C0508b.f2883a;
                this.f2937J = 16000;
                this.f2936I = 8;
                this.f2935H = 1;
            } else if (bhVar == bh.f2458c) {
                this.f2938K = C0508b.f2883a;
                this.f2937J = 16000;
                this.f2936I = 8;
                this.f2935H = 1;
            } else if (this.f2945e.mo323e()) {
                this.f2945e.mo322e("Codec " + bhVar + " is not handled, using PCM_16_8K by default.");
            }
            this.f2947g = 1;
            this.f2948h = this.f2937J;
            this.f2956p = 750;
            this.f2957q = (this.f2956p * this.f2948h) / 1000;
            this.f2958r = this.f2957q * 2;
            this.f2949i = 300;
            this.f2950j = (this.f2948h * this.f2949i) / 1000;
            this.f2951k = this.f2950j * 2;
            i = this.f2951k * 5;
            minBufferSize = AudioTrack.getMinBufferSize(this.f2948h, 2, 2);
            if (minBufferSize != -2 || minBufferSize == -1 || minBufferSize <= i) {
                this.f2953m = i;
            } else {
                this.f2953m = minBufferSize;
            }
            this.f2952l = this.f2953m / 2;
            this.f2954n = 500;
            this.f2955o = (this.f2948h * this.f2954n) / 1000;
            this.f2960t = this.f2937J;
            this.f2961u = 100;
            this.f2962v = (this.f2960t * this.f2961u) / 1000;
            this.f2963w = this.f2962v * 2;
            i = this.f2963w * 3;
            minBufferSize = AudioRecord.getMinBufferSize(this.f2960t, 2, 2);
            if (minBufferSize != -2 || minBufferSize == -1 || minBufferSize <= i) {
                this.f2964x = i;
            } else {
                this.f2964x = minBufferSize;
            }
            this.f2965y = this.f2963w;
        }
        this.f2938K = C0508b.f2884b;
        this.f2937J = 8000;
        this.f2935H = -1;
        this.f2936I = -1;
        this.f2947g = 1;
        this.f2948h = this.f2937J;
        this.f2956p = 750;
        this.f2957q = (this.f2956p * this.f2948h) / 1000;
        this.f2958r = this.f2957q * 2;
        this.f2949i = 300;
        this.f2950j = (this.f2948h * this.f2949i) / 1000;
        this.f2951k = this.f2950j * 2;
        i = this.f2951k * 5;
        minBufferSize = AudioTrack.getMinBufferSize(this.f2948h, 2, 2);
        if (minBufferSize != -2) {
        }
        this.f2953m = i;
        this.f2952l = this.f2953m / 2;
        this.f2954n = 500;
        this.f2955o = (this.f2948h * this.f2954n) / 1000;
        this.f2960t = this.f2937J;
        this.f2961u = 100;
        this.f2962v = (this.f2960t * this.f2961u) / 1000;
        this.f2963w = this.f2962v * 2;
        i = this.f2963w * 3;
        minBufferSize = AudioRecord.getMinBufferSize(this.f2960t, 2, 2);
        if (minBufferSize != -2) {
        }
        this.f2964x = i;
        this.f2965y = this.f2963w;
    }

    public static native void decodeCleanupSpeex();

    public static native int decodeInitSpeex(int i, int i2, int i3);

    public static native int decodeSpeex(byte[] bArr, int i, short[] sArr, int i2);

    public static native void encodeCleanupSpeex();

    public static native int encodeInitSpeex(int i, int i2, int i3, int i4, int i5);

    public static native int encodeSpeex(short[] sArr, byte[] bArr, int i);

    private void m2707j() {
        if (this.f2943S != null) {
            this.f2943S.m2462c();
            this.f2943S = null;
        }
    }

    private void m2709k() {
        if (this.f2944T == bh.f2457b || this.f2944T == bh.f2458c) {
            this.f2944T = bh.f2456a;
            m2689a(this.f2944T);
        } else if (this.f2944T == bh.f2460e || this.f2944T == bh.f2461f || this.f2944T == bh.f2463h || this.f2944T == bh.f2462g) {
            this.f2944T = bh.f2459d;
            m2689a(this.f2944T);
        }
    }

    public static native String speexCodeToString(int i);

    public final void mo304a(C0408e c0408e) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b((Object) "++++++++++++========== turnOnEndPointer()");
        }
        if (c0408e != null && this.f2931A != null) {
            this.f2931A.m2669a(c0408e);
        }
    }

    public final void mo305a(C0409f c0409f) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b((Object) "++++++++++++========== turnOnEndPointer()");
        }
        if (c0409f != null && this.f2931A != null) {
            this.f2931A.m2670a(c0409f);
        }
    }

    public final void mo306a(C0415m c0415m) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b((Object) "++++++++++++========== stopRecording()");
        }
        if (c0415m != null) {
            if (this.f2931A == null) {
                c0415m.mo227a(C0405b.f2464a);
            } else {
                this.f2931A.m2671a(c0415m, null);
            }
        }
    }

    public final void mo225a(Object obj, Object obj2) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b("---------------------- AudioSystemAndroid +++++ handleMessage() Thread:" + Thread.currentThread());
        }
    }

    public final boolean mo307a() {
        this.f2945e.mo318c((Object) "++++++++++++========== pausePlayback() is not implemented");
        return false;
    }

    public final boolean mo308a(C0411h c0411h, boolean z, C0404a c0404a, C0415m c0415m, C0410g c0410g, C0414l c0414l, C0407d c0407d, C0408e c0408e, C0409f c0409f) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b((Object) "++++++++++++========== startRecording()");
        }
        if (this.f2931A != null) {
            if (this.f2945e.mo317b()) {
                this.f2945e.mo316b((Object) "previous recording still running!");
            }
            return false;
        } else if (c0404a == null) {
            if (this.f2945e.mo323e()) {
                this.f2945e.mo322e("audioCallback cannot be null.");
            }
            return false;
        } else if (this.f2942R == null) {
            if (this.f2945e.mo323e()) {
                this.f2945e.mo322e("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            }
            return false;
        } else {
            this.f2943S = dy.m2457a(this.f2942R);
            if (this.f2943S.m2461b()) {
                m2709k();
            }
            if (c0411h == C0411h.f2466a) {
                this.f2959s = 1;
                m2707j();
            } else if (c0411h == C0411h.f2468c) {
                this.f2959s = this.f2943S.mo283g();
                if (!this.f2943S.m2461b()) {
                    m2707j();
                }
            } else {
                if (this.f2945e.mo323e()) {
                    this.f2945e.mo322e("Unexpected inputDevice.");
                }
                m2707j();
                return false;
            }
            this.f2931A = new C0510d();
            try {
                this.f2931A.m2673a(z, c0404a, c0415m, c0410g, c0414l, c0407d, c0408e, c0409f);
                return true;
            } catch (C0507a e) {
                this.f2931A.m2667a(e);
                this.f2931A = null;
                return false;
            }
        }
    }

    public final boolean mo309a(C0413k c0413k, C0404a c0404a, C0406c c0406c) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b((Object) "++++++++++++========== startPlayback()");
        }
        if (c0404a == null) {
            if (!this.f2945e.mo323e()) {
                return false;
            }
            this.f2945e.mo322e("audioCallback cannot be null.");
            return false;
        } else if (this.f2942R != null) {
            this.f2943S = dy.m2457a(this.f2942R);
            if (this.f2943S.m2461b()) {
                m2709k();
            }
            if (c0413k == C0413k.f2471a) {
                this.f2946f = 3;
                m2707j();
            } else if (c0413k == C0413k.f2473c) {
                this.f2946f = this.f2943S.mo282f();
                if (!this.f2943S.m2461b()) {
                    m2707j();
                }
            } else {
                if (this.f2945e.mo323e()) {
                    this.f2945e.mo322e("Unexpected outputDevice.");
                }
                m2707j();
                return false;
            }
            this.f2966z = new C0514e();
            try {
                this.f2966z.m2684a(c0404a, c0406c);
                return true;
            } catch (C0507a e) {
                this.f2966z.m2676a(e);
                this.f2966z = null;
                return false;
            }
        } else if (!this.f2945e.mo323e()) {
            return false;
        } else {
            this.f2945e.mo322e("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            return false;
        }
    }

    public final void mo310b(C0415m c0415m) {
        if (this.f2945e.mo317b()) {
            this.f2945e.mo316b((Object) "++++++++++++========== stopPlayback()");
        }
        if (this.f2966z != null) {
            this.f2966z.m2685a(c0415m);
        }
        this.f2966z = null;
    }

    public final boolean mo311b() {
        this.f2945e.mo318c((Object) "++++++++++++========== previousPlayback() is not implemented");
        return false;
    }

    public final boolean mo312c() {
        this.f2945e.mo318c((Object) "++++++++++++========== nextPlayback() is not implemented");
        return false;
    }
}
