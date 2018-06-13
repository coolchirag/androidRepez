package com.nuance.nmdp.speechkit;

import android.os.Build.VERSION;
import com.nuance.nmdp.speechkit.bi.C0378j;
import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.dm.C0448a;
import java.util.Vector;

public class cr extends cq implements dq {
    private static final bj f2643g = C0478j.m2563a(cr.class);
    private static String f2644k = VERSION.RELEASE;
    private bk f2645h;
    private cm f2646i;
    private dm f2647j = null;

    public cr(cn cnVar, cm cmVar) {
        super(cnVar, cmVar);
        this.f2646i = cmVar;
        this.f2645h = cnVar.m2226a();
        this.a = cnVar.m2275h();
        this.a.m2289a((ck) this);
        bk bkVar = this.f2645h;
        C0416a c0416a = new C0416a((byte) 0, null);
        Thread currentThread = Thread.currentThread();
        this.f2645h.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    private void m2333a(byte b) {
        if (b == this.f2647j.f2686a) {
            Vector vector = (Vector) ((cn) m2326d()).m2276i();
            if (vector != null && vector.size() > 0) {
                f2643g.mo316b("clearResLogsToServer() before clean the log vector tranId[" + b + "] log list size [" + vector.size() + "]");
                int i = 0;
                while (i < vector.size()) {
                    C0448a c0448a = (C0448a) vector.elementAt(i);
                    if (c0448a.m2427e()) {
                        vector.removeElement(c0448a);
                    } else {
                        i++;
                    }
                }
                f2643g.mo316b("clearResLogsToServer() after clean the log vector tranId[" + b + "] log list size [" + vector.size() + "]");
            }
        }
    }

    public final C0378j mo251a(String str, dp dpVar) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        } else if (dpVar != null) {
            return new cw(str, (cx) dpVar);
        } else {
            throw new NullPointerException("dict can not be null");
        }
    }

    public final C0378j mo252a(String str, dp dpVar, bz bzVar) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        } else if (dpVar == null) {
            throw new NullPointerException("tts_dict can not be null");
        } else if (bzVar != null) {
            return new dl(str, this.a, (cx) dpVar, bzVar);
        } else {
            throw new NullPointerException("audioSink can not be null");
        }
    }

    public final bz mo253a(String str) {
        if (str != null) {
            return new ct(str, this.a, this.f2645h);
        }
        throw new NullPointerException("name can not be null");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.nuance.nmdp.speechkit.C0450do mo254a(com.nuance.nmdp.speechkit.ds r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, com.nuance.nmdp.speechkit.dp r31) {
        /*
        r24 = this;
        r1 = "";
        if (r25 != 0) goto L_0x0017;
    L_0x0004:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "commandListener is invalid; ";
        r1 = r1.append(r2);
        r1 = r1.toString();
    L_0x0017:
        if (r26 == 0) goto L_0x0023;
    L_0x0019:
        r2 = "";
        r0 = r26;
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0036;
    L_0x0023:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "cmd should be non-null; ";
        r1 = r1.append(r2);
        r1 = r1.toString();
    L_0x0036:
        if (r27 == 0) goto L_0x0042;
    L_0x0038:
        r2 = "";
        r0 = r27;
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0055;
    L_0x0042:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "scriptVersion should be non-null; ";
        r1 = r1.append(r2);
        r1 = r1.toString();
    L_0x0055:
        if (r28 == 0) goto L_0x0061;
    L_0x0057:
        r2 = "";
        r0 = r28;
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0074;
    L_0x0061:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "dictationLanguage should be non-null; ";
        r1 = r1.append(r2);
        r1 = r1.toString();
    L_0x0074:
        if (r30 == 0) goto L_0x0080;
    L_0x0076:
        r2 = "";
        r0 = r30;
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0093;
    L_0x0080:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "phoneModel should be non-null; ";
        r1 = r1.append(r2);
        r1 = r1.toString();
    L_0x0093:
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x00ae;
    L_0x009b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "commandTimeout is invalid; ";
        r1 = r1.append(r2);
        r1 = r1.toString();
    L_0x00ae:
        r2 = "";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x00d0;
    L_0x00b6:
        r2 = f2643g;
        r3 = new java.lang.StringBuilder;
        r4 = "NMASResourceImpl.createCommand() ";
        r3.<init>(r4);
        r3 = r3.append(r1);
        r3 = r3.toString();
        r2.mo322e(r3);
        r2 = new java.lang.IllegalArgumentException;
        r2.<init>(r1);
        throw r2;
    L_0x00d0:
        r0 = r24;
        r0 = r0.e;
        r23 = r0;
        monitor-enter(r23);
        r0 = r24;
        r1 = r0.f2647j;	 Catch:{ all -> 0x017b }
        if (r1 == 0) goto L_0x00e4;
    L_0x00dd:
        r0 = r24;
        r1 = r0.f2647j;	 Catch:{ all -> 0x017b }
        r1.m2448b();	 Catch:{ all -> 0x017b }
    L_0x00e4:
        r0 = r24;
        r1 = r0.a;	 Catch:{ all -> 0x017b }
        com.nuance.nmdp.speechkit.co.m2279b();	 Catch:{ all -> 0x017b }
        r0 = r24;
        r1 = r0.d;	 Catch:{ all -> 0x017b }
        if (r1 != 0) goto L_0x010c;
    L_0x00f1:
        r0 = r24;
        r1 = r0.f2645h;	 Catch:{ all -> 0x017b }
        r2 = new com.nuance.nmdp.speechkit.bk$a;	 Catch:{ all -> 0x017b }
        r3 = 0;
        r4 = 0;
        r2.<init>(r3, r4);	 Catch:{ all -> 0x017b }
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x017b }
        r0 = r24;
        r4 = r0.f2645h;	 Catch:{ all -> 0x017b }
        r4.mo329a();	 Catch:{ all -> 0x017b }
        r0 = r24;
        r1.mo327a(r2, r0, r3);	 Catch:{ all -> 0x017b }
    L_0x010c:
        r0 = r24;
        r1 = r0.a;	 Catch:{ all -> 0x017b }
        r1 = r1.m2300f();	 Catch:{ all -> 0x017b }
        r0 = r24;
        r0.f = r1;	 Catch:{ all -> 0x017b }
        r1 = new com.nuance.nmdp.speechkit.dm;	 Catch:{ all -> 0x017b }
        r0 = r24;
        r2 = r0.f2645h;	 Catch:{ all -> 0x017b }
        r0 = r24;
        r3 = r0.c;	 Catch:{ all -> 0x017b }
        r3 = (com.nuance.nmdp.speechkit.cn) r3;	 Catch:{ all -> 0x017b }
        r5 = r3.f2603a;	 Catch:{ all -> 0x017b }
        r0 = r24;
        r6 = r0.a;	 Catch:{ all -> 0x017b }
        r0 = r24;
        r3 = r0.c;	 Catch:{ all -> 0x017b }
        r3 = (com.nuance.nmdp.speechkit.cn) r3;	 Catch:{ all -> 0x017b }
        r7 = r3.m2231d();	 Catch:{ all -> 0x017b }
        r8 = "1";
        r9 = f2644k;	 Catch:{ all -> 0x017b }
        r11 = "enus";
        r12 = "ne";
        r0 = r24;
        r3 = r0.c;	 Catch:{ all -> 0x017b }
        r3 = (com.nuance.nmdp.speechkit.cn) r3;	 Catch:{ all -> 0x017b }
        r13 = r3.m2232e();	 Catch:{ all -> 0x017b }
        r0 = r24;
        r3 = r0.c;	 Catch:{ all -> 0x017b }
        r3 = (com.nuance.nmdp.speechkit.cn) r3;	 Catch:{ all -> 0x017b }
        r17 = r3.m2231d();	 Catch:{ all -> 0x017b }
        r18 = "";
        r0 = r24;
        r0 = r0.f2646i;	 Catch:{ all -> 0x017b }
        r21 = r0;
        r0 = r24;
        r0 = r0.f;	 Catch:{ all -> 0x017b }
        r22 = r0;
        r3 = r25;
        r4 = r26;
        r10 = r27;
        r14 = r28;
        r15 = r29;
        r16 = r30;
        r19 = r31;
        r20 = r24;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);	 Catch:{ all -> 0x017b }
        r0 = r24;
        r0.f2647j = r1;	 Catch:{ all -> 0x017b }
        r0 = r24;
        r1 = r0.f2647j;	 Catch:{ all -> 0x017b }
        monitor-exit(r23);	 Catch:{ all -> 0x017b }
        return r1;
    L_0x017b:
        r1 = move-exception;
        monitor-exit(r23);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.cr.a(com.nuance.nmdp.speechkit.ds, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.nuance.nmdp.speechkit.dp):com.nuance.nmdp.speechkit.do");
    }

    public final void mo241a() {
        f2643g.mo316b((Object) "freeResource() disconnectTimeout:0");
        if (this.f2647j != null) {
            this.f2647j.m2448b();
        }
        synchronized (this.e) {
            if (this.d == 2) {
                this.d = 0;
                Integer num = new Integer(0);
                bk bkVar = this.f2645h;
                C0416a c0416a = new C0416a((byte) 3, num);
                Thread currentThread = Thread.currentThread();
                this.f2645h.mo329a();
                bkVar.mo327a(c0416a, this, currentThread);
            } else {
                throw new cl("the resource was unloaded. ");
            }
        }
    }

    public final void mo244a(byte b, short s) {
        if (b == this.f) {
            if (this.f2647j != null) {
                this.f2647j.m2448b();
            }
            super.mo244a(b, s);
        }
    }

    public final void mo245a(byte b, byte[] bArr) {
        da a = db.m2395a(bArr);
        switch (a.m2391e()) {
            case (short) 29185:
                m2333a(b);
                if (this.f2647j != null) {
                    this.f2647j.m2443a((di) a, b);
                    return;
                }
                return;
            case (short) 29186:
                if (this.f2647j != null) {
                    this.f2647j.m2442a((dg) a, b);
                    return;
                }
                return;
            case (short) 29189:
                m2333a(b);
                if (this.f2647j != null) {
                    this.f2647j.m2444a((dj) a, b);
                    return;
                }
                return;
            default:
                f2643g.mo322e("Session.parseXModeMsgBcpData() Unknown command: " + a.m2391e() + ". ");
                return;
        }
    }

    public final void mo225a(Object obj, Object obj2) {
        switch (((C0416a) obj).f2477a) {
            case (byte) 0:
                super.m2319a((cp) this);
                return;
            case (byte) 3:
                this.a.m2296b((cp) this);
                cm cmVar = this.f2646i;
                return;
            default:
                super.mo225a(obj, obj2);
                return;
        }
    }

    public final void mo246a(short s) {
        f2643g.mo316b("onSessionDisconnected() reasonCode:" + s);
        if (this.f2647j != null) {
            this.f2647j.m2446a(s);
        }
        super.mo246a(s);
    }

    public final void mo247a(byte[] bArr) {
        super.mo247a(bArr);
        if (this.f2647j != null) {
            this.f2647j.m2447a(bArr);
        }
    }

    public final void mo250c() {
        this.f2647j.m2449c();
    }

    public final long mo255e() {
        return super.mo255e();
    }

    public final dp mo256g() {
        return new cx();
    }
}
