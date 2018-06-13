package com.nuance.nmdp.speechkit;

public final class cb {
    private String f2569a;
    private Object f2570b;
    private C0445a f2571c;

    public final class C0445a extends bt {
        public static final C0445a f2559a = new C0445a((short) 0);
        public static final C0445a f2560b = new C0445a((short) 1);
        public static final C0445a f2561c = new C0445a((short) 2);
        public static final C0445a f2562d = new C0445a((short) 3);
        public static final C0445a f2563e = new C0445a((short) 4);
        public static final C0445a f2564f = new C0445a((short) 5);
        public static final C0445a f2565g = new C0445a((short) 6);
        public static final C0445a f2566h = new C0445a((short) 7);
        public static final C0445a f2567i = new C0445a((short) 8);
        public static final C0445a f2568j = new C0445a((short) 9);

        private C0445a(short s) {
            super(s);
        }

        public final String toString() {
            return m2120a(f2560b) ? "nmsp" : m2120a(f2561c) ? "app" : m2120a(f2562d) ? "nss" : m2120a(f2563e) ? "slog" : m2120a(f2564f) ? "nsslog" : m2120a(f2565g) ? "gwlog" : m2120a(f2566h) ? "svsp" : m2120a(f2567i) ? "sip" : m2120a(f2568j) ? "sdp" : m2120a(f2559a) ? "sdk" : null;
        }
    }

    public cb(String str, C0445a c0445a) {
        this.f2569a = str;
        this.f2570b = new byte[0];
        this.f2571c = c0445a;
    }

    public cb(String str, Object obj, C0445a c0445a) {
        this.f2569a = str;
        this.f2570b = obj;
        this.f2571c = c0445a;
    }

    public final String m2234a() {
        return this.f2569a;
    }

    public final byte[] m2235b() {
        return this.f2570b instanceof byte[] ? (byte[]) this.f2570b : "THIS IS NOT A STRING PARAMETER!!!".getBytes();
    }

    public final Object m2236c() {
        return this.f2570b;
    }

    public final /* synthetic */ Object clone() {
        Object obj = this.f2570b;
        if (this.f2570b instanceof byte[]) {
            byte[] bArr = (byte[]) this.f2570b;
            Object obj2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj2, 0, bArr.length);
            obj = obj2;
        }
        return new cb(this.f2569a, obj, this.f2571c);
    }

    public final C0445a m2237d() {
        return this.f2571c;
    }
}
