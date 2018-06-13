package com.nuance.nmdp.speechkit;

import com.faceture.google.play.QueryParamConst;
import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.by.C0424a;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Vector;

public class co implements C0417b, C0424a {
    private static final bj f2606a = C0478j.m2563a(co.class);
    private static byte[] f2607l = new byte[16];
    private static int f2608o = 1;
    private static String[] f2609t = new String[]{QueryParamConst.U_VALUE, "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    private Hashtable f2610b;
    private Hashtable f2611c;
    private by f2612d;
    private String f2613e;
    private short f2614f;
    private Vector f2615g;
    private bk f2616h;
    private cj f2617i;
    private Vector f2618j;
    private byte[] f2619k = null;
    private bh f2620m;
    private bh f2621n;
    private boolean f2622p = false;
    private ck f2623q;
    private long f2624r = 1;
    private byte f2625s = (byte) 1;

    public co(String str, short s, String str2, byte[] bArr, String str3, Vector vector, bk bkVar, cj cjVar) {
        this.f2613e = str;
        this.f2614f = s;
        this.f2616h = bkVar;
        this.f2617i = cjVar;
        this.f2623q = null;
        this.f2618j = new Vector();
        this.f2610b = new Hashtable();
        this.f2611c = new Hashtable();
        this.f2615g = new Vector();
        this.f2612d = new by(this.f2613e, this.f2614f, str2, bArr, str3, this, vector, bkVar);
    }

    public static String m2277a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < 16) {
            byte b = bArr[i];
            stringBuffer.append(f2609t[(byte) (((byte) (((byte) (b & 240)) >>> 4)) & 15)] + f2609t[(byte) (b & 15)]);
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append("-");
            }
            i++;
        }
        return stringBuffer.toString().toLowerCase();
    }

    private void m2278a(byte b, Object obj) {
        bk bkVar = this.f2616h;
        C0416a c0416a = new C0416a(b, obj);
        Thread currentThread = Thread.currentThread();
        this.f2616h.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    public static void m2279b() {
    }

    private void m2280b(byte[] bArr) {
        byte b = bArr[16];
        short a = br.m2178a(bArr, 17);
        for (int i = 0; i < this.f2615g.size(); i++) {
            ((cp) this.f2615g.elementAt(i)).mo244a(b, a);
        }
    }

    private void m2281c(byte[] bArr) {
        int b = br.m2181b(bArr, 0);
        if (this.f2611c.size() != 0) {
            bz bzVar = (bz) this.f2611c.get(new Integer(b));
            if (bzVar == null) {
                f2606a.mo322e("Could not find the audio sink associated with AID: " + b);
                return;
            }
            int b2 = br.m2181b(bArr, 4);
            b = 8;
            if (bu.m2186b(this.f2621n)) {
                while ((bArr[b] & 128) > 0) {
                    b++;
                    b2--;
                }
                b++;
                b2--;
            }
            if (b2 > 0 && b2 <= bArr.length - b) {
                try {
                    bzVar.mo219a(bArr, b, b2, false);
                } catch (ce e) {
                    f2606a.mo322e(e.getMessage());
                }
            }
        }
    }

    private void m2282h() {
        while (!this.f2618j.isEmpty()) {
            C0416a c0416a = (C0416a) this.f2618j.firstElement();
            this.f2618j.removeElementAt(0);
            switch (c0416a.f2477a) {
                case (byte) 1:
                    m2278a((byte) 1, c0416a.f2478b);
                    break;
                case (byte) 2:
                    m2278a((byte) 2, c0416a.f2478b);
                    break;
                case (byte) 4:
                    m2278a((byte) 4, c0416a.f2478b);
                    break;
                case (byte) 5:
                    m2278a((byte) 5, c0416a.f2478b);
                    break;
                case (byte) 6:
                    m2278a((byte) 6, c0416a.f2478b);
                    break;
                case (byte) 7:
                    m2278a((byte) 7, c0416a.f2478b);
                    break;
                case (byte) 8:
                    m2278a((byte) 8, c0416a.f2478b);
                    break;
                default:
                    break;
            }
        }
    }

    public final synchronized int m2283a() {
        int i;
        i = f2608o;
        f2608o = i + 1;
        if (f2608o == Integer.MIN_VALUE) {
            f2608o = 1;
        }
        return i;
    }

    public final void m2284a(byte b, int i, cp cpVar) {
        f2606a.mo316b("freeResource, TID: " + b + ", disconnect timeout: " + i);
        this.f2615g.removeElement(cpVar);
        Object obj = new Object[]{new Byte(b), new Integer(i)};
        if (this.f2619k == null || !this.f2618j.isEmpty()) {
            this.f2618j.addElement(new C0416a((byte) 4, obj));
        } else {
            m2278a((byte) 4, obj);
        }
    }

    public final void m2285a(int i) {
        if (f2606a.mo317b()) {
            f2606a.mo316b("vapRecordBegin, AID: " + i);
        }
        Object num = new Integer(i);
        if (this.f2619k == null || !this.f2618j.isEmpty()) {
            this.f2618j.addElement(new C0416a((byte) 5, num));
        } else {
            m2278a((byte) 5, num);
        }
    }

    public final void m2286a(int i, bz bzVar) {
        this.f2611c.put(new Integer(i), bzVar);
    }

    public final void m2287a(bh bhVar, bh bhVar2) {
        if (f2606a.mo317b()) {
            f2606a.mo316b((Object) "connect()");
        }
        this.f2620m = bhVar;
        this.f2621n = bhVar2;
        m2278a((byte) 1, null);
    }

    public final void mo239a(bp bpVar, byte[] bArr) {
        if (f2606a.mo317b()) {
            f2606a.mo316b("xmodeMsgCallback, protocol: " + bpVar.f2486a + ", command: " + bpVar.f2487b);
        }
        int b;
        switch (bpVar.f2486a) {
            case (byte) 1:
                switch (bpVar.f2487b) {
                    case (short) 512:
                        m2281c(bArr);
                        return;
                    case (short) 1024:
                        b = br.m2181b(bArr, 0);
                        if (this.f2611c.size() != 0) {
                            bz bzVar = (bz) this.f2611c.remove(new Integer(b));
                            if (bzVar == null) {
                                f2606a.mo322e("Could not find the audio sink associated with AID: " + b);
                                return;
                            }
                            try {
                                bzVar.mo219a(null, 0, 0, true);
                                return;
                            } catch (ce e) {
                                f2606a.mo322e(e.getMessage());
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            case (byte) 2:
                byte b2;
                short a;
                cp cpVar;
                long b3;
                int b4;
                byte[] bArr2;
                int b5;
                switch (bpVar.f2487b) {
                    case (short) 2576:
                        b2 = bArr[16];
                        int b6 = br.m2181b(bArr, 17);
                        a = br.m2178a(bArr, 21);
                        short a2 = br.m2178a(bArr, 23);
                        short a3 = br.m2178a(bArr, 25);
                        cpVar = (cp) this.f2610b.get(new Long((long) b6));
                        if (cpVar != null) {
                            cpVar.mo242a(b2, (long) b6, a, a2, a3);
                            if (a != (short) 200) {
                                this.f2610b.remove(new Long((long) b6));
                                return;
                            }
                            return;
                        }
                        return;
                    case (short) 2577:
                        long b7 = (long) br.m2181b(bArr, 17);
                        br.m2181b(bArr, 21);
                        br.m2178a(bArr, 25);
                        this.f2610b.remove(new Long(b7));
                        return;
                    case (short) 2578:
                        return;
                    case (short) 2579:
                        b3 = (long) br.m2181b(bArr, 17);
                        br.m2178a(bArr, 21);
                        b4 = br.m2181b(bArr, 23);
                        if (b4 > 0 && b4 <= bArr.length - 27) {
                            System.arraycopy(bArr, 27, new byte[b4], 0, b4);
                        }
                        this.f2610b.remove(new Long(b3));
                        return;
                    case (short) 2580:
                        b3 = (long) br.m2181b(bArr, 17);
                        br.m2178a(bArr, 21);
                        b4 = br.m2181b(bArr, 23);
                        if (b4 > 0 && b4 <= bArr.length - 27) {
                            System.arraycopy(bArr, 27, new byte[b4], 0, b4);
                        }
                        this.f2610b.get(new Long(b3));
                        return;
                    case (short) 2582:
                        bArr2 = null;
                        b2 = bArr[16];
                        b5 = br.m2181b(bArr, 17);
                        a = br.m2178a(bArr, 21);
                        b4 = br.m2181b(bArr, 23);
                        if (b4 > 0 && b4 <= bArr.length - 27) {
                            bArr2 = new byte[b4];
                            System.arraycopy(bArr, 27, bArr2, 0, b4);
                        }
                        cpVar = (cp) this.f2610b.remove(new Long((long) b5));
                        if (cpVar != null) {
                            cpVar.mo243a(b2, (long) b5, a, bArr2);
                            return;
                        }
                        return;
                    case (short) 2584:
                        bArr2 = null;
                        b2 = bArr[16];
                        b5 = br.m2181b(bArr, 17);
                        a = br.m2178a(bArr, 21);
                        b4 = br.m2181b(bArr, 23);
                        if (b4 > 0 && b4 <= bArr.length - 27) {
                            bArr2 = new byte[b4];
                            System.arraycopy(bArr, 27, bArr2, 0, b4);
                        }
                        cpVar = (cp) this.f2610b.remove(new Long((long) b5));
                        if (cpVar != null) {
                            cpVar.mo249b(b2, (long) b5, a, bArr2);
                            return;
                        }
                        return;
                    case (short) 2585:
                        b2 = bArr[16];
                        b5 = br.m2181b(bArr, 21);
                        if (b5 > 0 && b5 <= bArr.length - 25) {
                            byte[] bArr3 = new byte[b5];
                            System.arraycopy(bArr, 25, bArr3, 0, b5);
                            cpVar = (cp) this.f2610b.get(new Long(0));
                            if (cpVar != null) {
                                cpVar.mo245a(b2, bArr3);
                                return;
                            }
                            return;
                        }
                        return;
                    case (short) 2600:
                        m2280b(bArr);
                        return;
                    default:
                        f2606a.mo322e("Unknown BCP command");
                        return;
                }
            case (byte) 3:
                switch (bpVar.f2487b) {
                    case (short) 257:
                        this.f2619k = this.f2612d.f2503b;
                        if (f2606a.mo317b()) {
                            f2606a.mo316b("connected(" + m2277a(this.f2619k) + ") called on " + this.f2617i);
                        }
                        cj cjVar = this.f2617i;
                        String a4 = m2277a(this.f2619k);
                        ck ckVar = this.f2623q;
                        cjVar.mo302a(a4);
                        for (b = 0; b < this.f2615g.size(); b++) {
                            ((cp) this.f2615g.elementAt(b)).mo247a(this.f2619k);
                        }
                        m2282h();
                        return;
                    case (short) 512:
                    case (short) 768:
                        return;
                    default:
                        return;
                }
            default:
                f2606a.mo322e("Unknown Xmode protocol");
                return;
        }
    }

    public final void m2289a(ck ckVar) {
        this.f2623q = ckVar;
    }

    public final void m2290a(cp cpVar) {
        if (!this.f2615g.contains(cpVar)) {
            this.f2615g.addElement(cpVar);
        }
    }

    public final void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        Object[] objArr;
        byte byteValue;
        switch (c0416a.f2477a) {
            case (byte) 1:
                this.f2612d.m2205a(this.f2620m.m2119a(), this.f2621n.m2119a());
                return;
            case (byte) 2:
                this.f2612d.m2208b();
                return;
            case (byte) 3:
                this.f2612d.m2208b();
                this.f2622p = true;
                return;
            case (byte) 4:
                if (this.f2619k != null) {
                    objArr = (Object[]) c0416a.f2478b;
                    byteValue = ((Byte) objArr[0]).byteValue();
                    int intValue = ((Integer) objArr[1]).intValue();
                    byte[] bArr = new byte[5];
                    bArr[0] = byteValue;
                    br.m2179a(intValue, bArr, 1);
                    this.f2612d.m2207a(bo.m2174a((byte) 2, (byte) 34, (short) 2601, bo.m2175a(bArr, this.f2619k)), (Object) "SEND_BCP_FREE_RESOURCE");
                    return;
                }
                return;
            case (byte) 5:
                if (this.f2619k != null) {
                    this.f2612d.m2200a(((Integer) c0416a.f2478b).intValue());
                    return;
                }
                return;
            case (byte) 6:
                if (this.f2619k != null) {
                    objArr = (Object[]) c0416a.f2478b;
                    byte[] bArr2 = (byte[]) objArr[0];
                    int intValue2 = ((Integer) objArr[1]).intValue();
                    for (int i = 0; i < this.f2615g.size(); i++) {
                        ((cp) this.f2615g.elementAt(i)).mo250c();
                    }
                    this.f2612d.m2206a(bArr2, intValue2);
                    return;
                }
                return;
            case (byte) 7:
                if (this.f2619k != null) {
                    this.f2612d.m2209b(((Integer) c0416a.f2478b).intValue());
                    return;
                }
                return;
            case (byte) 8:
                if (this.f2619k != null) {
                    Object[] objArr2 = (Object[]) c0416a.f2478b;
                    short shortValue = ((Short) objArr2[0]).shortValue();
                    Object obj3 = (String) objArr2[1];
                    byte[] bArr3 = (byte[]) objArr2[2];
                    byte[] bArr4 = (byte[]) objArr2[3];
                    byteValue = ((Byte) objArr2[4]).byteValue();
                    long longValue = ((Long) objArr2[5]).longValue();
                    cp cpVar = (cp) objArr2[6];
                    boolean booleanValue = ((Boolean) objArr2[7]).booleanValue();
                    this.f2610b.put(new Long(longValue), cpVar);
                    int length = bArr3.length + 5;
                    if (shortValue == (short) 2585) {
                        length += 4;
                    }
                    byte[] bArr5 = new byte[length];
                    bArr5[0] = byteValue;
                    length = 1;
                    if (shortValue == (short) 2585) {
                        br.m2179a((int) longValue, bArr5, 1);
                        length = 5;
                    }
                    br.m2179a(bArr3.length, bArr5, length);
                    System.arraycopy(bArr3, 0, bArr5, length + 4, bArr3.length);
                    byte[] a = bo.m2175a(bArr5, this.f2619k != null ? this.f2619k : f2607l);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(a, 0, a.length);
                    if (bArr4 != null) {
                        byteArrayOutputStream.write(bArr4, 0, bArr4.length);
                    }
                    this.f2612d.m2207a(bo.m2174a((byte) 2, (byte) 34, shortValue, byteArrayOutputStream.toByteArray()), obj3);
                    if (!booleanValue) {
                        return;
                    }
                    if (shortValue == (short) 2581) {
                        if (cpVar != null) {
                            cpVar.mo243a(byteValue, longValue, (short) 200, null);
                            return;
                        }
                        return;
                    } else if (shortValue == (short) 2608 && cpVar != null) {
                        this.f2615g.removeElement(cpVar);
                        cpVar.mo248b();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                f2606a.mo322e("Unknown command");
                return;
        }
    }

    public final void mo240a(short s) {
        if (f2606a.mo317b()) {
            f2606a.mo316b("socketClosed, reason: " + s);
        }
        if (s == (short) 1 && this.f2622p) {
            this.f2616h.mo331c();
        }
        if (f2606a.mo317b()) {
            f2606a.mo316b("socketClosed() sessionListeners.size():" + this.f2615g.size());
        }
        for (int i = 0; i < this.f2615g.size(); i++) {
            ((cp) this.f2615g.elementAt(i)).mo246a(s);
        }
        if (!this.f2618j.isEmpty()) {
            this.f2618j.removeAllElements();
        }
        this.f2615g.removeAllElements();
        cj cjVar;
        ck ckVar;
        if (s == (short) 4 || s == (short) 5 || s == (short) 7) {
            cjVar = this.f2617i;
            ckVar = this.f2623q;
            cjVar.mo301a();
        } else if (s == (short) 8 && this.f2619k == null) {
            cjVar = this.f2617i;
            ckVar = this.f2623q;
            cjVar.mo301a();
        } else if (this.f2619k != null) {
            cjVar = this.f2617i;
            ckVar = this.f2623q;
            cjVar.mo303b();
        }
        this.f2619k = null;
    }

    public final void m2293a(short s, String str, byte[] bArr, byte[] bArr2, byte b, long j, cp cpVar, boolean z) {
        if (f2606a.mo317b()) {
            f2606a.mo316b("postBcpMessage, BCP: " + s + ", TID: " + b + ", RID: " + j);
        }
        Object obj = new Object[]{new Short(s), str, bArr, bArr2, new Byte(b), new Long(j), cpVar, new Boolean(z)};
        if (this.f2619k == null || !this.f2618j.isEmpty()) {
            this.f2618j.addElement(new C0416a((byte) 8, obj));
        } else {
            m2278a((byte) 8, obj);
        }
    }

    public final void m2294a(byte[] bArr, int i) {
        if (f2606a.mo317b()) {
            f2606a.mo316b("vapRecord, AID: " + i);
        }
        Object obj = new Object[]{bArr, new Integer(i)};
        if (this.f2619k == null || !this.f2618j.isEmpty()) {
            this.f2618j.addElement(new C0416a((byte) 6, obj));
        } else {
            m2278a((byte) 6, obj);
        }
    }

    public final void m2295b(int i) {
        if (f2606a.mo317b()) {
            f2606a.mo316b("vapRecordEnd, AID: " + i);
        }
        Object num = new Integer(i);
        if (this.f2619k == null || !this.f2618j.isEmpty()) {
            this.f2618j.addElement(new C0416a((byte) 7, num));
        } else {
            m2278a((byte) 7, num);
        }
    }

    public final void m2296b(cp cpVar) {
        this.f2615g.removeElement(cpVar);
    }

    public final void m2297c() {
        f2606a.mo316b((Object) "disconnectAndShutdown");
        m2278a((byte) 3, null);
    }

    public final byte[] m2298d() {
        return this.f2619k;
    }

    public final long m2299e() {
        long j = this.f2624r;
        this.f2624r = j + 1;
        if (this.f2624r == Long.MIN_VALUE) {
            this.f2624r = 1;
        }
        return j;
    }

    public final byte m2300f() {
        byte b = this.f2625s;
        this.f2625s = (byte) (b + 1);
        if (this.f2625s == Byte.MIN_VALUE) {
            this.f2625s = (byte) 1;
        }
        return b;
    }

    public final bh m2301g() {
        return this.f2620m;
    }
}
