package com.nuance.nmdp.speechkit;

import java.util.Enumeration;
import java.util.Vector;

public class dk extends cv implements dv {
    private static final bj f2674a = C0478j.m2563a(dk.class);
    private Vector f2675b = new Vector();

    public dk() {
        super((short) 16);
    }

    public dk(byte[] bArr) {
        super((short) 16);
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            i = cv.m2348a(bArr, i2);
            i2 += cv.m2347a(i);
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
            i += i2;
            switch (i3) {
                case 4:
                    this.f2675b.addElement(new cu(bArr2));
                    break;
                case 5:
                    this.f2675b.addElement(new dc());
                    break;
                case 16:
                    this.f2675b.addElement(new dk(bArr2));
                    break;
                case 22:
                    this.f2675b.addElement(new cs(bArr2));
                    break;
                case 192:
                    this.f2675b.addElement(new cz(bArr2));
                    break;
                case 193:
                    this.f2675b.addElement(new dn(bArr2));
                    break;
                case 224:
                    this.f2675b.addElement(new cx(bArr2, (byte) 0));
                    break;
                default:
                    f2674a.mo322e("PDXSequence() Unknown PDXClass type: " + i3 + ". ");
                    break;
            }
        }
    }

    public final int mo275a() {
        return this.f2675b.size();
    }

    public final void m2412a(dp dpVar) {
        if (dpVar == null) {
            throw new IllegalArgumentException("value is null.");
        } else if (((cv) dpVar).m2350c() != (short) 224) {
            f2674a.mo322e("PDXSequence.addDictionary() value is not a valid dictionary.");
            throw new IllegalArgumentException("value is not a valid dictionary. ");
        } else {
            this.f2675b.addElement(dpVar);
        }
    }

    public final int mo276b(int i) {
        if (i >= this.f2675b.size()) {
            f2674a.mo322e("PDXSequence.getInteger() index " + i + " is out of range. ");
            throw new IndexOutOfBoundsException();
        }
        cv cvVar = (cv) this.f2675b.elementAt(i);
        if (cvVar.m2350c() == (short) 192) {
            return ((cz) cvVar).m2393a();
        }
        f2674a.mo322e("PDXSequence.getInteger() index " + i + " is not a PDXInteger. ");
        throw new RuntimeException("index is of wrong type.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] m2414b() {
        /*
        r6 = this;
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r0 = r6.f2675b;
        r2 = r0.elements();
    L_0x000b:
        r0 = r2.hasMoreElements();
        if (r0 == 0) goto L_0x0085;
    L_0x0011:
        r0 = r2.nextElement();
        r0 = (com.nuance.nmdp.speechkit.cv) r0;
        r3 = r0.m2350c();	 Catch:{ IOException -> 0x0029 }
        switch(r3) {
            case 4: goto L_0x001f;
            case 5: goto L_0x0067;
            case 16: goto L_0x007b;
            case 22: goto L_0x005d;
            case 192: goto L_0x0049;
            case 193: goto L_0x0053;
            case 224: goto L_0x0071;
            default: goto L_0x001e;
        };	 Catch:{ IOException -> 0x0029 }
    L_0x001e:
        goto L_0x000b;
    L_0x001f:
        r0 = (com.nuance.nmdp.speechkit.cu) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.m2359b();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x0029:
        r0 = move-exception;
        r3 = f2674a;
        r4 = new java.lang.StringBuilder;
        r5 = "PDXSequence.toByteArray() ";
        r4.<init>(r5);
        r0 = r0.toString();
        r0 = r4.append(r0);
        r4 = ". ";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.mo322e(r0);
        goto L_0x000b;
    L_0x0049:
        r0 = (com.nuance.nmdp.speechkit.cz) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.m2394b();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x0053:
        r0 = (com.nuance.nmdp.speechkit.dn) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.m2451b();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x005d:
        r0 = (com.nuance.nmdp.speechkit.cs) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.m2352b();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x0067:
        r0 = (com.nuance.nmdp.speechkit.dc) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.m2396a();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x0071:
        r0 = (com.nuance.nmdp.speechkit.cx) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.mo266d();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x007b:
        r0 = (com.nuance.nmdp.speechkit.dk) r0;	 Catch:{ IOException -> 0x0029 }
        r0 = r0.m2414b();	 Catch:{ IOException -> 0x0029 }
        r1.write(r0);	 Catch:{ IOException -> 0x0029 }
        goto L_0x000b;
    L_0x0085:
        r0 = r1.toByteArray();
        r0 = super.m2349a(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmdp.speechkit.dk.b():byte[]");
    }

    public final String mo277c(int i) {
        if (i >= this.f2675b.size()) {
            f2674a.mo322e("PDXSequence.getUTF8String() index " + i + " is out of range. ");
            throw new IndexOutOfBoundsException();
        }
        cv cvVar = (cv) this.f2675b.elementAt(i);
        if (cvVar.m2350c() == (short) 193) {
            return ((dn) cvVar).m2450a();
        }
        f2674a.mo322e("PDXSequence.getUTF8String() index " + i + " is not a PDXUTF8String. ");
        throw new RuntimeException("index is of wrong type.");
    }

    protected final String m2416d(int i) {
        String str = "";
        String str2 = "";
        int i2 = 0;
        String str3 = "";
        while (i2 < i - 1) {
            i2++;
            str3 = str3 + "    ";
        }
        String str4 = i > 0 ? str3 + "    " : str2;
        Enumeration elements = this.f2675b.elements();
        String str5 = str + "[ \n";
        while (elements.hasMoreElements()) {
            cv cvVar = (cv) elements.nextElement();
            switch (cvVar.m2350c()) {
                case (short) 4:
                    str5 = str5 + str4 + "<BYTES> \"" + ((cu) cvVar).m2358a() + "\" ";
                    break;
                case (short) 5:
                    str5 = str5 + str4 + "<NULL> ";
                    break;
                case (short) 16:
                    str5 = str5 + str4 + ((dk) cvVar).m2416d(i + 1);
                    break;
                case (short) 22:
                    str5 = str5 + str4 + "<ASCII> \"" + ((cs) cvVar).m2351a() + "\" ";
                    break;
                case (short) 192:
                    str5 = str5 + str4 + "<INT> " + ((cz) cvVar).m2393a();
                    break;
                case (short) 193:
                    str5 = str5 + str4 + "<UTF8> \"" + ((dn) cvVar).m2450a() + "\" ";
                    break;
                case (short) 224:
                    str5 = str5 + str4 + ((cx) cvVar).m2381b(i + 1);
                    break;
            }
            if (elements.hasMoreElements()) {
                str5 = str5 + ",";
            }
            str5 = str5 + "\n";
        }
        return str5 + str3 + "] ";
    }

    public final String toString() {
        return m2416d(0);
    }
}
