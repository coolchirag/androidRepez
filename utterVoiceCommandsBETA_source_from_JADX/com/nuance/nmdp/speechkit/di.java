package com.nuance.nmdp.speechkit;

public class di extends da implements dp {
    private static final bj f2672a = C0478j.m2563a(di.class);

    public di(byte[] bArr) {
        super((short) 29185, bArr);
    }

    public final boolean m2401g() {
        try {
            if (m2379a("final_response")) {
                return mo261c("final_response") != 0;
            } else {
                if (!f2672a.mo319c()) {
                    return true;
                }
                f2672a.mo318c((Object) "final_response does not exist. ");
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
