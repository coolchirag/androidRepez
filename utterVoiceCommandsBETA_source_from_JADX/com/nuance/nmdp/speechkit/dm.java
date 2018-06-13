package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.C0450do.C0451a;
import com.nuance.nmdp.speechkit.bi.C0378j;
import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0509c;
import java.util.Vector;

public class dm implements C0417b, C0450do {
    private static final bj f2685b = C0478j.m2563a(dm.class);
    protected byte f2686a;
    private cr f2687c;
    private cm f2688d;
    private ds f2689e = null;
    private co f2690f = null;
    private short f2691g = (short) -1;
    private bk f2692h;
    private bn f2693i;
    private long f2694j;
    private boolean f2695k = false;
    private C0448a f2696l;
    private Object f2697m;

    public final class C0448a {
        private int f2679a;
        private String f2680b;
        private String f2681c;
        private dm f2682d;
        private boolean f2683e;

        protected C0448a(int i, dm dmVar) {
            this.f2679a = i;
            if (dmVar.f2690f.m2298d() != null) {
                this.f2680b = co.m2277a(dmVar.f2690f.m2298d());
            } else {
                this.f2680b = "";
            }
            this.f2681c = "INTERNAL_ERROR";
            this.f2682d = dmVar;
            this.f2683e = false;
        }

        static /* synthetic */ void m2420a(C0448a c0448a, String str) {
            if (c0448a.f2681c.equals("INTERNAL_ERROR")) {
                c0448a.f2681c = str;
            } else {
                c0448a.f2681c += ":" + str;
            }
            dm.m2432a(c0448a.f2682d, c0448a);
        }

        protected final int m2421a() {
            return this.f2679a;
        }

        protected final void m2422a(C0451a c0451a) {
            if (this.f2681c.equals("INTERNAL_ERROR")) {
                this.f2681c = c0451a.toString();
            } else {
                this.f2681c += ":" + c0451a.toString();
            }
            dm.m2432a(this.f2682d, this);
        }

        protected final void m2423a(String str) {
            this.f2680b = str;
        }

        protected final String m2424b() {
            return this.f2680b;
        }

        protected final String m2425c() {
            return this.f2681c;
        }

        protected final void m2426d() {
            this.f2683e = true;
        }

        protected final boolean m2427e() {
            return this.f2683e;
        }
    }

    final class C0449b implements bn {
        private /* synthetic */ dm f2684a;

        C0449b(dm dmVar) {
            this.f2684a = dmVar;
        }

