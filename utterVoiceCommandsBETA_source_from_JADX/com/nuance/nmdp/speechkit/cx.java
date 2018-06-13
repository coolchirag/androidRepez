package com.nuance.nmdp.speechkit;

import java.util.Enumeration;
import java.util.Hashtable;

public class cx extends cv implements dp {
    private static final bj f2659a = C0478j.m2563a(cx.class);
    private Hashtable f2660b = new Hashtable();

    public cx() {
        super((short) 224);
    }

    public cx(byte[] bArr) {
        super((short) 224);
        if (bArr.length <= 0) {
            return;
        }
        if ((bArr[0] & 255) != 224) {
            f2659a.mo322e("PDXDictionary() Expected a dictionary. ");
            return;
        }
        int a = cv.m2348a(bArr, 1);
        byte[] bArr2 = new byte[a];
        System.arraycopy(bArr, bArr.length - a, bArr2, 0, bArr2.length);
        m2370b(bArr2);
    }

    public cx(byte[] bArr, byte b) {
        super((short) 224);
        m2370b(bArr);
    }

    private void m2370b(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            i = bArr[i] & 255;
            if (i == 22) {
                i = cv.m2348a(bArr, i2);
                i2 += cv.m2347a(i);
                Object obj = new byte[i];
                System.arraycopy(bArr, i2, obj, 0, obj.length);
                i += i2;
                String str = new String(obj);
                int i3 = i + 1;
                int i4 = bArr[i] & 255;
                i = cv.m2348a(bArr, i3);
                i3 += cv.m2347a(i);
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, i3, bArr2, 0, bArr2.length);
                i += i3;
                switch (i4) {
                    case 4:
                        this.f2660b.put(str, new cu(bArr2));
                        break;
                    case 5:
                        this.f2660b.put(str, new dc());
                        break;
                    case 16:
                        this.f2660b.put(str, new dk(bArr2));
                        break;
                    case 22:
                        this.f2660b.put(str, new cs(bArr2));
                        break;
                    case 192:
                        this.f2660b.put(str, new cz(bArr2));
                        break;
                    case 193:
                        this.f2660b.put(str, new dn(bArr2));
                        break;
                    case 224:
                        this.f2660b.put(str, new cx(bArr2, (byte) 0));
                        break;
                    default:
                        f2659a.mo322e("PDXDictionary.setContent() Unknown PDXClass type: " + i4 + ". ");
                        break;
                }
            }
            f2659a.mo322e("PDXDictionary.setContent() Expected an ASCII string but got " + i + ". ");
            return;
        }
    }

    public final Enumeration mo257a() {
        return this.f2660b.keys();
    }

    protected final void m2372a(String str, int i) {
        this.f2660b.put(str, new cz(i));
    }

    public final void m2373a(String str, dp dpVar) {
        if (str == null || dpVar == null) {
            throw new IllegalArgumentException("key or value is null.");
        } else if (((cv) dpVar).m2350c() != (short) 224) {
            f2659a.mo322e("PDXDictionary.addDictionary() value is not a valid dictionary.");
            throw new IllegalArgumentException("value is not a valid dictionary. ");
        } else {
            this.f2660b.put(str, dpVar);
        }
    }

    public final void m2374a(String str, dv dvVar) {
        if (str == null || dvVar == null) {
            throw new IllegalArgumentException("key or value is null.");
        } else if (((cv) dvVar).m2350c() != (short) 16) {
            f2659a.mo322e("PDXDictionary.addSequence() value is not a valid sequence.");
            throw new IllegalArgumentException("value is not a valid sequence. ");
        } else {
            this.f2660b.put(str, dvVar);
        }
    }

    public final void mo258a(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f2660b.put(str, new dn(str2));
    }

    protected final void m2376a(String str, String str2, short s) {
        switch (s) {
            case (short) 22:
                this.f2660b.put(str, new cs(str2));
                return;
            case (short) 193:
                this.f2660b.put(str, new dn(str2));
                return;
            default:
                return;
        }
    }

    public final void mo259a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f2660b.put(str, new cu(bArr));
    }

    protected final void m2378a(String str, byte[] bArr, short s) {
        switch (s) {
            case (short) 4:
                this.f2660b.put(str, new cu(bArr));
                return;
            case (short) 5:
                this.f2660b.put(str, new dc());
                return;
            case (short) 16:
                this.f2660b.put(str, new dk(bArr));
                return;
            case (short) 22:
                this.f2660b.put(str, new cs(bArr));
                return;
            case (short) 192:
                this.f2660b.put(str, new cz(bArr));
                return;
            case (short) 193:
                this.f2660b.put(str, new dn(bArr));
                return;
            case (short) 224:
                this.f2660b.put(str, new cx(bArr, (byte) 0));
                return;
            default:
                f2659a.mo322e("PDXDictionary.put() Unknown PDXClass type: " + s + ". ");
                return;
        }
    }

    public final boolean m2379a(String str) {
        if (str != null) {
            return this.f2660b.containsKey(str);
        }
        throw new NullPointerException("PDXDictionary.containsKey key is null");
    }

    protected final cv m2380b(String str) {
        return (cv) this.f2660b.get(str);
    }

    protected final String m2381b(int i) {
        String str = "";
        String str2 = "";
        int i2 = 0;
        String str3 = "";
        while (i2 < i - 1) {
            i2++;
            str3 = str3 + "    ";
        }
        String str4 = i > 0 ? str3 + "    " : str2;
        Enumeration keys = this.f2660b.keys();
        r3 = i != 0 ? str + "{ \n" : str;
        while (keys.hasMoreElements()) {
            str2 = (String) keys.nextElement();
            cv cvVar = (cv) this.f2660b.get(str2);
            switch (cvVar.m2350c()) {
                case (short) 4:
                    r3 = r3 + str4 + str2 + ": <BYTES> \"" + ((cu) cvVar).m2358a() + "\"\n";
                    continue;
                case (short) 5:
                    r3 = r3 + str4 + str2 + ": <NULL> \n";
                    continue;
                case (short) 16:
                    str2 = r3 + str4 + str2 + ": " + ((dk) cvVar).m2416d(i + 1) + "\n";
                    break;
                case (short) 22:
                    r3 = r3 + str4 + str2 + ": <ASCII> \"" + ((cs) cvVar).m2351a() + "\"\n";
                    continue;
                case (short) 192:
                    r3 = r3 + str4 + str2 + ": <INT> " + ((cz) cvVar).m2393a() + "\n";
                    continue;
                case (short) 193:
                    r3 = r3 + str4 + str2 + ": <UTF8> \"" + ((dn) cvVar).m2450a() + "\"\n";
                    continue;
                case (short) 224:
                    r3 = r3 + str4 + str2 + ": " + ((cx) cvVar).m2381b(i + 1) + "\n";
                    continue;
                default:
                    str2 = r3;
                    break;
            }
            r3 = str2;
        }
        return i != 0 ? r3 + str3 + "} " : r3;
    }

    public final void mo260b(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f2660b.put(str, new cz(i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] m2383b() {
        /*
        r6 = this;
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r0 = r6.f2660b;
        r2 = r0.keys();
    L_0x000b:
        r0 = r2.hasMoreElements();
        if (r0 == 0) goto L_0x009b;
    L_0x0011:
        r0 = r2.nextElement();
        r0 = (java.lang.String) r0;
        r3 = new com.nuance.nmdp.speechkit.cs;
        r3.<init>(r0);
        r3 = r3.m2352b();	 Catch:{ IOException -> 0x003d }
        r1.write(r3);	 Catch:{ IOException -> 0x003d }
        r3 = r6.f2660b;	 Catch:{ IOException -> 0x003d }
        r0 = r3.get(r0);	 Catch:{ IOException -> 0x003d }
        r0 = (com.nuance.nmdp.speechkit.cv) r0;	 Catch:{ IOException -> 0x003d }
        r3 = r0.m2350c();	 Catch:{ IOException -> 0x003d }
        switch(r3) {
            case 4: goto L_0x0033;
            case 5: goto L_0x007b;
            case 16: goto L_0x0090;
            case 22: goto L_0x0071;
            case 192: goto L_0x005d;
            case 193: goto L_0x0067;
            case 224: goto L_0x0085;
            default: goto L_0x0032;
        };	 Catch:{ IOException -> 0x003d }
    L_0x0032:
        goto L_0x000b;
    L_0x0033:
        r0 = (com.nuance.nmdp.speechkit.cu) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m2359b();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x003d:
        r0 = move-exception;
        r3 = f2659a;
        r4 = new java.lang.StringBuilder;
        r5 = "PDXDictionary.getContent() ";
        r4.<init>(r5);
        r0 = r0.toString();
        r0 = r4.append(r0);
        r4 = ". ";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.mo322e(r0);
        goto L_0x000b;
    L_0x005d:
        r0 = (com.nuance.nmdp.speechkit.cz) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m2394b();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x0067:
        r0 = (com.nuance.nmdp.speechkit.dn) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m2451b();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x0071:
        r0 = (com.nuance.nmdp.speechkit.cs) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m2352b();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x007b:
        r0 = (com.nuance.nmdp.speechkit.dc) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m2396a();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x0085:
        r0 = (com.nuance.nmdp.speechkit.cx) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.mo266d();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x0090:
        r0 = (com.nuance.nmdp.speechkit.dk) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m2414b();	 Catch:{ IOException -> 0x003d }
        r1.write(r0);	 Catch:{ IOException -> 0x003d }
        goto L_0x000b;
    L_0x009b:
        r0 = r1.toByteArray();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.cx.b():byte[]");
    }

    public final int mo261c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        cv cvVar = (cv) this.f2660b.get(str);
        if (cvVar == null) {
            if (f2659a.mo323e()) {
                f2659a.mo322e("PDXDictionary.getInteger() " + str + " does not exist. ");
            }
            throw new RuntimeException("key does not exist. ");
        } else if (cvVar.m2350c() == (short) 192) {
            return ((cz) cvVar).m2393a();
        } else {
            if (f2659a.mo323e()) {
                f2659a.mo322e("PDXDictionary.getInteger() " + str + " is not a PDXInteger. ");
            }
            throw new RuntimeException("key is of wrong type. ");
        }
    }

    public byte[] mo266d() {
        return super.m2349a(m2383b());
    }

    public final byte[] mo262d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        cv cvVar = (cv) this.f2660b.get(str);
        if (cvVar == null) {
            f2659a.mo322e("PDXDictionary.getByteString() " + str + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
        } else if (cvVar.m2350c() == (short) 4) {
            return ((cu) cvVar).m2358a();
        } else {
            f2659a.mo322e("PDXDictionary.getByteString() " + str + " is not a PDXByteString. ");
            throw new RuntimeException("key is of wrong type. ");
        }
    }

    public final String mo263e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        cv cvVar = (cv) this.f2660b.get(str);
        if (cvVar == null) {
            f2659a.mo322e("PDXDictionary.getUTF8String() " + str + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
        } else if (cvVar.m2350c() == (short) 193) {
            return ((dn) cvVar).m2450a();
        } else {
            f2659a.mo322e("PDXDictionary.getUTF8String() " + str + " is not a PDXUTF8String. ");
            throw new RuntimeException("key is of wrong type. ");
        }
    }

    public final String mo264f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        cv cvVar = (cv) this.f2660b.get(str);
        if (cvVar == null) {
            f2659a.mo322e("PDXDictionary.getAsciiString() " + str + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
        } else if (cvVar.m2350c() == (short) 22) {
            return ((cs) cvVar).m2351a();
        } else {
            f2659a.mo322e("PDXDictionary.getAsciiString() " + str + " is not a PDXAsciiString. ");
            throw new RuntimeException("key is of wrong type. ");
        }
    }

    public final dv mo265g(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        cv cvVar = (cv) this.f2660b.get(str);
        if (cvVar == null) {
            f2659a.mo322e("PDXDictionary.getSequence() " + str + " does not exist. ");
            throw new RuntimeException("key does not exist. ");
        } else if (cvVar.m2350c() == (short) 16) {
            return (dk) cvVar;
        } else {
            f2659a.mo322e("PDXDictionary.getSequence() " + str + " is not a PDXSequence. ");
            throw new RuntimeException("key is of wrong type. ");
        }
    }

    public final String toString() {
        return m2381b(0);
    }
}
