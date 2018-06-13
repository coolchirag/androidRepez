package com.nuance.nmdp.speechkit;

import java.util.Vector;

public interface bm {

    public interface C0418a {
        void mo221a();
    }

    public final class C0419b {
        public static final C0419b f2480a = new C0419b();

        private C0419b() {
        }
    }

    public final class C0420c {
        public static final C0420c f2481a = new C0420c();
        public static final C0420c f2482b = new C0420c();
        public static final C0420c f2483c = new C0420c();

        private C0420c() {
        }
    }

    public interface C0421d {
        void mo222a(C0420c c0420c, Object obj);
    }

    public interface C0422e {
        void mo224a(C0420c c0420c, Object obj, byte[] bArr, int i, int i2, Object obj2);
    }

    public interface C0423f {
        void mo223a(C0420c c0420c, Object obj, int i, int i2, Object obj2);
    }

    C0420c mo333a(Object obj, C0419b c0419b, byte[] bArr, int i, C0422e c0422e, Object obj2);

    C0420c mo334a(Object obj, byte[] bArr, int i, C0423f c0423f, Object obj2);

    void mo335a(Object obj);

    void mo336a(String str, int i, C0421d c0421d, C0418a c0418a);

    void mo337a(String str, int i, Vector vector, C0421d c0421d, C0418a c0418a);

    void mo338b(Object obj);
}
