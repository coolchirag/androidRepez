package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bi.C0378j;

public interface C0450do {

    public final class C0451a {
        private String f2700a;

        private C0451a(String str) {
            this.f2700a = str;
        }

        public final String toString() {
            return this.f2700a;
        }
    }

    static {
        C0451a c0451a = new C0451a("ABORT_END");
        c0451a = new C0451a("ABORT_BACK");
        c0451a = new C0451a("ABORT_NEW");
        c0451a = new C0451a("STOPPED_TOO_SOON");
        c0451a = new C0451a("PREEMPTED");
    }

    void mo278a();

    void mo279a(C0378j c0378j);
}
