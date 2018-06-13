package com.brandall.nutter;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class kc {
    public static String m1283a(String str, String str2) {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), "RC4");
        Cipher instance = Cipher.getInstance("RC4");
        instance.init(1, secretKeySpec);
        byte[] doFinal = instance.doFinal(str.getBytes());
        if (hc.f1269b) {
            ls.m1344a("Encrypted RC4 prior to base64" + new String(doFinal));
        }
        String encodeToString = Base64.encodeToString(doFinal, 2);
        if (hc.f1269b) {
            ls.m1344a("Encrypted RC4 base64 encoded: " + encodeToString);
        }
        String str3 = new String(Base64.decode(encodeToString, 2));
        if (hc.f1269b) {
            ls.m1344a("Encrypted RC4 base64 decoded: " + str3);
        }
        instance.init(2, secretKeySpec, instance.getParameters());
        String str4 = new String(instance.doFinal(doFinal));
        if (hc.f1269b) {
            ls.m1344a("Decrypted RC4 " + str4);
        }
        return encodeToString;
    }
}