        public final void run() {
            try {
                synchronized (this.f2684a.f2697m) {
                    this.f2684a.f2691g = (short) -1;
                }
                if (this.f2684a.f2689e != null) {
                    dm.f2685b.mo316b((Object) "PDXTransactionImpl.end() timed out waiting for results. ");
                    try {
                        dm dmVar = this.f2684a;
                        dm.m2435b(this.f2684a.f2696l, "TIMEOUT_CMD");
                        this.f2684a.f2689e.mo300a((short) 1);
                    } catch (Throwable th) {
                        dm.f2685b.mo322e("got exp in PDXCommandListener.PDXCommandEvent(TIMED_OUT_WAITING_FOR_RESULT) [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                    }
                }
            } catch (Exception e) {
                dm.f2685b.mo322e("PDXTransactionImpl.run() " + e.getClass().getName() + " " + e.getMessage());
            }
        }
    }

    protected dm(bk bkVar, ds dsVar, String str, String str2, co coVar, String str3, String str4, String str5, String str6, String str7, String str8, bh bhVar, String str9, String str10, String str11, String str12, String str13, dp dpVar, cr crVar, cm cmVar, byte b) {
        if (f2685b.mo317b()) {
            f2685b.mo316b((Object) "PDXTransactionImpl()");
        }
        this.f2697m = new Object();
        this.f2692h = bkVar;
        this.f2690f = coVar;
        this.f2689e = dsVar;
        this.f2694j = 30000;
        this.f2687c = crVar;
        this.f2688d = cmVar;
        this.f2686a = b;
        if (((cn) crVar.m2326d()).m2276i() != null) {
            this.f2696l = new C0448a(this.f2686a, this);
            m2435b(this.f2696l, "INTERNAL_ERROR");
        }
        synchronized (this.f2697m) {
            this.f2691g = (short) 0;
        }
        Object obj = new Object[18];
        obj[0] = str3;
        obj[1] = str4;
        obj[2] = str5;
        obj[3] = str6;
        obj[4] = str7;
        obj[5] = str8;
        obj[6] = bhVar;
        obj[7] = str9;
        obj[8] = new Short((short) 1);
        obj[9] = new Short((short) 1);
        obj[10] = str10;
        obj[11] = str11;
        obj[12] = str12;
        obj[13] = str13;
        obj[14] = str2;
        obj[15] = str;
        obj[16] = dpVar;
        C0416a c0416a = new C0416a((byte) 1, obj);
        Thread currentThread = Thread.currentThread();
        bkVar.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    static /* synthetic */ void m2432a(dm dmVar, C0448a c0448a) {
        Vector vector = (Vector) ((cn) dmVar.f2687c.m2326d()).m2276i();
        if (vector == null) {
            f2685b.mo318c((Object) "appendLogToResLogs: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled.");
        } else if (!vector.contains(c0448a)) {
            vector.addElement(c0448a);
        }
    }

    private static String m2433b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < bArr.length) {
            String toHexString = Integer.toHexString(bArr[i]);
            if (toHexString.length() > 1) {
                stringBuffer.append(toHexString.substring(toHexString.length() - 2));
            } else {
                stringBuffer.append(toHexString);
            }
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append('-');
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private static void m2435b(C0448a c0448a, String str) {
        if (c0448a != null) {
            C0448a.m2420a(c0448a, str);
        }
    }

    public final void mo278a() {
        if (f2685b.mo317b()) {
            f2685b.mo316b((Object) "PDXTransactionImpl.end()");
        }
        synchronized (this.f2697m) {
            if (this.f2691g == (short) -1) {
                f2685b.mo322e("PDXTransactionImpl.end() transaction already finished!");
                throw new cc("transaction already finished!");
            }
            if (this.f2691g == (short) 0) {
                this.f2691g = (short) 1;
                bk bkVar = this.f2692h;
                C0416a c0416a = new C0416a((byte) 4, null);
                Thread currentThread = Thread.currentThread();
                this.f2692h.mo329a();
                bkVar.mo327a(c0416a, this, currentThread);
            } else if (this.f2691g == (short) 1) {
                f2685b.mo322e("PDXTransactionImpl.end() transaction already finished!");
                throw new cc("transaction already finished!");
            } else if (this.f2691g == (short) 2) {
                f2685b.mo322e("PDXTransactionImpl.end() transaction already expired!");
                throw new cd("transaction already expired!");
            }
        }
    }

    public final void mo279a(C0378j c0378j) {
        if (f2685b.mo317b()) {
            f2685b.mo316b((Object) "PDXTransactionImpl.sendParam()");
        }
        if (c0378j == null) {
            throw new NullPointerException("Parameter cannot be null");
        }
        synchronized (this.f2697m) {
            if (this.f2691g == (short) -1) {
                f2685b.mo322e("PDXTransactionImpl.sendParam() transaction already finished!");
                throw new cc("transaction already finished!");
            }
            if (this.f2691g == (short) 0) {
                bk bkVar = this.f2692h;
                C0416a c0416a = new C0416a((byte) 2, c0378j);
                Thread currentThread = Thread.currentThread();
                this.f2692h.mo329a();
                bkVar.mo327a(c0416a, this, currentThread);
            } else if (this.f2691g == (short) 1) {
                f2685b.mo322e("PDXTransactionImpl.sendParam() transaction already finished!");
                throw new cc("transaction already finished!");
            } else if (this.f2691g == (short) 2) {
                f2685b.mo322e("PDXTransactionImpl.sendParam() transaction already expired!");
                throw new cd("transaction already expired!");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2442a(com.nuance.nmdp.speechkit.dg r6, byte r7) {
        /*
        r5 = this;
        r2 = -1;
        r0 = f2685b;
        r1 = "PDXTransactionImpl.onQueryError()";
        r0.mo316b(r1);
        r0 = r5.f2686a;
        if (r7 == r0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r1 = r5.f2697m;
        monitor-enter(r1);
        r0 = r5.f2691g;	 Catch:{ all -> 0x001b }
        if (r0 == r2) goto L_0x0019;
    L_0x0014:
        r0 = r5.f2691g;	 Catch:{ all -> 0x001b }
        r2 = 2;
        if (r0 != r2) goto L_0x001e;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x000c;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x001e:
        r0 = -1;
        r5.f2691g = r0;	 Catch:{ all -> 0x001b }
        r0 = r5.f2693i;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r5.f2692h;	 Catch:{ all -> 0x001b }
        r2 = r5.f2693i;	 Catch:{ all -> 0x001b }
        r0.mo328a(r2);	 Catch:{ all -> 0x001b }
    L_0x002c:
        r0 = r5.f2689e;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x003c;
    L_0x0030:
        r0 = r5.f2696l;	 Catch:{ Throwable -> 0x003e }
        r2 = "QUERY_ERROR";
        m2435b(r0, r2);	 Catch:{ Throwable -> 0x003e }
        r0 = r5.f2689e;	 Catch:{ Throwable -> 0x003e }
        r0.mo298a(r6);	 Catch:{ Throwable -> 0x003e }
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x000c;
    L_0x003e:
        r0 = move-exception;
        r2 = f2685b;	 Catch:{ all -> 0x001b }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001b }
        r4 = "got exp in PDXCommandListener.PDXQueryErrorReturned() [";
        r3.<init>(r4);	 Catch:{ all -> 0x001b }
        r4 = r0.getClass();	 Catch:{ all -> 0x001b }
        r4 = r4.getName();	 Catch:{ all -> 0x001b }
        r3 = r3.append(r4);	 Catch:{ all -> 0x001b }
        r4 = "] msg [";
        r3 = r3.append(r4);	 Catch:{ all -> 0x001b }
        r0 = r0.getMessage();	 Catch:{ all -> 0x001b }
        r0 = r3.append(r0);	 Catch:{ all -> 0x001b }
        r3 = "]";
        r0 = r0.append(r3);	 Catch:{ all -> 0x001b }
        r0 = r0.toString();	 Catch:{ all -> 0x001b }
        r2.mo322e(r0);	 Catch:{ all -> 0x001b }
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.dm.a(com.nuance.nmdp.speechkit.dg, byte):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2443a(com.nuance.nmdp.speechkit.di r6, byte r7) {
        /*
        r5 = this;
        r0 = f2685b;
        r0 = r0.mo317b();
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = f2685b;
        r1 = "PDXTransactionImpl.onQueryResults()";
        r0.mo316b(r1);
    L_0x000f:
        r0 = r5.f2686a;
        if (r7 == r0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r1 = r5.f2697m;
        monitor-enter(r1);
        r0 = r5.f2691g;	 Catch:{ all -> 0x0023 }
        r2 = -1;
        if (r0 == r2) goto L_0x0021;
    L_0x001c:
        r0 = r5.f2691g;	 Catch:{ all -> 0x0023 }
        r2 = 2;
        if (r0 != r2) goto L_0x0026;
    L_0x0021:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x0013;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0026:
        r0 = r5.f2693i;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0037;
    L_0x002a:
        r0 = r6.m2401g();	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0037;
    L_0x0030:
        r0 = r5.f2692h;	 Catch:{ all -> 0x0023 }
        r2 = r5.f2693i;	 Catch:{ all -> 0x0023 }
        r0.mo328a(r2);	 Catch:{ all -> 0x0023 }
    L_0x0037:
        r0 = r5.f2689e;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x004d;
    L_0x003b:
        r0 = r6.m2401g();	 Catch:{ Throwable -> 0x004f }
        if (r0 == 0) goto L_0x0048;
    L_0x0041:
        r0 = r5.f2696l;	 Catch:{ Throwable -> 0x004f }
        r2 = "FINAL_RESULT";
        m2435b(r0, r2);	 Catch:{ Throwable -> 0x004f }
    L_0x0048:
        r0 = r5.f2689e;	 Catch:{ Throwable -> 0x004f }
        r0.mo297a(r6);	 Catch:{ Throwable -> 0x004f }
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x0013;
    L_0x004f:
        r0 = move-exception;
        r2 = f2685b;	 Catch:{ all -> 0x0023 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0023 }
        r4 = "got exp in PDXCommandListener.PDXQueryResultReturned() [";
        r3.<init>(r4);	 Catch:{ all -> 0x0023 }
        r4 = r0.getClass();	 Catch:{ all -> 0x0023 }
        r4 = r4.getName();	 Catch:{ all -> 0x0023 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0023 }
        r4 = "] msg [";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0023 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0023 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0023 }
        r3 = "]";
        r0 = r0.append(r3);	 Catch:{ all -> 0x0023 }
        r0 = r0.toString();	 Catch:{ all -> 0x0023 }
        r2.mo322e(r0);	 Catch:{ all -> 0x0023 }
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.dm.a(com.nuance.nmdp.speechkit.di, byte):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2444a(com.nuance.nmdp.speechkit.dj r6, byte r7) {
        /*
        r5 = this;
        r2 = -1;
        r0 = f2685b;
        r1 = "PDXTransactionImpl.onQueryRetry()";
        r0.mo316b(r1);
        r0 = r5.f2686a;
        if (r7 == r0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r1 = r5.f2697m;
        monitor-enter(r1);
        r0 = r5.f2691g;	 Catch:{ all -> 0x001b }
        if (r0 == r2) goto L_0x0019;
    L_0x0014:
        r0 = r5.f2691g;	 Catch:{ all -> 0x001b }
        r2 = 2;
        if (r0 != r2) goto L_0x001e;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x000c;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x001e:
        r0 = -1;
        r5.f2691g = r0;	 Catch:{ all -> 0x001b }
        r0 = r5.f2693i;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r5.f2692h;	 Catch:{ all -> 0x001b }
        r2 = r5.f2693i;	 Catch:{ all -> 0x001b }
        r0.mo328a(r2);	 Catch:{ all -> 0x001b }
    L_0x002c:
        r0 = r5.f2689e;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x003c;
    L_0x0030:
        r0 = r5.f2696l;	 Catch:{ Throwable -> 0x003e }
        r2 = "QUERY_RETRY";
        m2435b(r0, r2);	 Catch:{ Throwable -> 0x003e }
        r0 = r5.f2689e;	 Catch:{ Throwable -> 0x003e }
        r0.mo299a(r6);	 Catch:{ Throwable -> 0x003e }
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x000c;
    L_0x003e:
        r0 = move-exception;
        r2 = f2685b;	 Catch:{ all -> 0x001b }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001b }
        r4 = "got exp in PDXCommandListener.PDXQueryRetryReturned() [";
        r3.<init>(r4);	 Catch:{ all -> 0x001b }
        r4 = r0.getClass();	 Catch:{ all -> 0x001b }
        r4 = r4.getName();	 Catch:{ all -> 0x001b }
        r3 = r3.append(r4);	 Catch:{ all -> 0x001b }
        r4 = "] msg [";
        r3 = r3.append(r4);	 Catch:{ all -> 0x001b }
        r0 = r0.getMessage();	 Catch:{ all -> 0x001b }
        r0 = r3.append(r0);	 Catch:{ all -> 0x001b }
        r3 = "]";
        r0 = r0.append(r3);	 Catch:{ all -> 0x001b }
        r0 = r0.toString();	 Catch:{ all -> 0x001b }
        r2.mo322e(r0);	 Catch:{ all -> 0x001b }
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.dm.a(com.nuance.nmdp.speechkit.dj, byte):void");
    }

    public final void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        Object obj3 = c0416a.f2478b;
        switch (c0416a.f2477a) {
            case (byte) 1:
                Object[] objArr = (Object[]) obj3;
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                String str3 = (String) objArr[2];
                String str4 = (String) objArr[3];
                String str5 = (String) objArr[4];
                String str6 = (String) objArr[5];
                bh bhVar = (bh) objArr[6];
                String str7 = (String) objArr[7];
                short shortValue = ((Short) objArr[8]).shortValue();
                short shortValue2 = ((Short) objArr[9]).shortValue();
                String str8 = (String) objArr[10];
                String str9 = (String) objArr[11];
                String str10 = (String) objArr[12];
                String str11 = (String) objArr[13];
                byte[] d = this.f2690f.m2298d();
                String str12 = (String) objArr[14];
                String str13 = (String) objArr[15];
                dp dpVar = (dp) objArr[16];
                if (new C0509c(this.f2687c.b).m2665a()) {
                    bhVar = bu.m2187c(bhVar);
                }
                cq.m2313f();
                de deVar = new de(str, str2, str3, str4, str5, str6, bhVar, str7, shortValue, shortValue2, str8, str9, str10, str11, d, str12, str13, dpVar);
                Vector vector = (Vector) ((cn) this.f2687c.m2326d()).m2276i();
                if (vector == null) {
                    f2685b.mo318c((Object) "appendLogToQueryBegin: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled");
                } else if (vector.size() == 0) {
                    f2685b.mo318c((Object) "appendLogToQueryBegin: nmasResLogsToServer is empty, nothing to log to server");
                } else {
                    int size = vector.size();
                    dp cxVar = new cx();
                    dv dkVar = new dk();
                    for (int i = 0; i < size; i++) {
                        C0448a c0448a = (C0448a) vector.elementAt(i);
                        if (c0448a.m2421a() != this.f2686a) {
                            dp cxVar2 = new cx();
                            cxVar2.m2376a("id", c0448a.m2424b() + ":" + c0448a.m2421a(), (short) 193);
                            cxVar2.m2376a("status", c0448a.m2425c().toString(), (short) 193);
                            dkVar.m2412a(cxVar2);
                            c0448a.m2426d();
                        }
                    }
                    cxVar.m2374a("device_log", dkVar);
                    deVar.m2373a("app_info", cxVar);
                }
                this.f2690f.m2293a((short) 2597, "SEND_BCP_BEGIN" + this.f2686a, deVar.m2392f(), null, this.f2686a, 0, this.f2687c, false);
                if (d != null) {
                    try {
                        if (!this.f2695k) {
                            this.f2695k = true;
                            f2685b.mo316b("PDXCommandCreated() called from handleInit()" + m2433b(d) + ":" + this.f2686a + " (" + this + "," + this.f2688d + ")");
                            this.f2688d.mo296a(m2433b(d) + ":" + this.f2686a);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        f2685b.mo322e("got exp in PDXCommandListener.PDXCommandCreated() [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                        return;
                    }
                }
                return;
            case (byte) 2:
                C0378j c0378j = (C0378j) obj3;
                if (((dd) c0378j).m2354c() == Byte.MAX_VALUE) {
                    this.f2690f.m2286a(((dl) c0378j).m2417a(), ((dl) c0378j).m2419e());
                }
                cq.m2313f();
                this.f2690f.m2293a((short) 2585, "SEND_BCP_DATA", new dh((dd) c0378j).mo266d(), null, this.f2686a, 0, this.f2687c, false);
                return;
            case (byte) 3:
                byte[] bArr = (byte[]) obj3;
                cq.m2313f();
                this.f2690f.m2293a((short) 2585, "SEND_BCP_DATA", new cy(bArr).mo266d(), null, this.f2686a, 0, this.f2687c, false);
                return;
            case (byte) 4:
                cq.m2313f();
                this.f2690f.m2293a((short) 2585, "SEND_BCP_DATA", new df().mo266d(), null, this.f2686a, 0, this.f2687c, false);
                this.f2693i = new C0449b(this);
                this.f2692h.mo326a(this.f2693i, this.f2694j);
                return;
            case (byte) 5:
                this.f2689e.mo300a((short) 4);
                return;
            case (byte) 6:
                C0451a c0451a = (C0451a) obj3;
                C0448a c0448a2 = this.f2696l;
                if (c0448a2 != null) {
                    c0448a2.m2422a(c0451a);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void m2446a(short s) {
        if (f2685b.mo317b()) {
            f2685b.mo316b("PDXTransactionImpl.onSessionDisconnected() " + s);
        }
        synchronized (this.f2697m) {
            if (this.f2691g == (short) 1 && this.f2693i != null) {
                this.f2692h.mo328a(this.f2693i);
            }
            if (this.f2691g == (short) 2) {
                return;
            }
            if (s == (short) 0) {
                try {
                    if (this.f2691g != (short) -1) {
                        m2435b(this.f2696l, "REMOTE_DISC");
                        this.f2689e.mo300a((short) 3);
                    }
                } catch (Throwable th) {
                    f2685b.mo322e("got exp in PDXCommandListener.PDXCommandEvent() or PDXManagerListener.PDXManagerError() or PDXManagerListener.PDXManagerDisconnected() reasonCode [" + s + "] [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            } else if (s == (short) 1) {
                if (this.f2691g != (short) -1) {
                    this.f2689e.mo300a((short) 4);
                }
            } else if (s == (short) 3) {
                if (this.f2691g != (short) -1) {
                    m2435b(this.f2696l, "TIMEOUT_IDLE");
                    this.f2689e.mo300a((short) 5);
                }
            } else if (s == (short) 4) {
                if (this.f2691g != (short) -1) {
                    m2435b(this.f2696l, "CONN_FAILED");
                    this.f2688d.mo295a();
                }
            } else if (s == (short) 5) {
                if (this.f2691g != (short) -1) {
                    m2435b(this.f2696l, "CONN_FAILED");
                    this.f2688d.mo295a();
                }
            } else if (s == (short) 6) {
                if (this.f2691g != (short) -1) {
                    m2435b(this.f2696l, "REMOTE_DISC");
                    this.f2689e.mo300a((short) 3);
                }
            } else if (s == (short) 7) {
                if (this.f2691g != (short) -1) {
                    m2435b(this.f2696l, "CONN_FAILED");
                    this.f2688d.mo295a();
                }
            } else if (s == (short) 8 && this.f2691g != (short) -1) {
                m2435b(this.f2696l, "REMOTE_DISC");
                this.f2689e.mo300a((short) 3);
            }
            this.f2691g = (short) 2;
        }
    }

    public final void m2447a(byte[] bArr) {
        if (f2685b.mo317b()) {
            f2685b.mo316b((Object) "PDXTransactionImpl.onSessionConnected()");
        }
        synchronized (this.f2697m) {
            if (this.f2691g == (short) 0 || this.f2691g == (short) 1) {
                try {
                    String b = m2433b(bArr);
                    C0448a c0448a = this.f2696l;
                    if (c0448a != null) {
                        c0448a.m2423a(b);
                    }
                    if (!this.f2695k) {
                        this.f2695k = true;
                        f2685b.mo316b("PDXCommandCreated() called from onSessionConnected()" + b + ":" + this.f2686a + " (" + this + "," + this.f2688d + ")");
                        this.f2688d.mo296a(b + ":" + this.f2686a);
                    }
                } catch (Throwable th) {
                    f2685b.mo322e("got exp in PDXCommandListener.PDXCommandCreated() [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    public final void m2448b() {
        synchronized (this.f2697m) {
            if (this.f2691g == (short) 1 && this.f2693i != null) {
                this.f2692h.mo328a(this.f2693i);
            }
            if (this.f2691g == (short) 2) {
                return;
            }
            if (this.f2691g != (short) -1) {
                bk bkVar = this.f2692h;
                C0416a c0416a = new C0416a((byte) 5, null);
                Thread currentThread = Thread.currentThread();
                this.f2692h.mo329a();
                bkVar.mo327a(c0416a, this, currentThread);
            }
            this.f2691g = (short) 2;
        }
    }

    protected final void m2449c() {
        if (this.f2693i != null) {
            this.f2692h.mo328a(this.f2693i);
            this.f2692h.mo326a(this.f2693i, this.f2694j);
        }
    }
}
