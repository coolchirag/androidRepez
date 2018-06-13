package com.brandall.nutter;

import android.util.Base64;

public final class hm {
    public static String m1123a(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String m1124b(String str) {
        return new String(Base64.decode(str, 0));
    }
}
