package com.nuance.nmdp.speechkit;

public class dr {
    private static final bj f2701a = C0478j.m2563a(dr.class);

    private dr() {
    }

    public static dq m2452a(ch chVar, cm cmVar) {
        if (f2701a.mo317b()) {
            f2701a.mo316b((Object) "createNMASResource");
        }
        if (chVar == null) {
            f2701a.mo322e("manager is null");
            throw new NullPointerException("manager can not be null!");
        } else if (cmVar != null) {
            return new cr((cn) chVar, cmVar);
        } else {
            f2701a.mo322e("nmasListener is null");
            throw new NullPointerException("nmasListener can not be null!");
        }
    }
}
