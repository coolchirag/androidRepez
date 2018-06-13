package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.bm.C0418a;
import com.nuance.nmdp.speechkit.bm.C0419b;
import com.nuance.nmdp.speechkit.bm.C0420c;
import com.nuance.nmdp.speechkit.bm.C0421d;
import com.nuance.nmdp.speechkit.bm.C0422e;
import com.nuance.nmdp.speechkit.bm.C0423f;
import com.nuance.nmdp.speechkit.cb.C0445a;
import com.nuance.nmsp.client.sdk.oem.C0526e;
import java.util.Enumeration;
import java.util.Vector;

public class by implements C0417b, C0418a, C0421d, C0422e, C0423f {
    private static bj f2501c = C0478j.m2563a(by.class);
    protected byte f2502a;
    public byte[] f2503b;
    private bn f2504d;
    private int f2505e = 30;
    private bn f2506f;
    private int f2507g = 50;
    private bn f2508h;
    private String f2509i = null;
    private short f2510j = (short) 0;
    private Vector f2511k;
    private boolean f2512l = false;
    private Vector f2513m = null;
    private bk f2514n = null;
    private Object f2515o;
    private bp f2516p = null;
    private short f2517q = (short) 0;
    private String f2518r = "Not specified";
    private String f2519s = "Not specified";
    private byte[] f2520t = null;
    private bm f2521u = null;
    private String f2522v = "";
    private int f2523w;
    private short f2524x;
    private short f2525y;
    private C0424a f2526z;

    public interface C0424a {
        void mo239a(bp bpVar, byte[] bArr);

        void mo240a(short s);
    }

    final class C0425b implements bn {
        private /* synthetic */ by f2494a;

        C0425b(by byVar) {
            this.f2494a = byVar;
        }

