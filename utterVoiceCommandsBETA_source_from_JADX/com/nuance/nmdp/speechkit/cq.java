package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.cb.C0445a;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0509c;
import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class cq implements C0417b, ck, cp {
    private static final bj f2626g = C0478j.m2563a(cq.class);
    private static long f2627o = 1;
    protected co f2628a;
    public Vector f2629b;
    protected ch f2630c;
    protected int f2631d = 0;
    protected Object f2632e;
    protected byte f2633f = (byte) 0;
    private cm f2634h;
    private cp f2635i;
    private bh f2636j;
    private bh f2637k;
    private byte f2638l;
    private bk f2639m;
    private Hashtable f2640n;
    private long f2641p;
    private Hashtable f2642q;

    public cq(cn cnVar, cm cmVar) {
        this.f2630c = cnVar;
        this.f2628a = cnVar.m2275h();
        this.f2634h = cmVar;
        this.f2636j = cnVar.m2232e();
        this.f2637k = cnVar.m2233f();
        this.f2638l = (byte) 5;
        this.f2639m = cnVar.m2226a();
        this.f2632e = new Object();
        this.f2633f = this.f2628a.m2300f();
        this.f2640n = new Hashtable();
        this.f2642q = new Hashtable();
        this.f2641p = this.f2628a.m2299e();
        this.f2629b = new Vector();
    }

    private static C0445a mo253a(String str) {
        return str.equalsIgnoreCase("sdk") ? C0445a.f2559a : str.equalsIgnoreCase("nmsp") ? C0445a.f2560b : str.equalsIgnoreCase("app") ? C0445a.f2561c : str.equalsIgnoreCase("nss") ? C0445a.f2562d : str.equalsIgnoreCase("slog") ? C0445a.f2563e : str.equalsIgnoreCase("nsslog") ? C0445a.f2564f : str.equalsIgnoreCase("gwlog") ? C0445a.f2565g : str.equalsIgnoreCase("svsp") ? C0445a.f2566h : str.equalsIgnoreCase("sip") ? C0445a.f2567i : str.equalsIgnoreCase("sdp") ? C0445a.f2568j : null;
    }

    private void m2312a(Vector vector, long j) {
        if (this.f2631d != 2) {
            cm cmVar = this.f2634h;
        }
        byte[] bArr = new byte[0];
        this.f2640n.put(new Long(j), new Byte((byte) 2));
        this.f2642q.put(new Long(j), vector);
        String str = "<gp><rid>" + j + "</rid>";
        for (int i = 0; i < vector.size(); i++) {
            cb cbVar = (cb) vector.elementAt(i);
            if (cbVar.m2237d() == C0445a.f2561c || cbVar.m2237d() == C0445a.f2560b || cbVar.m2237d() == C0445a.f2562d || cbVar.m2237d() == C0445a.f2566h) {
                str = str + "<" + cbVar.m2237d() + " p=\"" + cbVar.m2234a() + "\"/>";
            }
        }
        long j2 = j;
        this.f2628a.m2293a((short) 2583, "SEND_BCP_GET_PARAMS", (str + "</gp>").getBytes(), bArr, this.f2633f, j2, this.f2635i, false);
    }

    public static long m2313f() {
        return 0;
    }

    public void mo241a() {
        f2626g.mo316b((Object) "freeResource, disconnect timeout: 0");
        synchronized (this.f2632e) {
            if (this.f2631d == 2) {
                this.f2631d = 0;
                Integer num = new Integer(0);
                bk bkVar = this.f2639m;
                C0416a c0416a = new C0416a((byte) 3, num);
                Thread currentThread = Thread.currentThread();
                this.f2639m.mo329a();
                bkVar.mo327a(c0416a, this, currentThread);
            } else {
                f2626g.mo322e("ResourceException the resource was unloaded. ");
                throw new cl("the resource was unloaded. ");
            }
        }
    }

    public final void mo242a(byte b, long j, short s, short s2, short s3) {
        f2626g.mo316b("onBcpResponse, TID: " + b + ", RID: " + j + ", status code: " + s + " , request state: " + s2 + ", completion cause: " + s3);
        if (s != (short) 200) {
            Byte b2 = (Byte) this.f2640n.get(new Long(j));
            if (b2 != null) {
                cm cmVar;
                switch (b2.byteValue()) {
                    case (byte) 1:
                        this.f2640n.remove(new Long(j));
                        cmVar = this.f2634h;
                        return;
                    case (byte) 2:
                        this.f2640n.remove(new Long(j));
                        cmVar = this.f2634h;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void mo243a(byte b, long j, short s, byte[] bArr) {
        f2626g.mo316b("onBcpSetParamsComplete, TID: " + b + ", RID: " + j + ", status code: " + s);
        if (this.f2640n.remove(new Long(j)) == null) {
            f2626g.mo320d("onBcpSetParamsComplete, RID: " + j + " already removed!");
            return;
        }
        Vector vector = new Vector();
        if (bArr != null) {
            String substring;
            String str = new String(bArr);
            int i = str.startsWith(";") ? 1 : 0;
            while (true) {
                int indexOf = str.indexOf(";", i);
                if (indexOf == -1) {
                    break;
                }
                substring = str.substring(i, indexOf);
                int indexOf2 = substring.indexOf(".");
                if (indexOf2 != -1) {
                    vector.addElement(new cb(substring.substring(indexOf2 + 1), mo253a(substring.substring(0, indexOf2))));
                }
                i = indexOf + 1;
            }
            if (i < str.length()) {
                substring = str.substring(i);
                int indexOf3 = substring.indexOf(".");
                if (indexOf3 != -1) {
                    vector.addElement(new cb(substring.substring(indexOf3 + 1), mo253a(substring.substring(0, indexOf3))));
                }
            }
        }
        cm cmVar;
        if (s == (short) 200 || s == (short) 201) {
            cmVar = this.f2634h;
        } else {
            cmVar = this.f2634h;
        }
    }

    public void mo244a(byte b, short s) {
        f2626g.mo316b("onBcpEvent, TID: " + b + ", event code: " + s);
        if (this.f2631d == 2) {
            cm cmVar;
            this.f2631d = 0;
            Enumeration keys = this.f2640n.keys();
            while (keys.hasMoreElements()) {
                switch (((Byte) this.f2640n.remove((Long) keys.nextElement())).byteValue()) {
                    case (byte) 1:
                        cmVar = this.f2634h;
                        break;
                    case (byte) 2:
                        cmVar = this.f2634h;
                        break;
                    default:
                        break;
                }
            }
            cmVar = this.f2634h;
            this.f2628a.m2296b((cp) this);
        }
    }

    public void mo245a(byte b, byte[] bArr) {
    }

    protected final void m2319a(cp cpVar) {
        f2626g.mo316b((Object) "loadResource");
        if (new C0509c(this.f2629b).m2665a()) {
            this.f2636j = bu.m2187c(this.f2636j);
            this.f2637k = bu.m2187c(this.f2637k);
            ((cn) this.f2630c).m2227a(this.f2636j);
            ((cn) this.f2630c).m2229b(this.f2637k);
        }
        this.f2635i = cpVar;
        this.f2628a.m2290a(cpVar);
        if (this.f2631d == 0) {
            if (this.f2628a.m2298d() != null) {
                this.f2631d = 2;
            } else {
                this.f2628a.m2287a(this.f2636j, this.f2637k);
                this.f2631d = 1;
            }
            long e = mo255e();
            String str = "<lr><rid>" + e + "</rid>";
            switch (this.f2638l) {
                case (byte) 1:
                    str = str + "<nr9><reco/></nr9>";
                    break;
                case (byte) 2:
                    str = str + "<nr9><tts/></nr9>";
                    break;
                case (byte) 3:
                    str = str + "<oper></oper>";
                    break;
                case (byte) 4:
                    str = (str + "<dict>") + "</dict>";
                    break;
                case (byte) 5:
                    return;
            }
            this.f2628a.m2293a((short) 2599, "SEND_BCP_LOAD_RESOURCE", (str + "</lr>").getBytes(), null, this.f2633f, e, cpVar, false);
        }
    }

    public void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        Object[] objArr;
        long longValue;
        cm cmVar;
        switch (c0416a.f2477a) {
            case (byte) 1:
                objArr = (Object[]) c0416a.f2478b;
                Vector vector = (Vector) objArr[0];
                longValue = ((Long) objArr[1]).longValue();
                if (this.f2631d != 2) {
                    cmVar = this.f2634h;
                    return;
                }
                boolean z = true;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4];
                this.f2640n.put(new Long(longValue), new Byte((byte) 1));
                int i = 1;
                String str = "<sp><rid>" + longValue + "</rid>";
                for (int i2 = 0; i2 < vector.size(); i2++) {
                    cb cbVar = (cb) vector.elementAt(i2);
                    if (cbVar.m2237d() == C0445a.f2561c || cbVar.m2237d() == C0445a.f2560b || cbVar.m2237d() == C0445a.f2562d) {
                        z = false;
                        str = str + "<" + cbVar.m2237d() + " p=\"" + cbVar.m2234a() + "\" v=\"" + bu.m2182a(new String(cbVar.m2235b())) + "\"/>";
                    } else {
                        if (cbVar.m2237d() == C0445a.f2566h) {
                            z = false;
                        }
                        StringBuilder append = new StringBuilder().append(str).append("<").append(cbVar.m2237d().toString()).append(" p=\"").append(cbVar.m2234a()).append("\" v=\"");
                        int i3 = i + 1;
                        str = append.append(i).append("\"/>").toString();
                        byte[] b = cbVar.m2235b();
                        br.m2179a(b.length, bArr, 0);
                        byteArrayOutputStream.write(bArr, 0, 4);
                        byteArrayOutputStream.write(b, 0, b.length);
                        i = i3;
                    }
                }
                this.f2628a.m2293a((short) 2581, "SEND_BCP_SET_PARAMS", (str + "</sp>").getBytes(), byteArrayOutputStream.toByteArray(), this.f2633f, longValue, this.f2635i, z);
                try {
                    byteArrayOutputStream.close();
                    return;
                } catch (Exception e) {
                    return;
                }
            case (byte) 2:
                objArr = (Object[]) c0416a.f2478b;
                m2312a((Vector) objArr[0], ((Long) objArr[1]).longValue());
                return;
            case (byte) 3:
                this.f2628a.m2284a(this.f2633f, ((Integer) c0416a.f2478b).intValue(), this.f2635i);
                cmVar = this.f2634h;
                return;
            case (byte) 4:
                int intValue = ((Integer) c0416a.f2478b).intValue();
                longValue = mo255e();
                this.f2628a.m2293a((short) 2608, "SEND_BCP_FREE_RESOURCE_ID", ((((((("<fr><rid>" + longValue + "</rid>") + "<n>1</n>") + "<resids>") + "<res1><id>" + this.f2641p + "</id>") + "<timeout>" + intValue + "<timeout></res1>") + "</resids>") + "</fr>").getBytes(), null, this.f2633f, longValue, this.f2635i, true);
                return;
            default:
                return;
        }
    }

    public void mo246a(short s) {
        if (f2626g.mo317b()) {
            f2626g.mo316b("onSessionDisconnected, reason code: " + s);
        }
        Enumeration keys = this.f2640n.keys();
        while (keys.hasMoreElements()) {
            cm cmVar;
            switch (((Byte) this.f2640n.remove((Long) keys.nextElement())).byteValue()) {
                case (byte) 1:
                    cmVar = this.f2634h;
                    break;
                case (byte) 2:
                    cmVar = this.f2634h;
                    break;
                default:
                    break;
            }
        }
        synchronized (this.f2632e) {
            if (this.f2631d == 2) {
                cmVar = this.f2634h;
            }
            this.f2631d = 0;
        }
    }

    public void mo247a(byte[] bArr) {
        if (f2626g.mo317b()) {
            f2626g.mo316b("onSessionConnected, SID: " + bArr);
        }
        synchronized (this.f2632e) {
            this.f2631d = 2;
        }
    }

    public final void mo248b() {
        cm cmVar = this.f2634h;
    }

    public final void mo249b(byte b, long j, short s, byte[] bArr) {
        int i = 0;
        f2626g.mo316b("onBcpGetParamsComplete, TID: " + b + ", RID: " + j);
        if (this.f2640n.remove(new Long(j)) == null) {
            f2626g.mo320d("onBcpGetParamsComplete, RID: " + j + " already removed!");
            this.f2642q.remove(new Long(j));
            return;
        }
        Vector vector = (Vector) this.f2642q.remove(new Long(j));
        if (vector == null) {
            f2626g.mo322e("Could not find the grammars associated with RID: " + j);
            return;
        }
        int i2;
        String str = new String(bArr);
        if (str.startsWith(";")) {
            i = 1;
            i2 = 0;
        } else {
            i2 = 0;
        }
        while (true) {
            int indexOf = str.indexOf(";", i);
            if (indexOf == -1) {
                break;
            }
            String substring = str.substring(i, indexOf);
            if (substring.indexOf(":") == -1) {
                cb cbVar = (cb) vector.elementAt(i2);
                vector.setElementAt(new cb(cbVar.m2234a(), substring.getBytes(), cbVar.m2237d()), i2);
            }
            i2++;
            i = indexOf + 1;
        }
        if (i < str.length()) {
            String substring2 = str.substring(i);
            if (substring2.indexOf(":") == -1) {
                cbVar = (cb) vector.elementAt(i2);
                vector.setElementAt(new cb(cbVar.m2234a(), substring2.getBytes(), cbVar.m2237d()), i2);
            }
        }
        cm cmVar;
        if (s == (short) 200 || s == (short) 201) {
            cmVar = this.f2634h;
        } else {
            cmVar = this.f2634h;
        }
    }

    public void mo250c() {
    }

    public final ch m2326d() {
        return this.f2630c;
    }

    protected synchronized long mo255e() {
        long j;
        j = f2627o;
        f2627o = 1 + j;
        if (f2627o == Long.MIN_VALUE) {
            f2627o = 1;
        }
        return j;
    }
}
