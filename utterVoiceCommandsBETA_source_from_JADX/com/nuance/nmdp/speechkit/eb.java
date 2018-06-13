package com.nuance.nmdp.speechkit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class eb {
    public eb() {
        C0478j.m2563a(getClass());
    }

    public static Class<?> m2485a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("getClassForName failed", e);
        }
    }

    public static Object m2486a(Class<?> cls, String str) {
        try {
            return cls.getField(str).get(null);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("getFieldValue failed", e);
        }
    }

    public static Object m2487a(Class<?> cls, String str, Object obj) {
        try {
            obj = cls.getField(str).get(null);
        } catch (Exception e) {
        }
        return obj;
    }

    public static Constructor<?> m2488a(Class<?> cls, Class<?>... clsArr) {
        try {
            return cls.getConstructor(clsArr);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("getConstructor failed", e);
        }
    }

    public static Method m2489a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("getMethod failed", e);
        }
    }

    public static Method m2490b(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (Exception e) {
        }
        return method;
    }
}
