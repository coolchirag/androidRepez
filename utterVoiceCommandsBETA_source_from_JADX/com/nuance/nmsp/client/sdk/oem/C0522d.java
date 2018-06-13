package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmdp.speechkit.bl;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class C0522d extends bl {
    protected final byte[] mo332a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return instance.doFinal(bArr2);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
