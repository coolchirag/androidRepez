package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public final class C0314y {
    private static C0314y f2310c = null;
    private final BigInteger f2311a = C0314y.m1882d();
    private BigInteger f2312b = BigInteger.ONE;

    private C0314y() {
    }

    public static synchronized C0314y m1881a() {
        C0314y c0314y;
        synchronized (C0314y.class) {
            if (f2310c == null) {
                f2310c = new C0314y();
            }
            c0314y = f2310c;
        }
        return c0314y;
    }

    private static BigInteger m1882d() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            UUID randomUUID = UUID.randomUUID();
            instance.update(BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray());
            instance.update(BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray());
            Object obj = new byte[9];
            obj[0] = (byte) 0;
            System.arraycopy(instance.digest(), 0, obj, 1, 8);
            return new BigInteger(obj);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot find MD5 message digest algorithm.");
        }
    }

    public final synchronized BigInteger m1883b() {
        return this.f2311a;
    }

    public final synchronized BigInteger m1884c() {
        BigInteger bigInteger;
        bigInteger = this.f2312b;
        this.f2312b = this.f2312b.add(BigInteger.ONE);
        return bigInteger;
    }
}
