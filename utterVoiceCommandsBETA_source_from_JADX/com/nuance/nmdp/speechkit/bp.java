package com.nuance.nmdp.speechkit;

public class bp {
    private static final bj f2485d = C0478j.m2563a(bp.class);
    public byte f2486a;
    public short f2487b;
    public int f2488c;
    private byte f2489e;

    public bp(byte b, byte b2, short s, int i) {
        if (f2485d.mo317b()) {
            f2485d.mo316b("Constructing XModeMsgHeader(protocol=" + b + ", version=" + b2 + ", cmd=" + s + ", len=" + i + ")");
        }
        this.f2486a = b;
        this.f2489e = b2;
        this.f2487b = s;
        this.f2488c = i;
    }

    public bp(byte[] bArr) {
        if (f2485d.mo317b()) {
            f2485d.mo316b((Object) "Constructing XModeMsgHeader(byte[])");
            f2485d.m2143a(bArr);
        }
        this.f2486a = bArr[0];
        this.f2489e = bArr[1];
        this.f2487b = br.m2178a(bArr, 2);
        this.f2488c = br.m2181b(bArr, 4);
    }

    public final byte[] m2176a() {
        if (f2485d.mo317b()) {
            f2485d.mo316b((Object) "XModeMsgHeader.getBytes()");
        }
        byte[] bArr = new byte[8];
        bArr[0] = this.f2486a;
        bArr[1] = this.f2489e;
        br.m2180a(this.f2487b, bArr, 2);
        br.m2179a(this.f2488c, bArr, 4);
        if (f2485d.mo317b()) {
            f2485d.mo313a((Object) "Generated: ");
            f2485d.m2143a(bArr);
        }
        return bArr;
    }
}
