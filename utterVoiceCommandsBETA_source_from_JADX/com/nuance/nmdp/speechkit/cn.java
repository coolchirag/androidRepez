package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.cb.C0445a;
import java.util.Vector;

public class cn extends ca implements ch {
    private static final bj f2602b = C0478j.m2563a(cn.class);
    public String f2603a;
    private co f2604c;
    private Object f2605d;

    public cn(String str, short s, String str2, byte[] bArr, String str3, bh bhVar, bh bhVar2, Vector vector, cj cjVar) {
        super(str, s, str3, bhVar, bhVar2);
        if (str2 == null) {
            throw new IllegalArgumentException(" application id is null.");
        }
        this.f2603a = str2;
        if (bArr == null) {
            throw new IllegalArgumentException(" application key is null");
        }
        Vector vector2;
        if (vector == null || vector.size() == 0) {
            vector2 = new Vector();
        } else {
            vector2 = new Vector(vector.size());
            for (int i = 0; i < vector.size(); i++) {
                cb cbVar = (cb) vector.elementAt(i);
                if (cbVar.m2237d() == C0445a.f2559a && cbVar.m2234a().equals("DEVICE_CMD_LOG_TO_SERVER_ENABLED")) {
                    this.f2605d = new Vector();
                }
                vector2.addElement(cbVar);
            }
        }
        this.f2604c = new co(m2228b(), m2230c(), str2, bArr, str3, vector2, m2226a(), cjVar);
    }

    public final void b_() {
        f2602b.mo316b((Object) "shutdown");
        this.f2604c.m2297c();
    }

    public final co m2275h() {
        return this.f2604c;
    }

    public final Object m2276i() {
        return this.f2605d;
    }
}
