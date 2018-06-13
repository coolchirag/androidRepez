package com.nuance.nmdp.speechkit;

public class db {
    private static final bj f2667a = C0478j.m2563a(db.class);

    public static da m2395a(byte[] bArr) {
        short s = (short) (((bArr[1] & 255) << 8) + (bArr[0] & 255));
        Object obj = new byte[(bArr.length - 2)];
        System.arraycopy(bArr, 2, obj, 0, obj.length);
        switch (s) {
            case (short) 29185:
                return new di(obj);
            case (short) 29186:
                return new dg(obj);
            case (short) 29189:
                return new dj(obj);
            default:
                f2667a.mo322e("PDXMessageFactory.createMessage() Unknown command: " + s + ". ");
                return null;
        }
    }
}
