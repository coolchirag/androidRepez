package com.google.ads.internal;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import org.ispeech.core.HttpRequestParams;

public final class C0265q {
    public String f2178a;
    public HashMap<String, String> f2179b;

    public C0265q(Bundle bundle) {
        this.f2178a = bundle.getString(HttpRequestParams.ACTION);
        Serializable serializable = bundle.getSerializable("params");
        this.f2179b = serializable instanceof HashMap ? (HashMap) serializable : null;
    }

    private C0265q(String str) {
        this.f2178a = str;
    }

    public C0265q(String str, HashMap<String, String> hashMap) {
        this(str);
        this.f2179b = hashMap;
    }
}