        public final void run() {
            try {
                this.f2494a.m2194a((byte) 5);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.readSocketCallback() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    final class C0426c implements bn {
        private /* synthetic */ by f2495a;

        C0426c(by byVar) {
            this.f2495a = byVar;
        }

        public final void run() {
            try {
                this.f2495a.f2517q = (short) 3;
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("Session Idle for too long, longer than [" + this.f2495a.f2507g + "] ()");
                }
                this.f2495a.f2502a = (byte) 2;
                this.f2495a.m2194a((byte) 4);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.sendXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    final class C0427d implements bn {
        private /* synthetic */ by f2496a;

        C0427d(by byVar) {
            this.f2496a = byVar;
        }

        public final void run() {
            try {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.handleSendCopConnect() COP CONNECT timed out. ");
                }
                this.f2496a.m2194a((byte) 9);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.handleSendCopConnect() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    final class C0428e implements bn {
        private /* synthetic */ by f2497a;

        C0428e(by byVar) {
            this.f2497a = byVar;
        }

        public final void run() {
            try {
                this.f2497a.m2194a((byte) 6);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.readSocketCallback() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    final class C0429f implements bn {
        private /* synthetic */ by f2498a;

        C0429f(by byVar) {
            this.f2498a = byVar;
        }

        public final void run() {
            try {
                this.f2498a.f2517q = (short) 3;
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("Session Idle for too long, longer than [" + this.f2498a.f2507g + "] (initiated from XMode.parseBcp)");
                }
                this.f2498a.f2502a = (byte) 2;
                this.f2498a.m2194a((byte) 4);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.parseXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    final class C0430g implements bn {
        private /* synthetic */ by f2499a;

        C0430g(by byVar) {
            this.f2499a = byVar;
        }

        public final void run() {
            try {
                this.f2499a.f2517q = (short) 3;
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("Session Idle for too long, longer than [" + this.f2499a.f2507g + "] (initiated from XMode.parseCopConnected)");
                }
                this.f2499a.f2502a = (byte) 2;
                this.f2499a.m2194a((byte) 4);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.parseXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    final class C0431h implements bn {
        private /* synthetic */ by f2500a;

        C0431h(by byVar) {
            this.f2500a = byVar;
        }

        public final void run() {
            try {
                this.f2500a.f2517q = (short) 3;
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("Session Idle for too long, longer than [" + this.f2500a.f2507g + "] (initiated from XMode.parseVap)");
                }
                this.f2500a.f2502a = (byte) 2;
                this.f2500a.m2194a((byte) 4);
            } catch (Exception e) {
                if (by.f2501c.mo323e()) {
                    by.f2501c.mo322e("XMode.parseXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                }
            }
        }
    }

    public by(String str, short s, String str2, byte[] bArr, String str3, C0424a c0424a, Vector vector, bk bkVar) {
        this.f2509i = str;
        this.f2510j = s;
        this.f2518r = str2;
        this.f2520t = bArr;
        this.f2519s = str3;
        this.f2526z = c0424a;
        if (vector != null) {
            this.f2511k = vector;
        } else {
            this.f2511k = new Vector();
        }
        this.f2514n = bkVar;
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode() server: " + str + " port: " + s);
        }
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            cb cbVar = (cb) elements.nextElement();
            if (f2501c.mo317b()) {
                f2501c.mo316b("XMode() " + cbVar.m2237d() + " : " + cbVar.m2234a() + " = " + new String(cbVar.m2235b()));
            }
            if (cbVar.m2237d() == C0445a.f2559a) {
                if (cbVar.m2234a().equals("IdleSessionTimeout")) {
                    int parseInt = Integer.parseInt(new String(cbVar.m2235b()));
                    if (parseInt > 0) {
                        this.f2507g = parseInt;
                    }
                } else if (cbVar.m2234a().equals("ConnectionTimeout")) {
                    this.f2505e = Integer.parseInt(new String(cbVar.m2235b()));
                } else if (cbVar.m2234a().equals("SSL_Socket_Enable") || cbVar.m2234a().equals("SSL_Cert_Summary") || cbVar.m2234a().equals("SSL_Cert_Data") || cbVar.m2234a().equals("SSL_SelfSigned_Cert")) {
                    if (cbVar.m2234a().equals("SSL_Socket_Enable") && (new String(cbVar.m2235b()).equals("TRUE") || new String(cbVar.m2235b()).equals("true"))) {
                        this.f2512l = true;
                    }
                    if (this.f2513m == null) {
                        this.f2513m = new Vector();
                    }
                    this.f2513m.addElement(cbVar);
                }
            }
        }
        this.f2502a = (byte) 3;
    }

    private void m2194a(byte b) {
        try {
            bk bkVar = this.f2514n;
            C0416a c0416a = new C0416a(b, null);
            Thread currentThread = Thread.currentThread();
            this.f2514n.mo329a();
            bkVar.mo327a(c0416a, this, currentThread);
        } catch (Exception e) {
            if (f2501c.mo323e()) {
                f2501c.mo322e("XMode.sendCmdMsg() " + e.getMessage());
            }
        }
    }

    private void m2195a(bp bpVar, byte[] bArr) {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.parseXModeMsg() protocol: " + bpVar.f2486a + " cmd: " + bpVar.f2487b);
        }
        switch (bpVar.f2486a) {
            case (byte) 1:
                if (this.f2508h != null && this.f2514n.mo328a(this.f2508h)) {
                    this.f2508h = new C0431h(this);
                    this.f2514n.mo326a(this.f2508h, (long) (this.f2507g * 1000));
                }
                this.f2526z.mo239a(bpVar, bArr);
                return;
            case (byte) 2:
                if (this.f2508h != null && this.f2514n.mo328a(this.f2508h)) {
                    this.f2508h = new C0429f(this);
                    this.f2514n.mo326a(this.f2508h, (long) (this.f2507g * 1000));
                }
                this.f2526z.mo239a(bpVar, bArr);
                return;
            case (byte) 3:
                switch (bpVar.f2487b) {
                    case (short) 257:
                        this.f2514n.mo328a(this.f2506f);
                        this.f2503b = new byte[16];
                        System.arraycopy(bArr, 0, this.f2503b, 0, 16);
                        bk bkVar = this.f2514n;
                        byte[] bArr2 = this.f2503b;
                        bm bmVar = this.f2521u;
                        Object obj = this.f2515o;
                        bArr2 = this.f2503b;
                        this.f2522v = bj.m2139b(this.f2503b);
                        bj bjVar = f2501c;
                        String str = this.f2522v;
                        bjVar.mo324f();
                        try {
                            if (f2501c.mo317b()) {
                                f2501c.mo316b("Received COP_Connected " + this.f2522v);
                            }
                            m2194a((byte) 10);
                            this.f2508h = new C0430g(this);
                            this.f2514n.mo326a(this.f2508h, (long) (this.f2507g * 1000));
                            break;
                        } finally {
                            f2501c.mo325g();
                        }
                    case (short) 258:
                        this.f2523w = br.m2181b(bArr, 0);
                        m2194a((byte) 8);
                        break;
                    case (short) 512:
                        if (this.f2508h != null) {
                            this.f2514n.mo328a(this.f2508h);
                        }
                        this.f2502a = (byte) 2;
                        this.f2517q = (short) 6;
                        if (f2501c.mo321d()) {
                            f2501c.mo320d("XMode.parseXModeMsgCopDisconnect() Received COP DISCONNECT. ");
                        }
                        m2194a((byte) 4);
                        break;
                    case (short) 768:
                        this.f2517q = (short) 7;
                        this.f2502a = (byte) 2;
                        if (f2501c.mo323e()) {
                            f2501c.mo322e("XMode.parseXModeMsgCopConnectFailed() COP CONNECT failure. ");
                        }
                        m2194a((byte) 4);
                        break;
                }
                this.f2526z.mo239a(bpVar, bArr);
                return;
            case (byte) 15:
                return;
            default:
                if (f2501c.mo323e()) {
                    f2501c.mo322e("XMode.parseXModeMsg() unknown protocol: " + Integer.toHexString(bpVar.f2486a));
                    return;
                }
                return;
        }
    }

    public final void mo221a() {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.closeSocketCallback() " + this.f2522v);
        }
        this.f2502a = (byte) 3;
        if (this.f2504d != null) {
            this.f2514n.mo328a(this.f2504d);
            this.f2504d = null;
        }
        if (this.f2508h != null) {
            this.f2514n.mo328a(this.f2508h);
            this.f2508h = null;
        }
        if (this.f2515o != null) {
            this.f2526z.mo240a(this.f2517q);
        }
        this.f2515o = null;
        this.f2521u = null;
        this.f2503b = null;
        this.f2522v = "";
    }

    public final void m2200a(int i) {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.startStreaming() audio id: " + i);
        }
        if (this.f2502a == (byte) 1) {
            byte[] bArr = new byte[6];
            br.m2179a(i, bArr, 0);
            br.m2180a(this.f2524x, bArr, 4);
            m2207a(bo.m2174a((byte) 1, (byte) 18, (short) 257, bArr), (Object) "SEND_VAP_RECORD_BEGIN");
        }
    }

    public final void mo222a(C0420c c0420c, Object obj) {
        if (f2501c.mo317b()) {
            f2501c.mo316b((Object) "XMode.openSocketCallback() ");
        }
        if (c0420c == C0420c.f2481a) {
            this.f2515o = obj;
            if (this.f2502a == (byte) 0) {
                m2194a((byte) 7);
                return;
            }
            this.f2502a = (byte) 2;
            this.f2521u.mo335a(this.f2515o);
        } else if (c0420c == C0420c.f2482b) {
            if (f2501c.mo323e()) {
                f2501c.mo322e("XMode.openSocketCallback() NETWORK_ERROR");
            }
            this.f2502a = (byte) 3;
            this.f2517q = (short) 4;
            this.f2526z.mo240a(this.f2517q);
            this.f2515o = null;
            this.f2521u = null;
            this.f2503b = null;
            this.f2522v = "";
        } else if (c0420c == C0420c.f2483c) {
            this.f2517q = (short) 4;
            if (f2501c.mo323e()) {
                f2501c.mo322e("XMode.openSocketCallback() NETWORK_MEMORY_ERROR");
            }
        }
    }

    public final void mo223a(C0420c c0420c, Object obj, int i, int i2, Object obj2) {
        String str = (String) obj2;
        if (c0420c == C0420c.f2481a && i == i2) {
            if (str.equals("SEND_COP_CONNECT")) {
                m2194a((byte) 5);
            } else if (str.equals("SEND_COP_DISCONNECT")) {
                this.f2521u.mo335a(obj);
            }
        } else if (c0420c == C0420c.f2482b) {
            if (!(this.f2517q == (short) 1 || this.f2517q == (short) 3)) {
                this.f2517q = (short) 8;
                if (f2501c.mo323e()) {
                    f2501c.mo322e("XMode.writeSocketCallback() NETWORK_ERROR");
                }
            }
            m2194a((byte) 4);
        } else if (c0420c == C0420c.f2483c && this.f2517q != (short) 1 && this.f2517q != (short) 3) {
            this.f2517q = (short) 8;
            if (f2501c.mo323e()) {
                f2501c.mo322e("XMode.writeSocketCallback() NETWORK_MEMORY_ERROR");
            }
        }
    }

    public final void mo224a(C0420c c0420c, Object obj, byte[] bArr, int i, int i2, Object obj2) {
        String str = (String) obj2;
        if (f2501c.mo317b()) {
            f2501c.mo316b((Object) "Read callback");
        }
        if (f2501c.mo315a()) {
            f2501c.m2143a(bArr);
        }
        if (c0420c == C0420c.f2481a) {
            if (str.equals("READ_XMODE_HEADER")) {
                if (i2 == 0) {
                    this.f2504d = new C0425b(this);
                    this.f2514n.mo326a(this.f2504d, 20);
                } else if (i2 == i) {
                    this.f2516p = new bp(bArr);
                    if (this.f2516p.f2488c == 0) {
                        m2195a(this.f2516p, null);
                        m2194a((byte) 5);
                    } else if (this.f2516p.f2488c > 512000 || this.f2516p.f2488c < 0) {
                        this.f2521u.mo338b(obj);
                        m2194a((byte) 5);
                    } else {
                        m2194a((byte) 6);
                    }
                } else if (f2501c.mo323e()) {
                    f2501c.mo322e("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_HEADER bytesRead:[" + i2 + "] bufferLen:[" + i + "]");
                }
            } else if (!str.equals("READ_XMODE_PAYLOAD")) {
            } else {
                if (i2 == 0) {
                    if (f2501c.mo317b()) {
                        f2501c.mo316b(Integer.toHexString(this.f2516p.f2487b) + " payload not read bytesRead is 0");
                    }
                    this.f2504d = new C0428e(this);
                    this.f2514n.mo326a(this.f2504d, 20);
                } else if (i2 == i) {
                    if (this.f2516p.f2488c <= i) {
                        m2195a(this.f2516p, bArr);
                    }
                    m2194a((byte) 5);
                } else if (f2501c.mo323e()) {
                    f2501c.mo322e("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_PAYLOAD bytesRead:[" + i2 + "] bufferLen:[" + i + "]");
                }
            }
        } else if (c0420c == C0420c.f2482b) {
            if (!(this.f2517q == (short) 1 || this.f2517q == (short) 3)) {
                this.f2517q = (short) 8;
                if (f2501c.mo323e()) {
                    f2501c.mo322e("XMode.readSocketCallback() NETWORK_ERROR");
                }
            }
            m2194a((byte) 4);
        } else if (c0420c == C0420c.f2483c && this.f2517q != (short) 1 && this.f2517q != (short) 3) {
            this.f2517q = (short) 8;
            if (f2501c.mo323e()) {
                f2501c.mo322e("XMode.readSocketCallback() NETWORK_MEMORY_ERROR");
            }
        }
    }

    public final void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        byte[] bArr;
        Object bytes;
        C0424a c0424a;
        switch (c0416a.f2477a) {
            case (byte) 1:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_CONNECT");
                }
                if (this.f2502a == (byte) 0) {
                    m2194a((byte) 3);
                    return;
                } else {
                    this.f2526z.mo240a(this.f2517q);
                    return;
                }
            case (byte) 2:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_DISCONNECT");
                }
                bArr = new byte[2];
                br.m2180a((short) 0, bArr, 0);
                bArr = bo.m2174a((byte) 3, (byte) 23, (short) 512, bArr);
                this.f2521u.mo338b(this.f2515o);
                m2207a(bArr, (Object) "SEND_COP_DISCONNECT");
                return;
            case (byte) 3:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_OPEN_SOCKET");
                }
                if (this.f2502a == (byte) 0) {
                    this.f2521u = new C0526e(this.f2514n);
                    if (this.f2512l) {
                        this.f2521u.mo337a(this.f2509i, this.f2510j, this.f2513m, (C0421d) this, (C0418a) this);
                        return;
                    } else {
                        this.f2521u.mo336a(this.f2509i, this.f2510j, this, this);
                        return;
                    }
                }
                this.f2526z.mo240a(this.f2517q);
                return;
            case (byte) 4:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_CLOSE_SOCKET");
                }
                if (this.f2521u != null && this.f2515o != null) {
                    this.f2521u.mo335a(this.f2515o);
                    return;
                }
                return;
            case (byte) 5:
                if (this.f2521u != null && this.f2515o != null) {
                    this.f2521u.mo333a(this.f2515o, C0419b.f2480a, new byte[8], 8, this, "READ_XMODE_HEADER");
                    return;
                }
                return;
            case (byte) 6:
                if (this.f2516p.f2488c > 0 && this.f2516p.f2488c <= 512000) {
                    byte[] bArr2 = new byte[this.f2516p.f2488c];
                    if (this.f2521u != null && this.f2515o != null) {
                        this.f2521u.mo333a(this.f2515o, C0419b.f2480a, bArr2, bArr2.length, this, "READ_XMODE_PAYLOAD");
                        return;
                    }
                    return;
                }
                return;
            case (byte) 7:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_COP_CONNECT");
                }
                if (this.f2502a == (byte) 0) {
                    String str = "<?xml version=\"1.0\"?><cc><s></s><t>7</t><b>20091023</b><tsc>" + this.f2524x + "</tsc><fsc>" + this.f2525y + "</fsc><nmaid>" + this.f2518r + "</nmaid><uid>" + this.f2519s + "</uid>";
                    Enumeration elements = this.f2511k.elements();
                    String str2 = str;
                    byte b = (byte) 0;
                    while (elements.hasMoreElements()) {
                        String str3;
                        byte b2;
                        cb cbVar = (cb) elements.nextElement();
                        if (cbVar.m2237d() == C0445a.f2560b) {
                            str2 = str2 + "<nmsp p=\"" + cbVar.m2234a() + "\" v=\"" + bu.m2182a(new String(cbVar.m2235b())) + "\"/>";
                            if (cbVar.m2234a().equals("Ping_IntervalSecs")) {
                                str3 = str2;
                                b2 = (byte) 1;
                                if (cbVar.m2237d() != C0445a.f2561c) {
                                    str = str3 + "<app p=\"" + cbVar.m2234a() + "\" v=\"" + bu.m2182a(new String(cbVar.m2235b())) + "\"/>";
                                } else {
                                    str = str3;
                                }
                                b = b2;
                                str2 = str;
                            }
                        }
                        String str4 = str2;
                        b2 = b;
                        str3 = str4;
                        if (cbVar.m2237d() != C0445a.f2561c) {
                            str = str3;
                        } else {
                            str = str3 + "<app p=\"" + cbVar.m2234a() + "\" v=\"" + bu.m2182a(new String(cbVar.m2235b())) + "\"/>";
                        }
                        b = b2;
                        str2 = str;
                    }
                    if (b == (byte) 0) {
                        str2 = str2 + "<nmsp p=\"Ping_IntervalSecs\" v=\"0\"/>";
                    }
                    bytes = (str2 + "</cc>").getBytes();
                    int length = bytes.length;
                    int i = (length + 4) + 1;
                    byte[] bArr3 = new byte[i];
                    br.m2179a(i - 4, bArr3, 0);
                    bArr3[4] = (byte) 0;
                    System.arraycopy(bytes, 0, bArr3, 5, length);
                    m2207a(bo.m2174a((byte) 3, (byte) 23, (short) 256, bArr3), (Object) "SEND_COP_CONNECT");
                    this.f2506f = new C0427d(this);
                    this.f2514n.mo326a(this.f2506f, (long) (this.f2505e * 1000));
                    this.f2502a = (byte) 1;
                    c0424a = this.f2526z;
                    return;
                }
                return;
            case (byte) 8:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_COP_PING_RESPONSE");
                }
                bArr = new byte[8];
                br.m2179a(this.f2523w, bArr, 0);
                br.m2179a(0, bArr, 4);
                m2207a(bo.m2174a((byte) 3, (byte) 23, (short) 259, bArr), (Object) "SEND_COP_PING_RESPONSE");
                return;
            case (byte) 9:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_COP_CONNECT_TIMED_OUT");
                }
                if (this.f2502a == (byte) 1) {
                    this.f2502a = (byte) 2;
                    this.f2517q = (short) 5;
                    if (f2501c.mo323e()) {
                        f2501c.mo322e("XMode.handleCopConnectTimeout() COP CONNECT timed out. ");
                    }
                    m2194a((byte) 4);
                    return;
                }
                return;
            case (byte) 10:
                if (f2501c.mo317b()) {
                    f2501c.mo316b((Object) "XMode.handleMessage() CMD_COP_CONFIRM");
                }
                bytes = bl.m2162b(this.f2520t, this.f2503b);
                byte[] bArr4 = new byte[(bytes.length + 4)];
                br.m2179a(bytes.length, bArr4, 0);
                System.arraycopy(bytes, 0, bArr4, 4, bytes.length);
                m2207a(bo.m2174a((byte) 3, (byte) 23, (short) 262, bArr4), (Object) "SEND_COP_CONFIRM");
                return;
            case (byte) 11:
                bytes = c0416a.f2478b;
                c0424a = this.f2526z;
                return;
            case (byte) 12:
                bytes = c0416a.f2478b;
                c0424a = this.f2526z;
                return;
            default:
                return;
        }
    }

    public final void m2205a(short s, short s2) {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.connect() codec: " + s2);
        }
        if (this.f2502a != (byte) 1 && this.f2502a != (byte) 0) {
            if (this.f2502a == (byte) 2) {
                if (this.f2504d != null) {
                    this.f2514n.mo328a(this.f2504d);
                }
                if (this.f2508h != null) {
                    this.f2514n.mo328a(this.f2508h);
                }
                this.f2515o = null;
                this.f2521u = null;
                this.f2503b = null;
                this.f2522v = "";
                this.f2524x = s;
                this.f2525y = s2;
                this.f2502a = (byte) 0;
                m2194a((byte) 1);
            } else if (this.f2502a == (byte) 3) {
                this.f2524x = s;
                this.f2525y = s2;
                this.f2502a = (byte) 0;
                m2194a((byte) 1);
            }
        }
    }

