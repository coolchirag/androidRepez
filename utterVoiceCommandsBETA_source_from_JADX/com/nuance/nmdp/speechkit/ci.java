package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.cb.C0445a;
import java.util.Vector;

public class ci {
    private static final bj f2601a = C0478j.m2563a(ci.class);

    private ci() {
    }

    public static ch m2268a(String str, short s, String str2, byte[] bArr, String str3, bh bhVar, bh bhVar2, Vector vector, cj cjVar) {
        if (f2601a.mo317b()) {
            f2601a.mo316b((Object) "createManager");
        }
        if (str == null || str.length() == 0) {
            f2601a.mo322e("NullPointerException gatewayIP is NULL. ");
            throw new NullPointerException("gatewayIP must be provided!");
        } else if (s <= (short) 0) {
            f2601a.mo322e("IllegalArgumentException gatewayPort is invalid. ");
            throw new IllegalArgumentException("gatewayPort invalid value!");
        } else if (str2 == null) {
            f2601a.mo322e("NullPointerException applicationId is NULL. ");
            throw new NullPointerException("Application id can not be null!");
        } else if (bArr == null) {
            f2601a.mo322e("NullPointerException appKey is NULL. ");
            throw new NullPointerException("Application key can not be null!");
        } else if (str3 == null) {
            f2601a.mo322e("NullPointerException uid is NULL. ");
            throw new NullPointerException("uid can not be null!");
        } else if (bhVar == null) {
            f2601a.mo322e("NullPointerException inputCodec is NULL. ");
            throw new NullPointerException("inputCodec can not be null!");
        } else if (bhVar2 == null) {
            f2601a.mo322e("NullPointerException outputCodec is NULL. ");
            throw new NullPointerException("outputCodec can not be null!");
        } else if (cjVar == null) {
            f2601a.mo322e("NullPointerException managerListener is NULL. ");
            throw new NullPointerException("managerListener can not be null!");
        } else {
            if (vector != null) {
                for (int i = 0; i < vector.size(); i++) {
                    cb cbVar = (cb) vector.elementAt(i);
                    if (cbVar.m2237d() == C0445a.f2563e || cbVar.m2237d() == C0445a.f2564f || cbVar.m2237d() == C0445a.f2565g || cbVar.m2237d() == C0445a.f2566h || cbVar.m2237d() == C0445a.f2562d || cbVar.m2237d() == C0445a.f2567i || cbVar.m2237d() == C0445a.f2568j) {
                        f2601a.mo322e("IllegalArgumentException Parameter type: " + cbVar.m2237d() + " not allowed. ");
                        throw new IllegalArgumentException("Parameter type: " + cbVar.m2237d() + " not allowed. ");
                    }
                }
            }
            return new cn(str, s, str2, bArr, str3, bhVar, bhVar2, vector, cjVar);
        }
    }
}
