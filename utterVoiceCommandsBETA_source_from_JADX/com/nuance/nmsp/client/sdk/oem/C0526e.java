package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmdp.speechkit.C0478j;
import com.nuance.nmdp.speechkit.bj;
import com.nuance.nmdp.speechkit.bk;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.bm;
import com.nuance.nmdp.speechkit.bm.C0418a;
import com.nuance.nmdp.speechkit.bm.C0419b;
import com.nuance.nmdp.speechkit.bm.C0420c;
import com.nuance.nmdp.speechkit.bm.C0421d;
import com.nuance.nmdp.speechkit.bm.C0422e;
import com.nuance.nmdp.speechkit.bm.C0423f;
import com.nuance.nmdp.speechkit.cb;
import com.nuance.nmdp.speechkit.eh;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class C0526e implements C0417b, bm {
    private static final bj f3014a = C0478j.m2563a(C0526e.class);
    private static final Integer f3015c = new Integer(0);
    private static final Integer f3016d = new Integer(1);
    private static final Integer f3017e = new Integer(2);
    private static final Integer f3018f = new Integer(3);
    private bk f3019b = null;
    private Object f3020g = new Object();

    final class C0523a extends Thread {
        private String f2994a = null;
        private int f2995b;
        private C0421d f2996c = null;
        private C0418a f2997d = null;
        private C0420c f2998e = C0420c.f2481a;
        private boolean f2999f = false;
        private Vector f3000g = null;
        private eh f3001h = null;
        private boolean f3002i = false;
        private /* synthetic */ C0526e f3003j;

        public C0523a(C0526e c0526e, String str, int i, C0421d c0421d, C0418a c0418a) {
            this.f3003j = c0526e;
            this.f2994a = str;
            this.f2995b = i;
            this.f2996c = c0421d;
            this.f2997d = c0418a;
            this.f3000g = new Vector();
        }

        public C0523a(C0526e c0526e, String str, int i, eh ehVar, C0421d c0421d, C0418a c0418a) {
            this.f3003j = c0526e;
            this.f2994a = str;
            this.f2995b = i;
            this.f2996c = c0421d;
            this.f2997d = c0418a;
            this.f3000g = new Vector();
            this.f3002i = true;
            this.f3001h = ehVar;
        }

        public final C0420c m2764a(C0524b c0524b) {
            if (this.f2999f) {
                if (C0526e.f3014a.mo323e()) {
                    C0526e.f3014a.mo322e("SocketReadThread is already stopping!");
                }
                return C0420c.f2482b;
            }
            C0420c c0420c;
            Object obj;
            C0420c c0420c2 = C0420c.f2481a;
            synchronized (this.f3003j.f3020g) {
                if (this.f3000g == null) {
                    c0420c = C0420c.f2482b;
                    obj = "SocketReadThread: queue is null!!";
                } else {
                    this.f3000g.addElement(c0524b);
                    c0420c = c0420c2;
                    obj = null;
                }
                this.f3003j.f3020g.notify();
            }
            if (!C0526e.f3014a.mo323e() || obj == null) {
                return c0420c;
            }
            C0526e.f3014a.mo322e(obj);
            return c0420c;
        }

        public final void m2765a() {
            synchronized (this.f3003j.f3020g) {
                this.f2999f = true;
                this.f3000g.removeAllElements();
                this.f3000g = null;
                this.f3003j.f3020g.notify();
            }
        }

        public final void m2766b() {
            Object obj = null;
            synchronized (this.f3003j.f3020g) {
                if (this.f3000g == null) {
                    obj = "SocketReadThread.cleanPendingJobs(): queue is null!!";
                } else {
                    this.f3000g.removeAllElements();
                }
            }
            if (C0526e.f3014a.mo323e() && obj != null) {
                C0526e.f3014a.mo322e(obj);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r12 = this;
            r11 = 3;
            r10 = 2;
            r9 = 0;
            r8 = 1;
            r7 = 0;
            r1 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r1 = r1.mo317b();
            if (r1 == 0) goto L_0x0039;
        L_0x000f:
            r1 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r2 = new java.lang.StringBuilder;
            r3 = "Open Socket connection on host:- [";
            r2.<init>(r3);
            r3 = r12.f2994a;
            r2 = r2.append(r3);
            r3 = "] and port[";
            r2 = r2.append(r3);
            r3 = r12.f2995b;
            r2 = r2.append(r3);
            r3 = "]";
            r2 = r2.append(r3);
            r2 = r2.toString();
            r1.mo316b(r2);
        L_0x0039:
            r1 = r12.f3002i;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            if (r1 == 0) goto L_0x0082;
        L_0x003d:
            r1 = r12.f2994a;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2 = r12.f2995b;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = r12.f3001h;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2 = com.nuance.nmdp.speechkit.ef.m2503a(r1, r2, r3);	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
        L_0x0047:
            r1 = r2.isConnected();	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            if (r1 != 0) goto L_0x0199;
        L_0x004d:
            r1 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r1 = r1.mo323e();	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            if (r1 == 0) goto L_0x0060;
        L_0x0057:
            r1 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2 = "SocketReadThread NETWORK_ERROR. !sock.isConnected()";
            r1.mo322e(r2);	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
        L_0x0060:
            r1 = r12.f3003j;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2 = 5;
            r2 = new java.lang.Object[r2];	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = 0;
            r4 = com.nuance.nmsp.client.sdk.oem.C0526e.f3015c;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2[r3] = r4;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = 1;
            r4 = r12.f2996c;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2[r3] = r4;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = 2;
            r4 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2[r3] = r4;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = 3;
            r4 = 0;
            r2[r3] = r4;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = 4;
            r4 = 0;
            r2[r3] = r4;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r1.m2770a(r2);	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
        L_0x0081:
            return;
        L_0x0082:
            r2 = new java.net.Socket;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r1 = r12.f2994a;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r3 = r12.f2995b;	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            r2.<init>(r1, r3);	 Catch:{ UnknownHostException -> 0x008c, IOException -> 0x00e5, SecurityException -> 0x013f }
            goto L_0x0047;
        L_0x008c:
            r1 = move-exception;
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r2 = r2.mo323e();
            if (r2 == 0) goto L_0x00c9;
        L_0x0097:
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r3 = new java.lang.StringBuilder;
            r4 = "Open Streams Exception - [";
            r3.<init>(r4);
            r4 = r1.getClass();
            r4 = r4.getName();
            r3 = r3.append(r4);
            r4 = "] Message - [";
            r3 = r3.append(r4);
            r1 = r1.getMessage();
            r1 = r3.append(r1);
            r3 = "]";
            r1 = r1.append(r3);
            r1 = r1.toString();
            r2.mo322e(r1);
        L_0x00c9:
            r1 = r12.f3003j;
            r2 = 5;
            r2 = new java.lang.Object[r2];
            r3 = com.nuance.nmsp.client.sdk.oem.C0526e.f3015c;
            r2[r7] = r3;
            r3 = r12.f2996c;
            r2[r8] = r3;
            r3 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;
            r2[r10] = r3;
            r2[r11] = r9;
            r3 = 4;
            r2[r3] = r9;
            r1.m2770a(r2);
            goto L_0x0081;
        L_0x00e5:
            r1 = move-exception;
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r2 = r2.mo323e();
            if (r2 == 0) goto L_0x0122;
        L_0x00f0:
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r3 = new java.lang.StringBuilder;
            r4 = "Open Streams Exception - [";
            r3.<init>(r4);
            r4 = r1.getClass();
            r4 = r4.getName();
            r3 = r3.append(r4);
            r4 = "] Message - [";
            r3 = r3.append(r4);
            r1 = r1.getMessage();
            r1 = r3.append(r1);
            r3 = "]";
            r1 = r1.append(r3);
            r1 = r1.toString();
            r2.mo322e(r1);
        L_0x0122:
            r1 = r12.f3003j;
            r2 = 5;
            r2 = new java.lang.Object[r2];
            r3 = com.nuance.nmsp.client.sdk.oem.C0526e.f3015c;
            r2[r7] = r3;
            r3 = r12.f2996c;
            r2[r8] = r3;
            r3 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;
            r2[r10] = r3;
            r2[r11] = r9;
            r3 = 4;
            r2[r3] = r9;
            r1.m2770a(r2);
            goto L_0x0081;
        L_0x013f:
            r1 = move-exception;
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r2 = r2.mo323e();
            if (r2 == 0) goto L_0x017c;
        L_0x014a:
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r3 = new java.lang.StringBuilder;
            r4 = "Open Streams Exception - [";
            r3.<init>(r4);
            r4 = r1.getClass();
            r4 = r4.getName();
            r3 = r3.append(r4);
            r4 = "] Message - [";
            r3 = r3.append(r4);
            r1 = r1.getMessage();
            r1 = r3.append(r1);
            r3 = "]";
            r1 = r1.append(r3);
            r1 = r1.toString();
            r2.mo322e(r1);
        L_0x017c:
            r1 = r12.f3003j;
            r2 = 5;
            r2 = new java.lang.Object[r2];
            r3 = com.nuance.nmsp.client.sdk.oem.C0526e.f3015c;
            r2[r7] = r3;
            r3 = r12.f2996c;
            r2[r8] = r3;
            r3 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;
            r2[r10] = r3;
            r2[r11] = r9;
            r3 = 4;
            r2[r3] = r9;
            r1.m2770a(r2);
            goto L_0x0081;
        L_0x0199:
            r1 = r12.f3002i;	 Catch:{ Exception -> 0x0261 }
            if (r1 == 0) goto L_0x01a5;
        L_0x019d:
            r0 = r2;
            r0 = (javax.net.ssl.SSLSocket) r0;	 Catch:{ Exception -> 0x0261 }
            r1 = r0;
            r3 = 1;
            r1.setUseClientMode(r3);	 Catch:{ Exception -> 0x0261 }
        L_0x01a5:
            r1 = 1;
            r2.setTcpNoDelay(r1);	 Catch:{ Exception -> 0x0261 }
            r1 = 1;
            r2.setKeepAlive(r1);	 Catch:{ Exception -> 0x0261 }
            r1 = 1;
            r3 = 40;
            r2.setSoLinger(r1, r3);	 Catch:{ Exception -> 0x0261 }
        L_0x01b3:
            r4 = r2.getInputStream();	 Catch:{ IOException -> 0x02a0 }
            r5 = r2.getOutputStream();	 Catch:{ IOException -> 0x02a0 }
            r1 = new com.nuance.nmsp.client.sdk.oem.e$c;
            r3 = r12.f2997d;
            r6 = r12;
            r1.<init>(r2, r3, r4, r5, r6);
            r2 = r12.f3003j;
            r3 = 5;
            r3 = new java.lang.Object[r3];
            r5 = com.nuance.nmsp.client.sdk.oem.C0526e.f3015c;
            r3[r7] = r5;
            r5 = r12.f2996c;
            r3[r8] = r5;
            r5 = com.nuance.nmdp.speechkit.bm.C0420c.f2481a;
            r3[r10] = r5;
            r3[r11] = r1;
            r5 = 4;
            r3[r5] = r9;
            r2.m2770a(r3);
        L_0x01de:
            r2 = r12.f2999f;	 Catch:{ Exception -> 0x0228 }
            if (r2 != 0) goto L_0x0081;
        L_0x01e2:
            r2 = r12.f3003j;	 Catch:{ Exception -> 0x0228 }
            r3 = r2.f3020g;	 Catch:{ Exception -> 0x0228 }
            monitor-enter(r3);	 Catch:{ Exception -> 0x0228 }
        L_0x01e9:
            r2 = r12.f2999f;	 Catch:{ all -> 0x0225 }
            if (r2 != 0) goto L_0x02fd;
        L_0x01ed:
            r2 = r12.f3000g;	 Catch:{ all -> 0x0225 }
            if (r2 == 0) goto L_0x02fd;
        L_0x01f1:
            r2 = r12.f3000g;	 Catch:{ all -> 0x0225 }
            r2 = r2.isEmpty();	 Catch:{ all -> 0x0225 }
            if (r2 == 0) goto L_0x02fd;
        L_0x01f9:
            r2 = r12.f3003j;	 Catch:{ Exception -> 0x0203 }
            r2 = r2.f3020g;	 Catch:{ Exception -> 0x0203 }
            r2.wait();	 Catch:{ Exception -> 0x0203 }
            goto L_0x01e9;
        L_0x0203:
            r2 = move-exception;
            r5 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;	 Catch:{ all -> 0x0225 }
            r5 = r5.mo323e();	 Catch:{ all -> 0x0225 }
            if (r5 == 0) goto L_0x01e9;
        L_0x020e:
            r5 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;	 Catch:{ all -> 0x0225 }
            r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0225 }
            r8 = "InterruptedException ie:";
            r6.<init>(r8);	 Catch:{ all -> 0x0225 }
            r2 = r6.append(r2);	 Catch:{ all -> 0x0225 }
            r2 = r2.toString();	 Catch:{ all -> 0x0225 }
            r5.mo322e(r2);	 Catch:{ all -> 0x0225 }
            goto L_0x01e9;
        L_0x0225:
            r1 = move-exception;
            monitor-exit(r3);	 Catch:{ Exception -> 0x0228 }
            throw r1;	 Catch:{ Exception -> 0x0228 }
        L_0x0228:
            r1 = move-exception;
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r2 = r2.mo323e();
            if (r2 == 0) goto L_0x0081;
        L_0x0233:
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r3 = new java.lang.StringBuilder;
            r4 = "NetworkSystemJ2me.run() ";
            r3.<init>(r4);
            r4 = r1.getClass();
            r4 = r4.getName();
            r3 = r3.append(r4);
            r4 = " ";
            r3 = r3.append(r4);
            r1 = r1.getMessage();
            r1 = r3.append(r1);
            r1 = r1.toString();
            r2.mo322e(r1);
            goto L_0x0081;
        L_0x0261:
            r1 = move-exception;
            r3 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r3 = r3.mo323e();
            if (r3 == 0) goto L_0x01b3;
        L_0x026c:
            r3 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r4 = new java.lang.StringBuilder;
            r5 = "Set Socket Option Exception - [";
            r4.<init>(r5);
            r5 = r1.getClass();
            r5 = r5.getName();
            r4 = r4.append(r5);
            r5 = "] Message - [";
            r4 = r4.append(r5);
            r1 = r1.getMessage();
            r1 = r4.append(r1);
            r4 = "]";
            r1 = r1.append(r4);
            r1 = r1.toString();
            r3.mo322e(r1);
            goto L_0x01b3;
        L_0x02a0:
            r1 = move-exception;
            r2.close();	 Catch:{ IOException -> 0x040f }
        L_0x02a4:
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r2 = r2.mo323e();
            if (r2 == 0) goto L_0x02e0;
        L_0x02ae:
            r2 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;
            r3 = new java.lang.StringBuilder;
            r4 = "Set Socket Option Exception - [";
            r3.<init>(r4);
            r4 = r1.getClass();
            r4 = r4.getName();
            r3 = r3.append(r4);
            r4 = "] Message - [";
            r3 = r3.append(r4);
            r1 = r1.getMessage();
            r1 = r3.append(r1);
            r3 = "]";
            r1 = r1.append(r3);
            r1 = r1.toString();
            r2.mo322e(r1);
        L_0x02e0:
            r1 = r12.f3003j;
            r2 = 5;
            r2 = new java.lang.Object[r2];
            r3 = com.nuance.nmsp.client.sdk.oem.C0526e.f3015c;
            r2[r7] = r3;
            r3 = r12.f2996c;
            r2[r8] = r3;
            r3 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;
            r2[r10] = r3;
            r2[r11] = r9;
            r3 = 4;
            r2[r3] = r9;
            r1.m2770a(r2);
            goto L_0x0081;
        L_0x02fd:
            r2 = r12.f2999f;	 Catch:{ all -> 0x0225 }
            if (r2 != 0) goto L_0x0305;
        L_0x0301:
            r2 = r12.f3000g;	 Catch:{ all -> 0x0225 }
            if (r2 != 0) goto L_0x0308;
        L_0x0305:
            monitor-exit(r3);	 Catch:{ all -> 0x0225 }
            goto L_0x0081;
        L_0x0308:
            r2 = r12.f3000g;	 Catch:{ all -> 0x0225 }
            r5 = 0;
            r2 = r2.elementAt(r5);	 Catch:{ all -> 0x0225 }
            r2 = (com.nuance.nmsp.client.sdk.oem.C0526e.C0524b) r2;	 Catch:{ all -> 0x0225 }
            r5 = r12.f3000g;	 Catch:{ all -> 0x0225 }
            r6 = 0;
            r5.removeElementAt(r6);	 Catch:{ all -> 0x0225 }
            monitor-exit(r3);	 Catch:{ all -> 0x0225 }
            r3 = r7;
        L_0x0319:
            r5 = r2.f3005b;	 Catch:{ IOException -> 0x0381 }
            if (r3 >= r5) goto L_0x0332;
        L_0x031d:
            r5 = r2.f3004a;	 Catch:{ IOException -> 0x0381 }
            r6 = r3 + 0;
            r8 = r2.f3005b;	 Catch:{ IOException -> 0x0381 }
            r8 = r8 - r3;
            r5 = r4.read(r5, r6, r8);	 Catch:{ IOException -> 0x0381 }
            if (r5 >= 0) goto L_0x037f;
        L_0x032a:
            r3 = r12.f2999f;	 Catch:{ IOException -> 0x0381 }
            if (r3 != 0) goto L_0x0332;
        L_0x032e:
            r3 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;	 Catch:{ IOException -> 0x0381 }
            r12.f2998e = r3;	 Catch:{ IOException -> 0x0381 }
        L_0x0332:
            r3 = r12.f2998e;	 Catch:{ Exception -> 0x0228 }
            r5 = com.nuance.nmdp.speechkit.bm.C0420c.f2481a;	 Catch:{ Exception -> 0x0228 }
            if (r3 != r5) goto L_0x03c4;
        L_0x0338:
            r3 = r12.f3003j;	 Catch:{ Exception -> 0x0228 }
            r5 = 9;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0228 }
            r6 = 0;
            r8 = com.nuance.nmsp.client.sdk.oem.C0526e.f3017e;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 1;
            r8 = r2.f3006c;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 2;
            r8 = com.nuance.nmdp.speechkit.bm.C0420c.f2481a;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 3;
            r5[r6] = r1;	 Catch:{ Exception -> 0x0228 }
            r6 = 4;
            r8 = r2.f3004a;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 5;
            r8 = new java.lang.Integer;	 Catch:{ Exception -> 0x0228 }
            r9 = 0;
            r8.<init>(r9);	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 6;
            r8 = new java.lang.Integer;	 Catch:{ Exception -> 0x0228 }
            r9 = r2.f3005b;	 Catch:{ Exception -> 0x0228 }
            r8.<init>(r9);	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 7;
            r8 = new java.lang.Integer;	 Catch:{ Exception -> 0x0228 }
            r9 = r2.f3005b;	 Catch:{ Exception -> 0x0228 }
            r8.<init>(r9);	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 8;
            r2 = r2.f3007d;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r2;	 Catch:{ Exception -> 0x0228 }
            r3.m2770a(r5);	 Catch:{ Exception -> 0x0228 }
            goto L_0x01de;
        L_0x037f:
            r3 = r3 + r5;
            goto L_0x0319;
        L_0x0381:
            r3 = move-exception;
            r5 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;	 Catch:{ Exception -> 0x0228 }
            r5 = r5.mo323e();	 Catch:{ Exception -> 0x0228 }
            if (r5 == 0) goto L_0x03be;
        L_0x038c:
            r5 = com.nuance.nmsp.client.sdk.oem.C0526e.f3014a;	 Catch:{ Exception -> 0x0228 }
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0228 }
            r8 = "Socket Read/Available Expception - [";
            r6.<init>(r8);	 Catch:{ Exception -> 0x0228 }
            r8 = r3.getClass();	 Catch:{ Exception -> 0x0228 }
            r8 = r8.getName();	 Catch:{ Exception -> 0x0228 }
            r6 = r6.append(r8);	 Catch:{ Exception -> 0x0228 }
            r8 = "] Message - [";
            r6 = r6.append(r8);	 Catch:{ Exception -> 0x0228 }
            r3 = r3.getMessage();	 Catch:{ Exception -> 0x0228 }
            r3 = r6.append(r3);	 Catch:{ Exception -> 0x0228 }
            r6 = "]";
            r3 = r3.append(r6);	 Catch:{ Exception -> 0x0228 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x0228 }
            r5.mo322e(r3);	 Catch:{ Exception -> 0x0228 }
        L_0x03be:
            r3 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;	 Catch:{ Exception -> 0x0228 }
            r12.f2998e = r3;	 Catch:{ Exception -> 0x0228 }
            goto L_0x0332;
        L_0x03c4:
            r3 = r12.f3003j;	 Catch:{ Exception -> 0x0228 }
            r5 = 9;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0228 }
            r6 = 0;
            r8 = com.nuance.nmsp.client.sdk.oem.C0526e.f3017e;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 1;
            r8 = r2.f3006c;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 2;
            r8 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 3;
            r5[r6] = r1;	 Catch:{ Exception -> 0x0228 }
            r6 = 4;
            r8 = r2.f3004a;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 5;
            r8 = new java.lang.Integer;	 Catch:{ Exception -> 0x0228 }
            r9 = 0;
            r8.<init>(r9);	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 6;
            r8 = new java.lang.Integer;	 Catch:{ Exception -> 0x0228 }
            r9 = r2.f3005b;	 Catch:{ Exception -> 0x0228 }
            r8.<init>(r9);	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 7;
            r8 = new java.lang.Integer;	 Catch:{ Exception -> 0x0228 }
            r9 = 0;
            r8.<init>(r9);	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r8;	 Catch:{ Exception -> 0x0228 }
            r6 = 8;
            r2 = r2.f3007d;	 Catch:{ Exception -> 0x0228 }
            r5[r6] = r2;	 Catch:{ Exception -> 0x0228 }
            r3.m2770a(r5);	 Catch:{ Exception -> 0x0228 }
            r2 = r12.f3003j;	 Catch:{ Exception -> 0x0228 }
            r2.mo335a(r1);	 Catch:{ Exception -> 0x0228 }
            goto L_0x01de;
        L_0x040f:
            r2 = move-exception;
            goto L_0x02a4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.e.a.run():void");
        }
    }

    final class C0524b {
        byte[] f3004a;
        int f3005b;
        C0422e f3006c;
        Object f3007d;

        public C0524b(byte[] bArr, int i, C0422e c0422e, Object obj) {
            this.f3004a = bArr;
            this.f3005b = i;
            this.f3006c = c0422e;
            this.f3007d = obj;
        }
    }

    final class C0525c {
        Socket f3008a;
        C0418a f3009b;
        InputStream f3010c = null;
        OutputStream f3011d = null;
        Object f3012e = null;
        C0523a f3013f = null;

        public C0525c(Socket socket, C0418a c0418a, InputStream inputStream, OutputStream outputStream, C0523a c0523a) {
            this.f3008a = socket;
            this.f3009b = c0418a;
            this.f3012e = null;
            this.f3010c = inputStream;
            this.f3011d = outputStream;
            this.f3013f = c0523a;
        }
    }

    public C0526e(bk bkVar) {
        this.f3019b = bkVar;
    }

    private void m2770a(Object[] objArr) {
        bk bkVar = this.f3019b;
        Object b = this.f3019b.mo330b();
        this.f3019b.mo329a();
        bkVar.mo327a(objArr, this, b);
    }

    public final C0420c mo333a(Object obj, C0419b c0419b, byte[] bArr, int i, C0422e c0422e, Object obj2) {
        if (c0419b != C0419b.f2480a) {
            if (f3014a.mo323e()) {
                f3014a.mo322e("Blackberry NetworkSystem only supports NETWORK_READ_FULL");
            }
            return C0420c.f2482b;
        }
        C0525c c0525c = (C0525c) obj;
        if (c0525c.f3013f == null) {
            if (f3014a.mo317b()) {
                f3014a.mo316b((Object) "SOCKET READ ERROR: socket read thread is null");
            }
            return C0420c.f2482b;
        } else if (c0525c.f3013f.f2999f) {
            if (f3014a.mo323e()) {
                f3014a.mo322e("socket read thread is stopping");
            }
            return C0420c.f2482b;
        } else {
            return c0525c.f3013f.m2764a(new C0524b(bArr, i, c0422e, obj2));
        }
    }

    public final C0420c mo334a(Object obj, byte[] bArr, int i, C0423f c0423f, Object obj2) {
        C0525c c0525c = (C0525c) obj;
        if (c0525c.f3008a == null || c0525c.f3011d == null) {
            return C0420c.f2482b;
        }
        OutputStream outputStream = c0525c.f3011d;
        try {
            outputStream.write(bArr, 0, i);
            outputStream.flush();
            m2770a(new Object[]{f3018f, c0423f, C0420c.f2481a, obj, bArr, new Integer(0), new Integer(i), new Integer(i), obj2});
            return C0420c.f2481a;
        } catch (Exception e) {
            if (f3014a.mo323e()) {
                f3014a.mo322e("Socket Write Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
            }
            m2770a(new Object[]{f3018f, c0423f, C0420c.f2482b, obj, bArr, new Integer(0), new Integer(i), new Integer(0), obj2});
            mo335a(obj);
            return C0420c.f2482b;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo335a(java.lang.Object r11) {
        /*
        r10 = this;
        r9 = 3;
        r8 = 2;
        r2 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11;
        r0 = (com.nuance.nmsp.client.sdk.oem.C0526e.C0525c) r0;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r4 = r10.f3020g;
        monitor-enter(r4);
        r1 = r0.f3013f;	 Catch:{ all -> 0x0014 }
        if (r1 != 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r4);	 Catch:{ all -> 0x0014 }
        goto L_0x000a;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0017:
        r1 = r0.f3013f;	 Catch:{ all -> 0x0014 }
        r1 = r1.f2999f;	 Catch:{ all -> 0x0014 }
        if (r1 != 0) goto L_0x00a9;
    L_0x001f:
        r1 = r0.f3013f;	 Catch:{ all -> 0x0014 }
        r1.m2765a();	 Catch:{ all -> 0x0014 }
        r1 = 0;
        r0.f3013f = r1;	 Catch:{ all -> 0x0014 }
        r1 = r2;
    L_0x0028:
        monitor-exit(r4);	 Catch:{ all -> 0x0014 }
        r4 = r0.f3008a;
        if (r4 == 0) goto L_0x000a;
    L_0x002d:
        if (r1 == 0) goto L_0x000a;
    L_0x002f:
        r1 = r0.f3010c;	 Catch:{ Throwable -> 0x0057 }
        r1.close();	 Catch:{ Throwable -> 0x0057 }
        r1 = 0;
        r0.f3010c = r1;	 Catch:{ Throwable -> 0x0057 }
        r1 = r0.f3008a;	 Catch:{ Throwable -> 0x0057 }
        r1.close();	 Catch:{ Throwable -> 0x0057 }
        r1 = 0;
        r0.f3008a = r1;	 Catch:{ Throwable -> 0x0057 }
        r1 = 5;
        r1 = new java.lang.Object[r1];
        r4 = f3016d;
        r1[r3] = r4;
        r0 = r0.f3009b;
        r1[r2] = r0;
        r0 = com.nuance.nmdp.speechkit.bm.C0420c.f2481a;
        r1[r8] = r0;
        r1[r9] = r11;
        r0 = 4;
        r1[r0] = r7;
        r10.m2770a(r1);
        goto L_0x000a;
    L_0x0057:
        r1 = move-exception;
        r4 = f3014a;
        r4 = r4.mo323e();
        if (r4 == 0) goto L_0x0090;
    L_0x0060:
        r4 = f3014a;
        r5 = new java.lang.StringBuilder;
        r6 = "Socket Close Expception - [";
        r5.<init>(r6);
        r6 = r1.getClass();
        r6 = r6.getName();
        r5 = r5.append(r6);
        r6 = "] Message - [";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r5 = "]";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r4.mo322e(r1);
    L_0x0090:
        r1 = 5;
        r1 = new java.lang.Object[r1];
        r4 = f3016d;
        r1[r3] = r4;
        r0 = r0.f3009b;
        r1[r2] = r0;
        r0 = com.nuance.nmdp.speechkit.bm.C0420c.f2482b;
        r1[r8] = r0;
        r1[r9] = r11;
        r0 = 4;
        r1[r0] = r7;
        r10.m2770a(r1);
        goto L_0x000a;
    L_0x00a9:
        r1 = r3;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.e.a(java.lang.Object):void");
    }

    public final void mo225a(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        if (objArr[0] == f3015c) {
            ((C0421d) objArr[1]).mo222a((C0420c) objArr[2], objArr[3]);
        } else if (objArr[0] == f3016d) {
            ((C0418a) objArr[1]).mo221a();
        } else if (objArr[0] == f3017e) {
            ((C0422e) objArr[1]).mo224a((C0420c) objArr[2], objArr[3], (byte[]) objArr[4], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), objArr[8]);
        } else if (objArr[0] == f3018f) {
            ((C0423f) objArr[1]).mo223a((C0420c) objArr[2], objArr[3], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), objArr[8]);
        }
    }

    public final void mo336a(String str, int i, C0421d c0421d, C0418a c0418a) {
        try {
            new C0523a(this, str, i, c0421d, c0418a).start();
        } catch (Exception e) {
            if (f3014a.mo323e()) {
                f3014a.mo322e("Open Socket Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
            }
            m2770a(new Object[]{f3015c, c0421d, C0420c.f2482b, null, null});
        }
    }

    public final void mo337a(String str, int i, Vector vector, C0421d c0421d, C0418a c0418a) {
        eh ehVar = new eh();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            cb cbVar = (cb) elements.nextElement();
            if (cbVar.m2234a().equals("SSL_SelfSigned_Cert") && (new String(cbVar.m2235b()).equals("TRUE") || new String(cbVar.m2235b()).equals("true"))) {
                ehVar.f2749a = true;
            }
            if (cbVar.m2234a().equals("SSL_Cert_Summary")) {
                ehVar.f2750b = new String(cbVar.m2235b());
            }
            if (cbVar.m2234a().equals("SSL_Cert_Data")) {
                ehVar.f2751c = new String(cbVar.m2235b());
            }
        }
        try {
            new C0523a(this, str, i, ehVar, c0421d, c0418a).start();
        } catch (Exception e) {
            if (f3014a.mo323e()) {
                f3014a.mo322e("Open Socket Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
            }
            m2770a(new Object[]{f3015c, c0421d, C0420c.f2482b, null, null});
        }
    }

    public final void mo338b(Object obj) {
        C0525c c0525c = (C0525c) obj;
        if (c0525c.f3013f != null) {
            c0525c.f3013f.m2766b();
            return;
        }
        if (f3014a.mo317b()) {
            f3014a.mo316b((Object) "SOCKET WRITE ERROR: socket read thread is null");
        }
        mo335a(obj);
    }
}