    public final void m2206a(byte[] bArr, int i) {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.sendVapRecordMsg() audio id: " + i);
        }
        if (this.f2502a == (byte) 1) {
            int length = bArr.length;
            byte[] bArr2 = new byte[(length + 8)];
            br.m2179a(i, bArr2, 0);
            br.m2179a(length, bArr2, 4);
            System.arraycopy(bArr, 0, bArr2, 8, length);
            m2207a(bo.m2174a((byte) 1, (byte) 18, (short) 513, bArr2), (Object) "SEND_VAP_RECORD");
        }
    }

    public final void m2207a(byte[] bArr, Object obj) {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.sendXModeMsg() " + obj);
        }
        if (this.f2508h != null && this.f2514n.mo328a(this.f2508h)) {
            this.f2508h = new C0426c(this);
            this.f2514n.mo326a(this.f2508h, (long) (this.f2507g * 1000));
        }
        if (this.f2521u != null && this.f2515o != null) {
            this.f2521u.mo334a(this.f2515o, bArr, bArr.length, (C0423f) this, obj);
        }
    }

    public final void m2208b() {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.disconnect() state:" + this.f2502a + ", socket:" + this.f2515o);
        }
        if (this.f2502a == (byte) 3) {
            this.f2517q = (short) 1;
            this.f2526z.mo240a(this.f2517q);
        } else if (this.f2502a == (byte) 2) {
        } else {
            if (this.f2502a == (byte) 0) {
                this.f2517q = (short) 1;
                this.f2502a = (byte) 2;
                if (this.f2515o != null) {
                    this.f2521u.mo335a(this.f2515o);
                }
            } else if (this.f2502a == (byte) 1) {
                this.f2502a = (byte) 2;
                this.f2517q = (short) 1;
                m2194a((byte) 2);
            }
        }
    }

    public final void m2209b(int i) {
        if (f2501c.mo317b()) {
            f2501c.mo316b("XMode.sendVapRecordEnd() audio id: " + i);
        }
        if (this.f2502a == (byte) 1) {
            byte[] bArr = new byte[4];
            br.m2179a(i, bArr, 0);
            m2207a(bo.m2174a((byte) 1, (byte) 18, (short) 256, bArr), (Object) "SEND_VAP_RECORD_END");
        }
    }
}
