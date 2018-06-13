package com.sun.p031a.p032a;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class C0530b {
    private static boolean f3031a;
    private static Logger f3032b = Logger.getLogger("javax.activation");
    private static final Level f3033c = Level.FINE;

    static {
        f3031a = false;
        try {
            f3031a = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable th) {
        }
    }

    public static void m2786a(String str) {
        if (f3031a) {
            System.out.println(str);
        }
        f3032b.log(f3033c, str);
    }

    public static void m2787a(String str, Throwable th) {
        if (f3031a) {
            System.out.println(new StringBuilder(String.valueOf(str)).append("; Exception: ").append(th).toString());
        }
        f3032b.log(f3033c, str, th);
    }

    public static boolean m2788a() {
        return f3031a || f3032b.isLoggable(f3033c);
    }
}
